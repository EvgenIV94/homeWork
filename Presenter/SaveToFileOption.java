package HomeWork.FamilyTree.Presenter;

public class SaveToFileOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.saveToFile(presenter.getView().getInput("Введите имя файла: "));
    }

    @Override
    public String getDescription() {
        return "Сохранить в файл";
    }
}