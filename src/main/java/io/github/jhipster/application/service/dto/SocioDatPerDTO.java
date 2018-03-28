package io.github.jhipster.application.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SocioDatPer entity.
 */
public class SocioDatPerDTO implements Serializable {

    private Long id;

    private Integer corrControl;

    private String usuarioId;

    private String extracto;

    private LocalDate fechaActiva;

    private LocalDate fechaTermina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCorrControl() {
        return corrControl;
    }

    public void setCorrControl(Integer corrControl) {
        this.corrControl = corrControl;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public LocalDate getFechaActiva() {
        return fechaActiva;
    }

    public void setFechaActiva(LocalDate fechaActiva) {
        this.fechaActiva = fechaActiva;
    }

    public LocalDate getFechaTermina() {
        return fechaTermina;
    }

    public void setFechaTermina(LocalDate fechaTermina) {
        this.fechaTermina = fechaTermina;
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
            ", corrControl=" + getCorrControl() +
            ", usuarioId='" + getUsuarioId() + "'" +
            ", extracto='" + getExtracto() + "'" +
            ", fechaActiva='" + getFechaActiva() + "'" +
            ", fechaTermina='" + getFechaTermina() + "'" +
            "}";
    }
}
