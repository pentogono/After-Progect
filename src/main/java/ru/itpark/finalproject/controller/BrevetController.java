package ru.itpark.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class BrevetController {

    @GetMapping
    public String getAll() {
        return "main";
    }
}
