package com.bolsadeideas.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Metodo para redirigir la ruta a otro controlador utilizando redirect.
     * @return retorna el archivo de la ruta especificada.
     */
    @GetMapping("/")
    public String home(){
        return "redirect:/app/index"; // Redirige la ruta al controlador con esa ruta especificada y reinicia la peticion HTTP.
/*      return "forward:/app/index"  --> Otra forma de redigir pero esta no cambia la ruta url
*       es mas recomendable y es para rutas propias internas del proyecto,  realizando por debajo
*       un RequestDispatcher.forward*/
    }
}
