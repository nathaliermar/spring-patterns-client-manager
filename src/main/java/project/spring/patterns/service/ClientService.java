package project.spring.patterns.service;

import project.spring.patterns.model.Client;

/**
 * Interface that defines the <b>Strategy</b> pattern in the client domain.

 * Therefore, if necessary, we can have multiple implementations of the same interface.
 */

public interface ClientService {
    Iterable<Client> searchAll();

    Client searchById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
