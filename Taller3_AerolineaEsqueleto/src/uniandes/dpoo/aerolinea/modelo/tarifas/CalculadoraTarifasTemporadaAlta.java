package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;


public class CalculadoraTarifasTemporadaAlta {
	private static final int COSTO_POR_KM = 1000;

    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
    	int distancia = vuelo.getRuta().getDistancia();
        return distancia * COSTO_POR_KM;

    }

    public double calcularPorcentajeDescuento(Cliente cliente) {
    	return 0.0;
    }

}
