package org.sax.service;

import org.sax.handler.MyHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by durban126 on 16/10/7.
 */
public class SAXService {

    public static List<HashMap<String, String>> readXML(InputStream inputStream, String nodeName){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler(nodeName);
            parser.parse(inputStream, handler);
            inputStream.close();
            return handler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
