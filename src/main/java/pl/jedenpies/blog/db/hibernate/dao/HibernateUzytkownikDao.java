package pl.jedenpies.blog.db.hibernate.dao;

import org.hibernate.HibernateException;

import pl.jedenpies.blog.dao.UzytkownikDao;
import pl.jedenpies.blog.db.hibernate.assembler.UzytkownikAssembler;
import pl.jedenpies.blog.db.hibernate.ds.UzytkownikDs;
import pl.jedenpies.blog.domain.Uzytkownik;

/**
 * Klasa obslugujaca operacje CRUD dla encji {@link Uzytkownik} z wykorzystaniem Hibernate.
 * @author Patryk Dobrowolski
 */
public class HibernateUzytkownikDao extends AbstractHibernateDao implements UzytkownikDao {

	@Override
	public Uzytkownik create(Uzytkownik uzytkownik) throws IllegalArgumentException {
				
		checkParameterNotNull(uzytkownik, "uzytkownik");
		if (uzytkownik.getId() != null) {
			throw new IllegalArgumentException("Cannot create user with id already set. Use update() instead.");
		}
		try {
			UzytkownikDs uzytkownikDs = UzytkownikAssembler.dto2Ds(uzytkownik);
			getSession().save(uzytkownikDs);
			return UzytkownikAssembler.ds2Dto(uzytkownikDs);
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Uzytkownik read(Integer id) throws IllegalArgumentException {
		
		checkParameterNotNull(id, "id");
		try {
			UzytkownikDs ds = readInternal(UzytkownikDs.class, id);			
			Uzytkownik result = ds == null ? null : UzytkownikAssembler.ds2Dto(ds);
			return result;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Uzytkownik update(Uzytkownik uzytkownik) throws IllegalArgumentException {
		
		checkParameterNotNull(uzytkownik, "uzytkownik");
		if (uzytkownik.getId() == null) return null;
		try {
			UzytkownikDs ds = readInternal(UzytkownikDs.class, uzytkownik.getId());
			if (ds == null) return null;
			UzytkownikAssembler.copyData(uzytkownik, ds);				
			getSession().update(ds);			
			return uzytkownik;
		} catch (HibernateException e) {
			return null;
		}

	}

	@Override
	public boolean delete(Uzytkownik uzytkownik) throws IllegalArgumentException {

		checkParameterNotNull(uzytkownik, "uzytkownik");
		if (uzytkownik.getId() == null) return false;
		try {
			UzytkownikDs ds = readInternal(UzytkownikDs.class, uzytkownik.getId());	
			if (ds == null)	return false;			
			getSession().delete(ds);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
