package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	protected List<Tiquete> tiquetes;

    public Cliente() {
        tiquetes = new ArrayList<>();
    }

    public abstract String getTipoCliente();
    public abstract String getIdentificador();

    public void agregarTiquete(Tiquete tiquete) {
    	this.tiquetes.add(tiquete);
    }

    public int calculaValorTotalTiquetes() {
        int total = 0;
        for (Tiquete tiquete : tiquetes) {
            total += tiquete.getTarifa();
        }
        return total;
    }

    public void usarTiquetes(Vuelo vuelo) {
    	for (Tiquete tiquete : tiquetes) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
            }
        }
    }
    
    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

}
