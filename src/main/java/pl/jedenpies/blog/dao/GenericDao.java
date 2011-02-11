package pl.jedenpies.blog.dao;

import pl.jedenpies.blog.domain.Identifiable;

/**
 * Generyczne DAO dla wszelkich klas typu Identifiable
 * @author Patryk Dobrowolski
 *
 * @param <T> typ obiektu, ktory obsluguje dane DAO
 */
public interface GenericDao<T extends Identifiable> {

	/**
	 * Tworzy w magazynie nowy obiekt na podstawie zadanego parametru.
	 * Parametr object nie moze miec ustawionego id. Jesli chcesz zaktualizowac obiekt, uzyj metody update().
	 * @param object obiekt do zapisania
	 * @return obiekt typu <T> z ustawionym identyfikatorem
	 * @throws IllegalArgumentException wyrzucany w sytuacji, kiedy parametr object == null
	 */
	public T create(T object) throws IllegalArgumentException;
	
	/**
	 * Wczytuje z magazynu obiekt typu <T> o okreslonym identyfikatorze.
	 * @param id identyfikator obiektu, ktory ma zostac zaladowany.
	 * @return wczytany obiekt typu <T> lub null, jesli obiekt o zadanym id nie istnieje w magazynie
	 * @throws IllegalArgumentException rzucnay w sytuacji, kiedy id == null
	 */
	public T read(Integer id) throws IllegalArgumentException;
	
	/**
	 * Aktualizuje obiekt w magazynie.
	 * Parametr object musi miec ustawiony identyfikator. Jesli chcesz utworzyc nowy obiekt uzyj metody create();
	 * @param object object do zaktualizowania
	 * @return zaktualizowany obiekt typu <T> lub null, jesli obiekt nie istnieje w bazie
	 * @throws IllegalArgumentException rzucany, kiedy parametr object == null
	 */
	public T update(T object) throws IllegalArgumentException;
	
	/**
	 * Usuwa wskazany obiekt z magazynu.
	 * @param object obiekt do usuniecia
	 * @return true w przypadku usuniecia rekordu, false w pozostalych przypadkach
	 * @throws IllegalArgumentException rzucany, gdy parametr object == null
	 */
	public boolean delete(T object) throws IllegalArgumentException;
}
