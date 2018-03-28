package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * table SOCCONS_SOCIOS_DATPER
 */
@ApiModel(description = "table SOCCONS_SOCIOS_DATPER")
@Entity
@Table(name = "socio_dat_per")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SocioDatPer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "iden")
    private Integer iden;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "comuna")
    private String comuna;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "region")
    private Integer region;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIden() {
        return iden;
    }

    public SocioDatPer iden(Integer iden) {
        this.iden = iden;
        return this;
    }

    public void setIden(Integer iden) {
        this.iden = iden;
    }

    public String getProfesion() {
        return profesion;
    }

    public SocioDatPer profesion(String profesion) {
        this.profesion = profesion;
        return this;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public SocioDatPer direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public SocioDatPer comuna(String comuna) {
        this.comuna = comuna;
        return this;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public SocioDatPer ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getRegion() {
        return region;
    }

    public SocioDatPer region(Integer region) {
        this.region = region;
        return this;
    }

    public void setRegion(Integer region) {
        this.region = region;
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
        SocioDatPer socioDatPer = (SocioDatPer) o;
        if (socioDatPer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), socioDatPer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SocioDatPer{" +
            "id=" + getId() +
            ", iden=" + getIden() +
            ", profesion='" + getProfesion() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", comuna='" + getComuna() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", region=" + getRegion() +
            "}";
    }
}
