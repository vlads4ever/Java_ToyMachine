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

    public void fillQueue(int[] ids, String[] names, double[] frequencies) {
        service.setIds(ids);
        service.setNames(names);
        service.setFrequencies(frequencies);
        view.print("Массивы заполнены.");
    }

    public void getToy() {
        view.print(service.getToyFromQueue());
    }

    public void saveToysList(String path) {
        view.print(service.saveToysList(path));
    }
}
