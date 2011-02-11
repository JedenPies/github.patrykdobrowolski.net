package pl.jedenpies.blog.db.hibernate.dao.factory;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.domain.Uzytkownik;
import pl.jedenpies.blog.domain.Wpis;
import pl.jedenpies.blog.tests.AbstractTest;

public class HibernateDaoFactoryTest extends AbstractTest {

	@Resource(name = "hibernateDaoFactory")
	private HibernateDaoFactory daoFactory;
	
	@Test
	public void testFactory() {
		Assert.notNull(daoFactory);
		
		{
			GenericDao<Wpis> dao = daoFactory.createDao(Wpis.class);
			Assert.notNull(dao);
		}
		{
			GenericDao<Uzytkownik> dao = daoFactory.createDao(Uzytkownik.class);
			Assert.notNull(dao);
		}
	}
}
