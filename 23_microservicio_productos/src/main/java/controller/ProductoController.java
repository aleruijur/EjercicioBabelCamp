package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@CrossOrigin("*")
@RestController
public class ProductoController {
	
	@Autowired
	ProductoService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos() {
		return service.productos();
	}
	
	@PutMapping(value="{codigoProducto}/{unidades}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String actualizarStock(@PathVariable("codigoProducto") int codigoProducto, @PathVariable("unidades") int unidades) {
		return String.valueOf(service.actualizarStock(codigoProducto, unidades));
	}
	
	@GetMapping(value="{codigoProducto}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String precio(@PathVariable("codigoProducto") int codigoProducto) {
		return String.valueOf(service.precio(codigoProducto));
	}

}
