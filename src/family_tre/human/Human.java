package family_tre.human;

import family_tre.family.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human  implements Serializable,TreeNode<Human> {
       private long id;
       private Human spuose;
       private String name;
       private  LocalDate birthday;
       private LocalDate deathDate;
       private Gender gender;
       private  List<Human> child;
       private Human father;
       private Human mother;
       public Human(LocalDate birthday,Gender gender){
        this.birthday = birthday;
        this.gender = gender;
        this.child = new ArrayList<>();
           }

        public Human(String name,Gender gender, LocalDate birthday,LocalDate deathDate,Human father,Human mother){
        id=-1;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.deathDate  = deathDate;
        this.father = father;
        this.mother = mother;
        child = new ArrayList<>();
       }
        public Human(String name,Gender gender, LocalDate birthday){
        this(name,gender,birthday,null,null,null);
        }
        public Human(String name,Gender gender, LocalDate birthday,Human father,Human mother){
        this(name,gender,birthday,null,father,mother);
        }
        public String getName() {
            return name;
        }

        public Human getSpuose() {
        return spuose;
        }

         public void setSpuose(Human spuose) {
        this.spuose = spuose;
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

         public long getId() {
        return id;
         }
         public Human getMother() {
            return mother;
        }
         public List<Human> getChild() {
            return child;
        }

         public void setId(long id) {
        this.id = id;
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
        public boolean addChild(Human children) {
           if (!child.contains(children)){
               child.add(children);
               return true;
           }
           return false;
        }
        public boolean addParent(Human parent){
           if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
           }
           else{
               setMother(parent);
           }
           return true;
       }
       public List<Human> getParents(){
           List<Human> list = new ArrayList<>();
           if(father != null){
               list.add(father);
           }
           if(mother != null){
               list.add(mother);
           }
           return list;
       }
       public int age(){
           if (deathDate == null){
               return getPeriod(birthday,LocalDate.now());
           }
           else{
               return getPeriod(birthday,deathDate);
           }
       }
       public int getPeriod(LocalDate birthday , LocalDate deathDate){
           Period diff = Period.between(birthday,deathDate);
           return diff.getYears();
       }
       @Override
        public String toString(){
           return getInfo();
       }

       public String getInfo(){
           StringBuilder sb = new StringBuilder();
           sb.append("id = ");
           sb.append(id);
           sb.append("name = ");
           sb.append(name);
           sb.append("gender = ");
           sb.append(getGender());
           sb.append("age = ");
           sb.append(age());
           sb.append(getSuposeInfo());
           sb.append(" ");
           sb.append(getChildrenInfo());
           sb.append("  ");
           sb.append(getFatherInfo());
           return    sb.toString();
       }
       public String getSuposeInfo(){
           String res="Cупруг(а) = ";
           if (spuose == null){
               res += "no";
           }
           else {
               res += spuose.name;
           }
           return res;
       }
    public String getMotherInfo(){
        String res="мать = ";
        if (mother == null){
            res += "no";
        }
        else {
            res += mother.name;
        }
        return res;
    }
    public String getFatherInfo(){
        String res="отец = ";
        if (father == null){
            res += "no";
        }
        else {
            res += father.name;
        }
        return res;
    }
    public String getChildrenInfo(){
           StringBuilder sb = new StringBuilder();
           if (!child.isEmpty()){
               sb.append(child.get(0).getName());
               for (int i = 1; i<child.size();i++){

                   sb.append(child.get(i).getName());
                   sb.append(";");
               }
           }
           else {
               sb.append("no child");
           }
           return sb.toString();
    }

    public boolean equals(Object obj){
    if(this==obj){
        return true;
    }
    if(!(obj instanceof Human)){
        return false;
    }
       Human human = (Human) obj;
     return human.getId()==getId();
       }

}
