package com.bita.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Bita2  
{
	 
	private static final long serialVersionUID = 1L;
	
	@Column(name = "vSqlError")	
	private Integer vSqlError;
	
	@Column(name = "vIsamError")	
	private Integer vIsamError;
	
	@Column(name = "vErrorInformacion")	
	private String vErrorInformacion;
	
	@Column(name = "compania")	
	private Integer compania;
	
	@Column(name = "anio")	
	private Integer anio;
	
	@Column(name = "mes")	
	private Integer mes;
	
	@Id
	@Column(name = "numerodepoliza", unique = false, nullable = false) 
	private Integer numerodepoliza;
	
	@Column(name = "fechadelapoliza")	
	private Date fechadelapoliza;
	
	@Column(name = "tipodepoliza")	
	private Integer tipodepoliza;
	
	@Column(name = "cuenta")	
	private String cuenta;
	
	@Column(name = "moneda")	
	private String moneda;
	
	@Column(name = "ctrodecostos")	
	private String ctrodecostos;
	
	@Column(name = "numerodecheque")	
	private String numerodecheque;
	
	@Column(name = "cargo")	
	private Double cargo;
	
	@Column(name = "abono")	
	private Double abono;
	
	@Column(name = "vdesmov")	
	private String vdesmov;
	
	@Column(name = "tippro")	
	private Integer tippro;
	
	@Column(name = "orden")	
	private Integer orden;
	
	@Column(name = "polcont")	
	private Integer polcont;
	
	@Column(name = "estatus")	
	private Integer estatus;

	public Integer getvSqlError() {
		return vSqlError;
	}

	public void setvSqlError(Integer vSqlError) {
		this.vSqlError = vSqlError;
	}

	public Integer getvIsamError() {
		return vIsamError;
	}

	public void setvIsamError(Integer vIsamError) {
		this.vIsamError = vIsamError;
	}

	public String getvErrorInformacion() {
		return vErrorInformacion;
	}

	public void setvErrorInformacion(String vErrorInformacion) {
		this.vErrorInformacion = vErrorInformacion;
	}

	public Integer getCompania() {
		return compania;
	}

	public void setCompania(Integer compania) {
		this.compania = compania;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getNumerodepoliza() {
		return numerodepoliza;
	}

	public void setNumerodepoliza(Integer numerodepoliza) {
		this.numerodepoliza = numerodepoliza;
	}

	public Date getFechadelapoliza() {
		return fechadelapoliza;
	}

	public void setFechadelapoliza(Date fechadelapoliza) {
		this.fechadelapoliza = fechadelapoliza;
	}

	public Integer getTipodepoliza() {
		return tipodepoliza;
	}

	public void setTipodepoliza(Integer tipodepoliza) {
		this.tipodepoliza = tipodepoliza;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getCtrodecostos() {
		return ctrodecostos;
	}

	public void setCtrodecostos(String ctrodecostos) {
		this.ctrodecostos = ctrodecostos;
	}

	public String getNumerodecheque() {
		return numerodecheque;
	}

	public void setNumerodecheque(String numerodecheque) {
		this.numerodecheque = numerodecheque;
	}

	public Double getCargo() {
		return cargo;
	}

	public void setCargo(Double cargo) {
		this.cargo = cargo;
	}

	public Double getAbono() {
		return abono;
	}

	public void setAbono(Double abono) {
		this.abono = abono;
	}

	public String getVdesmov() {
		return vdesmov;
	}

	public void setVdesmov(String vdesmov) {
		this.vdesmov = vdesmov;
	}

	public Integer getTippro() {
		return tippro;
	}

	public void setTippro(Integer tippro) {
		this.tippro = tippro;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getPolcont() {
		return polcont;
	}

	public void setPolcont(Integer polcont) {
		this.polcont = polcont;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Bita2 [vSqlError=" + vSqlError + ", vIsamError=" + vIsamError + ", vErrorInformacion="
				+ vErrorInformacion + ", compania=" + compania + ", anio=" + anio + ", mes=" + mes + ", numerodepoliza="
				+ numerodepoliza + ", fechadelapoliza=" + fechadelapoliza + ", tipodepoliza=" + tipodepoliza
				+ ", cuenta=" + cuenta + ", moneda=" + moneda + ", ctrodecostos=" + ctrodecostos + ", numerodecheque="
				+ numerodecheque + ", cargo=" + cargo + ", abono=" + abono + ", vdesmov=" + vdesmov + ", tippro="
				+ tippro + ", orden=" + orden + ", polcont=" + polcont + ", estatus=" + estatus + "]";
	}
 
	
	 


	
	
	
	
}
