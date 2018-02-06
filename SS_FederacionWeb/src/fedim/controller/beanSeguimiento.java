package fedim.controller;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;



import fedim.model.entities.Deportista;

import fedim.model.entities.Test;
import fedim.model.entities.SeguimientodepCab;
import fedim.model.manager.ManagerSeguimiento;
import fedim.model.manager.ManagerDAO;
@ManagedBean
@SessionScoped
public class beanSeguimiento {
private String cedulaDeportista;
@EJB
private ManagerSeguimiento managersegui;

private Integer codigoTest;
private Integer cantidadTest;
private SeguimientodepCab seguiCabTmp;
private boolean seguiCabTmpGuardada;


public beanSeguimiento() {
	
}


/**
 * Action para la creacion de una factura temporal en memoria.
 * Hace uso del componente {@link facturacion.model.manager.ManagerFacturacion ManagerFacturacion} de la capa model.
 * @return outcome para la navegacion.
 */
public String crearNuevaSeguimiento(){
	seguiCabTmp=managersegui.crearSeguimientoTmp();
	cedulaDeportista=null;
	codigoTest=0;
	cantidadTest=0;
	seguiCabTmpGuardada=false;
	return "";
}
/**
 * Action para asignar un cliente a la factura temporal actual.
 * Hace uso del componente {@link facturacion.model.manager.ManagerFacturacion ManagerFacturacion} de la capa model.
 * @return outcome para la navegacion.
 */
public void asignarDeportista(){
	if(seguiCabTmpGuardada==true){
		JSFUtil.crearMensajeWARN("El seguimiento ya fue guardada.");
	}
	try {
	managersegui.asignarDeportistaSeguimientoTmp(seguiCabTmp, cedulaDeportista);	 
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
	}
}

/*public void verificarExistencia(){
	try {
		if(managerFacturacion.obtenerExistencia(codigoProducto)==0)
			JSFUtil.crearMensajeERROR("No hay existencia");
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
}/*

/**
 * Action que adiciona un item a una factura temporal.
 * Hace uso del componente {@link model.manager.ManagerFacturacion ManagerFacturacion} de la capa model.
 * @return
 */
public String insertarDetalleTest(){
	if( seguiCabTmpGuardada==true){
		JSFUtil.crearMensajeWARN("el seguimiento ya fue guardada.");
		return "";
	}
	try {
	managersegui.agregarDetalleSeguimientoTmp(seguiCabTmp, codigoTest, cantidadTest);	
		codigoTest=0;
		cantidadTest=0;
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
	}		
	return "";
}

/**
 * Action que almacena en la base de datos una factura temporal creada en memoria.
 * Hace uso del componente {@link facturacion.model.manager.ManagerFacturacion ManagerFacturacion} de la capa model.
 * @return outcome para la navegacion.
 */
public String guardarSeguimiento(){
	if(seguiCabTmpGuardada==true){
		JSFUtil.crearMensajeWARN("El seguimiento ya fue guardada.");
		return "";
	}
	try {
managersegui.guardarSeguimientoTemporal(seguiCabTmp);	  	
		seguiCabTmpGuardada=true;
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
	}
	
	return "";
}



/**
 * Devuelve un listado de componentes SelectItem a partir
 * de un listado de {@link facturacion.model.dao.entities.Cliente Cliente}.
 * @return listado de SelectItems de clientes.
 */
public List<SelectItem> getListaDeportistaSI(){
	List<SelectItem> listadoSI=new ArrayList<SelectItem>();
	List<Deportista> listadoDeportista= managersegui.findAllDeportista();  
	
	for(Deportista c:listadoDeportista){
		SelectItem item=new SelectItem(c.getCedulaDeportista(), 
				                   c.getApellidos()+" "+c.getNombres());
		listadoSI.add(item);
	}
	return listadoSI;
}
public List<SelectItem> getListaDeportistaMe(){
	List<SelectItem> listadoMe=new ArrayList<SelectItem>();
	List<Deportista> listadoDeportista= managersegui.findAllDeportista();  
	
	for(Deportista c:listadoDeportista){
		SelectItem item=new SelectItem(c.getCedulaDeportista(), 
				                   c.getApellidos()+" "+c.getNombres());
		listadoMe.add(item);
	}
	return listadoMe;
}


/**
 * Devuelve un listado de componentes SelectItem a partir
 * de un listado de {@link facturacion.model.dao.entities.Producto Producto}.
 * 
 * @return listado de SelectItems de productos.
 */
public List<SelectItem> getListaTestSI(){
	List<SelectItem> listadoSI=new ArrayList<SelectItem>();
	List<Test> listadoTest=managersegui.findAllTest();
	
	for(Test p:listadoTest){
		SelectItem item=new SelectItem(p.getCodigoTest(), 
				                   p.getNombretest());
		listadoSI.add(item);
	}
	return listadoSI;
}


public String getCedulaDeportista() {
	return cedulaDeportista;
}


public void setCedulaDeportista(String cedulaDeportista) {
	this.cedulaDeportista = cedulaDeportista;
}


public Integer getCodigoTest() {
	return codigoTest;
}


public void setCodigoTest(Integer codigoTest) {
	this.codigoTest = codigoTest;
}


public Integer getCantidadTest() {
	return cantidadTest;
}


public void setCantidadTest(Integer cantidadTest) {
	this.cantidadTest = cantidadTest;
}


public SeguimientodepCab getSeguiCabTmp() {
	return seguiCabTmp;
}


public void setSeguiCabTmp(SeguimientodepCab seguiCabTmp) {
	this.seguiCabTmp = seguiCabTmp;
}


public List<SeguimientodepCab> getListaSeguimientodepCab(){
	List<SeguimientodepCab> listadosegui=managersegui.findAllSeguimientoCab();
	return listadosegui;
}


public boolean isSeguiCabTmpGuardada() {
	return seguiCabTmpGuardada;
}


public void setSeguiCabTmpGuardada(boolean seguiCabTmpGuardada) {
	this.seguiCabTmpGuardada = seguiCabTmpGuardada;
}





}
