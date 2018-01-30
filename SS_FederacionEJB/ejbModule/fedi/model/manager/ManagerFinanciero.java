package fedi.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fedi.model.manager.ManagerDAO;
import fedi.model.entities.ModfinTipoEgreso;

/**
 * Session Bean implementation class ManagerFinanciero
 */
@Stateless
@LocalBean
public class ManagerFinanciero {
	@EJB
	private ManagerDAO managerDAO;

	public ManagerFinanciero() {
		// TODO Auto-generated constructor stub
	}

	// MANEJO DE PRODUCTOS:


	/**
	 * Metodo finder para consulta de productos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @return listado de Productos ordenados por nombre.
	 */
	@SuppressWarnings("unchecked")
	public List<ModfinTipoEgreso> findAllModfinTipoEgreso() {
		return managerDAO.findAll(ModfinTipoEgreso.class, "o.nombre");
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
	public ModfinTipoEgreso findModfinTipoEgresoById(Integer codTipoEgreso) throws Exception {
		return (ModfinTipoEgreso) managerDAO.findById(ModfinTipoEgreso.class, codTipoEgreso);
	}

	/**
	 * Guarda un nuevo producto en la base de datos. Hace uso del componente
	 * {@link facturacion.model.manager.ManagerDAO ManagerDAO} de la capa model.
	 * 
	 * @param p
	 *            El nuevo producto.
	 * @throws Exception
	 */
	public void insertarTipoEgreso(ModfinTipoEgreso p) throws Exception {
		managerDAO.insertar(p);
	}
}
