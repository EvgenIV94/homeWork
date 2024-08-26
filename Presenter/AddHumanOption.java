package HomeWork.FamilyTree.Presenter;

public class AddHumanOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.addHuman();
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }
}
