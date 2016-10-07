package org.sax.test;

import org.sax.http.HttpUtils;
import org.sax.service.SAXService;

import java.io.InputStream;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;

/**
 * Created by durban126 on 16/10/7.
 */
public class Test {

    public static void main(String[] args){
        String path = "http://192.168.31.220:8080/ProductManagement/persons.xml";
        InputStream inputStream = HttpUtils.getXML(path);
        List<HashMap<String, String>> list = SAXService.readXML(inputStream, "person");
        for(HashMap<String, String> map:list){
            System.out.println(map.toString());
        }
    }
}
