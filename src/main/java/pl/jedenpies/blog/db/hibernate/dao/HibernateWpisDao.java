package pl.jedenpies.blog.db.hibernate.dao;

import pl.jedenpies.blog.dao.WpisDao;
import pl.jedenpies.blog.db.hibernate.ds.WpisDs;

public class HibernateWpisDao extends AbstractHibernateDao implements WpisDao {

	@Override
	public WpisDs create(WpisDs wpis) {
		
		getSession().save(wpis);
		return wpis;		
	}

	@Override
	public WpisDs update(WpisDs wpis) {

		getSession().update(wpis);
		return wpis;
	}

}
