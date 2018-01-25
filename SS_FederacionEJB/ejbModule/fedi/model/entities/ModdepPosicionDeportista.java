package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the moddep_posicion_deportista database table.
 * 
 */
@Entity
@Table(name="moddep_posicion_deportista")
@NamedQuery(name="ModdepPosicionDeportista.findAll", query="SELECT m FROM ModdepPosicionDeportista m")
public class ModdepPosicionDeportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODDEP_POSICION_DEPORTISTA_CODPOSICION_GENERATOR", sequenceName="SEQ_MODDEP_POSICION_DEPORTISTA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODDEP_POSICION_DEPORTISTA_CODPOSICION_GENERATOR")
	@Column(name="cod_posicion", unique=true, nullable=false)
	private Integer codPosicion;

	@Column(length=500)
	private String descripcion;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-one association to ModadUsuario
	@ManyToOne
	@JoinColumn(name="cedula_us")
	private ModadUsuario modadUsuario;

	//bi-directional many-to-one association to ModdepTest
	@ManyToOne
	@JoinColumn(name="cod_test")
	private ModdepTest moddepTest;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="moddepPosicionDeportista")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	public ModdepPosicionDeportista() {
	}

	public Integer getCodPosicion() {
		return this.codPosicion;
	}

	public void setCodPosicion(Integer codPosicion) {
		this.codPosicion = codPosicion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ModadUsuario getModadUsuario() {
		return this.modadUsuario;
	}

	public void setModadUsuario(ModadUsuario modadUsuario) {
		this.modadUsuario = modadUsuario;
	}

	public ModdepTest getModdepTest() {
		return this.moddepTest;
	}

	public void setModdepTest(ModdepTest moddepTest) {
		this.moddepTest = moddepTest;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepPosicionDeportista(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepPosicionDeportista(null);

		return moddepRegistroRendimiento;
	}

}