package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja {
	private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQ = 0.02;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;


    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
    	int distancia = vuelo.getRuta().getDistancia();
        int costoPorKm;

        if (cliente instanceof ClienteNatural) {
            costoPorKm = COSTO_POR_KM_NATURAL;
        } else if (cliente instanceof ClienteCorporativo) {
            costoPorKm = COSTO_POR_KM_CORPORATIVO;
        } else {
            throw new IllegalArgumentException("Tipo de cliente no soportado");
        }

        return distancia * costoPorKm;

    }


    public double calcularPorcentajeDescuento(Cliente cliente) {
    	if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            int tamano = corporativo.getTamanoEmpresa();

            switch (tamano) {
                case ClienteCorporativo.GRANDE:
                    return DESCUENTO_GRANDES;
                case ClienteCorporativo.MEDIANA:
                    return DESCUENTO_MEDIANAS;
                case ClienteCorporativo.PEQUENA:
                    return DESCUENTO_PEQ;
                default:
                    throw new IllegalArgumentException("Tamaño de empresa no reconocido");
            }
        }
        return 0.0;
    }

}
