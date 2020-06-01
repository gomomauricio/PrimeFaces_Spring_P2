package com.bita.service;

import java.sql.Date;
import java.util.List;

import com.bita.model.BitaMalos;
import com.bita.model.BitaTotal;
import com.bita.model.Bitacora;
import com.bita.model.BuscaBita; 
import com.bita.model.TipoOperaciones;
import com.bita.model.TotalBitacora;
 
 

 

 
public interface IDBService {
 
	
	//BitacoraDAO
	public List<TotalBitacora> funBitaTotal(List<String> bb);
	public List<Bitacora> funBitacora(BuscaBita bb);
	
	//BitaTotalDAO   
	 public List<BitaTotal> funTotal(List<String> bb);
	 public List<BitaMalos> funBitaDetalleMalos(List<String> bb);
	 
	//util
    public List<String> getRol(int u);
    public List<TipoOperaciones> getOperacion();
}
