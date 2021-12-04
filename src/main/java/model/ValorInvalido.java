package model;

public class ValorInvalido extends Exception {

	private static final long serialVersionUID = -452441221707326190L;

	public ValorInvalido(){
		super("Ingrese un valor válido");
	}

}
