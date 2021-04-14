package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class stoixeia_epikoinwnias<CountryAdapter> extends AppCompatActivity  {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    Spinner sp1;
    CustomAdapter adapter;
    private ArrayList<GrammateiaItem> mGram_cont;
    private CountryAdapter mAdapter;
    private TextView email,phone,addr,title;
    String[] names = {"Γραμματεία Φοιτητών","Γραμματεία Προέδρου","Γραμματεία ΠΜΣ Πληροφορικής","Γραμματεία ΠΜΣ Προηγμένα Συστήματα Πληροφορικής" , "Γραμματεία e-Learning"};
    int[] images = {R.drawable.teacher,R.drawable.teacher,R.drawable.teacher,R.drawable.teacher,R.drawable.teacher};
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoixeia_epikoinwnias);
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
                Intent intent = new Intent(stoixeia_epikoinwnias.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(stoixeia_epikoinwnias.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(stoixeia_epikoinwnias.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition));
                startActivity(intent);
                return false;
            }
        });
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setSelectedItemId(R.id.contact_bot_nav);
        bottom_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(stoixeia_epikoinwnias.this, menu_redirection.class);
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

        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner);

        mAdapter = (CountryAdapter) new CustomAdapter(this, mGram_cont);
        spinnerCountries.setAdapter((SpinnerAdapter) mAdapter);
        email = (TextView) findViewById(R.id.txtviewemail);
        phone = (TextView) findViewById(R.id.txtphone);
        addr = (TextView) findViewById(R.id.txtaddress);
        title = (TextView) findViewById(R.id.txtgrammateia);
        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GrammateiaItem clickedItem = (GrammateiaItem) parent.getItemAtPosition(position);
                String clickedName = clickedItem.getCountryName();
                if(clickedName == "Γραμματεία Φοιτητών"){
                    title.setText("Γραμματεία Φοιτητών");
                    addr.setText("1ος όροφος, Ζέας 80-82, Πειραιάς 18534");
                    phone.setText("210 4142067, 210 4142437");
                    email.setText("plh-secr@unipi.gr");
                }else if(clickedName == "Γραμματεία Προέδρου"){
                    title.setText("Γραμματεία Προέδρου");
                    addr.setText("Γραφείο 503, Κεντρ. κτίριο, Καραολή & Δημητρίου 80, Πειραιάς 18534");
                    phone.setText("210 4142263");
                    email.setText("infodept@unipi.gr");
                }else if(clickedName == "Γραμματεία ΠΜΣ Πληροφορικής"){
                        title.setText("Γραμματεία ΠΜΣ Πληροφορικής");
                        addr.setText("Γραφείο 503, Κεντρ. κτίριο, Καραολή & Δημητρίου 80, Πειραιάς 18534");
                        phone.setText("210 4142263, 210 4142105");
                    email.setText("infodept@unipi.gr");
                }else if(clickedName == "Γραμματεία ΠΜΣ Προηγμένα Συστήματα Πληροφορικής"){
                    title.setText("Γραμματεία ΠΜΣ Προηγμένα Συστήματα Πληροφορικής");
                    addr.setText("Γραφείο 503, Κεντρ. κτίριο, Καραολή & Δημητρίου 80, Πειραιάς 18534");
                    phone.setText("210 4142105, 210 4142263");
                    email.setText("psp@unipi.gr");
                }else if(clickedName == "Γραμματεία e-Learning"){
                    title.setText("Γραμματεία e-Learning");
                    addr.setText("Γραφείο 503, Κεντρ. κτίριο, Καραολή & Δημητρίου 80, Πειραιάς 18534");
                    phone.setText("210 4142263");
                    email.setText("elearncs@unipi.gr");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        email.setPaintFlags(email.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        email.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:"+email.getText().toString()+"?subject=" + "" + "&body=" + "");
                intent.setData(data);
                startActivity(intent);
            }
        });

    }

    private void initList() {
        mGram_cont = new ArrayList<>();
        mGram_cont.add(new GrammateiaItem("Γραμματεία Φοιτητών", R.drawable.ungraduate));
        mGram_cont.add(new GrammateiaItem("Γραμματεία Προέδρου", R.drawable.rector));
        mGram_cont.add(new GrammateiaItem("Γραμματεία ΠΜΣ Πληροφορικής", R.drawable.graduate));
        mGram_cont.add(new GrammateiaItem("Γραμματεία ΠΜΣ Προηγμένα Συστήματα Πληροφορικής", R.drawable.advancedd));
        mGram_cont.add(new GrammateiaItem("Γραμματεία e-Learning", R.drawable.elearn));
    }
}