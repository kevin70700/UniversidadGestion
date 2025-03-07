package co.edu.uniquindio.poo.model;

public class Nota {
    private String nombre;
    private double valor;

    public Nota(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

