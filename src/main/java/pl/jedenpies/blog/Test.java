package pl.jedenpies.blog;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.db.hibernate.dao.HibernateDaoFactory;
import pl.jedenpies.blog.domain.Wpis;

public class Test {

	public static void main(String args[]) {
		HibernateDaoFactory f = new HibernateDaoFactory();
		GenericDao<Wpis> wdao = f.createDao(Wpis.class);
		wdao.create(new Wpis());
		System.out.println("koniec" + wdao);
	}
}
