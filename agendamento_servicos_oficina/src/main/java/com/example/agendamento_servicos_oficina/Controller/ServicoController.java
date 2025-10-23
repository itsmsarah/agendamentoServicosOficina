package com.example.agendamento_servicos_oficina.Controller;


import com.example.agendamento_servicos_oficina.Modal.ClienteModal;
import com.example.agendamento_servicos_oficina.Modal.ServicoModal;
import com.example.agendamento_servicos_oficina.Repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/oficina/servico")
public class ServicoController {

    @Autowired

    private ServicoRepository servicoRepository;

    @PostMapping

    public ResponseEntity<ServicoModal> cadastrarServico(@Validated @RequestBody ServicoModal servico){
        ServicoModal salvo;
        salvo = servicoRepository.save(servico);
        return  ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping

    public List<ServicoModal> listarServicos(){
        return servicoRepository.findAll();
    }
}
