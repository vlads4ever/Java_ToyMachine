import model.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}