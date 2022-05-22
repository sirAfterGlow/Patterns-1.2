import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance = null;

    private StringBuilder stringBuilder;
    private SimpleDateFormat simpleDateFormat;
    private int count;

    private Logger() {
        stringBuilder = new StringBuilder();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        count = 1;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeLog(String text) {
        Date dateNow = new Date();
        stringBuilder.append(count + " [" + simpleDateFormat.format(dateNow) + "] " + text + "\n");
        count++;
    }

    public String getCurrentLog() {
        return stringBuilder.toString();
    }
}
