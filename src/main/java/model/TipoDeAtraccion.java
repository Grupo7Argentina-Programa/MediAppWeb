package model;

public enum TipoDeAtraccion {

	AVENTURA, DEGUSTACION, PAISAJE, SINPREFERENCIA;
	private int id;
	
	private TipoDeAtraccion(int id){
		this.setId(id);
	}

	private TipoDeAtraccion(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
