package recorders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CamerasMain {
    public static void main(String[] args) {
        PhotoCamera photoCamera = new PhotoCamera("photo1", "Canon G7X",
                "1920x1080", 21.6);
        VideoCamera videoCamera = new VideoCamera("video1", "Sony A7",
                VideoRes.UHD, 41.2);

        InputStream is = null;
        try {
            is = new FileInputStream("\\employees.txt"); // example file
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит");
        }

        photoCamera.shoot(is);
        videoCamera.shoot(is);

    }
}
