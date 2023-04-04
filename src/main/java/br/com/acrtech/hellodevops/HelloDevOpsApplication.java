package br.com.acrtech.hellodevops;

import br.com.acrtech.hellodevops.service.HelloService;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController @RequestMapping("/hello")
public class HelloDevOpsApplication {

    private static final Logger log = LoggerFactory.getLogger(HelloDevOpsApplication.class);
    private final HelloService helloService;

    public HelloDevOpsApplication(HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloDevOpsApplication.class, args);
    }

    @GetMapping
    public String hello(){
        log.info("Hello got a request");
        return helloService.hello();
    }

}
