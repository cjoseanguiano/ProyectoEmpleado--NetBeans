/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempleado;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author carlosjoseanguiano
 */
public class ProyectoEmpleado {

    final static int MAXIMO_EMPLEADOS = 1;
    static Empleado[] empleados = new Empleado[MAXIMO_EMPLEADOS];
    static int indice = 0;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        double importe;
        Empleado empleado;
        leerEmpleado();
        if (numeroDeEmpleado() > 0) {

            System.out.println("\n\nEmpleados introducidos");
            mostrar();

            importe = leerImporteHoras();

            // Asignar el atributo estatico pagoPorHoraExtra
            Empleado.setPagoPorHora(importe);

            // Calcular el empleado que mas cobra
            empleado = empleadoQueMasCobra();
            System.out.println("\n\nEmpleado que mas cobra :");
            System.out.println(empleado);
            System.out.printf("Sueldo :%.2f%n", empleado.calcularSueldo());

            // Calcular el empleado que menos cobra
            empleado = empleadoQueMenosCobra();
            System.out.println("\n\nEmpleado que menos cobra :");
            System.out.println(empleado);
            System.out.printf("Sueldo :%.2f%n", empleado.calcularSueldo());

            // Calcular el empleado que mas cobra por horas extras
            empleado = empleadoCobrasMasHoraExtra();
            System.out.println("\n\nEmpleado que cobra mas por hora Extra :");
            System.out.println(empleado);
            System.out.printf("Total horas extras : %.2f", empleado.calcularImporteHorasExtras());

            // Calcular el empleado que menos cobra por hora extra
            empleado = empleadoCobrasMenosHoraExtra();

            ordenarPorSalario();
            System.out.println("\n\nEmpleado ordenado por salario :");
            mostrarEmpleadosySalarios();
        }
    }

    private static int numeroDeEmpleado() {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void leerEmpleado() throws IOException {
        Empleado e;
        String dni, nombre;
        double sueldoBase;
        int horasExtras;
        double tipoIRPF;
        char casado;  // S ó N
        int numeroHijos;
        int i, N;

        do {
            System.out.print("Número de empleados? ");
            N = entrada.nextInt();
        } while (N < 0 || N > MAXIMO_EMPLEADOS);

        for (i = 1; i <= N; i++) {
            entrada.nextLine(); //limpiar el intro
            System.out.println("Empleado " + i);
            System.out.print("Nif: ");
            dni = entrada.nextLine();
            System.out.print("Nombre: ");
            nombre = entrada.nextLine();
            System.out.print("Sueldo Base: ");
            sueldoBase = entrada.nextDouble();
            System.out.print("Horas extra: ");
            horasExtras = entrada.nextInt();
            System.out.print("Tipo de IRPF: ");
            tipoIRPF = entrada.nextDouble();
            System.out.print("Casado (S/N): ");
            casado = (char) System.in.read();
            System.out.print("Número de hijos: ");
            numeroHijos = entrada.nextInt();

            e = new Empleado(dni); //crear una nueva instancia de empleado

            e.setNombre(nombre);
            e.setSueldo(sueldoBase);
            e.setHoraExtra(horasExtras);
            e.setTipoIRPF(tipoIRPF);
            e.setCasado(Character.toUpperCase(casado));
            e.setNumeroHijos(numeroHijos);

            empleados[indice] = e; //se añade el empleado al array
            indice++;
        }
    }

    public static double leerImporteHoras() {
        return indice;
        // TODO Auto-generated method stub
    }

    public static void mostrar() {
        for (int i = 0; i < indice; i++) {
            System.out.println(empleados[i]);
        }
    }

    public static Empleado empleadoQueMasCobra() {
        // TODO Auto-generated method stub
        Empleado mayor = empleados[0];
        for (int i = 0; i < indice; i++) {
            if (empleados[i].calcularSueldo() > mayor.calcularSueldo()) {
                mayor = empleados[i];
            }
        }

        return mayor;
    }

    public static Empleado empleadoQueMenosCobra() {
        // TODO Auto-generated method stub
        Empleado menor = empleados[0];
        for (int i = 1; i < indice; i++) {
            if (empleados[i].calcularSueldo() < menor.calcularSueldo()) {
                menor = empleados[i];
            }
        }
        return menor;
    }

    public static Empleado empleadoCobrasMasHoraExtra() {
        // TODO Auto-generated method stub
        Empleado empleadoCobraMasHoraExtra = empleados[0];
        for (int i = 0; i < indice; i++) {
            if (empleados[i].calcularImporteHorasExtras() > empleadoCobraMasHoraExtra.calcularImporteHorasExtras()) {
                empleadoCobraMasHoraExtra = empleados[i];
            }
        }
        return empleadoCobraMasHoraExtra;
    }

    public static Empleado empleadoCobrasMenosHoraExtra() {
        // TODO Auto-generated method stub
        Empleado empleadoCobraMenosHoraExtra = empleados[0];
        for (int i = 0; i < indice; i++) {
            if (empleados[i].calcularImporteHorasExtras() < empleadoCobraMenosHoraExtra.calcularImporteHorasExtras()) {
                empleadoCobraMenosHoraExtra = empleados[i];
            }
        }
        return empleadoCobraMenosHoraExtra;
    }

    public static void ordenarPorSalario() {
        int i, j;
        Empleado aux;
        for (j = 0; j < indice - 1; j++) {
            if (empleados[j + 1].calcularSueldo() < empleados[j].calcularSueldo()) {
                aux = empleados[j + 1];
                empleados[j + 1] = empleados[j];
                empleados[j] = aux;
            }
        }
    }

    public static void mostrarEmpleadosySalarios() {
        for (int i = 0; i < indice; i++) {
            System.out.println(empleados[i]);
            System.out.printf("Sueldo %,2f %n", empleados[i].calcularSueldo());
        }
    }
}
