package com.Calculadora.dominio;

public class Calculadora {

    public static double sumar (double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b){
        return a * b;
    }

    public static double dividir (double a, double b) {
        return a/b;
    }

    public static double redondear (double numero) {
        double numeroRedondeado = Math.round(numero * 100.0) / 100.0;
        return numeroRedondeado;
    }

}
