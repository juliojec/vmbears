package br.com.vmbears.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.vmbears.model.Regiao;
import br.com.vmbears.service.AgenteService;

@RestController
@RequestMapping("/agente")
@CrossOrigin(origins="*", maxAge=3600)
public class AgenteController {
	
	@Autowired
	private AgenteService agenteService;
	
	@PostMapping(value = "/upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws Exception {
		agenteService.save(file);
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
	
	@GetMapping(value = "/sigla/{sigla}")
	public List<Regiao> findBySigla(@PathVariable("sigla") String sigla) {
		return agenteService.findBySigla(sigla);
	}
	
}
