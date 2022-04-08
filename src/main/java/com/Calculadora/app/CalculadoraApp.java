package com.Calculadora.app;

import com.Calculadora.dominio.Calculadora;

import javax.swing.*;
import java.util.Arrays;

public class CalculadoraApp {

    public static ImageIcon iconoInicial = new ImageIcon(Calculadora.class.getResource("/Iconos/calculadora.png"));
    public static ImageIcon iconoSuma = new ImageIcon(CalculadoraApp.class.getResource("/Iconos/suma.gif"));
    public static ImageIcon iconoResta = new ImageIcon(Calculadora.class.getResource("/Iconos/resta.png"));
    public static ImageIcon iconoMultiplicacion = new ImageIcon(Calculadora.class.
            getResource("/Iconos/multiplicacion.jpg"));
    public static ImageIcon iconoDivision = new ImageIcon(Calculadora.class.getResource("/Iconos/division.gif"));
    public static JCheckBox redondear = new JCheckBox("Redondear");

    public static void main(String[] args) {
        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, "Elija una opcion: ",
                    "Calculadora", 0, 0, iconoInicial, Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", redondear).toArray(), 0);


            if (opcion!=JOptionPane.CLOSED_OPTION)  {
                switch (opcion) {
                    case -1: {
                        break;
                    }
                    case 0: {
                        double a = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese un numero",
                                "Suma", 0 , iconoSuma, null, 0));
                        double b = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese otro numero ", "Suma",
                                0 , iconoSuma, null, 0));
                        if (redondear.isSelected()){
                            double numero = Calculadora.redondear(Calculadora.sumar(a, b));
                            imprimirMensaje("La suma de los numeros es: " + numero);
                        } else {
                            imprimirMensaje("La suma de los numeros es: " + Calculadora.sumar(a, b));
                        }
                        break;
                    }
                    case 1: {
                        double a = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese un numero",
                                "Resta", 0 , iconoResta, null, 0));
                        double b = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese otro numero ", "Resta",
                                0 , iconoResta, null, 0));
                        if (redondear.isSelected()){
                            double numero = Calculadora.redondear(Calculadora.restar(a, b));
                            imprimirMensaje("La resta de los numeros es: " + numero);
                        } else {
                            imprimirMensaje("La resta de los numeros es: " + Calculadora.restar(a, b));
                        }
                        break;
                    }
                    case 2: {
                        double a = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese un numero",
                                "Multiplicar", 0 , iconoMultiplicacion, null, 0));
                        double b = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese otro numero ", "Multiplicar",
                                0 , iconoMultiplicacion, null, 0));
                        if (redondear.isSelected()) {
                            double numero = Calculadora.redondear(Calculadora.multiplicar(a, b));
                            imprimirMensaje("La multiplicacion de los numeros es: " + numero);
                        } else {
                            imprimirMensaje("La multiplicacion de los numeros es: " + Calculadora.multiplicar(a, b));
                        }
                        break;
                    }
                    case 3: {
                        double a = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese un numero",
                                "Dividir", 0 , iconoDivision, null, 0));
                        double b = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese otro numero ", "Dividir",
                                0 , iconoDivision, null, 0));
                        double numero = Calculadora.redondear(Calculadora.dividir(a,b));
                        if (b!=0) {
                            if (redondear.isSelected()) {
                                imprimirMensaje("La division de los numeros es: " + numero);
                            } else {
                                imprimirMensaje("La division de los numeros es: " + Calculadora.dividir(a, b));
                            }
                        } else {
                            imprimirMensaje("No se puede dividir por cero. ");
                        }
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
            } else if (opcion==JOptionPane.CLOSED_OPTION) {
                break;
            }
        }
    }
    public static void imprimirMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "resultado", JOptionPane.PROPERTIES);
    }


}

