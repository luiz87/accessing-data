package com.example.accessingdata;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

    public Produto findById(int id);
    public Iterable<Produto> findAll(Sort sort);

}