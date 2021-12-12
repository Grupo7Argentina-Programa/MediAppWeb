package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TipoDeAtraccion {
	
	private String nombre;
	private Integer id;
	private Map<String, String> errors;

	@Override
	public String toString() {
		return this.nombre;
	}
	
	public TipoDeAtraccion(){
	}
	
	public TipoDeAtraccion(String nombre){
		this.setNombre(nombre);
	}
	
	public TipoDeAtraccion(Integer id, String nombre){
		this.setId(id);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDeAtraccion other = (TipoDeAtraccion) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	public boolean isValid() {
		this.validate();
		return errors.isEmpty();
	}

	private void validate() {
		
		errors = new HashMap<String, String>();

		if (this.nombre.equals("")) {
			errors.put("cupo", "El nombre no puede estar vacío");
		}

	}
}
