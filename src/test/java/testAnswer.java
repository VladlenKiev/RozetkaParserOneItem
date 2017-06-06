import org.junit.Test;
import ua.kiev.fin.Parser;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by admin on 06.06.2017.
 */

public class testAnswer {
    @Test
    public void testMultiply() {
        Parser parser = new Parser();
        String strRequest = "http://rozetka.com.ua/captain_morgan_5000299223017/p4968858/";
        Map testResultMap = parser.Connect(strRequest);

        assertEquals("reviewCount must be equals 49", 50, testResultMap.get("reviewCount"));
        assertEquals("ratingValue must be equals 49", 5, testResultMap.get("ratingValue"));
        assertEquals("price must be equals 219", 219, testResultMap.get("price"));
    }
}
