package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    /**
     * Metodo para la vista principal index.html con las rutas de los metodos del controlador.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return vista html llamada ver.html
     */
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
        return "variables/index";
    }

    /**
     * Metodo para recibir un parametro via URL y pasarlos a la vista ver.html.
     * @param texto pasado por la URL.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return una vista llamada ver.html el cual esta en el directorio variables.
     */
    @GetMapping("/string/{texto}")/*Importante que el nombre en la ruta sea igual al de el parametro*/
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
        return "variables/ver";
    }

    /**
     * Metodo para recibir varios parametros via URL y pasarlos a la vista ver.html.
     * @param texto pasado por la URL.
     * @param numero pasado por la URL.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return una vista llamada ver.html.
     */
    @GetMapping("/string/{texto}/{numero}")/*Importante que el nombre en la ruta sea igual al de el parametro*/
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto +
                " y el numero enviado en el path es: " + numero);
        return "variables/ver";
    }

}
