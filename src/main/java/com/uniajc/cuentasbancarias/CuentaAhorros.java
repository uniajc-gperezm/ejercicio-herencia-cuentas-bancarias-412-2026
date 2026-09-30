package com.uniajc.cuentasbancarias;

public class CuentaAhorros extends Cuenta {
    protected boolean activa;

    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        this.activa = saldo >= 10000;
    }

    @Override
    public void retirar(float cantidad) { 
        if (activa) {
            super.consignar(cantidad);
        } else if (cantidad + saldo >= 10000) {
            super.consignar(cantidad);
            activa = true;
        }
        else {
            System.out.println("No se puede retirar: la cuenta está INACTIVA (saldo menor a $10,000).");
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            if (saldo < 10000) {
                activa = false;
            }
        }
        else {
            System.out.println("No se puede consignar: la cuenta está INACTIVA (saldo menor a $10,000).");
        }
    }
        
         
        
     

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        if (saldo < 10000) {
            activa = false;
        }
     }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cuenta activa: " + activa);
        System.out.println("Transacciones totales: " + (numeroConsignaciones + numeroRetiros));
    }
}
