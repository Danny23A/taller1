package com.Taller.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DispensadorSnack {
    private List<Snack> snacks;
    private long cantidadActual;
    private int capacidad = 12;

    public DispensadorSnack() {
        this.snacks = new ArrayList<>();
    }

    public void agregar(String nombre, String codigo, long valor) {
        Snack snackAAgregar = new Snack(nombre, codigo, valor);
        if ((this.snacks.size() + 1) <= this.capacidad){
            this.snacks.add(snackAAgregar);
        } else {
            System.out.println("¡ERROR! Capacidad llena");
        }
    }

    public void sacarSnackPorCodigo(String codigo) {
        Snack snackASacar = buscarSnackXCodigo(codigo);
        if ((snackASacar != null)&&(snackASacar.getCantidad()>0)) {
            this.cantidadActual = snackASacar.getCantidad()-1;
            snackASacar.setCantidad(this.cantidadActual);
            System.out.println("El snack "+ snackASacar.getNombre() + " ha sido retirado");
        }
        else if ((snackASacar != null)&&(snackASacar.getCantidad()==0)){
            System.out.println("El snack se encuentra agotado.");
        }
        else {
            System.out.println("No se ha podido retirar el snack, ¡NO EXISTE!");
        }
    }

    public void sacarSnackPorNombre(String nombre) {
        Snack snackARetirar = this.snacks.stream()
                .filter(snackName -> snackName.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
        if ((snackARetirar != null)&&(snackARetirar.getCantidad()>0)){
            this.cantidadActual = snackARetirar.getCantidad()-1;
            snackARetirar.setCantidad(this.cantidadActual);
            System.out.println("El snack " + snackARetirar.getNombre() + " ha sido retirado");
            System.out.println("Quedan: " +snackARetirar.getCantidad());
        }
        else if ((snackARetirar != null)&&(snackARetirar.getCantidad()==0)) {
            System.out.println("El snack se encuentra agotado.");
        }
        else {
            System.out.println("No se ha podido retirar el snack, ¡NO EXISTE!");
        }
    }

    public void aumentarSnack(String codigo, long cantidadAAumentar) {
        Snack snackAumentado = buscarSnackXCodigo(codigo);
        if ((snackAumentado != null)&&(snackAumentado.getCantidad()<6)){
            this.cantidadActual = snackAumentado.getCantidad() + cantidadAAumentar;
            if (this.cantidadActual <= 6) {
                snackAumentado.setCantidad(this.cantidadActual);
                System.out.println("El snack "+snackAumentado.getNombre() + "ha sido rebastecido en "
                        + cantidadAAumentar + " unidades");
            }
            else {
                System.out.println("¡ERROR! Has excedido la cantidad permitida.");
            }
        } else {
            System.out.println("¡ERROR! El snack no existe.");
        }
    }

    public void quitarSnack(String codigo) {
        Snack snackAQuitar = buscarSnackXCodigo(codigo);
        if (snackAQuitar != null) {
            this.snacks.remove(snackAQuitar);
            System.out.println("Se ha removido el snack " + snackAQuitar.getNombre());
        } else {
            System.out.println("¡ERROR!  el snack no existe.");
        }
    }

    public Snack cantidadSnack(String codigo) {
        Snack cantidadSnack = buscarSnackXCodigo(codigo);
        if ((cantidadSnack != null)&&(cantidadSnack.getCantidad()>0)){
            System.out.println("Quedan: " +cantidadSnack.getCantidad() + " unidades del snack " +cantidadSnack.getNombre());
            return cantidadSnack;
        } else {
            System.out.println("El snack no existe en la maquina O se encuentra agotado.");
            return null;
        }
    }

    public List<Snack> snackAgotados() {
        List<Snack> snackAgotados = this.snacks.stream()
                .filter(snack -> snack.getCantidad()==0)
                .collect(Collectors.toList());
        if (snackAgotados != null) {
            System.out.println("Snacks agotados: ");
            snackAgotados.forEach(snackD -> System.out.println(snackD.getNombre()+" --> "+snackD.getValor()));
            return snackAgotados;
        } else {
            System.out.println("No hay ningun snack agotado.");
            return null;
        }
    }

    public List<Snack> snackDisponibles() {
        List<Snack> snackDisponibles = this.snacks.stream()
                .filter(snack -> snack.getCantidad()>0)
                .collect(Collectors.toList());
        if (snackDisponibles != null) {
            System.out.println("Snacks disponibles: ");
            snackDisponibles.forEach(snackD -> System.out.println(snackD.getNombre()+" --> "+snackD.getValor()));
            return snackDisponibles;
        } else {
            System.out.println("No queda ningun snack disponible.");
            return null;
        }
    }

    public void snackOrdenadaPrecio () {
        this.snacks.sort(Comparator.comparing(Snack::getValor).reversed());
        this.listaDeSnacks();
    }

    public void snackOrdenadaCantidad () {
        this.snacks.sort(Comparator.comparing(Snack::getCantidad));
        this.listaDeSnacks();
    }

    private Snack buscarSnackXCodigo(String codigo) { // Buscando con filter los snacks por codigo.
        Snack snackCodigo = this.snacks.stream()
                .filter(snackCod -> snackCod.getCodigo().equalsIgnoreCase(codigo))
                .findFirst().orElse(null);
        if (snackCodigo != null) {
            return snackCodigo;
        } else {
            return null;
        }
    }

    private void listaDeSnacks () {
        this.snacks.forEach(snack -> System.out.println(snack.getNombre() + " "
                + snack.getCodigo() + " --> " + snack.getValor() + " cantidad: " + snack.getCantidad()));
    }
}
