package com.dio.design_patterns.Design.Patterns.servico;

import com.dio.design_patterns.Design.Patterns.models.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService {
    Iterable<Cliente> getAll();

    Cliente getById(String cpf);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    void deleteCleinte(Cliente cliente);
}
