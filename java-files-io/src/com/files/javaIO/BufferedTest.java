package com.files.javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Java IO: File, FileReader, BufferedReader, FileWriter, BufferedWriter
 * 
 * OBS: BufferedReader/BufferedWriter = Versões otimizadas/mais rápidas de FileReader/FileWriter.
 */

public class BufferedTest {
	public static void main(String[] args) throws IOException {
		
		//Cria um diretório
		File diretorio = new File("folder");
		diretorio.mkdir();		
		
		//Cria um objeto File, que aponta para para um arquivo ou diretório no sistema de arquivos.
		File file = new File(diretorio, "File.txt");
		file.createNewFile();
			
		//Usando try with resources
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			 BufferedReader br = new BufferedReader(new FileReader(file));) {
			bw.write("Olá");
			bw.newLine();
			bw.write("Bom dia");
			bw.newLine();
			bw.write("Appendando mais uma linha");
			bw.flush();
			bw.close();
			
			String line = null;			
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
