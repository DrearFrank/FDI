package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modfin_egresos database table.
 * 
 */
@Entity
@Table(name="modfin_egresos")
@NamedQuery(name="ModfinEgreso.findAll", query="SELECT m FROM ModfinEgreso m")
public class ModfinEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODFIN_EGRESOS_CODEGRESOS_GENERATOR", sequenceName="SEQ_MODFIN_EGRESOS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODFIN_EGRESOS_CODEGRESOS_GENERATOR")
	@Column(name="cod_egresos", unique=true, nullable=false)
	private Integer codEgresos;

	@Column(length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer valor;

	//bi-directional many-to-one association to ModfinTipoEgreso
	@ManyToOne
	@JoinColumn(name="cod_tipo_egreso")
	private ModfinTipoEgreso modfinTipoEgreso;

	public ModfinEgreso() {
	}

	public Integer getCodEgresos() {
		return this.codEgresos;
	}

	public void setCodEgresos(Integer codEgresos) {
		this.codEgresos = codEgresos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public ModfinTipoEgreso getModfinTipoEgreso() {
		return this.modfinTipoEgreso;
	}

	public void setModfinTipoEgreso(ModfinTipoEgreso modfinTipoEgreso) {
		this.modfinTipoEgreso = modfinTipoEgreso;
	}

}