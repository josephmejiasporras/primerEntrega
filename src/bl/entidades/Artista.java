
package bl.entidades;

import java.util.ArrayList;

/**
 *
 * @author capri
 */
public class Artista extends Persona{
    
    protected String nacionalidad;
    protected ArrayList<Cancion> repertorio = new ArrayList<>();  
    
    public Artista(
            String nombre,
            String nacionalidad,
            Cancion cancion) {
        this.setNombre(nombre);
        this.nacionalidad = nacionalidad;
        repertorio.add(cancion);
    }
    
}
