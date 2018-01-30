package fedi.financiero.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fedi.model.entities.ModfinTipoEgreso;
import fedi.view.util.JSFUtil;
import fedi.model.manager.ManagerFinanciero;

@ManagedBean
@SessionScoped
public class FinancieroController {

	private List<ModfinTipoEgreso> lista;
	
	@EJB
	private ManagerFinanciero managerFinanciero;

	private Integer codTipoEgreso;
	private String nombre;
	private String descripcion;

	public FinancieroController() {
		// TODO Auto-generated constructor stub
	}
	public void iniciar() {
		System.out.println("inicio...");
	}

	public String actionInsertarTipoEgreso() {
		ModfinTipoEgreso p = new ModfinTipoEgreso();
		//p.setCodTipoEgreso(codTipoEgreso);
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		try {
			managerFinanciero.insertarTipoEgreso(p);
			// limpiamos las variables del formulario:
			//codTipoEgreso = 0;
			nombre = "";
			descripcion = "";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public List<ModfinTipoEgreso> getLista() {
		return lista;
	}

	public void setLista(List<ModfinTipoEgreso> lista) {
		this.lista = lista;
	}

	public ManagerFinanciero getManagerFinanciero() {
		return managerFinanciero;
	}

	public void setManagerFinanciero(ManagerFinanciero managerFinanciero) {
		this.managerFinanciero = managerFinanciero;
	}


	public Integer getCodTipoEgreso() {
		return codTipoEgreso;
	}
	public void setCodTipoEgreso(Integer codTipoEgreso) {
		this.codTipoEgreso = codTipoEgreso;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
