package org.mrityunjoy24.repositories;

import java.util.List;

public interface IRepository<T> {
    void save(T t);

    T getById(int id);

    List<T> getAll();
}
