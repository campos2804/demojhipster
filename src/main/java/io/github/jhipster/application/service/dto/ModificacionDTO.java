package io.github.jhipster.application.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Modificacion entity.
 */
public class ModificacionDTO implements Serializable {

    private Long id;

    private Integer rut;

    private String dv;

    private String extracto;

    private String nombre;

    private String fecpub;

    private String nomfan;

    private String feconst;

    private String tipconst;

    private String duracion;

    private String fecterm;

    private String cappag;

    private String capsus;

    private String nacciones;

    private Integer notariorut;

    private String notariodv;

    private Integer directorrut;

    private String directordv;

    private Integer reprut;

    private String repdv;

    private String regcom;

    private String fojas;

    private String num;

    private String ano;

    private String fpubconst;

    private LocalDate fecescrit;

    private Integer estado;

    private Integer grupo;

    private LocalDate fecact;

    private LocalDate fecactnom;

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

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecpub() {
        return fecpub;
    }

    public void setFecpub(String fecpub) {
        this.fecpub = fecpub;
    }

    public String getNomfan() {
        return nomfan;
    }

    public void setNomfan(String nomfan) {
        this.nomfan = nomfan;
    }

    public String getFeconst() {
        return feconst;
    }

    public void setFeconst(String feconst) {
        this.feconst = feconst;
    }

    public String getTipconst() {
        return tipconst;
    }

    public void setTipconst(String tipconst) {
        this.tipconst = tipconst;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecterm() {
        return fecterm;
    }

    public void setFecterm(String fecterm) {
        this.fecterm = fecterm;
    }

    public String getCappag() {
        return cappag;
    }

    public void setCappag(String cappag) {
        this.cappag = cappag;
    }

    public String getCapsus() {
        return capsus;
    }

    public void setCapsus(String capsus) {
        this.capsus = capsus;
    }

    public String getNacciones() {
        return nacciones;
    }

    public void setNacciones(String nacciones) {
        this.nacciones = nacciones;
    }

    public Integer getNotariorut() {
        return notariorut;
    }

    public void setNotariorut(Integer notariorut) {
        this.notariorut = notariorut;
    }

    public String getNotariodv() {
        return notariodv;
    }

    public void setNotariodv(String notariodv) {
        this.notariodv = notariodv;
    }

    public Integer getDirectorrut() {
        return directorrut;
    }

    public void setDirectorrut(Integer directorrut) {
        this.directorrut = directorrut;
    }

    public String getDirectordv() {
        return directordv;
    }

    public void setDirectordv(String directordv) {
        this.directordv = directordv;
    }

    public Integer getReprut() {
        return reprut;
    }

    public void setReprut(Integer reprut) {
        this.reprut = reprut;
    }

    public String getRepdv() {
        return repdv;
    }

    public void setRepdv(String repdv) {
        this.repdv = repdv;
    }

    public String getRegcom() {
        return regcom;
    }

    public void setRegcom(String regcom) {
        this.regcom = regcom;
    }

    public String getFojas() {
        return fojas;
    }

    public void setFojas(String fojas) {
        this.fojas = fojas;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getFpubconst() {
        return fpubconst;
    }

    public void setFpubconst(String fpubconst) {
        this.fpubconst = fpubconst;
    }

    public LocalDate getFecescrit() {
        return fecescrit;
    }

    public void setFecescrit(LocalDate fecescrit) {
        this.fecescrit = fecescrit;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public LocalDate getFecact() {
        return fecact;
    }

    public void setFecact(LocalDate fecact) {
        this.fecact = fecact;
    }

    public LocalDate getFecactnom() {
        return fecactnom;
    }

    public void setFecactnom(LocalDate fecactnom) {
        this.fecactnom = fecactnom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModificacionDTO modificacionDTO = (ModificacionDTO) o;
        if(modificacionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), modificacionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ModificacionDTO{" +
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
            ", regcom='" + getRegcom() + "'" +
            ", fojas='" + getFojas() + "'" +
            ", num='" + getNum() + "'" +
            ", ano='" + getAno() + "'" +
            ", fpubconst='" + getFpubconst() + "'" +
            ", fecescrit='" + getFecescrit() + "'" +
            ", estado=" + getEstado() +
            ", grupo=" + getGrupo() +
            ", fecact='" + getFecact() + "'" +
            ", fecactnom='" + getFecactnom() + "'" +
            "}";
    }
}
