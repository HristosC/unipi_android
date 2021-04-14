package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
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

public class didaskontes_details extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    private String title;
    private int img_id;
    private String post;
    ImageView image;
    TextView text_details,title_details;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didaskontes_details);

        int id;
        int margins[] = {400,1300,450,450,450,450,450,450,450,450,450,4700,450,450,450,150,450,450,2900};
        String reads[] = {"2227","2208","2071","1763","1998","1850","1775","2075","1955","1997","1824","1825","2129","2324","2228","3274","2997","2109","3054","3332"};
        String modify[] = {"Παρασκευή, 12 Απριλίου 2019 21:03","Παρασκευή, 31 Ιανουαρίου 2020 08:35","Παρασκευή, 12 Απριλίου 2019 21:19","Παρασκευή, 12 Απριλίου 2019 21:06","Παρασκευή, 12 Απριλίου 2019 21:06","Παρασκευή, 12 Απριλίου 2019 21:06"
        ,"Παρασκευή, 12 Απριλίου 2019 21:07","Παρασκευή, 12 Απριλίου 2019 21:10","Παρασκευή, 12 Απριλίου 2019 21:08","Παρασκευή, 12 Απριλίου 2019 21:10","Παρασκευή, 12 Απριλίου 2019 21:18","Παρασκευή, 12 Απριλίου 2019 21:18","Παρασκευή, 12 Απριλίου 2019 21:15"
        ,"Παρασκευή, 12 Απριλίου 2019 21:11","Παρασκευή, 12 Απριλίου 2019 21:11","Παρασκευή, 12 Απριλίου 2019 21:12","Πέμπτη, 04 Οκτωβρίου 2018 15:37","Παρασκευή, 12 Απριλίου 2019 21:05","Παρασκευή, 12 Απριλίου 2019 21:13","Πέμπτη, 04 Οκτωβρίου 2018 15:32"};


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
                Intent intent = new Intent(didaskontes_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(didaskontes_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(didaskontes_details.this, menu_redirection.class);
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
                Intent intent = new Intent(didaskontes_details.this, menu_redirection.class);
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



        Bundle bundle = getIntent().getExtras();
        post = bundle.getString("post");
        id = getIntent().getExtras().getInt("id");
        create_details(post,reads[id-1],modify[id-1],margins[id-1]);
    }

    void create_details(String text, String read_times,String modify,int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_didaskontes_details);
        final TextView[] news_text = new TextView[3];
        final ImageView[] news_underline = new ImageView[1];

        news_underline[0] = new ImageView(this);

        //Setting text
        news_text[0] = new TextView(this);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params2.leftMargin = 30;
        news_text[0].setText(Html.fromHtml(text));
        news_text[0].setTextSize((float) 12);
        news_text[0].setPadding(20, 50, 20, 50);
        params2.topMargin  = 20;
        news_text[0].setLayoutParams(params2);
        news_text[0].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(news_text[0]);


        //Setting image
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 30;
        news_underline[0].setImageResource(R.drawable.underline);
        params4.topMargin  = underline_top;
        news_underline[0].setLayoutParams(params4);
        rl.addView(news_underline[0]);

        //Setting read times
        news_text[1] = new TextView(this);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params5.leftMargin = 30;
        news_text[1].setText(Html.fromHtml("Read <b>"+read_times+"</b> times"));
        news_text[1].setTextSize((float) 11);
        news_text[1].setPadding(20, 50, 20, 50);
        params5.topMargin  = underline_top+20;
        news_text[1].setLayoutParams(params5);
        news_text[1].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(news_text[1]);

        //Setting last modified
        if(!modify.equals("")) {
            news_text[2] = new TextView(this);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params6.leftMargin = 30 + 520;
            news_text[2].setText(Html.fromHtml("Last modified on " + modify));
            news_text[2].setTextSize((float) 11);
            news_text[2].setPadding(20, 50, 20, 50);
            params6.topMargin = underline_top + 20;
            news_text[2].setLayoutParams(params6);
            rl.addView(news_text[2]);
        }


    }
}