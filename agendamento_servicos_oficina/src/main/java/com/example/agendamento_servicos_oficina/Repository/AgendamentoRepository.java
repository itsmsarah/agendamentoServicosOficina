package com.example.agendamento_servicos_oficina.Repository;

import com.example.agendamento_servicos_oficina.Modal.AgendamentoModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModal, Integer> {
}
