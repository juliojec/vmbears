package br.com.vmbears.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="regiao")
public class Regiao { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_regiao")
	private Integer idRegiao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_geracao")
	public Geracao geracao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_compra")
	public Compra compra;
	
	@XmlAttribute
	public String sigla;
	
	@ManyToOne
	@JoinColumn(name = "id_agente")
	@JsonIgnore
	private Agente agente;
	
	public Geracao getGeracao() {
		return geracao;
	}
	
	public void setGeracao(Geracao geracao) {
		this.geracao = geracao;
	}
	
	public Compra getCompra() {
		return compra;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Integer idRegiao) {
		this.idRegiao = idRegiao;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	@Override
	public String toString() {
		return "Regiao [geracao=" + geracao + ", compra=" + compra + ", sigla=" + sigla + ", agente=" + agente + "]";
	}
	
}
