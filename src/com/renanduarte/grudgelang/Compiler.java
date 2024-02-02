package com.renanduarte.grudgelang;

import java.io.IOException;

import static com.renanduarte.grudgelang.Utils.INSTRUCTIONS;;

public class Compiler {
	private static final int MAX_MEMORY_LENGTH = 100;
	private static final int TOKEN_LENGTH = 3;
	private int[] memory = new int[MAX_MEMORY_LENGTH];
	private int p = 0;
	private int c = 0;
	private String[] code;
	private int colchete_abertura = -1;
	
	public Compiler() {
		
	}
	
	/**
	 * Instruções da linguagem
	 */
	private void increase() { memory[p] ++;}
	private void decrease() { memory[p] --;}
	private void input() { 
		try {
			memory[p] = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void output() {
		System.out.println(Character.toString(memory[p]));
	}
	
	private void prev() { p--;  }
	private void next() { p++; }
	private void consumeLoop() {
		colchete_abertura = c;
		if(memory[p] == 0) {
			for(int i=0;i<code.length;i++) {
				if(!code[c].equals("AaA")) {
					c = i;
				}
			}
			colchete_abertura = -1;
		}
	}
	private void exitLoop() {
		if(memory[p] > 0) { c = colchete_abertura; }
	}
	
	private void convert(String sourceCode) {
		code = new String[sourceCode.length() / TOKEN_LENGTH];
		for(int i=0;i<sourceCode.length();i+=TOKEN_LENGTH) {
			code[c] = sourceCode.substring(i, i+TOKEN_LENGTH);
			c++;
		}
		c = 0;
	}
	
	/**
	 * Exibe o estado atual da memória
	 * @return Estado atual da memória
	 */
	public int[] showMemory() {
		return memory;
	}
	
	public void compile(String sourceCode) throws CompilerException {
		convert(sourceCode);
		while(c < code.length) {
			switch(INSTRUCTIONS.get(code[c]).intValue()) {
				case 0:
					increase();
					break;
				case 1:
					decrease();
					break;
				case 2:
					next();
					break;
				case 3:
					prev();
					break;
				case 4:
					consumeLoop();
					break;
				case 5:
					exitLoop();
					break;
				case 6:
					input();
					break;
				case 7:
					output();
					break;
				default:
					throw new CompilerException("Erro de sintaxe no comando "+code[c]+".");
			}
			c++;
		}
	}
}
