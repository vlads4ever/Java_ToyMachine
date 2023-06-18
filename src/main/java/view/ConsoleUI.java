package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static String WRONG_VALUE = "Введено некорректное значение.";
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean run;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.run = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        print("Добро пожаловать в Автомат Игрушек!");
        print("************************************");
        print("");
        while (run) {
            this.printMenu();
            this.execute();
        }
    }

    @Override
    public void fillMachine() {
        int[] ids = new int[10];
        String[] names = new String[10];
        double[] frequencies = new double[10];
        print("Наполните автомат десятью игрушками..." + "\n");
        for (int i = 0; i < 10; i++) {
            print(String.format("Введите данные %d игрушки (id Название Вероятность появления (0,1 - 0,9)):", i + 1));
            boolean frun = true;
            while (frun) {
                try {
                    if (scanner != null) {
                        ids[i] = scanner.nextInt();
                        names[i] = scanner.next();
                        frequencies[i] = scanner.nextDouble();
                        frun = false;
                    }
                } catch (InputMismatchException | IllegalStateException | NullPointerException e) {
                    System.out.println(WRONG_VALUE);
                } finally {
//                    if (scanner != null) {
//                        scanner.close();
//                    }
                }
            }
        }
        presenter.fillQueue(ids, names, frequencies);
    }

    @Override
    public void getToy() {
        presenter.getToy();
    }

    @Override
    public void saveToyList() {
        print("Введите название файла (без расширения):");
        String path = scanner.nextLine() + ".txt";
        presenter.saveToysList(path);
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.print("Введите номер команды> ");
        String userInput = scanner.nextLine();
        if (checkTextForInt(userInput)){
            int numCommand = Integer.parseInt(userInput);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            this.print(WRONG_VALUE);
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            this.print(WRONG_VALUE);
            return false;
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printMenu() {
        this.print(mainMenu.print());
    }

    @Override
    public void exit() {
        run = false;
        print("Завершение работы.");
    }
}
