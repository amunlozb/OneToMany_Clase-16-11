package com.onetomany.controller;

import com.onetomany.model.Autor;
import com.onetomany.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping()
    public String listarAutores(Model model) {
        List<Autor> autores = autorService.listarTodos();
        model.addAttribute("autores", autores);
        return "autores/lista";
    }
}
