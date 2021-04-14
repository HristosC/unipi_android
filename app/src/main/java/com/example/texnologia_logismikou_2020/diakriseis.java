package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class diakriseis extends AppCompatActivity {
    TextView id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15,id16;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private int point;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diakriseis);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.navigationmenu);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Intent intent = new Intent(diakriseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(diakriseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(diakriseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition));
                startActivity(intent);
                return false;
            }
        });
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setSelectedItemId(R.id.homepage_bot_nav);
        bottom_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(diakriseis.this, menu_redirection.class);
                intent.putExtra("bot_nav_id", menuItem.getItemId());
                startActivity(intent);
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        View hView =  navigationView.getHeaderView(0);
        ImageView nav_fb = (ImageView)hView.findViewById(R.id.facebook);
        nav_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cs.unipi"));
                startActivity(browserIntent);
            }
        });
        ImageView nav_twitter = (ImageView)hView.findViewById(R.id.twitter);
        nav_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/explore"));
                startActivity(browserIntent);
            }
        });
        create_diakriseis("11522", "Πέμπτη, 25 Φεβρουαρίου 2016 14:57", 2700);

    }
    public void create_diakriseis(String read_times, String modify, int underline_top){
        final String[] str = {"• Skype Android Security Issue","• Το Πανεπιστήμιο Πειραιώς πρωτοπόρο σε\n τομείς αιχμής","Κατάταξη Μελών ΔΕΠ και Διδακτόρων του\n Τμήματος με Βάση το Εργαλείο Microsoft\n Academic Search","• Το Πανεπιστήμιο Πειραιώς στα 100\n Κορυφαία Πανεπιστήμια του Κόσμου για\n Computer Education Σύμφωνα με το Εργαλείο\n Ακαδημαϊκής Αναζήτησης της Microsoft","• Διεθνής Αναγνώριση και Δραστηριότητα\n Μελών ΔΕΠ και Φοιτητών του Τμήματος\n Πληροφορικής","Διακρίσεις Αποφοίτων του Τμήματος\n Πληροφορικής","• Διακρίσεις Τμήματος 2013","• Διακρίσεις Τμήματος 2012","• Διακρίσεις Τμήματος 2010","• Διακρίσεις Τμήματος 2011","• Διακρίσεις Τμήματος 2009","• Διακρίσεις Τμήματος 2008","• Διακρίσεις Τμήματος 2007","• Διακρίσεις Τμήματος 2006","• Διακρίσεις Τμήματος 2005","• Διακρίσεις Τμήματος 2004"};
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_diakriseis);
        final TextView[] diakrisi_title = new TextView[16];
        final TextView[] underline_text = new TextView[2];
        final ImageView[] diakriseis_underline = new ImageView[1];
        int tl=90;
        for (point=0; point<str.length; point++)
        {
            diakrisi_title[point] = new TextView(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 20;
            diakrisi_title[point].setText(str[point]);
            diakrisi_title[point].setTextSize((float) 16);
            diakrisi_title[point].setPadding(20, 50, 20, 50);
            if(point>0){
                if(textview_lines(diakrisi_title[point-1])==2){
                    tl+=185;
                }else if(textview_lines(diakrisi_title[point-1])==1){
                    tl += 110;
                }
                else if(textview_lines(diakrisi_title[point-1])==3){
                    tl += 250;
                }else if(textview_lines(diakrisi_title[point-1])==4){
                    tl += 290;
                }
            }else{
                tl += 200;
            }
            params.topMargin  = tl;
            diakrisi_title[point].setLayoutParams(params);
            diakrisi_title[point].setTextColor(Color.parseColor("#003366"));
            diakrisi_title[point].setPaintFlags(diakrisi_title[point].getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            rl.addView(diakrisi_title[point]);


            final int j = point+1;  // use new variable here
            diakrisi_title[point].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(diakriseis.this, driakriseis_details.class);
                    intent.putExtra("id", j);
                    startActivity(intent);
                }
            });
        }

        underline_text[0] = new TextView(this);
        underline_text[1] = new TextView(this);
        diakriseis_underline[0] = new ImageView(this);
        //Setting image
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 30;
        diakriseis_underline[0].setImageResource(R.drawable.underline);
        params4.topMargin = underline_top;
        diakriseis_underline[0].setLayoutParams(params4);
        rl.addView(diakriseis_underline[0]);
        //Setting read times
        underline_text[0] = new TextView(this);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params5.leftMargin = 30;
        underline_text[0].setText(Html.fromHtml("Read <b>" + read_times + "</b> times"));
        underline_text[0].setTextSize((float) 11);
        underline_text[0].setPadding(20, 50, 20, 50);
        params5.topMargin = underline_top + 20;
        underline_text[0].setLayoutParams(params5);
        underline_text[0].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(underline_text[0]);

        //Setting last modified
        if (!modify.equals("")) {
            underline_text[1] = new TextView(this);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params6.leftMargin = 30 + 520;
            underline_text[1].setText(Html.fromHtml("Last modified on " + modify));
            underline_text[1].setTextSize((float) 11);
            underline_text[1].setPadding(20, 50, 20, 50);
            params6.topMargin = underline_top + 20;
            underline_text[1].setLayoutParams(params6);
            rl.addView(underline_text[1]);
        }

    }

    public int textview_lines(TextView tv){
        int count = tv.getText().toString().split("\\r?\\n").length;
        return count;
    }
}