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
import com.bita.model.BitaMalos;
import com.bita.model.BitaTotal;
import com.bita.model.Bitacora;
import com.bita.model.BuscaBita;
import com.bita.model.TotalBitacora;
 
 

@Repository
public class BitaTotalDAO extends DBGenericDAO 
{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BitaTotalDAO.class);
	
	public List<BitaTotal> funSelTotal(List<String> bb) 
	{
		List<BitaTotal> res = new ArrayList<BitaTotal>(); 
		  BitaTotal bita = null;
		  
		  System.out.println(" param total: " + bb);
		
		logger.info(" Inicia Call Totales " ); 
		
		String consulta = "CALL spConsultaTotalGeneral('" + bb.get(0) + "','" +
				 											   bb.get(1) + "');";
		logger.info("consulta: " + consulta);
		try
		{
	        Query query2 = getSessionFactory().getCurrentSession().createSQLQuery( consulta );
	         
	        @SuppressWarnings("unchecked")
			 Iterator<Object> i = query2.list().iterator();
				
				while (i.hasNext()) 
				{
					bita = new BitaTotal();
					
					Object[] row = (Object[]) i.next();  
					  
					if(row[0] != null) bita.setSqlError( (Integer)row[0] ); 
					if(row[1] != null) bita.setIsaError( (Integer)row[1] );
					if(row[2] != null) bita.setErrorInfo( (String)row[2] ); 
					if(row[3] != null) bita.setMovTotal( (Integer)row[3]  );
					if(row[4] != null) bita.setFecha( (String)row[4] );  
					if(row[5] != null) bita.setMovOk( (Integer)row[5] ); 
						if( bita.getMovOk() >=1 )  
								bita.setIsDetalles(true); 
					if(row[6] != null) bita.setMonNoOk((Integer)row[6]);   
						if( bita.getMonNoOk() >=1 ) 
								bita.setIsMalos(true); 
					if(row[7] != null) bita.setEstatus( (String)row[7] );   
					
					res.add(bita);
					
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
	
	
	public List<BitaMalos> funSelDetalleMalos(List<String> bb) 
	{
		List<BitaMalos> res = new ArrayList<BitaMalos>(); 
		BitaMalos bita = null;
		
		logger.info(" Inicia Call a spConsultaDetalleError " );
		
		String consulta = "CALL spConsultaDetalleError(10,'" + bb.get(0) + "');";
		
		logger.info("consulta: " + consulta);
		try
		{
	        Query query2 = getSessionFactory().getCurrentSession().createSQLQuery( consulta );
	         
	        @SuppressWarnings("unchecked")
			 Iterator<Object> i = query2.list().iterator();
				
				while (i.hasNext()) 
				{
					bita = new BitaMalos();
					
					Object[] row = (Object[]) i.next(); 
					
					 if(row[0] != null) bita.setvSqlError( (Integer)row[0] ); 
				     if(row[1] != null) bita.setvIsamError( (Integer)row[1] ); 
				     if(row[2] != null) bita.setvErrorInformacion( row[2].toString() ); 
					 if(row[3] != null) bita.setCompania( row[3].toString() );  
					 if(row[4] != null) bita.setAno( row[4].toString() ); 
					 if(row[5] != null) bita.setMes( row[5].toString() ); 
					 
					 if(row[6] != null) bita.setNumSucursal( ((Short)row[6]).intValue() ); 
					 if(row[7] != null) bita.setNumRamo( ((Short)row[7]).intValue() ); 
					 
					 if(row[8] != null) bita.setNumpoliza(  row[8].toString() );
					 
					 if(row[9] != null) bita.setTipoEndoso( row[9].toString() ); 
					 if(row[10] != null) bita.setNumEndoso( (Integer)row[10] );  
					 
					 if(row[11] != null) bita.setFechapoliza(  row[11].toString() ); 
					 if(row[12] != null) bita.setTipopoliza(  row[12].toString() ); 
					 if(row[13] != null) bita.setNomOpera(  row[13].toString() ); 					 
					 if(row[14] != null) bita.setNumrecibo(  row[14].toString() );  
					 
					 if(row[15] != null) bita.setTotalRecibos(  row[15].toString() );  
					 
					 if(row[16] != null) bita.setMoneda(   row[16].toString() ); 
					 if(row[17] != null) bita.setCargo(   row[17].toString() ); 
					 if(row[18] != null) bita.setPrimaneta(   row[18].toString() ); 
					 if(row[19] != null) bita.setRecargos(  row[19].toString() );  
					 if(row[20] != null) bita.setDerechos(  row[20].toString() );  
					 if(row[21] != null) bita.setCompf(  row[21].toString() ); 
					 if(row[22] != null) bita.setComxdevpf(   row[22].toString() ); 
					 if(row[23] != null) bita.setCompm(  row[23].toString() ); 
					 if(row[24] != null) bita.setComxdevpm(  row[24].toString() );  
					 if(row[25] != null) bita.setIva(  row[25].toString() ); 
					 if(row[26] != null) bita.setMensaje(  row[26].toString() );
					 
					 res.add(bita);
				}
					 
		}
		catch (Exception e) 
		{
			logger.info("Error al cargar Detalle Malos " , e);
			e.printStackTrace();
		}
		 
		logger.info("Termina spConsultaDetalleError con " + res.size() + " registros");
		 
		return res;
	}
	
	 
	
}
