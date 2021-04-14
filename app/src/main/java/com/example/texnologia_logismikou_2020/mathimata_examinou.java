package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
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

public class mathimata_examinou extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private Dialog myDialog;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        myDialog = new Dialog(this);

        String mathima_choice = bundle.getString("mathima_choice");

        if(mathima_choice.equals("ex1")){
            create_math_1o();
            create_underline_info(R.id.layout_ex1,"106507","",10750);
        }else if(mathima_choice.equals("ex2")){
            create_math_2o();
            create_underline_info(R.id.layout_ex2,"106507","",11900);
        }else if(mathima_choice.equals("ex3")){
            create_math_3o();
            create_underline_info(R.id.layout_ex3,"106507","",14290);
        }else if(mathima_choice.equals("ex4")){
            create_math_4o();
            create_underline_info(R.id.layout_ex4,"106507","",14050);
        }else if(mathima_choice.equals("ex5")){
            create_math_5o();
            create_underline_info(R.id.layout_ex5,"106507","",19200);
        }else if(mathima_choice.equals("ex6")){
            create_math_6o();
            create_underline_info(R.id.layout_ex6,"106507","",23290);
        }else if(mathima_choice.equals("ex7")){
            create_math_7o();
            create_underline_info(R.id.layout_ex7,"106507","",19290);
        }else if(mathima_choice.equals("ex8")){
            create_math_8o();
            create_underline_info(R.id.layout_ex8,"106507","",16720);
        }

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
                Intent intent = new Intent(mathimata_examinou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(mathimata_examinou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(mathimata_examinou.this, menu_redirection.class);
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
                Intent intent = new Intent(mathimata_examinou.this, menu_redirection.class);
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
    }

    void create_math_1o(){
        setContentView(R.layout.activity_mathima1o);

        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        String text = "<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));

        TextView underline_sapoynakis;
        underline_sapoynakis = (TextView) findViewById(R.id.sapoynakis);
        text = "<u>Σαπουνάκης Αριστείδης</u>";
        underline_sapoynakis.setText(Html.fromHtml(text));
        underline_sapoynakis = (TextView) findViewById(R.id.sapoynakis1);
        text = "<u>Σαπουνάκης Αριστείδης</u>";
        underline_sapoynakis.setText(Html.fromHtml(text));

        TextView underline_apostoloy;
        underline_apostoloy = (TextView) findViewById(R.id.apostoloy);
        text = "<u>Αποστόλου Δημήτριος</u>";
        underline_apostoloy.setText(Html.fromHtml(text));

        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis);
        text = "<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_tsikoyras;
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras);
        text = "<u>Τσικούρας Παναγιώτης-Γεώργιος</u>";
        underline_tsikoyras.setText(Html.fromHtml(text));

        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));


        TextView mathimatika_ypologistwn = (TextView) findViewById(R.id.perigrafi_mathimatika_ypologistwn);
        text= "<br><b>Εισαγωγή στη θεωρία συνόλων:</b> Σύνολα. Απεικονίσεις. Πράξεις. Σχέσεις. Ισοδύναμα σύνολα." +
                "<br><b>Βασικές Αρχές:</b> Μαθηματική επαγωγή. Αρχή εγκλεισμού – αποκλεισμού. Αρχή του περιστερεώνα. Αρχή της διαγωνιοποίησης." +
                "<br><b>Μαθηματική Λογική:</b> Γλώσσα προτασιακού λογισμού. Τιμές αληθείας. Εκτίμηση. Λογικό Συμπέρασμα. Αξιώματα και πληρότητα του προτασιακού λογισμού. Δένδρα αληθείας. Αρχή της απόφασης. Κατηγορηματικός Λογισμός. Ποσοδείκτες.Άλγεβρα Boole: Δικτυωτά. Πράξεις. Δίπολα." +
                "<br><b>Εισαγωγή στη συνδυαστική ανάλυση:</b> Διατάξεις. Μεταθέσεις. Συνδυασμοί." +
                "<br><b>Διαφορές – Αθροίσματα:</b> Ο τελεστής της διαφοράς. Παραγοντικά πολυώνυμα. Διώνυμο του Νεύτωνα." +
                "<br><b>Στοιχεία Θεωρίας Αριθμών:</b> Διαιρετότητα. Μέγιστος κοινός διαιρέτης. Αλγόριθμος του Ευκλείδη. Πρώτοι αριθμοί. Ισοτιμίες. Θεώρημα Εuler-Fermat.<br> ";
        mathimatika_ypologistwn.setText(Html.fromHtml(text));
    }
    void create_math_2o(){
        setContentView(R.layout.activity_mathima2o);
        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        String text = "<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));

        TextView underline_sapoynakis;
        underline_sapoynakis = (TextView) findViewById(R.id.sapoynakis);
        text = "<u>Σαπουνάκης Αριστείδης</u>";
        underline_sapoynakis.setText(Html.fromHtml(text));
        underline_sapoynakis = (TextView) findViewById(R.id.sapoynakis1);
        text = "<u>Σαπουνάκης Αριστείδης</u>";
        underline_sapoynakis.setText(Html.fromHtml(text));

        TextView underline_kwstantopoylos;
        underline_kwstantopoylos = (TextView) findViewById(R.id.kwstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwstantopoylos.setText(Html.fromHtml(text));


        TextView underline_despoths;
        underline_despoths = (TextView) findViewById(R.id.despotis);
        text = "<u>Δεσπότης Δημήτριος</u>";
        underline_despoths.setText(Html.fromHtml(text));

        TextView underline_tsikoyras;
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras);
        text = "<u>Τσικούρας Παναγιώτης-Γεώργιος</u>";
        underline_tsikoyras.setText(Html.fromHtml(text));
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras1);
        underline_tsikoyras.setText(Html.fromHtml(text));

        TextView underline_alepis;
        underline_alepis = (TextView) findViewById(R.id.alephs);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alepis.setText(Html.fromHtml(text));


        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));


        TextView diakrita = (TextView) findViewById(R.id.diakrita_perigrafi);
        text= "<br><b>Εισαγωγή στην θεωρία γραφημάτων:</b> Γραφήματα δεσμών. Γραφήματα τόξων. Εφαρμογές των γραφημάτων στους αλγόριθμους." +
                "<br><b>Δένδρα:</b> Δυαδικά δένδρα. Διατεταγμένα δένδρα. Δένδρα αποφάσεων." +
                "<br><b>Συνδυαστικοί αριθμοί:</b> Αριθμοί Fibonacci, Catalan, Motzkin, Narayana, Stirling, Bell." +
                "<br><b>Γεννήτριες συναρτήσεις: </b> Συνήθεις και εκθετικές γεννήτριες συναρτήσεις ακολουθιών. Γεννήτριες συναρτήσεις συνόλων. Το πρόβλημα της αντιστροφής (θεώρημα Lagrange)." +
                "<br><b>Αναγωγικές εξισώσεις:</b> Επίλυση γραμμικών αναγωγικών εξισώσεων με τη χρήση του χαρακτηριστικού πολυωνύμου. Επίλυση αναγωγικών εξισώσεων με γεννήτριες συναρτήσεις." +
                "<br><b>Ασυμπτωτικές εκτιμήσεις:</b> Ασυμπτωτικοί συμβολισμοί. Το θεώρημα κυρίαρχου όρου. Ο τύπος του Stirling. Προσεγγίσεις αθροισμάτων. Ανάλυση ιδιομορφιών."+
                "<br><b>Γλώσσες και Αυτόματα:</b>Τυπικές γλώσσες, D – αυτόματα. Αναγνωρίσιμες γλώσσες. <br>";
        diakrita.setText(Html.fromHtml(text));

        TextView domes = (TextView) findViewById(R.id.domes);
        text= "<br>Με την επιτυχή ολοκλήρωση αυτής της ενότητας οι φοιτητές θα είναι σε θέση να: " +
                "<br>1. Να εφαρμόζουν εύστοχα τις κατάλληλες δομές δεδομένων για την επίλυση υπολογιστικών προβλημάτων που προκύπτουν στα διάφορα πεδία εφαρμογών. " +
                "<br>2. Να αποτιμούν τόσο αναλυτικά όσο και πειραματικά το χρόνο εκτέλεσης των βασικών λειτουργιών μίας δομής δεδομένων. " +
                "<br>3. Να προσδιορίζουν αναλυτικά και πειραματικά την πολυπλοτητα χώρου μίας δομής δεδομένων. " +
                "<br>4. Να υλοποιούν αποδοτικά δομές δεδομένων λαμβάνοντας υπόψη τη συγκεκριμένη πλατφόρμα υλοποίησης. <br>";
        domes.setText(Html.fromHtml(text));

        TextView perigrafi_efarmosmenh = (TextView) findViewById(R.id.perigrafi_efarmosmenh);
        text= "<br><b>Αλγεβρικές δομές:</b>Ομάδες. Δακτύλιοι. Σώματα. Διανυσματικοί χώροι." +
                "<br><b>Βασική γραμμική άλγεβρα:</b>Μήτρες. Ορίζουσες. Γραμμικά Συστήματα." +
                "<br><b>Χαρακτηριστικά μεγέθη:</b> Ιδιοτιμές. Ιδιοδιανύσματα. Διαγωνιοποίηση μητρών. Τετραγωνικές μορφές." +
                "<br><b>Εσωτερικό γινόμενο:</b>Ορθοκανονικοποίηση. Μέθοδος Gram-Schmidt." +
                "<br><b>Μήτρες γραμμικών απεικονίσεων:</b>Μήτρα αλλαγής βάσης. Μήτρα γραμμικής απεικόνισης.<br>";
        perigrafi_efarmosmenh.setText(Html.fromHtml(text));
    }
    void create_math_3o(){
        setContentView(R.layout.activity_mathima3o);
        String text;
        myDialog = new Dialog(this);

        TextView underline_tsikoyras;
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras);
        text = "<u>Τσικούρας Παναγιώτης-Γεώργιος</u>";
        underline_tsikoyras.setText(Html.fromHtml(text));

        TextView underline_tasoylas;
        underline_tasoylas = (TextView) findViewById(R.id.tasoylas);
        text = "<u>Τασούλας Ιωάννης</u>";
        underline_tasoylas.setText(Html.fromHtml(text));

        TextView underline_despoths;
        underline_despoths = (TextView) findViewById(R.id.despotis);
        text = "<u>Δεσπότης Δημήτριος</u>";
        underline_despoths.setText(Html.fromHtml(text));
        underline_despoths = (TextView) findViewById(R.id.despotis1);
        underline_despoths.setText(Html.fromHtml(text));

        TextView underline_pikrakhs;
        underline_pikrakhs = (TextView) findViewById(R.id.pikrakhs);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakhs.setText(Html.fromHtml(text));

        TextView underline_kotzanikolaoy;
        underline_kotzanikolaoy = (TextView) findViewById(R.id.kotzanikolaoy);
        text = "<u>Κοτζανικολάου Παναγιώτης</u>";
        underline_kotzanikolaoy.setText(Html.fromHtml(text));

        TextView underline_alepis;
        underline_alepis = (TextView) findViewById(R.id.alephs);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alepis.setText(Html.fromHtml(text));


        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));


        TextView perigrafi_efarmoges_thewrias = (TextView) findViewById(R.id.perigrafi_efarmoges_thewrias);
        text= "<br><b>Γραφήματα Δεσμών:</b> Βασικοί ορισμοί και αποτελέσματα. Ισομορφισμός. Πράξεις. Συνεκτικότητα. Διμερή Γραφήματα. Επίπεδα Γραφήματα. Μήτρα. Απεικόνιση. Χρωματικός Αριθμός. Ανεξαρτησία – Κάλυψη. Κόστος. Κορυφές με Επιγραφή. Πολυγραφήματα." +
                "<br><b>Δένδρα:</b> Βασικοί ορισμοί και αποτελέσματα. Διατεταγμένα Δένδρα. Δυαδικά δένδρα. Διάσχιση διατεταγμένων και δυαδικών δένδρων." +
                "<br><b>Γραφήματα τόξων:</b> Βασικοί ορισμοί και αποτελέσματα. Μήτρα. Απεικόνιση. Πράξεις. Πυρήνας. Βάση." +
                "<br><b>Εφαρμογές: </b> Δένδρα Αποφάσεων, Δένδρα και Πράξεις. Διάταξη Παραγωγής. Εφαρμογή στον Χρονικό Προγραμματισμό.<br> ";
        perigrafi_efarmoges_thewrias.setText(Html.fromHtml(text));


    }
    void create_math_4o(){
        setContentView(R.layout.activity_mathima4o);
        String text;
        myDialog = new Dialog(this);



        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris1);
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_kotzanikolaoy;
        underline_kotzanikolaoy = (TextView) findViewById(R.id.kotzanikolaoy);
        text = "<u>Κοτζανικολάου Παναγιώτης</u>";
        underline_kotzanikolaoy.setText(Html.fromHtml(text));
        underline_kotzanikolaoy = (TextView) findViewById(R.id.kotzanikolaoy1);
        underline_kotzanikolaoy.setText(Html.fromHtml(text));

        TextView underline_mamakoy;
        underline_mamakoy = (TextView) findViewById(R.id.mamakoy);
        text = "<u>Μαμάκου Ειρήνη</u>";
        underline_mamakoy.setText(Html.fromHtml(text));

        TextView underline_mixelakakis;
        underline_mixelakakis = (TextView) findViewById(R.id.mixelakakis);
        text = "<u>Ν. Μιχελακάκης</u>";
        underline_mixelakakis.setText(Html.fromHtml(text));

        TextView underline_kwstantopoylos;
        underline_kwstantopoylos = (TextView) findViewById(R.id.konstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwstantopoylos.setText(Html.fromHtml(text));

        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy1);
        underline_voygioyklidoy.setText(Html.fromHtml(text));

        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text = "<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));

        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis);
        text = "<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));


        TextView mathisiaka_algorithmoys = (TextView) findViewById(R.id.mathisiaka_algorithmoys);
        text= "<br>Με την επιτυχή ολοκλήρωση αυτής της ενότητας οι φοιτητές θα είναι σε θέση να:" +
                "<br>1. Να εφαρμόζουν εύστοχα τις κατάλληλες αλγοριθμικές τεχνικές για την επίλυση υπολογιστικών προβλημάτων που προκύπτουν στα διάφορα πεδία εφαρμογών. " +
                "<br>2. Να κατανοούν τη εγγενή δυσκολία ενός αλγοριθμικού προβλήματος. " +
                "<br>3. Να εκτιμούν τόσο αναλυτικά όσο και πειραματικά την ποιότητα λύσης ενός αλγορίθμου. " +
                "<br>4. Να προσδιορίζουν αναλυτικά την πολυπλοτητα χώρου και χρόνου των αλγοριθμικών τεχνικών. " +
                "<br>5. Να υλοποιούν αποδοτικά αλγορίθμους λαμβάνοντας υπόψη την συγκεκριμένη πλατφόρμα υλοποίησης. <br>";
        mathisiaka_algorithmoys.setText(Html.fromHtml(text));


    }
    void create_math_5o(){
        setContentView(R.layout.activity_mathima5o);
        String text;
        myDialog = new Dialog(this);


        TextView underline_asimakopoylos;
        underline_asimakopoylos = (TextView) findViewById(R.id.asimakopoylos);
        text = "<u>Ασημακόπουλος Νικήτας</u>";
        underline_asimakopoylos.setText(Html.fromHtml(text));

        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        text = "<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));

        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));


        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));

        TextView underline_kwstantopoylos;
        underline_kwstantopoylos = (TextView) findViewById(R.id.konstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwstantopoylos.setText(Html.fromHtml(text));

        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy1);
        underline_voygioyklidoy.setText(Html.fromHtml(text));

        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text = "<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));

        TextView underline_meta3iwths;
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths);
        text = "<u>Μεταξιώτης Κωνσταντίνος</u>";
        underline_meta3iwths.setText(Html.fromHtml(text));

        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis);
        text = "<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));

        TextView underline_fotis;
        underline_fotis = (TextView) findViewById(R.id.fotis);
        text = "<u>Γεωργιακώδης Φώτιος</u>";
        underline_fotis.setText(Html.fromHtml(text));

        TextView underline_apostoloy;
        underline_apostoloy = (TextView) findViewById(R.id.apostoloy);
        text = "<u>Αποστόλου Δημήτριος</u>";
        underline_apostoloy.setText(Html.fromHtml(text));
    }
    void create_math_6o(){
        setContentView(R.layout.activity_mathima6o);
        String text;
        myDialog = new Dialog(this);


        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_despotis;
        underline_despotis = (TextView) findViewById(R.id.despotis);
        text = "<u>Δεσπότης Δημήτριος</u>";
        underline_despotis.setText(Html.fromHtml(text));

        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        text = "<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));



        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));


        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));


        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text = "<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));


        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis);
        text = "<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis1);
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));
        underline_vergados = (TextView) findViewById(R.id.vergados1);
        underline_vergados.setText(Html.fromHtml(text));


        TextView underline_fotis;
        underline_fotis = (TextView) findViewById(R.id.fotis);
        text = "<u>Γεωργιακώδης Φώτιος</u>";
        underline_fotis.setText(Html.fromHtml(text));

        TextView underline_asimakopoylos;
        underline_asimakopoylos = (TextView) findViewById(R.id.asimakopoylos);
        text = "<u>Ασημακόπουλος Νικήτας</u>";
        underline_asimakopoylos.setText(Html.fromHtml(text));

        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis1);
        underline_pikrakis.setText(Html.fromHtml(text));


        TextView underline_alephs;
        underline_alephs = (TextView) findViewById(R.id.alepis);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alephs.setText(Html.fromHtml(text));

        TextView underline_apostoloy;
        underline_apostoloy = (TextView) findViewById(R.id.apostoloy);
        text = "<u>Αποστόλου Δημήτριος</u>";
        underline_apostoloy.setText(Html.fromHtml(text));
        underline_apostoloy = (TextView) findViewById(R.id.apostoloy1);
        underline_apostoloy.setText(Html.fromHtml(text));
    }
    void create_math_7o(){
        setContentView(R.layout.activity_mathima7o);

        String text;
        myDialog = new Dialog(this);


        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_pelekis;
        underline_pelekis = (TextView) findViewById(R.id.pelekis);
        text = "<u>Ν. Πελέκης</u>";
        underline_pelekis.setText(Html.fromHtml(text));

        TextView underline_kotzanikolaoy;
        underline_kotzanikolaoy = (TextView) findViewById(R.id.kotzanikolaoy);
        text = "<u>Κοτζανικολάου Παναγιώτης</u>";
        underline_kotzanikolaoy.setText(Html.fromHtml(text));



        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        text = "<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));



        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));


        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));

        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));


        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text = "<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));
        underline_polemi = (TextView) findViewById(R.id.polemi1);
        underline_polemi.setText(Html.fromHtml(text));



        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tzixritzis);
        text = "<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));

        TextView underline_meta3iwths;
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths);
        text = "<u>Μεταξιώτης Κωνσταντίνος</u>";
        underline_meta3iwths.setText(Html.fromHtml(text));





        TextView underline_asimakopoylos;
        underline_asimakopoylos = (TextView) findViewById(R.id.asimakopoylos);
        text = "<u>Ασημακόπουλος Νικήτας</u>";
        underline_asimakopoylos.setText(Html.fromHtml(text));

        TextView underline_kwnstantopoylos;
        underline_kwnstantopoylos = (TextView) findViewById(R.id.kwstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwnstantopoylos.setText(Html.fromHtml(text));


        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));



        TextView underline_alephs;
        underline_alephs = (TextView) findViewById(R.id.alepis);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alephs.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis1);
        underline_theodwridis.setText(Html.fromHtml(text));
    }
    void create_math_8o(){
        setContentView(R.layout.activity_mathima8o);
        String text;
        myDialog = new Dialog(this);


        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_pelekis;
        underline_pelekis = (TextView) findViewById(R.id.pelekis);
        text = "<u>Ν. Πελέκης</u>";
        underline_pelekis.setText(Html.fromHtml(text));


        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));


        TextView underline_voygioyklidoy;
        underline_voygioyklidoy = (TextView) findViewById(R.id.voygioyklidoy);
        text = "<u>Βουγιουκλίδου Άννα</u>";
        underline_voygioyklidoy.setText(Html.fromHtml(text));


        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text = "<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));


        TextView underline_asimakopoylos;
        underline_asimakopoylos = (TextView) findViewById(R.id.asimakopoylos);
        text = "<u>Ασημακόπουλος Νικήτας</u>";
        underline_asimakopoylos.setText(Html.fromHtml(text));


        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));



        TextView underline_alephs;
        underline_alephs = (TextView) findViewById(R.id.alepis);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alephs.setText(Html.fromHtml(text));

        TextView underline_meta3iwths;
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths);
        text = "<u>Μεταξιώτης Κωνσταντίνος</u>";
        underline_meta3iwths.setText(Html.fromHtml(text));
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths1);
        underline_meta3iwths.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));

        TextView underline_fotis;
        underline_fotis = (TextView) findViewById(R.id.fotis);
        text = "<u>Γεωργιακώδης Φώτιος</u>";
        underline_fotis.setText(Html.fromHtml(text));

        TextView underline_kotzanikolaoy;
        underline_kotzanikolaoy = (TextView) findViewById(R.id.kotzanikolaoy);
        text = "<u>Κοτζανικολάου Παναγιώτης</u>";
        underline_kotzanikolaoy.setText(Html.fromHtml(text));
    }

    public void ShowPopup(View v){

        TextView txtclose;
        TextView onomatepwnymo;
        TextView idiotita;
        TextView tmhma;
        TextView grafeio;
        TextView thl;
        TextView email;
        TextView istoselida;



        TextView clickedTextView = (TextView) v;
        String text = clickedTextView.getText().toString();

        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

        onomatepwnymo = (TextView) myDialog.findViewById(R.id.onomatepwnymo);
        idiotita = (TextView) myDialog.findViewById(R.id.idiotita);
        tmhma = (TextView) myDialog.findViewById(R.id.tmhma);
        grafeio = (TextView) myDialog.findViewById(R.id.grafeio);
        thl = (TextView) myDialog.findViewById(R.id.thl);
        email = (TextView) myDialog.findViewById(R.id.email);
        istoselida = (TextView) myDialog.findViewById(R.id.istoselida);

        onomatepwnymo.setText(text);
        if (text.equals("Ψαράκης Μιχαήλ")){
            idiotita.setText(" Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("302/ΓΛ126");
            thl.setText(" +30 210 4142425");
            email.setText("mpsarak@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σαπουνάκης Αριστείδης")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("542/ΚΕΚΤ");
            thl.setText(" +30 210 4142262");
            email.setText("arissap@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Αποστόλου Δημήτριος")){
            idiotita.setText("Αναπληρωτής Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("303/ΓΛ126");
            thl.setText("+30 210 4142476");
            email.setText("dapost@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Δουληγέρης Χρήστος")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText(" 302/ΚΕΚΤ");
            thl.setText("+30 210 4142137");
            email.setText("cdoulig@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Παναγιωτόπουλος Θεμιστοκλής")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("541/ΚΕΚΤ");
            thl.setText("+30 210 4142276");
            email.setText("themisp@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Τσιχριντζής Γεώργιος")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("506/ΚΕΚΤ");
            thl.setText("+30 210 4142322");
            email.setText("geoatsi@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Τσικούρας Παναγιώτης-Γεώργιος")) {
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("543/ΚΕΚΤ");
            thl.setText("+30 210 4142313");
            email.setText("pgtsik@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Βουγιουκλίδου Άννα")) {
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("4ος/ΖΕΑΣ");
            thl.setText("+30 210 4142176");
            email.setText("avou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κωνσταντόπουλος Χαράλαμπος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142124");
            email.setText("konstant@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Δεσπότης Δημήτριος")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("702/ΓΛ126");
            thl.setText("+30 210 4142315");
            email.setText("despotis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Αλέπης Ευθύμιος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("540/ΚΕΚΤ");
            thl.setText("+30 210 4142311");
            email.setText("talepis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        } else if(text.equals("Κοτζανικολάου Παναγιώτης")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("302/ΓΛ126");
            thl.setText("+30 210 4142123");
            email.setText("pkotzani@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Πικράκης Άγγελος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("505/ΚΕΚΤ");
            thl.setText("+30 210 4142128");
            email.setText("pikrakis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Τασούλας Ιωάννης")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("542/ΚΕΚΤ");
            thl.setText("+30 210 4142313");
            email.setText("jtas@unipi.gr");
            istoselida.setText("www.unipi.gr");
        } else if(text.equals("Πολέμη Δέσποινα")) {
            idiotita.setText("Αναπλ. Καθηγήτρια");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("502/ΚΕΚΤ");
            thl.setText("+30 210 4142270");
            email.setText("dpolemi@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Τσιχριντζής Γεώργιος")) {
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("506/ΚΕΚΤ");
            thl.setText("+30 210 4142322");
            email.setText("geoatsi@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Θεοδωρίδης Ιωάννης")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("501/ΚΕΚΤ");
            thl.setText("+30 210 4142449");
            email.setText("ytheod@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Μαμάκου Ειρήνη")){
            idiotita.setText("Μέλος ΕΕΠ");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("201/Γρ. Λαμπράκη 126");
            thl.setText("+30 210 4142641");
            email.setText("mamakou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Ν. Μιχελακάκης")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("ΚΕKΤ/522");
            thl.setText("+30 210 4142289");
            email.setText("njm@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Μεταξιώτης Κωνσταντίνος")){
            idiotita.setText("Αναπληρωτής Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("303/ΓΛ126");
            thl.setText("+30 210 4142578");
            email.setText("cdoulig@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }        else if(text.equals("Βίρβου Μαρία")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("507/ΚΕΚΤ");
            thl.setText("+30 210 4142269");
            email.setText("mvirvou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Βέργαδος Δημήτριος")){
            idiotita.setText("Αναπλ. Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("vergados@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Γεωργιακώδης Φώτιος")) {
            idiotita.setText("Ομότιμος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("");
            thl.setText("");
            email.setText("fotis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Ασημακόπουλος Νικήτας")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("308/ΚΕΚΤ");
            thl.setText("+30 210 4142145");
            email.setText("assinik@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }else if(text.equals("Ν. Πελέκης")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("ΓΛ126 / 601");
            thl.setText("+30 210 4142428");
            email.setText("npelekis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }

        txtclose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
    void create_underline_info(int layout_id,String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(layout_id);
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