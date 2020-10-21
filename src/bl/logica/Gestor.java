package bl.logica;

import bl.entidades.*;
import java.util.ArrayList;

public class Gestor {

    protected static ArrayList<Persona> personas = new ArrayList<>();
    protected static ArrayList<Cancion> canciones = new ArrayList<>();
    protected static ArrayList<Artista> artistas = new ArrayList<>();
    protected static Cliente usuarioActual = new Cliente();
    
    
    /* crea cliente y la registra en la bd de clientes*/
    public static void crearCliente(Cliente cliente) {
        getPersonas().add(cliente);
    }
    
    
    /* crea cancion y la registra en la bd de canciones*/
    public static Cancion crearCancion(String name) {
        
        Cancion cancion = new Cancion (name);
        getCanciones().add(cancion);
        return cancion;
    }
    
    public static Cancion crearCancion(String name, String artist) {
        
        Cancion cancion = new Cancion(name);
        getCanciones().add(cancion);
        return cancion;
    }
    
    
    
    
    
    /*Imprime Playlist names*/
    public static void printPlaylist(Playlist example){
        
        ArrayList<Cancion> lista = example.getPlaylist();
        
        for (int i = 0; i < lista.size(); i++) {
            Cancion cancion = lista.get(i);
            System.out.println(cancion.getName());
        }
    }
    
    
    public static void getClientes() {
        getPersonas().forEach(cliente -> {
            System.out.println(cliente);
        });
    }

    public static ArrayList<Persona> getPersonas() {
        return personas;
    }

    public static void setPersonas(ArrayList<Persona> aPersonas) {
        personas = aPersonas;
    }

    public static ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public static void setCanciones(ArrayList<Cancion> aCanciones) {
        canciones = aCanciones;
    }

    public static Cliente getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Cliente aUsuarioActual) {
        usuarioActual = aUsuarioActual;
    }
    
    public static ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public static void addArtista(Artista artista) {
        artistas.add(artista);
    }
    
    

}
