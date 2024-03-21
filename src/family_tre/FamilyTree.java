package family_tre;

import java.util.List;

public class FamilyTree {
    private final Human root;
    public FamilyTree(Human root){
        this.root = root;
    }
    public Human getRoot() {
        return root;
    }
    public List<Human> getAllChildren(Human person) {
        return person.getChildren();
    }

}
