package com.kenshoo.kamazon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @GetMapping
    public String helloGradle() {
        return "Hello Gradle!";
    }
}
