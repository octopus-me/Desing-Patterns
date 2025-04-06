package com.dio.design_patterns.Design.Patterns.servico.serviceImplementations;

import com.dio.design_patterns.Design.Patterns.beans.JacksonObjectMapper;
import com.dio.design_patterns.Design.Patterns.beans.Okhttp;
import com.dio.design_patterns.Design.Patterns.models.Endereco;
import com.dio.design_patterns.Design.Patterns.servico.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EnderecoSeriveImplementation1 implements EnderecoService {

    private String BASEURL = "https://viacep.com.br/ws/";

    @Autowired
    Okhttp okhttp;

    @Autowired
    JacksonObjectMapper mapper;

    @Override
    public Endereco getEndereco(String cep) {

        OkHttpClient client = okhttp.getClient();
        ObjectMapper objectMapper = mapper.getMapper();

        Request request = new Request.Builder().url(BASEURL + cep + "/json/").build();

        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                assert response.body() != null;
                String responseString =  response.body().string();

                return objectMapper.readValue(responseString, Endereco.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
