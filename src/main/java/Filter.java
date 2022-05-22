import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    private int minValueBound;

    public Filter (int minValueBound) {
        this.minValueBound = minValueBound;
    }

    public List<Integer> filterOut(List<Integer> list) {
        int deletedElementsCount = (int) list.stream()
                .filter(value -> value < minValueBound)
                .peek(value -> Logger.getInstance().writeLog("Value " + value + " is delete"))
                .count();

        Logger.getInstance().writeLog(deletedElementsCount + " elements was delete");


        List<Integer> result =list.stream()
                .filter(value -> value >= minValueBound)
                .collect(Collectors.toList());

        Logger.getInstance().writeLog("Filtering was complete");
        return result;
    }
}
