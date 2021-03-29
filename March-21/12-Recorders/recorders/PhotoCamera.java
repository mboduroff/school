package recorders;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

public class PhotoCamera extends Recorder {
    private String resolution;
    private double opticalZoom;
    private static final String fileExtension = ".jpg";

    public PhotoCamera(String fileName, String recorderDetails,
                       String resolution, double opticalZoom) {
        super(fileName + fileExtension, recorderDetails);
        this.resolution = resolution;
        this.opticalZoom = opticalZoom;
    }

    public PhotoCamera(Recorder recorder,
                       String resolution, double opticalZoom) {
        super(recorder.getFileName() + fileExtension, recorder.getRecorderDetails());
        this.resolution = resolution;
        this.opticalZoom = opticalZoom;
    }

    @Override
    void shoot(InputStream is) {
        try (PrintWriter out = new PrintWriter(super.getFileName())) {
            out.println(is);
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %s | %s",
                this.getResolution(),
                this.getOpticalZoom());
    }

    public double getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(double opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
