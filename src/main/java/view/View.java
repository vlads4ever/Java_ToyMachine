package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);
    void print(String text);
    void printMenu();
    void exit();
    void fillMachine();
    void getToy();
    void saveToysQueue();
    void execute() throws IOException, ClassNotFoundException;
}
