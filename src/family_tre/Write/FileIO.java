package family_tre.Write;
import java.io.IOException;
public interface FileIO<T> {

    void writeToFile(T object, String filename) throws IOException;
    T readFromFile(String filename) throws IOException, ClassNotFoundException;
}
