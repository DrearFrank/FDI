package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the modad_usuario database table.
 * 
 */
@Entity
@Table(name="modad_usuario")
@NamedQuery(name="ModadUsuario.findAll", query="SELECT m FROM ModadUsuario m")
public class ModadUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula_us", unique=true, nullable=false)
	private Integer cedulaUs;

	@Column(name="apellidos_us", length=50)
	private String apellidosUs;

	@Column(name="contrasena_us", nullable=false, length=50)
	private String contrasenaUs;

	@Column(name="correo_elec_us", length=100)
	private String correoElecUs;

	@Column(name="direccion_us", length=100)
	private String direccionUs;

	@Column(name="estado_us")
	private Boolean estadoUs;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac_us")
	private Date fechaNacUs;

	@Column(name="lugar_nac_us", length=20)
	private String lugarNacUs;

	@Column(name="nombres_us", length=50)
	private String nombresUs;

	@Column(name="sexo_us", length=1)
	private String sexoUs;

	@Column(name="telefono_us", length=100)
	private String telefonoUs;

	//bi-directional many-to-one association to ModadRole
	@ManyToOne
	@JoinColumn(name="cod_roles")
	private ModadRole modadRole;

	//bi-directional many-to-one association to ModfinDetallePagoUsuario
	@OneToMany(mappedBy="modadUsuario")
	private List<ModfinDetallePagoUsuario> modfinDetallePagoUsuarios;

	//bi-directional many-to-one association to ModmedConsultaMedica
	@OneToMany(mappedBy="modadUsuario")
	private List<ModmedConsultaMedica> modmedConsultaMedicas;

	public ModadUsuario() {
	}

	public Integer getCedulaUs() {
		return this.cedulaUs;
	}

	public void setCedulaUs(Integer cedulaUs) {
		this.cedulaUs = cedulaUs;
	}

	public String getApellidosUs() {
		return this.apellidosUs;
	}

	public void setApellidosUs(String apellidosUs) {
		this.apellidosUs = apellidosUs;
	}

	public String getContrasenaUs() {
		return this.contrasenaUs;
	}

	public void setContrasenaUs(String contrasenaUs) {
		this.contrasenaUs = contrasenaUs;
	}

	public String getCorreoElecUs() {
		return this.correoElecUs;
	}

	public void setCorreoElecUs(String correoElecUs) {
		this.correoElecUs = correoElecUs;
	}

	public String getDireccionUs() {
		return this.direccionUs;
	}

	public void setDireccionUs(String direccionUs) {
		this.direccionUs = direccionUs;
	}

	public Boolean getEstadoUs() {
		return this.estadoUs;
	}

	public void setEstadoUs(Boolean estadoUs) {
		this.estadoUs = estadoUs;
	}

	public Date getFechaNacUs() {
		return this.fechaNacUs;
	}

	public void setFechaNacUs(Date fechaNacUs) {
		this.fechaNacUs = fechaNacUs;
	}

	public String getLugarNacUs() {
		return this.lugarNacUs;
	}

	public void setLugarNacUs(String lugarNacUs) {
		this.lugarNacUs = lugarNacUs;
	}

	public String getNombresUs() {
		return this.nombresUs;
	}

	public void setNombresUs(String nombresUs) {
		this.nombresUs = nombresUs;
	}

	public String getSexoUs() {
		return this.sexoUs;
	}

	public void setSexoUs(String sexoUs) {
		this.sexoUs = sexoUs;
	}

	public String getTelefonoUs() {
		return this.telefonoUs;
	}

	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}

	public ModadRole getModadRole() {
		return this.modadRole;
	}

	public void setModadRole(ModadRole modadRole) {
		this.modadRole = modadRole;
	}

	public List<ModfinDetallePagoUsuario> getModfinDetallePagoUsuarios() {
		return this.modfinDetallePagoUsuarios;
	}

	public void setModfinDetallePagoUsuarios(List<ModfinDetallePagoUsuario> modfinDetallePagoUsuarios) {
		this.modfinDetallePagoUsuarios = modfinDetallePagoUsuarios;
	}

	public ModfinDetallePagoUsuario addModfinDetallePagoUsuario(ModfinDetallePagoUsuario modfinDetallePagoUsuario) {
		getModfinDetallePagoUsuarios().add(modfinDetallePagoUsuario);
		modfinDetallePagoUsuario.setModadUsuario(this);

		return modfinDetallePagoUsuario;
	}

	public ModfinDetallePagoUsuario removeModfinDetallePagoUsuario(ModfinDetallePagoUsuario modfinDetallePagoUsuario) {
		getModfinDetallePagoUsuarios().remove(modfinDetallePagoUsuario);
		modfinDetallePagoUsuario.setModadUsuario(null);

		return modfinDetallePagoUsuario;
	}

	public List<ModmedConsultaMedica> getModmedConsultaMedicas() {
		return this.modmedConsultaMedicas;
	}

	public void setModmedConsultaMedicas(List<ModmedConsultaMedica> modmedConsultaMedicas) {
		this.modmedConsultaMedicas = modmedConsultaMedicas;
	}

	public ModmedConsultaMedica addModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().add(modmedConsultaMedica);
		modmedConsultaMedica.setModadUsuario(this);

		return modmedConsultaMedica;
	}

	public ModmedConsultaMedica removeModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().remove(modmedConsultaMedica);
		modmedConsultaMedica.setModadUsuario(null);

		return modmedConsultaMedica;
	}

}