package com.pedroDRM.newProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pedroDRM.newProject.model.Usuario;
import com.pedroDRM.newProject.security.Autenticador;
import com.pedroDRM.newProject.security.Token;

@RestController
@CrossOrigin("*")
public class controllerUsuario {

	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario) {
		if (usuario.getEmail().equals("PedroDRMenezes@gmail.com") && usuario.getSenha().equals("12345")) {
			usuario.setId(1);
			usuario.setNome("Pedro Del Rey Menezes");

			String tk = Autenticador.GTK(usuario);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
}
