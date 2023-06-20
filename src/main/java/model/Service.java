package model;

import model.saving.Savable;
import model.saving.Saving;
import model.toymachine.ToyMachine;

public class Service {
    private ToyMachine toyMachine;
    private Savable saving;

    public Service(Savable saving) {
        this.toyMachine = new ToyMachine();
        this.saving = saving;
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
        String result = "Массивы успешно заполнены."  + "\n";
        result += toyMachine.fillToyList();
        return result;
    }

    public String lottery() {
        return toyMachine.lottery();
    }

    public String saveToysQueue(String path) {
        return saving.saveToFile(path, toyMachine.getWinsQueue());
    }

    public String loadToys(String path) {
        String result = saving.loadFromFile(path, toyMachine) + "\n";
        if (result.equals("Массивы успешно заполнены из файла " + path + "\n")) {
            result += toyMachine.fillToyList();
        }
        return result;
    }
}
