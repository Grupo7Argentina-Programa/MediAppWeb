package model;

import java.util.Comparator;

public class OrdenadorDeMostrables implements Comparator<Mostrable> {
	

	@Override
	public int compare(Mostrable prod1, Mostrable prod2) {
		int c;
	       c = prod1.getCosto().compareTo(prod2.getCosto());
	    if (c == 0)
		       c = prod1.getTiempoNecesario().compareTo(prod2.getTiempoNecesario());
		    return c;
	}

}
