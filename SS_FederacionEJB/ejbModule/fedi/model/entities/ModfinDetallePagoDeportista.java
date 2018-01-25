package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modfin_detalle_pago_deportista database table.
 * 
 */
@Entity
@Table(name="modfin_detalle_pago_deportista")
@NamedQuery(name="ModfinDetallePagoDeportista.findAll", query="SELECT m FROM ModfinDetallePagoDeportista m")
public class ModfinDetallePagoDeportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODFIN_DETALLE_PAGO_DEPORTISTA_CODDETALLERDEPORTISTA_GENERATOR", sequenceName="SEQ_MODFIN_DETALLE_PAGO_DEPORTISTA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODFIN_DETALLE_PAGO_DEPORTISTA_CODDETALLERDEPORTISTA_GENERATOR")
	@Column(name="cod_detaller_deportista", unique=true, nullable=false)
	private Integer codDetallerDeportista;

	@Column(name="cedula_us")
	private Integer cedulaUs;

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
	private Integer pagoTotal;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumn(name="cedula_dep")
	private ModadDeportista modadDeportista;

	public ModfinDetallePagoDeportista() {
	}

	public Integer getCodDetallerDeportista() {
		return this.codDetallerDeportista;
	}

	public void setCodDetallerDeportista(Integer codDetallerDeportista) {
		this.codDetallerDeportista = codDetallerDeportista;
	}

	public Integer getCedulaUs() {
		return this.cedulaUs;
	}

	public void setCedulaUs(Integer cedulaUs) {
		this.cedulaUs = cedulaUs;
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

	public Integer getPagoTotal() {
		return this.pagoTotal;
	}

	public void setPagoTotal(Integer pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

}