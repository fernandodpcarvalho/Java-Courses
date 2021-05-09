package com.files.javaIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Java IO: File, FileReader, BufferedReader, FileWriter, BufferedWriter
 * 
 * OBS: BufferedReader/BufferedWriter = Versões otimizadas/mais rápidas de FileReader/FileWriter.
 */

public class FileTest {
	public static void main(String[] args) throws IOException {
		//Cria um diretório
		File diretorio = new File("folder");
		diretorio.mkdir();		
		
		//Cria um objeto File, que aponta para para um arquivo ou diretório no sistema de arquivos.
		File file = new File(diretorio, "File.txt");
		file.createNewFile();
		
		//Escrever em um arquivo
		FileWriter fw = new FileWriter(file);
		fw.write("Olá\nBom dia"); 
		fw.flush();
		fw.close();
		
		//Append
		FileWriter fwAppend = new FileWriter(file, true);
		fwAppend.write("\nAppendando mais uma linha"); 
		fwAppend.flush();
		fwAppend.close();
		
		//Ler arquivo
		FileReader fr = new FileReader(file);
		char[] in = new char[500];
		int size = fr.read(in);
		System.out.println(size);
		System.out.println(in);	
		
		fr.close();
		
		//Deletar o arquivo:
//		file.delete();
		
		//deletar o diretório:
//		diretorio.delete();
		
		
	}
}
