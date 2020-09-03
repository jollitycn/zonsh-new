package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/7 11:31
 */
public class Loggable {
    public Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
}
