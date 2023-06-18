package model;

import model.saving.Saving;
import model.toy.Toy;
import model.toymachine.ToyMachine;

import java.util.List;

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

    public String fillQueue() {
        return toyMachine.fillQueue();
    }

    public String getToyFromQueue() {
            return toyMachine.getToyFromQueue();
    }

    public String saveToysList(String path) {
        return saving.saveToFile(path, toyMachine.getToysList());
    }
}
