package family_tre.presenter;

import family_tre.Model.FamilyTree;
import family_tre.Model.human.Human;
import family_tre.view.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree model;

    public FamilyTreePresenter(FamilyTreeView view, FamilyTree model) {
        this.view = view;
        this.model = model;
        this.view.setPresenter(this);
    }

    public void loadFamilyMembers() {
        try {
            view.displayFamilyMembers(model.getMembers());
        } catch (Exception e) {
            view.displayError("Failed to load family members.");
        }
    }

    public void addFamilyMember(Human human) {
        model.addt(human);
        loadFamilyMembers();  // Обновить представление после добавления
    }
}
