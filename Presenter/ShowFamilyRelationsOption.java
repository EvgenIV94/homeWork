package HomeWork.FamilyTree.Presenter;

public class ShowFamilyRelationsOption implements MenuOption {
    @Override
    public void execute(FamilyTreePresenter presenter) {
        presenter.showFamilyRelations();
    }

    @Override
    public String getDescription() {
        return "Показать родственные связи";
    }
}
