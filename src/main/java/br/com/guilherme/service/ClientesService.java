package br.com.guilherme.service;

import br.com.guilherme.model.Cliente;
import br.com.guilherme.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    //nessa caso o Spring já entenderia, podendo eliminar o construtor, realizando a orquestração e injeção da dependencia
    @Autowired
    private ClientesRepository repository;

//    pode ser usado como uma alternativa
//    @Autowired
//    public void setRepository(ClientesRepository repository) {
//        this.repository = repository;
//    }

//    com construtor complementando a declaração da classe utilizada, não é necessário a notação @Autowired
//    @Autowired
    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
