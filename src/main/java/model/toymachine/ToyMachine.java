package model.toymachine;

import model.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ToyMachine {
    private int[] ids;
    private String[] names;
    private double[] frequencies;
    private PriorityQueue<Toy> toysQueue;
    private List<Toy> toysList;

    public ToyMachine() {
        this.ids = new int[10];
        this.names = new String[10];
        this.frequencies = new double[10];
        this.toysQueue = new PriorityQueue<>();
        this.toysList = new ArrayList<>();
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setFrequencies(double[] frequencies) {
        this.frequencies = frequencies;
    }

    public String fillQueue() {
        for (int i = 0; i < 10; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }
        return "Очередь заполнена.";
    }

    public String getToyFromQueue() {
        Toy toy = toysQueue.poll();
        if (toy != null) {
            toysList.add(toy);
            return toy.toString();
        } else {
            return "Очередь пуста.";
        }
    }

    public List<Toy> getToysList() {
        return toysList;
    }
}
