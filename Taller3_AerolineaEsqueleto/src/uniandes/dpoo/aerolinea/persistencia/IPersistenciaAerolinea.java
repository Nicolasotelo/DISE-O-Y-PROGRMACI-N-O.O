package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {
	/**
     * Este método carga los datos de una aerolínea desde un archivo.
     * 
     * @param archivo La ruta del archivo desde donde se cargará la información de la aerolínea.
     * @param aerolinea El objeto Aerolinea donde se cargarán los datos.
     */
    void cargarAerolinea(String archivo, Aerolinea aerolinea);

    /**
     * Este método salva los datos de una aerolínea en un archivo.
     * 
     * @param archivo La ruta del archivo donde se guardará la información de la aerolínea.
     * @param aerolinea El objeto Aerolinea cuyos datos se guardarán.
     */
    void salvarAerolinea(String archivo, Aerolinea aerolinea);

}
