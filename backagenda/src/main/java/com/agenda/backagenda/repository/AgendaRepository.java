package com.agenda.backagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.backagenda.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    
}
