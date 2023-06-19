package model;

import model.saving.Saving;
import model.toymachine.ToyMachine;

public class Service {
    private ToyMachine toyMachine;
    private Saving saving;

    public Service() {
        this.toyMachine = new ToyMachine();
        this.saving = new Saving();
    }

    public void setIds(int[] ids) {
        toyMachine.setIds(ids);
    }

    public void setNames(String[] names) {
        toyMachine.setNames(names);
    }

    public void setFrequencies(double[] frequencies) {
        toyMachine.setFrequencies(frequencies);
    }

    public String fillToyList(int[] ids, String[] names, double[] frequencies) {
        setIds(ids);
        setNames(names);
        setFrequencies(frequencies);
        return toyMachine.fillToyList();
    }

    public String lottery() {
        return toyMachine.lottery();
    }

    public String saveToysQueue(String path) {
        return saving.saveToFile(path, toyMachine.getWinsQueue());
    }
}
