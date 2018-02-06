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

	@Column(length=5)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_consulata")
	private Date fechaConsulata;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicutud")
	private Date fechaSolicutud;

	@Column(name="nota_medica", length=500)
	private String notaMedica;

	@Column(length=2)
	private String resposp;

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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaConsulata() {
		return this.fechaConsulata;
	}

	public void setFechaConsulata(Date fechaConsulata) {
		this.fechaConsulata = fechaConsulata;
	}

	public Date getFechaSolicutud() {
		return this.fechaSolicutud;
	}

	public void setFechaSolicutud(Date fechaSolicutud) {
		this.fechaSolicutud = fechaSolicutud;
	}

	public String getNotaMedica() {
		return this.notaMedica;
	}

	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}

	public String getResposp() {
		return this.resposp;
	}

	public void setResposp(String resposp) {
		this.resposp = resposp;
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