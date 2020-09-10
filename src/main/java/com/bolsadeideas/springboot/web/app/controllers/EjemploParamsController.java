package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "/params/index";
    }

    /**
     * Metodo parqa demostrar el recibir parámetros del Request HTTP GEt - URL.
     * el parametro en la url se escribe de la siguiente forma, primero los endpoints despues
     * un signo de pregunta, el nombre del parametro con el argumento.
     * http://localhost:8080/params/string?texto=Hola que tal
     * @param texto parametro recibido de la URL por medio de la anotacion @RequestParam
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return la vista o archivo que esta en la carpeta params llamado ver.html.
     */
    @GetMapping("/string")
    public String param(@RequestParam (required = false, defaultValue = "algun valor") String texto, Model model){ // el @RequestParam (required = false) si no se envia el parametro no dara un error en el servidor.
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }


}

