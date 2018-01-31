package medico.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedi.model.entities.ModmedConsultaMedica;
import fedi.model.manager.ManagerMedico;
import fedi.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerMedico {
	
	private List<ModmedConsultaMedica> lista;
	
	@EJB
private ManagerMedico managerMedico;
	
	private Integer codConsulta;
	private String estado;
	private String notaMedica;
	private String diagnostico;
	private Integer diasrepos;
	private Date fechaSolicutudConsula;
	private Date fechaRealizaConsulata;
	
	public ControllerMedico() {
		// TODO Auto-generated constructor stub
	}
	public void iniciar() {
		System.out.println("inicio...");
	}
	public String actionInsertarConsultaMedica() {
		ModmedConsultaMedica p = new ModmedConsultaMedica();
		//p.setCodConsulta(codConsulta);
		p.setEstado(estado);
		p.setNotaMedica(notaMedica);
		p.setDiagnostico(diagnostico);
		p.setDiasrepos(diasrepos);
		p.setFechaSolicutudConsula(fechaSolicutudConsula);;
		p.setFechaRealizaConsulata(fechaRealizaConsulata);
		
		try {
			managerMedico.insertarTipoConsultaMedica(p);
			// limpiamos las variables del formulario:
			//codConsulta = 0;
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
	
	
	public List<ModmedConsultaMedica> getLista() {
		lista = managerMedico.findAllModfinConsultaMedica();
		return lista;
	}
	
	public ManagerMedico getManagerMedico() {
		return managerMedico;
	}
	public void setManagerMedico(ManagerMedico managerMedico) {
		this.managerMedico = managerMedico;
	}
	public Integer getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(Integer codConsulta) {
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
	public Integer getDiasrepos() {
		return diasrepos;
	}
	public void setDiasrepos(Integer diasrepos) {
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
