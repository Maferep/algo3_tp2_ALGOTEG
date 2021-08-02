package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
    El evento base que se debe usar para mostrar pantallas
*/ 
public class EventoVista implements EventHandler<ActionEvent>{
    IVista vista;
    public EventoVista(IVista vista){
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent event) {
        vista.visualizar();
    }
}