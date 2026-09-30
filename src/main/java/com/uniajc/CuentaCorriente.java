package com.uniajc;

public class CuentaCorriente extends Cuenta {
    protected float sobregiro = 0;

    
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        this.sobregiro = 0;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser mayor que cero.");
            return;
        }

        
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            
            float restante = cantidad - saldo;
            sobregiro += restante;
            saldo = 0;
            numeroRetiros++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a consignar debe ser mayor que cero.");
            return;
        }

        
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                float residuo = cantidad - sobregiro;
                sobregiro = 0;
                saldo += residuo;
            } else {
                sobregiro -= cantidad;
            }
            numeroConsignaciones++;
        } else {
            // Si no hay sobregiro, se consigna normalmente
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    public void imprimir() {
        System.out.println("--- DATOS CUENTA CORRIENTE ---");
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Número de consignaciones: " + numeroConsignaciones);
        System.out.println("Número de retiros: " + numeroRetiros);
        System.out.println("Número de transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Monto en sobregiro: $" + sobregiro);
    }
}