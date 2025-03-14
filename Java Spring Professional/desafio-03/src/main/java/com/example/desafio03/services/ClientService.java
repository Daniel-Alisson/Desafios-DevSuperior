package com.example.desafio03.services;

import com.example.desafio03.dto.ClientDTO;
import com.example.desafio03.models.Client;
import com.example.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    // BUSCA POR ID
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    // BUSCA PAGINADA
    @Transactional(readOnly = true)
    public Page<ClientDTO> findByAll(Pageable pageable) {
        Page<Client> resultado = repository.findAll(pageable);
        return resultado.map(x -> new ClientDTO(x));
    }
}
