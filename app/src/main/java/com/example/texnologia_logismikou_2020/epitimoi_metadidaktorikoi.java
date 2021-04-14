package com.example.texnologia_logismikou_2020;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
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

public class epitimoi_metadidaktorikoi extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_epitimoi_didakt);
        final TextView[] underline_text = new TextView[2];
        final ImageView[] diakriseis_underline = new ImageView[2];

        underline_text[0] = new TextView(this);
        underline_text[0] = new TextView(this);
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


    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epitimoi_metadidaktorikoi);

        Bundle bundle = getIntent().getExtras();
        String menu = bundle.getString("menu");


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
                Intent intent = new Intent(epitimoi_metadidaktorikoi.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(epitimoi_metadidaktorikoi.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(epitimoi_metadidaktorikoi.this, menu_redirection.class);
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
                Intent intent = new Intent(epitimoi_metadidaktorikoi.this, menu_redirection.class);
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

        String css = "<html><head><style type=\"text/css\">table{ table-layout: fixed;  text-align: center; font-family: Arial, Helvetica, sans-serif;  } th {\n" +
                "  padding-top: 12px;\n" +
                "  padding-bottom: 12px;\n" +
                "  text-align: left;\n" +
                "  background-color: #3240a8;\n" +
                "  color: white;\n" +
                "}td,th {\n" +
                "  border: 1px solid #ddd;\n" +
                "  padding: 8px;\n" +
                "}" +
                "tr:nth-child(even){background-color: #f2f2f2;}" +
                "tr:hover {background-color: #ddd;}\"></style></head> " +
                "<body style=\"text-align:justify;  margin-right :30px; \"> %s </body></Html>";
        WebView wb = (WebView) findViewById(R.id.table);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 5;
        params.topMargin = 150;

        RelativeLayout.LayoutParams title_params=new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        title_params.leftMargin = 20;
        title_params.topMargin = 50;
        TextView title = (TextView) findViewById(R.id.epit_meta_title);
        title.setLayoutParams(title_params);
        wb.setLayoutParams(params);
        if(menu.equals("Μεταδιδακτορικοί")) {

            title.setText(Html.fromHtml("<h3><b>Μεταδιδακτορικοί Ερευνητές</b></h2>"));
            String table =
                    "<table border=1 >\t<thead>\t\t<tr>\t\t\t<th>\t\t\t\t<strong>Επώνυμο</strong></th>\t\t\t<th>\t\t\t\t<strong>Όνομα</strong></th>\t\t\t<th>\t\t\t\t<strong>Email</strong></th>\t\t</tr>\t</thead>\t" +
                            "<tbody>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΑναστασάκης</td>\t\t\t<td>\t\t\t\tΓεώργιος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:anastas@unipi.gr\">anastas@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΒαϊδης</td>\t\t\t<td>\t\t\t\tΤιμολέων</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΒέργαδος</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΒλάχος</td>\t\t\t<td>\t\t\t\tΑριστείδης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:avlachos@unipi.gr\">avlachos@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΓκιζέλης</td>\t\t\t<td>\t\t\t\tΧρήστος-Αντώνιος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΖορμπάς</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΘεοχαρόπουλος</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΚαραγιώργου</td>\t\t\t<td>\t\t\t\tΣοφία</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:karagior@unipi.gr\">karagior@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΚαραντζιάς</td>\t\t\t<td>\t\t\t\tΑθανάσιος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΚαρβουνίδης</td>\t\t\t<td>\t\t\t\tΘεόδωρος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΚατσιώνης</td>\t\t\t<td>\t\t\t\tΓεώργιος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:gkatsion@unipi.gr\">gkatsion@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΜανές</td>\t\t\t<td>\t\t\t\tΚωνσταντίνος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:kmanes@unipi.gr\">kmanes@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΜυριδάκης</td>\t\t\t<td>\t\t\t\tΝικόλαος</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΠετραντωνάκης</td>\t\t\t<td>\t\t\t\tΠαύλος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:papetr@unipi.gr\">papetr@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΣγώρα</td>\t\t\t<td>\t\t\t\tΑγγελική</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:asgora@unipi.gr\">asgora@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΣκόνδρας</td>\t\t\t<td>\t\t\t\tΕμμανουήλ</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:skondras@unipi.gr\">skondras@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΣωτηρόπουλος</td>\t\t\t<td>\t\t\t\tΔιονύσιος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:dsotirop@unipi.gr\">dsotirop@unipi.gr</a></td>\t\t</tr>\t\t" +
                            "<tr>\t\t\t<td>\t\t\t\tΤσελίκης</td>\t\t\t<td>\t\t\t\tΧρήστος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:ctseliki@unipi.gr\">ctseliki@unipi.gr</a></td>\t\t</tr>\t</tbody></table>";
            wb.loadDataWithBaseURL("",String.format(css, table), "text/html", "utf-8","");
            wb.getSettings().setDefaultFontSize(30);
            wb.getSettings().setLoadWithOverviewMode(true);
            wb.getSettings().setUseWideViewPort(true);
            wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            wb.setScrollbarFadingEnabled(false);
            create_underline_info("12836","Τρίτη, 11 Ιουλίου 2017 19:25",1350);
        }else{

            title.setText(Html.fromHtml("<h3><b>Υποψήφιοι Διδάκτορες\n</b></h2>"));
            String table ="<table border=1>\t<thead>\t\t<tr>\t\t\t<th colspan=\"5\"><strong>ΥΠΟΨΗΦΙΟΙ ΔΙΔΑΚΤΟΡΕΣ ΤΜΗΜΑΤΟΣ ΠΛΗΡΟΦΟΡΙΚΗΣ</strong></th>\t\t</tr>\t\t" +
                    "<tr>\t\t\t<th>Επώνυμο</th>\t\t\t<th>Όνομα</th>\t\t\t<th>Email</th>\t\t\t<th>Τηλέφωνο</th>\t\t\t<th>Website</th>\t\t</tr>\t</thead>\t" +
                    "<tbody>\t\t<tr>\t\t\t<td>\t\t\t\tAlmabrok</td>\t\t\t<td>\t\t\t\tAbdo Alnasir</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>" +
                    "\t\t\t\tΑβραντινής</td>\t\t\t<td>\t\t\t\tΝικόλαος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:avrad@unipi.gr\">avrad@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>" +
                    "\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tAλμαλής</td>\t\t\t<td>\t\t\t\tΝικόλαος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t" +
                    "<td>\t\t\t\tΑντωνιάδης</td>\t\t\t<td>\t\t\t\tΡάλλης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΑποστολάτος" +
                    "</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:japost@unipi.gr\">japost@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                    "<tr>\t\t\t<td>\t\t\t\tΒαβούσης</td>\t\t\t<td>\t\t\t\tΑλέξανδρος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t" +
                    "<td>\t\t\t\tΒάρσος</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΒενέτη</td>\t\t\t" +
                    "<td>\t\t\t\tΑφροδίτη</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:aveneti@webmail.unipi.gr\">aveneti@webmail.unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t" +
                    "</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΒλαγκούλης</td>\t\t\t<td>\t\t\t\tΒασίλειος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:v.vlagkoulis@unipi.gr\">v.vlagkoulis@unipi.gr</a>" +
                    "</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΒλαχάκης</td>\t\t\t<td>\t\t\t\tΓεώργιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΒόντας</td>\t\t\t<td>\t\t\t\tΜάριος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:mvodas@unipi.gr\">mvodas@unipi.gr</a>" +
                    "</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"https://mvodas.wordpress.com\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t" +
                    "<td>\t\t\t\tΓαροφαλάκη</td>\t\t\t<td>\t\t\t\tΖαχαρένια</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:z.garofalaki@unipi.gr\">z.garofalaki@unipi.gr</a></td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΓιώτης</td>\t\t\t<td>\t\t\t\tΘεοφάνης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΓκοτσίνας</td>\t\t\t<td>\t\t\t\tΑντώνιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                    "<tr>\t\t\t<td>\t\t\t\tΓκοτσιόπουλος</td>\t\t\t<td>\t\t\t\tΠαναγιώτης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΓρυλλάκης</td>\t\t\t<td>\t\t\t\tΦραγκίσκος</td>\t\t\t<td>\t\t\t\t" +
                    "<a href=\"mailto:fgryllakis@unipi.gr\">fgryllakis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t" +
                    "<tr>\t\t\t<td>\t\t\t\tΔεϊρμεντζόγλου</td>\t\t\t<td>\t\t\t\tΕυάγγελος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t" +
                    "<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΔρακούλης</td>\t\t\t<td>\t\t\t\tΣάββας</td>\t\t\t<td>\t\t\t\t</td>\t\t\t" +
                    "<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΔρακουλόγκωνας</td>\t\t\t<td>\t\t\t\tΠαναγιώτης</td>\t\t\t" +
                    "<td>\t\t\t\t<a href=\"mailto:drakoulogkonas@unipi.gr\">drakoulogkonas@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΕυσταθίου</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t" +
                    "<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΖαρογιάννης</td>\t\t\t<td>\t\t\t\tΑθανάσιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΖογκού</td>\t\t\t<td>\t\t\t\tΜαρία</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:mzogkou@unipi.gr\">mzogkou@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΖυγομήτρος</td>\t\t\t<td>\t\t\t\tΑθανάσιος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:azigomit@unipi.gr\">azigomit@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"http://athanasios.zigomitros.com/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΘεοχάρης</td>\t\t\t<td>\t\t\t\tΣταμάτιος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:stheohar@unipi.gr\">stheohar@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚαλλέργης</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:d.kallergis@unipi.gr\">d.kallergis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t<a href=\"http://netlab.cs.unipi.gr/member/dkallergis/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚαλλιγκάτσης</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚαλογεράκη</td>\t\t\t<td>\t\t\t\tΕλένη-Μαρία</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:elmaklg@unipi.gr\">elmaklg@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142263</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚαραλής</td>\t\t\t<td>\t\t\t\tΑπόστολος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:akaralis@unipi.gr\">akaralis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚατσικογιάννης</td>\t\t\t<td>\t\t\t\tΓεώργιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚοντοβά</td>\t\t\t<td>\t\t\t\tΧρυσούλα</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚοντογιάννη</td>\t\t\t<td>\t\t\t\tΑριστέα</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:akontogianni@unipi.gr\">akontogianni@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚοντούλης</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:ikontoulis@unipi.gr\">ikontoulis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚοπανάκη</td>\t\t\t<td>\t\t\t\tΔέσποινα</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚοτσιφάκος</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚουτσαντώνης</td>\t\t\t<td>\t\t\t\tΔιονύσιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚρούσκα</td>\t\t\t<td>\t\t\t\tΑκριβή</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:akrouska@unipi.gr\">akrouska@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"http://softeng.cs.unipi.gr/akrouska/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΚυπριάδης – Σπυριδωνίδης</td>\t\t\t<td>\t\t\t\tΔαμιανός</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΛιναρδάτος</td>\t\t\t<td>\t\t\t\tΓεράσιμος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t" +
                    "</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜαθιουδάκης</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>" +
                    "\t\t\t<td>\t\t\t\tΜακροδημήτρης</td>\t\t\t<td>\t\t\t\tΓεώργιος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t" +
                    "</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜατζαβέλα</td>\t\t\t<td>\t\t\t\tΒασιλική</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜηλιαρέση</td>\t\t\t<td>\t\t\t\tΙωάννα</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:imiliaresi@unipi.gr\">imiliaresi@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜηλιώρης</td>\t\t\t<td>\t\t\t\tΚωνσταντίνος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:kmil@unipi.gr\">kmil@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜίαρης</td>\t\t\t<td>\t\t\t\tΑλέξανδρος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:amiaris@unipi.gr\">amiaris@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜικέλη</td>\t\t\t<td>\t\t\t\tΑγγελική</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:amikeli@unipi.gr\">amikeli@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΜουγιάκου</td>\t\t\t<td>\t\t\t\tΕιρήνη</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:imougiakou@unipi.gr\">imougiakou@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΝικολάου</td>\t\t\t<td>\t\t\t\tΣπυρίδων</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:s.nikolaou@unipi.gr\">s.nikolaou@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΝτριγκόγιας</td>\t\t\t<td>\t\t\t\tΧρήστος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠαπαγεωργίου</td>\t\t\t<td>\t\t\t\tΑχιλλέας</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠαπαδημητρίου</td>\t\t\t<td>\t\t\t\tΣπυρίδων</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:spap@unipi.gr\">spap@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"http://www.spyrospapadimitriou.gr/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠαπαϊωάννου</td>\t\t\t<td>\t\t\t\tΠαναγιώτης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"https://sites.google.com/site/ppapaioannou/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠαπανίκας</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:papanik@unipi.gr\">papanik@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠαππάς</td>\t\t\t<td>\t\t\t\tΔημήτριος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠετράκος</td>\t\t\t<td>\t\t\t\tΝικόλαος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:npetrakos@unipi.gr\">npetrakos@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠέτρου</td>\t\t\t<td>\t\t\t\tΧρυσάνθη</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠλιώτα</td>\t\t\t<td>\t\t\t\tΘεοδώρα</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠολίτου</td>\t\t\t<td>\t\t\t\tΕυγενία</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:epolitou@unipi.gr\">epolitou@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΠούτος</td>\t\t\t<td>\t\t\t\tΚυριάκος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:kyriakos@unipi.gr\">kyriakos@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142169</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΡήγος</td>\t\t\t<td>\t\t\t\tΚωνσταντίνος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣαλίχος</td>\t\t\t<td>\t\t\t\tΠέτρος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣαρή</td>\t\t\t<td>\t\t\t\tΑϊτζάν</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣεραλίδου</td>\t\t\t<td>\t\t\t\tΕλένη</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:eseralid@unipi.gr\">eseralid@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣιδηρόπουλος</td>\t\t\t<td>\t\t\t\tΣωτήριος-Χρήστος</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣπηλιώτη</td>\t\t\t<td>\t\t\t\tΒασιλική</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣτέλλιος</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΣωτηρόπουλος</td>\t\t\t<td>\t\t\t\tΑνδρέας</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤαμπάκης</td>\t\t\t<td>\t\t\t\tΠαναγιώτης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:ptampak@unipi.gr\">ptampak@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"http://infolab.cs.unipi.gr/people/panosbp/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤζούμπα</td>\t\t\t<td>\t\t\t\tΔήμητρα</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤριανταφύλλου</td>\t\t\t<td>\t\t\t\tΑνδρέας</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤρίχας</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:jtrichas@unipi.gr\">jtrichas@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤρούσσας</td>\t\t\t<td>\t\t\t\tΧρήστος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:ctrouss@unipi.gr\">ctrouss@unipi.gr</a></td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t<a href=\"http://softeng.cs.unipi.gr/ctrouss/\" target=\"blank\"><i class=\"external icon\"></i></a></td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤσαντίλης</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:itsantilis@unipi.gr\">itsantilis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΤσώλης</td>\t\t\t<td>\t\t\t\tΝικόλαος</td>\t\t\t<td>\t\t\t\t<a href=\"mailto:tsolis@unipi.gr\">tsolis@unipi.gr</a></td>\t\t\t<td>\t\t\t\t+30 210 4142458,<br>+30 210 4142127</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΦούντας</td>\t\t\t<td>\t\t\t\tΙωάννης</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t\t<tr>\t\t\t<td>\t\t\t\tΦραγκιαδάκη</td>\t\t\t<td>\t\t\t\tΔέσποινα</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t\t<td>\t\t\t\t</td>\t\t</tr>\t</tbody></table>";
            wb.setInitialScale(1);

            wb.getSettings().setLoadWithOverviewMode(true);
            wb.getSettings().setUseWideViewPort(true);
            wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            wb.setScrollbarFadingEnabled(false);
            wb.loadDataWithBaseURL("",String.format(css, table), "text/html", "utf-8","");
            wb.getSettings().setDefaultFontSize(30);
            create_underline_info("14872","Τρίτη, 11 Ιουλίου 2017 19:27",5450);


        }
        //WebView wb = findViewById(R.id.table);
        //wb.getSettings().setJavaScriptEnabled(true);
        //Resources res = getResources();

        //WebSettings webSettings = wb.getSettings();
        //webSettings.setDefaultFontSize((int)res.getDimension(R.dimen.WBSize));

        //wb.loadDataWithBaseURL("", table, "text/html", "UTF-8", "");






    }
}