package model.saving;

import model.toy.Toy;
import model.toymachine.ToyMachine;

import java.util.PriorityQueue;

public interface Savable {
    String saveToFile(String path, PriorityQueue<Toy> toysQueue);
    String loadFromFile(String path, ToyMachine toyMachine);
}
