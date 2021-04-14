package com.example.texnologia_logismikou_2020;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sunergazomenes_etairies extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    public void createPosttxtView(@IdRes final int id, final String content, final int value, @DrawableRes final int resId, @IdRes final int img_id, final String post){
        TextView txt = (TextView)findViewById(id);

        txt.setText(Html.fromHtml(content));
        ImageView image =(ImageView) findViewById(img_id);
        image.setImageResource(resId);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sunergazomenes_etairies.this, Sunergazomenes_etairies_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sunergazomenes_etairies.this, Sunergazomenes_etairies_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);
            }
        });
    }
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunergazomenes_etairies);
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
                Intent intent = new Intent(Sunergazomenes_etairies.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(Sunergazomenes_etairies.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(Sunergazomenes_etairies.this, menu_redirection.class);
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
                Intent intent = new Intent(Sunergazomenes_etairies.this, menu_redirection.class);
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

        String post = "\n" +
                "Η υπηρεσία MSDN Academic Alliance προσφέρει λογισμικό σε φοιτητές (προπτυχιακούς, μεταπτυχιακούς, διδακτορικούς), μέλη ΔΕΠ και προσωπικό της σχολής." +
                "<br> <a href=\"https://e5.onthehub.com/WebStore/Security/Signin.aspx?ws=c7873c65-2578-e011-969d-0030487d8897\">MSDNAA Τμήματος Πληροφορικής Πανεπιστημίου Πειραιά</a> "+
                "<br> <a href=\"http://msdnaa.unipi.gr/\">MSDNAA Πανεπιστημίου Πειραιά</a> "+
                "<br> <a href=\"http://msdn.microsoft.com/academic/\">MSDN Academic Alliance</a> ";
        String post2 = "The Oracle Academy helps more than 1.9 million students gain industry-relevant skills. Few subjects will open as many doors for students in the twenty-first century as computer science (CS) and engineering. To help educators awaken and deepen students' interest in these important fields of study, the Oracle Academy makes available CS education resources that are up-to-date, industry-relevant, and engaging." +
                "<br> <a href=\"https://academy.oracle.com/\">Oracle Academy</a> "+
                "<br> <a href=\"https://academy.oracle.com/oa-web-advancedcs-description.html\">Oracle Academy Advanced CS</a> "+
                "<br> <a href=\"https://academy.oracle.com/oa-student_en.html\">Oracle Academy Student Center</a> ";



        createPosttxtView(R.id.etairia_id_1, "MSDNAA", 1, R.drawable.etairia1,R.id.txt_img1,post);
        createPosttxtView(R.id.etairia_id_2, "Oracle Academy", 2, R.drawable.etairia2,R.id.txt_img2, post2);
    }
}