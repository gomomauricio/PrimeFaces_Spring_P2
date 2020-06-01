package com.bita.service;

import java.io.Serializable; 
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bita.dao.BitaTotalDAO;
import com.bita.dao.BitacoraDAO;

import com.bita.dao.UtilDAO;
import com.bita.model.BitaMalos;
import com.bita.model.BitaTotal;
import com.bita.model.Bitacora;
import com.bita.model.BuscaBita; 
import com.bita.model.TipoOperaciones;
import com.bita.model.TotalBitacora;


 

  
@Service
public class DBService implements IDBService, Serializable{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DBService.class);
	
	 
	@Autowired
	BitacoraDAO bitacoraDAO;

	@Autowired
	BitaTotalDAO bitaTotalDAO;
	 
	@Autowired
	UtilDAO utilDAO;
	
	
	 
	
///////////////////  BitacoraDAO     //////////////////////////////////
	@Transactional (value="DBTxManager" )
	public List<TotalBitacora> funBitaTotal(List<String> bb)
	{   
	   return bitacoraDAO.funSelTotal(bb);
	}
	
	@Transactional (value="DBTxManager" )
	public List<Bitacora> funBitacora(BuscaBita bb)
	{ 
	   //logger.info(" Enviando funSociedadSap");   
	   return bitacoraDAO.funSel(bb);
	}
	
///////////////////  BitaTotalDAO     //////////////////////////////////
	@Transactional (value="DBTxManager" )
	public List<BitaTotal> funTotal(List<String> bb)
	{   
		return bitaTotalDAO.funSelTotal(bb);
	}

	@Transactional (value="DBTxManager" )
	public List<BitaMalos> funBitaDetalleMalos(List<String> bb)
	{   
		return bitaTotalDAO.funSelDetalleMalos(bb);
	}

 	
	
 
	///////////////////  Util       //////////////////////////	
	
	@Transactional (value="DBTxManager" )
	public List<TipoOperaciones> getOperacion()
	{
		return utilDAO.getOperacion();
	}
	
	@Transactional (value="DBTxManager" )
	public List<String> getRol(int u)
	{
//		logger.info(" Enviando getRol");  
		return utilDAO.funGetRol(u);
	}
	 
}
