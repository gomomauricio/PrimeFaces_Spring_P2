package com.bita.model;

import java.io.Serializable;
import java.sql.Date;

 
public class Bitacora  
{
	 
	private static final long serialVersionUID = 1L;
	
	private Integer vSqlError;
	private Integer vIsamError;
	private String vErrorInformacion; 
	private Integer Compania;
	private Integer Anio;
	private Integer Mes;
	private String NumeroDePoliza; //Referencia
	private Date FechaDelaPoliza;
	private Integer TipoDePoliza;
	private String Cuenta;
	private String Moneda;
	private String CtroDeCostos;
	private Integer PolizaContable; //PolCont
	private Double Cargo;
	private Double Abono;
	private String vDesMov;   
	private Integer movimientos; 
	private Integer numRecibo;
	private String estatus;  
	private String totalRecibo;
	private String descRecibo;
	
	 
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
		return Compania;
	}
	public void setCompania(Integer compania) {
		Compania = compania;
	}
	public Integer getAnio() {
		return Anio;
	}
	public void setAnio(Integer anio) {
		Anio = anio;
	}
	public Integer getMes() {
		return Mes;
	}
	public void setMes(Integer mes) {
		Mes = mes;
	}
	public String getNumeroDePoliza() {
		return NumeroDePoliza;
	}
	public void setNumeroDePoliza(String numeroDePoliza) {
		NumeroDePoliza = numeroDePoliza;
	}
	public Date getFechaDelaPoliza() {
		return FechaDelaPoliza;
	}
	public void setFechaDelaPoliza(Date fechaDelaPoliza) {
		FechaDelaPoliza = fechaDelaPoliza;
	}
	public Integer getTipoDePoliza() {
		return TipoDePoliza;
	}
	public void setTipoDePoliza(Integer tipoDePoliza) {
		TipoDePoliza = tipoDePoliza;
	}
	public String getCuenta() {
		return Cuenta;
	}
	public void setCuenta(String cuenta) {
		Cuenta = cuenta;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public String getCtroDeCostos() {
		return CtroDeCostos;
	}
	public void setCtroDeCostos(String ctroDeCostos) {
		CtroDeCostos = ctroDeCostos;
	}
	public Integer getPolizaContable() {
		return PolizaContable;
	}
	public void setPolizaContable(Integer polizaContable) {
		PolizaContable = polizaContable;
	}
	public Double getCargo() {
		return Cargo;
	}
	public void setCargo(Double cargo) {
		Cargo = cargo;
	}
	public Double getAbono() {
		return Abono;
	}
	public void setAbono(Double abono) {
		Abono = abono;
	}
	public String getvDesMov() {
		return vDesMov;
	}
	public void setvDesMov(String vDesMov) {
		this.vDesMov = vDesMov;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	 
	public Integer getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(Integer movimientos) {
		this.movimientos = movimientos;
	}
	public Integer getNumRecibo() {
		return numRecibo;
	}
	public void setNumRecibo(Integer numRecibo) {
		this.numRecibo = numRecibo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTotalRecibo() {
		return totalRecibo;
	}
	public void setTotalRecibo(String totalRecibo) {
		this.totalRecibo = totalRecibo;
	}
	public String getDescRecibo() {
		return descRecibo;
	}
	public void setDescRecibo(String descRecibo) {
		this.descRecibo = descRecibo;
	}
	
	
	 
	 
	
	
	

	
	
	
	
}
