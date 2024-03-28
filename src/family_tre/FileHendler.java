package family_tre;
import java.io.*;
public class FileHendler implements FileIO<FamilyTree>{
    @Override
    public void writeToFile(FamilyTree object, String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(object);
        }
    }

    @Override
    public FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) inputStream.readObject();
        }
    }
}
