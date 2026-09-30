package com.uniajc;

public class CuentaAhorros extends Cuenta {
    // Único atributo propio de esta subclase
    protected boolean activa;

    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        this.activa = (saldo >= 10000);
    }

    @Override
    public void consignar(float cantidad) {
      
        if (!activa && (saldo + cantidad) >= 10000) {
            activa = true;
        }

        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("Cuenta inactiva. El saldo debe alcanzar al menos $10,000 para operar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            
            if (saldo < 10000) {
                activa = false;
            }
        } else {
            System.out.println("Cuenta inactiva. No se pueden realizar retiros.");
        }
    }

    @Override
    public void extractoMensual() {
     
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
    
        super.extractoMensual();

       
        this.activa = (saldo >= 10000);
    }

    public void imprimir() {
        System.out.println("--- DATOS CUENTA DE AHORROS ---");
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Número de consignaciones: " + numeroConsignaciones);
        System.out.println("Número de retiros: " + numeroRetiros);
        System.out.println("Número de transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Estado de la cuenta: " + (activa ? "Activa" : "Inactiva"));
    }
}