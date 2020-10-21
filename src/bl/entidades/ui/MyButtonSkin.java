/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.entidades.ui;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;


public class MyButtonSkin extends ButtonSkin {

    public MyButtonSkin(Button control) {
        super(control);

        final FadeTransition fadeIn = new FadeTransition(Duration.millis(90));
        fadeIn.setNode(control);
        fadeIn.setToValue(0.5);
        control.setOnMouseEntered(e -> fadeIn.playFromStart());

        final FadeTransition fadeOut = new FadeTransition(Duration.millis(250));
        fadeOut.setNode(control);
        fadeOut.setToValue(1);
        control.setOnMouseExited(e -> fadeOut.playFromStart());

        control.setOpacity(1);
    }

}
