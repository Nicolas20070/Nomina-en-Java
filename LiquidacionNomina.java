import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleado {
    private String nombres;
    private String apellidos;
    private String documento;
    private int diasTrabajados;
    private double salarioBasico;
    private double subsidioTransporte;

    public Empleado(String nombres, String apellidos, String documento, int diasTrabajados, double salarioBasico) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.salarioBasico = salarioBasico;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public double getSubsidioTransporte() {
        return subsidioTransporte;
    }

    public double calcularSubsidioTransporte() {
        return (162.000 / 30) * diasTrabajados;
    }

    public double calcularTotalDevengos() {
        return (salarioBasico * diasTrabajados) + subsidioTransporte;
    }

    public double calcularTotalDescuentos() {
        return salarioBasico * 0.08;
    }

    public double calcularSalarioNeto() {
        return calcularTotalDevengos() - calcularTotalDescuentos();
    }
}

public class LiquidacionNomina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        System.out.println("📑 Bienvenido al sistema de liquidación de nómina 📊\n");

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        System.out.println("\n👩‍💼👨‍💼 Ingrese la información de los empleados:");

        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("\n👉 Datos del empleado " + (i + 1) + ":");
            System.out.print("Nombres: ");
            String nombres = scanner.next();
            System.out.print("Apellidos: ");
            String apellidos = scanner.next();
            System.out.print("Documento: ");
            String documento = scanner.next();
            System.out.print("Días trabajados: ");
            int diasTrabajados = scanner.nextInt();
            System.out.print("Salario básico: ");
            double salarioBasico = scanner.nextDouble();

            empleados.add(new Empleado(nombres, apellidos, documento, diasTrabajados, salarioBasico));
        }

        System.out.println("\n--- 💼 Resultados de la liquidación de nómina 💰 ---\n");

        for (Empleado empleado : empleados) {
            System.out.println("👩‍💼👨‍💼 Empleado: " + empleado.getNombres() + " " + empleado.getApellidos());
            System.out.println("\uD83E\uDEAA\uD83E\uDEAADocumento: " + empleado.getDocumento());
            System.out.println("Total devengos: 💵 " + empleado.calcularTotalDevengos());
            System.out.println("Total descuentos: 💸 " + empleado.calcularTotalDescuentos());
            System.out.println("SubsidioTransporte: 💸 " + empleado.calcularSubsidioTransporte());
            System.out.println("Salario neto a pagar: 💰 " + empleado.calcularSalarioNeto());
            System.out.println();
        }

        scanner.close();
    }
}