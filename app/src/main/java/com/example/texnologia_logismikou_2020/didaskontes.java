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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class didaskontes extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    public void createPosttxtView(final int id_num, @IdRes final int id, final String content, @DrawableRes final int resId, @IdRes final int img_id,
                                  @DrawableRes final int img_id_globe, @DrawableRes final int img_id_email,
                                  final String post, @IdRes final int img_id2, @IdRes final int img_id3, String email, final String url) {
        TextView txt = (TextView) findViewById(id);

        txt.setText(Html.fromHtml(content));
        ImageView image = (ImageView) findViewById(img_id);
        image.setImageResource(resId);
        ImageView image2 = (ImageView) findViewById(img_id2);
        image2.setImageResource(img_id_globe);
        ImageView image3 = (ImageView) findViewById(img_id3);
        image3.setImageResource(img_id_email);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(didaskontes.this, didaskontes_details.class);
                intent.putExtra("id", id_num);
                intent.putExtra("title", content);

                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(didaskontes.this, didaskontes_details.class);
                intent.putExtra("id", id_num);
                intent.putExtra("title", content);

                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        final Uri uri = Uri.parse(email);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivity2 = new Intent(Intent.ACTION_SENDTO, uri);

                startActivity(myActivity2);
            }
        });
    }

    public void createPosttxtViewGram(@IdRes final int id, final String content, @DrawableRes final int resId, @IdRes final int img_id,
                                      @DrawableRes final int img_id_email, final String post, @IdRes final int img_id3, String email){
        TextView txt = (TextView)findViewById(id);

        txt.setText(Html.fromHtml(content));
        ImageView image =(ImageView) findViewById(img_id);
        image.setImageResource(resId);

        ImageView image3 =(ImageView) findViewById(img_id3);
        image3.setImageResource(img_id_email);



        final Uri uri = Uri.parse(email);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivity2 = new Intent(Intent.ACTION_SENDTO, uri);

                startActivity(myActivity2);
            }
        });
    }

    public void createPosttxtView(final int id_num, @IdRes final int id, final String content, @DrawableRes final int resId, @IdRes final int img_id,
                                  @DrawableRes final int img_id_email, final String post, @IdRes final int img_id3, String email) {
        TextView txt = (TextView) findViewById(id);

        txt.setText(Html.fromHtml(content));
        ImageView image = (ImageView) findViewById(img_id);
        image.setImageResource(resId);

        ImageView image3 = (ImageView) findViewById(img_id3);
        image3.setImageResource(img_id_email);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(didaskontes.this, didaskontes_details.class);
                intent.putExtra("id", id_num);


                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(didaskontes.this, didaskontes_details.class);
                intent.putExtra("id", id_num);


                intent.putExtra("post", post);
                startActivity(intent);
            }
        });

        final Uri uri = Uri.parse(email);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivity2 = new Intent(Intent.ACTION_SENDTO, uri);

                startActivity(myActivity2);
            }
        });
    }

    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didaskontes);

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
                Intent intent = new Intent(didaskontes.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(didaskontes.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(didaskontes.this, menu_redirection.class);
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
                Intent intent = new Intent(didaskontes.this, menu_redirection.class);
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
        String post = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=663&Itemid=681&lang=el\">Τσιχριντζής Γεώργιος</a> " +
                "<br> 302, κεντρικό κτίριο " +
                "<br> +302104142322 ";

        String post2 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=664&Itemid=681&lang=el\">Βέργαδος Δημήτριος</a> " +
                "<br> 104, Γ. Λαμπράκη 126 " +
                "<br> +302104142479 ";

        String post3 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=667&Itemid=681&lang=el\">Δεσπότης Δημήτριος</a> " +
                "<br> 702, Γ. Λαμπράκη 126 " +
                "<br> +302104142411 ";

        String post4 = "<br> <a href=\"http://netlab.cs.unipi.gr/en/labmember/christos-douligeris\">Δουληγέρης Χρήστος</a> " +
                "<br> 302, κεντρικό κτίριο " +
                "<br> +302104142137 ";
        String post5 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=669&Itemid=681&lang=el\">Θεοδωρίδης Ιωάννης</a> " +
                "<br> 501, κεντρικό κτίριο " +
                "<br> +302104142449 ";
        String post6 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=671&Itemid=681&lang=el\">Σαπουνάκης Αριστείδης</a> " +
                "<br> 542, κεντρικό κτίριο " +
                "<br> +302104142262 ";

        String post7 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=677&Itemid=681&lang=el\">Αλέπης Ευθύμιος</a> " +
                "<br> 542, κεντρικό κτίριο ";
        String post8 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=673&Itemid=681&lang=el\">Αποστόλου Δημήτριος</a> " +
                "<br> 303, Γ. Λαμπράκη 126 " +
                "<br> +302104142476 ";
        String post9 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=679&Itemid=681&lang=el\">Κοτζανικολάου Παναγιώτης</a> " +
                "<br> 302, Γ. Λαμπράκη 126 " +
                "<br> +302104142123 ";

        String post10 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=676&Itemid=681&lang=el\">Πολέμη Δέσποινα</a> " +
                "<br> 502, κεντρικό κτίριο " +
                "<br> +302104142270 ";

        String post11 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=678&Itemid=681&lang=el\">Βουγιουκλίδου Άννα</a> " +
                "<br> Ζέας 80-82, 4ος όροφος " +
                "<br> +302104142176 ";

        String post12 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=680&Itemid=681&lang=el\">Πατσάκης Κωνσταντίνος</a> " +
                "<br> 540, κεντρικό κτίριο ";

        String post13 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=681&Itemid=681&lang=el\">Πικράκης Άγγελος </a> " +
                "<br> 505, κεντρικό κτίριο " +
                "<br> +302104142128 ";

        String post14 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=684&Itemid=681&lang=el\">Ψαράκης Μιχαήλ </a> " +
                "<br> 302, Γ. Λαμπράκη 126 " +
                "<br> +302104142425 ";
        String post15 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=685&Itemid=681&lang=el\">Αλεξανδρής Νικόλαος </a> ";

        String post16 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=665&Itemid=681&lang=el\">Ασημακόπουλος Νικήτας </a> " +
                "<br> 308, κεντρικό κτίριο " +
                "<br> +302104142145 ";

        String post17 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=687&Itemid=681&lang=el\">Γεωργιακώδης Φώτιος </a> " +
                "<br> 512, κεντρικό κτίριο " +
                "<br> +302104142276 ";

        String post18 = "<br> <a href=\"http://www.cs.unipi.gr/index.php?option=com_k2&view=item&layout=item&id=690&Itemid=681&lang=el\">Φούντας Ευάγγελος</a> ";


        String details2 = "<h2> <b>Βέργαδος Δημήτριος </b> </h2>\n <br><br>" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.\n" +
                "<br><br>" +
                "Ο Δημήτριος Δ. Βέργαδος είναι Καθηγητής, Αναπληρωτής Πρόεδρος του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς, και υπεύθυνος του Π.Μ.Σ. «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες». Τα ερευνητικά ενδιαφέροντά του εντοπίζονται στην περιοχή των δικτύων υπολογιστών και επικοινωνιακών συστημάτων, επεξεργασίας και ανάλυσης ψηφιακών εικόνων, έξυπνων τεχνολογιών, διαχείρισης περιεχομένου ψηφιακού πολιτισμού, διαδικτύου των πραγμάτων (IoT) και προηγμένων ψηφιακών τεχνολογιών, Ρυθμιστικών και Κανονιστικών Θεμάτων, cloud computing. Τα αποτελέσματα της ερευνητικής δραστηριότητάς του έχουν δημοσιευθεί σε έγκριτα διεθνή περιοδικά, συνέδρια και βιβλία. Έχει διατελέσει επιμελητής έκδοσης διεθνών περιοδικών (co-Editor, member of the Editorial Board), πρόεδρος προγράμματος συνεδρίων (Program Chair), μέλος σε πολλές τεχνικές επιτροπές προγράμματος (TPC) διεθνών συνεδρίων, " +
                "κριτής άρθρων σε διεθνή περιοδικά και συνέδρια. Έχει διατελέσει μέλος και αξιολογητής σε εθνικές και διεθνείς επιτροπές και οργανισμούς.";
        String details = "<h2> <b>Τσιχριντζής Γεώργιος </b> </h2>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";
        String details3 = "<h2> <b>Βίρβου Μαρία </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με την Καθηγήτρια.";

        String details4 = "<h2> <b>Δεσπότης Δημήτριος </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";
        String details5 = "<h2> <b>Δουληγέρης Χρήστος </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";
        String details6 = "<h2> <b>Θεοδωρίδης Ιωάννης </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";
        String details7 = "<h2> <b>Σαπουνάκης Αριστείδης </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";


        String details8 = "<h2> <b>Αλέπης Ευθύμιος\n </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details9 = "<h2> <b>Αποστόλου Δημήτριος </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details10 = "<h2> <b>Κοτζανικολάου Παναγιώτης </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details11 = "<h2> <b>Πολέμη Δέσποινα </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "<br><br>" +
                "Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγήτρια.";

        String details12 = "<h2> <b>ΣΒουγιουκλίδου Άννα </b> </h2><br><br>\n" +
                "\"+ \"\n" +
                "<br><br>" +
                "QUALIFICATIONS\"+ \"\n" +
                "-PhD 3e cycle (ParisIII-La Nouvelle Sorbonne)<br>\"+ \"\n" +
                "-MA (DEA ParisIII-La Nouvelle Sorbonne)<br>\"+ \"\n" +
                "-BA (University of Athens, department of French language and literature)<br>\"+ \"\n" +
                "-Higher Diploma in French of French Economics<br>\"+ \"\n" +
                "\n" +
                "FOREIGN LANGUAGES<br><br>\"+ \"\n" +
                "-French Diplôme d' Etudes Supérieures<br>\"+ \"\n" +
                "-Italien Certificato Livello Medio<br>\"+ \"\n" +
                "Certificato Livello Avanzato<br>\"+ \"\n" +
                "-English B1 level<br>\"+ \"\n" +
                "\n" +
                "<br><br>WRITTEN WORK\"+ \"\n" +
                "\n" +
                "<br><br>A) Books:\"+ \"\n" +
                "-Initiation au français de l Informatique, Propombos pub , Athens , 2011.<br>\"+ \"\n" +
                "-Initiation au français économique,Papazissis pub, Athens, 1988<br>\"+ \"\n" +
                "\n" +
                "<br><br>B) Articles:\"+ \"\n" +
                "-The contempory face of technology in France<br>\"+ \"\n" +
                "-French as a language of speciality: Obligation or choice?<br>\"+ \"\n" +
                "-The sociocultural dimension in Business correspondence teaching<br>\"+ \"\n" +
                "\n" +
                "<br><br>OTHER ACTIVITIES\"+ \"\n" +
                "\n" +
                "<br><br>Participation in Seminars\"+ \"\n" +
                "\n" +
                "<br><br>From October 1989 to June 2011:\"+ \"\n" +
                "-Oct.1989: \\\"Le français de Spécialités:Elaboration de pratiques\\\", Thessaloniki<br>\"+ \"\n" +
                "-May 1990: \\\"Le français de Spécialités Utilisation de Pratiques\\\", Athens<br>\"+ \"\n" +
                "-May 1992: \\\"Le français de spécialités:Les nouvelles Technologies et l' accession à l' autonomie\\\", Piraeus.<br>\"+ \"\n" +
                "-May 1992: \\\"Le français de Spécialités:L' Informatique et l' accession à l' autonomie\\\", Volos<br>\"+ \"\n" +
                "-June 1997 :\\\"Le Français de Spécialités :Montage de cours de Français sur objectif spécifiques\\\", Athens<br>\"+ \"\n" +
                "-April 2009 :\\\"Le FOS dans l' enseignement supérieur grec\\\", Athens<br>\"+ \"\n" +
                "\n" +
                "<br><br>TEACHING CAREER\"+ \"\n" +
                "\n" +
                "<br><br>Since 1983 she has been teaching French as a language of speciality , at the University of Piraeus , in following departments : Business Organisation and Administration ,Economics, Finances and Banking Administration, Industrial Administration and Technology.\"+ \"\n" +
                "\n" +
                "<br><br>Since 2008 she has been teaching French , French terminology in IT and Scientific writing , at the Department of IT.\"+ \"\n" +
                "\n" +
                "<br><br>ADMINISTRATIVE-ACADEMIC ACTIVITIES\"+ \"\n" +
                "-A representative of Foreign Language Teachers, in the senate of the University of Piraeus,(3 terms)<br>\"+ \"\n" +
                "-A member of the Board of Teachers at the University of Piraeus(2 terms)<br>\"+ \"\n" +
                "-A member of the scientific committee of the \\\"Horizons Francophones\\\" magazine(Association Panhellénique des Professeurs de Langue et de Littérature Française Diplômés Universitaires).<br>\"+ \"\n" +
                "\n" +
                "<br><br>FRENCH\"+ \"\n" +
                "\n" +
                "<br><br>TEACHING SCHEDULE\"+ \"\n" +
                "\n" +
                "<br><br>1st +2nd semesters: Intensive courses for adults provide the basic skills in vocabulary –grammar-syntax of the French language.\"+ \"\n" +
                "\n" +
                "<br><br>3rd+4th sem: Based on the Common European Framework, the development of required skills is attempted through texts and multimedia: a) reading comprehension ,b)listening skills, c) writing skills, d) speaking skills.\"+ \"\n" +
                "\n" +
                "<br><br>5th+6th sem : The teaching material comes exclusively from the Field of IT end multimedia Great emphasis is given to the comprehension and production of both written and oral specch by the students.\"+ \"\n" +
                "\n" +
                "<br><br>7th+8th sem: Application of all the acquired skills in business environment. Business correspondence, presentation and support of argumentation.\"+ \"\n" +
                "\n" +
                "<br><br>FRENCH IT TERMINOLOGY 6th SEMESTER\"+ \"\n" +
                "-Students come in contact with the basic terminology of IT through texts qnd mainly through interactive activities.<br>\"+ \"\n" +
                "\n" +
                "<br><br>WRITING OF ACADEMIC PAPER\"+ \"\n" +
                "4th sem : The students of the department of IT are taught how to write their dissertation.\"; }else{ document.getElementById('maincontent').innerHTML=\"\"+ \"Ώρες γραφείου: 13:00-18:00<br>\"+ \"\n" +
                "\n" +
                "<br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με την Καθηγήτρια.\"; }";

        String details13 = "<h2> <b>Πατσάκης Κωνσταντίνος </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "\n" +
                "<br><br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details14 = "<h2> <b>Πικράκης Άγγελος </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "\n" +
                "<br><br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details15 = "<h2> <b>Ψαράκης Μιχαήλ </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "\n" +
                "<br><br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details16 = "<h2> <b>Αλεξανδρής Νικόλαος </b> </h2><br><br>\n";

        String details17 = "<h2> <b>Ασημακόπουλος Νικήτας </b> </h2><br><br>\n" +
                "Ώρες γραφείου: 13:00-18:00\n" +
                "\n" +
                "<br><br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details18 = "<h2> <b>Γεωργιακώδης Φώτιος </b> </h2>\n" +
                "<br><br>Ώρες γραφείου: 13:00-18:00\n" +
                "\n" +
                "<br><br>Επιπρόσθετες ώρες γραφείου, ύστερα από συνεννόηση με τον Καθηγητή.";

        String details19 = "<h2> <b>Φούντας Ευάγγελος </b> </h2>\n" +
                "<br><br>Ο κ. Δρ. Ευάγγελος Φούντας είναι Καθηγητής και Πρόεδρος στο Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς , και διευθύνων του εργαστηρίου συνδυαστικής ανάλυσης. Tα διδακτικά και ερευνητικά του ενδιαφέροντα επικεντρώνονται στις Εφαρμογές Πληροφορικής, Συνδυαστικής Ανάλυσης και των Εφαρμοσμένων Μαθηματικών. Έχει δημοσιεύσει εργασίες σε διεθνή αναγνωρισμένα επιστημονικά περιοδικά με θεματικά πεδία Search Algorithms, Combinatorial Optimization with Industrial Applications, Algorithms and Applications for shortest Path Problems, Decision Support Systems.\n" +
                "\n" +
                "<br><br>Είναι συγγραφέας αρκετών βιβλίων όπως «Εφαρμοσμένες Πιθανότητες», «Συνδυαστική Ανάλυση», «Μαθηματικός Προγραμματισμός και Θεωρία Παιγνίων», «Διαφορικές Εξισώσεις», «Ανώτερα Μαθηματικά», «Ανάλυση και Εφαρμογές », «Μαθηματικά Οικονομικών και Διοικητικών Επιστημών» και «Μαθηματικά Αποφάσεων». Επίσης συνεργάζεται ως κριτής επιστημονικών άρθρων στο περιοδικό «Discrete Mathematical Sciences and Cryptography».\n" +
                "\n" +
                "<br><br>Έχει διδάξει και διδάσκει Εφαρμοσμένα Μαθηματικά Μοντέλα , Πιθανότητες, Συνδυαστική Ανάλυση και Μαθηματικά Αποφάσεων στα Τμήματα : Οργάνωση και Διοίκηση Επιχειρήσεων, Ναυτιλιακών Σπουδών, Στατιστικής και Ασφαλιστικής Επιστήμης, Χρηματοοικονομικής και Τραπεζικής Διοικητικής, Οικονομικής Επιστήμης, Πληροφορικής και Βιομηχανικής Διοίκησης και Τεχνολογίας του Πανεπιστημίου Πειραιώς. Επίσης διδάσκει στο Ελληνικό Ανοικτό Πανεπιστήμιο.\n" +
                "\n" +
                "<br><br>Επίσης διδάσκει στα Προγράμματα Μεταπτυχιακών Σπουδών: “Προηγμένα Συστήματα Πληροφορικής” και “Πληροφορική” του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς και “Διοίκηση Υγείας” του Τ.Ε. Ι. Πειραιώς.\n" +
                "\n" +
                "<br><br>Έχει αναλάβει την επίβλεψη πτυχιακών και διπλωματικών εργασιών φοιτητών του\n" +
                "\n" +
                "<br><br>Τμήματος Πληροφορικής καθώς και την επίβλεψη υποψηφίων διδακτόρων του Τμήματος Πληροφορικής.\n" +
                "\n" +
                "<br><br>Υπήρξε ομιλητής σε σειρά τακτικών σεμιναρίων του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς.\n" +
                "\n" +
                "<br><br>Επίσης διετέλεσε Πρόεδρος της Αναργυρείου και Κοργιαλενείου Σχολής Σπετσών.\n" +
                "\n" +
                "<br><br>Εξελέγη Πρόεδρος του Τμήματος Πληροφορ ικής του Πανεπιστημίου Πειραιώς κατά τις διετίες 2002-2004, 2004-2006, 2008-2010 και 2010-2012.\n" +
                "\n" +
                "<br><br>Είναι επιστημονικός υπεύθυνος στα έργα: “Ενίσχυση Σπουδών Πληροφορικής” που χρηματοδοτείται από το ΕΠΕΑΕΚ ΙΙ του ΥΠΕΠΘ από το Μάρτιο του 2004 μέχρι το 2009 και “Πρακτική ΄Ασκηση” των φοιτητών του τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς από τον Ιανουάριο του 2006.\n" +
                "\n" +
                "<br><br>Έχει διδάξει σε Τριτοβάθμια Εκπαιδευτικά Ιδρύματα, για πάνω από 27 έτη.";

        if(menu.equals("Διδάσκοντες")) {
            titles_enable_disable(true,new int[] {R.id.title_1,R.id.title_2,R.id.title_3,R.id.title_4,R.id.title_5,R.id.title_6});
            TextView txt1 = (TextView) findViewById(R.id.title_1);
            txt1.setText("Πρόεδρος Τμήματος");
            TextView txt2 = (TextView) findViewById(R.id.title_2);
            txt2.setText("Αναπληρωτής Πρόεδρος Τμήματος");
            TextView txt3 = (TextView) findViewById(R.id.title_3);
            txt3.setText("Καθηγητές");
            TextView txt4 = (TextView) findViewById(R.id.title_4);
            txt4.setText("Αναπληρωτές Καθηγητές");
            TextView txt5 = (TextView) findViewById(R.id.title_5);
            txt5.setText("Επίκουροι Καθηγητές");
            TextView txt6 = (TextView) findViewById(R.id.title_6);
            txt6.setText("Ομότιμοι Καθηγητές");


            createPosttxtView(1, R.id.melos_id_1, post, R.drawable.tsixr, R.id.did_img0, R.drawable.globe, R.drawable.email_2, details, R.id.did_img1, R.id.did_img2, "mailto:geoatsi@unipi.gr <geoatsi@unipi.gr>;", "http://www.unipi.gr/faculty/geoatsi");
            createPosttxtView(2, R.id.melos_id_2, post2, R.drawable.verg, R.id.did_img3, R.drawable.globe, R.drawable.email_2, details2, R.id.globe_2, R.id.email_2, "mailto:vergados@unipi.gr <vergados@unipi.gr>;", "http://netlab.cs.unipi.gr/en/labmember/dimitrios-d-vergados");
            createPosttxtView(2, R.id.melos_id_3, post2, R.drawable.verg, R.id.did_img4, R.drawable.globe, R.drawable.email_2, details2, R.id.globe_3, R.id.email_3, "mailto:vergados@unipi.gr <vergados@unipi.gr>;", "http://netlab.cs.unipi.gr/en/labmember/dimitrios-d-vergados");
            createPosttxtView(3, R.id.melos_id_4, post2, R.drawable.virvou, R.id.did_img5, R.drawable.globe, R.drawable.email_2, details3, R.id.globe_4, R.id.email_4, "mailto:mvirvou@unipi.gr <mvirvou@unipi.gr>;", "http://www.unipi.gr/faculty/mvirvou");
            createPosttxtView(4, R.id.melos_id_5, post3, R.drawable.despotis, R.id.did_img6, R.drawable.globe, R.drawable.email_2, details4, R.id.globe_5, R.id.email_5, "mailto:despotis@unipi.gr <despotis@unipi.gr>;", "http://https//sites.google.com/site/dimitrisdespotis/");
            createPosttxtView(5, R.id.melos_id_6, post4, R.drawable.douligeris, R.id.did_img7, R.drawable.globe, R.drawable.email_2, details5, R.id.globe_6, R.id.email_6, "mailto:cdoulig@unipi.gr <cdoulig@unipi.gr>;", "http://netlab.cs.unipi.gr/en/labmember/christos-douligeris");
            createPosttxtView(6, R.id.melos_id_7, post5, R.drawable.thewdoridis, R.id.did_img8, R.drawable.globe, R.drawable.email_2, details6, R.id.globe_7, R.id.email_7, "mailto:ytheod@unipi.gr <ytheod@unipi.gr>;", "http://www.unipi.gr/faculty/ytheod");
            createPosttxtView(7, R.id.melos_id_8, post6, R.drawable.unlocked_character, R.id.did_img9, R.drawable.globe, R.drawable.email_2, details7, R.id.globe_8, R.id.email_8, "mailto:arissap@unipi.gr <arissap@unipi.gr>;", "http://www.cs.unipi.gr/sapounakis/");
            createPosttxtView(8, R.id.melos_id_9, post7, R.drawable.alepis, R.id.did_img10, R.drawable.email_2, details8, R.id.email_9, "mailto:talepis@unipi.gr <talepis@unipi.gr>;");
            createPosttxtView(9, R.id.melos_id_10, post8, R.drawable.apostolou, R.id.did_img11, R.drawable.globe, R.drawable.email_2, details9, R.id.globe_10, R.id.email_10, "mailto:dapost@unipi.gr <dapost@unipi.gr>;", "http://dsslab.cs.unipi.gr/PWP3/PWP3-main.htm");
            createPosttxtView(10, R.id.melos_id_11, post9, R.drawable.kotza, R.id.did_img12, R.drawable.globe, R.drawable.email_2, details10, R.id.globe_11, R.id.email_11, "mailto:pkotzani@unipi.gr <pkotzani@unipi.gr>;", "http://www.cs.unipi.gr/pkotzani");
            createPosttxtView(11, R.id.melos_id_12, post10, R.drawable.polemidesp, R.id.did_img13, R.drawable.globe, R.drawable.email_2, details11, R.id.globe_12, R.id.email_12, "mailto:dpolemi@unipi.gr <dpolemi@unipi.gr>;", "http://athina.cs.unipi.gr/security-lab");
            createPosttxtView(12, R.id.melos_id_13, post11, R.drawable.bougioukanna, R.id.did_img14, R.drawable.globe, R.drawable.email_2, details12, R.id.globe_13, R.id.email_13, "mailto:avou@unipi.gr <avou@unipi.gr>;", "http://www.cs.unipi.gr/avou/");
            createPosttxtView(13, R.id.melos_id_14, post12, R.drawable.patsak, R.id.did_img15, R.drawable.globe, R.drawable.email_2, details13, R.id.globe_14, R.id.email_14, "mailto:kpatsak@unipi.gr <kpatsak@unipi.gr>;", "http://www.cs.unipi.gr/kpatsak");
            createPosttxtView(14, R.id.melos_id_15, post13, R.drawable.pikrak, R.id.did_img16, R.drawable.globe, R.drawable.email_2, details14, R.id.globe_15, R.id.email_15, "mailto:pikrakis@unipi.gr <pikrakis@unipi.gr>;", "https://sites.google.com/site/aggelospikrakis");
            createPosttxtView(15, R.id.melos_id_16, post14, R.drawable.psarak, R.id.did_img17, R.drawable.globe, R.drawable.email_2, details15, R.id.globe_16, R.id.email_16, "mailto:mpsarak@unipi.gr <mpsarak@unipi.gr>;", "http://www.cs.unipi.gr/psarakis");
            createPosttxtView(16, R.id.melos_id_17, post15, R.drawable.alexnik, R.id.did_img18, R.drawable.globe, R.drawable.email_2, details16, R.id.globe_17, R.id.email_17, "mailto:alexandr@unipi.gr <alexandr@unipi.gr>;", "http://www.cs.unipi.gr/alexandr");
            createPosttxtView(17, R.id.melos_id_18, post16, R.drawable.asimaknik, R.id.did_img19, R.drawable.email_2, details17, R.id.email_18, "mailto:assinik@unipi.gr <assinik@unipi.gr>;");
            createPosttxtView(18, R.id.melos_id_19, post17, R.drawable.georgefwt, R.id.did_img20, R.drawable.globe, R.drawable.email_2, details18, R.id.globe_19, R.id.email_19, "mailto:fotis@unipi.gr <fotis@unipi.gr>;", "http://www.cs.unipi.gr/georgiakodis/");
            createPosttxtView(19, R.id.melos_id_20, post18, R.drawable.unlocked_character, R.id.did_img21, R.drawable.globe, R.drawable.email_2, details19, R.id.globe_20, R.id.email_20, "mailto:efountas@unipi.gr <efountas@unipi.gr>;", "http://www.cs.unipi.gr/fountas");
            create_underline_info("60533", "Τρίτη, 11 Ιουλίου 2017 19:27", 7300);
        }else {
            String content = "<h1><b>Γραμματεία </b> </h1> <br>" +
                    "Το κτίριο της Γραμματείας του Τμήματος βρίσκεται στον Πειραιά επί της" +
                    " οδού Ζέας 80-82 (1ος όροφος). Η Γραμματεία του Τμήματος εξυπηρετεί τους προπτυχιακούς φοιτητές κάθε Δευτέρα-Τετάρτη-Παρασκευή, 11:30-14:00.";
            post2 = "<br> <a href=\"url\">Γκότση Βασιλική</a> "+
                    "<br> Ζέας 80-82 <br>  "+
                    "+30 2104142097 ";

            post3 = "<br> <a href=\"url\">Κατσιαδράμη Αριστέα</a> "+
                    "<br> Ζέας 80-82 <br>  "+
                    "+30 2104142067 ";

            post4 = "<br> <a href=\"url\">Ρούβαλη Θεοδώρα</a> "+
                    "<br> Ζέας 80-82 <br>  "+
                    "+30 2104142437 ";
            TextView txt = (TextView)findViewById(R.id.didaskontes);
            titles_enable_disable(false,new int[] {R.id.title_1,R.id.title_2,R.id.title_3,R.id.title_4,R.id.title_5,R.id.title_6});
            txt.setTextColor(Color.parseColor("#000000"));
            txt.setTextSize((float) 12);
            txt.setText(Html.fromHtml(content));
            ImageView img = (ImageView) findViewById(R.id.did_img3);
            ImageView email = (ImageView) findViewById(R.id.email_2);

            ImageView img2 = (ImageView) findViewById(R.id.did_img4);
            ImageView email2 = (ImageView) findViewById(R.id.email_3);

            ImageView img3 = (ImageView) findViewById(R.id.did_img5);
            ImageView email3 = (ImageView) findViewById(R.id.email_4);

            TextView txt2 = (TextView)findViewById(R.id.melos_id_2);
            TextView txt3 = (TextView)findViewById(R.id.melos_id_3);
            TextView txt4 = (TextView)findViewById(R.id.melos_id_4);

            createPosttxtViewGram(R.id.melos_id_2, post2, R.drawable.unlocked_character, R.id.did_img3,  R.drawable.email_2, details2, R.id.email_2, "mailto:bgotsi@unipi.gr <bgotsi@unipi.gr>;");
            createPosttxtViewGram(R.id.melos_id_3, post3, R.drawable.unlocked_character, R.id.did_img4,  R.drawable.email_2, details2, R.id.email_3, "mailto:aristeakats@unipi.gr <aristeakats@unipi.gr>;");
            createPosttxtViewGram(R.id.melos_id_4, post4, R.drawable.unlocked_character, R.id.did_img5,  R.drawable.email_2, details2, R.id.email_4, "mailto:rouvali@unipi.gr <rouvali@unipi.gr>;");
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

            RelativeLayout.LayoutParams imgparams=new RelativeLayout.LayoutParams
                    (250,200);

            RelativeLayout.LayoutParams email_img_params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            imgparams.topMargin = 400;
            imgparams.leftMargin = 10;
            params.leftMargin = 290;
            params.topMargin = 350;
            email_img_params.leftMargin =300;
            email_img_params.topMargin = 550;
            txt2.setLayoutParams(params);
            img.setLayoutParams(imgparams);
            email.setLayoutParams(email_img_params);


            RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

            RelativeLayout.LayoutParams imgparams2=new RelativeLayout.LayoutParams
                    (250,200);

            RelativeLayout.LayoutParams email_img_params2=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

            RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

            RelativeLayout.LayoutParams imgparams3=new RelativeLayout.LayoutParams
                    (250,200);

            RelativeLayout.LayoutParams email_img_params3=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

            imgparams2.topMargin = 600;
            imgparams2.leftMargin = 10;
            params2.leftMargin = 290;
            params2.topMargin = 550;
            email_img_params2.leftMargin =300;
            email_img_params2.topMargin = 750;
            txt3.setLayoutParams(params2);
            img2.setLayoutParams(imgparams2);
            email2.setLayoutParams(email_img_params2);


            imgparams3.topMargin = 800;
            imgparams3.leftMargin = 10;
            params3.leftMargin = 290;
            params3.topMargin = 750;
            email_img_params3.leftMargin =300;
            email_img_params3.topMargin = 950;
            txt4.setLayoutParams(params3);
            img3.setLayoutParams(imgparams3);
            email3.setLayoutParams(email_img_params3);

            RelativeLayout.LayoutParams params4=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_didaskontes);
            TextView txt5 = new TextView(this);
            params4.leftMargin = 70;
            params4.topMargin = 1050;
            txt5.setTextSize((float) 12);
            txt5.setTextColor(Color.parseColor("#0d0d0d"));
            txt5.setLayoutParams(params4);
            txt5.setMovementMethod(LinkMovementMethod.getInstance());
            txt5.setText(Html.fromHtml("Fax.: 210-4142107\n" +
                    "\n" +
                    "Ομαδική διεύθυνση ηλεκτρονικού ταχυδρομείου Γραμματείας:<a href = \"mailto:plh-secr@unipi.gr\">plh-secr@unipi.gr</a> "));
            rl.addView(txt5);
            create_underline_info("17850","Τρίτη, 11 Ιουλίου 2017 19:28",1200);
        }

    }

    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_didaskontes);
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
    void titles_enable_disable(boolean action,int[] titles){
        for(int i=0;i<titles.length;i++){
            TextView tl = (TextView) findViewById(titles[i]);
            if(action)
                tl.setVisibility(TextView.VISIBLE);
            else
                tl.setVisibility(TextView.INVISIBLE);
        }
    }
}