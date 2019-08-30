package webcm;
import com.github.sarxos.webcam.Webcam;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class main{
    public static  void main(String args[])
    {
        Webcam webcam =Webcam.getDefault();
   /* webcam.addWebcamListener(new WebcamListener() {
        @Override
        public void webcamOpen(WebcamEvent we) {
            System.out.print("OPENED");
        }

        @Override
        public void webcamClosed(WebcamEvent we) {
            System.out.print("closed");
        }

        @Override
        public void webcamDisposed(WebcamEvent we) {
            System.out.print("disposed");
        }

        @Override
        public void webcamImageObtained(WebcamEvent we) {
            System.out.print("taken");
        }
    });*/


        webcam.setViewSize(new Dimension(640,480));

        webcam.open();



        try {
            ImageIO.write(webcam.getImage(),"JPG",new File("MY.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}