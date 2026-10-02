package com.uniajc.cuentasbancarias.parcial;

import java.util.Arrays;
import java.util.Scanner;

public class Paciente {
    private String nombre;
    private double[] temperaturas = new double[7];
    private final Scanner sc = new Scanner(System.in);

    public Paciente() {
        this.nombre = "";
    }

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void iniciarMenu() {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.print("Nombre del paciente: ");
            nombre = sc.nextLine();
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar temperaturas");
            System.out.println("2. Listar todas las temperaturas");
            System.out.println("3. Buscar una temperatura");
            System.out.println("4. Listar temperaturas mayores a 37,5");
            System.out.println("5. Mostrar la primera temperatura");
            System.out.println("6. Mostrar la última temperatura");
            System.out.println("7. Mostrar el promedio");
            System.out.println("8. Ordenar ascendentemente");
            System.out.println("9. Eliminar una temperatura");
            System.out.println("10. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < 7; i++) {
                        System.out.print("Temperatura " + (i + 1) + ": ");
                        registrar(i, sc.nextDouble());
                    }
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    System.out.print("Temperatura a buscar: ");
                    buscar(sc.nextDouble());
                    break;
                case 4:
                    listarFiebre();
                    break;
                case 5:
                    primera();
                    break;
                case 6:
                    ultima();
                    break;
                case 7:
                    promedio();
                    break;
                case 8:
                    ordenar();
                    break;
                case 9:
                    System.out.print("Temperatura a eliminar: ");
                    eliminar(sc.nextDouble());
                    break;
                case 10:
                    System.out.println("Fin del programa.... Adiós " + nombre);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 10);

        sc.close();
    }

    // 1. Registrar
    public void registrar(int posicion, double valor) {
        temperaturas[posicion] = valor;
    }

    // 2. Listar todas
    public void listar() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Posición " + (i + 1) + ": " + temperaturas[i] + "°C");
        }
    }

    // 3. Buscar
    public void buscar(double valor) {
        boolean encontrada = false;
        for (int i = 0; i < 7; i++) {
            if (temperaturas[i] == valor) {
                encontrada = true;
            }
        }
        if (encontrada) {
            System.out.println("La temperatura SÍ está registrada.");
        } else {
            System.out.println("La temperatura NO está registrada.");
        }
    }

    // 4. Mayores a 37,5 y mensaje de fiebre
    public void listarFiebre() {
        boolean fiebre = false;
        for (int i = 0; i < 7; i++) {
            if (temperaturas[i] > 37.5) {
                System.out.println(temperaturas[i]);
                fiebre = true;
            }
        }
        if (fiebre) {
            System.out.println("El paciente " + nombre + " presenta fiebre.");
        } else {
            System.out.println("No hay temperaturas mayores a 37,5.");
        }
    }

    // 5. Primera
    public void primera() {
        System.out.println("Primera temperatura: " + temperaturas[0]);
    }

    // 6. Última
    public void ultima() {
        System.out.println("Última temperatura: " + temperaturas[6]);
    }

    // 7. Promedio (no cuenta las eliminadas, que valen 0)
    public void promedio() {
        double suma = 0;
        int cantidad = 0;
        for (int i = 0; i < 7; i++) {
            if (temperaturas[i] != 0) {
                suma = suma + temperaturas[i];
                cantidad++;
            }
        }
        if (cantidad > 0) {
            System.out.println("Promedio: " + (suma / cantidad));
        } else {
            System.out.println("No hay temperaturas registradas.");
        }
    }

    // 8. Ordenar ascendentemente
    public void ordenar() {
        Arrays.sort(temperaturas);
        System.out.println("Temperaturas ordenadas.....");
    }

    // 9. "Eliminar": se deja la posición en 0
    public void eliminar(double valor) {
        for (int i = 0; i < 7; i++) {
            if (temperaturas[i] == valor) {
                temperaturas[i] = 0;
                System.out.println("Temperatura eliminada.");
                return;
            }
        }
        System.out.println("Esa temperatura no está registrada.");
    }
}