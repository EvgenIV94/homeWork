package HomeWork.FamilyTree.Presenter;

public class ExitOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.exit();
    }

    @Override
    public String getDescription() {
        return "Выход";
    }
}
