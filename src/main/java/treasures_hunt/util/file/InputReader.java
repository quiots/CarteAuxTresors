package treasures_hunt.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    // A private constructor, which means that the class cannot be instantiated.
    private InputReader(){
        throw new IllegalStateException();
    }

    /**
     * It reads a file and returns a list of strings, each string being a line from the file
     *
     * @param fileName The name of the file to read.
     * @return A list of strings.
     */
    public static List<String> readInputFile(String fileName) throws IOException {
        List<String> fileLines = new ArrayList<>();
        // NB : The try-with-resources statement ensures that each resource is closed at the end of the statement.
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                fileLines.add(fileLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during the aptempt of reading file. Verify if file exists.");
            e.printStackTrace();
        }

        return fileLines;
    }

    /**
     * This function displays all the files in the directory 'src/main/resources/hunts/'
     */
    public static void displayFilesInDirectoryResources(){
        File dir = new File("src/main/resources/hunts/");
        File[] files = dir.listFiles();
        if(files!=null){
            for (File f : files) {
                System.out.println("- " + f.getName());
            }
        }
    }
}
