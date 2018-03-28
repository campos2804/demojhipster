package io.github.jhipster.application.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SocioDatPer entity.
 */
public class SocioDatPerDTO implements Serializable {

    private Long id;

    private Integer iden;

    private String profesion;

    private String direccion;

    private String comuna;

    private String ciudad;

    private Integer region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIden() {
        return iden;
    }

    public void setIden(Integer iden) {
        this.iden = iden;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SocioDatPerDTO socioDatPerDTO = (SocioDatPerDTO) o;
        if(socioDatPerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), socioDatPerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SocioDatPerDTO{" +
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
