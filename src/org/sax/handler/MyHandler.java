package org.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by durban126 on 16/10/7.
 */
public class MyHandler extends DefaultHandler {

    private HashMap<String, String> map = null;
    private List<HashMap<String, String>> list = null;
    private String currentTag = null;
    private String currentValue = null;
    private String nodeName = null;

    public List<HashMap<String, String>> getList() {
        return list;
    }

    public MyHandler(String nodeName){
        this.nodeName = nodeName;
    }

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<HashMap<String, String>>();
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {

        if(s2.equals(nodeName)){
            map = new HashMap<String, String>();
        }

        if(attributes != null && map != null){
            for(int i=0;i<attributes.getLength();i++){
                map.put(attributes.getQName(i),attributes.getValue(i));
            }
        }

        currentTag = s2;
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if(currentTag != null && map!=null){
            currentValue = new String(chars, i, i1);
            if (currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")) {
                map.put(currentTag, currentValue);
            }
        }

        currentTag = null;
        currentValue = null;
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        if(s2.equals(nodeName)){
            list.add(map);
            map = null;
        }

        super.endElement(s, s1, s2);

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
