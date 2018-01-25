package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modfin_tipo_egreso database table.
 * 
 */
@Entity
@Table(name="modfin_tipo_egreso")
@NamedQuery(name="ModfinTipoEgreso.findAll", query="SELECT m FROM ModfinTipoEgreso m")
public class ModfinTipoEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODFIN_TIPO_EGRESO_CODTIPOEGRESO_GENERATOR", sequenceName="SEQ_MODFIN_TIPO_EGRESO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODFIN_TIPO_EGRESO_CODTIPOEGRESO_GENERATOR")
	@Column(name="cod_tipo_egreso", unique=true, nullable=false)
	private Integer codTipoEgreso;

	@Column(length=100)
	private String descripcion;

	@Column(length=30)
	private String nombre;

	//bi-directional many-to-one association to ModfinEgreso
	@OneToMany(mappedBy="modfinTipoEgreso")
	private List<ModfinEgreso> modfinEgresos;

	public ModfinTipoEgreso() {
	}

	public Integer getCodTipoEgreso() {
		return this.codTipoEgreso;
	}

	public void setCodTipoEgreso(Integer codTipoEgreso) {
		this.codTipoEgreso = codTipoEgreso;
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

	public List<ModfinEgreso> getModfinEgresos() {
		return this.modfinEgresos;
	}

	public void setModfinEgresos(List<ModfinEgreso> modfinEgresos) {
		this.modfinEgresos = modfinEgresos;
	}

	public ModfinEgreso addModfinEgreso(ModfinEgreso modfinEgreso) {
		getModfinEgresos().add(modfinEgreso);
		modfinEgreso.setModfinTipoEgreso(this);

		return modfinEgreso;
	}

	public ModfinEgreso removeModfinEgreso(ModfinEgreso modfinEgreso) {
		getModfinEgresos().remove(modfinEgreso);
		modfinEgreso.setModfinTipoEgreso(null);

		return modfinEgreso;
	}

}