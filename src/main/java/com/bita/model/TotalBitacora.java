package com.bita.model;

public class TotalBitacora 
{

	private Integer vSqlError;
	private Integer vIsamError;
	private String vErrorInformacion; 
	private Integer compania;
	private Integer anio;
	private Integer mes;
	private Integer polizaContable;
	private String fechaDelaPoliza;
	private Integer tipoDePoliza;
	private Double cargos;
	private Double abonos;
	private Integer movimientos;
	private Integer numRecibo;
	private Integer totalRecibo; 
	private String estatus;
	
	private Boolean isMovimientos;
	private Boolean isPolDescuadrada=false;
	
	private Integer operacion;
	private String descripOper;
  
	
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
	 
	public String getFechaDelaPoliza() {
		return fechaDelaPoliza;
	}
	public void setFechaDelaPoliza(String fechaDelaPoliza) {
		this.fechaDelaPoliza = fechaDelaPoliza;
	}
	public Integer getTipoDePoliza() {
		return tipoDePoliza;
	}
	public void setTipoDePoliza(Integer tipoDePoliza) {
		this.tipoDePoliza = tipoDePoliza;
	}
	public Double getCargos() {
		return cargos;
	}
	public void setCargos(Double cargos) {
		this.cargos = cargos;
	}
	public Double getAbonos() {
		return abonos;
	}
	public void setAbonos(Double abonos) {
		this.abonos = abonos;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Integer getPolizaContable() {
		return polizaContable;
	}
	public void setPolizaContable(Integer polizaContable) {
		this.polizaContable = polizaContable;
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
	public Boolean getIsMovimientos() {
		return isMovimientos;
	}
	public void setIsMovimientos(Boolean isMovimientos) {
		this.isMovimientos = isMovimientos;
	}
	
	
	public Integer getOperacion() {
		return operacion;
	}
	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}
	
	public String getDescripOper() {
		return descripOper;
	}
	public void setDescripOper(String descripOper) {
		this.descripOper = descripOper;
	}
	public Boolean getIsPolDescuadrada() {
		return isPolDescuadrada;
	}
	public void setIsPolDescuadrada(Boolean isPolDescuadrada) {
		this.isPolDescuadrada = isPolDescuadrada;
	}
	public Integer getTotalRecibo() {
		return totalRecibo;
	}
	public void setTotalRecibo(Integer totalRecibo) {
		this.totalRecibo = totalRecibo;
	}
 
	
	 
	
	
	
	
	
}
