package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Table SOCCONS_CARGA_SOCVIG
 */
@ApiModel(description = "Table SOCCONS_CARGA_SOCVIG")
@Entity
@Table(name = "carga_socvig")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CargaSocvig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rut")
    private Integer rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "nivel")
    private Integer nivel;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRut() {
        return rut;
    }

    public CargaSocvig rut(Integer rut) {
        this.rut = rut;
        return this;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public CargaSocvig dv(String dv) {
        this.dv = dv;
        return this;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public Integer getNivel() {
        return nivel;
    }

    public CargaSocvig nivel(Integer nivel) {
        this.nivel = nivel;
        return this;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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
        CargaSocvig cargaSocvig = (CargaSocvig) o;
        if (cargaSocvig.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cargaSocvig.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CargaSocvig{" +
            "id=" + getId() +
            ", rut=" + getRut() +
            ", dv='" + getDv() + "'" +
            ", nivel=" + getNivel() +
            "}";
    }
}
