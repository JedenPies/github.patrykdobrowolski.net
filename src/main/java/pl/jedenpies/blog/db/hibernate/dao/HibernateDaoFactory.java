package pl.jedenpies.blog.db.hibernate.dao;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.db.hibernate.assembler.Assembler;
import pl.jedenpies.blog.db.hibernate.assembler.WpisAssembler;
import pl.jedenpies.blog.db.hibernate.ds.WpisDs;
import pl.jedenpies.blog.domain.Identifiable;
import pl.jedenpies.blog.domain.Wpis;

public class HibernateDaoFactory {

	public <TDTO extends Identifiable, TDS extends Identifiable> GenericDao<TDTO> createDao(Class<TDTO> type) {		
		if (type == Wpis.class) {
			Assembler<Wpis, WpisDs> assembler = new WpisAssembler();
			GenericDao<Wpis> r = new HibernateGenericDao<Wpis, WpisDs>(assembler, WpisDs.class);
			@SuppressWarnings("unchecked")
			GenericDao<TDTO> result = (GenericDao<TDTO>) r;
			return result;
		}
		throw new IllegalArgumentException("Cannot create DAO for type " + type);
	}
}
