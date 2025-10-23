package com.example.agendamento_servicos_oficina.Controller;

import com.example.agendamento_servicos_oficina.Modal.AgendamentoModal;

import com.example.agendamento_servicos_oficina.Repository.AgendamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/oficina/agendamentos")

public class AgendamentoController {
    @Autowired

    private AgendamentoRepository agendamentoRepository;

    @PostMapping

    public ResponseEntity<AgendamentoModal> cadastrarAgendamento(@Validated @RequestBody AgendamentoModal agendamento){
        AgendamentoModal salvo = agendamentoRepository.save(agendamento);
        return  ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping

    public List<AgendamentoModal> listarAgendamentos(){
        return agendamentoRepository.findAll();
    }

    @GetMapping("/{agendamentoId}")
    public ResponseEntity<AgendamentoModal> buscarAgendamento(@PathVariable int agendamentoId) {
        return agendamentoRepository.findById(agendamentoId).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{agendamentoId}")

    public ResponseEntity<AgendamentoModal> atualizarAgendamento(@PathVariable int agendamentoId, @Validated @RequestBody AgendamentoModal novoAgendamento){
        return agendamentoRepository.findById(agendamentoId)
                .map(agendamento -> {
                    agendamento.setCliente(novoAgendamento.getCliente());
                    agendamento.setServico(novoAgendamento.getServico());
                    agendamento.setDataAgendada(novoAgendamento.getDataAgendada());
                    agendamento.setObservacoes(novoAgendamento.getObservacoes());
                    agendamento.setStatus(novoAgendamento.getStatus());

                    AgendamentoModal atualizado = agendamentoRepository.save(agendamento);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{agendamentoId}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable int agendamentoId){
        if(!agendamentoRepository.existsById(agendamentoId)){
            return ResponseEntity.notFound().build();
        }
        agendamentoRepository.deleteById(agendamentoId);
        return ResponseEntity.noContent().build();
    }

}



