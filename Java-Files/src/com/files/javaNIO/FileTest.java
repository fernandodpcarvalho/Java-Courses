package com.files.javaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Java IO: File, FileReader, BufferedReader, FileWriter, BufferedWriter
 * 
 * OBS: BufferedReader/BufferedWriter = Versões otimizadas/mais rápidas de FileReader/FileWriter.
 */

public class FileTest {
		
	public static void main(String[] args) throws IOException {
		
		//Create a file
		Path newFilePath = Paths.get("./file.txt");
	    Files.createFile(newFilePath);
		
	    //Continuar
		
	}
}
