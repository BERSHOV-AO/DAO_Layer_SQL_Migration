package ru.netology.daomigration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daomigration.repository.Repository;


import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @RequestMapping("/fetch-product")
    public List<String> fetchProduct(@RequestParam String name) {
        return repository.getProductName(name);
    }
}
