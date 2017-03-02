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

	 private static double pagoPorHoraExtra; //atributo de clase
    private String nif;
    private String nombre;
    private double sueldoBase;
    private int horasExtras;
    private double tipoIRPF;
    private char casado;  //S ó N
    private int numeroHijos;

    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
    }

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

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public char getCasado() {
        return casado;
    }

    public void setCasado(char casado) {
        this.casado = casado;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

  
 
	public Empleado(String nif) {
		this.nif = nif;
	}

	public Empleado() {

	}

	public double calcularImporteHorasExtras() {
		return horasExtras * pagoPorHoraExtra;
	}

	public double calcularsueldoBruto() {
		return sueldoBase + calcularImporteHorasExtras();
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
		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", sueldo=" + sueldoBase + ", horaExtra=" + horasExtras
				+ ", tipoIRPF=" + tipoIRPF + ", casado=" + casado + ", numeroHijos=" + numeroHijos + "]";
	}

	

}
