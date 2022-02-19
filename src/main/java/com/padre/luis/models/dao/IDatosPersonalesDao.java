package com.padre.luis.models.dao;

import com.padre.luis.models.DatosPersonales;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatosPersonalesDao extends CrudRepository<DatosPersonales, String> {
    @Query("SELECT d.nombre, d.aPP, d.aPM FROM DatosPersonales as d \n" +
            "inner join Otros as o on d.ine = o.ine WHERE o.colores like %?1%")
    public List<String> findPersonColorLikeBLUE(String color);

    @Query("SELECT d.nombre, d.aPP, d.aPM FROM DatosPersonales as d \n" +
            "inner join Otros as o on d.ine = o.ine WHERE o.hobby like %?1% and o.hobby like %?2%")
    public List<String> findPersonHobbyLike2Hobby(String hobby1, String hobby2);

    @Query("SELECT d.nombre, d.aPP, d.aPM FROM DatosPersonales as d \n" +
            "inner join Otros as o on d.ine = o.ine WHERE o.colores  like %?1% ")
    public List<String> findPersonsParticularColor(String value);

    @Query("SELECT d.nombre, d.aPP, d.aPM FROM DatosPersonales as d WHERE d.estado like %?1%")
    public List<String> findPersonsParticularEstado(String value);

    @Query("SELECT d.nombre, d.aPP, o.hobby FROM DatosPersonales as d inner join Otros as o on d.ine = o.ine where o.ine=:value")
    public List<String> nombreAppHobby(String value);

}
