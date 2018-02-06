package fedim.controadmin;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.model.entities.LugarEntrenamientoDepor;
import fedim.model.entities.Test;
import fedim.model.manager.ManagerAdmin;

@ManagedBean
@SessionScoped
public class beanlugar {
	private List<LugarEntrenamientoDepor> listalug;
	@EJB
	private ManagerAdmin manageradmin;

	private String codLugar;
	private String nombre;
	private String direccion;
	private String descripcion;
	public beanlugar() {

	}

	public String actionInsertarLugar() {
		LugarEntrenamientoDepor p = new LugarEntrenamientoDepor();
		p.setCodLugar(codLugar);
		p.setNombre(nombre);
		p.setDireccion(direccion);
		p.setDescripcion(descripcion);

		try {
			manageradmin.insertarlug(p);
			;
			codLugar="";
			nombre="";
			direccion="";
			descripcion="";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";

	}

	public String actionEliminarLugar(LugarEntrenamientoDepor dep) {
		try {
			manageradmin.eliminarDeportista(dep.getCodLugar());
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public String actionCargarLugar(LugarEntrenamientoDepor dep) {
		codLugar=dep.getCodLugar();
		nombre=dep.getNombre();
		direccion=dep.getDireccion();
		descripcion=dep.getDescripcion();

		return "jugador_update";
	}

	public String actionActualizarLugar() {
		LugarEntrenamientoDepor p = new LugarEntrenamientoDepor();
		p.setCodLugar(codLugar);
		p.setNombre(nombre);
		p.setDireccion(direccion);
		p.setDescripcion(descripcion);
		try {
			manageradmin.actualizarLugar(p);
			// limpiamos las variables del formulario:
			codLugar="";
			nombre="";
			direccion="";
			descripcion="";
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "registrojugador";
	}



	public List<LugarEntrenamientoDepor> getListalug() {
		listalug = manageradmin.findAllLugar();
		return listalug;
	}

	


}
