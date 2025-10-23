package com.example.agendamento_servicos_oficina.Repository;

import com.example.agendamento_servicos_oficina.Modal.ServicoModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <ServicoModal, Integer> {
}
