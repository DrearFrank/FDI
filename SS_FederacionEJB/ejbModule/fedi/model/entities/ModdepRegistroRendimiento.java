package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the moddep_registro_rendimiento database table.
 * 
 */
@Entity
@Table(name="moddep_registro_rendimiento")
@NamedQuery(name="ModdepRegistroRendimiento.findAll", query="SELECT m FROM ModdepRegistroRendimiento m")
public class ModdepRegistroRendimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODDEP_REGISTRO_RENDIMIENTO_CODREGISTRO_GENERATOR", sequenceName="SEQ_MODDEP_REGISTRO_RENDIMIENTO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODDEP_REGISTRO_RENDIMIENTO_CODREGISTRO_GENERATOR")
	@Column(name="cod_registro", unique=true, nullable=false)
	private Integer codRegistro;

	@Column(name="estado_dep", length=100)
	private String estadoDep;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_observacion_dep")
	private Date fechaObservacionDep;

	@Column(name="observacion_dep", length=100)
	private String observacionDep;

	@Column(name="rendimiento_fisico_dep", length=100)
	private String rendimientoFisicoDep;

	@Column(name="sancion_dep")
	private Integer sancionDep;

	//bi-directional many-to-one association to ModadCategoria
	@ManyToOne
	@JoinColumn(name="cod_cate")
	private ModadCategoria modadCategoria;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumn(name="cedula_dep")
	private ModadDeportista modadDeportista;

	//bi-directional many-to-one association to ModdepPosicionDeportista
	@ManyToOne
	@JoinColumn(name="cod_posicion")
	private ModdepPosicionDeportista moddepPosicionDeportista;

	//bi-directional many-to-one association to ModdepTest
	@ManyToOne
	@JoinColumn(name="cod_test")
	private ModdepTest moddepTest;

	public ModdepRegistroRendimiento() {
	}

	public Integer getCodRegistro() {
		return this.codRegistro;
	}

	public void setCodRegistro(Integer codRegistro) {
		this.codRegistro = codRegistro;
	}

	public String getEstadoDep() {
		return this.estadoDep;
	}

	public void setEstadoDep(String estadoDep) {
		this.estadoDep = estadoDep;
	}

	public Date getFechaObservacionDep() {
		return this.fechaObservacionDep;
	}

	public void setFechaObservacionDep(Date fechaObservacionDep) {
		this.fechaObservacionDep = fechaObservacionDep;
	}

	public String getObservacionDep() {
		return this.observacionDep;
	}

	public void setObservacionDep(String observacionDep) {
		this.observacionDep = observacionDep;
	}

	public String getRendimientoFisicoDep() {
		return this.rendimientoFisicoDep;
	}

	public void setRendimientoFisicoDep(String rendimientoFisicoDep) {
		this.rendimientoFisicoDep = rendimientoFisicoDep;
	}

	public Integer getSancionDep() {
		return this.sancionDep;
	}

	public void setSancionDep(Integer sancionDep) {
		this.sancionDep = sancionDep;
	}

	public ModadCategoria getModadCategoria() {
		return this.modadCategoria;
	}

	public void setModadCategoria(ModadCategoria modadCategoria) {
		this.modadCategoria = modadCategoria;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

	public ModdepPosicionDeportista getModdepPosicionDeportista() {
		return this.moddepPosicionDeportista;
	}

	public void setModdepPosicionDeportista(ModdepPosicionDeportista moddepPosicionDeportista) {
		this.moddepPosicionDeportista = moddepPosicionDeportista;
	}

	public ModdepTest getModdepTest() {
		return this.moddepTest;
	}

	public void setModdepTest(ModdepTest moddepTest) {
		this.moddepTest = moddepTest;
	}

}