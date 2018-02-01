package fedi.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import fedi.model.manager.ManagerDAO;
import fedi.model.util.ModelUtil;
import fedi.model.entities.ModadUsuario;
import fedi.model.entities.ModadCategoria;
import fedi.model.entities.ModadHorario;
import fedi.model.entities.ModadLugarEntrenamientoDepor;
import fedi.model.entities.ModadRole;


/**
 * Session Bean implementation class ManagerAdministrador
 */
@Stateless
@LocalBean
public class ManagerAdministrador {
	@EJB
	private ManagerDAO managerDAO;

	
	public ManagerAdministrador() {
	
	}
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////// MANAGER CATEGORIA////////////////////////////
/////////////////////////////////////////////////////////////////////////////
	/**
	 * Metodo finder para consulta de productos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @return listado de Productos ordenados por nombre.
	 */
	@SuppressWarnings("unchecked")
	public List<ModadCategoria> findAllModadCategoria() {
		return managerDAO.findAll(ModadCategoria.class, "o.codCate");
	}
	/**
	 * Metodo finder para consulta de productos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @param codigoProducto
	 *            codigo del producto que se desea buscar.
	 * @return el producto encontrado.
	 * @throws Exception
	 */
	public ModadCategoria findModadCategoriaById(Integer codCate) throws Exception {
		return (ModadCategoria) managerDAO.findById(ModadCategoria.class, codCate);
	}
	
	/**
	 * Guarda un nuevo producto en la base de datos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @param p
	 *            El nuevo producto.
	 * @throws Exception
	 */

	public void insertarCategoria(ModadCategoria p) throws Exception {
		managerDAO.insertar(p);
	}
///////////////////////////////////////////////////////////////////
////////////////////// MANAGER HORARIO ////////////////////////////
///////////////////////////////////////////////////////////////////
	/**
	 * Metodo finder para consulta de productos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @return listado de Productos ordenados por nombre.
	 */
	@SuppressWarnings("unchecked")
	public List<ModadHorario> findAllModadHorario() {
		return managerDAO.findAll(ModadHorario.class, "o.codHorario");
	}
	/**
	 * Metodo finder para consulta de productos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @param codigoProducto
	 *            codigo del producto que se desea buscar.
	 * @return el producto encontrado.
	 * @throws Exception
	 */
	public ModadHorario findModadHorarioById(Integer codHorario) throws Exception {
		return (ModadHorario) managerDAO.findById(ModadHorario.class, codHorario);
	}
	
	/**
	 * Guarda un nuevo producto en la base de datos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @param p
	 *            El nuevo producto.
	 * @throws Exception
	 */

	public void insertarHorario(ModadHorario p) throws Exception {
		managerDAO.insertar(p);
	}
	
////////////////////////////////////////////////////////////////////////////////
//////////////////////MANAGER LUGAR DE ENTRENAMIENTO ///////////////////////////
////////////////////////////////////////////////////////////////////////////////
/**
* Metodo finder para consulta de productos. Hace uso del componente
* {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
* 
* @return listado de Productos ordenados por nombre.
*/
@SuppressWarnings("unchecked")
public List<ModadLugarEntrenamientoDepor> findAllModadLugarEntrenamientoDepor() {
return managerDAO.findAll(ModadLugarEntrenamientoDepor.class, "o.codLugar");
}
/**
* Metodo finder para consulta de productos. Hace uso del componente
* {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
* 
* @param codigoProducto
*            codigo del producto que se desea buscar.
* @return el producto encontrado.
* @throws Exception
*/
public ModadLugarEntrenamientoDepor findModadLugarEntrenamientoDeporById(Integer codLugar) throws Exception {
return (ModadLugarEntrenamientoDepor) managerDAO.findById(ModadLugarEntrenamientoDepor.class, codLugar);
}

/**
* Guarda un nuevo producto en la base de datos. Hace uso del componente
* {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
* 
* @param p
*            El nuevo producto.
* @throws Exception
*/

public void insertarLugar(ModadLugarEntrenamientoDepor p) throws Exception {
managerDAO.insertar(p);
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////MANAGER USUARIO /////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

private EntityManager em;

public ModadUsuario findUsuarioById(String cedulaUs) {
	ModadUsuario u = em.find(ModadUsuario.class, cedulaUs);
	return u;
}


public void registrarUsuario(Integer cedulaUs, String apellidosUs, String contrasenaUs, String confirmacioncontrasenaUs,
		String correoElecUs, String direccionUs, Boolean estado, String fechaNacUs,
		String lugarNacUs, String nombresUs, String sexoUs,
		String telefonoUs, ModadRole modadRole)  
		throws Exception{ 
	if(ModelUtil.isEmpty(Integer.toBinaryString(cedulaUs)))
		throw new Exception("Debe especificar Cedula.");
	//verificamos la contraseña:
	if(ModelUtil.isEmpty(contrasenaUs))
		throw new Exception("Debe especificar una clave.");
	if(!contrasenaUs.equals(confirmacioncontrasenaUs))
		throw new Exception("No coinciden la clave y la confirmación.");
	//verificamos correo:
	if(ModelUtil.isEmpty(correoElecUs))
		throw new Exception("Debe especificar un correo válido.");
	//TODO: tambien validar el formato del correo 
	//Verificar la existencia del usuario:
	ModadUsuario u= findUsuarioById(Integer.toString(cedulaUs));
	if(u!=null)
		throw new Exception("Ya existe un usuario "+cedulaUs);
	//finalmente se puede guardar el nuevo usuario:
	u=new ModadUsuario(); 
	u.setCedulaUs(cedulaUs);
	u.setApellidosUs(apellidosUs);
	u.setContrasenaUs(contrasenaUs);
	u.setCorreoElecUs(correoElecUs);
	u.setDireccionUs(direccionUs);
	u.setEstado(estado);
	u.setFechaNacUs(fechaNacUs);
	u.setLugarNacUs(lugarNacUs);
	u.setNombresUs(nombresUs);
	u.setSexoUs(sexoUs);
	u.setTelefonoUs(telefonoUs);
	u.setModadRole(modadRole);
	em.persist(u); 
	}
}
