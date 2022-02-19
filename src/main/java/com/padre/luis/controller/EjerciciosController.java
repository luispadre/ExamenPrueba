package com.padre.luis.controller;

import com.padre.luis.models.DatosPersonales;
import com.padre.luis.services.EjerciciosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class EjerciciosController {

    @Autowired
    private EjerciciosServices ejerciciosServices;

    @GetMapping("/consultarPersonas")
    public List<DatosPersonales> consultarPersonas(){
        return  ejerciciosServices.consultarPersonas();
    }

    @GetMapping("/personasColorFavoritoAzul")
    public List<String> personasColorFavoritoAzul() {
       return  ejerciciosServices.personasColorFavoritoAzul("azul");
    }

    @GetMapping("/personasHobbyBasquetFutbol")
    public List<String> personasHobbyBasquetFutbol(){
        return ejerciciosServices.personasHobbyBasquetFutbol("basquetball","futbol");
    }

    @GetMapping(value = "/personasUnColorParticular/{color}")
    public List<String> personasUnColorParticular(@PathVariable String color){
        return ejerciciosServices.personasUnColorParticular(color);
    }

    @GetMapping("/personasParticularEstado/{estado}")
    public List<String> personasParticularEstado(@PathVariable String estado){
        return ejerciciosServices.personasParticularEstado(estado);
    }


    @GetMapping(value = "/nombreAppHobby/{id}")
    public List<String> nombreAppHobby(@PathVariable String id){
        return ejerciciosServices.nombreAppHobby(id);
    }

    @PostMapping(value = "/createPersona")
    public String createPersonas(@RequestBody DatosPersonales datosPersonales){
        ejerciciosServices.createPersonas(datosPersonales);
        return "Usuario Creado";
    }
    @PostMapping(value = "/updatePersonas")
    public String updatePersonas(@RequestBody DatosPersonales datosPersonales){
        if(datosPersonales.equals(new DatosPersonales())){
            return "Error tienes que ingresar todos los campos";
        }
        ejerciciosServices.updatePersonas(datosPersonales);
        return "Usuario Actualizado";
    }
    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable String id){
        ejerciciosServices.deleteById(id);
        return "Usuario Eliminado";
    }
}
