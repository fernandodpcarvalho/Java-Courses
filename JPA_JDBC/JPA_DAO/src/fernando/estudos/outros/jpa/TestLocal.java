package fernando.estudos.outros.jpa;

public class TestLocal {
	public static void main(String[] args) {
		localDAO dao = new localDAO();
		Local l = new Local();
		Local l2 = new Local();
		
		l.setPredio("Lambda");
		l.setSala("L330");
		l.setCapacidade(80);
		l.setId(1L);				
		
		dao.salvar(l);
		l2 = dao.consultar(l.getId());
		System.out.println("Local 1 salvo " +l2.getId() + " " + l2.getPredio()
		        + " " + l2.getSala() + " " + l2.getCapacidade());
		/////////////////////////////////////////////////////////////////

		l.setPredio("Hibernate");
		l.setSala("R550");
		l.setCapacidade(60);
		l.setId(2L);	
		
		dao.salvar(l);
		l2 = dao.consultar(l.getId());
		System.out.println("Local 2 salvo " +l2.getId() + " " + l2.getPredio()
        + " " + l2.getSala() + " " + l2.getCapacidade());
		////////////////////////////////////////////////////////////////
		
		l.setPredio("Eclipse");
		l.setSala("T220");
		l.setCapacidade(50);
		l.setId(2L);		

		dao.atualizar(l);
		l2 = dao.consultar(l.getId());
		System.out.println("Local 2 Atualizado " +l2.getId() + " " + l2.getPredio()
        + " " + l2.getSala() + " " + l2.getCapacidade());
        ////////////////////////////////////////////////////////////////
		
		if(dao.deletar(l)) {
			System.out.println("Local 2 Deletado " +l2.getId() + " " + l2.getPredio()
	        + " " + l2.getSala() + " " + l2.getCapacidade());
		}
		else System.out.println("Erro no delete do Local 2");
		
////////////////////////////////////////////////////////////////
		
		l.setPredio("JPA");
		l.setSala("S660");
		l.setCapacidade(90);
		l.setId(3L);	
		
		dao.salvar(l);
		l2 = dao.consultar(l.getId());
		System.out.println("Local 3 salvo " +l2.getId() + " " + l2.getPredio()
        + " " + l2.getSala() + " " + l2.getCapacidade());
		////////////////////////////////////////////////////////////////
	}

}
