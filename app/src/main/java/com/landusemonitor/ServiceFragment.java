package com.landusemonitor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;


public class ServiceFragment extends Fragment {

    LinearLayout mLinearLayout;
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_service, container, false);
        setHasOptionsMenu(true);

        TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);

        t.setText("Service");

        mLinearLayout = (LinearLayout) v.findViewById(R.id.text_impressum);
        mLinearLayout.setVisibility(View.GONE);

        final ImageButton collapse_impressum = (ImageButton) v.findViewById(R.id.btn_impressum);

        // Kontakt
        DocumentView dc = (DocumentView) v.findViewById(R.id.service_1);
        dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc.setText(getString(R.string.service_1));

        //Copyright
        DocumentView copy1 = (DocumentView) v.findViewById(R.id.impressum_1);
        copy1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        copy1.setText(getString(R.string.copy_1));

        DocumentView copy2 = (DocumentView) v.findViewById(R.id.impressum_2);
        copy2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        copy2.setText(getString(R.string.copy_2));

        DocumentView copy3 = (DocumentView) v.findViewById(R.id.impressum_3);
        copy3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        copy3.setText(getString(R.string.copy_3));

        //Impressum
        DocumentView dc1 = (DocumentView) v.findViewById(R.id.haftung_1);
        dc1.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc1.setText(getString(R.string.haftung_1));

        DocumentView dc2 = (DocumentView) v.findViewById(R.id.urheberrecht_1);
        dc2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc2.setText(getString(R.string.urheber_1));

        DocumentView dc3 = (DocumentView) v.findViewById(R.id.urheberrecht_2);
        dc3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc3.setText(getString(R.string.urheber_2));

        collapse_impressum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count == 1) {
                   mLinearLayout.setVisibility(View.VISIBLE);
                    collapse_impressum.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_up));
                } else {
                    mLinearLayout.setVisibility(View.GONE);
                    collapse_impressum.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_down));
                    count = 0;
                }
            }
        });

        return v;
    }


}
