package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisService service;
	
	@GetMapping(value="Continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	
	@GetMapping(value="Pais/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> buscar(@PathVariable("continente") String continente){
		return service.paisesPorContiente(continente);
	}
	
	@GetMapping(value="Poblacion/{continente}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String habitantes(@PathVariable("continente") String continente){
		return String.valueOf(service.poblacionContiente(continente));
	}
	
}
