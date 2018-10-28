package fernando.estudos.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoDAO {
	public static ResourceBundle config;
	
	private static ConexaoDAO conexao;
	
	private ConexaoDAO() {
		config = ResourceBundle.getBundle("config");
	}
    
	//PAdrão Singleton. Método ESTÁTICO que retorna uma instância do objeto ConexaoDAO
	//Somente este método pode dar um "new" e criar um objeto ConexaoDAO. 
	//Caso já exista uma instância criada, ele retorna esta mesma instância. Assim, garante que somente uma instância será criado
	public static ConexaoDAO getInstance() {
		if (conexao == null) { //garante que a instancia seja única
			conexao = new ConexaoDAO();
		}
		return conexao; //Retorna a variável estática conexao. Se for null, cria, senão retorna a já existente.
	}
	
	//Método que conecta e retorna uma Connection
	public Connection getConnection() throws ClassNotFoundException, SQLException { //Jogou a exeção "pra cima". Quem chamar o objeto é quem terá que tratar.
		Class.forName(config.getString("fernando.estudos.devmedia.jdbc.mysql")); 
		return DriverManager.getConnection(config.getString("fernando.estudos.devmedia.jdbc.url.conexao"),
                config.getString("fernando.estudos.devmedia.jdbc.usuario"),
                config.getString("fernando.estudos.devmedia.jdbc.senha"));
	}		
}
