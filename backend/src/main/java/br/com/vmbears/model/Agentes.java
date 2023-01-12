package br.com.vmbears.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "agentes")
@Entity(name="agentes")
public class Agentes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAgentes;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agentes", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	public List<Agente> agente;
	
	@XmlAttribute
	public double versao;
	
	public Integer getIdAgentes() {
		return idAgentes;
	}
	public void setIdAgentes(Integer idAgentes) {
		this.idAgentes = idAgentes;
	}
	public List<Agente> getAgente() {
		return agente;
	}
	public void setAgente(List<Agente> agente) {
		this.agente = agente;
	}
	public double getVersao() {
		return versao;
	}
	public void setVersao(double versao) {
		this.versao = versao;
	}
	
}