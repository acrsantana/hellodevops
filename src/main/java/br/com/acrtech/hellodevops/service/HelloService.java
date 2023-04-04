package br.com.acrtech.hellodevops.service;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloService.class);
    @Observed(name = "user.name",
            contextualName = "getting-user-name",
            lowCardinalityKeyValues = {"userType", "userType2"})
    public String hello() {
        log.info("Getting Hello message from service");
        return "Hello DevOps";
    }
}
