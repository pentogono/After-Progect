package ru.itpark.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/search", params = "name")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("name", name); // чтобы отображать в поле поиска
        model.addAttribute("brevet", brevetService.findByName(name));
        return "main";
    }

    @PostMapping(value = "/search", params = "name")
    public  String search(@RequestParam String name) {
        brevetService.findByName(name);
        return "main";
    }

    @RequestMapping("/page-results")
    public String pageResults() {
        return "page-results";
    }

//    @RequestMapping(value = "/page-results", method = RequestMethod.GET)
//    public String pageResult (Model model) {
//        model.addAttribute("r2017randonneur", brevetService.listAll());
//        return "page-results";
//    }



}
