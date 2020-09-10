package com.bolsadeideas.springboot.web.app.controllers;


import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
@RequestMapping("/app")
public class IndexController {

    /**
     * metodo que pasa al archivo index.html un titulo.
     * @param model se utiliza para pasar parametros a la vista con clave y valor.
     * @return un archivo index.html.
     */
    @GetMapping({"/index", "/", "/home", ""}) // Mapea la ruta desde una peticion http con el metodo GET
    public String index(Model model){
        model.addAttribute("titulo", "hola Spring Framework con Model!");
        return "index";
    }

    /**
     * Metodo que pasa al archivo perfil.html los valores de los atributos de un usuario.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return un archivo perfil.html.
     */
    @RequestMapping("/perfil") // Mapea la ruta desde una peticion http con el metodo GET por defecto.
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellido("Guzmán");
        usuario.setEmail("andres@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    /**
     * Metodo para una lista de usuarios y pasarlos a un archivo listar.html.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return un archivo listar.html.a
     */
    @RequestMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios") /* Se utiliza para pasar datos en comun y puede servirle a varios metodos handler del controlador y a varias vistas html. */
    public List<Usuario> listaUsuarios(){
        List<Usuario> usuarios = Arrays.asList( // Metodo asList() de la Clase Arrays
                new Usuario("Andres", "Guzmán", "andres@correo.com"),
                new Usuario("Jhon", "Doe", "jhon@correo.com"),
                new Usuario("Jane", "Doe", "jane@correo.com"),
                new Usuario("Tornado", "Roe", "tornado@correo.com")
        ); // Crea una lista de la clase Usuario.

        return usuarios;
    }


}
