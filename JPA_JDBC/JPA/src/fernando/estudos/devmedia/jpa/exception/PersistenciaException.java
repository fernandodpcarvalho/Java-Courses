package fernando.estudos.devmedia.jpa.exception;

public class PersistenciaException extends Exception{

	private static final long serialVersionUID = 890204194500103934L;
	
	public PersistenciaException(String msg, Exception exception) {
		super(msg, exception);
	}
	
	public PersistenciaException(String msg) {
		super(msg);
	}

}
