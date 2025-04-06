package com.dio.design_patterns.Design.Patterns.servico.serviceImplementations;

import com.dio.design_patterns.Design.Patterns.models.Cliente;
import com.dio.design_patterns.Design.Patterns.models.ClienteReposity;
import com.dio.design_patterns.Design.Patterns.models.Endereco;
import com.dio.design_patterns.Design.Patterns.models.EnderecoRepository;
import com.dio.design_patterns.Design.Patterns.servico.ClienteService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplemenation1 implements ClienteService {

    @Autowired
    ClienteReposity clienteReposity;


    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EnderecoSeriveImplementation1 enderecoSeriveImplementation1;


    @Override
    public Iterable<Cliente> getAll() {
        return clienteReposity.findAll();
    }

    @Override
    public Cliente getById(String cpf) {
        Optional<Cliente> cliente = clienteReposity.findById(cpf);
        return cliente.get();

    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return getCliente(cliente);
    }


    private Cliente getCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Optional<Endereco> endereco = enderecoRepository.findById(cep);

        if(endereco.isPresent()){
            cliente.setEndereco(endereco.get());

        } else {
            Endereco novoEndereco = enderecoSeriveImplementation1.getEndereco(cep);
            enderecoRepository.save(novoEndereco);
            cliente.setEndereco(novoEndereco);
        }

        return clienteReposity.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Optional<Cliente> clienteBD = clienteReposity.findById(cliente.getCpf());
        
        if(clienteBD.isPresent()){
            return getCliente(cliente);
        }
        return null;
    }

    @Override
    public void deleteCleinte(Cliente cliente) {

        clienteReposity.deleteById(cliente.getCpf());


    }
}
