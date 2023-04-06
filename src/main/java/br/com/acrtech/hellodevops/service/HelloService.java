package br.com.acrtech.hellodevops.service;

import br.com.acrtech.hellodevops.model.UsuarioDto;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloService.class);

    public String hello(UsuarioDto dto) {
        log.info("Getting Hello message from service");
        return "Hello " + dto.getNome();
    }
}
