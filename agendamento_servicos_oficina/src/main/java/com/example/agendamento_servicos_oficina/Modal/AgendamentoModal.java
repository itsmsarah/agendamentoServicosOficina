package com.example.agendamento_servicos_oficina.Modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table (name = "agendamentos")
public class AgendamentoModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="agendamento_id")
    private int agendamentoId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference(value = "cliente-agendamentos")
    private ClienteModal cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    @JsonBackReference(value = "servico-agendamentos")
    private ServicoModal servico;



    @Column (name= "data_agendada")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAgendada;

    @Column (name = "observacoes")
    private String observacoes;

    @Column(name = "status")
    private String status;

    @Column(name = "criacao_agendamento", updatable = false)
    @CreationTimestamp
    private LocalDateTime criacaoAgendamento;

   public AgendamentoModal(){

   }

    public AgendamentoModal(int agendamentoId, ClienteModal cliente, ServicoModal servico, LocalDateTime dataAgendada, String observacoes, String status, LocalDateTime criacaoAgendamento) {
        this.agendamentoId = agendamentoId;
        this.cliente = cliente;
        this.servico = servico;
        this.dataAgendada = dataAgendada;
        this.observacoes = observacoes;
        this.status = status;
        this.criacaoAgendamento = criacaoAgendamento;
    }

    public int getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(int agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public ClienteModal getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModal cliente) {
        this.cliente = cliente;
    }

    public ServicoModal getServico() {
        return servico;
    }

    public void setServico(ServicoModal servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDateTime dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCriacaoAgendamento() {
        return criacaoAgendamento;
    }

    public void setCriacaoAgendamento(LocalDateTime criacaoAgendamento) {
        this.criacaoAgendamento = criacaoAgendamento;
    }
}
