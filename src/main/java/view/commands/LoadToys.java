package view.commands;

import view.View;

public class LoadToys implements Command {
    private View view;

    public LoadToys(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Наполнить автомат из файла";
    }

    @Override
    public void execute() {
        this.view.loadToys();
    }
}
