package pl.jedenpies.blog.dao;

import pl.jedenpies.blog.db.hibernate.ds.WpisDs;

public interface WpisDao {

	/**
	 * Tworzy nowy wpis
	 * @param wpis wpis
	 * @return nowy wpis
	 */
	public WpisDs create(WpisDs wpis);
	
	/**
	 * Zapisuje/aktualizuje istniej¹cy wpis
	 * @param wpis
	 * @return zaktualizowany wpis
	 */
	public WpisDs update(WpisDs wpis);
}
