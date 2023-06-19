package model.toy;

public class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private  double frequency;

    public Toy(int id, String name, double frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Toy toy) {
        int firstCompare = Double.compare(this.frequency, toy.getFrequency());
        if (firstCompare == 0) {
            int secondCompare = this.name.compareTo(toy.getName());
            if (secondCompare == 0) {
                return Integer.compare(this.getId(), toy.getId());
            }
            return secondCompare;
        }
        return firstCompare;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Название: %s, Вероятность выпадения: %.2f\n",
                id, name, frequency);
    }
}
