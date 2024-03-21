package family_tre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
   private final LocalDate birthday;
   private final Gender gender;
   private final List<Human> child;
   private Human father;
   private Human mother;
   public Human(LocalDate birthday,Gender gender){
    this.birthday = birthday;
    this.gender = gender;
    this.child = new ArrayList<>();
       }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
       return birthday;
    }
       public List<Human> getChildren() {
       return child;
    }
       public Human getFather() {
        return father;
    }

       public Human getMother() {
        return mother;
    }
    public List<Human> getChild() {
        return child;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Gender getGender() {
        return gender;
    }
    public void addChild(Human child) {
        this.child.add(child);
        if (this.gender == Gender.Male) {
            child.setFather(this);
        } else {
            child.setMother(this);
        }
    }

}
