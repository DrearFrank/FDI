package fedi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the moddep_test database table.
 * 
 */
@Entity
@Table(name="moddep_test")
@NamedQuery(name="ModdepTest.findAll", query="SELECT m FROM ModdepTest m")
public class ModdepTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODDEP_TEST_CODTEST_GENERATOR", sequenceName="SEQ_MODDEP_TEST",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODDEP_TEST_CODTEST_GENERATOR")
	@Column(name="cod_test", unique=true, nullable=false)
	private Integer codTest;

	@Column(name="abdominales_min_test")
	private Integer abdominalesMinTest;

	@Column(name="altura_test")
	private Integer alturaTest;

	@Column(name="cardio_min_test")
	private Integer cardioMinTest;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_tet")
	private Date fechaTet;

	@Column(name="peso_test")
	private Integer pesoTest;

	@Column(name="posision_jug", length=50)
	private String posisionJug;

	@Column(name="rendimiento_fisico_test")
	private Integer rendimientoFisicoTest;

	@Column(name="velocidad_test")
	private Integer velocidadTest;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="moddepTest")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	public ModdepTest() {
	}

	public Integer getCodTest() {
		return this.codTest;
	}

	public void setCodTest(Integer codTest) {
		this.codTest = codTest;
	}

	public Integer getAbdominalesMinTest() {
		return this.abdominalesMinTest;
	}

	public void setAbdominalesMinTest(Integer abdominalesMinTest) {
		this.abdominalesMinTest = abdominalesMinTest;
	}

	public Integer getAlturaTest() {
		return this.alturaTest;
	}

	public void setAlturaTest(Integer alturaTest) {
		this.alturaTest = alturaTest;
	}

	public Integer getCardioMinTest() {
		return this.cardioMinTest;
	}

	public void setCardioMinTest(Integer cardioMinTest) {
		this.cardioMinTest = cardioMinTest;
	}

	public Date getFechaTet() {
		return this.fechaTet;
	}

	public void setFechaTet(Date fechaTet) {
		this.fechaTet = fechaTet;
	}

	public Integer getPesoTest() {
		return this.pesoTest;
	}

	public void setPesoTest(Integer pesoTest) {
		this.pesoTest = pesoTest;
	}

	public String getPosisionJug() {
		return this.posisionJug;
	}

	public void setPosisionJug(String posisionJug) {
		this.posisionJug = posisionJug;
	}

	public Integer getRendimientoFisicoTest() {
		return this.rendimientoFisicoTest;
	}

	public void setRendimientoFisicoTest(Integer rendimientoFisicoTest) {
		this.rendimientoFisicoTest = rendimientoFisicoTest;
	}

	public Integer getVelocidadTest() {
		return this.velocidadTest;
	}

	public void setVelocidadTest(Integer velocidadTest) {
		this.velocidadTest = velocidadTest;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}


}