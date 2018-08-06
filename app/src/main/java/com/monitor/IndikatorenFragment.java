package com.monitor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.monitor.indikatoren.FragmentKategorie;


public class IndikatorenFragment extends Fragment {

	LinearLayout mLinearLayout;
	LinearLayout siedlung;
	LinearLayout freiraum;
	LinearLayout bevoelkerung;
	LinearLayout verkehr;
	LinearLayout lun;
	LinearLayout lq;
	LinearLayout risiko;
	LinearLayout relief;
	int count = 0;
	ScrollView methodik_ScrollView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_indikatoren, container, false);

		setHasOptionsMenu(true);

		TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);

		t.setText("Indikatoren");

		methodik_ScrollView = (ScrollView) v.findViewById(R.id.scoll_methodik);

		mLinearLayout = (LinearLayout) v.findViewById(R.id.text_indikatoren1);
		final ImageButton collapse_text = (ImageButton) v.findViewById(R.id.collapse_text_indikatoren);
		DocumentView dc = (DocumentView) v.findViewById(R.id.indikator_1);
		DocumentView dc2 = (DocumentView) v.findViewById(R.id.indikator_2);
		dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc.setText(getString(R.string.indikator_1));
		dc2.setText(getString(R.string.indikator_2));

		collapse_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) mLinearLayout.findViewById(R.id.text_indikatoren1);
					temp.setVisibility(View.GONE);
					collapse_text.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_down));

					System.out.println("Button Indikator 1 was pressed");
					count = 0;

				} else {
					final LinearLayout temp_ll = (LinearLayout) mLinearLayout.findViewById(R.id.text_indikatoren1);
					temp_ll.setVisibility(View.VISIBLE);
					collapse_text.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_up));
					count = 0;
				}
			}
		});

		// Buttons der Kategorien werden hinzugefügt
		// Siedlung

		final Button btnSiedlung = (Button) v.findViewById(R.id.btn_siedlung);
		siedlung = (LinearLayout) v.findViewById(R.id.text_siedlung);
		siedlung.setVisibility(View.GONE);
		DocumentView dc_siedlung = (DocumentView) v.findViewById(R.id.siedlung);
		dc_siedlung.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_siedlung.setText(getString(R.string.indikator_siedlung));
		TextView link_siedlung = (TextView) v.findViewById(R.id.link_siedlung);
		link_siedlung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment1 = new FragmentKategorie();
				Bundle args1 = new Bundle();
				args1.putString("url", "file:///android_asset/indikatoren_siedlung.html");
				fragment1.setArguments(args1);
				android.support.v4.app.FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction1.replace(R.id.frame, fragment1,"raster");
				fragmentTransaction1.addToBackStack("fragment1");
				fragmentTransaction1.commit();
			}
		});

		btnSiedlung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) siedlung.findViewById(R.id.text_siedlung);
					temp.setVisibility(View.VISIBLE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) siedlung.findViewById(R.id.text_siedlung);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Freiraum
		final Button btnFreiraum = (Button) v.findViewById(R.id.btn_freiraum);
		freiraum = (LinearLayout) v.findViewById(R.id.text_freiraum);
		freiraum.setVisibility(View.GONE);
		DocumentView dc_freiraum = (DocumentView) v.findViewById(R.id.freiraum);
		dc_freiraum.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_freiraum.setText(getString(R.string.indikator_freiraum));
		TextView link_freiraum = (TextView) v.findViewById(R.id.link_freiraum);
		link_freiraum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment2 = new FragmentKategorie();
				Bundle args2 = new Bundle();
				args2.putString("url", "file:///android_asset/indikatoren_freiraum.html");
				fragment2.setArguments(args2);
				android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction2.replace(R.id.frame, fragment2,"raster");
				fragmentTransaction2.addToBackStack("fragment2");
				fragmentTransaction2.commit();
			}
		});

		btnFreiraum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) freiraum.findViewById(R.id.text_freiraum);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) freiraum.findViewById(R.id.text_freiraum);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Bevölkerung
		final Button btnBevoelkerung = (Button) v.findViewById(R.id.btn_bevoelkerung);
		bevoelkerung = (LinearLayout) v.findViewById(R.id.text_bevoelkerung);
		bevoelkerung.setVisibility(View.GONE);
		DocumentView dc_bevoelkerung = (DocumentView) v.findViewById(R.id.bevoelkerung);
		dc_bevoelkerung.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_bevoelkerung.setText(getString(R.string.indikator_bevoelkerung));
		TextView link_bevoelkerung = (TextView) v.findViewById(R.id.link_bevoelkerung);
		link_bevoelkerung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment3 = new FragmentKategorie();
				Bundle args3 = new Bundle();
				args3.putString("url", "file:///android_asset/indikatoren_bevoelkerung.html");
				fragment3.setArguments(args3);
				android.support.v4.app.FragmentTransaction fragmentTransaction3 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction3.replace(R.id.frame, fragment3,"raster");
				fragmentTransaction3.addToBackStack("fragment3");
				fragmentTransaction3.commit();
			}
		});

		btnBevoelkerung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) bevoelkerung.findViewById(R.id.text_bevoelkerung);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) bevoelkerung.findViewById(R.id.text_bevoelkerung);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Verkehr
		final Button btnVerkehr = (Button) v.findViewById(R.id.btn_verkehr);
		verkehr = (LinearLayout) v.findViewById(R.id.text_verkehr);
		verkehr.setVisibility(View.GONE);
		DocumentView dc_verkehr = (DocumentView) v.findViewById(R.id.verkehr);
		dc_verkehr.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_verkehr.setText(getString(R.string.indikator_verkehr));
		TextView link_verkehr = (TextView) v.findViewById(R.id.link_verkehr);
		link_verkehr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment4 = new FragmentKategorie();
				Bundle args4 = new Bundle();
				args4.putString("url", "file:///android_asset/indikatoren_verkehr.html");
				fragment4.setArguments(args4);
				android.support.v4.app.FragmentTransaction fragmentTransaction4 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction4.replace(R.id.frame, fragment4,"raster");
				fragmentTransaction4.addToBackStack("fragment4");
				fragmentTransaction4.commit();
			}
		});

		btnVerkehr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) verkehr.findViewById(R.id.text_verkehr);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) verkehr.findViewById(R.id.text_verkehr);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Landschafts- und Naturschutz
		final Button btnLun = (Button) v.findViewById(R.id.btn_lun);
		lun = (LinearLayout) v.findViewById(R.id.text_lun);
		lun.setVisibility(View.GONE);
		DocumentView dc_lun = (DocumentView) v.findViewById(R.id.lun);
		dc_lun.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_lun.setText(getString(R.string.indikator_lun));
		TextView link_lun = (TextView) v.findViewById(R.id.link_lun);
		link_lun.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment5 = new FragmentKategorie();
				Bundle args5 = new Bundle();
				args5.putString("url", "file:///android_asset/indikatoren_ln.html");
				fragment5.setArguments(args5);
				android.support.v4.app.FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction5.replace(R.id.frame, fragment5,"raster");
				fragmentTransaction5.addToBackStack("fragment5");
				fragmentTransaction5.commit();
			}
		});

		btnLun.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) lun.findViewById(R.id.text_lun);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) lun.findViewById(R.id.text_lun);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Landschaftsqualität
		final Button btnLq = (Button) v.findViewById(R.id.btn_lq);
		lq = (LinearLayout) v.findViewById(R.id.text_lq);
		lq.setVisibility(View.GONE);
		DocumentView dc_lq = (DocumentView) v.findViewById(R.id.lq);
		dc_lq.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_lq.setText(getString(R.string.indikator_lq));
		TextView link_lq = (TextView) v.findViewById(R.id.link_lq);
		link_lq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment6 = new FragmentKategorie();
				Bundle args6 = new Bundle();
				args6.putString("url", "file:///android_asset/indikatoren_lq.html");
				fragment6.setArguments(args6);
				android.support.v4.app.FragmentTransaction fragmentTransaction6 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction6.replace(R.id.frame, fragment6,"raster");
				fragmentTransaction6.addToBackStack("fragment6");
				fragmentTransaction6.commit();
			}
		});

		btnLq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) lq.findViewById(R.id.text_lq);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) lq.findViewById(R.id.text_lq);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Risiko
		final Button btnRisiko = (Button) v.findViewById(R.id.btn_risiko);
		risiko = (LinearLayout) v.findViewById(R.id.text_risiko);
		risiko.setVisibility(View.GONE);
		TextView link_risiko = (TextView) v.findViewById(R.id.link_risiko);
		link_risiko.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment7 = new FragmentKategorie();
				Bundle args7 = new Bundle();
				args7.putString("url", "file:///android_asset/indikatoren_risiko.html");
				fragment7.setArguments(args7);
				android.support.v4.app.FragmentTransaction fragmentTransaction7 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction7.replace(R.id.frame, fragment7,"raster");
				fragmentTransaction7.addToBackStack("fragment7");
				fragmentTransaction7.commit();
			}
		});

		btnRisiko.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) risiko.findViewById(R.id.text_risiko);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					relief.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) risiko.findViewById(R.id.text_risiko);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		//Relief
		final Button btnRelief = (Button) v.findViewById(R.id.btn_relief);
		relief = (LinearLayout) v.findViewById(R.id.text_relief);
		relief.setVisibility(View.GONE);
		TextView link_relief = (TextView) v.findViewById(R.id.link_relief);
		link_relief.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentKategorie fragment8 = new FragmentKategorie();
				Bundle args8 = new Bundle();
				args8.putString("url", "file:///android_asset/indikatoren_relief.html");
				fragment8.setArguments(args8);
				android.support.v4.app.FragmentTransaction fragmentTransaction8 = getActivity().getSupportFragmentManager().beginTransaction();
				fragmentTransaction8.replace(R.id.frame, fragment8,"raster");
				fragmentTransaction8.addToBackStack("fragment8");
				fragmentTransaction8.commit();
			}
		});

		btnRelief.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				if (count == 1) {
					LinearLayout temp = (LinearLayout) relief.findViewById(R.id.text_relief);
					temp.setVisibility(View.VISIBLE);
					siedlung.setVisibility(View.GONE);
					freiraum.setVisibility(View.GONE);
					bevoelkerung.setVisibility(View.GONE);
					verkehr.setVisibility(View.GONE);
					lun.setVisibility(View.GONE);
					lq.setVisibility(View.GONE);
					risiko.setVisibility(View.GONE);
				} else {
					final LinearLayout temp_ll = (LinearLayout) relief.findViewById(R.id.text_relief);
					temp_ll.setVisibility(View.GONE);
					count = 0;
				}
			}
		});

		DocumentView dc_themenfeld1 = (DocumentView) v.findViewById(R.id.themenfeld_1);
		dc_themenfeld1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_themenfeld1.setText(getString(R.string.indikator_themenfeld1));

		DocumentView dc_themenfeld2 = (DocumentView) v.findViewById(R.id.themenfeld_2);
		dc_themenfeld2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_themenfeld2.setText(getString(R.string.indikator_themenfeld2));

		DocumentView dc_themenfeld3 = (DocumentView) v.findViewById(R.id.themenfeld_3);
		dc_themenfeld3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_themenfeld3.setText(getString(R.string.indikator_themenfeld3));

		DocumentView dc_themenfeld4 = (DocumentView) v.findViewById(R.id.themenfeld_4);
		dc_themenfeld4.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
		dc_themenfeld4.setText(getString(R.string.indikator_themenfeld4));

		return v;
	}

}
