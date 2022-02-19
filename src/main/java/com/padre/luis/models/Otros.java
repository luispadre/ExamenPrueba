package com.padre.luis.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Otro")
@Inheritance(strategy = InheritanceType.JOINED)
public class Otros implements Serializable {

    private static final long serialVersionUID = -7045546686855840385L;

    @Id
    @Column(name = "INE")
    private String ine;
    @Column(name = "Colores")
    private String colores;
    @Column(name = "Hobby")
    private String hobby;

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public  String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Otros(String ine, String colores, String hobby) {
        this.ine = ine;
        this.colores = colores;
        this.hobby = hobby;
    }

    public Otros() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Otros)) return false;
        Otros otros = (Otros) o;
        return Objects.equals(getIne(), otros.getIne()) && Objects.equals(getColores(), otros.getColores()) && Objects.equals(getHobby(), otros.getHobby());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIne(), getColores(), getHobby());
    }

    @Override
    public String toString() {
        return "Otros{" +
                "ine='" + ine + '\'' +
                ", colores='" + colores + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }


}

