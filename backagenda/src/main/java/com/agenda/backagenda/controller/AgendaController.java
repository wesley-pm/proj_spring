package com.agenda.backagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.backagenda.entity.Agenda;
import com.agenda.backagenda.service.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired  
    private AgendaService agendaService;

    @GetMapping("/")   
    @CrossOrigin("http://localhost:3000")
    public List<Agenda> buscarTodos(){
        return agendaService.buscarTodos();
    }
   
    @PostMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Agenda inserir(@RequestBody Agenda agenda){
        return agendaService.inserir(agenda);
    }

    @PutMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Agenda alterar(@RequestBody Agenda agenda){
        return agendaService.alterar(agenda);
    }

    @DeleteMapping("/{id}")  
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        agendaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
