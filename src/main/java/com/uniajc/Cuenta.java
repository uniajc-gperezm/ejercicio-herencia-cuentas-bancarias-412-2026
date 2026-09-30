package com.uniajc;

/**
 * Clase base que modela una cuenta bancaria.
 */
public class Cuenta {

    protected float saldo;
    protected int   numeroConsignaciones = 0;
    protected int   numeroRetiros        = 0;
    protected float tasaAnual;
    protected float comisionMensual      = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo     = saldo;
        this.tasaAnual = tasaAnual;
    }

    public float getSaldo()                  { return saldo; }
    public void  setSaldo(float saldo)       { this.saldo = saldo; }

    public int  getNumeroConsignaciones()                        { return numeroConsignaciones; }
    public void setNumeroConsignaciones(int numeroConsignaciones){ this.numeroConsignaciones = numeroConsignaciones; }

    public int  getNumeroRetiros()                  { return numeroRetiros; }
    public void setNumeroRetiros(int numeroRetiros) { this.numeroRetiros = numeroRetiros; }

    public float getTasaAnual()                { return tasaAnual; }
    public void  setTasaAnual(float tasaAnual) { this.tasaAnual = tasaAnual; }

    public float getComisionMensual()                    { return comisionMensual; }
    public void  setComisionMensual(float comisionMensual){ this.comisionMensual = comisionMensual; }

    /**
     * Suma la cantidad al saldo e incrementa el contador de consignaciones.
     */
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numeroConsignaciones++;
        }
    }

    /**
     * Resta la cantidad al saldo si hay fondos suficientes.
     * El valor a retirar no debe superar el saldo.
     */
    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
        } else {
            System.out.println("Retiro no permitido: fondos insuficientes.");
        }
    }

    /**
     * Calcula el interés mensual y lo suma al saldo.
     * Interés = saldo * (tasaAnual / 12) / 100
     */
    public void calcularInteres() {
        float interesMensual = saldo * (tasaAnual / 12) / 100;
        saldo += interesMensual;
    }

    /**
     * Extracto mensual: resta comisión al saldo y calcula interés.
     */
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }
}