package com.renanduarte.grudgelang;

import java.util.HashMap;

public class Utils {
	public static final HashMap<String, Integer>INSTRUCTIONS = new HashMap<String, Integer>() {/**
		 *
		 */
		private static final long serialVersionUID = 1L;

	{
	    put("aaa", 0); //Incrementa um valor no endere�o atual da mem�ria
	    put("aaA", 1); //Decrementa um valor no endere�o atual da mem�ria
	    put("aAa", 2); //Avan�a um endere�o de mem�ria
	    put("aAA", 3); //Volta um endere�o de mem�ria
	    put("Aaa", 4); //Delimitam um la�o, que � interrompido ap�s o contador atingir valor 0
	    put("AaA", 5);	
	    put("AAa", 6);	//Espera o usu�rio digitar alguma coisa na linha de comando
	    put("AAA", 7);	//Exibe o conte�do na posi��o atual da mem�ria para o usu�rio
	}};
}
