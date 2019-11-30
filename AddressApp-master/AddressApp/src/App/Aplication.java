//@author Savio Cardoso
package App;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Aplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainApp agenda = MainApp.getInstance();
        agenda.primaryStage = primaryStage;
        agenda.primaryStage.setTitle("AddressApp");
        agenda.primaryStage.getIcons().
                add(new Image("file:resources/images/agenda.png"));
        agenda.initRootLayout();
        agenda.showPersonOverview();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}