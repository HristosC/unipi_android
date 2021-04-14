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

public class ipiresies_tmimatos_panepistimiou extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    public void createPosttxtView(@IdRes final int id, final String content, final int value, @DrawableRes final int resId,@IdRes final int img_id, final String post){
        TextView txt = (TextView)findViewById(id);

        txt.setText(Html.fromHtml(content));
        ImageView image =(ImageView) findViewById(img_id);
        image.setImageResource(resId);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, ipiresies_tmimatos_panepistimiou_details.class);
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
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, ipiresies_tmimatos_panepistimiou_details.class);
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
        setContentView(R.layout.activity_ipiresies_tmimatos_panepistimiou);

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
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, menu_redirection.class);
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
                Intent intent = new Intent(ipiresies_tmimatos_panepistimiou.this, menu_redirection.class);
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

        String post = "Η πλατφόρμα GUNet eClass αποτελεί ένα ολοκληρωμένο Σύστημα Διαχείρισης Ηλεκτρονικών Μαθημάτων. Ακολουθεί τη φιλοσοφία του λογισμικού ανοικτού κώδικα και υποστηρίζει την υπηρεσία Ασύγχρονης Τηλεκπαίδευσης χωρίς περιορισμούς και δεσμεύσεις. " +
                "Η πρόσβαση στην υπηρεσία γίνεται με τη χρήση ενός απλού φυλλομετρητή (web browser) χωρίς την απαίτηση εξειδικευμένων τεχνικών γνώσεων." +
                "<br> <a href=\"http://gunet2.cs.unipi.gr/eclass\">GUNet eClass - Πλατφόρμα Ασύγχρονης Τηλεκπαίδευσης</a> ";
        String post2 = "Υπηρεσία Πληροφόρησης Φοιτητών. Προγράμματα σπουδών, δηλώσεις, αιτήσεις, βαθμολογία. <br>" +
                "<a href=\"https://students.unipi.gr/\">STUDENTS - Υπηρεσία Πληροφόρησης Φοιτητών</a>";
        String post3 = "Ο Student Support Server είναι ένας H/Y με λειτουργικό σύστημα GNU/Linux στο Πανεπιστήμιο Πειραιώς. Παρέχει υπηρεσίες ηλεκτρονικού ταχυδρομείου " +
                "(e-mail) και διαδικτυακού τόπου (web hosting) για τους φοιτητές του τμήματος Πληροφορικής.<br>" +
                "<a href=\"https://students.cs.unipi.gr/\">STUDENTS.CS - Students support server</a>";
        String post4 = "Από την ιστοσελίδα της Βιβλιοθήκης του Πανεπιστημίου Πειραιά μπορείτε να ενημερωθείτε για τις υπηρεσίες και τη λειτουργία της βιβλιοθήκης. Η ιστοσελίδα επίσης λειτουργεί ως πύλη για τις δικτυακές υπηρεσίες που παρέχονται από τη Βιβλιοθήκη, προσφέροντας πρόσβαση τόσο στον κατάλογο βιβλίων της συλλογής όσο " +
                "και σε ένα σύνολο βάσεων δεδομένων για την ανάκτηση βιβλιογραφικής πληροφορίας και πλήρους κειμένου επιστημονικών άρθρων.<br>" +
                "<a href=\"http://www.lib.unipi.gr/\">Βιβλιοθήκη Πανεπιστημίου Πειραιά</a>";
        String post5 = "Η Ηλεκτρονική Υπηρεσία Ολοκληρωμένης Διαχείρισης Συγγραμμάτων Εύδοξος πρόκειται για μία πρωτοποριακή " +
                "υπηρεσία για την άμεση και ολοκληρωμένη παροχή των Συγγραμμάτων των φοιτητών των Πανεπιστημίων και των ΤΕΙ της επικράτειας.<br>" +
                "<a href=\"http://eudoxus.gr/\">ΕΥΔΟΞΟΣ - Ηλεκτρονική Υπηρεσία Ολοκληρωμένης Διαχείρισης Συγγραμμάτων</a>";
        String post6 = "Υπηρεσία Υποστήριξης Χρηστών. Ερωτήματα και αιτήματα υποστήριξης, γνωσιακή βάση, οδηγοί επίλυσης προβλημάτων.<br>"+
                "<a href=\"https://helpdesk.unipi.gr/\">Helpdesk - Υπηρεσία Υποστήριξης Χρηστών Πανεπιστημίου Πειραιά</a>";
        String post7 = "Το Κέντρο Ερευνών Πανεπιστημίου Πειραιώς (Κ.Ε.Π.Π.) στα πλαίσια του θεσμικού πλαισίου που διέπει τη λειτουργία του, έχει θέσει ως όραμα το να καταστεί ένα σύγχρονο και διεθνούς φήμης ερευνητικό κέντρο το οποίο θα συμβάλλει στην ανάδειξη " +
                "και αναγνώριση του Πανεπιστημίου Πειραιώς ως ενός εκ των κορυφαίων της Ευρώπης."+
                "<a href=\"http://www.kep.unipi.gr/\">ΚΕΠΠ - Κέντρο Ερευνών Πανεπιστημίου Πειραιά</a>";
        String post8 = "Η ιστοσελίδα του Πανεπιστημίου Πειραιά.\n" +
                "<br><a href=\"http://www.unipi.gr/\">Πανεπιστήμιο Πειραιά</a>";
        String post9 = "Βασική επιδίωξη του Γραφείου Διασύνδεσης είναι η πολύπλευρη υποστήριξη των φοιτητών/αποφοίτων για την ομαλή ένταξή τους στην αγορά εργασίας και για την ανάπτυξη επιτυχημένης σταδιοδρομίας. Το Γραφείο Διασύνδεσης προωθεί την ανάπτυξη δυναμικών συνεργασιών και την εξυπηρέτηση τεσσάρων πόλων: των Φοιτητών & Αποφοίτων του Πανεπιστημίου, του Διδακτικού & Ερευνητικού Προσωπικού του Πανεπιστημίου, " +
                "των Επιχειρήσεων & Φορέων προώθησης απασχόλησης και της Δευτεροβάθμιας Εκπαίδευσης.<br><a href=\"http://www.career.unipi.gr/\">Γραφείο Διασύνδεσης Πανεπιστημίου Πειραιά</a>";



        createPosttxtView(R.id.ipiresia_id_1, "GUNET", 1, R.drawable.upiresia1,R.id.txt_img1,post);
        createPosttxtView(R.id.ipiresia_id_2, "STUDENTS", 2, R.drawable.upiresia2,R.id.txt_img2, post2);
        createPosttxtView(R.id.ipiresia_id_3, "STUDENTS.CS", 3, R.drawable.upiresia3,R.id.txt_img3, post3);
        createPosttxtView(R.id.ipiresia_id_4, "Βιβλιοθήκη", 4, R.drawable.upiresia4,R.id.txt_img4, post4);
        createPosttxtView(R.id.ipiresia_id_5, "ΕΥΔΟΞΟΣ ", 5, R.drawable.upiresia5,R.id.txt_img5, post5);
        createPosttxtView(R.id.ipiresia_id_6, "Helpdesk", 6, R.drawable.upiresia6,R.id.txt_img6, post6);
        createPosttxtView(R.id.ipiresia_id_7, "ΚΕΠΠ", 7, R.drawable.upiresia7,R.id.txt_img7, post7);
        createPosttxtView(R.id.ipiresia_id_8, "UNIPI", 8, R.drawable.upiresia8,R.id.txt_img8, post8);
        createPosttxtView(R.id.ipiresia_id_9, "Γρ. Διασύνδεσης", 9, R.drawable.upiresia9,R.id.txt_img9, post9);
    }
}