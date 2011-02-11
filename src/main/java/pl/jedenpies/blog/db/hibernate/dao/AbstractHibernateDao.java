package pl.jedenpies.blog.db.hibernate.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Klasa bazowa dla wszystkich DAO Hibernate'a.
 * Zawiera kilka pomocniczych metod takich jak {@link AbstractHibernateDao#getSession()}, 
 * czy {@link AbstractHibernateDao#readInternal(Class, Integer)
 * @author Patryk Dobrowolski
 */
public abstract class AbstractHibernateDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;
	
	protected Session getSession() {		
		return sessionFactory.getCurrentSession();
	}
	
	protected void checkParameterNotNull(Object parameter) throws IllegalArgumentException {
		checkParameterNotNull(parameter, "");
	}
	protected void checkParameterNotNull(Object parameter, String parameterName) throws IllegalArgumentException {
		if (parameter == null) {
			throw new IllegalArgumentException("parameter " + parameterName + " cannot be null");
		}
	}
	
	/**
	 * Wczytuje obiekt okreslonego typu o okreslonym id z bazy danych. 
	 * @param type typ obiektu
	 * @param id identyfikator
	 * @return wczytany obiekt
	 */
	protected <T> T readInternal(Class<T> type, Integer id) {
		Criteria c = getSession().createCriteria(type);
		c.add(Restrictions.idEq(id));
		@SuppressWarnings("unchecked")
		T ds = (T) c.uniqueResult();
		return ds;	
	}
}
