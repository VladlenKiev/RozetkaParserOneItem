package ua.kiev.fin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 06.06.2017.
 */
public class Parser {

    public Map Connect(String strRequest){
        Document doc = null;
        try {
            doc = Jsoup.connect(strRequest).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements rozetkaHeadlines = doc.select("meta");

        return parsingPage(rozetkaHeadlines);
    }

    private static Map parsingPage(Elements rozetkaHeadlines){
        Map map = new HashMap();

        for (Element element: rozetkaHeadlines){
            if(element.toString().contains("reviewCount"))
                map.put("reviewCount", parsingValue(element));

            if(element.toString().contains("bestRating"))
                map.put("ratingValue",parsingValue(element));

            if(element.toString().contains("price")&&!element.toString().contains("priceCurrency"))
                map.put("price",parsingValue(element));

        }
        return map;
    }

    private static Integer parsingValue(Element element){
        String strElement = element.toString();
        String strRes = strElement.substring(strElement.indexOf("content")+9,strElement.length()-4);
        return Integer.valueOf(strRes);
    }
}
