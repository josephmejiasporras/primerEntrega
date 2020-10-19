
package bl.entidades.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UI extends Application {
    
    Stage window = new Stage();
    VBox layout = new VBox(50);
    Button boton = new Button("Click");
    Scene scene = new Scene(layout);
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        layout.getChildren().addAll(boton);
        
        layout.setMinWidth(200);
        layout.setMinHeight(200);
        window.setScene(scene);
        window.setTitle("Titulo");
        window.initStyle(StageStyle.TRANSPARENT);
        window.show();
        
    }
    
}
