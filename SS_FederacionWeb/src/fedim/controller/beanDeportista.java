package fedim.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.model.entities.Deportista;
import fedim.model.entities.Test;
import fedim.model.manager.ManagerSeguimiento;
@ManagedBean
@SessionScoped
public class beanDeportista {
private List<Deportista> listadep;
@EJB
private ManagerSeguimiento managersegui;

private String ceduladeportista;
private String nombres;
private String apellidos;
private String direccion;
private String categoria;
private String posisionjugador;
private String clave;
private Boolean estado;


public beanDeportista() {
	
	
}




public String actionInsertarDeportista(){
	Deportista p= new Deportista();
	p.setCedulaDeportista(ceduladeportista);
	p.setNombres(nombres); 
	p.setApellidos(apellidos);
	p.setDireccion(direccion);
	p.setCategoria(categoria);
	p.setPosisionjug(posisionjugador);

	try {
		managersegui.insertarDepb(p);;
		ceduladeportista="";
		nombres="";
		apellidos="";
		direccion="";
		categoria="";
		posisionjugador="";
		estado=true;
		clave="";
	
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
	
}
public String actionEliminarDeportista(Deportista dep){
	try {
	managersegui.eliminarDeportista(dep.getCedulaDeportista());	
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
}
public String actionCargarDeportista(Deportista dep){
	ceduladeportista=dep.getCedulaDeportista();
	nombres=dep.getNombres();
	apellidos=dep.getApellidos();
direccion=dep.getDireccion();
	categoria= dep.getCategoria();
	posisionjugador= dep.getPosisionjug();
	estado=dep.getEstadojug();
	
	return "jugador_update";
}
public String actionActualizarDeportista(){
	Deportista p=new Deportista();
	p.setCedulaDeportista(ceduladeportista);

	p.setNombres(nombres); 
	p.setApellidos(apellidos);
	p.setDireccion(direccion);
	p.setCategoria(categoria);
	p.setPosisionjug(posisionjugador);

	try {
	managersegui.actualizarDeportista(p);
		//limpiamos las variables del formulario:
	ceduladeportista="";
	nombres="";
	apellidos="";
	direccion="";
	categoria="";
	posisionjugador="";
	estado=true;
	clave="";
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "registrojugador";
}














public List<Deportista> getListadep() {
	listadep=managersegui.findAllDeportista();
	return listadep;
}

public String getCeduladeportista() {
	return ceduladeportista;
}
public void setCeduladeportista(String ceduladeportista) {
	this.ceduladeportista = ceduladeportista;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String getPosisionjugador() {
	return posisionjugador;
}
public void setPosisionjugador(String posisionjugador) {
	this.posisionjugador = posisionjugador;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public Boolean getEstado() {
	return estado;
}
public void setEstado(Boolean estado) {
	this.estado = estado;
}

}
