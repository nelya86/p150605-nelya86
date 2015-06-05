/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Noelia
 */
public abstract class AudioPista {
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public AudioPista() {
    }

    /**
     * Método que establece los metadatos del spot.
     *
     * @param producto indica el nombre del producto.
     * @param anunciante indica el nombre de la empresea anunciante.
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Método que establece la duración.
     *
     * @param duracion indica la duración del audio, en segundos.
     * @throws IllegalArgumentException error cuando la duración es demasiado larga.
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > 120) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Método para establecer un vínculo con el fichero de audio.
     *
     * @param nombre_archivo nombre del fichero que introduzco
     * @return true si el archivo existe y false si no existe.
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * Método que sirva para poner las cuñas en cola de reproducción
     *
     * Puede devolver un valor entero con un còdigo de error, los valores que
     * indican errores son siempre negativos.
     * Si se produce un error en lasterrormsg contiene una descripción del error
     * relacionado con el código negativo devuelto.
     *
     * @param cola_reproduccion orden que van a llevar los anuncios.
     * @return resultado
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date fecha_reproduccion) {
        int resultado = checkDatos();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int checkDatos();

    /**
     * Método que exporta una cuña completa.
     *
     * Puede devolver un valor entero con un còdigo de error, los valores que
     * indican errores son siempre negativos.
     * Si se produce un error en lasterrormsg contiene una descripción del error
     * relacionado con el código negativo devuelto.
     *
     * Exporta (audio+ metadatos) a un formato propio (.daf, acrónimo Daf Audio Format).
     * @param objeto_daw la cuña completa que introduzco para que luego se exporte.
     * @return resultado
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
