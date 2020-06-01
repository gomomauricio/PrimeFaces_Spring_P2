package com.bita.model;

public class BitaTotal 
{
	
	private Integer sqlError;
	private Integer isaError;
	private String errorInfo;
	
	private Integer movTotal;  
	private String fecha;	 
	private Integer movOk;  
	private Integer monNoOk;	 	
	private String estatus;
	
	private Boolean isDetalles = false;
	private Boolean isMalos = false;
	 
	
	public Integer getMovTotal() {
		return movTotal;
	}
	public String getFecha() {
		return fecha;
	}
	public Integer getMovOk() {
		return movOk;
	}
	public Integer getMonNoOk() {
		return monNoOk;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setMovTotal(Integer movTotal) {
		this.movTotal = movTotal;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setMovOk(Integer movOk) {
		this.movOk = movOk;
	}
	public void setMonNoOk(Integer monNoOk) {
		this.monNoOk = monNoOk;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Boolean getIsDetalles() {
		return isDetalles;
	}
	public Boolean getIsMalos() {
		return isMalos;
	}
	public void setIsDetalles(Boolean isDetalles) {
		this.isDetalles = isDetalles;
	}
	public void setIsMalos(Boolean isMalos) {
		this.isMalos = isMalos;
	}
	public Integer getSqlError() {
		return sqlError;
	}
	public Integer getIsaError() {
		return isaError;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setSqlError(Integer sqlError) {
		this.sqlError = sqlError;
	}
	public void setIsaError(Integer isaError) {
		this.isaError = isaError;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	@Override
	public String toString() {
		return "BitaTotal [sqlError=" + sqlError + ", isaError=" + isaError + ", errorInfo=" + errorInfo + ", movTotal="
				+ movTotal + ", fecha=" + fecha + ", movOk=" + movOk + ", monNoOk=" + monNoOk + ", estatus=" + estatus
				+ ", isDetalles=" + isDetalles + ", isMalos=" + isMalos + "]";
	}
	
	 
	
	 
	
	

}
