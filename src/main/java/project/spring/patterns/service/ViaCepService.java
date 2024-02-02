package project.spring.patterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import project.spring.patterns.model.Address;

/**
 * Client HTTP, made via <b>OpenFeign</b>,
 * for API consume of <b>VIaCEP</b>
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign"> Spring Cloud OpenFeign </a>
 * @see <a href="https://viacep.com.br"> ViaCEP </a>
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);
}
