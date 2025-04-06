package com.dio.design_patterns.Design.Patterns.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteReposity extends CrudRepository<Cliente, String> {
}
