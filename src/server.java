import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class server extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {

        while (true) {ReceiveImage receiveImage = new ReceiveImage();
        Scene scene;
        primaryStage.setTitle("SEREVR");
        primaryStage.show();

            scene = receiveImage.receive(5000);
            primaryStage.setScene(scene);

        }
    }
}