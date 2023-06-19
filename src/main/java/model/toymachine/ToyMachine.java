package model.toymachine;

import model.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyMachine {
    private int[] ids;
    private String[] names;
    private double[] frequencies;
    private PriorityQueue<Toy> toysQueue;
    private List<Toy> toysList;

    public ToyMachine() {
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

    public String fillToyList() {
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysList.add(toy);
        }
        return "Список игрушек сформирован.";
    }

    private boolean win(double frequency) {
        Random random = new Random();
        double winRnd = random.nextDouble();
        return frequency > winRnd;
    }

    public String lottery() {
        if (toysList.size() == 0) {
            return "Автомат пуст.";
        } else {
            while (true) {
                for (Toy toy: toysList) {
                    if (win(toy.getFrequency())) {
                        toysQueue.add(toy);
                        return "Выиграна игрушка: " + toy.toString();
                    }
                }
            }
        }
    }

    public PriorityQueue<Toy> getToysQueue() {
        return toysQueue;
    }
}
