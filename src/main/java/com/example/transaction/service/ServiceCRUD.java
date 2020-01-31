package com.example.transaction.service;

import java.util.List;
public interface ServiceCRUD <T, U> {

	List<T> findAll();

	T findByID(U id);

	void save(T object);

	void delete(T object);

	void deleteByID(U id);
}
