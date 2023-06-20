package model.saving;

import model.toy.Toy;
import model.toymachine.ToyMachine;

import java.io.*;
import java.util.*;

public class Saving implements Savable{
    private String WRONG_VALUE = "Некорректные входные значения.";

    @Override
    public String saveToFile(String path, PriorityQueue<Toy> toysQueue) {
        String result = "Список успешно сохранен в файл ";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Toy toy;
            while ((toy = toysQueue.poll()) != null) {
                writer.write(String.format("Id: %d, Название: %s, Вероятность выпадения: %.2f\n",
                        toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            result = WRONG_VALUE;
        }
        result += path;
        return result;
    }

    @Override
    public String loadFromFile(String path, ToyMachine toyMachine) {
        String result = "Массивы успешно заполнены из файла ";

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
            result = WRONG_VALUE;
        }

        int count = lines.size();
        int[] ids = new int[count];
        String[] names = new String[count];
        double[] frequencies = new double[count];
        for (int i = 0; i < count; i++) {
            try (Scanner toyScanner = new Scanner(lines.get(i))) {
                toyScanner.useDelimiter(";");
                ids[i] = toyScanner.nextInt();
                names[i] = toyScanner.next();
                frequencies[i] = toyScanner.nextDouble();
                if (frequencies[i] >= 0.99 && frequencies[i] <= 0.01) {
                    result = WRONG_VALUE + "\n";
                }
            } catch (InputMismatchException | IllegalStateException | NullPointerException e) {
                result = WRONG_VALUE + "\n";
            }
        }
        toyMachine.setIds(ids);
        toyMachine.setNames(names);
        toyMachine.setFrequencies(frequencies);
        result += path;
        return result;
    }
}

