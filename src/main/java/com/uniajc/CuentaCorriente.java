package com.uniajc;

public class CuentaCorriente extends Cuenta {
    protected float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual, float sobregiro) {
        super(saldo, tasaAnual);
        this.sobregiro = sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public void consignar(float cantidad) { }

    @Override
    public void retirar(float cantidad) { }

    @Override
    public void calcularInteres() { }
    
}
