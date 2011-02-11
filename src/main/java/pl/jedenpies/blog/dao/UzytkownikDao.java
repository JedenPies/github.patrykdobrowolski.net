package pl.jedenpies.blog.dao;

import pl.jedenpies.blog.domain.Uzytkownik;

public interface UzytkownikDao {

	/**
	 * Tworzy w magazynie nowego uzytkownika na podstawie zadanego parametru.
	 * Parametr uzytkownik nie moze miec ustawionego id. Jesli chcesz zaktualizowac obiekt, uzyj metody update().
	 * @param uzytkownik obiekt do zapisania
	 * @return obiekt klasy Uzytkownik z ustawionym identyfikatorem
	 * @throws IllegalArgumentException wyrzucany w sytuacji, kiedy uzytkownik == null
	 */
	public Uzytkownik create(Uzytkownik uzytkownik) throws IllegalArgumentException;
		
	/**
	 * Wczytuje z magazynu uzytkownika o okreslonym identyfikatorze.
	 * @param id identyfikator uzytkownika, ktory ma zostac zaladowany.
	 * @return wczytany uzytkownik lub null, jesli uzytkownik o zadanym id nie istnieje w magazynie
	 * @throws IllegalArgumentException rzunay w sytuacji, kiedy id == null
	 */
	public Uzytkownik read(Integer id) throws IllegalArgumentException;
	
	/**
	 * Aktualizuje uzytkownika w magazynie.
	 * Parametr uzytkownik musi miec ustawiony identyfikator. Jesli chcesz utworzyc nowego uzytkownika uzyj metody create();
	 * @param uzytkownik uzytkownik do zaktualizowania
	 * @return zaktualizowany uzytkownik lub null, jesli uzytkownik nie istnieje w bazie
	 * @throws IllegalArgumentException rzucany, kiedy parametr uzytkownik == null
	 */
	public Uzytkownik update(Uzytkownik uzytkownik) throws IllegalArgumentException;
	
	/**
	 * Usuwa wskazanego uzytkownika z magazynu.
	 * @param uzytkownik uzytkownik do usuniecia
	 * @return true w przypadku usuniecia rekordu, false w pozostalych przypadkach
	 * @throws IllegalArgumentException rzucany, gdy parametr uzytkownik == null
	 */
	public boolean delete(Uzytkownik uzytkownik) throws IllegalArgumentException;
}
