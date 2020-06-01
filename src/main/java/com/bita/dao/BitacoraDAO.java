package com.bita.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bita.model.Bita2;
import com.bita.model.Bitacora;
import com.bita.model.BuscaBita;
import com.bita.model.TotalBitacora;
 
 

@Repository
public class BitacoraDAO extends DBGenericDAO 
{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BitacoraDAO.class);
	
	public List<TotalBitacora> funSelTotal(List<String> bb) 
	{
		List<TotalBitacora> res = new ArrayList<TotalBitacora>(); 
		TotalBitacora bita = null;
		
		logger.info(" Inicia Call a spConsultaTotalBitacora " );
		
		String consulta = "CALL spConsultaTotalBitacora(" + 
		                    bb.get(0) + "," + 
		                    bb.get(1) + ",'" +
		                    bb.get(2) + "','" +
		                    bb.get(3) + "'," +
		                    bb.get(4) + ")";
		
		logger.info("consulta: " + consulta);
		try
		{
	        Query query2 = getSessionFactory().getCurrentSession().createSQLQuery( consulta );
	         
	        @SuppressWarnings("unchecked")
			 Iterator<Object> i = query2.list().iterator();
				
				while (i.hasNext()) 
				{
					bita = new TotalBitacora();
					bita.setIsMovimientos(false);
					bita.setOperacion( Integer.valueOf( bb.get(4) ) ); 
					
					if(bita.getOperacion() == 1) bita.setDescripOper("EMISION");
					if(bita.getOperacion() == 2) bita.setDescripOper("COBRANZA");
					if(bita.getOperacion() == 3) bita.setDescripOper("SINIESTROS");
					if(bita.getOperacion() == 4) bita.setDescripOper("AGENTES");
					if(bita.getOperacion() == 5) bita.setDescripOper("RE ASEGUROS"); 
					
					Object[] row = (Object[]) i.next(); 
	
					if(row[0] != null) bita.setvSqlError( (Integer)row[0] ); 
					if(row[1] != null) bita.setvIsamError( (Integer)row[1] );
					if(row[2] != null) bita.setvErrorInformacion( (String)row[2] ); 
					if(row[3] != null) bita.setCompania( ((Short)row[3]).intValue() );
					if(row[4] != null) bita.setAnio( ((Short)row[4]).intValue() );  
					if(row[5] != null) bita.setMes( ((Short)row[5]).intValue() ); 
					if(row[6] != null) bita.setPolizaContable((Integer)row[6]);    
					if(row[7] != null) bita.setFechaDelaPoliza( ((Date)row[7]).toString() );  
					if(row[8] != null) bita.setTipoDePoliza( ((Short)row[8]).intValue() );  
					if(row[9] != null) bita.setCargos( Double.valueOf(row[9].toString()) );  
					if(row[10] != null) bita.setAbonos( Double.valueOf(row[10].toString()) ); 
					if(row[11] != null)
					{
						bita.setMovimientos( ((Short)row[11]).intValue() );
						if(bita.getMovimientos() > 0 ) bita.setIsMovimientos(true); 
					}
					if(row[12] != null) bita.setNumRecibo( ((Short)row[12]).intValue() ); 
//					if(row[13] != null) bita.setTotalRecibo(((Short)row[13]).intValue() );
					if(row[13] != null) 
					{
						bita.setEstatus( (String)row[13] );
						 if(bita.getEstatus().contains("Poliza Descuadrada"))
							 bita.setIsPolDescuadrada(true);
					}
					 
					if(bita.getIsMovimientos())
					{
						if(!bita.getIsPolDescuadrada())
								res.add(bita);
					}
					
					bita = null;
					 
		         }
		}
		catch (Exception e) 
		{
			logger.info("Error al cargar Total " , e);
			e.printStackTrace();
		}
		 
		logger.info("Termina spConsultaTotalBitacora con " + res.size() + " registros");
	 
		return res;
	}
	
	public List<Bitacora> funSel(BuscaBita bb) 
	{
		List<Bitacora> res = new ArrayList<Bitacora>(); 
		Bitacora bita = null;
		
		logger.info(" Inicia Select a wdpoliza " );
		try
		{
	// call spConsultaDetalleBitacotaWee(pCveCia, pAno, pMes, pPolCont, pFecPol, pTipPol, pOperacion)
			String consulta = "CALL spConsultaDetalleBitacora(" + 
			                    bb.getpCveCia() + "," + 
					            bb.getpAno() + "," +
			                    bb.getpMes() + "," +
					            bb.getpPolCont() + ",'" + 
			                    bb.getpFecPol() + "'," +
			                    bb.getpTipPol() + "," +
					            bb.getpOperacion()  + "," +
					            bb.getpEstatus() +  ")";
			
			logger.info("consulta: " + consulta);
	        Query query2 = getSessionFactory().getCurrentSession().createSQLQuery( consulta );
	        
	        
				 
				@SuppressWarnings("unchecked")
				Iterator<Object> i = query2.list().iterator();
				
				while (i.hasNext()) 
				{
					bita = new Bitacora();
					Object[] row = (Object[]) i.next(); 
				 
					if(row[0] != null) bita.setvSqlError( (Integer)row[0] );    
					if(row[1] != null) bita.setvIsamError( (Integer)row[1] );  
					if(row[2] != null) bita.setvErrorInformacion( (String)row[2] );  
					if(row[3] != null) bita.setCompania( ((Short)row[3]).intValue() );  
					if(row[4] != null) bita.setAnio( ((Short)row[4]).intValue() );  
					if(row[5] != null) bita.setMes( ((Short)row[5]).intValue() );  
					if(row[6] != null) bita.setNumeroDePoliza( row[6].toString() );  
					if(row[7] != null) bita.setFechaDelaPoliza( (java.sql.Date)row[7] );  
					if(row[8] != null) bita.setTipoDePoliza( ((Short)row[8]).intValue() );  
					if(row[9] != null) bita.setCuenta( (String)row[9] ); 
					if(row[10] != null) bita.setMoneda( (String)row[10] );  
					if(row[11] != null) bita.setCtroDeCostos( (String)row[11] );    
					if(row[12] != null) bita.setCargo( Double.valueOf(row[12].toString()) );  
					if(row[13] != null) bita.setAbono( Double.valueOf(row[13].toString()) );  
					if(row[14] != null) bita.setvDesMov( (String)row[14] );   
					if(row[15] != null) bita.setPolizaContable( (Integer)row[15] ); 
					if(row[16] != null) bita.setMovimientos( ((Short)row[16]).intValue() );   
					if(row[17] != null) bita.setNumRecibo( ((Short)row[17]).intValue() );  
					if(row[18] != null) bita.setTotalRecibo( ((Short)row[18]).toString() );
					if(row[19] != null) bita.setEstatus( row[19].toString() );


					if( bita.getTotalRecibo() != null )
						if(bita.getTotalRecibo().equals("1"))
										bita.setDescRecibo("ANUAL/CONTADO");
						else if(bita.getTotalRecibo().equals("2"))
										bita.setDescRecibo("SEMESTRAL");
						else if(bita.getTotalRecibo().equals("4"))
										bita.setDescRecibo("TRIMESTRAL");
						else if(bita.getTotalRecibo().equals("12"))
										bita.setDescRecibo("MENSUAL");
						else if(bita.getTotalRecibo().equals("26"))
										bita.setDescRecibo("QUINCENAL");
						else if(bita.getTotalRecibo().equals("52"))
										bita.setDescRecibo("SEMANAL");
					 
	  
					res.add(bita);
					bita = null;
					 
		         }
		}
		catch (Exception e) 
		{
			logger.info("Error al cargar Total " , e);
			e.printStackTrace();
		}
		 
			logger.info("Temina wdpoliza con " + res.size() + " registros");
		 
		return res;
	}
	
	
}
