package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_deportista database table.
 * 
 */
@Entity
@Table(name="modad_deportista")
@NamedQuery(name="ModadDeportista.findAll", query="SELECT m FROM ModadDeportista m")
public class ModadDeportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula_dep", unique=true, nullable=false)
	private Integer cedulaDep;

	@Column(name="apellidos_dep", nullable=false, length=50)
	private String apellidosDep;

	@Column(name="contrasena_dep", length=50)
	private String contrasenaDep;

	@Column(name="correo_elec_dep", length=100)
	private String correoElecDep;

	@Column(name="direccion_dep", length=100)
	private String direccionDep;

	private Boolean estado;

	@Column(name="fecha_nac_dep", length=20)
	private String fechaNacDep;

	@Column(name="lugar_nac_dep", length=20)
	private String lugarNacDep;

	@Column(name="nombres_dep", nullable=false, length=50)
	private String nombresDep;

	@Column(name="sexo_dep", nullable=false, length=1)
	private String sexoDep;

	@Column(name="telefono_dep", nullable=false, length=100)
	private String telefonoDep;

	//bi-directional many-to-one association to ModadCategoria
	@ManyToOne
	@JoinColumn(name="cod_cate", nullable=false)
	private ModadCategoria modadCategoria;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="modadDeportista")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	//bi-directional many-to-one association to ModfinDetallePagoDeportista
	@OneToMany(mappedBy="modadDeportista")
	private List<ModfinDetallePagoDeportista> modfinDetallePagoDeportistas;

	//bi-directional many-to-one association to ModmedConsultaMedica
	@OneToMany(mappedBy="modadDeportista")
	private List<ModmedConsultaMedica> modmedConsultaMedicas;

	public ModadDeportista() {
	}

	public Integer getCedulaDep() {
		return this.cedulaDep;
	}

	public void setCedulaDep(Integer cedulaDep) {
		this.cedulaDep = cedulaDep;
	}

	public String getApellidosDep() {
		return this.apellidosDep;
	}

	public void setApellidosDep(String apellidosDep) {
		this.apellidosDep = apellidosDep;
	}

	public String getContrasenaDep() {
		return this.contrasenaDep;
	}

	public void setContrasenaDep(String contrasenaDep) {
		this.contrasenaDep = contrasenaDep;
	}

	public String getCorreoElecDep() {
		return this.correoElecDep;
	}

	public void setCorreoElecDep(String correoElecDep) {
		this.correoElecDep = correoElecDep;
	}

	public String getDireccionDep() {
		return this.direccionDep;
	}

	public void setDireccionDep(String direccionDep) {
		this.direccionDep = direccionDep;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFechaNacDep() {
		return this.fechaNacDep;
	}

	public void setFechaNacDep(String fechaNacDep) {
		this.fechaNacDep = fechaNacDep;
	}

	public String getLugarNacDep() {
		return this.lugarNacDep;
	}

	public void setLugarNacDep(String lugarNacDep) {
		this.lugarNacDep = lugarNacDep;
	}

	public String getNombresDep() {
		return this.nombresDep;
	}

	public void setNombresDep(String nombresDep) {
		this.nombresDep = nombresDep;
	}

	public String getSexoDep() {
		return this.sexoDep;
	}

	public void setSexoDep(String sexoDep) {
		this.sexoDep = sexoDep;
	}

	public String getTelefonoDep() {
		return this.telefonoDep;
	}

	public void setTelefonoDep(String telefonoDep) {
		this.telefonoDep = telefonoDep;
	}

	public ModadCategoria getModadCategoria() {
		return this.modadCategoria;
	}

	public void setModadCategoria(ModadCategoria modadCategoria) {
		this.modadCategoria = modadCategoria;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadDeportista(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadDeportista(null);

		return moddepRegistroRendimiento;
	}

	public List<ModfinDetallePagoDeportista> getModfinDetallePagoDeportistas() {
		return this.modfinDetallePagoDeportistas;
	}

	public void setModfinDetallePagoDeportistas(List<ModfinDetallePagoDeportista> modfinDetallePagoDeportistas) {
		this.modfinDetallePagoDeportistas = modfinDetallePagoDeportistas;
	}

	public ModfinDetallePagoDeportista addModfinDetallePagoDeportista(ModfinDetallePagoDeportista modfinDetallePagoDeportista) {
		getModfinDetallePagoDeportistas().add(modfinDetallePagoDeportista);
		modfinDetallePagoDeportista.setModadDeportista(this);

		return modfinDetallePagoDeportista;
	}

	public ModfinDetallePagoDeportista removeModfinDetallePagoDeportista(ModfinDetallePagoDeportista modfinDetallePagoDeportista) {
		getModfinDetallePagoDeportistas().remove(modfinDetallePagoDeportista);
		modfinDetallePagoDeportista.setModadDeportista(null);

		return modfinDetallePagoDeportista;
	}

	public List<ModmedConsultaMedica> getModmedConsultaMedicas() {
		return this.modmedConsultaMedicas;
	}

	public void setModmedConsultaMedicas(List<ModmedConsultaMedica> modmedConsultaMedicas) {
		this.modmedConsultaMedicas = modmedConsultaMedicas;
	}

	public ModmedConsultaMedica addModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().add(modmedConsultaMedica);
		modmedConsultaMedica.setModadDeportista(this);

		return modmedConsultaMedica;
	}

	public ModmedConsultaMedica removeModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().remove(modmedConsultaMedica);
		modmedConsultaMedica.setModadDeportista(null);

		return modmedConsultaMedica;
	}

}