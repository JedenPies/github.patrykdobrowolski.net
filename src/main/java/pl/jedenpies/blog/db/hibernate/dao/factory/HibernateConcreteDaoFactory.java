package pl.jedenpies.blog.db.hibernate.dao.factory;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.domain.Identifiable;

/**
 * Fabryka tworzaca DAO konkretnego typu - powiazanego z konkretnym typem Identifiable
 * @author Patryk Dobrowolski
 *
 */
public interface HibernateConcreteDaoFactory {

	/**
	 * Tworzy DAO.
	 * @return utworzone DAO.
	 */
	public GenericDao<? extends Identifiable> create();
}
