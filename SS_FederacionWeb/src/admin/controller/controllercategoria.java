package admin.controller;

	import java.util.List;
	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;
	import fedi.model.entities.ModadCategoria;
	import fedi.model.manager.ManagerAdministrador;
	import fedi.view.util.JSFUtil;
	@ManagedBean
	@SessionScoped
	public class controllercategoria {
	 
		private List<ModadCategoria>lista;
		
		@EJB
		
		private ManagerAdministrador manageradminitrador;
		
		private Integer codCate;
		private String nombre;
		private String descripcion;
		
		public controllercategoria() {
			
		
		}
		
		public void iniciar() {
			System.out.println("inicio...");
		}

		public String actionInsertarCategoria() {
			ModadCategoria p= new ModadCategoria();
			
			p.setNombreCate(nombre);
			p.setDescripcionCate(descripcion);
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


		public Integer getCodCate() {
			return codCate;
		}

		public void setCodCate(Integer codCate) {
			this.codCate = codCate;
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
