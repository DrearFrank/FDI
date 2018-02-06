package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modfin_detalle_pago_jugador database table.
 * 
 */
@Entity
@Table(name="modfin_detalle_pago_jugador")
@NamedQuery(name="ModfinDetallePagoJugador.findAll", query="SELECT m FROM ModfinDetallePagoJugador m")
public class ModfinDetallePagoJugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODFIN_DETALLE_PAGO_JUGADOR_CODDETALLEREGRESO_GENERATOR", sequenceName="SEQ_MODFIN_DETALLE_PAGO_JUGADOR",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODFIN_DETALLE_PAGO_JUGADOR_CODDETALLEREGRESO_GENERATOR")
	@Column(name="cod_detaller_egreso", unique=true, nullable=false)
	private Integer codDetallerEgreso;

	private Integer descuentos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="mes_pago")
	private Date mesPago;

	@Column(length=100)
	private String observacion;

	@Column(name="pago_total")
	private double pagoTotal;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumn(name="cedula_dep")
	private ModadDeportista modadDeportista;

	public ModfinDetallePagoJugador() {
	}

	public Integer getCodDetallerEgreso() {
		return this.codDetallerEgreso;
	}

	public void setCodDetallerEgreso(Integer codDetallerEgreso) {
		this.codDetallerEgreso = codDetallerEgreso;
	}

	public Integer getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(Integer descuentos) {
		this.descuentos = descuentos;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getMesPago() {
		return this.mesPago;
	}

	public void setMesPago(Date mesPago) {
		this.mesPago = mesPago;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getPagoTotal() {
		return this.pagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

}