package com.uniajc;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world desde la rama Cuentas!");

/*      
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000.0f, 0.05f);

        cuentaAhorros.imprimir(); // Saldo: 15000.0f, Activa: true

        cuentaAhorros.consignar(5000.0f); // Saldo: 20000.0f
        cuentaAhorros.retirar(2000.0f); // Saldo: 18000.0f

        cuentaAhorros.imprimir(); // Saldo: 18000.0f, Activa: true

        cuentaAhorros.retirar(1000.0f); // Saldo: 17000.0f

        cuentaAhorros.extractoMensual(); // Comision mensual: 0.0f, Saldo: 17000.0f
    
        cuentaAhorros.imprimir(); // Saldo: 17000.0f, Activa: true

        cuentaAhorros.retirar(7000.0f); // Saldo: 10000.0f
        cuentaAhorros.retirar(1000.0f); // Saldo: 9000.0f

        cuentaAhorros.imprimir(); // Saldo: 9000.0f, Activa: false

        cuentaAhorros.extractoMensual(); // Comision mensual: 0.0f, Saldo: 9000.0f
    
        cuentaAhorros.consignar(11000.0f);
        cuentaAhorros.retirar(500.0f);
        cuentaAhorros.extractoMensual(); // Comision mensual: 1000f, Saldo: 19500.0f
        cuentaAhorros.imprimir(); // Saldo: 20000.0f, Activa: true
    */

        CuentaCorriente cuentaCorriente = new CuentaCorriente(10000.0f, 0.05f);

        
        cuentaCorriente.imprimir(); // Saldo: 10000.0f, Sobregiro: 0.0f

        cuentaCorriente.retirar(15000.0f); // Saldo: 0.0f, Sobregiro: 5000.0f

        cuentaCorriente.imprimir(); // Saldo: 0.0f, Sobregiro: 5000.0f


        cuentaCorriente.retirar(10000); // Saldo: 0.0f, Sobregiro: 15000.0f
        cuentaCorriente.imprimir();


    }
}