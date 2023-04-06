package br.com.acrtech.hellodevops;

import br.com.acrtech.hellodevops.model.UsuarioDto;
import br.com.acrtech.hellodevops.service.HelloService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController @RequestMapping("/hello")
public class HelloDevOpsApplication {

    private static final Logger log = LoggerFactory.getLogger(HelloDevOpsApplication.class);
    private final ObservationRegistry registry;
    private final HelloService helloService;

    public HelloDevOpsApplication(ObservationRegistry registry, HelloService helloService) {
        this.registry = registry;
        this.helloService = helloService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloDevOpsApplication.class, args);
    }

    @PostMapping
    public String hello(@RequestBody UsuarioDto dto){
        log.info("Hello got a request from {}", dto.getNome());
        Observation observation = Observation.createNotStarted("hellodevops.server", registry)
                .lowCardinalityKeyValue("userType", dto.getSexo().name())
                .highCardinalityKeyValue("userId", dto.getCpf())
                .contextualName("span-hello-user")
                .start();
        String hello = helloService.hello(dto);
        observation.stop();
        return hello;
    }

}
