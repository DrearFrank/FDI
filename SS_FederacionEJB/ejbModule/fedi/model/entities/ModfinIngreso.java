package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modfin_ingreso database table.
 * 
 */
@Entity
@Table(name="modfin_ingreso")
@NamedQuery(name="ModfinIngreso.findAll", query="SELECT m FROM ModfinIngreso m")
public class ModfinIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODFIN_INGRESO_CODINGRESOS_GENERATOR", sequenceName="SEQ_MODFIN_INGRESO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODFIN_INGRESO_CODINGRESOS_GENERATOR")
	@Column(name="cod_ingresos", unique=true, nullable=false)
	private Integer codIngresos;

	@Column(length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double valor;

	//bi-directional many-to-one association to ModfinDetalleIngreso
	@ManyToOne
	@JoinColumn(name="cod_deta_ingreso")
	private ModfinDetalleIngreso modfinDetalleIngreso;

	public ModfinIngreso() {
	}

	public Integer getCodIngresos() {
		return this.codIngresos;
	}

	public void setCodIngresos(Integer codIngresos) {
		this.codIngresos = codIngresos;
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

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ModfinDetalleIngreso getModfinDetalleIngreso() {
		return this.modfinDetalleIngreso;
	}

	public void setModfinDetalleIngreso(ModfinDetalleIngreso modfinDetalleIngreso) {
		this.modfinDetalleIngreso = modfinDetalleIngreso;
	}

}