import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void printConsoleAndWriteLog(String text) {
        System.out.println(text);
        Logger.getInstance().writeLog(text);
    }

    public static void main(String[] args) {

        Logger.getInstance();
        int size;
        int maxValueBound;
        int filterValue;
        Random random = new Random();

        try (Scanner scanner = new Scanner(System.in)){
            printConsoleAndWriteLog("Hello!");
            printConsoleAndWriteLog("Print list size");
            size = scanner.nextInt();
            Logger.getInstance().writeLog("The number " + size + " is entered");

            printConsoleAndWriteLog("Print value bound");
            maxValueBound = scanner.nextInt();
            Logger.getInstance().writeLog("The number " + maxValueBound + " is entered");

            printConsoleAndWriteLog("Print filter value");
            filterValue = scanner.nextInt();
            Logger.getInstance().writeLog("The number " + filterValue + " is entered");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(maxValueBound));
        }

        printConsoleAndWriteLog("Start list:");
        printConsoleAndWriteLog(numbers.toString());


        Filter filter = new Filter(filterValue);
        numbers = filter.filterOut(numbers);


        printConsoleAndWriteLog("Result list:");
        printConsoleAndWriteLog(numbers.toString());

        System.out.println("----------------------------------------");
        System.out.println("Final log");
        System.out.println(Logger.getInstance().getCurrentLog());

    }
}
