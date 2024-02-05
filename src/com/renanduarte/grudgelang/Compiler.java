package com.renanduarte.grudgelang;

import java.io.IOException;

import static com.renanduarte.grudgelang.Utils.INSTRUCTIONS;
import static com.renanduarte.grudgelang.Utils.BF_TO_GDG;
import static com.renanduarte.grudgelang.Utils.GDG_TO_BF;

public class Compiler {
	protected static final int MAX_MEMORY_LENGTH = 100;
	protected static final int TOKEN_LENGTH = 3;
	protected int[] memory = new int[MAX_MEMORY_LENGTH];
	protected int p = 0;
	protected int c = 0;
	protected String[] code;
	protected int colchete_abertura = -1;
	
	public Compiler() {
		
	}
	
	/**
	 * Instruções da linguagem
	 */
	protected void increase() { memory[p] ++;}
	protected void decrease() { memory[p] --;}
	protected void input() { 
		try {
			memory[p] = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void output() {
		System.out.println((char)memory[p]);
	}
	
	protected void prev() { p--;  }
	protected void next() { p++; }
	protected void consumeLoop() {
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
	protected void exitLoop() {
		if(memory[p] > 0) { c = colchete_abertura; }
	}
	
	protected void convert(String sourceCode) {
		code = new String[sourceCode.length() / TOKEN_LENGTH];
		for(int i=0;i<sourceCode.length();i+=TOKEN_LENGTH) {
			code[c] = sourceCode.substring(i, i+TOKEN_LENGTH);
			c++;
		}
		c = 0;
	}
	
	public String convertFromBFCodeToGDG(String source) {
		String tmp = "";
		for(int i=0;i<source.length();i++) {
			tmp += BF_TO_GDG.get(source.substring(i, i+1));
		}
		return tmp;
	}
	
	public String convertFromGDGCodeToBF(String source) {
		String tmp = "";
		for(int i=0;i<source.length();i+=TOKEN_LENGTH) {
			tmp += GDG_TO_BF.get(source.substring(i, i+TOKEN_LENGTH));
		}
		return tmp;
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
			try {
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
			}catch(NullPointerException ex) {
				throw new CompilerException(code[c] +" Comando inválido: Stacktrace \n"+ex.getMessage());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			c++;
		}
		
	}
}
