package com.example.agendamento_servicos_oficina.Modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name= "servicos")
public class ServicoModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="servico_id")
    private int servicoId;

    @Column( name = "nome")
    private String nome;

    @Column(name="descricao")
    private  String descricao;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;


    @Column(name = "criacao_servico", updatable = false)
    @CreationTimestamp
    private LocalDateTime criacaoServico;


    @OneToMany(mappedBy = "servico")
    @JsonManagedReference(value = "servico-agendamentos")
    private List<AgendamentoModal> agendamentos;


    public ServicoModal (){

    }

    public ServicoModal(int servicoId, String nome, String descricao, BigDecimal preco, LocalDateTime criacaoServico, List<AgendamentoModal> agendamentos) {
        this.servicoId = servicoId;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.criacaoServico = criacaoServico;
        this.agendamentos = agendamentos;
    }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDateTime getCriacaoServico() {
        return criacaoServico;
    }

    public void setCriacaoServico(LocalDateTime criacaoServico) {
        this.criacaoServico = criacaoServico;
    }

    public List<AgendamentoModal> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoModal> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
