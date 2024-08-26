package HomeWork.FamilyTree.Presenter;

public class SortByNameOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.sortByName();
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }
}