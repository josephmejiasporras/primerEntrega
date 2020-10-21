

package bl.entidades;

import java.util.ArrayList;


public class Playlist {
    
    private String nombre;
    private String tipo;
    private ArrayList<Cancion> playlist = new ArrayList<>();
    
    public Playlist (){
        
    }
    public Playlist (String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public void addSong(Cancion toAdd){
        playlist.add(toAdd);
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Cancion> getPlaylist() {
        return playlist;
    }
    public void setPlaylist(ArrayList<Cancion> playlist) {
        this.playlist = playlist;
    }

}
