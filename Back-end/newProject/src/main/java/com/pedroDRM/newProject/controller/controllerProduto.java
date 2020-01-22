package com.pedroDRM.newProject.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroDRM.newProject.model.Produto;
import com.pedroDRM.newProject.security.Autenticador;

@RestController
@CrossOrigin("*")
public class controllerProduto {

	@GetMapping("/produtos/todos")
	public ResponseEntity<ArrayList<Produto>> getTodos(@RequestParam String token){
		if(Autenticador.isValid(token)) {
			ArrayList<Produto> lista = new ArrayList<Produto>();
			for (int i = 0 ; i<10 ; i++ ) {
				Produto p = new Produto();
				p.setCodigo(i+10);
				p.setDetalhes("Muito topppppp, Vitamininha do isidro. ps:Idosos");
				p.setPreco((100*i)*1.58f);
				p.setTitulo("Vitaminas do vovo");
				lista.add(p);
			}
			return ResponseEntity.ok(lista);
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
}
