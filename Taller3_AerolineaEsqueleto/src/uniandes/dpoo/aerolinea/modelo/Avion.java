package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	private String nombre;
    private int capacidad;

    // Constructor
    public Avion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para capacidad
    public int getCapacidad() {
        return capacidad;
    }
}
