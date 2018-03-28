package io.github.jhipster.application.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CargaSocvig entity.
 */
public class CargaSocvigDTO implements Serializable {

    private Long id;

    private Integer rut;

    private String dv;

    private Integer nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CargaSocvigDTO cargaSocvigDTO = (CargaSocvigDTO) o;
        if(cargaSocvigDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cargaSocvigDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CargaSocvigDTO{" +
            "id=" + getId() +
            ", rut=" + getRut() +
            ", dv='" + getDv() + "'" +
            ", nivel=" + getNivel() +
            "}";
    }
}
