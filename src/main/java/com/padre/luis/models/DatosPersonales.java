package com.padre.luis.models;

import org.springframework.orm.jpa.vendor.Database;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "datospersonales")
public class DatosPersonales implements Serializable {

    private static final long serialVersionUID = 4630915392537119327L;
    @Id
    @Column(name = "INE")
    private String ine;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "APP")
    private String aPP;
    @Column(name = "APM")
    private String aPM;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "Telefono")
    private long telefono;

//    @Transient
    @OneToOne
    @JoinColumn(name = "INE",referencedColumnName = "INE")
    private Otros otros;

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPP() {
        return aPP;
    }

    public void setaPP(String aPP) {
        this.aPP = aPP;
    }

    public String getaPM() {
        return aPM;
    }

    public void setaPM(String aPM) {
        this.aPM = aPM;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Otros getOtros() {
        return otros;
    }

    public void setOtros(Otros otros) {
        this.otros = otros;
    }

    public DatosPersonales(String ine, String nombre, String aPP, String aPM, String estado, long telefono, Otros otros) {
        this.ine = ine;
        this.nombre = nombre;
        this.aPP = aPP;
        this.aPM = aPM;
        this.estado = estado;
        this.telefono = telefono;
        this.otros = otros;
    }

    public DatosPersonales() {
        super();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosPersonales)) return false;

        DatosPersonales that = (DatosPersonales) o;

        if (getTelefono() != that.getTelefono()) return false;
        if (getIne() != null ? !getIne().equals(that.getIne()) : that.getIne() != null) return false;
        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        if (getaPP() != null ? !getaPP().equals(that.getaPP()) : that.getaPP() != null) return false;
        if (getaPM() != null ? !getaPM().equals(that.getaPM()) : that.getaPM() != null) return false;
        if (getEstado() != null ? !getEstado().equals(that.getEstado()) : that.getEstado() != null) return false;
        return getOtros() != null ? getOtros().equals(that.getOtros()) : that.getOtros() == null;
    }

    @Override
    public int hashCode() {
        int result = getIne() != null ? getIne().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getaPP() != null ? getaPP().hashCode() : 0);
        result = 31 * result + (getaPM() != null ? getaPM().hashCode() : 0);
        result = 31 * result + (getEstado() != null ? getEstado().hashCode() : 0);
        result = 31 * result + (int) (getTelefono() ^ (getTelefono() >>> 32));
        result = 31 * result + (getOtros() != null ? getOtros().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DatosPersonales{" +
                "ine='" + ine + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aPP='" + aPP + '\'' +
                ", aPM='" + aPM + '\'' +
                ", estado='" + estado + '\'' +
                ", telefono=" + telefono +
                ", otros=" + otros +
                '}';
    }
}
