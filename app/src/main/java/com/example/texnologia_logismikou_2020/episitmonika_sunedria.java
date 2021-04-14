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
import android.text.method.LinkMovementMethod;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class episitmonika_sunedria extends AppCompatActivity {
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
                Intent intent = new Intent(episitmonika_sunedria.this, sundedrio_details.class);
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
        setContentView(R.layout.episitmonika_sunedria);
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
                Intent intent = new Intent(episitmonika_sunedria.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(episitmonika_sunedria.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(episitmonika_sunedria.this, menu_redirection.class);
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
                Intent intent = new Intent(episitmonika_sunedria.this, menu_redirection.class);
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
                "<a href=\"url\">http://iisa2016.unipi.gr </a><br><br>\n" +
                "\n" +
                "Information is widely available and accessible, but frequently leads to information overload and overexposure, while the effort for coding, storing, hiding, securing, transmitting and retrieving it may be excessive. Intelligenceis required to manage information and extract knowledge from it, inspired by biological and other paradigms.Multimedia Systems and Networks, with an increasing level of Intelligence, are being developed that incorporate these advances. As a result, new Technologies, Protocols and Applications are emerging.\n" +
                "\n" +
                "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology, medicine, chemistry, experimental psychology, social sciences, " +
                "linguistics, and engineering – having the goal of developing methodologies and tools for the solution of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance, education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.";

        String post2 = "\n" +
                "<a href=\"url\">http://fosscomm.cs.unipi.gr</a><br><br>\n" +
                "\n" +
                "Το FOSSCOMM (Free and Open Source Software Communities Meeting) είναι ένα ετήσιο συνέδριο που έχει ως κύριο θέμα το ελεύθερο και ανοικτό λογισμικό, το όποιο έχει φιλοξενηθεί σε πολλές πόλεις της Ελλάδας. Σκοπός του συνεδρίου είναι η προώθηση της χρήσης FOSS (Free and Open Source Software) και απευθύνεται σε προγραμματιστές, FOSS κοινότητες και λοιπούς ενδιαφερόμενους.\n" +
                "\n" +
                "Είμαστε στην ευχάριστη θέση να σας ανακοινώσουμε ότι το 9o FOSSCOMM θα πραγματοποιηθεί στο χώρο του Πανεπιστημίου Πειραιώς στις 16 και 17 Απριλίου, με την υποστήριξη της κοινότητας University of Piraeus, Software Libre Society. Η οργανωτική ομάδα της FOSSCOMM 2016 προσκαλεί" +
                " όλους όσους ενδιαφέρονται να παρακολουθήσουν το συνέδριο να δηλώσουν συμμετοχή στον σύνδεσμο “Δήλωση Παρακολούθησης” για την καλύτερη οργάνωση του συνεδρίου.";

        String post3 = "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction" +
                " and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology," +
                " medicine, chemistry, experimental psychology, social sciences, linguistics, and engineering – having the goal of developing methodologies and tools for the solution " +
                "of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance," +
                " education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.\n" +
                "\n <br>" +
                "<a href=\"url\">http://iisa2015.unipi.gr/</a>";
        String post4 = "July 07 – 09, 2014,  Chania Crete, Greece\n" +
                "\n" +
                "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology, medicine, chemistry, experimental psychology, social sciences, linguistics, and engineering – having the goal of developing methodologies and tools for the solution of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance, education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.\n" +
                "\n" +
                "<br><a href=\"url\">http://iisa2014.unipi.gr/</a>";
        String post5 = "11-13 Οκτωβρίου 2013\n" +
                "\n" +
                "Το 5th Conference on Informatics in Education – Η Πληροφορική στην εκπαίδευση (5th CIE 2013), διοργανώνεται από το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς και το Τμήμα Πληροφορικής του Ιονίου Πανεπιστημίου σε συνεργασία με την ΕΠΥ και εστιάζεται στην Πληροφορική, αλλά και στις ΤΠΕ στην εκπαίδευση. Καλύπτει τόσο τις βαθμίδες της τυπικής εκπαίδευσης –Δευτεροβάθμια (ΓΕΛ, ΕΠΑΛ, Γυμνάσια), Πρωτοβάθμια, " +
                "Τριτοβάθμια- όσο και την μη τυπική εκπαίδευση.<br><a href=\"url\">http://di.ionio.gr/cie/index.php/cie-2013</a>";

        String post6 = "\n" +
                "24-27 Ιουλίου 2012\n" +
                "\n" +
                "The purpose of WINSYS 2012, the International Conference on Wireless Information Networks and Systems, is to bring together researchers, engineers and practitioners interested on information systems and applications in the context of wireless networks and mobile technologies.\n" +
                "\n" +
                "<br><a href=\"url\">http://www.winsys.icete.org/?y=2012</a>";

        String post7 = "7-9 Νοεμβρίου 2012 24th IEEE International Conference on Tools with Artificial Intelligence <br><a href=\"\">http://ictai12.unipi.gr/</a> ";

        String post8 = "5-7 Οκτωβρίου 2012 16th Panhellenic Conference on Informatics with international participation (PCI 2012)<br> <a href=\"url\">http://pci2012.unipi.gr/</a>";
        String post9 = "\n" +
                "5-7 Οκτωβριου 2012\n" +
                "\n" +
                "Το Συνέδριο διοργανώνεται από το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς και το Τμήμα Πληροφορικής του Ιονίου Πανεπιστημίου σε συνεργασία με την ΕΠΥ και εστιάζεται στην Πληροφορική, αλλά και στις ΤΠΕ στην εκπαίδευση. Θα λάβει χώρα και φέτος στους χώρους του Πανεπιστημίου Πειραιώς, 5-7 Οκτωβρίου 2012, παράλληλα με το PCI2012." +
                " Για περισσότερες λεπτομέρειες και το πρόγραμμα επισκεφθείτε την ιστοσελίδα του Συνεδρίου (<a href=\"http://195.130.124.90/cie//\">http://di.ionio.gr/cie/</a>)<br><br>" +
                "<a href=\"url\">http://www.cs.unipi.gr/index.php?lang=el</a>";

        String post10 = "\n" +
                "23-26 August 2012, Rhodes, Greece  10th Joint Conference on Knowledge-Based Software Engineering  <br> <a href=\"url\">http://jckbse12.unipi.gr/</a>";

        String post11 = "\n" +
                "24-27 Ιουλίου 2012\n" +
                "\n" +
                "The purpose of SIGMAP 2012, the International Conference on Signal Processing and Multimedia Applications, is to bring together researchers, engineers and practitioners interested on information systems and applications in the context of Signal Processing, including theory and practice in the field of telecommunications, image, video, audio, biometrics, etc., and Multimedia Applications related to representation, storage, authentication and communication of multimedia information.\n" +
                "\n" +
                "<a href=\"url\">http://www.sigmap.icete.org/?y=2012</a>";

        String post12 = "\n" +
                "18-20 Ιουλίου 2012\n" +
                "\n" +
                "Διεθνές συνέδριο 8th International Conference on Intelligent Information Hiding and Multimedia Signal Processing. <br> <a href=\"url\">http://iihmsp12.unipi.gr/</a>";
        createPosttxtView(R.id.sunedrio_id_1, "<u> · 7th International Conference on Information, Intelligence,Systems and Applications (IISA 2016) </u>", 1, R.drawable.sunedrio1, post);
        createPosttxtView(R.id.sunedrio_id_2, "<u> · 9o Συνέδριο Free and Open Source Software Communities Meeting (FOSSCOMM 2016) στο Πανεπιστήμιο Πειραιώς </u>", 2, R.drawable.sunedrio2, post2);
        createPosttxtView(R.id.sunedrio_id_3, "<u> · 6th International Conference on Information, Intelligence, Systems and Applications (IISA 2015), July 6–8, 2015, Ionian University, Corfu, Greece </u>", 3, R.drawable.sunedrio3, post3);
        createPosttxtView(R.id.sunedrio_id_4, "<u> · 5th International Conference on Information, Intelligence, Systems and Applications (IISA 2014) </u>",4 , R.drawable.sunedrio4, post4);
        createPosttxtView(R.id.sunedrio_id_5, "<u> · 5th Conference on Informatics in Education (CIE 2013) </u>", 5, R.drawable.sunedrio5, post5);
        createPosttxtView(R.id.sunedrio_id_6, "<u> ·9th International Conference on Wireless Information Networks and Systems (WINSYS 2012) </u>", 6, R.drawable.sunedrio6, post6);
        createPosttxtView(R.id.sunedrio_id_7, "<u> · 24th IEEE International Conference on Tools with Artificial Intelligence (ICTAI 2012) </u>", 7, R.drawable.sunedrio7, post7);
        createPosttxtView(R.id.sunedrio_id_8, "<u> · 16th Panhellenic Conference on Informatics with international participation (PCI 2012) </u>", 8, R.drawable.sunedrio8, post8);
        createPosttxtView(R.id.sunedrio_id_9, "<u> · 4th Conference on Informatics in Education (CIE 2012) </u>", 9, R.drawable.sunedrio9, post9);
        createPosttxtView(R.id.sunedrio_id_10, "<u> · 10th Joint Conference on Knowledge-Based Software Engineering (JCKBSE 2012) </u>", 10, R.drawable.sunedrio10, post10);
        createPosttxtView(R.id.sunedrio_id_11, "<u> · 9th International International Conference on Signal Processing and Multimedia Applications (SIGMAP 2012) </u>", 11, R.drawable.sunedrio11, post11);
        createPosttxtView(R.id.sunedrio_id_12, "<u> · 8th International Conference on Intelligent Information Hiding and Multimedia Signal Processing (IIHMSP 2012) </u>", 12, R.drawable.sunedrio12, post12);

        create_underline_info("16141","Κυριακή, 11 Ιουνίου 2017 21:27",3800);

    }
    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_epistimonika_synedria);
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
