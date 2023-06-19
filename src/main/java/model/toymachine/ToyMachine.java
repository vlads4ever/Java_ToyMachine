package model.toymachine;

import model.toy.Toy;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyMachine {
    private int[] ids;
    private String[] names;
    private double[] frequencies;
    private PriorityQueue<Toy> winsQueue;
    private PriorityQueue<Toy> toysQueue;

    public ToyMachine() {
        this.winsQueue = new PriorityQueue<>();
        this.toysQueue = new PriorityQueue<>();
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

    public String fillToyList() {
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }
        return "Список игрушек сформирован.";
    }

    public String lottery() {
        String result = "";
        if (toysQueue.size() == 0) {
            result = "Автомат пуст.";
        } else {
            Random random = new Random();
            double sumOfFrequencies = 0.0;
            for (Toy toy: toysQueue)
                sumOfFrequencies += toy.getFrequency();
            double winRnd = random.nextDouble(0.01, sumOfFrequencies);
            double countFrequencies = 0.0;
            for (Toy toy: toysQueue) {
                countFrequencies += toy.getFrequency();
                if (countFrequencies >= winRnd) {
                    winsQueue.add(toy);
                    result = toy.toString();
                    break;
                }
            }
        }
        return result;
    }

    public PriorityQueue<Toy> getWinsQueue() {
        return winsQueue;
    }
}
