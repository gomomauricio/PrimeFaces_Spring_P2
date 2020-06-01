package com.bita.model;

import java.util.Date;

public class BuscaBita
{
	
	private Integer pCveCia;
	private Integer pAno;
	private Integer  pMes;
	private Integer pPolCont;
	private String pFecPol;
	private Integer pTipPol;  
	private Integer pOperacion;
	private Integer pEstatus;
 
	
	public Integer getpCveCia() {
		return pCveCia;
	}
	public void setpCveCia(Integer pCveCia) {
		this.pCveCia = pCveCia;
	}
	public Integer getpAno() {
		return pAno;
	}
	public void setpAno(Integer pAno) {
		this.pAno = pAno;
	}
	public Integer getpMes() {
		return pMes;
	}
	public void setpMes(Integer pMes) {
		this.pMes = pMes;
	}
	 
	public String getpFecPol() {
		return pFecPol;
	}
	public void setpFecPol(String pFecPol) {
		this.pFecPol = pFecPol;
	}
	public Integer getpTipPol() {
		return pTipPol;
	}
	public void setpTipPol(Integer pTipPol) {
		this.pTipPol = pTipPol;
	}
	public Integer getpPolCont() {
		return pPolCont;
	}
	public void setpPolCont(Integer pPolCont) {
		this.pPolCont = pPolCont;
	}
	public Integer getpOperacion() {
		return pOperacion;
	}
	public void setpOperacion(Integer pOperacion) {
		this.pOperacion = pOperacion;
	}
	
	
	public Integer getpEstatus() {
		return pEstatus;
	}
	public void setpEstatus(Integer pEstatus) {
		this.pEstatus = pEstatus;
	}
	@Override
	public String toString() {
		return "BuscaBita [pCveCia=" + pCveCia + ", pAno=" + pAno + ", pMes=" + pMes + ", pPolCont=" + pPolCont
				+ ", pFecPol=" + pFecPol + ", pTipPol=" + pTipPol + ", pOperacion=" + pOperacion + "]";
	}
	
	 
	


	
	 
	 
	 
	


}
