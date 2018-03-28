package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Table SOCCONS_CONTROL_CAMBIO_RAZON
 */
@ApiModel(description = "Table SOCCONS_CONTROL_CAMBIO_RAZON")
@Entity
@Table(name = "control_cambio_razon")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ControlCambioRazon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "cambio_extracto")
    private String cambioExtracto;

    @Column(name = "cambio_rut")
    private Integer cambioRut;

    @Column(name = "cambio_dv")
    private String cambioDv;

    @Column(name = "cambio_emp")
    private String cambioEmp;

    @Column(name = "cambio_fanta")
    private String cambioFanta;

    @Column(name = "cambioa_emp")
    private String cambioaEmp;

    @Column(name = "cambioa_fanta")
    private String cambioaFanta;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCambioExtracto() {
        return cambioExtracto;
    }

    public ControlCambioRazon cambioExtracto(String cambioExtracto) {
        this.cambioExtracto = cambioExtracto;
        return this;
    }

    public void setCambioExtracto(String cambioExtracto) {
        this.cambioExtracto = cambioExtracto;
    }

    public Integer getCambioRut() {
        return cambioRut;
    }

    public ControlCambioRazon cambioRut(Integer cambioRut) {
        this.cambioRut = cambioRut;
        return this;
    }

    public void setCambioRut(Integer cambioRut) {
        this.cambioRut = cambioRut;
    }

    public String getCambioDv() {
        return cambioDv;
    }

    public ControlCambioRazon cambioDv(String cambioDv) {
        this.cambioDv = cambioDv;
        return this;
    }

    public void setCambioDv(String cambioDv) {
        this.cambioDv = cambioDv;
    }

    public String getCambioEmp() {
        return cambioEmp;
    }

    public ControlCambioRazon cambioEmp(String cambioEmp) {
        this.cambioEmp = cambioEmp;
        return this;
    }

    public void setCambioEmp(String cambioEmp) {
        this.cambioEmp = cambioEmp;
    }

    public String getCambioFanta() {
        return cambioFanta;
    }

    public ControlCambioRazon cambioFanta(String cambioFanta) {
        this.cambioFanta = cambioFanta;
        return this;
    }

    public void setCambioFanta(String cambioFanta) {
        this.cambioFanta = cambioFanta;
    }

    public String getCambioaEmp() {
        return cambioaEmp;
    }

    public ControlCambioRazon cambioaEmp(String cambioaEmp) {
        this.cambioaEmp = cambioaEmp;
        return this;
    }

    public void setCambioaEmp(String cambioaEmp) {
        this.cambioaEmp = cambioaEmp;
    }

    public String getCambioaFanta() {
        return cambioaFanta;
    }

    public ControlCambioRazon cambioaFanta(String cambioaFanta) {
        this.cambioaFanta = cambioaFanta;
        return this;
    }

    public void setCambioaFanta(String cambioaFanta) {
        this.cambioaFanta = cambioaFanta;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ControlCambioRazon controlCambioRazon = (ControlCambioRazon) o;
        if (controlCambioRazon.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), controlCambioRazon.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ControlCambioRazon{" +
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
