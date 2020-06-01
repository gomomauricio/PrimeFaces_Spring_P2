package com.bita.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bita.model.TipoOperaciones;
import com.bita.model.TotalBitacora;
 
 
@Repository
public class UtilDAO extends DBGenericDAO   
{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UtilDAO.class);
	
	
	public List<TipoOperaciones> getOperacion()
	{
		List<TipoOperaciones> to = new ArrayList<TipoOperaciones>();
		
		TipoOperaciones top = null;
		
		try
		{
			String hql = "SELECT * FROM operaciones_dm";
			 
			Query query = getSessionFactory().getCurrentSession().createSQLQuery(hql);
			 @SuppressWarnings("unchecked")
			 Iterator<Object> i = query.list().iterator();
				
				while (i.hasNext()) 
				{
					top = new TipoOperaciones();
					Object[] row = (Object[]) i.next(); 
	
					if(row[0] != null) top.setId_operacion( ((Short)row[0]).intValue() ); 
					if(row[1] != null) top.setDescripcion( (String)row[1] );
					 
					to.add(top); 
					top = null; 
		         } 
				
			  
			logger.info("select getOperacion finalizado  con " + to.size() + "  registros" ); 
		}
		catch (Exception e) 
		{
			logger.error("Error en getOperacion" , e);  
			e.printStackTrace(); 
		}
		
		
		return to;
	}

	
	public List<String> funGetRol(int u) 
	{ 
		List<String> res = new ArrayList<String>(); 
		
		String us = "none"; 
		String rol = "none"; 
		String rolQ = "none"; 
		String[] roles = null;
		
		try
		{
			String cons = "call SP_DATOS_USUARIO(" + u + ", null)";
			
			Query query = getSessionFactory().getCurrentSession().createSQLQuery(cons); 
			
			@SuppressWarnings("unchecked")
			List<Object[]> rows =  query.list();	 
			 
			for(Object[] row : rows)
			{  
				if(row[7] != null) 
					rolQ = row[7].toString();
				
				if(row[8] != null) 
					us =  row[8].toString(); 
			}
			
			us = us.replace(" ", "");
			 
			res.add(us);
			 
			roles = rolQ.split("\\|");
			 
			if(roles.length > 0)
			{ 
				for (int i = 1; i < roles.length; i++)  
					 res.add(roles[i]); 
			}
			else
				res.add(rol);
			
			  
			logger.info("select rol finalizado  con " + us + " - " + rolQ ); 
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e); 
			res.add(us);
			res.add(rol);
		}
		 
		return res;
	}

	
}
