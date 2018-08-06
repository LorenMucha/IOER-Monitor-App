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

import com.monitor.rasterkarten.RasterkartenFragment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class RasterkarenChoiceFragment extends Fragment {

    //the xml files
    private String xml_siedlung ="xml/siedlung.xml";
    private String xml_verkehr ="xml/verkehr.xml";
    private String xml_freiraum ="xml/freiraum.xml";
    private String xml_bevoelkerung ="xml/bevoelkerung.xml";
    private String xml_ln ="xml/ln.xml";
    private String xml_lq ="xml/lq.xml";
    private String xml_risiko ="xml/risiko.xml";
    private String xml_relief ="xml/relief.xml";

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rasterkarten_choice, container, false);

        setHasOptionsMenu(true);

        TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);

        t.setText("Rasterkarten");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);

        Spinner intSpinner = (Spinner) v.findViewById(R.id.indikatoren_spinner);
        final Spinner idSpinner = (Spinner) v.findViewById(R.id.id_spinner);

        String[] indikatoren = new String[] { "Bitte Wählen","Siedlung","Freiraum","Bevölkerung","Verkehr","Landschafts- und Naturschutz","Landschaftsqualität","Risiko","Relief" };

        //parse the xml which are used
        siedlung_titles = parseTitle("title",xml_siedlung);
        siedlung_tags = parseTAG_array(xml_siedlung);

        verkehr_titles = parseTitle("title",xml_verkehr);
        verkehr_tags = parseTAG_array(xml_verkehr);

        freiraum_titles = parseTitle("title",xml_freiraum);
        freiraum_tags = parseTAG_array(xml_freiraum);

        bev_titles = parseTitle("title",xml_bevoelkerung);
        bev_tags = parseTAG_array(xml_bevoelkerung);

        ln_titles = parseTitle("title",xml_ln);
        ln_tags = parseTAG_array(xml_ln);

        lq_titles = parseTitle("title",xml_lq);
        lq_tags = parseTAG_array(xml_lq);

        risiko_titles = parseTitle("title",xml_risiko);
        risiko_tags = parseTAG_array(xml_risiko);

        relief_titles = parseTitle("title",xml_relief);
        relief_tags = parseTAG_array(xml_relief);

        // Create an ArrayAdapter using the string array and a default spinner
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1, indikatoren);
        final ArrayAdapter<String> siedlung_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1, siedlung_titles);
        final ArrayAdapter<String> freiraum_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,freiraum_titles);
        final ArrayAdapter<String> bevoelkerung_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,bev_titles);
        final ArrayAdapter<String> verkehr_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,verkehr_titles);
        final ArrayAdapter<String> ln_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,ln_titles);
        final ArrayAdapter<String> lq_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,lq_titles);
        final ArrayAdapter<String> risiko_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,risiko_titles);
        final ArrayAdapter<String> relief_adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.multiline_spinner_item, android.R.id.text1,relief_titles);

        intSpinner.setAdapter(adapter);

        intSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView x = (TextView) getActivity().findViewById(android.R.id.text1);
                x.setSingleLine(false);
                 if (position == 1) {
                    idSpinner.setAdapter(siedlung_adapter);
                    idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            for (int i = 1; i<siedlung_tags.size();i++){
                                if(siedlung_adapter.getItemId(position)==i){
                                    RasterkartenFragment fragment0 = new RasterkartenFragment();
                                    Bundle args0 = new Bundle();
                                    args0.putString("kat", "file:///android_asset/siedlung/android.html");
                                    args0.putString("tag", siedlung_tags.get(i));
                                    args0.putString("rasterweite", "Rasterweite beträgt 100m");
                                    fragment0.setArguments(args0);
                                    android.support.v4.app.FragmentTransaction fragmentTransaction0 = getActivity().getSupportFragmentManager().beginTransaction();
                                    fragmentTransaction0.replace(R.id.frame, fragment0,"raster");
                                    fragmentTransaction0.addToBackStack("fragment"+i);
                                    fragmentTransaction0.commit();
                                    System.out.println("position================================="+siedlung_tags.get(i));
                                }
                                }
                            }
                            @Override
                            public void onNothingSelected (AdapterView < ? > parent){
                            }
                        }

                        );
                    }
                    if (position == 2) {
                        idSpinner.setAdapter(freiraum_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<freiraum_tags.size();i++){
                                    if(freiraum_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment1 = new RasterkartenFragment();
                                        Bundle args1 = new Bundle();
                                        args1.putString("kat", "file:///android_asset/freiraum/android.html");
                                        args1.putString("tag", freiraum_tags.get(i));
                                        args1.putString("rasterweite", "Rasterweite beträgt 100m");
                                        fragment1.setArguments(args1);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction1.replace(R.id.frame, fragment1,"raster");
                                        fragmentTransaction1.addToBackStack("fragment"+i);
                                        fragmentTransaction1.commit();
                                        System.out.println("position================================="+freiraum_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 3) {
                        idSpinner.setAdapter(bevoelkerung_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<bev_tags.size();i++){
                                    if(bevoelkerung_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment2 = new RasterkartenFragment();
                                        Bundle args2 = new Bundle();
                                        args2.putString("kat", "file:///android_asset/bevoelkerung/android.html");
                                        args2.putString("tag", bev_tags.get(i));
                                        args2.putString("rasterweite", "Rasterweite beträgt 100m");
                                        fragment2.setArguments(args2);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction2.replace(R.id.frame, fragment2,"raster");
                                        fragmentTransaction2.addToBackStack("fragment"+i);
                                        fragmentTransaction2.commit();
                                        System.out.println("position================================="+bev_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 4) {
                        idSpinner.setAdapter(verkehr_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<verkehr_tags.size();i++){
                                    if(verkehr_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment3 = new RasterkartenFragment();
                                        Bundle args3 = new Bundle();
                                        args3.putString("kat", "file:///android_asset/verkehr/android.html");
                                        args3.putString("tag", verkehr_tags.get(i));
                                        args3.putString("rasterweite", "Rasterweite beträgt 100m");
                                        fragment3.setArguments(args3);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction3 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction3.replace(R.id.frame, fragment3,"raster");
                                        fragmentTransaction3.addToBackStack("fragment"+i);
                                        fragmentTransaction3.commit();
                                        System.out.println("position================================="+verkehr_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 5) {
                        idSpinner.setAdapter(ln_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<ln_tags.size();i++){
                                    if(ln_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment4 = new RasterkartenFragment();
                                        Bundle args4 = new Bundle();
                                        args4.putString("kat", "file:///android_asset/ln/android.html");
                                        args4.putString("tag", ln_tags.get(i));
                                        args4.putString("rasterweite", "Rasterweite beträgt 100m");
                                        fragment4.setArguments(args4);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction4 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction4.replace(R.id.frame, fragment4,"raster");
                                        fragmentTransaction4.addToBackStack("fragment"+i);
                                        fragmentTransaction4.commit();
                                        System.out.println("position================================="+ln_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 6) {
                        idSpinner.setAdapter(lq_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<lq_tags.size();i++){
                                    if(lq_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment5 = new RasterkartenFragment();
                                        Bundle args5 = new Bundle();
                                        args5.putString("kat", "file:///android_asset/lq/android.html");
                                        args5.putString("tag", lq_tags.get(i));
                                        args5.putString("rasterweite", "Rasterweite beträgt 1000m");
                                        fragment5.setArguments(args5);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction5.replace(R.id.frame, fragment5,"raster");
                                        fragmentTransaction5.addToBackStack("fragment"+i);
                                        fragmentTransaction5.commit();
                                        System.out.println("position================================="+lq_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 7) {
                        idSpinner.setAdapter(risiko_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<risiko_tags.size();i++){
                                    if(risiko_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment6 = new RasterkartenFragment();
                                        Bundle args6 = new Bundle();
                                        args6.putString("kat", "file:///android_asset/risiko/android.html");
                                        args6.putString("tag", risiko_tags.get(i));
                                        args6.putString("rasterweite", "Rasterweite beträgt 100m");
                                        fragment6.setArguments(args6);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction6 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction6.replace(R.id.frame, fragment6,"raster");
                                        fragmentTransaction6.addToBackStack("fragment"+i);
                                        fragmentTransaction6.commit();
                                        System.out.println("position================================="+risiko_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                    if (position == 8) {
                        idSpinner.setAdapter(relief_adapter);

                        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 1; i<relief_tags.size();i++){
                                    if(relief_adapter.getItemId(position)==i){
                                        RasterkartenFragment fragment7 = new RasterkartenFragment();
                                        Bundle args7 = new Bundle();
                                        args7.putString("kat", "file:///android_asset/relief/android.html");
                                        args7.putString("tag", relief_tags.get(i));
                                        args7.putString("rasterweite", "Rasterweite beträgt 1000m");
                                        fragment7.setArguments(args7);
                                        android.support.v4.app.FragmentTransaction fragmentTransaction7 = getActivity().getSupportFragmentManager().beginTransaction();
                                        fragmentTransaction7.replace(R.id.frame, fragment7,"raster");
                                        fragmentTransaction7.addToBackStack("fragment"+i);
                                        fragmentTransaction7.commit();
                                        System.out.println("position================================="+relief_tags.get(i));
                                    }
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                }
                @Override
                public void onNothingSelected (AdapterView < ? > parent) {
            }
        });


        return v;
    }

    private ArrayList parseTitle(String name,String xml_file){
        AssetManager manager = getActivity().getApplicationContext().getAssets();
        InputStream stream;

        ArrayList<String> elements = new ArrayList<String>();

        try {

            stream = manager.open(xml_file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(name);

            for (int i = 0; i < nList.getLength(); i++) {
                if(i==0){
                    elements.add("Bitte Wählen");
                }
                // Get element
                Element element = (Element)nList.item(i);
                elements.add(element.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }

    private ArrayList parseTAG_array(String xml_file){
        AssetManager manager = getActivity().getApplicationContext().getAssets();
        InputStream stream;

        ArrayList<String> glossar_tags = new ArrayList<String>();
        glossar_tags.add("0");

        try {

            stream = manager.open(xml_file);
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