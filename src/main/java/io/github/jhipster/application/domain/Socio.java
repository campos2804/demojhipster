package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * table SOCCONS_SOCIOS
 */
@ApiModel(description = "table SOCCONS_SOCIOS")
@Entity
@Table(name = "socio")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rut")
    private Integer rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "extracto")
    private String extracto;

    @Column(name = "aporte")
    private String aporte;

    @Column(name = "aporte_porcen")
    private Float aportePorcen;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "estado_es")
    private Integer estadoEs;

    @Column(name = "iden")
    private Integer iden;

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

    public Socio rut(Integer rut) {
        this.rut = rut;
        return this;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public Socio dv(String dv) {
        this.dv = dv;
        return this;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public Socio nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtracto() {
        return extracto;
    }

    public Socio extracto(String extracto) {
        this.extracto = extracto;
        return this;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public String getAporte() {
        return aporte;
    }

    public Socio aporte(String aporte) {
        this.aporte = aporte;
        return this;
    }

    public void setAporte(String aporte) {
        this.aporte = aporte;
    }

    public Float getAportePorcen() {
        return aportePorcen;
    }

    public Socio aportePorcen(Float aportePorcen) {
        this.aportePorcen = aportePorcen;
        return this;
    }

    public void setAportePorcen(Float aportePorcen) {
        this.aportePorcen = aportePorcen;
    }

    public Integer getEstado() {
        return estado;
    }

    public Socio estado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstadoEs() {
        return estadoEs;
    }

    public Socio estadoEs(Integer estadoEs) {
        this.estadoEs = estadoEs;
        return this;
    }

    public void setEstadoEs(Integer estadoEs) {
        this.estadoEs = estadoEs;
    }

    public Integer getIden() {
        return iden;
    }

    public Socio iden(Integer iden) {
        this.iden = iden;
        return this;
    }

    public void setIden(Integer iden) {
        this.iden = iden;
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
        Socio socio = (Socio) o;
        if (socio.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), socio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Socio{" +
            "id=" + getId() +
            ", rut=" + getRut() +
            ", dv='" + getDv() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", extracto='" + getExtracto() + "'" +
            ", aporte='" + getAporte() + "'" +
            ", aportePorcen=" + getAportePorcen() +
            ", estado=" + getEstado() +
            ", estadoEs=" + getEstadoEs() +
            ", iden=" + getIden() +
            "}";
    }
}
