package pl.jedenpies.blog.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import pl.jedenpies.blog.domain.Wpis;
import pl.jedenpies.blog.tests.AbstractTest;

public class WpisDaoTest extends AbstractTest {

	@Resource(name = "wpisDao")
	private GenericDao<Wpis> wpisDao;
	
	@Test
	public void test1config() {
		Assert.notNull(wpisDao);
	}
	
	@Test
	public void test2Create() {		
		Wpis w = simpleWpis();
		Assert.isTrue(w.getId() == null);
		w = wpisDao.create(w);
		Assert.notNull(w, "wpis nie moze byc null");		
	}
	
	@Test
	public void test3Read() {
		Wpis w = simpleWpis();
		w = wpisDao.create(w);
		Assert.notNull(w);
		w = wpisDao.read(w.getId());
		Assert.notNull(w, "wpis nie moze byc null");
		Assert.hasText(w.getTresc());
		Assert.hasText(w.getTytul());
		Assert.notNull(w.getData());
	}
	
	@Test
	public void test3Update() {
		final String newTresc = "newTresc";
		Wpis w = simpleWpis();
		w = wpisDao.create(w);				
		w.setTresc(newTresc);
		w = wpisDao.update(w);		
		Assert.isTrue(newTresc.equals(w.getTresc()));
	}
	
	@Test
	public void test4Delete() {
		Wpis w = simpleWpis();
		w = wpisDao.create(w);
		wpisDao.delete(w);
		w = wpisDao.read(w.getId());
		Assert.isNull(w);
	}
	
	private Wpis simpleWpis() {
		Wpis wpis = new Wpis();
		wpis.setData(new Date());
		wpis.setTresc("tresc");
		wpis.setTytul("tytul");
		return wpis;
	}
}
