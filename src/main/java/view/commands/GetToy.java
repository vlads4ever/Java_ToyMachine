package view.commands;

import view.View;

public class GetToy implements  Command{
    private View view;

    public GetToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Розыгрыш игрушки";
    }

    @Override
    public void execute() {
        this.view.getToy();
    }
}
