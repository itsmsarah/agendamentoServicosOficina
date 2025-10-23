package com.example.agendamento_servicos_oficina.Repository;

import com.example.agendamento_servicos_oficina.Modal.ClienteModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModal, Integer> {
}
