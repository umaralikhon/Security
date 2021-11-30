package com.example.security.controller;

import com.example.security.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1{

    private List<Developer> developers = Stream.of(
            new Developer(1L,"Alisa", "Yandex"),
            new Developer(2L, "Siri", "Apple" ),
            new Developer(3L, "Alexa", "Amazon")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return developers.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer){
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        developers.removeIf(developer -> developer.getId().equals(id));
    }
}
