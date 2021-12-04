package model;

public class TipoDeAtraccionDistinta extends Exception {

	private static final long serialVersionUID = -7888914727100426934L;

	public TipoDeAtraccionDistinta() {
		super("El tipo de atracci�n de la promoci�n debe ser el mismo");
	}
}
