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
import android.view.ViewGroup;
import android.webkit.WebView;
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

public class alles_drasthriotites_details extends AppCompatActivity {
    private String title;
    private int img_id;
    private String post;
    ImageView image;
    TextView text_details,title_details;
    private ViewGroup.MarginLayoutParams mlp;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    int margins[] = {1150,2650,750};
    String reads[] = {"1737","4082","3783"};
    String modify[] = {"Δευτέρα, 06 Ιουνίου 2016 18:44","Κυριακή, 11 Ιουνίου 2017 21:05","Παρασκευή, 29 Μαΐου 2015 14:08"};
    String link[] = {"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=58_66ef88d79f9c2206ee1bd835e81e78f7&Itemid=583&lang=el","",""};
    String attachment_name[] = {"Πρόγραμμα ημερίδας (586 Downloads)","",""};
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alles_drasthriotites_details);

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
                Intent intent = new Intent(alles_drasthriotites_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(alles_drasthriotites_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(alles_drasthriotites_details.this, menu_redirection.class);
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
                Intent intent = new Intent(alles_drasthriotites_details.this, menu_redirection.class);
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
        title = bundle.getString("title");
        img_id = bundle.getInt("img_id");
        title_details = (TextView) findViewById(R.id.txt_title);
        image =(ImageView) findViewById(R.id.txt_img);
        image.setImageResource(img_id);
        title_details.setText(Html.fromHtml((title)));
        text_details = (TextView)findViewById(R.id.txt_details);
        text_details.setMovementMethod(LinkMovementMethod.getInstance());
        text_details.setText(Html.fromHtml(post));
        int id = bundle.getInt("id");
        create_details(reads[id-1],modify[id-1],link[id-1],margins[id-1],attachment_name[id-1]);
    }

    void create_details(String read_times, String modify, String link,int underline_top,String link_desc) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_alles_drast_details);
        final TextView[] news_text = new TextView[6];
        final ImageView[] news_underline = new ImageView[2];
        final TextView[] news_date = new TextView[1];

        news_text[0] = new TextView(this);
        news_date[0] = new TextView(this);
        news_underline[0] = new ImageView(this);


        //Setting image
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 30;
        news_underline[0].setImageResource(R.drawable.underline);
        params4.topMargin  = underline_top;
        news_underline[0].setLayoutParams(params4);
        rl.addView(news_underline[0]);

        //Setting read times
        news_text[3] = new TextView(this);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params5.leftMargin = 30;
        news_text[3].setText(Html.fromHtml("Read <b>"+read_times+"</b> times"));
        news_text[3].setTextSize((float) 11);
        news_text[3].setPadding(20, 50, 20, 50);
        params5.topMargin  = underline_top+20;
        news_text[3].setLayoutParams(params5);
        news_text[3].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(news_text[3]);

        //Setting last modified
        if(!modify.equals("")) {
            news_text[4] = new TextView(this);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params6.leftMargin = 30 + 520;
            news_text[4].setText(Html.fromHtml("Last modified on " + modify));
            news_text[4].setTextSize((float) 11);
            news_text[4].setPadding(20, 50, 20, 50);
            params6.topMargin = underline_top + 20;
            news_text[4].setLayoutParams(params6);
            rl.addView(news_text[4]);
        }

        //Setting download
        if(!link.equals("")) {
            news_text[5] = new TextView(this);
            RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params7.leftMargin = 30;
            news_text[5].setText(Html.fromHtml("<b>Download attachments:</b> <a href='" + link + "'>" + link_desc + "</a>"));
            news_text[5].setTextSize((float) 11);
            news_text[5].setPadding(20, 50, 20, 50);
            params7.topMargin = underline_top + 20 + 100;
            news_text[5].setLayoutParams(params7);
            news_text[5].setTextColor(Color.parseColor("#0d0d0d"));
            news_text[5].setMovementMethod(LinkMovementMethod.getInstance());
            rl.addView(news_text[5]);
        }

    }
}