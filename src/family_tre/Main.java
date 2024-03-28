package family_tre;
import java.io.*;
import java.time.LocalDate;

public class Main {

    
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human Gayrat = new Human("Gayrat",Gender.Male,LocalDate.of(1976,5,6)    );
        Human Gavhar = new Human("Gavhar",Gender.Female,LocalDate.of(1981,2,27));
        tree.addt(Gayrat);
        tree.addt(Gavhar);
        tree.setWidding(Gayrat,Gavhar);
        Human Javlon = new Human("Javlon",Gender.Male,LocalDate.of(2005,8,9),Gayrat,Gavhar);
        Human Lobar  = new Human("Lobar",Gender.Female,LocalDate.of(2002,8,3),Gayrat,Gavhar);
        tree.addt(Javlon);
        tree.addt(Lobar);
        Human grandMother = new Human ("grandMather",Gender.Female,LocalDate.of(1960,1,1));
        grandMother.addChild(Gayrat);
        tree.addt(grandMother);
        System.out.println(tree.toString());
        FileHendler fileHandler = new FileHendler();

        try {
            // Запись объекта FamilyTree в файл
            fileHandler.writeToFile(tree, "family_tree.ser");
            // Чтение объекта FamilyTree из файла
            FamilyTree loadedTree = fileHandler.readFromFile("family_tree.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
