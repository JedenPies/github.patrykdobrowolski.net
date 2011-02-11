package pl.jedenpies.blog.managers;

import pl.jedenpies.blog.db.hibernate.ds.UzytkownikDs;

public interface UzytkownicyManager {

	/**
	 * Tworzy nowego lub zapisuje starego uzytkownika.
	 * @param uzytkownik uzytkownik do zapisania
	 * @return zapisany uzytkownik
	 */
	public UzytkownikDs zapiszUzytkownika(UzytkownikDs uzytkownik);
}
