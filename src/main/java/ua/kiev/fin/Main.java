package ua.kiev.fin;


import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String strRequest = "http://rozetka.com.ua/captain_morgan_5000299223017/p4968858/";

        Parser parser = new Parser();
        Map<String, Integer> mapRes = parser.Connect(strRequest);

        System.out.println(strRequest);
        for (Map.Entry<String, Integer> entry : mapRes.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
