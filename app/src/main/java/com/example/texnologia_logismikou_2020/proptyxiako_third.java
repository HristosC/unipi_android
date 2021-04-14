package com.example.texnologia_logismikou_2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class proptyxiako_third extends Fragment {

    public proptyxiako_third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_proptyxiako_third, container, false);

        //tr1
        TableRow tr1 = (TableRow) rootView.findViewById(R.id.eksamino1);
        tr1.setClickable(true);
        tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex1");
                startActivity(intent);
            }
        });

        ///tr2
        TableRow tr2 = (TableRow) rootView.findViewById(R.id.eksamino2);
        tr2.setClickable(true);
        tr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex2");
                startActivity(intent);
            }
        });

        //tr3
        TableRow tr3 = (TableRow) rootView.findViewById(R.id.eksamino3);
        tr3.setClickable(true);
        tr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex3");
                startActivity(intent);
            }
        });

        //tr4
        TableRow tr4 = (TableRow) rootView.findViewById(R.id.eksamino4);
        tr4.setClickable(true);
        tr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex4");
                startActivity(intent);
            }
        });

        //tr5
        TableRow tr5 = (TableRow) rootView.findViewById(R.id.eksamino5);
        tr5.setClickable(true);
        tr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex5");
                startActivity(intent);
            }
        });

        //tr6
        TableRow tr6 = (TableRow) rootView.findViewById(R.id.eksamino6);
        tr6.setClickable(true);
        tr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex6");
                startActivity(intent);
            }
        });

        //tr7
        TableRow tr7 = (TableRow) rootView.findViewById(R.id.eksamino7);
        tr7.setClickable(true);
        tr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex7");
                startActivity(intent);
            }
        });

        //tr8
        TableRow tr8 = (TableRow) rootView.findViewById(R.id.eksamino8);
        tr8.setClickable(true);
        tr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mathimata_examinou.class);
                intent.putExtra("mathima_choice", "ex8");
                startActivity(intent);
            }
        });

        return rootView;
    }


}