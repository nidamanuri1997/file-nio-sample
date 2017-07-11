import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Created by rhaveson on 7/11/2017.
 */
public class FileIOTest
{
    final String fileName = "simpleClass.ser";
    final int testInt = 555;
    final String testString = "Ryan Haveson";
    final SimpleClass testSimpleClass = new SimpleClass(testInt, testString);

    @Test
    public void createsFileIfNoneExists() {

        deleteTestFileIfExists();

        SimpleClass simpleClass = new SimpleClass(testInt, testString);

        Path testFilePath = Paths.get(fileName);
        FileIOSample.saveClass(testFilePath, simpleClass);

        assertTrue(Files.exists(testFilePath));
    }

    @Test
    public void loadsObjectData() {

        deleteTestFileIfExists();

        Path testFilePath = Paths.get(fileName);
        FileIOSample.saveClass(testFilePath, testSimpleClass);

        SimpleClass loadedSimpleClass = FileIOSample.loadClass(testFilePath);

            // Make sure the string value and the int value are the same
        assertTrue(loadedSimpleClass.getMyString().equals(testSimpleClass.getMyString()));
        assertTrue(loadedSimpleClass.getMyInt() == testSimpleClass.getMyInt());

    }

    public void deleteTestFileIfExists() {

        // If the file exists, delete it
        Path path = Paths.get(fileName);

        // Delete the file if it exists
        if(Files.exists(path)) {
            try {
                Files.delete(path);

            } catch (IOException e) {

                // This is unexpected..
                e.printStackTrace();
            }
        }
    }

}
