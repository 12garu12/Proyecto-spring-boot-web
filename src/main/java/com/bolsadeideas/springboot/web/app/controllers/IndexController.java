package com.bolsadeideas.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/app")
public class IndexController {

    /**
     * metodo de prueba
     * @param model se utiliza para pasar parametros a la vista con clave y valor.
     * @return
     */
    @GetMapping({"/index", "/", "/home", ""})
    public String index(Model model){
        model.addAttribute("titulo", "hola Spring Framework con Model!");
        return "index";
    }

}
