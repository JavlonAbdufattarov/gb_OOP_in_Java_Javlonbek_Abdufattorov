package family_tre;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        Human grandfather = new Human(LocalDate.of(1960, 5, 15), Gender.Male);
        Human father = new Human(LocalDate.of(1976, 5, 6), Gender.Male);
        Human mother = new Human(LocalDate.of(1981, 2, 27), Gender.Female);
        Human javlon = new Human(LocalDate.of(2005, 8, 9), Gender.Male);
        Human daughter = new Human(LocalDate.of(2002, 8, 3), Gender.Female);
        grandfather.addChild(father);
        father.setName("father");
        father.addChild(javlon);
        father.addChild(daughter);
        mother.addChild(javlon);
        mother.addChild(daughter);
        FamilyTree familyTree = new FamilyTree(grandfather);

        System.out.println("Дети родоначальника:");
        for (Human child : familyTree.getAllChildren(grandfather)) {
            System.out.println(child.getName()+" - "+child.getBirthday() + " - " + child.getGender());
        }
    }

}
