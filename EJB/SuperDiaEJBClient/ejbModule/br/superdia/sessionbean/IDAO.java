package br.superdia.sessionbean;

import java.util.List;

public interface IDAO<T> {
	public void add(T t);
	public void remove(T t);
	public void update(T t);
	public List<T> getAll(Class<T> classe);
	public T getForId(Long id, Class<T> classe);
}
