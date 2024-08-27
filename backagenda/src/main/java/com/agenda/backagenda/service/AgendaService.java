package com.agenda.backagenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.backagenda.entity.Agenda;
import com.agenda.backagenda.repository.AgendaRepository;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> buscarTodos(){
        return agendaRepository.findAll();

    }
    public Agenda inserir(Agenda agenda){
        return agendaRepository.saveAndFlush(agenda);
    }

    public Agenda alterar(Agenda agenda){
        return agendaRepository.saveAndFlush(agenda);
    }

    public void excluir(Long id){
        Agenda agenda = agendaRepository.findById(id).get();
        agendaRepository.delete(agenda);
    }

}
