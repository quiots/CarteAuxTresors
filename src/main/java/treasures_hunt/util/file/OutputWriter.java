package treasures_hunt.util.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    // A private constructor, which means that the class cannot be instantiated.
    private OutputWriter(){
        throw new IllegalStateException();
    }

    /**
     * It takes a list of strings and a name for the output file, and writes the strings to the output file
     *
     * @param lines the list of lines to write to the file
     * @param nameOutputFile The name of the output file.
     */
    public static void writeOutputFile(List<String> lines,String directory,String nameOutputFile) throws IOException {
        // NB : The try-with-resources statement ensures that each resource is closed at the end of the statement.
        try(FileWriter writer = new FileWriter( directory + nameOutputFile)){
            for(String line: lines) {
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
