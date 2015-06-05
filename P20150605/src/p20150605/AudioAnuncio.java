package p20150605;

import java.io.File;
import java.util.Date;

/**
 * Clase que sirve para gestionar cuñas de anuncios publicitarios en radios.
 * 
 * Cada objeto se referirá a una cuña diferente. Es capaz de almacenar metadatos
 * sobre el anuncio y una referencia al archivo de audio que lo oontiene. También
 * permite acciones tales como programar la cuña dentro de una secuencia de audio
 * clips y
 * @author Noelia
 * @version 1.0.1
 * @see P20150605
 */
public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * Constructor que sirve para crear una cuña.
     * 
     */
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * Método que establece los metadatos del spot.
     * 
     * @param producto indica el nombre del producto.
     * @param anunciante indica el nombre de la empresea anunciante.
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    

    protected int checkDatos() {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
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
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
