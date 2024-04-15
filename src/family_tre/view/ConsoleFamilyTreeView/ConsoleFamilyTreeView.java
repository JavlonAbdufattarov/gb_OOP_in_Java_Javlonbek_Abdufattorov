package family_tre.view.ConsoleFamilyTreeView;
import family_tre.view.FamilyTreeView;
import family_tre.Model.human.*;
import family_tre.Model.human.Human;
import family_tre.presenter.FamilyTreePresenter;
import java.time.DateTimeException;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayFamilyMembers(List<Human> members) {
        for (Human human : members) {
            System.out.println(human);
        }
    }

    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, load, exit):");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            else if (command.equals("add")) {
                scanner = new Scanner(System.in);
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter gender (Male/Female):");
                String genderInput = scanner.nextLine();
                Gender gender = Gender.valueOf(genderInput.toUpperCase());

                System.out.println("Enter birth year:");
                int year = scanner.nextInt();

                System.out.println("Enter birth month:");
                int month = scanner.nextInt();

                System.out.println("Enter birth day:");
                int day = scanner.nextInt();

                LocalDate birthday = LocalDate.of(year, month, day);

                // Optional: Handling the case where the date might be invalid.
                if (!isValidDate(year, month, day)) {
                    System.out.println("Invalid date, please try again.");
                    continue;
                }

                Human newMember = new Human(name, gender, birthday);
                presenter.addFamilyMember(newMember);
            }
            else if (command.equals("load")) {
                presenter.loadFamilyMembers();
            }
        }
        scanner.close();
    }
}
