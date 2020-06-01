package com.bita.bean;
 
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.RowEditEvent;

import com.bita.model.BitaMalos;
import com.bita.model.BitaTotal;
import com.bita.model.Bitacora;
import com.bita.model.BuscaBita; 
import com.bita.model.TipoOperaciones;
import com.bita.model.TotalBitacora;
import com.bita.service.IDBService;
 
  
@ManagedBean(name="bitaSW") 
@SessionScoped
public class BitaBean  
{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BitaBean.class);
	
	@ManagedProperty(value="#{DBService}")
	IDBService DBService;
	
	private List<TotalBitacora> lTotalBit = new ArrayList<TotalBitacora>();
	private List<TotalBitacora> lTotalBitFiltro = new ArrayList<TotalBitacora>();
	
	private List<Bitacora> lBit = new ArrayList<Bitacora>();
	private List<Bitacora> lBitFiltro = new ArrayList<Bitacora>();
	
	private List<TipoOperaciones> ltop = new ArrayList<TipoOperaciones>();
	
	private java.util.Date fechaBusqueda;
	
	private BuscaBita buscaBita = new BuscaBita();
	private TotalBitacora TotalbuscaBita = new TotalBitacora(); 
	
	//variables para Totales
	private Double cargoT1;
	private Double abonoT1;
	private Double cargoT2;
	private Double abonoT2;
	
	//variables Busqueda Total
	private Integer companiaT;
	private Integer polizaT;
	private java.util.Date fechaT = null;
	private java.util.Date fechaF = null;
	private java.util.Date fechaTDetalles = null;
	private java.util.Date fechaFDetalles = null; 
	
	//variable Busqueda Individual
	private Integer numPolIndv = null;
	private Integer polConIndv = null;
	
	//Variable para mostrar tablas Total/Detalle/Malos
	private Boolean isTotal;
	private Boolean isDetalle;
	private Boolean isMalos; 
	private Boolean isBtnReturn; 
	private Boolean isFechaIF;
	private List<BitaMalos> lMalos = new ArrayList<BitaMalos>();
	private List<BitaMalos> lMalosFiltro = new ArrayList<BitaMalos>();
	
	private List<BitaTotal> lTotales = new ArrayList<BitaTotal>();
	private List<BitaTotal> lTotalesFiltro = new ArrayList<BitaTotal>();
	
	private Integer numOper;
	
	@PostConstruct
	public final void init() 
	{
		logger.info("Inicia Bean Bitacora ");  
  		
		isTotal = true;
		isMalos = false;
		isDetalle = false;
		isBtnReturn = false;
		isFechaIF = true;
		
 
		TipoOperaciones to = new TipoOperaciones();
		to.setId_operacion(77);
		to.setDescripcion("GLOBAL");
		
		ltop.add(to);
	} 
	
	public void muestraTotales()
	{
		isTotal = true; //se enciende principal
		isMalos = false;
		isDetalle = false;
		isBtnReturn = false; //se apaga boton
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		 cleanList(lTotalesFiltro);
		 cleanList(lTotales);
		  
		try
		{
			if( fechaT == null || fechaF == null)
			{
				context.addMessage(null, new FacesMessage("Importante",  "Debe seleccionar DOS fechas de busqueda " ) ); 
			}
			else
			{
				Format formatter = new SimpleDateFormat("dd/MM/yyyy");
				Format formatter2 = new SimpleDateFormat("dd/MM/yyyy");
				Format forINICIO = new SimpleDateFormat("dd/MM/yyyy");
				 
				List<String> bb = new ArrayList<String>();
				 
				cleanList(lTotales);
				 
				 bb.add( formatter.format( fechaT));
				 bb.add( formatter2.format( fechaF));
				  
				 lTotales = DBService.funTotal(bb); 
				 
			}
			
			
		}
		 catch (Exception e) 
		 {
			 context.addMessage(null, new FacesMessage("Importante",  "Error al traer registros" ) ); 
			 logger.info("Error en busqueda Totales " , e );
				e.printStackTrace();
		 } 
		 
	}
	
	public void muestraDetalles(BitaTotal bt)
	{
		isTotal = false; 
		isMalos = false;
		isDetalle = true; //se enciende detalles Contabilizados
		isBtnReturn = true; //se enciende boton
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		 cleanList(ltop); 
		 
		try
		{ System.out.println(" Fecha a detalle " + bt.getFecha());
		 
			java.util.Date fechaDet =  new SimpleDateFormat("dd/MM/yyyy").parse(bt.getFecha());
			fechaFDetalles = fechaDet;
			fechaTDetalles = fechaDet;
				//llenar tipo operaciones
			ltop = DBService.getOperacion(); 
			
			//Tipo Operaciones para mostrar todos
			TipoOperaciones to = new TipoOperaciones();
			  to.setId_operacion(77);
			  to.setDescripcion("GLOBAL");
			  ltop.add(to);
			  
			  numOper = 77; //asigno modo global;
				
			 getBusquedaTotal(); //Llamar a funcion de detalles la original pero en version global; 
				 
	 }
	 catch (Exception e) 
	 {
		 context.addMessage(null, new FacesMessage("Importante",  "Error al traer registros Contabilizados" ) ); 
		 logger.info("Error en busqueda Detalle contabilizados " , e );
			e.printStackTrace();
	 }
		
	}
	
	public void muestraMalos(BitaTotal bt)
	{
		isTotal = false; 
		isMalos = true; //se enciende detalles malos NO Contabilizados
		isDetalle = false; 
		isBtnReturn = true; //se enciende boton
		isFechaIF = false;
 		
		FacesContext context = FacesContext.getCurrentInstance();
		logger.info("Inicia Detalle malos " );
		
		 cleanList(lMalos); 
		 cleanList(lMalosFiltro); 
		
		try
		{
			List<String> bb = new ArrayList<String>(); 
			 
			 bb.add(bt.getFecha());  
			 
			lMalos = DBService.funBitaDetalleMalos(bb) ; 
		}
		catch (Exception e) 
		{
			 context.addMessage(null, new FacesMessage("Importante",  "Error al traer registros NO Contabilizados" ) ); 
			 logger.info("Error en busqueda Detalle malos " , e );
				e.printStackTrace();
		}
		
		logger.info("Fin Detalle malos con " + lMalos.size() + " registros" );
	}
	
	public void regresaTotales()
	{
		isTotal = true; //se enciende principal
		isMalos = false;
		isDetalle = false;
		isBtnReturn = false; //se apaga boton 
		isFechaIF = true;
	 
		System.out.println("Regresar a Totales");
	}
	
	 
	
	private void cleanList(List<?> list)
	{
		try
		{
			if(!list.isEmpty()) 
				list.clear(); 
		}
		catch (Exception e) 
		{
			logger.info("Error en limpiar lista " , e );
		}
	}
	
	public void getBusquedaTotal()
	{ 
		FacesContext context = FacesContext.getCurrentInstance();
		 System.out.println("tipo Operacion " + numOper);
		 try
		 { 
			if( fechaT == null || fechaF == null || numOper <= 0)
			{
				context.addMessage(null, new FacesMessage("Importante",  "Debe seleccionar dos fechas de busqueda y el tipo de Operacion" ) ); 
			}
			else
			{
				Format formatter = new SimpleDateFormat("dd/MM/yyyy");
				Format formatter2 = new SimpleDateFormat("dd/MM/yyyy");
				 
				List<String> bb = new ArrayList<String>();
				 
				 
				cleanList(lTotalBit);
				cleanList(lTotalBitFiltro);
				 cargoT1 = null;
				 abonoT1 = null;
				
				 bb.add("null");  
				 bb.add("null"); 
				 
				 bb.add( formatter.format( fechaTDetalles ));
				 bb.add( formatter2.format( fechaFDetalles ));
				 
				if( numOper == 77 )
				{
					for(Integer con = 1; con <= 5; con++)
					{
						 bb.add( 4,con.toString());
						 
						 List<TotalBitacora> ltb = new ArrayList<TotalBitacora>();
						 
						 ltb = DBService.funBitaTotal(bb);
						 
						 Integer cont = ltb.size();
						 
						 
						 
						 
						 if( cont > 1 )
						 {
							 for (int i = 1; i <ltb.size(); i++) 
							 {
								 lTotalBit.add(ltb.get(i));
							 }
						 }
					}
					
					for (TotalBitacora tb : lTotalBit) 
					{
						
					}
					 cargoT1 = null;
					 abonoT1 = null;
				}
				else
				{ 
					
					 bb.add(numOper.toString());
					 
					 List<TotalBitacora> ltb = new ArrayList<TotalBitacora>();
					 
					 ltb = DBService.funBitaTotal(bb);
					 
					 Integer cont = ltb.size();
					 
					 if( cont > 1 )
					 {
						 cargoT1 = ltb.get(0).getCargos();
						 abonoT1 = ltb.get(0).getAbonos();
						 
						 for (int i = 1; i <ltb.size(); i++) 
						 {
							 lTotalBit.add(ltb.get(i));
						 }
					 }
				}
				 
			}
		 }  
		 catch (Exception e) 
		 {
			 context.addMessage(null, new FacesMessage("Importante",  "No se logro extraer la consulta contabilizados." ) ); 
			 logger.info("Error en busqueda Total " , e );
				e.printStackTrace();
		 } 
	}
	
	public void getBusquedaIndv(TotalBitacora tb)
	{ 
		FacesContext context = FacesContext.getCurrentInstance();
		
		try
		{
			cleanList(lBit);
			
			numPolIndv = tb.getPolizaContable();
			
			buscaBita.setpCveCia(tb.getCompania());
			buscaBita.setpAno(tb.getAnio());
			buscaBita.setpMes(tb.getMes());
			buscaBita.setpPolCont(tb.getPolizaContable());
			buscaBita.setpTipPol(tb.getTipoDePoliza());
			buscaBita.setpOperacion(tb.getOperacion());
			buscaBita.setpEstatus(2);
	 
			     java.sql.Date d = java.sql.Date.valueOf(tb.getFechaDelaPoliza());
				 Format formatter = new SimpleDateFormat("dd/MM/yyyy");
				 
				buscaBita.setpFecPol(formatter.format(d).toString() ); 
				List<Bitacora> lb = new ArrayList<Bitacora>();
				
				 lb = DBService.funBitacora(buscaBita);
				 
				 Integer cont = lb.size();
				 
				 if(cont > 1)
				 {
					 cargoT2 = lb.get(0).getCargo();
					 abonoT2 = lb.get(0).getAbono();
					 
					 for (int i = 1; i < lb.size(); i++) 
					 {
						 lBit.add( lb.get(i));
					 }
					 
				 }
				 
		 
		}
		catch (Exception e) 
		{
			logger.info("Error al llenar subtabla Detalle " ,e );
			e.printStackTrace();
		}

	}
	
	
	/* GETTERS - SETTERS */

	public List<Bitacora> getlBit() {
		return lBit;
	}

	public void setlBit(List<Bitacora> lBit) {
		this.lBit = lBit;
	}

	public List<Bitacora> getlBitFiltro() {
		return lBitFiltro;
	}

	public void setlBitFiltro(List<Bitacora> lBitFiltro) {
		this.lBitFiltro = lBitFiltro;
	}

	public IDBService getDBService() {
		return DBService;
	}

	public void setDBService(IDBService DBService) {
		this.DBService = DBService;
	}



	public BuscaBita getBuscaBita() {
		return buscaBita;
	}



	public void setBuscaBita(BuscaBita buscaBita) {
		this.buscaBita = buscaBita;
	}



	public java.util.Date getFechaBusqueda() {
		return fechaBusqueda;
	}



	public void setFechaBusqueda(java.util.Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}



	public List<TotalBitacora> getlTotalBit() {
		return lTotalBit;
	}



	public void setlTotalBit(List<TotalBitacora> lTotalBit) {
		this.lTotalBit = lTotalBit;
	}



	public List<TotalBitacora> getlTotalBitFiltro() {
		return lTotalBitFiltro;
	}



	public void setlTotalBitFiltro(List<TotalBitacora> lTotalBitFiltro) {
		this.lTotalBitFiltro = lTotalBitFiltro;
	}



	public Integer getCompaniaT() {
		return companiaT;
	}



	public void setCompaniaT(Integer companiaT) {
		this.companiaT = companiaT;
	}



	public Integer getPolizaT() {
		return polizaT;
	}



	public void setPolizaT(Integer polizaT) {
		this.polizaT = polizaT;
	}



	public java.util.Date getFechaT() {
		return fechaT;
	}



	public void setFechaT(java.util.Date fechaT) {
		this.fechaT = fechaT;
	}



	public Integer getNumPolIndv() {
		return numPolIndv;
	}



	public void setNumPolIndv(Integer numPolIndv) {
		this.numPolIndv = numPolIndv;
	}



	public TotalBitacora getTotalbuscaBita() {
		return TotalbuscaBita;
	}



	public void setTotalbuscaBita(TotalBitacora totalbuscaBita) {
		TotalbuscaBita = totalbuscaBita;
	}



	public Double getCargoT1() {
		return cargoT1;
	}



	public void setCargoT1(Double cargoT1) {
		this.cargoT1 = cargoT1;
	}



	public Double getAbonoT1() {
		return abonoT1;
	}



	public void setAbonoT1(Double abonoT1) {
		this.abonoT1 = abonoT1;
	}



	public java.util.Date getFechaF() {
		return fechaF;
	}



	public void setFechaF(java.util.Date fechaF) {
		this.fechaF = fechaF;
	}



	public Double getCargoT2() {
		return cargoT2;
	}



	public void setCargoT2(Double cargoT2) {
		this.cargoT2 = cargoT2;
	}



	public Double getAbonoT2() {
		return abonoT2;
	}



	public void setAbonoT2(Double abonoT2) {
		this.abonoT2 = abonoT2;
	}



	public List<TipoOperaciones> getLtop() {
		return ltop;
	}



	public void setLtop(List<TipoOperaciones> ltb) {
		this.ltop = ltb;
	}



	public Integer getNumOper() {
		return numOper;
	}



	public void setNumOper(Integer numOper) {
		this.numOper = numOper;
	}



	public Boolean getIsTotal() {
		return isTotal;
	}



	public Boolean getIsDetalle() {
		return isDetalle;
	}



	public void setIsTotal(Boolean isTotal) {
		this.isTotal = isTotal;
	}



	public void setIsDetalle(Boolean isDetalle) {
		this.isDetalle = isDetalle;
	}



	public Boolean getIsMalos() {
		return isMalos;
	}



	public void setIsMalos(Boolean isMalos) {
		this.isMalos = isMalos;
	}



	public List<BitaMalos> getlMalos() {
		return lMalos;
	}



	public List<BitaMalos> getlMalosFiltro() {
		return lMalosFiltro;
	}



	public void setlMalos(List<BitaMalos> lMalos) {
		this.lMalos = lMalos;
	}



	public void setlMalosFiltro(List<BitaMalos> lMalosFiltro) {
		this.lMalosFiltro = lMalosFiltro;
	}



	public List<BitaTotal> getlTotales() {
		return lTotales;
	}



	public List<BitaTotal> getlTotalesFiltro() {
		return lTotalesFiltro;
	}



	public void setlTotales(List<BitaTotal> lTotales) {
		this.lTotales = lTotales;
	}



	public void setlTotalesFiltro(List<BitaTotal> lTotalesFiltro) {
		this.lTotalesFiltro = lTotalesFiltro;
	}

	public Boolean getIsBtnReturn() {
		return isBtnReturn;
	}

	public void setIsBtnReturn(Boolean isBtnReturn) {
		this.isBtnReturn = isBtnReturn;
	}

	public java.util.Date getFechaTDetalles() {
		return fechaTDetalles;
	}

	public java.util.Date getFechaFDetalles() {
		return fechaFDetalles;
	}

	public void setFechaTDetalles(java.util.Date fechaTDetalles) {
		this.fechaTDetalles = fechaTDetalles;
	}

	public void setFechaFDetalles(java.util.Date fechaFDetalles) {
		this.fechaFDetalles = fechaFDetalles;
	}

	public Boolean getIsFechaIF() {
		return isFechaIF;
	}

	public void setIsFechaIF(Boolean isFechaIF) {
		this.isFechaIF = isFechaIF;
	}
	
	
	
	
	
	
	 
}
