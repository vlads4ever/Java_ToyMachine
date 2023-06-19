package view.commands;

import view.View;

public class FillMachine implements Command {
    private View view;

    public FillMachine(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Наполнить машину";
    }

    @Override
    public void execute() {
        this.view.fillMachine();
    }
}
