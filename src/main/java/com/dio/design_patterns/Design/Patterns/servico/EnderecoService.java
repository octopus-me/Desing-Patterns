package com.dio.design_patterns.Design.Patterns.servico;

import com.dio.design_patterns.Design.Patterns.models.Endereco;
import org.springframework.stereotype.Service;


public interface EnderecoService {
    Endereco getEndereco(String cep);
}
