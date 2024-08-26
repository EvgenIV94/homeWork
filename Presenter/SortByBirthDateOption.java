package HomeWork.FamilyTree.Presenter;

public class SortByBirthDateOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.sortByBirthDate();
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }
}
