package br.edu.infnet.appWagnerLemos.model.service;

import br.edu.infnet.appWagnerLemos.model.domain.ModelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public abstract class BaseService<T extends ModelEntity, U extends CrudRepository<T, Long>> {

    protected CrudRepository<T, Long> repository;

    public BaseService(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T create(T model) {
        return repository.save(model);
    }

    public Collection<T> getList() {
        return (Collection<T>) repository.findAll();
    }

    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Long getQuantidade() {
        return repository.count();
    }
}
