package com.trabalhoFinal.apiEcommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoFinal.apiEcommerce.dto.CategoriaDTO;
import com.trabalhoFinal.apiEcommerce.entities.Categoria;
import com.trabalhoFinal.apiEcommerce.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	
	@GetMapping 
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		return new ResponseEntity<>(categoriaService.getAllCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
		return new ResponseEntity<>(categoriaService.getCategoriaById(id), HttpStatus.OK);
	}
	
	// DTO
	
	@GetMapping("/dto")
	public ResponseEntity<List<CategoriaDTO>> getAllCategoriasDTO() {
		return new ResponseEntity<>(categoriaService.getAllCategoriasDTO(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN', 'MODERATOR')")
	@PostMapping
	public ResponseEntity<Categoria> saveCategoria(@RequestBody @Valid Categoria categoria) {
		return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN', 'MODERATOR')")
	@PutMapping
	public ResponseEntity<Categoria> updateCategoria(@RequestBody @Valid Categoria categoria, Integer id) {
		return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN', 'MODERATOR')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delCategoria(@PathVariable Integer id) {
		Boolean categoriaResponse = categoriaService.delCategoria(id);
		if (categoriaResponse)
			return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(categoriaResponse, HttpStatus.NOT_MODIFIED);
	}
}
