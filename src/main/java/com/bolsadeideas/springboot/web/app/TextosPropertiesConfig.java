package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Esta clase es para configuraciones
 * pasos
 * 1. En el archivo resources del proyecto crear un archivo nombreArchivo.properties.
 * 2. Crear la clase con la anotacion @Configuration y @PropertySources @PropertySource
 */
@Configuration
@PropertySources({ // Configuracion de varias application.properties van separadas por comas, permitiendonos tener varios archivos de application.properties.
        @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
}
