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
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class didaktorikes_spoydes extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didaktorikes_spoydes);

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
                Intent intent = new Intent(didaktorikes_spoydes.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(didaktorikes_spoydes.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(didaktorikes_spoydes.this, menu_redirection.class);
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
                Intent intent = new Intent(didaktorikes_spoydes.this, menu_redirection.class);
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

        TextView text6 = (TextView) findViewById(R.id.text6);
        String text = "Για την εκπόνηση διδακτορικής διατριβής οι υποψήφιοι πρέπει να πληρούν τις παρακάτω προϋποθέσεις: <br> " +
                "<br> <b>1.</b> Να είναι πτυχιούχοι Τμημάτων Α.Ε.Ι. (Πανεπιστημίων και Τ.Ε.Ι). της ημεδαπής ή αναγνωρισμένων ομοταγών ιδρυμάτων της αλλοδαπής." +
                "<br> <b>2.</b> Να είναι κάτοχοι Μεταπτυχιακού Διπλώματος Ειδίκευσης ή κάτοχοι ισότιµου Μεταπτυχιακού ∆ιπλώµατος Ειδίκευσης Πανεπιστηµιακών Τµηµάτων " +
                "της ηµεδαπής ή αναγνωρισµένων οµοταγών πανεπιστηµιακών ιδρυµάτων της αλλοδαπής. Για τους κατόχους µεταπτυχιακού τίτλου σπουδών από πανεπιστηµιακό " +
                "ίδρυµα της αλλοδαπής, είναι απαραίτητη η αναγνώριση του τίτλου αυτού από το ∆ΟΑΤΑΠ.<br>" +
                "<b>3.</b> Να έχουν επαρκή γνώση της αγγλικής γλώσσας που να πιστοποιείται είτε µε πλήρη κύκλο σπουδών στο εξωτερικό ή τουλάχιστον πιστοποιητικό γλωσσοµάθειας αντίστοιχο του First Certificate.<br>";
        text6.setText(Html.fromHtml(text));

        TextView text8 = (TextView) findViewById(R.id.text8);
        text = " <b>1.</b> Αίτηση του ενδιαφερομένου." +
                "<br> <b>2. </b>Αναλυτικό βιογραφικό σημείωμα." +
                "<br> <b>3. </b>Πρώτο πτυχίο σε οποιαδήποτε ειδικότητα από αναγνωρισμένο εκπαιδευτικό Ίδρυμα." +
                "<br> <b>4. </b>Μεταπτυχιακό δίπλωμα τύπου Μάστερ (ΜΒΑ, Μ.Sc.), σε συναφές αντικείμενο, από αναγνωρισμένο εκπαιδευτικό 'Ιδρυμα." +
                "<br> <b>5. </b>Αναλυτική βαθμολογία από τις προπτυχιακές και μεταπτυχιακές σπουδές." +
                "<br> <b>6. </b>Απόδειξη γλωσσομάθειας της Αγγλικής Γλώσσας.<br>";
        text8.setText(Html.fromHtml(text));

        create_underline_info("18777","Δευτέρα, 24 Σεπτεμβρίου 2018 15:37",3420);
    }
    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_didaktorikes_spoudes);
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
}