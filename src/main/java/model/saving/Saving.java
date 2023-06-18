package model.saving;

import model.toy.Toy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Saving {
    public String saveToFile (String path, List<Toy> toysList) {
        String fileName = "result.txt";
        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(path))) {
            for (Toy toy : toysList) {
                writer.write(String.format("Id: %d, Название: %s, Частота выпадения: %.2fn",
                        toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return "Список сохранен в файл.";
    }
}
