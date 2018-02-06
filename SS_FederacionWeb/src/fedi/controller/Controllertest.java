package fedi.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedi.view.util.JSFUtil;
import fedi.model.entities.ModadRole;
import fedi.model.entities.ModdepTest;
import fedi.model.manager.ManagerEntrenador;

@ManagedBean
@SessionScoped
public class Controllertest {

	
	private Integer codTest;
	private Integer abdomxmin;
	private Integer altura;
	private Integer cardioxmintes;
	private Integer pesotest;
	private Integer velocidad;
	private Integer rendimeintotest;
	private String Posision;
	
	private List<ModdepTest> listest;
	
	
	public Integer getCodTest() {
		return codTest;
	}

	public void setCodTest(Integer codTest) {
		this.codTest = codTest;
	}

	public Integer getAbdomxmin() {
		return abdomxmin;
	}

	public void setAbdomxmin(Integer abdomxmin) {
		this.abdomxmin = abdomxmin;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getCardioxmintes() {
		return cardioxmintes;
	}

	public void setCardioxmintes(Integer cardioxmintes) {
		this.cardioxmintes = cardioxmintes;
	}

	public Integer getPesotest() {
		return pesotest;
	}

	public void setPesotest(Integer pesotest) {
		this.pesotest = pesotest;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getRendimeintotest() {
		return rendimeintotest;
	}

	public void setRendimeintotest(Integer rendimeintotest) {
		this.rendimeintotest = rendimeintotest;
	}

	public String getPosision() {
		return Posision;
	}

	public void setPosision(String posision) {
		Posision = posision;
	}

	public List<ModdepTest> getListest() {
		return listest;
	}

	public void setListest(List<ModdepTest> listest) {
		this.listest = listest;
	}

	@EJB
	private ManagerEntrenador managertest;
	@PostConstruct

	public void iniciar() {

		listest = managertest.findAllTests();
	
			
		

	}

	public void actionListenerReset() {

		listest = managertest.findAllTests();
	}
	
	
	public void actionListenerAgregaTest() {
		try {
	managertest.agregarTest(codTest, pesotest, altura, abdomxmin, cardioxmintes, velocidad, rendimeintotest, Posision);	
			listest =  managertest.findAllTests();
		
			JSFUtil.crearMensajeInfo("Indice registrado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}
	

}
