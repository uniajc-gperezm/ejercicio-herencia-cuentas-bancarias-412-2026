package com.uniajc;

public class CuentaAhorros extends Cuenta {

    protected boolean activa;

    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        this.activa = (saldo >= 10000);
    }

    @Override
    public void consignar(float cantidad) {
        if (!activa) {
            System.out.println("Cuenta inactiva. No se puede consignar.");
            return;
        }
        super.consignar(cantidad);
    }

    @Override
    public void retirar(float cantidad) {
        if (!activa) {
            System.out.println("Cuenta inactiva. No se puede retirar.");
            return;
        }
        super.retirar(cantidad);
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual = 1000 * (numeroRetiros - 4);
        } else {
            comisionMensual = 0;
        }
        super.extractoMensual();
        activa = (saldo >= 10000);
    }

    public void imprimir() {
        int transacciones = numeroConsignaciones + numeroRetiros;
        System.out.println("===== CUENTA DE AHORROS =====");
        System.out.println("Saldo:            $" + saldo);
        System.out.println("Comision mensual: $" + comisionMensual);
        System.out.println("Transacciones:     " + transacciones);
        System.out.println("Estado:            " + (activa ? "ACTIVA" : "INACTIVA"));
        System.out.println("=============================");
    }
}