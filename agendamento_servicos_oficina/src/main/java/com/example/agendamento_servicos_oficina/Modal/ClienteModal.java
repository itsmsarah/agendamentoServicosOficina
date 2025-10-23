package com.example.agendamento_servicos_oficina.Modal;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name="cliente_id")
    private  int clienteId;

    @Column (name="nome")
    private String nome;

    @Column (name = "email" ,nullable = false, unique = true)
    private String email;

    @Column (name="telefone")
    private String telefone;

    @Column(name = "criacao_cliente", updatable = false)
    @CreationTimestamp
    private LocalDateTime criacaoCliente;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference(value = "cliente-agendamentos")
    private List<AgendamentoModal> agendamentos;



    public ClienteModal(){

    }

    public ClienteModal(int clienteId, String nome, String email, String telefone, LocalDateTime criacaoCliente, List<AgendamentoModal> agendamentos) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.criacaoCliente = criacaoCliente;
        this.agendamentos = agendamentos;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getCriacaoCliente() {
        return criacaoCliente;
    }

    public void setCriacaoCliente(LocalDateTime criacaoCliente) {
        this.criacaoCliente = criacaoCliente;
    }

    public List<AgendamentoModal> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoModal> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
