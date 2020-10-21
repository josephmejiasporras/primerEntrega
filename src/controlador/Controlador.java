package controlador;

import bl.entidades.*;
import bl.entidades.ui.*;
import bl.logica.Gestor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controlador extends Application {

    /*init Controlador*/
    private final UI ui = new UI();

    public static void ejecutar() throws FileNotFoundException {

        Controlador.launch(Controlador.class);

    }

    /*ejecutando*/
    @Override
    public void start(Stage primaryStage) throws Exception {
/*
        ui.loadLogo();
        int action = ui.initApp();*/
        switch (1) {
            case 1:
                loadMain(ui.getUsuarioActual());
                break;
        }

    }

    /*interfaz del Cliente*/
    private void interfazCliente(Cliente cliente) {

        /*init objetos de Control*/
        Stage stage = UI.getMainWindow();
        Button importar = new Button("Importar");
        Button confirmImport = new Button("Importar Cancion");
        
        Button canciones = new Button("Canciones");
        Button cuenta = new Button("Cuenta");
        Button artistas = new Button("Artistas");
        Button cerrar = new Button("X");
        Button AddPlaylist = new Button("+");
        
        Label bibliotecaLabel = new Label("Biblioteca");
        TextField songName = new TextField();
        TextField artistName = new TextField();
        BorderPane mainBorder = new BorderPane();
        VBox navigation = new VBox(20);
        Label playlists = new Label("Playlists");
        VBox box = new VBox(5);
        ArrayList<Playlist> allPlaylists = cliente.getAllPlaylists();
        for (int i = 0; i < allPlaylists.size(); i++) {
            Button inside = new Button(allPlaylists.get(i).getNombre());
            box.getChildren().addAll(inside);
        }
        
        HBox containerPlaylist = new HBox();
        containerPlaylist.getChildren().addAll(playlists, AddPlaylist);
        
        /*----------node*/
        navigation.getChildren().addAll(cuenta, importar, bibliotecaLabel, canciones, artistas, containerPlaylist, box);

        /* basic styling*/
        
        

        /*load UI screen*/
        UI.loadMainCliente(cliente, cerrar, stage, navigation, mainBorder);

        /**
         * *acciones***
         */
        
        
        /* cerrar app */
        cerrar.setOnAction(e -> {

            if (ConfirmBox.display("", "Esta seguro que desea salir de la aplicación?")) {
                stage.close();
            }

        });

        /*NAVIGATION/*
        
        /*mostrar panel Importar*/
        importar.setOnAction(e -> {

            mainBorder.setCenter(UI.importScene(songName, artistName, confirmImport));

        });

        /*mostrar playlist de Canciones Favoritas*/
        canciones.setOnAction(e -> {

            mainBorder.setCenter(UI.songsScene(cliente.getCancionesFavoritas()));

        });

        /* Mostrar artistas*/
        artistas.setOnAction(e -> {

            ArrayList<Artista> listaArtistas = Gestor.getArtistas();
            mainBorder.setCenter(UI.artistScene(listaArtistas));

        });

        /* add playlist */
        AddPlaylist.setOnAction(e -> {
            
            String key = UI.createPlaylist();
            if (key == null) {

            } else {
                Playlist playlist = new Playlist(key, "personal");
                cliente.addPlaylist(playlist);
                
                for (int i = 0; i < allPlaylists.size(); i++) {
                    
                    
                    Button inside = new Button(allPlaylists.get(i).getNombre());
                    box.getChildren().addAll(inside);
                }
            }

        });

        /*IMPORTAR*/
        
        
        /*Click Importar Cancion*/
        confirmImport.setOnAction(e -> {

            Cancion cancion = Gestor.crearCancion(songName.getText());
            Artista artist = new Artista(artistName.getText(), "", cancion);
            cancion.setArtista(artist);
            Gestor.addArtista(artist);
            cliente.setCancionFavorita(cancion);
            artistName.setText("");
            songName.setText("");

        });
        
        
        

        /*showAndWait*/
        stage.showAndWait();
    }

    /////////////////////////////////////////////////////////////////////
    
    /*carga interfaz dependiendo de Usuario*/
    private void loadMain(Persona usuarioActual) {

        if (usuarioActual instanceof Cliente) {

            interfazCliente(usuarioActual.convertirACliente(usuarioActual, "nothing", "nothing", "nothing"));

        } else if (usuarioActual instanceof Administrador) {

        }

        System.out.println("El App ha finalizado");

    }

}
