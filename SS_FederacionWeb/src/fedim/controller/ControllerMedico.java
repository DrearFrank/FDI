package fedim.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.model.entities.ConsultaMedica;
import fedim.model.entities.Deportista;
import fedim.model.manager.ManagerMedico;
import fedim.controller.JSFUtil;
import fedim.model.manager.ManagerSeguimiento;


@ManagedBean
@SessionScoped
public class ControllerMedico {
	
	private List<ConsultaMedica> lista;
	
	@EJB
private ManagerMedico managerMedico;
	
	private String codConsulta;
	private String cedulaDeportista;
	private String estado;
	private String notaMedica;
	private String diagnostico;
	private String diasrepos;
	private Date fechaSolicutudConsula;
	private Date fechaRealizaConsulata;
	
	public ControllerMedico() {
		// TODO Auto-generated constructor stub
	}
	public void iniciar() {
		System.out.println("inicio...");
	}
	public String actionInsertarConsultaMedica() {
		ConsultaMedica p = new ConsultaMedica();
		p.setCodConsulta(codConsulta);
		Deportista d= new  Deportista();
		d.setCedulaDeportista(cedulaDeportista);
		p.setEstado(estado);
		p.setNotaMedica(notaMedica);
		p.setDiagnostico(diagnostico);
		p.setDiasrepos(diasrepos);
		p.setFechaSolicutudConsula(fechaSolicutudConsula);;
		p.setFechaRealizaConsulata(fechaRealizaConsulata);
		
		try {
			managerMedico.insertarTipoConsultaMedica(p);
			// limpiamos las variables del formulario:
			codConsulta = "";
			cedulaDeportista = "";
			estado = "";
			notaMedica = "";
			diagnostico = "";
			fechaSolicutudConsula = new Date();
			fechaRealizaConsulata = new Date();
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
		
	}
	public String actionEliminarCitaMedica(ConsultaMedica con) {
		try {
			managerMedico.eliminarCitaMedica(con.getCodConsulta());
			
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	//Actualizamos cita medica
	public String actionCargarCitaMedica(ConsultaMedica cita) {
		codConsulta=cita.getCodConsulta();
		estado=cita.getEstado();
		notaMedica=cita.getNotaMedica();
		diagnostico=cita.getDiagnostico();
		diasrepos=cita.getDiasrepos();
		fechaSolicutudConsula=cita.getFechaSolicutudConsula();
		fechaRealizaConsulata=cita.getFechaRealizaConsulata();
		return "citaMedica_update";
	}
	public String actionActulizarCitaMedica() {
		ConsultaMedica p=new ConsultaMedica();
		p.setCodConsulta(codConsulta);
		p.setEstado(estado);
		p.setNotaMedica(notaMedica);
		p.setDiagnostico(diagnostico);
		p.setDiasrepos(diasrepos);
		p.setFechaSolicutudConsula(fechaSolicutudConsula);
		p.setFechaRealizaConsulata(fechaRealizaConsulata);
		
		try {
			managerMedico.actualizarCitaMedico(p);
			//limpiar las variables del formulario
			codConsulta = "";
			cedulaDeportista = "";
			estado = "";
			notaMedica = "";
			diagnostico = "";
			fechaSolicutudConsula = new Date();
			fechaRealizaConsulata = new Date();
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "index";
		
	}
	
	public List<ConsultaMedica> getLista() {
		lista = managerMedico.findAllModfinConsultaMedica();
		return lista;
	}
	
	public ManagerMedico getManagerMedico() {
		return managerMedico;
	}
	public void setManagerMedico(ManagerMedico managerMedico) {
		this.managerMedico = managerMedico;
	}
	public String getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(String codConsulta) {
		this.codConsulta = codConsulta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNotaMedica() {
		return notaMedica;
	}
	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDiasrepos() {
		return diasrepos;
	}
	
	public String getCedulaDeportista() {
		return cedulaDeportista;
	}
	public void setCedulaDeportista(String cedulaDeportista) {
		this.cedulaDeportista = cedulaDeportista;
	}
	public void setDiasrepos(String diasrepos) {
		this.diasrepos = diasrepos;
	}
	public Date getFechaSolicutudConsula() {
		return fechaSolicutudConsula;
	}
	public void setFechaSolicutudConsula(Date fechaSolicutudConsula) {
		this.fechaSolicutudConsula = fechaSolicutudConsula;
	}
	public Date getFechaRealizaConsulata() {
		return fechaRealizaConsulata;
	}
	public void setFechaRealizaConsulata(Date fechaRealizaConsulata) {
		this.fechaRealizaConsulata = fechaRealizaConsulata;
	}
	
}
