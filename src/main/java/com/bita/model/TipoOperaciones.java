package com.bita.model;

import java.sql.Date;
 

public class TipoOperaciones 
{
	private Integer id_operacion;	 
	private String descripcion; 
	private Date fecha_reg; 
	private String usuario_reg;	 
	private Integer aux_001;	 
	private Double aux_002;	  
	private String aux_003;  
	private String aux_004;	  
	private String aux_005;
	public Integer getId_operacion() {
		return id_operacion;
	}
	public void setId_operacion(Integer id_operacion) {
		this.id_operacion = id_operacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
	public String getUsuario_reg() {
		return usuario_reg;
	}
	public void setUsuario_reg(String usuario_reg) {
		this.usuario_reg = usuario_reg;
	}
	public Integer getAux_001() {
		return aux_001;
	}
	public void setAux_001(Integer aux_001) {
		this.aux_001 = aux_001;
	}
	public Double getAux_002() {
		return aux_002;
	}
	public void setAux_002(Double aux_002) {
		this.aux_002 = aux_002;
	}
	public String getAux_003() {
		return aux_003;
	}
	public void setAux_003(String aux_003) {
		this.aux_003 = aux_003;
	}
	public String getAux_004() {
		return aux_004;
	}
	public void setAux_004(String aux_004) {
		this.aux_004 = aux_004;
	}
	public String getAux_005() {
		return aux_005;
	}
	public void setAux_005(String aux_005) {
		this.aux_005 = aux_005;
	}
	@Override
	public String toString() {
		return "TipoOperaciones [id_operacion=" + id_operacion + ", descripcion=" + descripcion + ", fecha_reg="
				+ fecha_reg + ", usuario_reg=" + usuario_reg + ", aux_001=" + aux_001 + ", aux_002=" + aux_002
				+ ", aux_003=" + aux_003 + ", aux_004=" + aux_004 + ", aux_005=" + aux_005 + "]";
	}
	
	

}
