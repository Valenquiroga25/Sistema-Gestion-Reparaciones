package main;

import excepciones.alreadyExistsExceptions.ClienteAlreadyExistsException;
import excepciones.notFoundExceptions.ClienteNotFoundException;
import gui.VentanaControlador;

public class Main {
    public static void main(String[] args) throws ClienteAlreadyExistsException, ClienteNotFoundException {
        new VentanaControlador();
    }
}
