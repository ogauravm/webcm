import javafx.scene.Scene;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ReceiveImage {

    int waiting = 1;

    Scene receive(int port) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        Scene scene=(Scene)in.readObject();
        return scene;

    }
}
