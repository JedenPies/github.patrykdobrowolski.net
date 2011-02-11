package pl.jedenpies.blog.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.util.Assert;

import pl.jedenpies.blog.domain.Uzytkownik;
import pl.jedenpies.blog.tests.AbstractTest;

public class UzytkownikDaoTest extends AbstractTest {

	@Resource(name = "uzytkownikDao")
	private UzytkownikDao uzytkownikDao;
	
	@Test
	@BeforeTransaction	
	public void test1Config() {
		Assert.notNull(uzytkownikDao, "UzytkownikDao nie moze byc null");
	}
	
	@Test	
	public void test2Create() {
		Uzytkownik u = simpleUzytkownik();
		Assert.isTrue(u.getId() == null);
		u = uzytkownikDao.create(u);
		Assert.notNull(u, "uzytkownik nie moze byc null");		
	}
	
	@Test
	public void test3Read() {
		Uzytkownik u = simpleUzytkownik();
		u = uzytkownikDao.create(u);
		Assert.notNull(u);
		u = uzytkownikDao.read(u.getId());
		Assert.notNull(u, "uzytkownik nie moze byc null");
		Assert.hasText(u.getEmail());
		Assert.hasText(u.getHasloHash());		
	}
	
	@Test
	public void test3Update() {
		final String newEmail = "newEmail@example.pl";
		Uzytkownik u = simpleUzytkownik();
		u = uzytkownikDao.create(u);				
		u.setEmail(newEmail);
		u = uzytkownikDao.update(u);		
		Assert.isTrue(u.getEmail().equals(newEmail));
	}
	
	@Test
	public void test4Delete() {
		Uzytkownik u = simpleUzytkownik();
		u = uzytkownikDao.create(u);
		uzytkownikDao.delete(u);
		u = uzytkownikDao.read(u.getId());
		Assert.isNull(u);
	}
	
	private Uzytkownik simpleUzytkownik() {
		Uzytkownik u = new Uzytkownik();
		u.setEmail("me@example.pl");
		u.setHaslo("tajneHaslo");
		return u;
	}
}
