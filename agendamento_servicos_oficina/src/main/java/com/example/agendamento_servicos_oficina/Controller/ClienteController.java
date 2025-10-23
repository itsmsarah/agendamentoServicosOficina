package com.example.agendamento_servicos_oficina.Controller;

import com.example.agendamento_servicos_oficina.Modal.ClienteModal;
import com.example.agendamento_servicos_oficina.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/oficina/clientes")
public class ClienteController {
    @Autowired

    private ClienteRepository clienteRepository;

    @PostMapping

    public ResponseEntity<ClienteModal> cadastrarClientes(@Validated @RequestBody ClienteModal cliente){
        ClienteModal salvo = clienteRepository.save(cliente);
        return  ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping

    public List<ClienteModal> listarCluentes(){
        return clienteRepository.findAll();
    }



}
