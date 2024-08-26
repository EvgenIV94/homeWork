package HomeWork.FamilyTree.Presenter;

public class AddChildOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.addChild();
    }

    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }
}
