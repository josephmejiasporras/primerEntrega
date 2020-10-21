package bl.entidades.ui;

import bl.entidades.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class UI extends Application {
    

    /*init*/
    protected static Stage initWindow = new Stage();
    protected static Stage loginWindow = new Stage();
    protected static  Stage principal = new Stage();
    protected Administrador usuarioActual2 = new Administrador();
    protected static int cent = 0;
    protected int chosen;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    
    
    /*mock data*/
    
    private final Cliente usuarioActual = new Cliente("Joseph", "", "Mejias Porras", "capricornjoe", " 1234", "jmejiasp@ucenfotec.ac.cr", "10-01-1994", "costarica", "111");
    
    /*Obtiene path y devuelve objeto Image de JavaFX*/
    private static Image convertImage(String path, double width, double height, boolean preserveRatio, boolean smooth) throws FileNotFoundException {
        File file = new File(path);
        FileInputStream stream = new FileInputStream(file);
        Image output = new Image(stream, width, height, preserveRatio, smooth);
        return output;
    }

    
    /* recibe objetos de control y carga escena */

    public static void loadMainCliente(Persona cliente, Button cerrar, Stage mainWindow, VBox navigation, BorderPane mainBorder) {
       
        
        HBox topMenu = new HBox();
        HBox closeMenu = new HBox();
        topMenu.setMinWidth(800);
        closeMenu.setMinWidth(1195);
        closeMenu.setAlignment(Pos.TOP_RIGHT);
        closeMenu.getChildren().addAll(cerrar);
        topMenu.getChildren().addAll(closeMenu);
        cerrar.getStyleClass().add("closeButton");
        /*LeftBar*/
        
        
        navigation.getStyleClass().add("navigationBar");
        navigation.setAlignment(Pos.TOP_LEFT);
        /*Estructura*/
        mainBorder.setTop(topMenu);
        mainBorder.setLeft(navigation);
        mainBorder.setMinHeight(700);
        mainBorder.setMinWidth(1200);
        Scene scene = new Scene(mainBorder);
        scene.getStylesheets().add("style.css");
        mainWindow.initStyle(StageStyle.UNDECORATED);
        mainWindow.setScene(scene);
        
    }

    
    
    /* recibe objetos de control y devuelve escena de Importar cancion */
    public static VBox importScene(TextField songName, TextField artistName, Button confirmImport){
    
        songName.setPromptText("Nombre de la canción");
        artistName.setPromptText("Nombre del artista");
        confirmImport.setText("Crear canción");
        VBox importLayout = new VBox(10);
        importLayout.getChildren().addAll(songName,artistName, confirmImport);
        
        return importLayout;
    }
    
    
    
    
    
    
    /* recibe arraylist de nombres y devuelve escena de artistas */
    
    
    public static TableView artistScene(ArrayList<Artista> artistas){
        
        
        
        ObservableList<Artista> listado = FXCollections.observableArrayList();
        ArrayList<Artista> lista = artistas;
        TableView<Artista> songsLayout = new TableView();
        
        for (int i = 0; i < lista.size(); i++) {
            listado.add(lista.get(i));
        }
        
        
        /* Columna nombre */
        TableColumn<Artista, String> nombre = new TableColumn<>("Nombre"); 
        nombre.setMinWidth(200);
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        
        songsLayout.setMaxWidth(800);
        songsLayout.setMaxHeight(500);
        songsLayout.setItems(listado);
        songsLayout.getColumns().addAll(nombre);
        
        return songsLayout;
    }
    
    
    
    
    
    
    public static TableView playlistView(ArrayList<Artista> artistas){
        
        
        
        ObservableList<Artista> listado = FXCollections.observableArrayList();
        ArrayList<Artista> lista = artistas;
        TableView<Artista> songsLayout = new TableView();
        
        for (int i = 0; i < lista.size(); i++) {
            listado.add(lista.get(i));
        }
        
        
        /* Columna nombre */
        TableColumn<Artista, String> nombre = new TableColumn<>("Nombre"); 
        nombre.setMinWidth(200);
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        
        songsLayout.setMaxWidth(800);
        songsLayout.setMaxHeight(500);
        songsLayout.setItems(listado);
        songsLayout.getColumns().addAll(nombre);
        
        return songsLayout;
    }
    
    
    
    
    
    
    private static String retornando;
    public static String createPlaylist(){
        
        
        
        Stage stageConfirm = new Stage();
        stageConfirm.setMaxWidth(250);
        stageConfirm.setMaxHeight(250);
        Label label = new Label("Escribe el nombre de la Playlist Nueva");
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button("Cancelar");
        TextField input = new TextField();
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label, input, aceptar, cancelar);
        Scene scene = new Scene(layout);
        stageConfirm.initStyle(StageStyle.UNDECORATED);
        stageConfirm.setScene(scene);
        
        aceptar.setOnAction(e->{
        retornando = input.getText();
        stageConfirm.close();
        });
        
        cancelar.setOnAction(e->{
        stageConfirm.close();
        });
        
        stageConfirm.showAndWait();
        
        return retornando;
        
    }
    
    /* recibe Playlist de canciones Favoritas y devuelve escena desplegando las canciones */
    public static TableView songsScene(Playlist playlist){
        
        ObservableList<Cancion> listado = FXCollections.observableArrayList();
        ArrayList<Cancion> lista = playlist.getPlaylist();
        TableView<Cancion> songsLayout = new TableView();
        
        for (int i = 0; i < lista.size(); i++) {
            listado.add(lista.get(i));
        }
        
        
        /* Columna nombre */
        TableColumn<Cancion, String> nombre = new TableColumn<>("Nombre"); 
        nombre.setMinWidth(200);
        nombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        /* Columna artista */
        TableColumn<Cancion, String> artista = new TableColumn<>("Artista"); 
        artista.setMinWidth(200);
        artista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));
        
        
        songsLayout.setMaxWidth(800);
        songsLayout.setMaxHeight(500);
        songsLayout.setItems(listado);
        songsLayout.getColumns().addAll(nombre, artista);
        
        return songsLayout;
    }
    
    
    
    
    
    
    
    
     /* recibe Playlist de canciones Favoritas y devuelve escena desplegando las canciones */
    public static HBox artistScene(Playlist playlist){
    
        ArrayList<Cancion> lista = playlist.getPlaylist();
        HBox songsLayout = new HBox();
        
        for (int i = 0; i < lista.size(); i++) {
            Button button = new Button(lista.get(i).getName());
            songsLayout.getChildren().addAll(button);
        }
        
        return songsLayout;
    }
    
    /* Animacion de Bienvenida */
    public void loadLogo() throws InterruptedException, FileNotFoundException {

        Image closeButton = convertImage("C:\\Users\\capri\\Downloads\\cancel.png", 300, 300, true, true);
        ImageView closeButtonIv = new ImageView(closeButton);
        VBox welcomeBox = new VBox();
        welcomeBox.getChildren().add(closeButtonIv);
        Scene welcome = new Scene(welcomeBox);

        welcomeBox.setMinHeight(300);
        welcomeBox.setMinWidth(300);

        PauseTransition delay = new PauseTransition(Duration.seconds(2));

        delay.setOnFinished(e -> {
            initWindow.close();
        });
        delay.play();

        initWindow.initStyle(StageStyle.TRANSPARENT);
        initWindow.setScene(welcome);
        initWindow.showAndWait();

    }

    /**
     * 
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */

    public int initApp() throws FileNotFoundException, InterruptedException {

        /* TOP MENU */
        HBox topMenu = new HBox();

        Button close = new Button();
        Image closeButton = convertImage("C:\\Users\\capri\\Downloads\\cancel.png", 30, 30, true, true);
        ImageView closeButtonIv = new ImageView(closeButton);
        Image minimizeButton = convertImage("C:\\Users\\capri\\Downloads\\minimize.png", 30, 30, true, true);
        ImageView minimizeButtonIv = new ImageView(minimizeButton);
        close.setGraphic(closeButtonIv);
        close.setOnAction(e -> {
            if (ConfirmBox.display("", "Está seguro que desea cerrar?")) {
                loginWindow.close();
            }
        });

        Button minimize = new Button();
        minimize.setGraphic(minimizeButtonIv);
        topMenu.getChildren().addAll(minimize, close);
        topMenu.setAlignment(Pos.TOP_RIGHT);
        topMenu.setPadding(new Insets(10, 10, 10, 10));
        minimize.setOnAction(e -> {
            loginWindow.setIconified(true);
        });
        /* Login Scene */

        VBox layout = new VBox();
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            chosen = 1;
            loginWindow.close();
        });

        TextField correo = new TextField();
        layout.setPadding(new Insets(10, 10, 10, 10));
        PasswordField contraseña = new PasswordField();

        layout.getChildren().addAll(topMenu, correo, contraseña, loginButton);
        layout.setMinWidth(400);
        layout.setMinHeight(400);

        Scene scene = new Scene(layout);
        loginWindow.setScene(scene);
        loginWindow.initStyle(StageStyle.TRANSPARENT);
        loginWindow.showAndWait();
        return chosen;
    }

    
    
    
    public Persona getUsuarioActual() {
        return usuarioActual;
    }

    public Persona getAdministrador() {
        return usuarioActual2;
    }

    public static Stage getMainWindow() {
        return principal;
    }

}
