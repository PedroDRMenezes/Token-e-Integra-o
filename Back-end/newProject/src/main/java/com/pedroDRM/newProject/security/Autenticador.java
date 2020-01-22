package com.pedroDRM.newProject.security;

import javax.xml.bind.DatatypeConverter;

import com.pedroDRM.newProject.model.Usuario;

public class Autenticador {
	private static final String PREFIXO = "*PeDrOcOrP|";
	
	public static String GTK(Usuario usuario) {
		String str = PREFIXO + usuario.toString();
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		return token;
	}
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String novaString = new String (vetor);
		if(novaString.startsWith(PREFIXO)) {
			return true;
		}
		return false;
	}
}
