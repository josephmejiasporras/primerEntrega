
package bl.entidades;


public class Cancion {
    
    
    
    
    private String name;
    private Artista artista;
    private String nombreArtista;
    private Genero genero;
    
    public Cancion(String name){
        this.name = name;
    }
    public Cancion(String name, Genero genero){
        this.name = name;
        this.genero = genero;
    }

    
    
    
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Artista getArtista() {
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
        this.nombreArtista= artista.getNombre();
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getNombreArtista() {
        return nombreArtista;
    }


}
