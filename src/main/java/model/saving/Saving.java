package model.saving;

import model.toy.Toy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

public class Saving {
    public String saveToFile (String path, PriorityQueue<Toy> toysQueue) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Toy toy;
            while ((toy = toysQueue.poll()) != null) {
                writer.write(String.format("Id: %d, Название: %s, Вероятность выпадения: %.2f\n",
                        toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return "Список сохранен в файл.";
    }
}

