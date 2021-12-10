package model.nullObjects;

import model.Usuario;


public class NullUsuario extends Usuario {

	public static Usuario build() {
		return new NullUsuario();
	}
	
	public NullUsuario() {
		super(-1, "", 0, 0.0, null, false);
	}
	
	public boolean isNull() {
		return true;
	}
	
	
}
