package HomeWork.FamilyTree.Presenter;

public class ShowFamilyTreeOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.showFamilyTree();
    }

    @Override
    public String getDescription() {
        return "Показать всё семейное древо";
    }
}
