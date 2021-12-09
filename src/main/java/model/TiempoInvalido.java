package model;

public class TiempoInvalido extends Exception {

	private static final long serialVersionUID = -7712014010359247230L;

	public TiempoInvalido() {
		super("Ingrese un tiempo v�lido");
	}
}
