import com.github.sarxos.webcam.Webcam;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Picturerunnable implements Runnable{
    SendImage sendimage;
    Webcam webcam;
    ImageView imageid;
    public Picturerunnable(SendImage sendimage,Webcam webcam,ImageView imageid){
        this.webcam=webcam;
        this.sendimage=sendimage;
        this.imageid=imageid;
    }

    Image imageinput;
    public void run()  {
        imageinput = sendimage.sendimage(webcam);
        imageid.setImage(imageinput);

    }
}
