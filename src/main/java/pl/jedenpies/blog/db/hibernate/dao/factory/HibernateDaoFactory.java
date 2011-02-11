package pl.jedenpies.blog.db.hibernate.dao.factory;

import java.util.HashMap;
import java.util.Map;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.domain.Identifiable;

/**
 * Fabryka generycznych obiektow DAO.
 * @author Patryk
 */
public class HibernateDaoFactory {

	private Map<Class<Identifiable>, HibernateConcreteDaoFactory> factories;
	
	/**
	 * Tworzy generyczne DAO dla Hibernate'a na podstawie zadanego parametru.
	 * @param type typ, ktory ma byc obslugiwany przez DAO
	 * @return generyczne DAO
	 * @throws IllegalArgumentException rzucany, kiedy nie jest znany sposob utworzenia danego DAO.
	 */
	public <TDTO extends Identifiable> GenericDao<TDTO> createDao(Class<TDTO> type) throws IllegalArgumentException {		
		
		HibernateConcreteDaoFactory factory = factories.get(type);
		if (factory == null) throw new IllegalArgumentException("Cannot create DAO for type " + type);
		@SuppressWarnings("unchecked")
		GenericDao<TDTO> result = (GenericDao<TDTO>) factory.create();
		return result;
	}

	/**
	 * Ustawia relacje miedzy konkretnymi typami Identifiable a konkretnymi fabrykami produkujacymi DAO.
	 * @param config mapa zawierajaca relacje klasa-klasa
	 */
	public void setConcreteFactories(Map<Class<Identifiable>, Class<HibernateConcreteDaoFactory>> config) {
		factories = new HashMap<Class<Identifiable>, HibernateConcreteDaoFactory>();
		for (Class<Identifiable> key : config.keySet()) {
			Class<HibernateConcreteDaoFactory> value = config.get(key);
			try {
				HibernateConcreteDaoFactory factory = value.newInstance();
				factories.put(key, factory);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
}
