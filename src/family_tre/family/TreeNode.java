package family_tre.family;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();

    LocalDate getBirthday();
    List<T> getParents();
    List<T> getChild();
    T getSpuose();
    void setSpuose(T human);
}
