package com.monitor;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.monitor.xml.XMLPullParserHandler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class GlossarFragment extends Fragment {

    List<String> glossar = new ArrayList<String>();
    List<String> glossar_content = new ArrayList<String>();
    List<String> tags = new ArrayList<String>();
    DocumentView dc_glossar;

    String xml = "xml/glossar_strings.xml";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_glossar, container, false);
        setHasOptionsMenu(true);

        TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);
        t.setText("Glossar");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);

        // der Justified Text view wird erstellt
        dc_glossar = (DocumentView) v.findViewById(R.id.glossar_text);
        dc_glossar.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);


        Spinner intSpinner = (Spinner) v.findViewById(R.id.glossar_spinner);

        //Todo: Muss nochmal erweitert werden z.B. Golfplatz fehlt...dieser wurde aber scon angelegt

        glossar = parseXML_array("title",xml);
        glossar_content = parseXML_array("content",xml);
        tags = parseTAG_array();

        // Create an ArrayAdapter using the string array and a default spinner
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1, glossar);
        intSpinner.setAdapter(adapter);
        intSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView x = (TextView) getActivity().findViewById(android.R.id.text1);
                x.setSingleLine(false);

                for (int i = 0; i<tags.size();i++){
                        if(adapter.getItemId(position)==i){
                            parseXml(tags.get(i));
                            System.out.println("position================================="+tags.get(i));
                        }
                    }
                }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return v;
    }

    public void parseXml(String title){

        XMLPullParserHandler parser = new XMLPullParserHandler();
        AssetManager manager = getActivity().getApplicationContext().getAssets();
        InputStream stream;

        try {
            stream = manager.open("xml/glossar_strings.xml");
            Document doc = parser.getDocument(stream);
            NodeList nodeList = doc.getElementsByTagName(title);
            String ue;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);

                ue = parser.getValue(e, "content");
                dc_glossar.setText(ue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList parseXML_array(String name, String xml_file){
        AssetManager manager = getActivity().getApplicationContext().getAssets();
        InputStream stream;

        ArrayList<String> glossar_elements = new ArrayList<String>();

        try {

            stream = manager.open(xml_file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(name);

            for (int i = 0; i < nList.getLength(); i++) {

                // Get element
                Element element = (Element)nList.item(i);
                glossar_elements.add(element.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return glossar_elements;
    }

    private ArrayList parseTAG_array(){
        AssetManager manager = getActivity().getApplicationContext().getAssets();
        InputStream stream;

        ArrayList<String> glossar_tags = new ArrayList<String>();

        try {

            stream = manager.open("xml/glossar_strings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);

            doc.getDocumentElement().normalize();

            Element docEl = doc.getDocumentElement();
            Node childNode = docEl.getFirstChild();
            while( childNode.getNextSibling()!=null ){
                childNode = childNode.getNextSibling();
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    glossar_tags.add(childElement.getNodeName());
                }
            }

            } catch (Exception e) {
            e.printStackTrace();
        }
        return glossar_tags;
    }


}
