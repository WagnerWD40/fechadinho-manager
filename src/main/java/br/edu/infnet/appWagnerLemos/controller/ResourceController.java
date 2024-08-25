package br.edu.infnet.appWagnerLemos.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public interface ResourceController<T> {
    @GetMapping("/listar")
    public Collection<T> getList();

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id);

    @PostMapping
    public T create(@RequestBody T campeao);

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id);
}
