package com.padre.luis.services;

import com.padre.luis.models.DatosPersonales;
import com.padre.luis.models.Otros;
import com.padre.luis.models.dao.IDatosPersonalesDao;
import com.padre.luis.models.dao.IOtrosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EjerciciosServices {

    @Autowired
    private IDatosPersonalesDao datosPersonalesDao;

    @Autowired
    private IOtrosDao otroDao;


    public void createPersonas(DatosPersonales datosPersonales) {
        datosPersonales.getOtros().setIne(datosPersonales.getIne());
        DatosPersonales datosPersonaless=new DatosPersonales();
        datosPersonaless.setIne(datosPersonales.getIne());
        datosPersonaless.setNombre(datosPersonales.getNombre());
        datosPersonaless.setaPP(datosPersonales.getaPP());
        datosPersonaless.setaPM(datosPersonales.getaPM());
        datosPersonaless.setEstado(datosPersonales.getEstado());
        datosPersonaless.setTelefono(datosPersonales.getTelefono());
        datosPersonalesDao.save(datosPersonaless);
        Otros otros= datosPersonales.getOtros();
        otroDao.save(otros);
    }

    public List<DatosPersonales> consultarPersonas() {
        return (List<DatosPersonales>) datosPersonalesDao.findAll();
    }

    public void deleteById(String id){
        otroDao.deleteById(id);
        datosPersonalesDao.deleteById(id);
    }

    public List<String> personasColorFavoritoAzul(String color) {
        return datosPersonalesDao.findPersonColorLikeBLUE(color).stream().map((e -> e.replace(",", " "))).collect(Collectors.toList());
    }

    public List<String> personasHobbyBasquetFutbol(String hobby1, String hobby2) {
        System.out.println(hobby1 + hobby2);
        return datosPersonalesDao.findPersonHobbyLike2Hobby(hobby1, hobby2).stream().map((e -> e.replace(",", " "))).collect(Collectors.toList());
    }

    public List<String> personasUnColorParticular(String color) {
        return datosPersonalesDao.findPersonsParticularColor(color).stream().map((e -> e.replace(",", " "))).collect(Collectors.toList());
    }

    public List<String> personasParticularEstado(String estado) {
        return datosPersonalesDao.findPersonsParticularEstado(estado).stream().map((e -> e.replace(",", " "))).collect(Collectors.toList());
    }

    public List<String> nombreAppHobby(String id) {
        return datosPersonalesDao.nombreAppHobby(id);
    }


    public void updatePersonas(DatosPersonales datosPersonales) {

        DatosPersonales persona = datosPersonalesDao.findById(datosPersonales.getIne()).orElse(null);

        if(persona.equals(new DatosPersonales())){
            return;

        }
        if (!datosPersonales.getaPP().toLowerCase().trim().equals("") || datosPersonales.getaPP().toLowerCase().trim() != persona.getaPP().toLowerCase().trim()) {
            persona.setaPP(datosPersonales.getaPP());
        }
        if (!datosPersonales.getaPM().toLowerCase().trim().equals("") || datosPersonales.getaPM().toLowerCase().trim() != persona.getaPM().toLowerCase().trim()) {
            persona.setaPM(datosPersonales.getaPM());
        }
        if (!datosPersonales.getEstado().toLowerCase().trim().equals("") || datosPersonales.getEstado().toLowerCase().trim() != persona.getEstado().toLowerCase().trim()) {
            persona.setEstado(datosPersonales.getEstado());
        }

        if (!datosPersonales.getNombre().toLowerCase().trim().equals("") || datosPersonales.getNombre().toLowerCase().trim() != persona.getNombre().toLowerCase().trim()) {
            persona.setNombre(datosPersonales.getNombre());
        }
        if (datosPersonales.getTelefono() != 0 && datosPersonales.getTelefono() != persona.getTelefono()) {
            persona.setTelefono(datosPersonales.getTelefono());
        }
        if (datosPersonales.getOtros() != persona.getOtros() || new Otros().equals(datosPersonales.getOtros())) {
            datosPersonales.getOtros().setIne(persona.getIne());
            persona.setOtros(datosPersonales.getOtros());
        }
        datosPersonalesDao.save(persona);
        otroDao.save(persona.getOtros());
    }
}
