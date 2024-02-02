package com.renanduarte.grudgelang;

import java.util.HashMap;

public class Utils {
	public static final HashMap<String, Integer>INSTRUCTIONS = new HashMap<String, Integer>() {/**
		 *
		 */
		private static final long serialVersionUID = 1L;

	{
	    put("aaa", 0); //Incrementa um valor no endereço atual da memória
	    put("aaA", 1); //Decrementa um valor no endereço atual da memória
	    put("aAa", 2); //Avança um endereço de memória
	    put("aAA", 3); //Volta um endereço de memória
	    put("Aaa", 4); //Delimitam um laço, que é interrompido após o contador atingir valor 0
	    put("AaA", 5);	
	    put("AAa", 6);	//Espera o usuário digitar alguma coisa na linha de comando
	    put("AAA", 7);	//Exibe o conteúdo na posição atual da memória para o usuário
	}};
}
