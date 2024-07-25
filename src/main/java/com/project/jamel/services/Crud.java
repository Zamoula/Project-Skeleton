package com.project.jamel.services;

import com.project.jamel.repositories.GenericRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

public abstract class Crud<T,ID> {
    protected abstract GenericRepository<T, ID> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public T update(ID id, T entity) {
        if(getRepository().existsById(id)) {
            T existingInstance = getRepository().getReferenceById(id);

            Class<?> clazz = existingInstance.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if ("id".equals(field.getName())) {
                        continue;
                    }
                    Object newValue = field.get(entity);
                    field.set(existingInstance, newValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return getRepository().save(existingInstance);
        } else {
            return null;
        }
    }

    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
