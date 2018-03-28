package io.github.jhipster.application.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * table SOCCONS_SOCIEDAD_CONSTITUCION
 */
@ApiModel(description = "table SOCCONS_SOCIEDAD_CONSTITUCION")
@Entity
@Table(name = "constitucion")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Constitucion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rut")
    private Integer rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "extracto")
    private String extracto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecpub")
    private String fecpub;

    @Column(name = "nomfan")
    private String nomfan;

    @Column(name = "feconst")
    private String feconst;

    @Column(name = "tipconst")
    private String tipconst;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "fecterm")
    private String fecterm;

    @Column(name = "cappag")
    private String cappag;

    @Column(name = "capsus")
    private String capsus;

    @Column(name = "nacciones")
    private String nacciones;

    @Column(name = "notariorut")
    private Integer notariorut;

    @Column(name = "notariodv")
    private String notariodv;

    @Column(name = "directorrut")
    private Integer directorrut;

    @Column(name = "directordv")
    private String directordv;

    @Column(name = "reprut")
    private Integer reprut;

    @Column(name = "repdv")
    private String repdv;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "extnomdup")
    private Integer extnomdup;

    @Column(name = "extnomduprut")
    private Integer extnomduprut;

    @Column(name = "extnomdupdv")
    private String extnomdupdv;

    @Column(name = "grupo")
    private Integer grupo;

    @Column(name = "fecact")
    private LocalDate fecact;

    @Column(name = "fecactnom")
    private LocalDate fecactnom;

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

    public Constitucion rut(Integer rut) {
        this.rut = rut;
        return this;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public Constitucion dv(String dv) {
        this.dv = dv;
        return this;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getExtracto() {
        return extracto;
    }

    public Constitucion extracto(String extracto) {
        this.extracto = extracto;
        return this;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public String getNombre() {
        return nombre;
    }

    public Constitucion nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecpub() {
        return fecpub;
    }

    public Constitucion fecpub(String fecpub) {
        this.fecpub = fecpub;
        return this;
    }

    public void setFecpub(String fecpub) {
        this.fecpub = fecpub;
    }

    public String getNomfan() {
        return nomfan;
    }

    public Constitucion nomfan(String nomfan) {
        this.nomfan = nomfan;
        return this;
    }

    public void setNomfan(String nomfan) {
        this.nomfan = nomfan;
    }

    public String getFeconst() {
        return feconst;
    }

    public Constitucion feconst(String feconst) {
        this.feconst = feconst;
        return this;
    }

    public void setFeconst(String feconst) {
        this.feconst = feconst;
    }

    public String getTipconst() {
        return tipconst;
    }

    public Constitucion tipconst(String tipconst) {
        this.tipconst = tipconst;
        return this;
    }

    public void setTipconst(String tipconst) {
        this.tipconst = tipconst;
    }

    public String getDuracion() {
        return duracion;
    }

    public Constitucion duracion(String duracion) {
        this.duracion = duracion;
        return this;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecterm() {
        return fecterm;
    }

    public Constitucion fecterm(String fecterm) {
        this.fecterm = fecterm;
        return this;
    }

    public void setFecterm(String fecterm) {
        this.fecterm = fecterm;
    }

    public String getCappag() {
        return cappag;
    }

    public Constitucion cappag(String cappag) {
        this.cappag = cappag;
        return this;
    }

    public void setCappag(String cappag) {
        this.cappag = cappag;
    }

    public String getCapsus() {
        return capsus;
    }

    public Constitucion capsus(String capsus) {
        this.capsus = capsus;
        return this;
    }

    public void setCapsus(String capsus) {
        this.capsus = capsus;
    }

    public String getNacciones() {
        return nacciones;
    }

    public Constitucion nacciones(String nacciones) {
        this.nacciones = nacciones;
        return this;
    }

    public void setNacciones(String nacciones) {
        this.nacciones = nacciones;
    }

    public Integer getNotariorut() {
        return notariorut;
    }

    public Constitucion notariorut(Integer notariorut) {
        this.notariorut = notariorut;
        return this;
    }

    public void setNotariorut(Integer notariorut) {
        this.notariorut = notariorut;
    }

    public String getNotariodv() {
        return notariodv;
    }

    public Constitucion notariodv(String notariodv) {
        this.notariodv = notariodv;
        return this;
    }

    public void setNotariodv(String notariodv) {
        this.notariodv = notariodv;
    }

    public Integer getDirectorrut() {
        return directorrut;
    }

    public Constitucion directorrut(Integer directorrut) {
        this.directorrut = directorrut;
        return this;
    }

    public void setDirectorrut(Integer directorrut) {
        this.directorrut = directorrut;
    }

    public String getDirectordv() {
        return directordv;
    }

    public Constitucion directordv(String directordv) {
        this.directordv = directordv;
        return this;
    }

    public void setDirectordv(String directordv) {
        this.directordv = directordv;
    }

    public Integer getReprut() {
        return reprut;
    }

    public Constitucion reprut(Integer reprut) {
        this.reprut = reprut;
        return this;
    }

    public void setReprut(Integer reprut) {
        this.reprut = reprut;
    }

    public String getRepdv() {
        return repdv;
    }

    public Constitucion repdv(String repdv) {
        this.repdv = repdv;
        return this;
    }

    public void setRepdv(String repdv) {
        this.repdv = repdv;
    }

    public Integer getEstado() {
        return estado;
    }

    public Constitucion estado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getExtnomdup() {
        return extnomdup;
    }

    public Constitucion extnomdup(Integer extnomdup) {
        this.extnomdup = extnomdup;
        return this;
    }

    public void setExtnomdup(Integer extnomdup) {
        this.extnomdup = extnomdup;
    }

    public Integer getExtnomduprut() {
        return extnomduprut;
    }

    public Constitucion extnomduprut(Integer extnomduprut) {
        this.extnomduprut = extnomduprut;
        return this;
    }

    public void setExtnomduprut(Integer extnomduprut) {
        this.extnomduprut = extnomduprut;
    }

    public String getExtnomdupdv() {
        return extnomdupdv;
    }

    public Constitucion extnomdupdv(String extnomdupdv) {
        this.extnomdupdv = extnomdupdv;
        return this;
    }

    public void setExtnomdupdv(String extnomdupdv) {
        this.extnomdupdv = extnomdupdv;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public Constitucion grupo(Integer grupo) {
        this.grupo = grupo;
        return this;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public LocalDate getFecact() {
        return fecact;
    }

    public Constitucion fecact(LocalDate fecact) {
        this.fecact = fecact;
        return this;
    }

    public void setFecact(LocalDate fecact) {
        this.fecact = fecact;
    }

    public LocalDate getFecactnom() {
        return fecactnom;
    }

    public Constitucion fecactnom(LocalDate fecactnom) {
        this.fecactnom = fecactnom;
        return this;
    }

    public void setFecactnom(LocalDate fecactnom) {
        this.fecactnom = fecactnom;
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
        Constitucion constitucion = (Constitucion) o;
        if (constitucion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), constitucion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Constitucion{" +
            "id=" + getId() +
            ", rut=" + getRut() +
            ", dv='" + getDv() + "'" +
            ", extracto='" + getExtracto() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", fecpub='" + getFecpub() + "'" +
            ", nomfan='" + getNomfan() + "'" +
            ", feconst='" + getFeconst() + "'" +
            ", tipconst='" + getTipconst() + "'" +
            ", duracion='" + getDuracion() + "'" +
            ", fecterm='" + getFecterm() + "'" +
            ", cappag='" + getCappag() + "'" +
            ", capsus='" + getCapsus() + "'" +
            ", nacciones='" + getNacciones() + "'" +
            ", notariorut=" + getNotariorut() +
            ", notariodv='" + getNotariodv() + "'" +
            ", directorrut=" + getDirectorrut() +
            ", directordv='" + getDirectordv() + "'" +
            ", reprut=" + getReprut() +
            ", repdv='" + getRepdv() + "'" +
            ", estado=" + getEstado() +
            ", extnomdup=" + getExtnomdup() +
            ", extnomduprut=" + getExtnomduprut() +
            ", extnomdupdv='" + getExtnomdupdv() + "'" +
            ", grupo=" + getGrupo() +
            ", fecact='" + getFecact() + "'" +
            ", fecactnom='" + getFecactnom() + "'" +
            "}";
    }
}
