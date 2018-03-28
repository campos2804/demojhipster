package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * table SOCCONS_TABLA_CONTROL
 */
@ApiModel(description = "table SOCCONS_TABLA_CONTROL")
@Entity
@Table(name = "socio_dat_per")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SocioDatPer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "corr_control")
    private Integer corrControl;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "extracto")
    private String extracto;

    @Column(name = "fecha_activa")
    private LocalDate fechaActiva;

    @Column(name = "fecha_termina")
    private LocalDate fechaTermina;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCorrControl() {
        return corrControl;
    }

    public SocioDatPer corrControl(Integer corrControl) {
        this.corrControl = corrControl;
        return this;
    }

    public void setCorrControl(Integer corrControl) {
        this.corrControl = corrControl;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public SocioDatPer usuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getExtracto() {
        return extracto;
    }

    public SocioDatPer extracto(String extracto) {
        this.extracto = extracto;
        return this;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public LocalDate getFechaActiva() {
        return fechaActiva;
    }

    public SocioDatPer fechaActiva(LocalDate fechaActiva) {
        this.fechaActiva = fechaActiva;
        return this;
    }

    public void setFechaActiva(LocalDate fechaActiva) {
        this.fechaActiva = fechaActiva;
    }

    public LocalDate getFechaTermina() {
        return fechaTermina;
    }

    public SocioDatPer fechaTermina(LocalDate fechaTermina) {
        this.fechaTermina = fechaTermina;
        return this;
    }

    public void setFechaTermina(LocalDate fechaTermina) {
        this.fechaTermina = fechaTermina;
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
            ", corrControl=" + getCorrControl() +
            ", usuarioId='" + getUsuarioId() + "'" +
            ", extracto='" + getExtracto() + "'" +
            ", fechaActiva='" + getFechaActiva() + "'" +
            ", fechaTermina='" + getFechaTermina() + "'" +
            "}";
    }
}
