package br.com.vmbears.service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.vmbears.model.Agentes;
import br.com.vmbears.model.Regiao;
import br.com.vmbears.repository.AgentesRepository;
import br.com.vmbears.repository.RegiaoRepository;

@Service
public class AgenteService {
	
	@Autowired
	private AgentesRepository agentesRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;

	public void save(MultipartFile file) throws Exception {
        	Agentes agentes = this.converterXML(file);
        
		agentes.getAgente().stream()
			.forEach(agente -> System.out.println("Código do Agente: " + agente.getCodigo()));
        
        	agentesRepository.save(agentes);
	}
	
	public List<Regiao> findBySigla(String sigla) {
		List<Regiao> regiao = regiaoRepository.findBySigla(sigla);
		return regiao;
	}

	private Agentes converterXML(MultipartFile file) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Agentes agentes = (Agentes) jaxbUnmarshaller.unmarshal(file.getInputStream());
		return agentes;
	}
	
}
