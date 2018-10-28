package br.com.caelum.criacionais.factory;

import java.sql.Connection;

public class TestaConectionFactory {
	
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
	}

}
