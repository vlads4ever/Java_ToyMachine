package view.commands;

import view.View;

public class SaveToysQueue implements Command {
    private View view;

    public SaveToysQueue(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить выигрыш в файл";
    }

    @Override
    public void execute() {
        this.view.saveToysQueue();
    }
}
