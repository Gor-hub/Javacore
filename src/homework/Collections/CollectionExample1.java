package homework.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CollectionExample1 implements Commands {
    static Scanner scanner = new Scanner(System.in);
    static List<String> array = new ArrayList<>();

    public static void main(String[] args) {
        array.add("Poxos");
        array.add("Petros");
        array.add("Martiros");
        array.add("Valod");
        array.add("Artur");
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case CHECK_NAME:
                    checkName();
                    break;
                case REMOVE_NAME:
                    removeName();
                    break;
                case ADD_NAME_BY_INDEX:
                    addNameByIndex();
                    break;
                default:
                    System.out.println("WRONG COMMAND!");
            }
        }
    }

    static void checkName() {
        System.out.println("Please input name");
        String name = scanner.nextLine();
        boolean bul = check(name);
        if (bul) {
            System.out.println("The name \"" + name + "\" is exists!");
        } else {
            System.out.println("The name \"" + name + "\" is not exists!");
        }
    }

    static boolean check(String name) {
        for (String s : array) {
            if (name.contains(s)) {
                return true;
            }
        }
        return false;
    }

    static void removeName() {
        System.out.println("Please input name");
        String name = scanner.nextLine();
        boolean bul = check(name);
        if (bul) {
            array.remove(name);
            System.out.println("The name \"" + name + "\" was successfully removed");
            print();
        } else {
            System.out.println("The name \"" + name + "\" is not exists!");
            print();
        }
        System.out.println();
    }

    private static void addNameByIndex() {
        System.out.println("Please input index,name");
        String[] data = scanner.nextLine().split(",");
        String num = data[0];
        try {
            int index = Integer.parseInt(num);
            String name = data[1];
            boolean bul = check(name);
            if (!bul) {
                array.add(index, name);
                System.out.println("The name \"" + name + "\" is successfully added at index " + index);
                print();
            } else {
                System.out.println("The name \"" + name + "\" is already exists!");
                print();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect format of input!");
        } catch (NumberFormatException e) {
            System.out.println("Format of index is incorrect!");
        }
    }

    static void print() {
        int index = 0;
        for (String s : array) {
            System.out.print((index++) + ":[" + s + "] ");
        }
        System.out.println();
    }
}
