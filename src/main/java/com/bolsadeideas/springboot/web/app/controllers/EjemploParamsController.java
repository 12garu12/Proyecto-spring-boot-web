package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    /**
     * Metodo para retornar una vista html.
     * @return una vista llamada index.html que se encuentra en el folder params.
     */
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

    /**
     * Metodo para recibir varios parametros por medio de la URL.
     * @param saludo parametro que llega por medio de la URL.
     * @param numero parametro que llega por medio de la URL.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return un archivo html llamado ver.html.
     */
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado", "El saludo enviado es: '" +
                saludo + "' y el numero es: '" + numero + "'");
        return "params/ver";

    }

    /**
     * Metodo para recibir varios parametros por medio de la URL.
     * @param request trae los parametros al metodo.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return un archivo html llamado ver.html.
     */
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){ // la interface HttpServletRequest trae los parametros en un array y el metodo getParameter() lo obtinen.
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero")) ;
        } catch (NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado", "El saludo enviado es: '" +
                saludo + "' y el numero es: '" + numero + "'");
        return "params/ver";
    }



}

