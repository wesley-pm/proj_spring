package com.agenda.backagenda.entity;


import lombok.Data;

@javax.persistence.Entity
@javax.persistence.Table(name = "agenda")
@Data
public class Agenda {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    private String nomeContato;
    
  
    private String numeroContato;
    
}