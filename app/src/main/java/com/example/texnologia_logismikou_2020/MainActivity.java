package com.example.texnologia_logismikou_2020;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    int lines_count,point;
    View.OnClickListener listener;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    String post,post1,post2,post3,post4,post5,post6,post7,post8,post9,post_syn,post_syn2,post_syn3,post_syn4,post_syn5,post_syn6,post_syn7,post_syn8,post_syn9,post_syn10,post_syn11,post_syn12;
    public void createPosttxtView(@IdRes final int id, final String content, final int value, @DrawableRes final int resId, @IdRes final int img_id, final String post){
                Intent intent = new Intent(MainActivity.this, ipiresies_tmimatos_panepistimiou_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);

    }

    public void createPosttxtViewSyn(@IdRes final int id, final String content, final int value, @DrawableRes final int resId, final String post){
                Intent intent = new Intent(MainActivity.this, sundedrio_details.class);
                intent.putExtra("id", value);
                intent.putExtra("title", content);
                intent.putExtra("img_id", resId);
                intent.putExtra("post", post);
                startActivity(intent);
    }

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent intent = new Intent(MainActivity.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                    Intent intent = new Intent(MainActivity.this, menu_redirection.class);
                    intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                    startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(MainActivity.this, menu_redirection.class);
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
                    Intent intent = new Intent(MainActivity.this, menu_redirection.class);
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

        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.mnmaproedrou, "ΜΗΝΥΜΑ ΠΡΟΕΔΡΟΥ\nΚαλωσορίσατε στο Τμήμα Πληροφορικής!"));
        slideModels.add(new SlideModel(R.drawable.xronia, "25 + 1 ΧΡΟΝΙΑ ΑΠΟ ΤΗΝ ΙΔΡΥΣΗ ΤΟΥ ΤΜΗΜΑΤΟΣ\nΤο 2016 το Τμήμα Πληροφορικής εόρτασε την επέτειο των 25 ετών από την Ίδρυσή του"));
        slideModels.add(new SlideModel(R.drawable.mainimg3, "ΠΜΣ ΠΛΗΡΟΦΟΡΙΚΗ \nΣπουδές Πληροφορικής για επαγγελματίες διαφόρων επιστημονικών ειδικοτήτων."));
        slideModels.add(new SlideModel(R.drawable.elearnslide, "E-LEARNING\nΣπουδές από απόσταση σε σύγχρονα αντικείμενα στο χώρο της Πληροφορικής"));
        slideModels.add(new SlideModel(R.drawable.pms, "ΠΜΣ «ΚΑΤΑΝΕΜΗΜΕΝΑ ΣΥΣΤΗΜΑΤΑ, ΑΣΦΑΛΕΙΑ ΚΑΙ ΑΝΑΔΥΟΜΕΝΕΣ ΤΕΧΝΟΛΟΓΙΕΣ ΠΛΗΡΟΦΟΡΙΑΣ»"));
        slideModels.add(new SlideModel(R.drawable.mainimg1, "ΠΜΣ «ΨΗΦΙΑΚΟΣ ΠΟΛΙΤΙΣΜΟΣ, ΕΞΥΠΝΕΣ ΠΟΛΕΙΣ, IOT ΚΑΙ ΠΡΟΗΓΜΕΝΕΣ ΨΗΦΙΑΚΕΣ ΤΕΧΝΟΛΟΓΙΕΣ»"));
        slideModels.add(new SlideModel(R.drawable.paidagwgikh, "ΤΟ ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ ΤΟΥ ΠΑΝΕΠΙΣΤΗΜΙΟΥ ΠΕΙΡΑΙΩΣ ΠΡΟΣΦΕΡΕΙ ΠΛΕΟΝ ΠΑΙΔΑΓΩΓΙΚΗ ΚΑΙ ΔΙΔΑΚΤΙΚΗ ΕΠΑΡΚΕΙΑ ΣΤΟΥΣ ΑΠΟΦΟΙΤΟΥΣ ΤΟΥ!"));
        imageSlider.setImageList(slideModels, true);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                if (i == 0 || i==1) {
                    Intent intent = new Intent(MainActivity.this, Message_proedrou.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elearning.cs.unipi.gr/"));
                    startActivity(browserIntent);
                }else if(i==4){
                    Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                    intent.putExtra("metaptyxiako_choice", "met3");
                    startActivity(intent);
                }else if(i==2){
                    Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                    intent.putExtra("metaptyxiako_choice", "met4");
                    startActivity(intent);
                }else if(i==5){
                    Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                    intent.putExtra("metaptyxiako_choice", "met2");
                    startActivity(intent);
                }else if(i==6){
                    String[] str_tmp = {"Ανακοίνωση δήλωσης συγγραμμάτων\n εαρινού εξαμήνου ακ. έτους 2019-2020","Ανακοίνωση για τροποποίηση ακαδημαϊκού\n ημερολογίου 2019-2020","Σίτιση των φοιτητών εν όψει των εορτών\n του Πάσχα","Εκπαιδευτική λειτουργία εξ αποστάσεως","Ανακοίνωση του Πανεπιστημίου Πειραιώς\n για την ηλεκτρονική εξ αποστάσεως\n εκπαίδευση","Μετακίνηση φοιτητών για παραλαβή δωρεάν\n γεύματος σε πακέτο από τη Φοιτητικό\n Εστιατόριο του Πανεπιστημίου Πειραιώς\n (αφορά και φοιτητές ERASMUS","Απαγόρευση εκπαιδευτικής λειτουργίας με\n φυσική παρουσία","Το τμήμα Πληροφορικής προχωρεί\n σε τηλε-διδασκαλία των μαθημάτων\n, συμμορφούμενο με τις οδηγίες του\n Υπουργείου",
                            "ΝΕΟ - Παράταση Δηλώσεων Μαθημάτων\n Εαρινού Εξαμήνου ακ. έτους 2019-2020","Παράταση Δηλώσεων Μαθημάτων Εαρινού\n Εξαμήνου ακ. έτους 2019-2020","Ανακοίνωση για τη δήλωση μαθημάτων\n παιδαγωγικής επάρκειας",
                            "Πρόγραμμα Διδασκαλίας Εαρινού Εξαμήνου\n Ακαδημαϊκού Έτους 2019-2020","Ορκωμοσία αποφοίτων του Προγράμματος\n Μεταπτυχιακών Σπουδών «Πληροφορική»\n του Τμήματος Πληροφορικής στις 27\n Φεβρουαρίου 2020",
                            "Ορκωμοσία αποφοίτων του Προγράμματος\n Μεταπτυχιακών Σπουδών «Προηγμένα\n Σύστηματα Πληροφορικής» του Τμήματος\n Πληροφορικής στις 27 Φεβρουαρίου 2020","Έναρξη μαθημάτων εαρινού εξ. 2019-2020","Αναβολή Εξετάσεων λόγω απεργίας ΜΜΜ"
                            ,"Ανακοίνωση για δωρεάν σίτιση φοιτητών /\n φοιτητριών (Ακαδημαϊκό Έτος 2019-2020)","Ανακοίνωση ορκωμοσίας των αποφοίτων\n των Τμημάτων της Σχολής-12 Μαρτίου 2020","ΙΚΥ - Ανακοίνωση προγράμματος\n υποτροφιών για εκπόνηση διδακτορικής\n διατριβής στο εξωτερικό. Πρόγραμμα\n ΙΚΥ-ΕΤΕ",
                            "Εσπερίδα Πληροφορικής και Τεχνητής\n Νοημοσύνης","Το Τμήμα Πληροφορικής προσφέρει πλέον\n παιδαγωγική επάρκεια!"};
                    String[] str_date_tmp = {"Σάββατο, 11 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Δευτέρα, 30 Μαρτίου 2020","Δευτέρα, 30 Μαρτίου 2020","Τρίτη, 24 Μαρτίου 2020","Κυριακή, 22 Μαρτίου 2020",
                            "16 Μαρτίου 2020","09 Μαρτίου 2020","25 Φεβρουαρίου 2020","21 Φεβρουαρίου 2020","18 Φεβρουαρίου 2020","18 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","17 Φεβρουαρίου 2020","12 Φεβρουαρίου 2020","27 Ιουνίου 2019"};
                    Intent intent = new Intent(MainActivity.this, anakoinwseis_details.class);
                    intent.putExtra("id", 20);
                    intent.putExtra("chapter", "MainPaidagwgika");
                    intent.putExtra("title", str_tmp);
                    intent.putExtra("date", str_date_tmp);
                    startActivity(intent);
                }
            }
        });
        ImageView main_img_1 = findViewById(R.id.main_img_1);
        main_img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met2");
                startActivity(intent);
            }
        });
        ImageView main_img_2 = findViewById(R.id.main_img_2);
        main_img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met3");
                startActivity(intent);
            }
        });
        ImageView main_img_3 = findViewById(R.id.main_img_3);
        main_img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met4");
                startActivity(intent);
            }
        });
        ImageView main_img_4 = findViewById(R.id.main_img_4);
        main_img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, proptyxiaka.class);
                startActivity(intent);
            }
        });
        ImageView main_img_5 = findViewById(R.id.main_img_5);
        main_img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elearning.cs.unipi.gr/"));
                startActivity(browserIntent);
            }
        });
        ImageView main_img_6 = findViewById(R.id.main_img_6);
        main_img_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , metaptyxiaka.class);
                intent.putExtra("metaptyxiako_choice", "met1");
                startActivity(intent);
            }
        });

        post = "Η πλατφόρμα GUNet eClass αποτελεί ένα ολοκληρωμένο Σύστημα Διαχείρισης Ηλεκτρονικών Μαθημάτων. Ακολουθεί τη φιλοσοφία του λογισμικού ανοικτού κώδικα και υποστηρίζει την υπηρεσία Ασύγχρονης Τηλεκπαίδευσης χωρίς περιορισμούς και δεσμεύσεις. " +
                "Η πρόσβαση στην υπηρεσία γίνεται με τη χρήση ενός απλού φυλλομετρητή (web browser) χωρίς την απαίτηση εξειδικευμένων τεχνικών γνώσεων." +
                "<br> <a href=\"http://gunet2.cs.unipi.gr/eclass\">GUNet eClass - Πλατφόρμα Ασύγχρονης Τηλεκπαίδευσης</a> ";
        post2 = "Υπηρεσία Πληροφόρησης Φοιτητών. Προγράμματα σπουδών, δηλώσεις, αιτήσεις, βαθμολογία. <br>" +
                "<a href=\"https://students.unipi.gr/\">STUDENTS - Υπηρεσία Πληροφόρησης Φοιτητών</a>";
       post3 = "Ο Student Support Server είναι ένας H/Y με λειτουργικό σύστημα GNU/Linux στο Πανεπιστήμιο Πειραιώς. Παρέχει υπηρεσίες ηλεκτρονικού ταχυδρομείου " +
                "(e-mail) και διαδικτυακού τόπου (web hosting) για τους φοιτητές του τμήματος Πληροφορικής.<br>" +
                "<a href=\"https://students.cs.unipi.gr/\">STUDENTS.CS - Students support server</a>";
       post4 = "Από την ιστοσελίδα της Βιβλιοθήκης του Πανεπιστημίου Πειραιά μπορείτε να ενημερωθείτε για τις υπηρεσίες και τη λειτουργία της βιβλιοθήκης. Η ιστοσελίδα επίσης λειτουργεί ως πύλη για τις δικτυακές υπηρεσίες που παρέχονται από τη Βιβλιοθήκη, προσφέροντας πρόσβαση τόσο στον κατάλογο βιβλίων της συλλογής όσο " +
                "και σε ένα σύνολο βάσεων δεδομένων για την ανάκτηση βιβλιογραφικής πληροφορίας και πλήρους κειμένου επιστημονικών άρθρων.<br>" +
                "<a href=\"http://www.lib.unipi.gr/\">Βιβλιοθήκη Πανεπιστημίου Πειραιά</a>";
        post5 = "Η Ηλεκτρονική Υπηρεσία Ολοκληρωμένης Διαχείρισης Συγγραμμάτων Εύδοξος πρόκειται για μία πρωτοποριακή " +
                "υπηρεσία για την άμεση και ολοκληρωμένη παροχή των Συγγραμμάτων των φοιτητών των Πανεπιστημίων και των ΤΕΙ της επικράτειας.<br>" +
                "<a href=\"http://eudoxus.gr/\">ΕΥΔΟΞΟΣ - Ηλεκτρονική Υπηρεσία Ολοκληρωμένης Διαχείρισης Συγγραμμάτων</a>";
        post6 = "Υπηρεσία Υποστήριξης Χρηστών. Ερωτήματα και αιτήματα υποστήριξης, γνωσιακή βάση, οδηγοί επίλυσης προβλημάτων.<br>"+
                "<a href=\"https://helpdesk.unipi.gr/\">Helpdesk - Υπηρεσία Υποστήριξης Χρηστών Πανεπιστημίου Πειραιά</a>";
        post7 = "Το Κέντρο Ερευνών Πανεπιστημίου Πειραιώς (Κ.Ε.Π.Π.) στα πλαίσια του θεσμικού πλαισίου που διέπει τη λειτουργία του, έχει θέσει ως όραμα το να καταστεί ένα σύγχρονο και διεθνούς φήμης ερευνητικό κέντρο το οποίο θα συμβάλλει στην ανάδειξη " +
                "και αναγνώριση του Πανεπιστημίου Πειραιώς ως ενός εκ των κορυφαίων της Ευρώπης."+
                "<a href=\"http://www.kep.unipi.gr/\">ΚΕΠΠ - Κέντρο Ερευνών Πανεπιστημίου Πειραιά</a>";
        post8 = "Η ιστοσελίδα του Πανεπιστημίου Πειραιά.\n" +
                "<br><a href=\"http://www.unipi.gr/\">Πανεπιστήμιο Πειραιά</a>";
        post9 = "Βασική επιδίωξη του Γραφείου Διασύνδεσης είναι η πολύπλευρη υποστήριξη των φοιτητών/αποφοίτων για την ομαλή ένταξή τους στην αγορά εργασίας και για την ανάπτυξη επιτυχημένης σταδιοδρομίας. Το Γραφείο Διασύνδεσης προωθεί την ανάπτυξη δυναμικών συνεργασιών και την εξυπηρέτηση τεσσάρων πόλων: των Φοιτητών & Αποφοίτων του Πανεπιστημίου, του Διδακτικού & Ερευνητικού Προσωπικού του Πανεπιστημίου, " +
                "των Επιχειρήσεων & Φορέων προώθησης απασχόλησης και της Δευτεροβάθμιας Εκπαίδευσης.<br><a href=\"http://www.career.unipi.gr/\">Γραφείο Διασύνδεσης Πανεπιστημίου Πειραιά</a>";

        post_syn = "\n" +
                "<a href=\"url\">http://iisa2016.unipi.gr </a><br><br>\n" +
                "\n" +
                "Information is widely available and accessible, but frequently leads to information overload and overexposure, while the effort for coding, storing, hiding, securing, transmitting and retrieving it may be excessive. Intelligenceis required to manage information and extract knowledge from it, inspired by biological and other paradigms.Multimedia Systems and Networks, with an increasing level of Intelligence, are being developed that incorporate these advances. As a result, new Technologies, Protocols and Applications are emerging.\n" +
                "\n" +
                "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology, medicine, chemistry, experimental psychology, social sciences, " +
                "linguistics, and engineering – having the goal of developing methodologies and tools for the solution of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance, education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.";

        post_syn2 = "\n" +
                "<a href=\"url\">http://fosscomm.cs.unipi.gr</a><br><br>\n" +
                "\n" +
                "Το FOSSCOMM (Free and Open Source Software Communities Meeting) είναι ένα ετήσιο συνέδριο που έχει ως κύριο θέμα το ελεύθερο και ανοικτό λογισμικό, το όποιο έχει φιλοξενηθεί σε πολλές πόλεις της Ελλάδας. Σκοπός του συνεδρίου είναι η προώθηση της χρήσης FOSS (Free and Open Source Software) και απευθύνεται σε προγραμματιστές, FOSS κοινότητες και λοιπούς ενδιαφερόμενους.\n" +
                "\n" +
                "Είμαστε στην ευχάριστη θέση να σας ανακοινώσουμε ότι το 9o FOSSCOMM θα πραγματοποιηθεί στο χώρο του Πανεπιστημίου Πειραιώς στις 16 και 17 Απριλίου, με την υποστήριξη της κοινότητας University of Piraeus, Software Libre Society. Η οργανωτική ομάδα της FOSSCOMM 2016 προσκαλεί" +
                " όλους όσους ενδιαφέρονται να παρακολουθήσουν το συνέδριο να δηλώσουν συμμετοχή στον σύνδεσμο “Δήλωση Παρακολούθησης” για την καλύτερη οργάνωση του συνεδρίου.";

        post_syn3 = "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction" +
                " and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology," +
                " medicine, chemistry, experimental psychology, social sciences, linguistics, and engineering – having the goal of developing methodologies and tools for the solution " +
                "of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance," +
                " education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.\n" +
                "\n <br>" +
                "<a href=\"url\">http://iisa2015.unipi.gr/</a>";
        post_syn4 = "July 07 – 09, 2014,  Chania Crete, Greece\n" +
                "\n" +
                "The International Conference on Information, Intelligence, Systems and Applications (IISA) series offers a forum for the constructive interaction and prolific exchange of ideas among scientists and practitioners from different research fields – such as computers, mathematics, physics, biology, medicine, chemistry, experimental psychology, social sciences, linguistics, and engineering – having the goal of developing methodologies and tools for the solution of complex problems in artificial intelligence, biology, neuroscience, security, monitoring, surveillance, healthcare, sustainability in energy sources, governance, education, commerce, automation, robotics, optimization, image, speech and natural languages, and their integration.\n" +
                "\n" +
                "<br><a href=\"url\">http://iisa2014.unipi.gr/</a>";
        post_syn5 = "11-13 Οκτωβρίου 2013\n" +
                "\n" +
                "Το 5th Conference on Informatics in Education – Η Πληροφορική στην εκπαίδευση (5th CIE 2013), διοργανώνεται από το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς και το Τμήμα Πληροφορικής του Ιονίου Πανεπιστημίου σε συνεργασία με την ΕΠΥ και εστιάζεται στην Πληροφορική, αλλά και στις ΤΠΕ στην εκπαίδευση. Καλύπτει τόσο τις βαθμίδες της τυπικής εκπαίδευσης –Δευτεροβάθμια (ΓΕΛ, ΕΠΑΛ, Γυμνάσια), Πρωτοβάθμια, " +
                "Τριτοβάθμια- όσο και την μη τυπική εκπαίδευση.<br><a href=\"url\">http://di.ionio.gr/cie/index.php/cie-2013</a>";

        post_syn6 = "\n" +
                "24-27 Ιουλίου 2012\n" +
                "\n" +
                "The purpose of WINSYS 2012, the International Conference on Wireless Information Networks and Systems, is to bring together researchers, engineers and practitioners interested on information systems and applications in the context of wireless networks and mobile technologies.\n" +
                "\n" +
                "<br><a href=\"url\">http://www.winsys.icete.org/?y=2012</a>";

        post_syn7 = "7-9 Νοεμβρίου 2012 24th IEEE International Conference on Tools with Artificial Intelligence <br><a href=\"\">http://ictai12.unipi.gr/</a> ";

        post_syn8 = "5-7 Οκτωβρίου 2012 16th Panhellenic Conference on Informatics with international participation (PCI 2012)<br> <a href=\"url\">http://pci2012.unipi.gr/</a>";
        post_syn9 = "\n" +
                "5-7 Οκτωβριου 2012\n" +
                "\n" +
                "Το Συνέδριο διοργανώνεται από το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς και το Τμήμα Πληροφορικής του Ιονίου Πανεπιστημίου σε συνεργασία με την ΕΠΥ και εστιάζεται στην Πληροφορική, αλλά και στις ΤΠΕ στην εκπαίδευση. Θα λάβει χώρα και φέτος στους χώρους του Πανεπιστημίου Πειραιώς, 5-7 Οκτωβρίου 2012, παράλληλα με το PCI2012." +
                " Για περισσότερες λεπτομέρειες και το πρόγραμμα επισκεφθείτε την ιστοσελίδα του Συνεδρίου (<a href=\"http://195.130.124.90/cie//\">http://di.ionio.gr/cie/</a>)<br><br>" +
                "<a href=\"url\">http://www.cs.unipi.gr/index.php?lang=el</a>";

        post_syn10 = "\n" +
                "23-26 August 2012, Rhodes, Greece  10th Joint Conference on Knowledge-Based Software Engineering  <br> <a href=\"url\">http://jckbse12.unipi.gr/</a>";

        post_syn11 = "\n" +
                "24-27 Ιουλίου 2012\n" +
                "\n" +
                "The purpose of SIGMAP 2012, the International Conference on Signal Processing and Multimedia Applications, is to bring together researchers, engineers and practitioners interested on information systems and applications in the context of Signal Processing, including theory and practice in the field of telecommunications, image, video, audio, biometrics, etc., and Multimedia Applications related to representation, storage, authentication and communication of multimedia information.\n" +
                "\n" +
                "<a href=\"url\">http://www.sigmap.icete.org/?y=2012</a>";

        post_syn12 = "\n" +
                "18-20 Ιουλίου 2012\n" +
                "\n" +
                "Διεθνές συνέδριο 8th International Conference on Intelligent Information Hiding and Multimedia Signal Processing. <br> <a href=\"url\">http://iihmsp12.unipi.gr/</a>";

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.ergast_slide_txt_1 || v.getId() == R.id.ergast_slide_txt_2 || v.getId() == R.id.ergast_slide_txt_3 || v.getId() == R.id.ergast_slide_txt_4 || v.getId() == R.id.ergast_slide_txt_5 || v.getId() == R.id.ergast_slide_txt_6 || v.getId() == R.id.ergast_slide_txt_7 || v.getId() == R.id.ergast_slide_txt_8 || v.getId() == R.id.ergast_slide_txt_9 || v.getId() == R.id.ergast_slide_img_1 || v.getId() == R.id.ergast_slide_img_2 || v.getId() == R.id.ergast_slide_img_3 || v.getId() == R.id.ergast_slide_img_4 || v.getId() == R.id.ergast_slide_img_5 || v.getId() == R.id.ergast_slide_img_6 || v.getId() == R.id.ergast_slide_img_7 || v.getId() == R.id.ergast_slide_img_8 || v.getId() == R.id.ergast_slide_img_9) {
                    Intent intent = new Intent(MainActivity.this, ereunitika_ergastiria.class);
                    startActivity(intent);
                }
                if(v.getId() == R.id.yp_slide_img_1){
                    createPosttxtView(R.id.ipiresia_id_1, "GUNET", 1, R.drawable.upiresia1,R.id.txt_img1,post);
                }else if(v.getId() == R.id.yp_slide_img_2){
                    createPosttxtView(R.id.ipiresia_id_2, "STUDENTS", 2, R.drawable.upiresia2,R.id.txt_img2, post2);
                }
                else if(v.getId() == R.id.yp_slide_img_3){
                    createPosttxtView(R.id.ipiresia_id_3, "STUDENTS.CS", 3, R.drawable.upiresia3,R.id.txt_img3, post3);
                }
                else if(v.getId() == R.id.yp_slide_img_4){
                    createPosttxtView(R.id.ipiresia_id_4, "Βιβλιοθήκη", 4, R.drawable.upiresia4,R.id.txt_img4, post4);
                }
                else if(v.getId() == R.id.yp_slide_img_5){
                    createPosttxtView(R.id.ipiresia_id_5, "ΕΥΔΟΞΟΣ ", 5, R.drawable.upiresia5,R.id.txt_img5, post5);
                }
                else if(v.getId() == R.id.yp_slide_img_6){
                    createPosttxtView(R.id.ipiresia_id_6, "Helpdesk", 6, R.drawable.upiresia6,R.id.txt_img6, post6);
                }
                else if(v.getId() == R.id.yp_slide_img_7){
                    createPosttxtView(R.id.ipiresia_id_7, "ΚΕΠΠ", 7, R.drawable.upiresia7,R.id.txt_img7, post7);
                }
                else if(v.getId() == R.id.yp_slide_img_8){
                    createPosttxtView(R.id.ipiresia_id_8, "UNIPI", 8, R.drawable.upiresia8,R.id.txt_img8, post8);
                }else if(v.getId() == R.id.yp_slide_img_9){
                    createPosttxtView(R.id.ipiresia_id_9, "Γρ. Διασύνδεσης", 9, R.drawable.upiresia9,R.id.txt_img9, post9);
                }
                if(v.getId() == R.id.drast_slide_img_1){
                    createPosttxtViewSyn(R.id.sunedrio_id_1, "<u> · 7th International Conference on Information, Intelligence,Systems and Applications (IISA 2016) </u>", 1, R.drawable.sunedrio1, post_syn);
                }else if(v.getId() == R.id.drast_slide_img_2){
                    createPosttxtViewSyn(R.id.sunedrio_id_2, "<u> · 9o Συνέδριο Free and Open Source Software Communities Meeting (FOSSCOMM 2016) στο Πανεπιστήμιο Πειραιώς </u>", 2, R.drawable.sunedrio2, post_syn2);
                }
                else if(v.getId() == R.id.drast_slide_img_3){
                    createPosttxtViewSyn(R.id.sunedrio_id_3, "<u> · 6th International Conference on Information, Intelligence, Systems and Applications (IISA 2015), July 6–8, 2015, Ionian University, Corfu, Greece </u>", 3, R.drawable.sunedrio3, post_syn3);
                }
                else if(v.getId() == R.id.drast_slide_img_4){
                    createPosttxtViewSyn(R.id.sunedrio_id_4, "<u> · 5th International Conference on Information, Intelligence, Systems and Applications (IISA 2014) </u>",4 , R.drawable.sunedrio4, post_syn4);
                }
                else if(v.getId() == R.id.drast_slide_img_5){
                    createPosttxtViewSyn(R.id.sunedrio_id_5, "<u> · 5th Conference on Informatics in Education (CIE 2013) </u>", 5, R.drawable.sunedrio5, post_syn5);
                }
                else if(v.getId() == R.id.drast_slide_img_6){
                    createPosttxtViewSyn(R.id.sunedrio_id_6, "<u> ·9th International Conference on Wireless Information Networks and Systems (WINSYS 2012) </u>", 6, R.drawable.sunedrio6, post_syn6);
                }
                else if(v.getId() == R.id.drast_slide_img_7){
                    createPosttxtViewSyn(R.id.sunedrio_id_7, "<u> · 24th IEEE International Conference on Tools with Artificial Intelligence (ICTAI 2012) </u>", 7, R.drawable.sunedrio7, post_syn7);
                }
                else if(v.getId() == R.id.drast_slide_img_8){
                    createPosttxtViewSyn(R.id.sunedrio_id_8, "<u> · 16th Panhellenic Conference on Informatics with international participation (PCI 2012) </u>", 8, R.drawable.sunedrio8, post_syn8);
                }
                else if(v.getId() == R.id.drast_slide_img_9){
                    createPosttxtViewSyn(R.id.sunedrio_id_9, "<u> · 4th Conference on Informatics in Education (CIE 2012) </u>", 9, R.drawable.sunedrio9, post9);
                }
                else if(v.getId() == R.id.drast_slide_img_10){
                    createPosttxtViewSyn(R.id.sunedrio_id_10, "<u> · 10th Joint Conference on Knowledge-Based Software Engineering (JCKBSE 2012) </u>", 10, R.drawable.sunedrio10, post_syn10);
                }
                else if(v.getId() == R.id.drast_slide_img_11){
                    createPosttxtViewSyn(R.id.sunedrio_id_11, "<u> · 9th International International Conference on Signal Processing and Multimedia Applications (SIGMAP 2012) </u>", 11, R.drawable.sunedrio11, post_syn11);
                }
                else if(v.getId() == R.id.drast_slide_img_12){
                    createPosttxtViewSyn(R.id.sunedrio_id_12, "<u> · 8th International Conference on Intelligent Information Hiding and Multimedia Signal Processing (IIHMSP 2012) </u>", 12, R.drawable.sunedrio12, post_syn12);
                }

            }
        };


        initialize_animations(-300.0f, 3600.0f, 300.0f, new ImageView[]{findViewById(R.id.yp_slide_img_1), findViewById(R.id.yp_slide_img_2), findViewById(R.id.yp_slide_img_3), findViewById(R.id.yp_slide_img_4), findViewById(R.id.yp_slide_img_5), findViewById(R.id.yp_slide_img_6), findViewById(R.id.yp_slide_img_7), findViewById(R.id.yp_slide_img_8), findViewById(R.id.yp_slide_img_9)}, 10000);
        initialize_animations(-300.0f, 4500.0f, 300.0f, new ImageView[]{findViewById(R.id.drast_slide_img_1), findViewById(R.id.drast_slide_img_2), findViewById(R.id.drast_slide_img_3), findViewById(R.id.drast_slide_img_4), findViewById(R.id.drast_slide_img_5), findViewById(R.id.drast_slide_img_6), findViewById(R.id.drast_slide_img_7), findViewById(R.id.drast_slide_img_8), findViewById(R.id.drast_slide_img_9), findViewById(R.id.drast_slide_img_10), findViewById(R.id.drast_slide_img_11), findViewById(R.id.drast_slide_img_12)}, 10000);
        initialize_animations(-500.0f, (9 * 500) + 1500, 500.0f, new ImageView[]{findViewById(R.id.ergast_slide_img_1), findViewById(R.id.ergast_slide_img_2), findViewById(R.id.ergast_slide_img_3), findViewById(R.id.ergast_slide_img_4), findViewById(R.id.ergast_slide_img_5), findViewById(R.id.ergast_slide_img_6), findViewById(R.id.ergast_slide_img_7), findViewById(R.id.ergast_slide_img_8), findViewById(R.id.ergast_slide_img_9)}, 10000);
        float start = -500;
        float end = (9 * 500) + 1500;
        TextView[] txt_list = new TextView[]{findViewById(R.id.ergast_slide_txt_1), findViewById(R.id.ergast_slide_txt_2), findViewById(R.id.ergast_slide_txt_3), findViewById(R.id.ergast_slide_txt_4), findViewById(R.id.ergast_slide_txt_5), findViewById(R.id.ergast_slide_txt_6), findViewById(R.id.ergast_slide_txt_7), findViewById(R.id.ergast_slide_txt_8), findViewById(R.id.ergast_slide_txt_9)};
        for (int j = 0; j < txt_list.length; j++) {
            txt_list[j].setTag(j);
            txt_list[j].setOnClickListener(listener);
            create_animations_text(start, end, txt_list[j], 10000);
            start -= 500.0f;
            end -= 500.0f;
        }
        findViewById(R.id.ergast_slide_img_1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ereunitika_ergastiria.class);
                startActivity(intent);

            }
        });
        create_last_news();
        create_fast_menu();
    }

    public void create_last_news(){
        final String[] str = {"Ανακοίνωση δήλωσης συγγραμμάτων\n εαρινού εξαμήνου ακ. έτους 2019-2020","Ανακοίνωση για τροποποίηση ακαδημαϊκού\n ημερολογίου 2019-2020","Σίτιση των φοιτητών εν όψει των εορτών\n του Πάσχα","Εκπαιδευτική λειτουργία εξ αποστάσεως","Ανακοίνωση του Πανεπιστημίου Πειραιώς\n για την ηλεκτρονική εξ αποστάσεως\n εκπαίδευση","Μετακίνηση φοιτητών για παραλαβή δωρεάν\n γεύματος σε πακέτο από τη Φοιτητικό\n Εστιατόριο του Πανεπιστημίου Πειραιώς\n (αφορά και φοιτητές ERASMUS","Απαγόρευση εκπαιδευτικής λειτουργίας με\n φυσική παρουσία","Το τμήμα Πληροφορικής προχωρεί\n σε τηλε-διδασκαλία των μαθημάτων\n, συμμορφούμενο με τις οδηγίες του\n Υπουργείου"};
        final String[] str_date = {"Σάββατο, 11 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Παρασκευή, 10 Απριλίου 2020","Δευτέρα, 30 Μαρτίου 2020","Δευτέρα, 30 Μαρτίου 2020","Τρίτη, 24 Μαρτίου 2020","Κυριακή, 22 Μαρτίου 2020"};
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_main);
        final TextView[] news_title = new TextView[8];
        final ImageView[] news_underline = new ImageView[8];
        final TextView[] news_date = new TextView[8];
        int tl=3100;
        int dt=3100;
        int img=3100;
        for (point=0; point<str.length; point++)
        {
            dt = tl;
            img = tl;
            news_title[point] = new TextView(this);
            news_date[point] = new TextView(this);
            news_underline[point] = new ImageView(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);


            //FOR LAST NEWS TITLE
            params.leftMargin = 50;
            news_title[point].setText(str[point]);
            news_title[point].setTextSize((float) 16);
            news_title[point].setPadding(20, 50, 20, 50);
            if(point>0){
                if(textview_lines(news_title[point-1])==2){
                    tl+=205;
                }else if(textview_lines(news_title[point-1])==1){
                    tl += 160;
                }
                else if(textview_lines(news_title[point-1])==3){
                    tl += 280;
                }else if(textview_lines(news_title[point-1])==4){
                    tl += 320;
                }
            }else{
                tl += 200;
            }
            params.topMargin  = tl;
            news_title[point].setLayoutParams(params);
            news_title[point].setTextColor(Color.parseColor("#003366"));
            news_title[point].setPaintFlags(news_title[point].getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            rl.addView(news_title[point]);


            final int j = point;  // use new variable here
            news_title[point].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, anakoinwseis_details.class);
                    intent.putExtra("id", j);
                    intent.putExtra("chapter", "Τελευταία νέα και ανακοινώσεις");
                    intent.putExtra("title", str);
                    intent.putExtra("date", str_date);
                    startActivity(intent);
                }
            });
            //FOR LAST NEWS DATE STRING
            if(textview_lines(news_title[point])==2){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4){
                        dt+=440;
                    }else{
                        dt+=320;
                    }
                }else{
                    dt+=320;
                }
            }else if(textview_lines(news_title[point])==1){
                dt+=260;
            }else if(textview_lines(news_title[point])==3){
                dt+=340;
            }else if(textview_lines(news_title[point])==4){
                if(point>0){
                    if(textview_lines(news_title[point-1])==2){
                        dt+=440;
                    }else{
                        dt+=510;
                    }
                }else{
                    dt+=510;
                }
            }
            RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params2.topMargin  = dt;
            params2.leftMargin = 50;
            news_date[point].setText(str_date[point]);
            news_date[point].setTextSize((float) 11);
            news_date[point].setPadding(20, 50, 20, 50);
            news_date[point].setLayoutParams(params2);
            news_date[point].getLineCount();
            rl.addView(news_date[point]);

            //FOR LAST NEWS image
            if(textview_lines(news_title[point])==2){
                if(point>0){
                    if(textview_lines(news_title[point-1])==4){
                        img+=525;
                    }else{
                        img+=395;
                    }
                }else{
                    img+=395;
                }
            }else if(textview_lines(news_title[point])==1){
                img+=345;
            }else if(textview_lines(news_title[point])==3){
                img+=425;
            }else if(textview_lines(news_title[point])==4){
                if(point>0){
                    if(textview_lines(news_title[point-1])==2){
                        img+=540;
                    }else{
                        img+=600;
                    }
                }else{
                    img+=600;
                }
            }
            RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params3.topMargin  = img;
            params3.leftMargin = 50;
            news_underline[point].setImageResource(R.drawable.underline);
            news_underline[point].setLayoutParams(params3);
            rl.addView(news_underline[point]);
        }
    }

    public int textview_lines(TextView tv){
        int count = tv.getText().toString().split("\\r?\\n").length;
        return count;
    }

    public void create_fast_menu(){
        final String[] str = {"Οδηγός σπουδών","Πρόγραμμα διδασκαλίας","Παιδαγωγική Επάρκεια","Υποστήριξη διδασκαλίας","Πληροφόρηση φοιτητών","Διαχείριση συγγραμάτων","Τεχνική υποστήριξη","Μητρώα Τμήματος","Βιβλιοθήκη","Σχολή ΤΠΕ","Πανεπιστήμιο Πειραιά"};
        final String[] links = {"http://www.cs.unipi.gr/files/pps2019_2020.pdf","http://www.cs.unipi.gr/files/pli20192020_earino.pdf","http://www.cs.unipi.gr/files/eparkia.pdf","http://gunet2.cs.unipi.gr/eclass","http://students.unipi.gr/","http://eudoxus.gr/","https://helpdesk.unipi.gr/","http://www.cs.unipi.gr/files/mitroa_pli_2021.pdf","http://www.lib.unipi.gr/","http://www.unipi.gr/unipi/el/academics/sxoli-plh-tex.html","http://www.unipi.gr/"};
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_main);
        final TextView[] fast_menu_options = new TextView[11];
        int tl=5370;
        for (int i=0; i<str.length; i++)
        {
            fast_menu_options[i] = new TextView(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            //FOR LAST NEWS TITLE
            params.leftMargin = 140;
            fast_menu_options[i].setText(Html.fromHtml("<a href='" + links[i] + "'>▣ " + str[i] + "</a>"));
            fast_menu_options[i].setTextSize((float) 14);
            fast_menu_options[i].setPadding(20, 50, 20, 50);
            params.topMargin  = tl;
            fast_menu_options[i].setLayoutParams(params);
            fast_menu_options[i].setTextColor(Color.parseColor("#003366"));
            fast_menu_options[i].setPaintFlags(fast_menu_options[i].getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            rl.addView(fast_menu_options[i]);
            fast_menu_options[i].setMovementMethod(LinkMovementMethod.getInstance());
            tl += 85;

        }
    }

    public void initialize_animations(float startX,float endX,float step,ImageView[] images,int duration){
        for(int i=0;i<images.length;i++){
            images[i].setTag(i);
            images[i].setOnClickListener(listener);
            create_animations(startX , endX , images[i],duration);
            startX-=step;
            endX-=step;
        }
    }
    public void create_animations_text(float from,float to,TextView txt , int duration){

        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(txt, "translationX", from, to);
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }
    public void create_animations(float from,float to,ImageView img , int duration){

        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(img, "translationX", from, to);
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        return false;
    }
}