package admin.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import fedi.model.manager.ManagerAdministrador;
import fedi.view.util.JSFUtil;
import fedi.model.entities.ModadLugarEntrenamientoDepor;

@ManagedBean
@SessionScoped
public class ControllerLugar {


	private List<ModadLugarEntrenamientoDepor>lista;
	
	@EJB
	
	private ManagerAdministrador manageradminitrador;
	
	private Integer codLugar;
	private String nombre;
	private String direccion;
	private String descripcion;
	
	
	public ControllerLugar() {
		// TODO Auto-generated constructor stub
	}
	
	public void iniciar() {
		System.out.println("inicio...");
	}

	public String actionInsertarLugar() {
		ModadLugarEntrenamientoDepor p= new ModadLugarEntrenamientoDepor();
		
		p.setNombre(nombre);
		p.setDireccion(direccion);
		p.setDescripcion(descripcion);
		try {
			manageradminitrador.insertarLugar(p);
			// limpiamos las variables del formulario:
			//codCate = 0;
			nombre = "";
			direccion="";
			descripcion = "";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}


	public List<ModadLugarEntrenamientoDepor> getLista() {
		return lista;
	}


	public void setLista(List<ModadLugarEntrenamientoDepor> lista) {
		this.lista = lista;
	}

	public ManagerAdministrador getManageradminitrador() {
		return manageradminitrador;
	}

	public void setManageradminitrador(ManagerAdministrador manageradminitrador) {
		this.manageradminitrador = manageradminitrador;
	}
	public Integer getCodLugar() {
		return codLugar;
	}

	public void setCodLugar(Integer codLugar) {
		this.codLugar = codLugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
