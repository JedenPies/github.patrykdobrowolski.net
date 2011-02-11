package pl.jedenpies.blog.dao;

import pl.jedenpies.blog.domain.Identifiable;

public interface GenericDao<T extends Identifiable> {

	public T create(T object) throws IllegalArgumentException;
	public T read(Integer id) throws IllegalArgumentException;
	public T update(T object) throws IllegalArgumentException;
	public boolean delete(T object) throws IllegalArgumentException;
}
