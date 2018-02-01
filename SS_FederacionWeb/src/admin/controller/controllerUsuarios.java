package admin.controller;

	import java.util.List;
	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;
	import fedi.model.entities.ModadCategoria;
import fedi.model.entities.ModadRole;
import fedi.model.entities.ModadUsuario;
import fedi.model.manager.ManagerAdministrador;
	import fedi.view.util.JSFUtil;
	@ManagedBean
	@SessionScoped
	public class controllerUsuarios {
	 
		private List<ModadCategoria>lista;
		
		@EJB
		
		private ManagerAdministrador manageradminitrador;
		
		Integer cedulaUs;
		String apellidosUs;
		String contrasenaUs;
		String confirmacioncontrasenaUs;
		String correoElecUs;
		String direccionUs; 
		Boolean estado;
		String fechaNacUs;
		String lugarNacUs;
		String nombresUs;
		String sexoUs;
		String telefonoUs;
		ModadRole modadRole;
		
		public Integer getCedulaUs() {
			return cedulaUs;
		}

		public void setCedulaUs(Integer cedulaUs) {
			this.cedulaUs = cedulaUs;
		}

		public String getApellidosUs() {
			return apellidosUs;
		}

		public void setApellidosUs(String apellidosUs) {
			this.apellidosUs = apellidosUs;
		}

		public String getContrasenaUs() {
			return contrasenaUs;
		}

		public void setContrasenaUs(String contrasenaUs) {
			this.contrasenaUs = contrasenaUs;
		}

		public String getConfirmacioncontrasenaUs() {
			return confirmacioncontrasenaUs;
		}

		public void setConfirmacioncontrasenaUs(String confirmacioncontrasenaUs) {
			this.confirmacioncontrasenaUs = confirmacioncontrasenaUs;
		}

		public String getCorreoElecUs() {
			return correoElecUs;
		}

		public void setCorreoElecUs(String correoElecUs) {
			this.correoElecUs = correoElecUs;
		}

		public String getDireccionUs() {
			return direccionUs;
		}

		public void setDireccionUs(String direccionUs) {
			this.direccionUs = direccionUs;
		}

		public Boolean getEstado() {
			return estado;
		}

		public void setEstado(Boolean estado) {
			this.estado = estado;
		}

		public String getFechaNacUs() {
			return fechaNacUs;
		}

		public void setFechaNacUs(String fechaNacUs) {
			this.fechaNacUs = fechaNacUs;
		}

		public String getLugarNacUs() {
			return lugarNacUs;
		}

		public void setLugarNacUs(String lugarNacUs) {
			this.lugarNacUs = lugarNacUs;
		}

		public String getNombresUs() {
			return nombresUs;
		}

		public void setNombresUs(String nombresUs) {
			this.nombresUs = nombresUs;
		}

		public String getSexoUs() {
			return sexoUs;
		}

		public void setSexoUs(String sexoUs) {
			this.sexoUs = sexoUs;
		}

		public String getTelefonoUs() {
			return telefonoUs;
		}

		public void setTelefonoUs(String telefonoUs) {
			this.telefonoUs = telefonoUs;
		}

		public ModadRole getModadRole() {
			return modadRole;
		}

		public void setModadRole(ModadRole modadRole) {
			this.modadRole = modadRole;
		}

		public controllerUsuarios() {
			
		
		}
		
		public void iniciar() {
			System.out.println("inicio...");
		}

		/**		public String actionInsertarUsuario() {
			ModadUsuario p= new ModadUsuario();
			
			p.setCedulaUs(cedulaUs);
			p.setNombresUs(nombresUs);
			p.setApellidosUs(apellidosUs);
			
			try {
				manageradminitrador.insertarCategoria(p);
				// limpiamos las variables del formulario:
				//codCate = 0;
				nombre = "";
				descripcion = "";

			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
			return "";
		}
		*/
		public String actionRegistrarUsuario() {
			try {
				manageradminitrador.registrarUsuario(cedulaUs, apellidosUs, contrasenaUs, confirmacioncontrasenaUs,
						correoElecUs, direccionUs, estado, fechaNacUs, lugarNacUs, nombresUs, sexoUs, telefonoUs, modadRole);
				JSFUtil.crearMensajeINFO("Nuevo blogger registrado.");
				return "blog/index";
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
			return "";
		}
		
		
		public List<ModadCategoria> getLista() {
			return lista;
		}

		public void setLista(List<ModadCategoria> lista) {
			this.lista = lista;
		}

		
		public ManagerAdministrador getManageradminitrador() {
			return manageradminitrador;
		}

		public void setManageradminitrador(ManagerAdministrador manageradminitrador) {
			this.manageradminitrador = manageradminitrador;
		}


	
}
