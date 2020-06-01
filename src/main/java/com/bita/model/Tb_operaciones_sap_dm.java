package com.bita.model;

import java.sql.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_operaciones_sap_dm") 
public class Tb_operaciones_sap_dm 
{
	@Id 
	@Column(name = "id_operacion", nullable=false )	 
	private Integer id_operacion;	
	
	@Column(name = "descripcion")
	private String descripcion;	
	
	@Column(name = "fec_reg") 
	private Date fec_reg;

	@Column(name = "usr_reg")
	private String usr_reg;	

	@Column(name = "aux_001")
	private Integer aux_001;	

	@Column(name = "aux_002") 
	private Double aux_002;	

	@Column(name = "aux_003") 
	private String aux_003;
	
	@Column(name = "aux_004") 
	private String aux_004;	

	@Column(name = "aux_005") 
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

	public Date getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}

	public String getUsr_reg() {
		return usr_reg;
	}

	public void setUsr_reg(String usr_reg) {
		this.usr_reg = usr_reg;
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
		return "Tb_operaciones_sap_dm [id_operacion=" + id_operacion + ", descripcion=" + descripcion + ", fec_reg="
				+ fec_reg + ", usr_reg=" + usr_reg + ", aux_001=" + aux_001 + ", aux_002=" + aux_002 + ", aux_003="
				+ aux_003 + ", aux_004=" + aux_004 + ", aux_005=" + aux_005 + "]";
	}
	 
	
	
	 
	
	

}










 

