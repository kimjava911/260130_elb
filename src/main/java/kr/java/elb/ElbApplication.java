package kr.java.elb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElbApplication.class, args);
    }

    @Value("${app.name}")
    private String appName;

    @GetMapping
    public String index() {
        return appName;
    }
}
