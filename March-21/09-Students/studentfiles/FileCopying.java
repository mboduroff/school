package studentfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileCopying {
    public static void main(String[] args) {
        var sourcePath = new File("students.txt");
        var destinationPath = new File("students1.txt");

        try {
            Files.copy(sourcePath.toPath(), destinationPath.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
