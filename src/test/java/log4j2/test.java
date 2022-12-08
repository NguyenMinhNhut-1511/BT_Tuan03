package log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class test {
    static Logger log = LogManager.getLogger(test.class.getName());

    public static void main(String[] args) {
        log.info("info log");
        log.error("error log");
    }
}
