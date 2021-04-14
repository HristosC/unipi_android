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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class alles_drasthriotites extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public void createPosttxtView(@IdRes final int id, final String content, final int value, @DrawableRes final int resId, final String post){
        TextView txt = (TextView)findViewById(id);

        txt.setText(Html.fromHtml(content));

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alles_drasthriotites.this, alles_drasthriotites_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);
            }
        });


    }
    public void createPosttxtView(@IdRes final int id, final String content, final int value, final String post){
        TextView txt = (TextView)findViewById(id);

        txt.setText(Html.fromHtml(content));

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alles_drasthriotites.this, alles_drasthriotites_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                //intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);
            }
        });


    }
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alles_drasthriotites);
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
                Intent intent = new Intent(alles_drasthriotites.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(alles_drasthriotites.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(alles_drasthriotites.this, menu_redirection.class);
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
                Intent intent = new Intent(alles_drasthriotites.this, menu_redirection.class);
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
        String post ="Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς εορτάζει τα 25 χρόνια από την Ίδρυσή του και διοργανώνει Ημερίδα με θέμα «Σπουδές και Σταδιοδρομία Πληροφορικής» , η οποία θα πραγματοποιηθεί την Τρίτη 7 Ιουνίου 2016, στην αίθουσα Συνεδρίων (Πορτοκαλί Αμφιθέατρο) του Πανεπιστημίου Πειραιώς (Ισόγειο, Κεντρικό Κτίριο Πανεπιστημίου Πειραιώς). Η Ημερίδα περιλαμβάνει:\n" +
                "\n" +
                "- Παρουσίαση του Προπτυχιακού Προγράμματος Σπουδώντου Τμήματος Πληροφορικής (πρωινή Συνεδρία, έναρξη: 10.30)\n" +
                "\n" +
                "- Παρουσίαση των Μεταπτυχιακών Προγραμμάτων Σπουδών του Τμήματος Πληροφορικής και ομιλίες στελεχών γνωστών εταιρειών στον τομέα της Πληροφορικής (απογευματινή συνεδρία, έναρξη: 18.00)\n" +
                "\n" +
                "Θα ακολουθήσει δεξίωση.\n" +
                "\n" +
                " \n" +
                "\n" +
                "ΕΙΣΟΔΟΣ ΕΛΕΥΘΕΡΗ\n" +
                "\n <br> Download attachments: <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=58_66ef88d79f9c2206ee1bd835e81e78f7&Itemid=583&lang=el\">Πρόγραμμα ημερίδας</a> ";
        String post2 = "Στο πλαίσιο του εορτασμού της επετείου των 25 ετών από την ίδρυσή του, το Τμήμα Πληροφορικής διοργανώνει και συμμετέχει στις παρακάτω εκδηλώσεις:\n" +
                "\n" +
                "<h4><b>Ημερίδα \"Σπουδές και Σταδιοδρομία Πληροφορικής </b></h4>\"\n" +
                "7 Ιουνίου 2016\n" +
                "\n" +
                "Πανεπιστήμιο Πειραιά, κεντρικό κτίριο,\n" +
                "Καραολή & Δημητρίου 80,\n" +
                "Πειραιάς\n" +
                "\n" +
                "Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς εορτάζει τα 25 χρόνια από την Ίδρυσή του και διοργανώνει Ημερίδα με θέμα «Σπουδές και Σταδιοδρομία Πληροφορικής». <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&id=388:imerida-spoudes-kai-stadiodromia-pliroforikis-triti-7-iouniou-2016&Itemid=583&lang=el\">Διαβάστε περισσότερα...</a>\n" +
                "\n" +
                "<h4><b>Συναυλία αφιερωμένη στην μνήμη του Κώστα Βίρβου</b></h4>\n" +
                "25 και 26 Μαΐου 2016, ώρα 21:00\n" +
                "\n" +
                "Βεάκειο Θέατρο, Καστέλλα, Πειραιάς\n" +
                "\n" +
                "Στο πλαίσιο του εορτασμού των 25 χρόνων από την ίδρυση του Τμήματος Πληροφορικής και του προγραμματισμού εκδηλώσεων έχει τεθεί υπό την αιγίδα του μια μεγάλη συναυλία, στην οποία συμμετέχουν 30 και πλέον κορυφαίοι Έλληνες συνθέτες, ερμηνευτές, μουσικοί και ηθοποιοί. Η συναυλία θα λάβει χώρα την Τετάρτη 25/5/2016 και την Πέμπτη 26/5/2016, στο θέατρο Βεάκειο Πειραιά. Για περαιτέρω πληροφορίες έχει αναρτηθεί το Δελτίο Τύπου της εκδήλωσης καθώς και σχετικό ενημερωτικό φυλλάδιο.\n" +
                "\n" +
                "Υλικό και σύνδεσμοι: <a href=\"http://www.cs.unipi.gr/files/afieroma-kosta-virvo-deltio-typoy-2016.pdf\" >Δελτίο τύπου</a>, <a href=\"http://www.cs.unipi.gr/files/afieroma-kosta-virvo-fylladio-2016.jpg\" >Ενημερωτικό φυλάδιο</a>, <a href=\"https://www.facebook.com/709511449150245/photos/pb.709511449150245.-2207520000.1463413618./762884917146231/?type=3&theater\">Σελίδα στο Facebook</a>";
        String post3 = "ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ\n" +
                "ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ\n" +
                "\n" +
                "3 Ιουνίου 2015\n" +
                "Αίθουσα Συνεδρίων, Πανεπιστημίου Πειραιώς\n" +
                "Καραολή & Δημητρίου 80\n" +
                "Πειραιάς 185 34\n" +
                "\n" +
                "Παρουσιάσεις:\n" +
                "Προπτυχιακό Πρόγραμμα Σπουδών: 10.30-12.00\n" +
                "Προγράμματα Μεταπτυχιακών Σπουδών: 18.00-20.30\n" +
                "Δεξίωση: 20.30-21.30 <br> <br> <a href=\"http://www.cs.unipi.gr/files/news/HMERIDA_INFORMATICS_3.6.2015.pdf\" >Πρόγραμμα ημερίδας</a>";
        createPosttxtView(R.id.sunedrio_id_1, "<u> · Ημερίδα \"Σπουδές και Σταδιοδρομία Πληροφορικής\", Τρίτη 7 Ιουνίου 2016 </u>", 1, post);
        createPosttxtView(R.id.sunedrio_id_2, "<u> · Εκδηλώσεις για τα 25 χρόνια από την ίδρυση του Τμήματος Πληροφορικής </u>", 2, R.drawable.virvos, post2);
        createPosttxtView(R.id.sunedrio_id_3, "<u> · Ημερίδα \"Σπουδές και Σταδιοδρομία Πληροφορικής\", 3 Ιουνίου 2015 </u>", 3,post3);
        create_underline_info("12444","Κυριακή, 11 Ιουνίου 2017 21:01",1100);
    }

    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_alles_drast);
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