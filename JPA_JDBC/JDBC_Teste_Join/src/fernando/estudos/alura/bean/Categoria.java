package fernando.estudos.alura.bean;

public class Categoria {
	private int id;
	private String nome;

	public Categoria(){
	}
/*	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return ""+this.id+"\t"+this.nome;
	}
}

/*
CREATE TABLE `Caelum`.`Categorias` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `Nome` varchar(45) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
*/