package com.bolsadeideas.springboot.web.app.controllers;


import com.bolsadeideas.springboot.web.app.models.Usuario;
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

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellido("Guzmán");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

}
