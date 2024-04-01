package family_tre.family;
import family_tre.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;
import java.util.stream.Collectors;
public class FamilyTree implements Serializable,Iterable<Human> {
    long count;
    private List<Human> humanList;
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public boolean addt(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
        humanList.add(human);
        human.setId(count++);
        addToChild(human);
        addToParents(human);
        return true;
        }
        return false;
    }
    private void addToParents(Human human){
        for(Human parent:human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChild(Human human){
        for(Human child:human.getChild()){
            child.addParent(human);
        }
    }
    public List<Human> getSibling(int id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> ListS = new ArrayList<>();
        for(Human parent:human.getParents()){
            for(Human child: parent.getChild()){
                if(!child.equals(human)){
                    ListS.add(child);
                }
            }
        }
    return ListS;
    }
    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
    return res;
    }
    public boolean setWidding(long id1,long id2){
        if(checkId(id1)&&checkId(id2)){
            Human human1 = getById(id1);
            Human human2 = getById(id2);
            return setWidding(human1,human2);
        }
        return false;
    }
    public boolean setWidding(Human human1,Human human2){
        if(human1.getSpuose()==null && human2.getSpuose()==null ){
            human1.setSpuose(human2);
            human2.setSpuose(human1);
            return true;
        }
        return false;
    }
    private boolean checkId(long Id){
        return Id <count&& Id>=0;
    }
    public Human getById(long id){
        for(Human human: humanList){
            if(human.getId()==id){
                return human;
            }
        }
    return null;
    }
        @Override
        public String toString(){
            return getInfo();
        }
        public String getInfo(){
            StringBuilder sb = new StringBuilder();
            sb.append("in tree ");
            sb.append(humanList.size());
            sb.append(" object: \n");
            for (Human human: humanList){
                sb.append(human);
                sb.append("\n");
            }
            return sb.toString();
        }
    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
    public List<Human> sortByName() {
        return humanList.stream()
                .sorted(Comparator.comparing(Human::getName))
                .collect(Collectors.toList());
    }


    public List<Human> sortByBirthday() {
        return humanList.stream()
                .sorted(Comparator.comparing(Human::getBirthday))
                .collect(Collectors.toList());
    }
}
