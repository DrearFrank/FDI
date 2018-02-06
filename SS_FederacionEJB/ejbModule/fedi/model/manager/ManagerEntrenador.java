package fedi.model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fedi.model.entities.ModadDeportista;
import fedi.model.entities.ModdepRegistroRendimiento;

import fedi.model.entities.ModdepTest;

/**
 * Session Bean implementation class ManagerEntrenador
 */
@Stateless
@LocalBean
public class ManagerEntrenador {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="fediDS")
	private EntityManager emd;
    public ManagerEntrenador() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    ////////_______________DEPORTISTAS___________________////////////
    
	public List<ModadDeportista> findAllDeportistas() {
		Query q;
		List<ModadDeportista> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM ModadDeportista o ORDER BY o.cedulaDep";
		q = emd.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}	 
	 public List<ModadDeportista> findDepByCed(Integer idced){
	 String JPQL="SELECT o FROM ModadDeportista o WHERE o.modad_deportista.cedDep='"+idced+"'";
	 Query q;
	 List<ModadDeportista> lista;
	 q=emd.createQuery(JPQL);
	 lista=q.getResultList();
	 return lista;
	 }
	 
	 
	 
	///////////////__________SEGUIMIENTO DEPORTISTA____________________///////////////////////
	 
	 


	 
	 
	 
	 
	 
	 
///////////////__________POSISICON DEPORTISTA____________________///////////////////////
	 

	 
	 
///////////////__________ TEST DEPORTISTA____________________///////////////////////
	 
	 
	 
		public List<ModdepTest> findAllTests() {
			Query q;
			List<ModdepTest> listadotest;
			String sentenciaSQL;
			sentenciaSQL = "SELECT o FROM ModdepTest o ORDER BY o.codTest";
			q = emd.createQuery(sentenciaSQL);
			listadotest = q.getResultList();
			return listadotest;
		}
		
		
		
	public void agregarTest(Integer codTest, Integer peso ,Integer altura,Integer abdominales,Integer cardio, Integer velocidad,Integer redimiento, String posision) throws Exception {
		
		ModdepTest a = new ModdepTest();
			a.setCodTest(codTest);
			a.setPesoTest(peso);
			a.setAlturaTest(altura);
			a.setAbdominalesMinTest(abdominales);
			a.setCardioMinTest(cardio);
			a.setVelocidadTest(velocidad);
			a.setRendimientoFisicoTest(redimiento);
			a.setPosisionJug(posision);;
			emd.persist(a);
		}
		
		
		
		
		public int sumaTest() {
			List<ModdepTest> lista = findAllTests();
			int suma = 0;
			for (ModdepTest a : lista) {
				suma = a.getAbdominalesMinTest()+a.getAlturaTest()+a.getCardioMinTest()+a.getVelocidadTest()+a.getPesoTest();
			}
			return suma;
		}
	 
}


