package fedi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import fedi.view.util.JSFUtil;
import fedi.model.entities.ModadDeportista;
import fedi.model.entities.ModdepRegistroRendimiento;
import fedi.model.manager.ManagerEntrenador;

@ManagedBean
@SessionScoped
public class ControllerSegJug {
	private List<ModadDeportista> listdep;

	private Integer cedDep;
	private String nombres;
	private String apellidos;
	private String categoria;
	private String sexo;
	private Boolean estado;

	public List<ModadDeportista> getListdep() {
		return listdep;
	}

	public void setListdep(List<ModadDeportista> listdep) {
		this.listdep = listdep;
	}

	public Integer getCedDep() {
		return cedDep;
	}

	public void setCedDep(Integer cedDep) {
		this.cedDep = cedDep;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@EJB
	private ManagerEntrenador managerdep;

	@PostConstruct

	public void actionListenerCargar(ModadDeportista dep) {
		cedDep = dep.getCedulaDep();
		nombres = dep.getNombresDep();
		apellidos = dep.getApellidosDep();
		categoria = dep.getModadCategoria().getNombreCate();
		sexo = dep.getSexoDep();
		estado = dep.getEstadoDep();

	}
	
	
	public void actionListenerActualizarDepxced(Integer ced) {
		   try {           
	
			   listdep=managerdep.findDepByCed(ced) ;
		         
			   JSFUtil.crearMensajeInfo("Actualización correcta.");        
			   } catch (Exception e) {          
				   JSFUtil.crearMensajeError(e.getMessage());     
				   e.printStackTrace();     
				   }   
		   }  
	
	
	
	
	
	
	

	public List<SelectItem> getListaJugadoresSI() {
		List<SelectItem> listadoSI = new ArrayList<SelectItem>();
		List<ModadDeportista> listadodep = managerdep.findAllDeportistas();

		for (ModadDeportista c : listadodep) {
			SelectItem item = new SelectItem(c.getCedulaDep(), c.getApellidosDep() + " " + c.getNombresDep());
			listadoSI.add(item);
		}
		return listadoSI;
	}
	
	
	
	
	////////////////////___________MODADrendimiento Registro Rendimeinto______________//////////////////
	

	
	
	
	
	
	
	
	
}
