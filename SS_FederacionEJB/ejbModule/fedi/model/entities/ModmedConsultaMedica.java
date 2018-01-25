package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modmed_consulta_medica database table.
 * 
 */
@Entity
@Table(name="modmed_consulta_medica")
@NamedQuery(name="ModmedConsultaMedica.findAll", query="SELECT m FROM ModmedConsultaMedica m")
public class ModmedConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODMED_CONSULTA_MEDICA_CODCONSULTA_GENERATOR", sequenceName="SEQ_MODMED_CONSULTA_MEDICA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODMED_CONSULTA_MEDICA_CODCONSULTA_GENERATOR")
	@Column(name="cod_consulta", unique=true, nullable=false)
	private Integer codConsulta;

	@Column(length=500)
	private String diagnostico;

	private Integer diasrepos;

	@Column(length=5)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_realiza_consulata")
	private Date fechaRealizaConsulata;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicutud_consula")
	private Date fechaSolicutudConsula;

	@Column(name="nota_medica", length=500)
	private String notaMedica;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumn(name="cedula_dep")
	private ModadDeportista modadDeportista;

	//bi-directional many-to-one association to ModadUsuario
	@ManyToOne
	@JoinColumn(name="cedula_us")
	private ModadUsuario modadUsuario;

	public ModmedConsultaMedica() {
	}

	public Integer getCodConsulta() {
		return this.codConsulta;
	}

	public void setCodConsulta(Integer codConsulta) {
		this.codConsulta = codConsulta;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Integer getDiasrepos() {
		return this.diasrepos;
	}

	public void setDiasrepos(Integer diasrepos) {
		this.diasrepos = diasrepos;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRealizaConsulata() {
		return this.fechaRealizaConsulata;
	}

	public void setFechaRealizaConsulata(Date fechaRealizaConsulata) {
		this.fechaRealizaConsulata = fechaRealizaConsulata;
	}

	public Date getFechaSolicutudConsula() {
		return this.fechaSolicutudConsula;
	}

	public void setFechaSolicutudConsula(Date fechaSolicutudConsula) {
		this.fechaSolicutudConsula = fechaSolicutudConsula;
	}

	public String getNotaMedica() {
		return this.notaMedica;
	}

	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

	public ModadUsuario getModadUsuario() {
		return this.modadUsuario;
	}

	public void setModadUsuario(ModadUsuario modadUsuario) {
		this.modadUsuario = modadUsuario;
	}

}