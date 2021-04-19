package recorders;

import java.io.InputStream;

abstract class Recorder {
    private String fileName;
    private String recorderDetails;

    public Recorder(String fileName, String recorderDetails) {
        this.fileName = fileName;
        this.recorderDetails = recorderDetails;
    }

    abstract void shoot(InputStream is);

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRecorderDetails() {
        return recorderDetails;
    }

    public void setRecorderDetails(String recorderDetails) {
        this.recorderDetails = recorderDetails;
    }

    @Override
    public String toString() {
        return String.format("%s | %s",
                this.getRecorderDetails(),
                this.getFileName());
    }
}
