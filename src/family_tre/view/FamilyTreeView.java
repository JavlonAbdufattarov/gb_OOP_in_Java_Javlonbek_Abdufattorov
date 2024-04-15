package family_tre.view;

import java.util.List;
import family_tre.presenter.*;
import family_tre.Model.human.Human;
public interface FamilyTreeView {
    void displayFamilyMembers(List<Human> members);
    void displayError(String message);
    void setPresenter(FamilyTreePresenter presenter);

}
