package com.github.jianlu8023.example.dockerdeploy;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class DockerDeploymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerDeploymentApplication.class, args);
    }
}
