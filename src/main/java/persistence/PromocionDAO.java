package persistence;

import model.Promocion;
import persistence.common.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion>{

	public abstract Promocion findByName(String name);
	
	public abstract int getIDByPromocion(Promocion promo);
	
}
