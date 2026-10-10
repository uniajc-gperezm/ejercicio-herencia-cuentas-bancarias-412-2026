package com.uniajc;

public class CuentaCorriente extends Cuenta {
    protected float sobregiro = 0f;

    CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
    }

    // Caso 1:
    // Saldo = 100.000
    // sobregiro = 0;
    // consignarMonto = 50.000
    // saldo final = 150.000

    // Caso 2:
    // Saldo = 0
    // sobregiro = 80.000
    // consignarMonto = 30.000
    // saldo final = 0
    // sobregiro = 50.000

    // Caso 3:
    // Saldo = 0
    // sobregiro = 50.000
    // consignarMonto = 150.000
    // saldo final = 100.000
    // sobregiro final = 0

    // Caso 4:
    // saldo = 0
    // consignarMonto = 50.000 
    // saldo final = 50.000
    // retirarMonto = 120.000
    // saldo final = 0
    // sobregiro final = 70.000

    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                super.consignar(cantidad);
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
    }
    
    // Caso 1: 
    // Saldo = 10.000
    // retirar = 5.000
    // saldo final = 5.000
    // sobregiro = 0

    // Caso 2:
    // sobregiro = 20.000
    // retirar = 25.000
    // saldo final = 0
    // sobregiro = 45.000

    public void retirar(float cantidad) {
        System.out.println("Retirar -> " + cantidad);
        if (cantidad > saldo) {
            sobregiro = cantidad - saldo;
            System.out.println("Se ha retirado: " + saldo + ", sobregiro: " + sobregiro);
            super.retirar(saldo);
        } else {
            super.retirar(cantidad);
        }
    }

    public void extractoMensual() { 
        super.extractoMensual();
    }

    public void imprimir() {
        System.out.println("--------------------");
        super.imprimir();
        System.out.println("Sobregiro: " + sobregiro);
        System.out.println("--------------------");
    }
}
