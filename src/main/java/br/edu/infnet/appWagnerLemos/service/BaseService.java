package br.edu.infnet.appWagnerLemos.service;

import br.edu.infnet.appWagnerLemos.domain.model.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BaseService<T extends Entity> {

    protected Map<Long, T> map = new HashMap<>();
    private Long id = 0L;

    public void create(T model) {
        Long newId = id + 1L;
        model.setId(newId);

        map.put(model.getId(), model);

        this.id = newId;
    }

    public Collection<T> getList() {
        return map.values();
    }

    public T getById(Long id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }

        throw new RuntimeException("Chave não encontrada: '" + id + "'");
    }
}
