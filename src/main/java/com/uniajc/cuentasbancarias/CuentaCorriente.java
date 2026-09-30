package com.uniajc.cuentasbancarias;

public class CuentaCorriente extends Cuenta {
    protected float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
    }

    public float getSobregiro() {
        return sobregiro;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                super.retirar(cantidad);
            } else {
                float deficit = cantidad - saldo;
                sobregiro += deficit;
                saldo = 0;
                numeroRetiros++;
            }
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            if (sobregiro > 0) {
                if (cantidad >= sobregiro) {
                    float remanente = cantidad - sobregiro;
                    sobregiro = 0;
                    saldo += remanente;
                } else {
                    sobregiro -= cantidad;
                }
            } else {
                super.consignar(cantidad);
            }
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Valor de sobregiro: $" + sobregiro);
    }
}
