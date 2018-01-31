package fedi.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedi.model.manager.ManagerAdministrador;
import fedi.model.entities.ModadRole;

@ManagedBean
@SessionScoped
public class ControllerRol {

	private List<ModadRole> listrol;

	private Integer codRoles;
	private String nombrerol;
	private String descripcionrol;

	@EJB
	private ManagerAdministrador managerol;

	@PostConstruct

	public void iniciar() {

		listrol = managerol.findAllRoles();
	}

	public void actionListenerReset() {

		listrol = managerol.findAllRoles();
	}

	public void actionListenerCargar(ModadRole rol) {
		codRoles = rol.getCodRoles();
		nombrerol = rol.getNombreRoles();
		descripcionrol = rol.getDescripcionRoles();
	}

	public List<ModadRole> getListrol() {
		return listrol;
	}

	public void setListrol(List<ModadRole> listrol) {
		this.listrol = listrol;
	}

	public Integer getCodRoles() {
		return codRoles;
	}

	public void setCodRoles(Integer codRoles) {
		this.codRoles = codRoles;
	}

	public String getNombrerol() {
		return nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	public String getDescripcionrol() {
		return descripcionrol;
	}

	public void setDescripcionrol(String descripcionrol) {
		this.descripcionrol = descripcionrol;
	}



}
