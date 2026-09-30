package com.uniajc;

public class Main {
    public static void main(String[] args) {

        // ── PRUEBA CUENTA DE AHORROS (Jefferson) ──
        System.out.println("=== CUENTA DE AHORROS ===");
        CuentaAhorros ahorros = new CuentaAhorros(50000, 0.12f);
        ahorros.consignar(20000);
        ahorros.retirar(10000);
        ahorros.retirar(10000);
        ahorros.retirar(10000);
        ahorros.retirar(10000);
        ahorros.retirar(10000); // retiro 5 → cobra comisión
        ahorros.extractoMensual();
        ahorros.imprimir();

        System.out.println("---");

        // ── PRUEBA CUENTA CORRIENTE (Compañero) ──
        System.out.println("=== CUENTA CORRIENTE ===");
        CuentaCorriente corriente = new CuentaCorriente(30000, 0.12f);
        corriente.retirar(40000); // genera sobregiro de 10000
        corriente.consignar(25000); // cubre el sobregiro
        corriente.extractoMensual();
        corriente.imprimir();
    }
}