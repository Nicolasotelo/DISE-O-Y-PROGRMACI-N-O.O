package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	protected static final double IMPUESTO = 0.28;

    /**
     * Calcula el costo base del vuelo para un cliente específico.
     * 
     * @param vuelo El vuelo del cual se calculará el costo base.
     * @param cliente El cliente para el cual se calculará el costo base.
     * @return El costo base del vuelo.
     */
    public abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula el porcentaje de descuento aplicable para un cliente específico.
     * 
     * @param cliente El cliente para el cual se calculará el porcentaje de descuento.
     * @return El porcentaje de descuento aplicable.
     */
    public abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula la tarifa total aplicando impuestos y descuentos.
     * 
     * @param vuelo El vuelo para el cual se calculará la tarifa total.
     * @param cliente El cliente para el cual se calculará la tarifa total.
     * @return La tarifa total con impuestos y descuentos incluidos.
     */
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) (costoBase * (1 - descuento));
        int valorImpuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + valorImpuestos;
    }

    /**
     * Calcula la distancia del vuelo basado en la ruta proporcionada.
     * 
     * @param ruta La ruta del vuelo.
     * @return La distancia del vuelo en kilómetros.
     */
    protected int calcularDistanciaVuelo(Ruta ruta) {
        return ruta.getDistancia();  
    }

    /**
     * Calcula el valor de los impuestos sobre un costo base.
     * 
     * @param costoBase El costo base sobre el cual se calcularán los impuestos.
     * @return El valor de los impuestos.
     */
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }

}
