package br.com.vmbears.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="compra")
public class Compra { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_compra")
	private Integer idCompra;
	
	@ElementCollection
	@Column(name="valor")
	public List<Double> valor;

	public List<Double> getValor() {
		return valor;
	}

	public void setValor(List<Double> valor) {
		this.valor = valor;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	
	
}
