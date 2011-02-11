package pl.jedenpies.blog.db.hibernate.dao;

import org.hibernate.HibernateException;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.db.hibernate.assembler.Assembler;
import pl.jedenpies.blog.db.hibernate.ds.HibernateIdentifiable;
import pl.jedenpies.blog.domain.Identifiable;

public class HibernateGenericDao<TDTO extends Identifiable, TDS extends HibernateIdentifiable> 
		extends AbstractHibernateDao 
		implements GenericDao<TDTO> {
	
	private Assembler<TDTO, TDS> assembler;
	private Class<TDS> dsType;
	
	public HibernateGenericDao(Assembler<TDTO, TDS> assembler, Class<TDS> dsType) {
		this.assembler = assembler;
		this.dsType = dsType;
	}
	
	@Override
	public TDTO create(TDTO object) throws IllegalArgumentException {
		
		checkParameterNotNull(object);
		if (object.getId() != null) {
			throw new IllegalArgumentException("Cannot create object with id already set. Use update() instead.");
		}
		try {
			TDS ds = assembler.dto2Ds(object);
			getSession().save(ds);
			return assembler.ds2Dto(ds);
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public TDTO read(Integer id) throws IllegalArgumentException {
		
		checkParameterNotNull(id, "id");
		try {
			TDS ds = readInternal(dsType, id);			
			TDTO result = ds == null ? null : assembler.ds2Dto(ds);
			return result;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public TDTO update(TDTO object) throws IllegalArgumentException {
		
		checkParameterNotNull(object);
		if (object.getId() == null) return null;
		try {
			TDS ds = readInternal(dsType, object.getId());
			if (ds == null) return null;
			assembler.copyDataDto2Ds(object, ds);				
			getSession().update(ds);			
			return object;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(TDTO object) throws IllegalArgumentException {
		
		checkParameterNotNull(object);
		if (object.getId() == null) return false;
		try {
			TDS ds = readInternal(dsType, object.getId());	
			if (ds == null)	return false;			
			getSession().delete(ds);			
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
