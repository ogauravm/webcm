import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
class SendImage{

    Image sendimage(Webcam webcam)
    {

        ImageInput in=new ImageInput();


        BufferedImage bim;
        Image image;

        ImageInput imageinput=new ImageInput();



            bim=webcam.getImage();
            image= SwingFXUtils.toFXImage(bim,null);

            imageinput.setSource(image);
            imageinput.setX(20);
            imageinput.setY(100);

            return image;










            /*try {

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(scene);
                out.flush();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }*/



    }
}

public class client extends Application {


    public static void main(String args[]) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Socket socket;


        // socket = new Socket("localhost", 5000) ;
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        webcam.open();
        //while (true) {

            SendImage sendimage = new SendImage();

            Group root = new Group();
            Rectangle rect = new Rectangle();
            root.getChildren().add(rect);
            Label l=new Label();
            root.getChildren().add(l);
            Scene scene = new Scene(root, 800, 800, Color.BLACK);
        Image imageinput = sendimage.sendimage(webcam);
        ImageView imageid=new ImageView(imageinput);
        l.setGraphic(imageid);

            stage.setTitle("CLIENT");
        stage.setScene(scene);
        stage.show();
            int a=50;
            while (a!=0) {
                a--;

                //(new Thread(new Picturerunnable(sendimage,webcam,imageid))).start();
               /* imageinput = sendimage.sendimage(webcam);
                imageid.setImage(imageinput);*/
                new Thread(new Runnable(){
                    public void run(){
                       ImageInput imaginput = new SendImage.sendimage(webcam);
                        imageid.setImage(imageinput);
                    }
                }).start();
                Thread.sleep(50);
                System.out.println(a+" ");

            }

            System.out.println("CLOSED");
            webcam.close();




    }
}
