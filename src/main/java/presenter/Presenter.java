package presenter;

import model.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void fillToyList(int[] ids, String[] names, double[] frequencies) {
        view.print(service.fillToyList(ids, names, frequencies) + "\n");
    }

    public void getToy() {
        view.print(service.lottery() + "\n");
    }

    public void saveToysQueue(String path) {
        view.print(service.saveToysQueue(path) + "\n");
    }

    public void loadToys(String path) {
        view.print(service.loadToys(path) + "\n");
    }
}
