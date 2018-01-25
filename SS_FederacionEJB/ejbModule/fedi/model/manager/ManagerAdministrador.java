package fedi.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fedi.model.entities.ModadRole;



/**
 * Session Bean implementation class ManagerAdministrador
 */
@Stateless
@LocalBean
public class ManagerAdministrador {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="fediDS")
	private EntityManager em;
    public ManagerAdministrador() {
        // TODO Auto-generated constructor stub
    }
    
	//// -----------------rolesss------------------//////////////

	public List<ModadRole> findAllRoles() {
		Query q;
		List<ModadRole> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM ModadRole o ORDER BY o.codRoles";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}

}
