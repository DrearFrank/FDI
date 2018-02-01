package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_lugar_entrenamiento_depor database table.
 * 
 */
@Entity
@Table(name="modad_lugar_entrenamiento_depor")
@NamedQuery(name="ModadLugarEntrenamientoDepor.findAll", query="SELECT m FROM ModadLugarEntrenamientoDepor m")
public class ModadLugarEntrenamientoDepor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODAD_LUGAR_ENTRENAMIENTO_DEPOR_CODLUGAR_GENERATOR", sequenceName="SEQ_MODAD_LUGAR_ENTRENAMIENTO_DEPOR",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODAD_LUGAR_ENTRENAMIENTO_DEPOR_CODLUGAR_GENERATOR")
	@Column(name="cod_lugar", unique=true, nullable=false)
	private Integer codLugar;

	@Column(length=100)
	private String descripcion;

	@Column(length=100)
	private String direccion;

	@Column(length=20)
	private String nombre;

	public ModadLugarEntrenamientoDepor() {
	}

	public Integer getCodLugar() {
		return this.codLugar;
	}

	public void setCodLugar(Integer codLugar) {
		this.codLugar = codLugar;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}