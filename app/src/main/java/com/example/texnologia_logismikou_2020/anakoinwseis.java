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
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anakoinwseis extends AppCompatActivity {
    private int point;
    private String nm;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    View.OnClickListener listener;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anakoinwseis);

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
                Intent intent = new Intent(anakoinwseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(anakoinwseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(anakoinwseis.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition));
                startActivity(intent);
                return false;
            }
        });
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setSelectedItemId(R.id.news_bot_nav);
        bottom_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(anakoinwseis.this, menu_redirection.class);
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

        nm = getIntent().getStringExtra("name");
        TextView title = (TextView)findViewById(R.id.dioik_title);
        title.setText(nm);
        if(nm.equals("Διοικητικές πράξεις")) {
            String str[] = {"ΑΝΑΠΛΗΡΩΤΗΣ ΠΡΟΕΔΡΟΥ", "Μονιμοποίηση Επίκουρου Καθηγητή στο\n γνωστικό αντικείμενο Αλγόριθμοι και\n Πολυπλοκότητα", "Πρόσκληση εκδήλωσης ενδιαφέροντος για\n την πρόσληψη εκπαιδευτικού προσωπικού\n με σχέση εργασίας ιδιωτικού δικαίου\n ορισμένου χρόνου", "Μονιμοποίηση μέλους ΔΕΠ", "Πρόσκληση εκδήλωσης ενδιαφέροντος για\n την πρόσληψη εκπαιδευτικού προσωπικού\n με σχέση εργασίας ιδιωτικού δικαίου\n ορισμένου χρόνου"};
            String str_date[] = {"30 Ιουνίου 2016", "26 Απριλίου 2016", "02 Μαρτίου 2016", "18 Μαΐου 2015", "30 Μαρτίου 2015"};
            create_news(str,str_date);
        }else{
            String[] str = {"Ανακοίνωση δήλωσης συγγραμμάτων\n εαρινού εξαμήνου ακ. έτους 2019-2020","Ανακοίνωση για τροποποίηση ακαδημαϊκού\n ημερολογίου 2019-2020","Σίτιση των φοιτητών εν όψει των εορτών\n του Πάσχα","Εκπαιδευτική λειτουργία εξ αποστάσεως","Ανακοίνωση του Πανεπιστημίου Πειραιώς\n για την ηλεκτρονική εξ αποστάσεως\n εκπαίδευση","Μετακίνηση φοιτητών για παραλαβή δωρεάν\n γεύματος σε πακέτο από τη Φοιτητικό\n Εστιατόριο του Πανεπιστημίου Πειραιώς\n (αφορά και φοιτητές ERASMUS","Απαγόρευση εκπαιδευτικής λειτουργίας με\n φυσική παρουσία","Το τμήμα Πληροφορικής προχωρεί\n σε τηλε-διδασκαλία των μαθημάτων\n, συμμορφούμενο με τις οδηγίες του\n Υπουργείου",
                    "ΝΕΟ - Παράταση Δηλώσεων Μαθημάτων\n Εαρινού Εξαμήνου ακ. έτους 2019-2020","Παράταση Δηλώσεων Μαθημάτων Εαρινού\n Εξαμήνου ακ. έτους 2019-2020","Ανακοίνωση για τη δήλωση μαθημάτων\n παιδαγωγικής επάρκειας",
            "Πρόγραμμα Διδασκαλίας Εαρινού Εξαμήνου\n Ακαδημαϊκού Έτους 2019-2020","Ορκωμοσία αποφοίτων του Προγράμματος\n Μεταπτυχιακών Σπουδών «Πληροφορική»\n του Τμήματος Πληροφορικής στις 27\n Φεβρουαρίου 2020",
            "Ορκωμοσία αποφοίτων του Προγράμματος\n Μεταπτυχιακών Σπουδών «Προηγμένα\n Σύστηματα Πληροφορικής» του Τμήματος\n Πληροφορικής στις 27 Φεβρουαρίου 2020","Έναρξη μαθημάτων εαρινού εξ. 2019-2020","Αναβολή Εξετάσεων λόγω απεργίας ΜΜΜ"
            ,"Ανακοίνωση για δωρεάν σίτιση φοιτητών /\n φοιτητριών (Ακαδημαϊκό Έτος 2019-2020)","Ανακοίνωση ορκωμοσίας των αποφοίτων\n των Τμημάτων της Σχολής-12 Μαρτίου 2020","ΙΚΥ - Ανακοίνωση προγράμματος\n υποτροφιών για εκπόνηση διδακτορικής\n διατριβής στο εξωτερικό. Πρόγραμμα\n ΙΚΥ-ΕΤΕ",
            "Εσπερίδα Πληροφορικής και Τεχνητής\n Νοημοσύνης","Το Τμήμα Πληροφορικής προσφέρει πλέον\n παιδαγωγική επάρκεια!"};
            String[] str_date = {"Σάββατο, 11 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Δευτέρα, 30 Μαρτίου 2020","Δευτέρα, 30 Μαρτίου 2020","Τρίτη, 24 Μαρτίου 2020","Κυριακή, 22 Μαρτίου 2020",
                    "16 Μαρτίου 2020","09 Μαρτίου 2020","25 Φεβρουαρίου 2020","21 Φεβρουαρίου 2020","18 Φεβρουαρίου 2020","18 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","12 Φεβρουαρίου 2020","27 Ιουνίου 2019"};
            create_news(str,str_date);
        }

    }
    public void create_news(final String[] str , final String[] str_date){
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_anakoinwseis);
        final TextView[] news_title = new TextView[21];
        final ImageView[] news_underline = new ImageView[21];
        final TextView[] news_date = new TextView[21];
        int tl=10;
        int dt=100;
        int img=100;
        for (point=0; point<str.length; point++)
        {
            dt = tl;
            img = tl;
            news_title[point] = new TextView(this);
            news_date[point] = new TextView(this);
            news_underline[point] = new ImageView(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);


            //FOR LAST NEWS TITLE
            params.leftMargin = 50;
            news_title[point].setText(str[point]);
            news_title[point].setTextSize((float) 16);
            news_title[point].setPadding(20, 50, 20, 50);
            if(point>0){
                if(textview_lines(news_title[point-1])==2){
                    tl+=205;
                }else if(textview_lines(news_title[point-1])==1){
                    tl += 160;
                }
                else if(textview_lines(news_title[point-1])==3){
                    tl += 280;
                }else if(textview_lines(news_title[point-1])==4){
                    tl += 320;
                }
            }else{
                tl += 200;
            }
            params.topMargin  = tl;
            news_title[point].setLayoutParams(params);
            news_title[point].setTextColor(Color.parseColor("#003366"));
            news_title[point].setPaintFlags(news_title[point].getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            rl.addView(news_title[point]);

            final int j = point;  // use new variable here
            news_title[point].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(anakoinwseis.this, anakoinwseis_details.class);
                    intent.putExtra("id", j);
                    intent.putExtra("chapter", nm);
                    intent.putExtra("title", str);
                    intent.putExtra("date", str_date);
                    startActivity(intent);
                }
            });

            //FOR LAST NEWS DATE STRING
            if(textview_lines(news_title[point])==2){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4) {
                        dt += 440;
                    }else if(textview_lines(news_title[point-1])==1){
                            dt+=280;
                    }else{
                        dt+=320;
                    }
                }else{
                    dt+=320;
                }
            }else if(textview_lines(news_title[point])==1){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4){
                        dt+=380;
                    }else if(textview_lines(news_title[point-1])==1){
                        dt+=215;
                    }else{
                        dt+=260;
                    }
                }else{
                    dt+=260;
                }
            }else if(textview_lines(news_title[point])==3){
                    dt+=340;
            }else if(textview_lines(news_title[point])==4){
                if(point>0){
                    if(textview_lines(news_title[point-1])==2) {
                        dt += 440;
                    }else if(textview_lines(news_title[point-1])==1){
                        dt+=390;
                    }else if(textview_lines(news_title[point-1])==4){
                        dt+=550;
                    }else{
                        dt+=510;
                    }
                }else{
                    dt+=510;
                }
            }
            RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params2.topMargin  = dt;
            params2.leftMargin = 50;
            news_date[point].setText(str_date[point]);
            news_date[point].setTextSize((float) 11);
            news_date[point].setPadding(20, 50, 20, 50);
            news_date[point].setLayoutParams(params2);
            news_date[point].getLineCount();
            rl.addView(news_date[point]);

            //FOR LAST NEWS image
            if(textview_lines(news_title[point])==2){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4) {
                        img += 525;
                    }else if(textview_lines(news_title[point-1])==1){
                        img += 360;
                    }else{
                        img+=395;
                    }
                }else{
                    img+=395;
                }
            }else if(textview_lines(news_title[point])==1){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4) {
                        img += 465;
                    }else if(textview_lines(news_title[point-1])==1){
                        img+=305;
                    }else{
                        img+=345;
                    }
                }else{
                    img+=345;
                }
            }else if(textview_lines(news_title[point])==3){
                img+=425;
            }else if(textview_lines(news_title[point])==4){
                if(point>0){
                    if(textview_lines(news_title[point-1])==2){
                        img+=540;
                    }else if(textview_lines(news_title[point-1])==1) {
                        img += 480;
                    }else if(textview_lines(news_title[point-1])==4){
                            img+=640;
                    }else{
                        img+=600;
                    }
                }else{
                    img+=600;
                }
            }
            RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params3.topMargin  = img;
            params3.leftMargin = 50;
            news_underline[point].setImageResource(R.drawable.underline);
            news_underline[point].setLayoutParams(params3);
            rl.addView(news_underline[point]);

        }
    }

    public int textview_lines(TextView tv){
        int count = tv.getText().toString().split("\\r?\\n").length;
        return count;
    }
}

