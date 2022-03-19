package Taller.com.app;

import Taller.com.dominio.Agenda;

public class AgendaApp {
    public static void main(String[] args) {

        Agenda miAgenda = new Agenda();

        miAgenda.agregar("Andres", "Cardona", 3148952798l);
        miAgenda.agregar("Jessica", "Alarcon", 3233986371l);
        miAgenda.agregar("Nelson", "Correa", 3136132582l);
        miAgenda.agregar("Liliana", "Betancur", 3136942247l);
        miAgenda.agregar("Daniela", "Giraldo", 3215301833l);

        miAgenda.ordenarAlfabeticamente();

        System.out.println("\n----------------------------------\n");

        miAgenda.eliminar(3215301833l);
        miAgenda.editar(3148952798l, 3113145082l);

        System.out.println("\n BUSCAR EL NUEVO NUMERO \n");
        miAgenda.buscarPorCelularConFilter(3148952798l);
        System.out.println("\n---------------------------------------\n");
        miAgenda.buscarPorApellido("Alarcon");
        miAgenda.buscarPorNombre("Andres");

    }
}
