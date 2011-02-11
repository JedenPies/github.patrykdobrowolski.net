package pl.jedenpies.blog.managers;

import pl.jedenpies.blog.dao.WpisDao;
import pl.jedenpies.blog.db.hibernate.ds.WpisDs;

public class WpisyManagerImpl implements WpisyManager {

	private WpisDao wpisDao;
	
	@Override
	public WpisDs zapiszWpis(WpisDs wpis) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void setWpisDao(WpisDao wpisDao) {
		this.wpisDao = wpisDao;
	}

}
