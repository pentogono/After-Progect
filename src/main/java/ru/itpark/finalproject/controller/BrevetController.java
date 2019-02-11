package ru.itpark.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.finalproject.service.BrevetService;

@Controller
@RequestMapping("/main")
public class BrevetController {
    private  final BrevetService brevetService;

    public BrevetController(BrevetService brevetService) {
        this.brevetService = brevetService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("main", brevetService.findAll());
        return "main";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("brevet", brevetService.findById(id));
        return "brevet";
    }
}
