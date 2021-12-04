package model;

public interface Mostrable {
	
	public String getNombre();
	public Integer getCosto();
	public Double getTiempoNecesario();
	public TipoDeAtraccion getTipoDeAtraccion();
	public boolean estaEnItinerario(Itinerario actual);
	public void aceptoMostrable(Usuario comprador);
	public Integer getCupo();
}
