package family_tre.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;
import java.util.stream.Collectors;
public class FamilyTree<E extends TreeNode<E>> implements Serializable,Iterable<E> {
    long count;
    private List<E> humanList;
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }
    public boolean addt(E human){
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
    private void addToParents(E human){
        for(E parent:human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChild(E human){
        for(E child:human.getChild()){
            child.addParent(human);
        }
    }
    public List<E> getSibling(int id){
        E human = getById(id);
        if(human == null){
            return null;
        }
        List<E> ListS = new ArrayList<>();
        for(E parent:human.getParents()){
            for(E child: parent.getChild()){
                if(!child.equals(human)){
                    ListS.add(child);
                }
            }
        }
    return ListS;
    }
    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human : humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
    return res;
    }
    public boolean setWidding(long id1,long id2){
        if(checkId(id1)&&checkId(id2)){
            E human1 = getById(id1);
            E human2 = getById(id2);
            return setWidding(human1,human2);
        }
        return false;
    }
    public boolean setWidding(E human1,E human2){
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
    public E getById(long id){
        for(E human: humanList){
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
            for (E human: humanList){
                sb.append(human);
                sb.append("\n");
            }
            return sb.toString();
        }
    @Override
    public Iterator<E> iterator() {
        return humanList.iterator();
    }
    public List<E> sortByName() {
        return humanList.stream()
                .sorted(Comparator.comparing(E::getName))
                .collect(Collectors.toList());
    }

    public List<E> getMembers() {
        return new ArrayList<>(humanList);
    }

    public List<E> sortByBirthday() {
        return humanList.stream()
                .sorted(Comparator.comparing(E::getBirthday))
                .collect(Collectors.toList());
    }
}
