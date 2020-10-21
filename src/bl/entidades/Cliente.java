/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.entidades;

import java.util.ArrayList;


public class Cliente extends Persona {

    /*inits*/
    private String fechaNacimiento;
    private String nacionalidad;
    private String id;
    private Playlist cancionesFavoritas;
    private Playlist albumesFavoritos;
    private Playlist artistasFavoritos;
    private Playlist queue;
    private final ArrayList<Playlist> allPlaylists = new ArrayList<>();
    
    
    /* constructors*/
    public Cliente(
            String nombre, String segundoNombre,
            String apellidos, String nickname, String password,
            String correo, String avatar, String fechaNacimiento,
            String nacionalidad, String id) {

        super(nombre, segundoNombre, apellidos, nickname, password, correo, avatar);
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.id = id;
        this.cancionesFavoritas = new Playlist("Canciones Favoritas", "favorito");
        this.artistasFavoritos = new Playlist("Artistas Favoritos", "favorito");
        this.albumesFavoritos = new Playlist("Albumes Favoritos", "favorito");
        this.queue = new Playlist("Cola de reproducción", "queue");
    }

    public Cliente(
            String nombre,
            String segundoNombre,
            String apellidos,
            String nickname,
            String password,
            String correo,
            String fechaNacimiento,
            String nacionalidad,
            String id) {
        super(nombre, segundoNombre, apellidos, nickname, password, correo, "");
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.id = id;
        this.cancionesFavoritas = new Playlist("Canciones Favoritas", "favorito");
        this.artistasFavoritos = new Playlist("Artistas Favoritos", "favorito");
        this.albumesFavoritos = new Playlist("Albumes Favoritos", "favorito");
        this.queue = new Playlist("Cola de reproducción", "queue");
    }

    
    public Cliente() {
    }
    
    
    /* metodos */

    public void setCancionFavorita(Cancion cancion) {

        ArrayList<Cancion> lista = cancionesFavoritas.getPlaylist();
        lista.add(cancion);

    }
    
    
    public void addPlaylist(Playlist nuevo) {

        allPlaylists.add(nuevo);

    }
    
    
    
    
    /*gets/sets*/

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getId() {
        return id;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Playlist getCancionesFavoritas() {
        return cancionesFavoritas;
    }

    public void setCancionesFavoritas(Playlist cancionesFavoritas) {
        this.cancionesFavoritas = cancionesFavoritas;
    }

    public ArrayList<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    public Playlist getAlbumesFavoritos() {
        return albumesFavoritos;
    }

    public void setAlbumesFavoritos(Playlist albumesFavoritos) {
        this.albumesFavoritos = albumesFavoritos;
    }

    public Playlist getArtistasFavoritos() {
        return artistasFavoritos;
    }

    public void setArtistasFavoritos(Playlist artistasFavoritos) {
        this.artistasFavoritos = artistasFavoritos;
    }

}
