package pl.jedenpies.blog.dao;

import pl.jedenpies.blog.domain.Wpis;

public interface WpisDao extends GenericDao<Wpis> {

	/**
	 * Tworzy nowy wpis
	 * @param wpis wpis
	 * @return nowy wpis
	 */
	public Wpis create(Wpis wpis);	
	
	public Wpis read(Integer id);
	
	/**
	 * Zapisuje/aktualizuje istniej¹cy wpis
	 * @param wpis
	 * @return zaktualizowany wpis
	 */
	public Wpis update(Wpis wpis);
	
	public boolean delete(Wpis wpis);
}
