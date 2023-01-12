package br.com.vmbears.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="agente")
public class Agente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_agente")
	private Integer idAgente;
	
	@ManyToOne
	@JoinColumn(name = "id_agentes")
	@JsonIgnore
	private Agentes agentes;
	
	public int codigo;
	
	public Date data;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agente", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	public List<Regiao> regiao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Regiao> getRegiao() {
		return regiao;
	}
	public void setRegiao(List<Regiao> regiao) {
		this.regiao = regiao;
	}
	public Integer getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	public Agentes getAgentes() {
		return agentes;
	}
	public void setAgentes(Agentes agentes) {
		this.agentes = agentes;
	}
	
}
