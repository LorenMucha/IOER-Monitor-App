package com.landusemonitor.xml;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FileChecker {

    private Context mcontext;
    private AssetManager manager;

    public FileChecker(Context context) {
        mcontext = context;
    }

    private String xml_siedlung = "xml/siedlung.xml";
    private String xml_verkehr = "xml/verkehr.xml";
    private String xml_freiraum = "xml/freiraum.xml";
    private String xml_bevoelkerung = "xml/bevoelkerung.xml";
    private String xml_ln = "xml/ln.xml";
    private String xml_lq = "xml/lq.xml";
    private String xml_risiko = "xml/risiko.xml";
    private String xml_relief = "xml/relief.xml";

    // The xml containing Arrays
    private List<String> siedlung_titles = new ArrayList<String>();
    private List<String> siedlung_tags = new ArrayList<String>();

    private List<String> verkehr_titles = new ArrayList<String>();
    private List<String> verkehr_tags = new ArrayList<String>();

    private List<String> freiraum_titles = new ArrayList<String>();
    private List<String> freiraum_tags = new ArrayList<String>();

    private List<String> bev_titles = new ArrayList<String>();
    private List<String> bev_tags = new ArrayList<String>();

    private List<String> ln_titles = new ArrayList<String>();
    private List<String> ln_tags = new ArrayList<String>();

    private List<String> lq_titles = new ArrayList<String>();
    private List<String> lq_tags = new ArrayList<String>();

    private List<String> risiko_titles = new ArrayList<String>();
    private List<String> risiko_tags = new ArrayList<String>();

    private List<String> relief_titles = new ArrayList<String>();
    private List<String> relief_tags = new ArrayList<String>();

    public void checkFiles(String folder, String xml_file) {

        ArrayList<String> files = new ArrayList<String>();
        ArrayList<String> tags = new ArrayList<String>();

        try {

            InputStream stream;

            AssetManager assetManager = mcontext.getApplicationContext().getAssets();

            for (String file : assetManager.list(folder)) {
                if (file.endsWith(".html"))
                    files.add(file);
            }

            //the tags to compare
            stream = mcontext.getApplicationContext().getAssets().open(xml_file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);

            doc.getDocumentElement().normalize();

            Element docEl = doc.getDocumentElement();
            Node childNode = docEl.getFirstChild();
            while (childNode.getNextSibling() != null) {
                childNode = childNode.getNextSibling();
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    tags.add(childElement.getNodeName()+ ".html");
                }
            }

            // Check for dublicates and remove then to find the xml tags
            tags.removeAll(files);

            //create the missing html files

            craeteMissingFiles(tags);

        }catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void craeteMissingFiles (ArrayList<String> tags_check) throws Exception{

        //Noch keine Idee, wie das erstellen von .html Dateien möglich werden soll :-( :-(

        for(String v: tags_check){

        }


    }

}
