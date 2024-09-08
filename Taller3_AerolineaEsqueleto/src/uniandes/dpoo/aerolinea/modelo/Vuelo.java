import java.util.ArrayList;


import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
    // Atributos
    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private Collection<Tiquete> tiquetes;
    
    // Constructor
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
    	this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
    }
    
    // Métodos Getters
    public Ruta getRuta() {
        return ruta;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public Avion getAvion() {
        return avion;
    }
    
    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }
    
    // Método para vender tiquetes
    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
    	// Calcular el costo total de los tiquetes para el cliente
        int costoTotal = calculadora.calcularTarifa(this, cliente);
        int costoPorTiquete = costoTotal / cantidad;

        for (int i = 0; i < cantidad; i++) {
            // Generar un nuevo tiquete usando el generador de tiquetes
            Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, costoPorTiquete);
            tiquetes.add(tiquete);  // Agregar el tiquete a la colección de tiquetes del vuelo
            cliente.agregarTiquete(tiquete);  // Agregar el tiquete al cliente
        }

        // Retornar el costo total de los tiquetes vendidos
        return costoTotal;
    }
    
    // Método equals para comparar vuelos
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Vuelo other = (Vuelo) obj;
        
        return this.fecha.equals(other.fecha) &&
               this.ruta.equals(other.ruta) &&
               this.avion.equals(other.avion);
    }
}
 
