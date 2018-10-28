package br.com.caelum.comportamentais.chain_of_responsibility;

class Requisicao {
    private Formato formato;
    public Requisicao(Formato formato) {
      this.formato = formato;
    }
	public Formato getFormato() {
		return formato;
	}
  }

class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
      this.titular = titular;
      this.saldo = saldo;
    }

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}    
  }

enum Formato {
    XML,
    CSV,
    PORCENTO
  }

interface Resposta {
    void responde(Requisicao req, Conta conta);
    void setProxima(Resposta resposta);
  }

class RespostaEmXml implements Resposta {
    private Resposta outraResposta;

    public void responde(Requisicao req, Conta conta) {
      if(req.getFormato() == Formato.XML) {
        System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>");
      }
      else {
        outraResposta.responde(req, conta);
      }
    }

    public void setProxima(Resposta resposta) {
      this.outraResposta = resposta;
    }
  }

  class RespostaEmCsv implements Resposta {
    private Resposta outraResposta;

    public void responde(Requisicao req, Conta conta) {
      if(req.getFormato() == Formato.CSV) {
        System.out.println(conta.getTitular() + "," + conta.getSaldo());
      }
      else {
        outraResposta.responde(req, conta);
      }
    }

    public void setProxima(Resposta resposta) {
      this.outraResposta = resposta;
    }
  }

  class RespostaEmPorcento implements Resposta {
    private Resposta outraResposta;

    public void responde(Requisicao req, Conta conta) {
      if(req.getFormato() == Formato.PORCENTO) {
        System.out.println(conta.getTitular() + "%" + conta.getSaldo());
      }
      else {
        outraResposta.responde(req, conta);
      }
    }

    public void setProxima(Resposta resposta) {
      this.outraResposta = resposta;
    }
  }
  
  
  class Requisitante {
	  
	    public void calcula(Requisicao requisicao, Conta conta) {
	    	Resposta r1 = new RespostaEmXml();
	    	Resposta r2 = new RespostaEmCsv();
	    	Resposta r3 = new RespostaEmPorcento();

	        r1.setProxima(r2);
	        r2.setProxima(r3);
	        
	        r1.responde(requisicao, conta);
	    }
	  }
  
public class TestaRequisicao {
	
	public static void main(String[] args) {
		Requisicao reqCSV = new Requisicao(Formato.CSV);
		Requisicao reqPORCENTO = new Requisicao(Formato.PORCENTO);
		Requisicao reqXML = new Requisicao(Formato.XML);
		
		Conta c1 = new Conta("Fernando", 15000.00);  
		  
		Requisitante req = new Requisitante();

		req.calcula(reqCSV, c1);
		req.calcula(reqPORCENTO, c1);
		req.calcula(reqXML, c1);
		
	}	  
	  	  
  }
  