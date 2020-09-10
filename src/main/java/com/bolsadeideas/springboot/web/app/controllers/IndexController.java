package com.bolsadeideas.springboot.web.app.controllers;


import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping({"/index", "/", "/home", ""})
    public String index(Model model){
        model.addAttribute("titulo", "hola Spring Framework con Model!");
        return "index";
    }

    /**
     * Metodo que pasa al archivo perfil.html los valores de los atributos de un usuario.
     * @param model utiliza los metodos de la interfaz Model para pasar datos clave valor.
     * @return un archivo perfil.html.
     */
    @RequestMapping("/perfil")
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
        List<Usuario> usuarios = new ArrayList<>();

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }


}
