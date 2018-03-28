package io.github.jhipster.application.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Socio entity.
 */
public class SocioDTO implements Serializable {

    private Long id;

    private Integer rut;

    private String dv;

    private String nombre;

    private String extracto;

    private String aporte;

    private Float aportePorcen;

    private Integer estado;

    private Integer estadoEs;

    private Integer iden;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public String getAporte() {
        return aporte;
    }

    public void setAporte(String aporte) {
        this.aporte = aporte;
    }

    public Float getAportePorcen() {
        return aportePorcen;
    }

    public void setAportePorcen(Float aportePorcen) {
        this.aportePorcen = aportePorcen;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstadoEs() {
        return estadoEs;
    }

    public void setEstadoEs(Integer estadoEs) {
        this.estadoEs = estadoEs;
    }

    public Integer getIden() {
        return iden;
    }

    public void setIden(Integer iden) {
        this.iden = iden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SocioDTO socioDTO = (SocioDTO) o;
        if(socioDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), socioDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SocioDTO{" +
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
