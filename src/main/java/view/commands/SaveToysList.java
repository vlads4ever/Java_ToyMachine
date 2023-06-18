package view.commands;

import view.View;

public class SaveToysList implements Command {
    private View view;

    public SaveToysList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить игрушки в файл.";
    }

    @Override
    public void execute() {
        this.view.saveToyList();
    }
}
