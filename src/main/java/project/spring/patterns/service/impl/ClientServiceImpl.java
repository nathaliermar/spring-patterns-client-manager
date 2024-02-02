package project.spring.patterns.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.patterns.model.Address;
import project.spring.patterns.model.AddressRepository;
import project.spring.patterns.model.Client;
import project.spring.patterns.model.ClientRepository;
import project.spring.patterns.service.ClientService;
import project.spring.patterns.service.ViaCepService;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    //SINGLETON: Inject Spring components with @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    //STRATEGY: Implement the methods defined in the interface.
    //FACADE: Abstract integrations with subsystems, providing a simple interface.

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }
    @Override
    public Client searchById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }
    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        //Search Client by ID, if any:
        Optional<Client> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()) {
            saveClientWithCep(client);
        }
    }
    @Override
    public void delete(Long id) {
        //Delete Client by ID.
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        //Checks if the Client's Address already exists (by CEP).
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            //If it doesn't exist, integrate with ViaCEP and persist the return.
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        //Change Client, linking Address (new or existing).
        clientRepository.save(client);
    }
}


