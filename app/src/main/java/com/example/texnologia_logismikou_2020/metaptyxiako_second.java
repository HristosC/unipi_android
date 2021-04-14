package com.example.texnologia_logismikou_2020;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TableRow;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class metaptyxiako_second extends Fragment {
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_metaptyxiako_second, container, false);

        //tr1
        TableRow tr1 = (TableRow) rootView.findViewById(R.id.metaptyxiako1);
        tr1.setClickable(true);
        tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met1");
                startActivity(intent);
            }
        });

        ///tr2
        TableRow tr2 = (TableRow) rootView.findViewById(R.id.metaptyxiako2);
        tr2.setClickable(true);
        tr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met2");
                startActivity(intent);
            }
        });

        //tr3
        TableRow tr3 = (TableRow) rootView.findViewById(R.id.metaptyxiako3);
        tr3.setClickable(true);
        tr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met3");
                startActivity(intent);
            }
        });

        //tr4
        TableRow tr4 = (TableRow) rootView.findViewById(R.id.metaptyxiako4);
        tr4.setClickable(true);
        tr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met4");
                startActivity(intent);
            }
        });

        //tr5
        TableRow tr5 = (TableRow) rootView.findViewById(R.id.metaptyxiako5);
        tr5.setClickable(true);
        tr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met5");
                startActivity(intent);
            }
        });

        //tr6
        TableRow tr6 = (TableRow) rootView.findViewById(R.id.metaptyxiako6);
        tr6.setClickable(true);
        tr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met6");
                startActivity(intent);
            }
        });

        //tr7
        TableRow tr7 = (TableRow) rootView.findViewById(R.id.metaptyxiako7);
        tr7.setClickable(true);
        tr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met7");
                startActivity(intent);
            }
        });

        //tr8
        TableRow tr8 = (TableRow) rootView.findViewById(R.id.metaptyxiako8);
        tr8.setClickable(true);
        tr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met8");
                startActivity(intent);
            }
        });
        start_asterisk_animation(new int[] {R.id.asterisk_1,R.id.asterisk_2,R.id.asterisk_3,R.id.asterisk_4,R.id.asterisk_5,R.id.asterisk_6,R.id.asterisk_7,R.id.asterisk_8});
        return rootView;
    }
    void start_asterisk_animation(int[] asterisks){
        for(int i=0;i<asterisks.length;i++){
            ImageView the_asterisk=(ImageView) rootView.findViewById(asterisks[i]);
            RotateAnimation rotate = new RotateAnimation(
                    0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
            );

            rotate.setDuration(1200);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setRepeatCount(Animation.INFINITE);
            the_asterisk.startAnimation(rotate);
        }
    }
}