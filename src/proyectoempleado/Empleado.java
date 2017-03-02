/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempleado;

/**
 *
 * @author carlosjoseanguiano
 */

public class Empleado {

	private static double pagoPorHora;
	private String nif;
	private String nombre;
	private double sueldo;
	private double horaExtra;
	private double tipoIRPF;

    public char getCasado() {
        return casado;
    }

    public void setCasado(char casado) {
        this.casado = casado;
    }
        private char casado;  //S ó N
	private int numeroHijos;

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(double horaExtra) {
		this.horaExtra = horaExtra;
	}

	public double getTipoIRPF() {
		return tipoIRPF;
	}

	public void setTipoIRPF(double tipoIRPF) {
		this.tipoIRPF = tipoIRPF;
	}


	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public static double getPagoPorHora() {
		return pagoPorHora;
	}

	public static void setPagoPorHora(double pagoPorHora) {
		Empleado.pagoPorHora = pagoPorHora;
	}

	public Empleado(String nif) {
		this.nif = nif;
	}

	public Empleado() {

	}

	public double calcularImporteHorasExtras() {
		return horaExtra * pagoPorHora;
	}

	public double calcularsueldoBruto() {
		return sueldo + calcularImporteHorasExtras();
	}

	public double calcularRetencionIrpf(){
        double tipo = tipoIRPF;
        if(casado == 's' || casado == 'S') {
            tipo = tipo - 2; //2 puntos menos si está casado
        }
        tipo = tipo - numeroHijos; //un punto menos por cada hijo
        if(tipo<0){
            tipo = 0;
        }
        return calcularsueldoBruto()* tipo / 100;
    }

	public double calcularSueldo() {

		return calcularsueldoBruto() - calcularRetencionIrpf();
	}

	@Override
	public String toString() {
		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", sueldo=" + sueldo + ", horaExtra=" + horaExtra
				+ ", tipoIRPF=" + tipoIRPF + ", casado=" + casado + ", numeroHijos=" + numeroHijos + "]";
	}

	

}
