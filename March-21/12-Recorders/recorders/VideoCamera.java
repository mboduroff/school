package recorders;

public class VideoCamera extends PhotoCamera {
    private static final String fileExtension = ".avi";
    private VideoRes resolution;

    public VideoCamera(String fileName, String recorderDetails,
                       VideoRes resolution, double opticalZoom) {
        super(fileName, recorderDetails, resolution.toString(), opticalZoom);
    }

    public VideoCamera(Recorder recorder,
                       VideoRes resolution, double opticalZoom) {
        super(recorder, resolution.toString(), opticalZoom);
    }
}
