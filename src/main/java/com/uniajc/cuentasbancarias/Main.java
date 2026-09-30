package com.uniajc.cuentasbancarias;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("=== BANCO UNIAJC ===");
        System.out.println("1. Crear cuenta de ahorros");
        System.out.println("2. Crear cuenta corriente");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.print("Ingrese saldo inicial: ");
            float saldo = sc.nextFloat();
            System.out.print("Ingrese tasa anual: ");
            float tasa = sc.nextFloat();

            CuentaAhorros cuentaAhorros = new CuentaAhorros(saldo, tasa);

            while (true) {
                System.out.println("\n=== CUENTA DE AHORROS ===");
                System.out.println("1. Consignar");
                System.out.println("2. Retirar");
                System.out.println("3. Ver extracto mensual");
                System.out.println("4. Imprimir datos");
                System.out.println("5. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                if (opcion == 1) {
                    System.out.print("Ingrese valor a consignar: ");
                    cuentaAhorros.consignar(sc.nextFloat());
                } else if (opcion == 2) {
                    System.out.print("Ingrese valor a retirar: ");
                    cuentaAhorros.retirar(sc.nextFloat());
                } else if (opcion == 3) {
                    cuentaAhorros.extractoMensual();
                } else if (opcion == 4) {
                    cuentaAhorros.imprimir();
                } else if (opcion == 5) {
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }

        } else if (opcion == 2) {
            System.out.print("Ingrese saldo inicial: ");
            float saldo = sc.nextFloat();
            System.out.print("Ingrese tasa anual: ");
            float tasa = sc.nextFloat();

            CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo, tasa);

            while (true) {
                System.out.println("\n=== CUENTA CORRIENTE ===");
                System.out.println("1. Consignar");
                System.out.println("2. Retirar");
                System.out.println("3. Ver extracto mensual");
                System.out.println("4. Imprimir datos");
                System.out.println("5. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                if (opcion == 1) {
                    System.out.print("Ingrese valor a consignar: ");
                    cuentaCorriente.consignar(sc.nextFloat());
                } else if (opcion == 2) {
                    System.out.print("Ingrese valor a retirar: ");
                    cuentaCorriente.retirar(sc.nextFloat());
                } else if (opcion == 3) {
                    cuentaCorriente.extractoMensual();
                } else if (opcion == 4) {
                    cuentaCorriente.imprimir();
                } else if (opcion == 5) {
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }

        } else if (opcion == 3) {
            System.out.println("Gracias por usar el banco.");
        } else {
            System.out.println("Opción inválida.");
        }

        sc.close();
    }
}