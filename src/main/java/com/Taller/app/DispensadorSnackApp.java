package com.Taller.app;

import com.Taller.dominio.DispensadorSnack;

public class DispensadorSnackApp {
    public static void main(String[] args) {

        DispensadorSnack miSnack = new DispensadorSnack();
        miSnack.agregar("Doritos", "D002", 2000);
        miSnack.agregar("Chessetres", "D023", 1500);
        miSnack.agregar("Salchichas", "D416", 6000);
        miSnack.agregar("Mamzana", "D000", 3000);

        miSnack.quitarSnack("D000");

        miSnack.sacarSnackPorCodigo("D416");
        miSnack.sacarSnackPorNombre("Doritos");


        miSnack.snackOrdenadaPrecio();
        System.out.println("------------Lista Por Cantidad-----------");
        miSnack.snackOrdenadaCantidad();
        miSnack.snackDisponibles();
        miSnack.snackAgotados();
        System.out.println("----------Buscando un Snack -----------");
        miSnack.cantidadSnack("D002");
        System.out.println("----------AUMENTANDO UN SNACK---------");
        miSnack.aumentarSnack("D002", 2);
        miSnack.aumentarSnack("D023", 15);
        miSnack.cantidadSnack("D002");

    }

}
