package io.github.jhipster.application.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ControlCambioRazon entity.
 */
public class ControlCambioRazonDTO implements Serializable {

    private Long id;

    private String cambioExtracto;

    private Integer cambioRut;

    private String cambioDv;

    private String cambioEmp;

    private String cambioFanta;

    private String cambioaEmp;

    private String cambioaFanta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCambioExtracto() {
        return cambioExtracto;
    }

    public void setCambioExtracto(String cambioExtracto) {
        this.cambioExtracto = cambioExtracto;
    }

    public Integer getCambioRut() {
        return cambioRut;
    }

    public void setCambioRut(Integer cambioRut) {
        this.cambioRut = cambioRut;
    }

    public String getCambioDv() {
        return cambioDv;
    }

    public void setCambioDv(String cambioDv) {
        this.cambioDv = cambioDv;
    }

    public String getCambioEmp() {
        return cambioEmp;
    }

    public void setCambioEmp(String cambioEmp) {
        this.cambioEmp = cambioEmp;
    }

    public String getCambioFanta() {
        return cambioFanta;
    }

    public void setCambioFanta(String cambioFanta) {
        this.cambioFanta = cambioFanta;
    }

    public String getCambioaEmp() {
        return cambioaEmp;
    }

    public void setCambioaEmp(String cambioaEmp) {
        this.cambioaEmp = cambioaEmp;
    }

    public String getCambioaFanta() {
        return cambioaFanta;
    }

    public void setCambioaFanta(String cambioaFanta) {
        this.cambioaFanta = cambioaFanta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ControlCambioRazonDTO controlCambioRazonDTO = (ControlCambioRazonDTO) o;
        if(controlCambioRazonDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), controlCambioRazonDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ControlCambioRazonDTO{" +
            "id=" + getId() +
            ", cambioExtracto='" + getCambioExtracto() + "'" +
            ", cambioRut=" + getCambioRut() +
            ", cambioDv='" + getCambioDv() + "'" +
            ", cambioEmp='" + getCambioEmp() + "'" +
            ", cambioFanta='" + getCambioFanta() + "'" +
            ", cambioaEmp='" + getCambioaEmp() + "'" +
            ", cambioaFanta='" + getCambioaFanta() + "'" +
            "}";
    }
}
