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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class metaptyxiaka extends AppCompatActivity {
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


        String mathima_choice = bundle.getString("metaptyxiako_choice");

        if (mathima_choice.equals("met1")) {
            create_metaptyxiako_1o();
            create_underline_info(R.id.layout_metaptyxiako1,"151685","",20550);
        } else if (mathima_choice.equals("met2")) {
            create_metaptyxiako_2o();
            create_underline_info(R.id.layout_metaptyxiako2,"151685","",44750);
        } else if (mathima_choice.equals("met3")) {
            create_metaptyxiako_3o();
            create_underline_info(R.id.layout_metaptyxiako3,"151685","",19900);
        } else if (mathima_choice.equals("met4")) {
            create_metaptyxiako_4o();
            create_underline_info(R.id.layout_metaptyxiako4,"151685","",10630);
        } else if (mathima_choice.equals("met5")) {
            create_metaptyxiako_5o();
            create_underline_info(R.id.layout_metaptyxiako5,"151685","",4650);
        } else if (mathima_choice.equals("met6")) {
            create_metaptyxiako_6o();
            create_underline_info(R.id.layout_metaptyxiako6,"151685","",2020);
        } else if (mathima_choice.equals("met7")) {
            create_metaptyxiako_7o();
            create_underline_info(R.id.layout_metaptyxiako7,"151685","",1770);
        } else if (mathima_choice.equals("met8")) {
            create_metaptyxiako_8o();
            create_underline_info(R.id.layout_metaptyxiako8,"151685","",1840);
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
                Intent intent = new Intent(metaptyxiaka.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(metaptyxiaka.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(metaptyxiaka.this, menu_redirection.class);
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
                Intent intent = new Intent(metaptyxiaka.this, menu_redirection.class);
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
    void create_metaptyxiako_1o() {
        setContentView(R.layout.activity_metaptyxiako1o);
        TextView textView4 = findViewById(R.id.text4);
        String text = "Το Πρόγραμμα Μεταπτυχιακών Σπουδών στις «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής " +
                "Νοημοσύνης» (Advanced Informatics and Computing Systems - Software Development and Αrtificial Intelligence) έχει ως " +
                "αντικείμενο τη συντονισμένη ανάπτυξη και οργάνωση των ερευνητικών κατευθύνσεων της επιστήμης της Πληροφορικής και των " +
                "νέων Τεχνολογιών και ειδικότερα αυτών που αφορούν σε τομείς υψηλής προτεραιότητας για τη χώρα μας.<br><br>" +
                "Το «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης» (Advanced Informatics and Computing " +
                "Systems - Software Development and Αrtificial Intelligence) θεραπεύει αμιγώς τα πλέον προηγμένα ζητήματα επιστήμης στο χώρο" +
                " της Πληροφορικής και των νέων τεχνολογιών. Το περιεχόμενο και η φυσιογνωμία του προγράμματος έχει διαμορφωθεί έτσι ώστε" +
                " να ανταποκρίνεται με επιτυχία στις ιδιαίτερες επιστημονικές ανάγκες που προκαλεί η ταχύτατη εξέλιξη της Πληροφορικής και" +
                " νέων Τεχνολογιών σε ευρωπαϊκό και διεθνές επίπεδο.<br><br>" +
                "Τόσο τα υποχρεωτικά μαθήματα, όσο και τα μαθήματα επιλογής, έχουν επιλεγεί ώστε να προσφέρουν στο μεταπτυχιακό φοιτητή " +
                "την ειδίκευση που απαιτούν οι πλέον πρόσφατες τεχνολογικές εξελίξεις στον τομέα της Πληροφορικής και νέων τεχνολογιών, " +
                "σε συνδυασμό με τα ιδιαίτερα χαρακτηριστικά και τις ανάγκες της σύγχρονης Ελληνικής και Ευρωπαϊκής Οικονομίας.<br><br>" +
                "Οι σκοποί του Προγράμματος Μεταπτυχιακών Σπουδών στο «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής " +
                "Νοημοσύνης» (Advanced Informatics and Computing Systems - Software Development and Αrtificial Intelligence) του Τμήματος " +
                "Πληροφορικής του Πανεπιστημίου Πειραιώς, είναι οι εξής:<br><br>" +
                "<ul><li> Η προαγωγή της επιστήμης και της έρευνας στο αντικείμενο του προγράμματος σπουδών. </li>" +
                "<li>Η προετοιμασία και εκπαίδευση εξειδικευμένων και ικανών μεταπτυχιακών επιστημόνων ερευνητών και στελεχών που θα προωθήσουν την ανάπτυξη της χώρας και των Ελληνικών επιχειρήσεων στην Κοινωνία της Πληροφορίας και των Νέων Τεχνολογιών, του Πολιτισμού και της Οικονομίας.</li> " +
                "<li> Η ανάπτυξη της Θεωρητικής και Εφαρμοσμένης Πληροφορικής, των Τεχνολογιών Πληροφορικής και Επικοινωνιών. </li>" +
                "<li>Η στενή συνεργασία μεταξύ της Ακαδημαϊκής Κοινότητας και των Επιχειρήσεων για την αποδοχή, χρήση και ανάπτυξη των πλέον προηγμένων συστημάτων Πληροφορικής και Υπηρεσιών. </li>" +
                "<li>Η συνεργασία με Ελληνικούς, Ευρωπαϊκούς και Διεθνείς Επιστημονικούς Οργανισμούς, που ασχολούνται με θέματα Πληροφορικής, Νέων Τεχνολογιών, με τομείς του Πολιτισμού, της Οικονομίας κ.α. </li></ul>";
        textView4.setText(Html.fromHtml(text));
        TextView textView6 = findViewById(R.id.text6);
        text = "Η χρονική διάρκεια για την απονομή του Διπλώματος Μεταπτυχιακών Σπουδών ορίζεται σε τρία (3) ακαδημαϊκά εξάμηνα για " +
                "το πρόγραμμα πλήρους φοίτησης και σε δυο (2) επιπλέον εξάμηνα για το πρόγραμμα μερικής φοίτησης.<br>" +
                "<br>" +
                "Για την απονομή του ΔΜΣ (M.Sc.) απαιτούνται: <br>" +
                "<br><ul><li>κατά το πρώτο εξάμηνο, για όλες τις κατευθύνσεις, η παρακολούθηση των πέντε υποχρεωτικών μαθημάτων της επιλεγείσας ειδίκευσης και ενός μαθήματος εκ των προσφερόμενων κατά το εξάμηνο αυτό από το πρόγραμμα σπουδών ως υποχρεωτικών μαθημάτων άλλων ειδικεύσεων ή ως μαθημάτων ελεύθερης επιλογής.</li>" +
                "<li>κατά το δεύτερο εξάμηνο, για όλες τις ειδικεύσεις, η παρακολούθηση των πέντε υποχρεωτικών μαθημάτων της επιλεγείσας κατεύθυνσης και ενός μαθήματος εκ των προσφερόμενων κατά το εξάμηνο αυτό από το πρόγραμμα σπουδών ως υποχρεωτικών μαθημάτων άλλων ειδικεύσεων ή ως μαθημάτων ελεύθερης επιλογής.</li>" +
                "<li> κατά το τρίτο εξάμηνο η εκπόνηση και συγγραφή μεταπτυχιακής διατριβής.</li></ul>" +
                "Οι γλώσσες διδασκαλίας του Π.Μ.Σ.(M.Sc. Program) είναι η Ελληνική ή/και η Αγγλική.<br><br>" +
                "Κάθε μάθημα ισοδυναμεί με πέντε (5) πιστωτικές μονάδες (ECTS). Η Μεταπτυχιακή Διατριβή ισοδυναμεί με τριάντα (30) πιστωτικές μονάδες (ECTS). Συνολικά, το ΠΜΣ ισοδυναμεί με ενενήντα (90) πιστωτικές μονάδες (ECTS).";
        textView6.setText(Html.fromHtml(text));

        TextView text16 = findViewById(R.id.text16);
        text="<u>Πατήστε εδώ για να κάνετε ηλεκτρονική υποβολή αίτησης</u>";
        text16.setText(Html.fromHtml(text));
        text16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/registration/aics-sdai.php";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text17 = findViewById(R.id.text17);
        text="<u>Πρόσκληση υποβολής αιτήσεων για το ΠΜΣ «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης» , 2020-2021</u>";
        text17.setText(Html.fromHtml(text));
        text17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prokirixi-pms-psp.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text18 = findViewById(R.id.text18);
        text="<u>Έντυπο αίτησης για το ΠΜΣ«Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης» , 2020-2021</u><br><br>";
        text18.setText(Html.fromHtml(text));
        text18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/aitisi-pms-psp.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));


        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));

        TextView underline_mixalas = (TextView) findViewById(R.id.mixalas);
        text = "<u>Μιχάλας Άγγελος</u>";
        underline_mixalas.setText(Html.fromHtml(text));

        TextView underline_pelekis = (TextView) findViewById(R.id.pelekis);
        text = "<u>Πελέκης Νικόλαος</u>";
        underline_pelekis.setText(Html.fromHtml(text));


        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));

        TextView underline_asimakopoylos;
        underline_asimakopoylos = (TextView) findViewById(R.id.asimakopoylos);
        text = "<u>Ασημακόπουλος Νικήτας</u>";
        underline_asimakopoylos.setText(Html.fromHtml(text));


        TextView underline_karagiwrgoy;
        underline_karagiwrgoy = (TextView) findViewById(R.id.karagiwrgoy);
        text = "<u>Καραγιώργου Σοφία</u>";
        underline_karagiwrgoy.setText(Html.fromHtml(text));


        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tsixritzis);
        text ="<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_alephs;
        underline_alephs = (TextView) findViewById(R.id.alepis);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alephs.setText(Html.fromHtml(text));

        TextView underline_tsikoyras;
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras);
        text = "<u>Τσικούρας Παναγιώτης-Γεώργιος</u>";
        underline_tsikoyras.setText(Html.fromHtml(text));

        TextView underline_katsiwnis;
        underline_katsiwnis = (TextView) findViewById(R.id.katsiwnhs);
        text = "<u>Κατσιώνης Γεώργιος</u>";
        underline_katsiwnis.setText(Html.fromHtml(text));


        TextView underline_kwnstantopoylos;
        underline_kwnstantopoylos = (TextView) findViewById(R.id.kwnstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwnstantopoylos.setText(Html.fromHtml(text));




        TextView underline_meta3iwths;
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths);
        text = "<u>Μεταξιώτης Κωνσταντίνος</u>";
        underline_meta3iwths.setText(Html.fromHtml(text));

        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_liagkoyras;
        underline_liagkoyras = (TextView) findViewById(R.id.liagkoyras);
        text = "<u>Λιαγκούρας Κωνσταντίνος</u>";
        underline_liagkoyras.setText(Html.fromHtml(text));

        TextView underline_kanatoyla;
        underline_kanatoyla = (TextView) findViewById(R.id.kanatoyla);
        text = "<u>Κανατούλα Αικατερίνη</u>";
        underline_kanatoyla.setText(Html.fromHtml(text));

        TextView underline_papadomixelaki;
        underline_papadomixelaki = (TextView) findViewById(R.id.papadomixelaki);
        text = "<u>Παπαδομιχελάκη Ξένη</u>";
        underline_papadomixelaki.setText(Html.fromHtml(text));

        TextView underline_swthropoylos;
        underline_swthropoylos = (TextView) findViewById(R.id.swthropoylos);
        text = "<u>Σωτηρόπουλος Διονύσιος</u>";
        underline_swthropoylos.setText(Html.fromHtml(text));

        TextView underline_kalogeraki;
        underline_kalogeraki = (TextView) findViewById(R.id.kalogeraki);
        text = "<u>Καλογεράκη Ελένη - Μαρία</u>";
        underline_kalogeraki.setText(Html.fromHtml(text));


        TextView underline_skondras;
        underline_skondras = (TextView) findViewById(R.id.skondras);
        text = "<u>Σκόνδρας Εμμανουήλ</u>";
        underline_skondras.setText(Html.fromHtml(text));
    }
    void create_metaptyxiako_2o() {
        setContentView(R.layout.activity_metaptyxiako2o);
        TextView text4 = findViewById(R.id.text4);
        String text = "Το Πρόγραμμα Μεταπτυχιακών Σπουδών «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες» («Digital Culture, Smart Cities, IoT and Advanced Digital Technologies») έχει ως αντικείμενο την συντονισμένη ανάπτυξη και οργάνωση των ερευνητικών κατευθύνσεων της επιστήμης των νέων Τεχνολογιών και ειδικότερα αυτών που αφορούν σε τομείς υψηλής προτεραιότητας για τη χώρα μας, όπως είναι ο " +
                "<b>Ψηφιακός Πολιτισμός, οι Έξυπνες Πόλεις, το Διαδίκτυο των Πραγμάτων (IoT), καθώς και οι Σύγχρονες Επικοινωνίες και Ψηφιακές Τεχνολογίες.</b>" +
                "<br> <br> Το ΠΜΣ απονέμει Δίπλωμα Μεταπτυχιακών Σπουδών (Δ.Μ.Σ.) με τίτλο «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες» με τις εξής τρεις (3) ειδικεύσεις (tracks) : «Ψηφιακός Πολιτισμός», «Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες», «Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες». " +
                "<b>Το Π.Μ.Σ. απευθύνεται σε αποφοίτους από διαφορετικά επιστημονικά πεδία.</b> <br> <br>" +
                "<u><b>Ειδίκευση / Κατεύθυνση «Ψηφιακός Πολιτισμός» - «Digital Culture»</b></u><br><br>" +
                "Η Ειδίκευση / Κατεύθυνση <b>«Ψηφιακός Πολιτισμός» - «Digital Culture» </b>στοχεύει στην εκπαίδευση και κατάρτιση επιστημόνων διαφόρων ειδικοτήτων από θεωρητικά, θετικά και τεχνολογικά πεδία γνώσεων για την ανάδειξη, προστασία, προβολή και διαχείριση του πολιτιστικού αποθέματος με τη συμβολή προηγμένων ψηφιακών τεχνολογιών. Eφοδιάζει τους φοιτητές με τις κατάλληλες γνώσεις των τελευταίων τάσεων που επικρατούν παγκοσμίως στο αναδυόμενο διεπιστημονικό πεδίο του ψηφιακού πολιτισμού και διασφαλίζει τη χάραξη και τη διαμόρφωση νέας ψηφιακής στρατηγικής στον πολιτισμό. Προωθεί τη διάσωση και ανάδειξη της πολιτισμικής κληρονομιάς στη χώρας μας αναδεικνύοντας νέους τρόπους αποτελεσματικής διοίκησης των πολιτισμικών οργανισμών στο ευρύτερο πλαίσιο της κοινωνικής και εκπαιδευτικής πολιτικής. Ενσωματώνει μοντέρνα γνωστικά πεδία μεταξύ των οποίων είναι η μοντελοποίηση με 3Δ γραφικά, η εφαρμογή τεχνολογιών μικτής πραγματικότητας (Virtual Reality, Augmented Reality, Virtual Worlds), οι κινητές επικοινωνίες, οι τεχνολογίες διαδικτύου και μέσων κοινωνικής δικτύωσης, η επεξεργασία σημάτων και πολυμέσων, με τελικό σκοπό τη βέλτιστη ψηφιακή διαχείριση, καταγραφή και επιμέλεια της πολιτισμικής κληρονομιάς αλλά και των πτυχών του σύγχρονου πολιτισμού. Καθώς η χώρα μας διαθέτει πλούσιο πολιτιστικό απόθεμα σε μια ήπειρο (Ευρώπη) που αποτελεί και η ίδια πολιτιστική υπερδύναμη, η ενίσχυση της διεπιστημονικότητας θα συμβάλλει στην ενίσχυση της Δημιουργικής Βιομηχανίας, στην προστασία της πολιτιστικής μας κληρονομιάς και την ώθηση της σύγχρονης δημιουργίας. " +
                "<br><br><u><b>Ειδίκευση / Κατεύθυνση «Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες» - «Smart Cities and Advanced Digital Technologies»</b></u>" +
                "<br><br>Η Ειδίκευση / Κατεύθυνση <b>«Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες»</b> στοχεύει να εκπαιδεύσει και να καταρτίσει επιστήμονες από διαφορετικά πεδία ώστε να μπορούν να εργαστούν στο νέο ψηφιακό αστικό τοπίο, καθώς και να σχεδιάσουν και να υποστηρίξουν νέες υπηρεσίες στις διαρκώς μεταβαλλόμενες «Έξυπνες Πόλεις», που συνδέονται με το σύγχρονο οικοσύστημα, υποδομές, λειτουργίες και υπηρεσίες, όπως οι έξυπνες μεταφορές, επικοινωνίες, έξυπνα σπίτια, ηλεκτρονική διακυβέρνηση, smart grids, έξυπνη πολιτιστική κληρονομιά, έξυπνη υγεία, έξυπνη γεωργία, έξυπνη ψηφιακή υποδομή, έξυπνη διαχείριση ενέργειας. Στοχεύει επίσης στην παροχή τεχνογνωσίας για τη διαχείριση πολύπλοκων αστικών ζητημάτων, να παράσχει τα κατάλληλα εφόδια για την ανάπτυξη καινοτόμων συστημάτων διακυβέρνησης μιας ασφαλούς και βιώσιμης πόλης, στον σχεδιασμό και υποστήριξη λειτουργικών και αποτελεσματικών μεθόδων εξοικονόμησης πόρων, καθώς και στην έξυπνη διαχείριση καταστροφών. " +
                "<br><br><u><b>Ειδίκευση / Κατεύθυνση «Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες» - «Internet of Things (IoT) and Advanced Digital Technologies»</b></u>" +
                "<br><br>Η Ειδίκευση / Κατεύθυνση <b>«Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες»</b> στοχεύει να εκπαιδεύσει και να καταρτίσει επιστήμονες από διαφορετικά πεδία, αλλά κυρίως από τους τομείς των θετικών και τεχνολογικών επιστημών, να παρέχει τις κατάλληλες γνώσεις για τη σχεδίαση, διαχείριση και υποστήριξη νέων υπηρεσιών στις ΙοΤ πλατφόρμες, τη διαχείριση πολύπλοκων έργων, να παράσχει τα κατάλληλα εφόδια για το σχεδιασμό και ανάπτυξη κατάλληλων και καινοτόμων συστημάτων και υπηρεσιών, την ανάλυση μεγάλων δεδομένων, να παρέχει την τεχνογνωσία στο σχεδιασμό των αλληλεξαρτώμενων ΙοΤ συστημάτων που συνδέονται με τις λειτουργίες της ψηφιακής πόλης, των έξυπνων σπιτιών, τις μεταφορές, την κατασκευή, την ενέργεια, τα smart grids, την έξυπνη υγεία, την έξυπνη γεωργία, την έξυπνη ασφάλεια, την παροχή υπηρεσιών, τις επικοινωνίες, τις έξυπνες ψηφιακές υποδομές, την εκπαίδευση, την έξυπνη ασφάλεια, την ανάπτυξη συστημάτων διακυβέρνησης, την ασφάλεια των δεδομένων, την προστασία της ιδιωτικότητας - ακεραιότητας των προσωπικών δεδομένων, την αντιμετώπιση διαδικτυακών εισβολών, την προστασία των συσκευών από επιθέσεις, την διαλειτουργικότητα των συστημάτων και των συσκευών. " +
                "<br><br>Οι απόφοιτοι του Μεταπτυχιακού Προγράμματος μπορούν να εργαστούν στη δημόσια διοίκηση, Δήμους, Περιφέρειες, τεχνολογικά και ερευνητικά κέντρα, σε μια σειρά εμπλεκομένων φορέων του Πολιτισμού και Τουρισμού, σε τμήματα R&D σε μικρές και μεσαίες επιχειρήσεις, καθώς και σε μεγάλες επιχειρήσεις, σε εταιρίες που ασχολούνται με την καινοτομία τον Πολιτισμό και τον Τουρισμό και την υλοποίηση τεχνολογικών λύσεων. Οι γνώσεις που θα αποκομίσουν θα τους δώσουν τη δυνατότητα να ασκήσουν επαγγελματική συμβουλευτική και επιχειρηματικότητα σε θέματα έξυπνων πόλεων, ψηφιακού πολιτισμού, σύγχρονων ψηφιακών υπηρεσιών, τηλεπικοινωνιών και δικτύων, συμπεριλαμβανομένων των επιχειρήσεων, των διαχειριστών δικτύων ενέργειας και τηλεπικοινωνιών, των ρυθμιστικών αρχών, ιδιωτικών και δημόσιων φορέων. Οι απόφοιτοι έχουν επίσης τη δυνατότητα να συνεχίσουν τη σταδιοδρομία τους σε υφιστάμενους οργανισμούς, να αποκτήσουν τα κατάλληλα εφόδια και γνώσεις απαραίτητες για τομείς όπως η Δημόσια διοίκηση και Υπουργεία, Δήμους, Περιφέρειες, Τεχνολογικά και ερευνητικά κέντρα, καθώς και να συνεχίσουν τις σπουδές τους σε Διδακτορικό Επίπεδο, καθώς και να ξεκινήσουν τις δικές τους καινοτόμες επιχειρήσεις. </b>" +
                "<br<br>" +
                "<b><p style=\"text-align:center;\">Χρονική Διάρκεια</p></b>" +
                "Η χρονική διάρκεια σπουδών για την απονομή του Διπλώματος Μεταπτυχιακών Σπουδών ορίζεται σε τρία (3) εξάμηνα.\n" +
                "Για την απονομή του Δ.Μ.Σ. απαιτείται η παρακολούθηση των μαθημάτων διάρκειας δύο ακαδημαϊκών εξαμήνων και η εκπόνηση μεταπτυχιακής διατριβής. Κατά τη διάρκεια των δύο πρώτων εξαμήνων και για όλες τις κατευθύνσεις απαιτείται η επιτυχής παρακολούθηση των πέντε υποχρεωτικών μαθημάτων της επιλεγείσης ειδίκευσης." +
                "<br>Κάθε μάθημα διδάσκεται σε δέκα τρίωρες διαλέξεις και έχει 6 Πιστωτικές Μονάδες - ECTS. Είναι υποχρεωτική η παρακολούθηση τουλάχιστον επτά από αυτές τις διαλέξεις. " +
                "<br>Με την επιτυχή παρακολούθηση και ολοκλήρωση του ΠΜΣ, χορηγείται Δ.Μ.Σ. 90 πιστωτικών μονάδων (ECTS). Το τρίτο εξάμηνο διατίθεται για τη εκπόνηση μεταπτυχιακής διατριβής. " +
                "<b><p style=\"text-align:center;\">Μεταπτυχιακοί Τίτλοι</p></b>" +
                "Το ΠΜΣ απονέμει το Δίπλωμα Μεταπτυχιακών Σπουδών (Δ.Μ.Σ.) με τίτλο «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες» («Digital Culture, Smart Cities, IoT and Advanced Digital Technologies») με τις εξής ειδικεύσεις (tracks) : " +
                "<ul><li>Ψηφιακός Πολιτισμός / Digital Culture</li><li>Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες / Smart Cities and Advanced Digital Technologies.</li>" +
                "<li>Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες / Internet of Things (IoT) and Advanced Digital Technologies.</li></ul>" +
                "<b>Οι ενδιαφερόμενοι μπορούν να υποβάλουν αιτήσεις έως και 30 Ιουνίου 2020</b> στη Γραμματεία του Προγράμματος Μεταπτυχιακών Σπουδών (Π.Μ.Σ.) του Πανεπιστημίου Πειραιώς. Περισσότερες Πληροφορίες μπορείτε να βρείτε: https://www.facebook.com/dcsciot, http://www.cs.unipi.gr/dcsciot, Email: dcsciot@unipi.gr" +
                "<b><p style=\"text-align:center;\">Σε ποιους απευθύνεται το Π.Μ.Σ.</p></b>" +
                "Στο Π.Μ.Σ. γίνονται δεκτοί κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν.4485/2017. Περισσότερες πληροφορίες μπορείτε να αναζητήσετε σε κάθε ειδίκευση/κατεύθυνση του Π.Μ.Σ. http://www.cs.unipi.gr/dcsciot" +
                "<br><br>Ενδεικτικά και ανάλογα με την ειδίκευση: Τμημάτων/Σχολών Τεχνολογιών Πληροφορικής και Επικοινωνιών, Μηχανικών, Καλών Τεχνών, Αρχιτεκτόνων Μηχανικών, Πολεοδόμων, Φιλοσοφικής Σχολής, Ανθρωπιστικών Επιστημών, Θετικών Επιστημών ή Τεχνολογικών Επιστημών, Γεωπονικών Επιστημών, Παιδαγωγικών, Θεολογικής, Οικονομικών και Κοινωνικών Επιστημών, Οικονομικών - Επιχειρηματικών και Διεθνών Σπουδών, Ναυτιλίας και Βιομηχανίας, Κοινωνικών Επιστημών, Μηχανικών Πολυτεχνείων ή Πολυτεχνικών Σχολών, Μηχανικών Περιβάλλοντος, Νομικών Επιστημών, Τμημάτων Πληροφορικής, Τεχνών Ήχου & Εικόνας, Πολιτισμικής Τεχνολογίας & Επικοινωνίας, Τμημάτων Τεχνολογιών Πληροφορικής και Επικοινωνιών, Διαχείρισης Πολιτισμικού Περιβάλλοντος και Νέων Τεχνολογιών, Επικοινωνίας Μέσων και Πολιτισμού, Ψηφιακών Μέσων, Επικοινωνίας και Πολιτισμικής Διαχείρισης, Συντηρητών Αρχαιοτήτων & Έργων Τέχνης, Ιστορικών και Αρχαιολόγων, Γραφιστικής, Πληροφορικής και Μέσων Μαζικής Ενημέρωσης, Διοίκησης - Οικονομίας και Επικοινωνίας, Πολιτιστικών και Τουριστικών Μονάδων, Aρχειονομίας, Bιβλιοθηκονομίας και Μουσειολογίας, Φωτογραφίας & Οπτικοακουστικών Τεχνών, Ελληνικού και Ευρωπαϊκού Πολιτισμού, Μηχανικών Πληροφορικής Τ.Ε., Φυσικών, Μαθηματικών, Χημικών, Χωροταξίας Πολεοδομίας και Περιφερειακής Ανάπτυξης, Πολιτικών Μηχανικών, Μηχανικών Παραγωγής και Διοίκησης, Μηχανικών Ορυκτών Πόρων Ηλεκτρολόγων Μηχανικών και Μηχανικών Υπολογιστών, Παιδαγωγικών Τμημάτων, Ειδικής Αγωγής, Ιστορίας - Αρχαιολογίας και Κοινωνικής Ανθρωπολογίας, Υδάτινου Περιβάλλοντος, Πολιτικής Επιστήμης και Δημόσιας Διοίκησης, Επικοινωνίας και Μέσων Μαζικής Ενημέρωσης, Επικοινωνίας Μέσων και Πολιτισμού, Θεατρικών Σπουδών, Φιλοσοφίας, Παιδαγωγικής και Ψυχολογίας, Γεωλογίας και Γεωπεριβάλλοντος, Ιστορίας και Φιλοσοφίας της Επιστήμης, Δημόσιας Διοίκησης, Οικονομικής και Περιφερειακής Ανάπτυξης, Κοινωνικών και Πολιτικών Επιστημών, Κοινωνικής Ανθρωπολογίας, Κοινωνιολογίας, Ψυχολογίας ή/και άλλων συναφών με τις κατευθύνσεις ειδικοτήτων), καθώς και πτυχιούχοι Πανεπιστημίων, Πολυτεχνείων ή Πολυτεχνικών Σχολών και ΤΕΙ ή Α.Σ.ΠΑΙ.Τ.Ε. της ημεδαπής, και ομοταγών Ιδρυμάτων ΑΕΙ της αλλοδαπής. " +
                "<b><p style=\"text-align:center;\">Πρόγραμμα Μαθημάτων</p></b>" +
                "Η έναρξη των μαθημάτων θα πραγματοποιηθεί εντός Οκτωβρίου 2019. Οι ώρες διδασκαλίας είναι από 18:00 έως 21:00, τέσσερις ημέρες την εβδομάδα. ";
        text4.setText(Html.fromHtml(text));
        TextView text6 = findViewById(R.id.text6);
        text ="Το ΠΜΣ απονέμει το Δίπλωμα Μεταπτυχιακών Σπουδών (Δ.Μ.Σ.) με τίτλο «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες» (Master of Science (M.Sc.) in «Digital Culture, Smart Cities, IoT and Advanced Digital Technologies»)";
        text6.setText(text);

        TextView programma1 = findViewById(R.id.programma1);
        text="<u>Πρόγραμμα Διδασκαλίας Α' Εξαμήνου (Κατεύθυνση \"Ψηφιακός Πολιτισμός\")</u>";
        programma1.setText(Html.fromHtml(text));
        programma1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/DCSCIOT_Lecture_Programme_V1_5_DC_A_Semester_9.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView programma2 = findViewById(R.id.programma2);
        text="<u>Πρόγραμμα Διδασκαλίας Α' Εξαμήνου (Κατεύθυνση \"Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες\")</u>";
        programma2.setText(Html.fromHtml(text));
        programma2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/DCSCIOT_Lecture_Programme_V1_5_SC_A_Semester_9.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView programma3 = findViewById(R.id.programma3);
        text="<u>Πρόγραμμα Διδασκαλίας Α' Εξαμήνου (Κατεύθυνση \"Διαδίκτυο των Πράγματων (Iot) και Προηγμένες Ψηφιακές Τεχνολογίες\")</u>";
        programma3.setText(Html.fromHtml(text));
        programma3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/DCSCIOT_Lecture_Programme_V1_5_IOT_A_Semester_9.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView programma4 = findViewById(R.id.programma4);
        text="<u>Πρόγραμμα Εξ Αποστάσεως Διαλέξεων Β' Εξαμήνου, από 30/03/2020 έως 03/04/2020 (Όλες οι Κατευθύνσεις)</u>";
        programma4.setText(Html.fromHtml(text));
        programma4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/DCSCIOT_Lecture_Programme_V1_0_All_Tracks_B_Semester_30-03_03-04.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView programma5 = findViewById(R.id.programma5);
        text="<u>Πρόγραμμα Εξ Αποστάσεως Διαλέξεων Β' Εξαμήνου, από 06/04/2020 έως 17/04/2020 (Όλες οι Κατευθύνσεις)</u>";
        programma5.setText(Html.fromHtml(text));
        programma5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/DCSCIOT_Lecture_Programme_V1_0_All_Tracks_B_Semester_06-04_17-04_updated";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView programma6 = findViewById(R.id.programma6);
        text="<u>Ακαδημαϊκό Ημερολόγιο</u>";
        programma6.setText(Html.fromHtml(text));
        programma6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/Ak_Hmerologio_2019-2020.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView underline_virvoy;
        underline_virvoy = (TextView) findViewById(R.id.virvoy);
        text = "<u>Βίρβου Μαρία</u>";
        underline_virvoy.setText(Html.fromHtml(text));


        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));

        TextView underline_mixalas = (TextView) findViewById(R.id.mixalas);
        text = "<u>Μιχάλας Άγγελος</u>";
        underline_mixalas.setText(Html.fromHtml(text));

        TextView underline_pelekis = (TextView) findViewById(R.id.pelekis);
        text = "<u>Πελέκης Νικόλαος</u>";
        underline_pelekis.setText(Html.fromHtml(text));

        TextView underline_anagnwstopoylos_iwannhs = (TextView) findViewById(R.id.anagnwstopoylos_iwannhs);
        text = "<u>Αναγνωστόπουλος Ιωάννης</u>";
        underline_anagnwstopoylos_iwannhs.setText(Html.fromHtml(text));

        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));

        TextView underline_patsakis;
        underline_patsakis = (TextView) findViewById(R.id.patsakis);
        text = "<u>Πατσάκης Κωνσταντίνος</u>";
        underline_patsakis.setText(Html.fromHtml(text));


        TextView underline_karagiwrgoy;
        underline_karagiwrgoy = (TextView) findViewById(R.id.karagiwrgoy);
        text = "<u>Καραγιώργου Σοφία</u>";
        underline_karagiwrgoy.setText(Html.fromHtml(text));

        TextView underline_anagnwstopoylos_xristos;
        underline_anagnwstopoylos_xristos = (TextView) findViewById(R.id.anagnwstopoylos_xristos);
        text = "<u>Αναγνωστόπουλος Χρήστος-Νικόλαος</u>";
        underline_anagnwstopoylos_xristos.setText(Html.fromHtml(text));

        TextView underline_tzixritzis;
        underline_tzixritzis = (TextView) findViewById(R.id.tsixritzis);
        text ="<u>Τσιχριντζής Γεώργιος</u>";
        underline_tzixritzis.setText(Html.fromHtml(text));

        TextView underline_panagiwtopoylos;
        underline_panagiwtopoylos = (TextView) findViewById(R.id.panagiwtopoylos);
        text = "<u>Παναγιωτόπουλος Θεμιστοκλής</u>";
        underline_panagiwtopoylos.setText(Html.fromHtml(text));

        TextView underline_alephs;
        underline_alephs = (TextView) findViewById(R.id.alepis);
        text = "<u>Αλέπης Ευθύμιος</u>";
        underline_alephs.setText(Html.fromHtml(text));

        TextView underline_tsikoyras;
        underline_tsikoyras = (TextView) findViewById(R.id.tsikoyras);
        text = "<u>Τσικούρας Παναγιώτης-Γεώργιος</u>";
        underline_tsikoyras.setText(Html.fromHtml(text));

        TextView underline_katsiwnis;
        underline_katsiwnis = (TextView) findViewById(R.id.katsiwnhs);
        text = "<u>Κατσιώνης Γεώργιος</u>";
        underline_katsiwnis.setText(Html.fromHtml(text));


        TextView underline_kwnstantopoylos;
        underline_kwnstantopoylos = (TextView) findViewById(R.id.kwnstantopoylos);
        text = "<u>Κωνσταντόπουλος Χαράλαμπος</u>";
        underline_kwnstantopoylos.setText(Html.fromHtml(text));




        TextView underline_meta3iwths;
        underline_meta3iwths = (TextView) findViewById(R.id.meta3iwths);
        text = "<u>Μεταξιώτης Κωνσταντίνος</u>";
        underline_meta3iwths.setText(Html.fromHtml(text));

        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_liagkoyras;
        underline_liagkoyras = (TextView) findViewById(R.id.liagkoyras);
        text = "<u>Λιαγκούρας Κωνσταντίνος</u>";
        underline_liagkoyras.setText(Html.fromHtml(text));

        TextView underline_kanatoyla;
        underline_kanatoyla = (TextView) findViewById(R.id.kanatoyla);
        text = "<u>Κανατούλα Αικατερίνη</u>";
        underline_kanatoyla.setText(Html.fromHtml(text));

        TextView underline_papadomixelaki;
        underline_papadomixelaki = (TextView) findViewById(R.id.papadomixelaki);
        text = "<u>Παπαδομιχελάκη Ξένη</u>";
        underline_papadomixelaki.setText(Html.fromHtml(text));

        TextView underline_swthropoylos;
        underline_swthropoylos = (TextView) findViewById(R.id.swthropoylos);
        text = "<u>Σωτηρόπουλος Διονύσιος</u>";
        underline_swthropoylos.setText(Html.fromHtml(text));

        TextView underline_kalogeraki;
        underline_kalogeraki = (TextView) findViewById(R.id.kalogeraki);
        text = "<u>Καλογεράκη Ελένη - Μαρία</u>";
        underline_kalogeraki.setText(Html.fromHtml(text));

        TextView underline_skondras;
        underline_skondras = (TextView) findViewById(R.id.skondras);
        text = "<u>Σκόνδρας Εμμανουήλ</u>";
        underline_skondras.setText(Html.fromHtml(text));

        TextView underline_diala;
        underline_diala = (TextView) findViewById(R.id.diala);
        text = "<u>Διάλλα Άντα</u>";
        underline_diala.setText(Html.fromHtml(text));

        TextView underline_filippakis;
        underline_filippakis = (TextView) findViewById(R.id.filippakis);
        text = "<u>Φιλιππάκης Μιχαήλ</u>";
        underline_filippakis.setText(Html.fromHtml(text));

        TextView underline_vergados_dimitris;
        underline_vergados_dimitris = (TextView) findViewById(R.id.vergados_dimitris);
        text = "<u>Δημήτριος Ι. Βέργαδος</u>";
        underline_vergados_dimitris.setText(Html.fromHtml(text));

        TextView underline_tasoylas;
        underline_tasoylas = (TextView) findViewById(R.id.tasoylas);
        text = "<u>Τασούλας Ιωάννης</u>";
        underline_tasoylas.setText(Html.fromHtml(text));

        TextView psyxogios;
        psyxogios = (TextView) findViewById(R.id.psyxogios);
        text = "<u>Ψυχογιός Δημήτριος</u>";
        psyxogios.setText(Html.fromHtml(text));

        TextView stefanoy_iwsif;
        stefanoy_iwsif = (TextView) findViewById(R.id.stefanoy_iwsif);
        text = "<u>Στεφάνου Ιωσήφ</u>";
        stefanoy_iwsif.setText(Html.fromHtml(text));

        TextView underline_Fran ;
        underline_Fran = (TextView) findViewById(R.id.casino);
        text = "<u>Fran Casino</u>";
        underline_Fran.setText(Html.fromHtml(text));

        TextView underline_androylidaki;
        underline_androylidaki = (TextView) findViewById(R.id.androylidaki);
        text = "<u>Ανδρουλιδάκη Αμαλία</u>";
        underline_androylidaki.setText(Html.fromHtml(text));

        TextView underline_vagena;
        underline_vagena = (TextView) findViewById(R.id.vagena);
        text = "<u>Βαγενά Ευαγγελία</u>";
        underline_vagena.setText(Html.fromHtml(text));

        TextView underline_vasilara;
        underline_vasilara = (TextView) findViewById(R.id.vasilara);
        text = "<u>Βασιλαρά Αρχοντούλα</u>";
        underline_vasilara.setText(Html.fromHtml(text));

        TextView underline_grigorarakis;
        underline_grigorarakis = (TextView) findViewById(R.id.grigorakis);
        text = "<u>Γρηγορακάκης Γρήγορης</u>";
        underline_grigorarakis.setText(Html.fromHtml(text));

        TextView underline_dasaklis;
        underline_dasaklis = (TextView) findViewById(R.id.dasaklis);
        text = "<u>Θωμάς Δασακλής</u>";
        underline_dasaklis.setText(Html.fromHtml(text));

        TextView underline_kakavas;
        underline_kakavas = (TextView) findViewById(R.id.kakavas);
        text = "<u>Κακαβάς Γεώργιος</u>";
        underline_kakavas.setText(Html.fromHtml(text));

        TextView underline_kakoylidoy;
        underline_kakoylidoy = (TextView) findViewById(R.id.kakoylidoy);
        text = "<u>Κακουλίδου Αλίκη</u>";
        underline_kakoylidoy.setText(Html.fromHtml(text));

        TextView underline_karamitsanis;
        underline_karamitsanis = (TextView) findViewById(R.id.karamitsanis);
        text = "<u>Καραμητσάνης Βασίλειος</u>";
        underline_karamitsanis.setText(Html.fromHtml(text));

        TextView underline_kotswnis;
        underline_kotswnis = (TextView) findViewById(R.id.kotswnis);
        text = "<u>Κοτσώνης Ιωάννης</u>";
        underline_kotswnis.setText(Html.fromHtml(text));

        TextView underline_linaki;
        underline_linaki = (TextView) findViewById(R.id.linaki);
        text = "<u>Λινάκη Ε.</u>";
        underline_linaki.setText(Html.fromHtml(text));

        TextView underline_magginis;
        underline_magginis = (TextView) findViewById(R.id.magginis);
        text = "<u>Μαγγίνης Γεώργιος</u>";
        underline_magginis.setText(Html.fromHtml(text));

        TextView underline_myridakis;
        underline_myridakis = (TextView) findViewById(R.id.myridakis);
        text = "<u>Μυριδάκης Νικόλαος</u>";
        underline_myridakis.setText(Html.fromHtml(text));

        TextView underline_oikonomoy;
        underline_oikonomoy = (TextView) findViewById(R.id.oikonomoy);
        text = "<u>Οικονόμου Αγησίλαος</u>";
        underline_oikonomoy.setText(Html.fromHtml(text));

        TextView underline_pantelis;
        underline_pantelis = (TextView) findViewById(R.id.pantelis);
        text = "<u>Πάνος Παντελής</u>";
        underline_pantelis.setText(Html.fromHtml(text));

        TextView underline_papapanagiwtoy;
        underline_papapanagiwtoy = (TextView) findViewById(R.id.papapanagiwtoy);
        text = "<u>Παπαπαναγιώτου Σταύρος</u>";
        underline_papapanagiwtoy.setText(Html.fromHtml(text));

        TextView underline_rappas;
        underline_rappas = (TextView) findViewById(R.id.rappas);
        text = "<u>Ράππας Παναγιώτης</u>";
        underline_rappas.setText(Html.fromHtml(text));

        TextView underline_rwmanoy;
        underline_rwmanoy = (TextView) findViewById(R.id.rwmanoy);
        text = "<u>Ρωμάνου Χριστίνα</u>";
        underline_rwmanoy.setText(Html.fromHtml(text));

        TextView underline_sioyntri;
        underline_sioyntri = (TextView) findViewById(R.id.sioyntri);
        text = "<u>Σιούντρη Κωνσταντίνα</u>";
        underline_sioyntri.setText(Html.fromHtml(text));

        TextView underline_skondras1;
        underline_skondras1 = (TextView) findViewById(R.id.skondras1);
        text = "<u>Σκόνδρας Εμμανουήλ</u>";
        underline_skondras1.setText(Html.fromHtml(text));

        TextView underline_stefanoy;
        underline_stefanoy = (TextView) findViewById(R.id.stefanoy_vasilia);
        text = "<u>Στεφάνου Βασιλεία</u>";
        underline_stefanoy.setText(Html.fromHtml(text));

        TextView underline_syris;
        underline_syris = (TextView) findViewById(R.id.syris);
        text = "<u>Συρρής Νικόλαος</u>";
        underline_syris.setText(Html.fromHtml(text));

        TextView underline_xatzigrigorioy;
        underline_xatzigrigorioy = (TextView) findViewById(R.id.xatzigrigorioy);
        text = "<u>Χατζηγρηγορίου Παύλος</u>";
        underline_xatzigrigorioy.setText(Html.fromHtml(text));

        TextView underline_zoymi;
        underline_zoymi = (TextView) findViewById(R.id.zoymi);
        text = "<u>Ζουμή Ειρήνη</u>";
        underline_zoymi.setText(Html.fromHtml(text));


        TextView text14 = findViewById(R.id.text14);
        text="\n" +
                "Στο Π.Μ.Σ. γίνονται δεκτοί κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν.4485/2017. Περισσότερες πληροφορίες μπορείτε να αναζητήσετε ενδεικτικά σε κάθε Ειδίκευση/Κατεύθυνση του Π.Μ.Σ. http://www.cs.unipi.gr/dcsciot" +
                "<br><br><b>Σε ποιους απευθύνεται η Ειδίκευση/Κατεύθυνση «Ψηφιακός Πολιτισμός» - «Digital Culture»</b>" +
                "<br>Στην Ειδίκευση/Κατεύθυνση «Ψηφιακός Πολιτισμός» - «Digital Culture» γίνονται δεκτοί κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν.4485/2017, ενδεικτικά: Τμημάτων/Σχολών Τεχνολογιών Πληροφορικής και Επικοινωνιών, Αρχιτεκτόνων Μηχανικών, Πολεοδόμων, Ανθρωπιστικών Επιστημών, Θετικών Επιστημών ή Τεχνολογικών Επιστημών, Μηχανικών, Καλών Τεχνών, Γεωπονικών Επιστημών, Φιλοσοφικής Σχολής, Παιδαγωγικών, Θεολογικής, Οικονομικών και Κοινωνικών Επιστημών, Μηχανικών Πολυτεχνείων ή Πολυτεχνικών Σχολών, Μηχανικών Περιβάλλοντος, Νομικών Επιστημών, Τμημάτων Πληροφορικής, Τεχνών Ήχου & Εικόνας, Πολιτισμικής Τεχνολογίας & Επικοινωνίας, Τμημάτων Τεχνολογιών Πληροφορικής και Επικοινωνιών, Διαχείρισης Πολιτισμικού Περιβάλλοντος και Νέων Τεχνολογιών, Επικοινωνίας Μέσων και Πολιτισμού, Ψηφιακών Μέσων, Επικοινωνίας και Πολιτισμικής Διαχείρισης, Συντηρητών Αρχαιοτήτων & Έργων Τέχνης, Ιστορικών και Αρχαιολόγων, Γραφιστικής, Πληροφορικής και Μέσων Μαζικής Ενημέρωσης, Διοίκησης - Οικονομίας και Επικοινωνίας, Πολιτιστικών και Τουριστικών Μονάδων, Aρχειονομίας, Bιβλιοθηκονομίας και Μουσειολογίας, Φωτογραφίας & Οπτικοακουστικών Τεχνών, Ελληνικού και Ευρωπαϊκού Πολιτισμού, Μηχανικών Πληροφορικής Τ.Ε., Φυσικών, Μαθηματικών, Χημικών, Χωροταξίας Πολεοδομίας και Περιφερειακής Ανάπτυξης, Πολιτικών Μηχανικών, Μηχανικών Παραγωγής και Διοίκησης, Ηλεκτρολόγων Μηχανικών και Μηχανικών Υπολογιστών, Παιδαγωγικών Τμημάτων, Ειδικής Αγωγής, Ιστορίας - Αρχαιολογίας και Κοινωνικής Ανθρωπολογίας, Πολιτικής Επιστήμης και Δημόσιας Διοίκησης, Επικοινωνίας και Μέσων Μαζικής Ενημέρωσης, Επικοινωνίας Μέσων και Πολιτισμού, Θεατρικών Σπουδών, Φιλοσοφίας, Παιδαγωγικής και Ψυχολογίας, Ιστορίας και Φιλοσοφίας της Επιστήμης, Δημόσιας Διοίκησης, Οικονομικής και Περιφερειακής Ανάπτυξης, Κοινωνικών και Πολιτικών Επιστημών, Κοινωνικής Ανθρωπολογίας, Κοινωνιολογίας, Ψυχολογίας ή/και άλλων συναφών με τις κατευθύνσεις ειδικοτήτων, καθώς και πτυχιούχοι Πανεπιστημίων, Πολυτεχνείων ή Πολυτεχνικών Σχολών και ΤΕΙ ή Α.Σ.ΠΑΙ.Τ.Ε. της ημεδαπής, και ομοταγών Ιδρυμάτων ΑΕΙ της αλλοδαπής." +
                "<br><br><b>Σε ποιους απευθύνεται η Ειδίκευση/Κατεύθυνση «Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες» - «Smart Cities and Advanced Digital Technologies»</b>" +
                "<br>Στην Ειδίκευση/Κατεύθυνση «Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες» - «Smart Cities and Advanced Digital Technologies» γίνονται δεκτοί κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν.4485/2017, ενδεικτικά και ανάλογα με την ειδίκευση: Τμημάτων/Σχολών Τεχνολογιών Πληροφορικής και Επικοινωνιών, Μηχανικών, Αρχιτεκτόνων Μηχανικών, Πολεοδόμων, Θετικών Επιστημών ή Τεχνολογικών Επιστημών, Παιδαγωγικών, Γεωπονικών Επιστημών, Ναυτιλίας και Βιομηχανίας, Μηχανικών Πολυτεχνείων ή Πολυτεχνικών Σχολών, Μηχανικών Περιβάλλοντος, Μηχανικών Πληροφορικής Τ.Ε., Φυσικών, Μαθηματικών, Χημικών, Χωροταξίας Πολεοδομίας και Περιφερειακής Ανάπτυξης, Πολιτικών Μηχανικών, Μηχανικών Παραγωγής και Διοίκησης, Ανθρωπιστικών Επιστημών, Οικονομικών και Κοινωνικών Επιστημών, Οικονομικών - Επιχειρηματικών και Διεθνών Σπουδών, Κοινωνικών Επιστημών, Νομικών Επιστημών, Τμημάτων Πληροφορικής, Τμημάτων Τεχνολογιών Πληροφορικής και Επικοινωνιών, Γεωλογίας και Γεωπεριβάλλοντος, Διαχείρισης Πολιτισμικού Περιβάλλοντος και Νέων Τεχνολογιών, Επικοινωνίας Μέσων και Πολιτισμού, Ψηφιακών Μέσων, Τεχνών Ήχου & Εικόνας, Πολιτισμικής Τεχνολογίας & Επικοινωνίας, Επικοινωνίας και Πολιτισμικής Διαχείρισης, Γραφιστικής, Πληροφορικής και Μέσων Μαζικής Ενημέρωσης, Διοίκησης - Οικονομίας και Επικοινωνίας, Πολιτιστικών και Τουριστικών Μονάδων, Aρχειονομίας, Ηλεκτρολόγων Μηχανικών και Μηχανικών Υπολογιστών, Φιλοσοφικής Σχολής, Παιδαγωγικών Τμημάτων, Υδάτινου Περιβάλλοντος, Πολιτικής Επιστήμης και Δημόσιας Διοίκησης, Επικοινωνίας και Μέσων Μαζικής Ενημέρωσης, Επικοινωνίας Μέσων και Πολιτισμού, Δημόσιας Διοίκησης, Οικονομικής και Περιφερειακής Ανάπτυξης, Bιβλιοθηκονομίας και Μουσειολογίας, Μηχανικών Ορυκτών Πόρων ή/και άλλων συναφών με τις κατευθύνσεις ειδικοτήτων), καθώς και πτυχιούχοι Πανεπιστημίων, Πολυτεχνείων ή Πολυτεχνικών Σχολών και ΤΕΙ ή Α.Σ.ΠΑΙ.Τ.Ε. της ημεδαπής, και ομοταγών Ιδρυμάτων ΑΕΙ της αλλοδαπής." +
                "<br><br><b>Σε ποιους απευθύνεται η Ειδίκευση/Κατεύθυνση «Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες» - «Internet of Things (IoT) and Advanced Digital Technologies»</b>" +
                "<br>Στην κατεύθυνση «Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες» - «Internet of Things (IoT) and Advanced Digital Technologies» γίνονται δεκτοί κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν.4485/2017, ενδεικτικά και ανάλογα με την ειδίκευση: Τμημάτων/Σχολών Πληροφορικής, Τεχνολογιών Πληροφορικής και Επικοινωνιών, Επιστήμης Υπολογιστών, Ηλεκτρολόγων Μηχανικών και Μηχανικών Υπολογιστών, Ηλεκτρονικών Μηχανικών Ηλεκτρονικών Υπολογιστών, Μηχανικών Πληροφοριακών και Επικοινωνιακών Συστημάτων, Μηχανικών Ηλεκτρονικών Υπολογιστών και Τεχνολογίας Υπολογιστών, Μηχανικών Πολυτεχνείων ή Πολυτεχνικών Σχολών, Θετικών Επιστημών ή Τεχνολογικών Επιστημών, Μηχανικών Πληροφορικής Τ.Ε., Μηχανικών Τ.Ε., Μηχανικών Χωροταξίας Πολεοδομίας και Περιφερειακής Ανάπτυξης, Πολεοδόμων, Μηχανικών Περιβάλλοντος, Γεωπονικών Επιστημών, Πολιτικών Μηχανικών, Αρχιτεκτόνων Μηχανικών, Μηχανολόγων Μηχανικών, Φυσικών, Μαθηματικών, Γεωλογίας και Γεωπεριβάλλοντος, Μηχανικών Παραγωγής και Διοίκησης, Ναυτιλίας και Βιομηχανίας, Τμημάτων Ψηφιακών Μέσων, Τεχνών Ήχου & Εικόνας, Πολιτισμικής Τεχνολογίας & Επικοινωνίας, Διαχείρισης Πολιτισμικού Περιβάλλοντος και Νέων Τεχνολογιών ή /και άλλων συναφών με την κατεύθυνση ειδικοτήτων, καθώς και πτυχιούχοι Πανεπιστημίων, Πολυτεχνείων ή Πολυτεχνικών Σχολών και ΤΕΙ ή Α.Σ.ΠΑΙ.Τ.Ε. της ημεδαπής, και ομοταγών Ιδρυμάτων ΑΕΙ της αλλοδαπής.";
        text14.setText(Html.fromHtml(text));

        TextView text16 = findViewById(R.id.text16);
        text="<u>Πατήστε εδώ για να κάνετε ηλεκτρονική υποβολή αίτησης</u>";
        text16.setText(Html.fromHtml(text));
        text16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/registration/dicul.php";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text17 = findViewById(R.id.text17);
        text="<u>Πρόσκληση υποβολής αιτήσεων για το ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\", 2020-2021</u>";
        text17.setText(Html.fromHtml(text));
        text17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prokirixi-pms-dcsciot.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text18 = findViewById(R.id.text18);
        text="<u>Έντυπο αίτησης για το ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\", 2020-2021</u><br><br>";
        text18.setText(Html.fromHtml(text));
        text18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/aitisi-pms-dcsciot.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView eggrafa1 = findViewById(R.id.eggrafa1);
        text="<u>Πρόσκληση υποβολής αιτήσεων για το ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\", 2020-2021</u><br><br>";
        eggrafa1.setText(Html.fromHtml(text));
        eggrafa1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prokirixi-pms-dcsciot.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView eggrafa2 = findViewById(R.id.eggrafa2);
        text="<u>Έντυπο αίτησης για το ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\", 2020-2021</u><br><br>";
        eggrafa2.setText(Html.fromHtml(text));
        eggrafa2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/aitisi-pms-dcsciot.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView eggrafa3 = findViewById(R.id.eggrafa3);
        text="<u>Ίδρυση ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\"</u><br><br>";
        eggrafa3.setText(Html.fromHtml(text));
        eggrafa3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/IDRYSH_dcsciot.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });
        TextView eggrafa4 = findViewById(R.id.eggrafa4);
        text="<u>Κανονισμός ΠΜΣ \"Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες\"</u><br><br>";
        eggrafa4.setText(Html.fromHtml(text));
        eggrafa4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/Kanonismos_dcsciot.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });



    }
    void create_metaptyxiako_3o() {
        setContentView(R.layout.activity_metaptyxiako3o);

        TextView aithshs = findViewById(R.id.entypo_aithshs);
        String text="<u>Έντυπο Αίτησης</u><br><br>";
        aithshs.setText(Html.fromHtml(text));
        aithshs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/aitisi-pms-distributed.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView prokhry3i = findViewById(R.id.prokhry3i);
        text="<u>Προκήρυξη</u><br><br>";
        prokhry3i.setText(Html.fromHtml(text));
        prokhry3i.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prokirixi-pms-distributed.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text16 = findViewById(R.id.text16);
        text="<u>Πατήστε εδώ για να κάνετε ηλεκτρονική υποβολή αίτησης</u>";
        text16.setText(Html.fromHtml(text));
        text16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/registration/distributed.php";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text17 = findViewById(R.id.text17);
        text="<u>Πρόσκληση υποβολής αιτήσεων για το ΠΜΣ \"Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας\", 2020-2021</u>";
        text17.setText(Html.fromHtml(text));
        text17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prokirixi-pms-distributed.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text18 = findViewById(R.id.text18);
        text="<u>Έντυπο αίτησης για το ΠΜΣ \"Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας\", 2020-2021</u>";
        text18.setText(Html.fromHtml(text));
        text18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/aitisi-pms-distributed.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text19 = findViewById(R.id.text19);
        text="Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς προσκαλεί υποψηφίους μεταπτυχιακούς φοιτητές για υποβολή αιτήσεων με σκοπό τη συμμετοχή στα Προγράμματα Μεταπτυχιακών Σπουδών (ΠΜΣ):" +
                "<b>\"Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας\" που διοργανώνει για τον ακαδημαϊκό κύκλο 2020-2021." +
                "<br><br>Το ΠΜΣ \"Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας\" </b>" +
                "(“Distributed Systems, Security and Emerging Information Technologies”) έχει διάρκεια τριών (3) ακαδημαϊκών εξαμήνων (δυο (2) ακαδημαϊκών εξαμήνων παρακολούθησης μεταπτυχιακών μαθημάτων και ενός (1) ακαδημαϊκού εξαμήνου εκπόνησης μεταπτυχιακής διατριβής) και απονέμει Μεταπτυχιακό Δίπλωμα Ειδίκευσης (ΜΔΕ) στα «Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας» στις εξής κατευθύνσεις: " +
                "<br><br>α) Διάχυτα Υπολογιστικά Συστήματα και Αρχιτεκτονικές / Pervasive Computing Systems and Architectures (ΔΥΣΑ/PCSA).<br>" +
                "β) Τεχνολογίες και Διαχείριση Ασφάλειας Υπολογιστικών Συστημάτων / Computing Systems Security Management and Engineering (ΤΕΔΑ/CSSME). " +
                "<br>γ) Επιχειρηματική Αναλυτική και Αναδυόμενες Τεχνολογίες Πληροφορίας / Business Analytics and Emerging Information Technologies (ΕΑΑΤΠ/BAEIT)." +
                "<br><br>Στο ΠΜΣ γίνονται δεκτοί, μετά από επιλογή, κάτοχοι τίτλου πρώτου κύκλου σπουδών Α.Ε.Ι. της ημεδαπής ή ομοταγών ιδρυμάτων της αλλοδαπής σύμφωνα με τις διατάξεις του άρθρου 34 του ν. 4485/2017, κατά προτεραιότητα πτυχιούχοι Τμημάτων Πληροφορικής, Σχολών Τεχνολογιών Πληροφορικής και Επικοινωνιών, Πολυτεχνείων ή Πολυτεχνικών Σχολών, Τμημάτων Θετικών Επιστημών Πανεπιστημίων, Μηχανικών Πληροφορικής Τ.Ε., Μηχανικών Τ.Ε., Σχολών Θετικών ή Τεχνολογικών Επιστημών ή/και άλλων συναφών με τις κατευθύνσεις ειδικοτήτων. Η έναρξη των μαθημάτων θα πραγματοποιηθεί εντός Οκτωβρίου 2019." +
                "<br><br>Οι ενδιαφερόμενοι μπορούν να υποβάλουν αιτήσεις<b> από 19 Μαρτίου 2020 έως και 30 Ιουνίου 2020.</b>" +
                "<br><br>Οι υποψήφιοι πρέπει να υποβάλουν ηλεκτρονικά την αίτηση στον διαδικτυακό τόπο: http://www.cs.unipi.gr/registration/distributed.php και να αποστείλουν την αίτηση και τα κάτωθι δικαιολογητικά αναγράφοντας το Ονοματεπώνυμό τους στο e-mail psp@unipi.gr. Οι αιτήσεις γίνονται δεκτές και ταχυδρομικώς εφόσον αποσταλούν προς το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς, μέχρι την καταληκτική ημερομηνία. Τα σχετικά έγγραφα είναι τα ακόλουθα:" +
                "<ul><li>Συμπληρωμένη αίτηση εγγραφής στο Π.Μ.Σ. Το έντυπο της αίτησης παρέχεται από τη Γραμματεία του Τμήματος Πληροφορικής και τους δικτυακούς τόπους του Τμήματος: http://www.cs.unipi.gr/  (ανακοίνωση «Πρόσκληση Υποβολής Αιτήσεων»)</li>" +
                "<li>Αντίγραφο πτυχίου ελληνικού ΑΕΙ ή ΑΤΕΙ (νόμιμα επικυρωμένου), ή αντίγραφο πτυχίου ανώτατου ιδρύματος της αλλοδαπής αναγνωρισμένο από το ΔΟΑΤΑΠ (πρώην ΔΙΚΑΤΣΑ). </li>" +
                "<li>Πιστοποιητικό αναλυτικής βαθμολογίας προπτυχιακών μαθημάτων στην οποία να αναγράφεται και ο βαθμός του πτυχίου, ή να προκύπτει  η βαθμολογία του υποψηφίου μέχρι την ημέρα της αίτησης. </li>" +
                "<li>Πιστοποιητικά γνώσης της Αγγλικής γλώσσας ή/και άλλων γλωσσών εάν υπάρχουν. Σε περίπτωση μη προσκόμισης από υποψήφιο πιστοποιητικού γνώσης Αγγλικής, η Επιτροπή Επιλογής θα αξιολογήσει το επίπεδο γνώσης Αγγλικής του υποψηφίου.</li" +
                "<li>Πλήρες βιογραφικό σημείωμα.</li>" +
                "<li>Αντίγραφα από τυχόν άλλα πτυχία ΑΕΙ ή ΑΤΕΙ ή αντίστοιχου ιδρύματος της αλλοδαπής, αναγνωρισμένα από το ΔΟΑΤΑΠ. (πρώην ΔΙΚΑΤΣΑ).</li>" +
                "<li>Ανάτυπα δημοσιεύσεων σε επιστημονικά περιοδικά, συνέδρια ή ανάτυπα άλλου συγγραφικού έργου.</li>" +
                "<li>Πιστοποιητικά προϋπηρεσίας και επαγγελματικού έργου.</li>" +
                "<li>Κάθε άλλο πιστοποιητικό για έργο ή δραστηριότητα που μπορεί να βοηθήσει στην επιλογή του υποψηφίου.</li>" +
                "<li>Φωτοτυπία της αστυνομικής ταυτότητας ή του διαβατηρίου.</li>" +
                "<li>Μία πρόσφατη φωτογραφία, η οποία επισυνάπτεται στην αίτηση του υποψηφίου.</li>" +
                "<li>Δύο Συστατικές Επιστολές.</li></ul>" +
                "Περισσότερες πληροφορίες μπορείτε να αναζητήσετε στην ηλεκτρονική διεύθυνση του Μεταπτυχιακού \"Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας\": http://www.cs.unipi.gr/distributed" +
                "<br><br><u>Κριτήρια επιλογής για την αξιολόγηση και κατάταξη υποψηφίων του ΠΜΣ«Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας»</u>" +
                "<br><br>Η επιλογή των εισακτέων πραγματοποιείται από Επιτροπή μελών ΔΕΠ (Επιτροπή Επιλογής), που συγκροτείται με απόφαση της Συνέλευσης. Τα κριτήρια επιλογής καθώς και οι λεπτομέρειες εφαρμογής των κριτηρίων αυτών (όπως μόρια, συντελεστές) γίνονται γνωστά στους υποψηφίους με την προκήρυξη του ΠΜΣ και είναι τα ακόλουθα:" +
                "<br><br>1. Βαθμός πτυχίου (30%)<br>2. Συνάφεια του Τμήματος προέλευσης με το ΠΜΣ (20%)<br>3. Είδος και εύρος εργασιακής ή/και ερευνητικής εμπειρίας (10%)<br>4. Συστατικές επιστολές από μέλη ∆ΕΠ ΑΕΙ ή / και από εργοδότη (10%)" +
                "<br>5. Γνώση Αγγλικής γλώσσας (10%)<br>6. Συνέντευξη (20%)<br><br>" +
                "Η συμπληρωμένη αίτηση με τα σχετικά δικαιολογητικά υποβάλλονται σε έντυπη μορφή καθημερινά, Δευτέρα, Τρίτη, Πέμπτη από 09:00 έως 17:00 και Τετάρτη από 09:00 έως 20:00 Παρασκευή από 09:00 έως 14:00, στην παρακάτω διεύθυνση.<br><br>";
                text19.setText(Html.fromHtml(text));

        TextView underline_doyligeris;
        underline_doyligeris = (TextView) findViewById(R.id.doyligeris);
        text = "<u>Δουληγέρης Χρήστος</u>";
        underline_doyligeris.setText(Html.fromHtml(text));

        TextView underline_liagkoyras;
        underline_liagkoyras = (TextView) findViewById(R.id.liagkoyras);
        text = "<u>Λιαγκούρας Κωνσταντίνος</u>";
        underline_liagkoyras.setText(Html.fromHtml(text));

        TextView underline_vergados;
        underline_vergados = (TextView) findViewById(R.id.vergados);
        text = "<u>Βέργαδος Δημήτριος</u>";
        underline_vergados.setText(Html.fromHtml(text));

        TextView underline_mixalas = (TextView) findViewById(R.id.mixalas);
        text = "<u>Μιχάλας Άγγελος</u>";
        underline_mixalas.setText(Html.fromHtml(text));

        TextView underline_pelekis = (TextView) findViewById(R.id.pelekis);
        text = "<u>Πελέκης Νικόλαος</u>";
        underline_pelekis.setText(Html.fromHtml(text));


        TextView underline_pikrakis;
        underline_pikrakis = (TextView) findViewById(R.id.pikrakis);
        text = "<u>Πικράκης Άγγελος</u>";
        underline_pikrakis.setText(Html.fromHtml(text));

        TextView underline_theodwridis;
        underline_theodwridis = (TextView) findViewById(R.id.theodwridis);
        text = "<u>Θεοδωρίδης Ιωάννης</u>";
        underline_theodwridis.setText(Html.fromHtml(text));





        TextView underline_polemi;
        underline_polemi = (TextView) findViewById(R.id.polemi);
        text ="<u>Πολέμη Δέσποινα</u>";
        underline_polemi.setText(Html.fromHtml(text));

        TextView underline_apostoloy;
        underline_apostoloy = (TextView) findViewById(R.id.apostoloy);
        text ="<u>Αποστόλου Δημήτριος</u>";
        underline_apostoloy.setText(Html.fromHtml(text));

        TextView underline_despotis;
        underline_despotis = (TextView) findViewById(R.id.despotis);
        text ="<u>Δεσπότης Δημήτριος</u>";
        underline_despotis.setText(Html.fromHtml(text));

        TextView underline_kotza;
        underline_kotza = (TextView) findViewById(R.id.kotzanikolaoy);
        text ="<u>Κοτζανικολάου Παναγιώτης</u>";
        underline_kotza.setText(Html.fromHtml(text));

        TextView underline_patsakis;
        underline_patsakis = (TextView) findViewById(R.id.patsakis);
        text ="<u>Πατσάκης Κωνσταντίνος</u>";
        underline_patsakis.setText(Html.fromHtml(text));

        TextView underline_psarakis;
        underline_psarakis = (TextView) findViewById(R.id.psarakis);
        text ="<u>Ψαράκης Μιχαήλ</u>";
        underline_psarakis.setText(Html.fromHtml(text));




    }
    void create_metaptyxiako_4o() {
        setContentView(R.layout.activity_metaptyxiako4o);

        TextView text2 = findViewById(R.id.text2);
        String text ="<b>Συνοπτική Παρουσίαση του ΠΜΣ \"Πληροφορική\"</b>" +
                "<br><br>Το Πρόγραμμα Μεταπτυχιακών Σπουδών στην «Πληροφορική» έχει ως αντικείμενο την άρτια και υψηλού επιπέδου εκπαίδευση αποφοίτων τμημάτων ΑΕΙ και ΑΤΕΙ διαφόρων επιστημονικών ειδικοτήτων στις αρχές και μεθοδολογίες εφαρμογής της σύγχρονης επιστήμης της Πληροφορικής,<br><br>" +
                "Το Πρόγραμμα Μεταπτυχιακών Σπουδών στην «Πληροφορική» θεραπεύει σύγχρονα ζητήματα τεχνολογίας και εφαρμογών της επιστήμης της Πληροφορικής σε άλλες σύγχρονες επιστήμες. Το περιεχόμενο και η φυσιογνωμία του προγράμματος έχει διαμορφωθεί έτσι ώστε να ανταποκρίνεται με επιτυχία στις ιδιαίτερες επιστημονικές ανάγκες που προκαλεί η ταχύτατη εξέλιξη της Πληροφορικής και των εφαρμογών της σε ευρωπαϊκό και διεθνές επίπεδο.";
        text2.setText(Html.fromHtml(text));

        TextView text4 = findViewById(R.id.text4);
        text = "Η ενδυνάμωση του διεπιστημονικού χαρακτήρα της Πληροφορικής και η σύνδεσή της με άλλες επιστήμες με στόχο τόσο την ανάπτυξη υψηλού επιπέδου γνώσεων Πληροφορικής σε επιστήμονες άλλων ειδικοτήτων, όσο και η τροφοδότηση της ίδιας της Πληροφορικής με νέα επιστημονικά πεδία βασικής έρευνας και ανάπτυξης εφαρμογών." +
                "<ul><li>Η προετοιμασία και εκπαίδευση καταρτισμένων και ικανών επιστημόνων και ερευνητών που θα προωθήσουν την ανάπτυξη της χώρας.</li>" +
                "<li>Η προετοιμασία για μεταπτυχιακές σπουδές διδακτορικού επιπέδου.</li>" +
                "<li>Η ανάπτυξη και διάχυση της Εφαρμοσμένης Πληροφορικής στον Ελλαδικό χώρο.</li>" +
                "<li>Η στενή συνεργασία μεταξύ της Ακαδημαϊκής Κοινότητας και των Επιχειρήσεων για την αποδοχή, χρήση και διάδοση των συστημάτων Πληροφορικής.</li>" +
                "<li>Η συνεργασία με Ελληνικούς, Ευρωπαϊκούς και Διεθνείς Επιστημονικούς Οργανισμούς, που ασχολούνται με θέματα Πληροφορικής.</li></ul>";
        text4.setText(Html.fromHtml(text));


        TextView text16 = findViewById(R.id.text16);
        text = "<u>Πατήστε εδώ για να κάνετε ηλεκτρονική υποβολή αίτησης</u>";
        text16.setText(Html.fromHtml(text));
        text16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/registration/request1.php";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text17 = findViewById(R.id.text17);
        text = "<u>Νέα πρόσκληση υποβολής αιτήσεων για το ΠΜΣ Πληροφορική, 2020-2022</u>";
        text17.setText(Html.fromHtml(text));
        text17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/MSc_In_Informatics_2020-2022_.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView text18 = findViewById(R.id.text18);
        text = "<u>Έντυπο αίτησης για το ΠΜΣ Πληροφορική, 2020-2022</u>";
        text18.setText(Html.fromHtml(text));
        text18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/129_aitisi_informatics2020.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView orologio1 = findViewById(R.id.orologio1);
        text = "<u>Ωρολόγιο πρόγραμμα B' Εξαμήνου (12ος κύκλος)</u>";
        orologio1.setText(Html.fromHtml(text));
        orologio1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prog_b_eksaminou_12os_kiklos_FINAL_.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView orologio2 = findViewById(R.id.orologio2);
        text = "<u>Ωρολόγιο πρόγραμμα B' Εξαμήνου (12ος κύκλος)</u>";
        orologio2.setText(Html.fromHtml(text));
        orologio2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/prog_d_eksaminou_11os_kiklos_FINAL_.pdf";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

        TextView eggrafa1 = findViewById(R.id.eggrafa1);
        text = "<u>Υπόδειγμα Διατριβής</u>";
        eggrafa1.setText(Html.fromHtml(text));
        eggrafa1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/dissertation_informatics.doc";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
        });

    }
    void create_metaptyxiako_5o() {
        setContentView(R.layout.activity_metaptyxiako5o);


    }
    void create_metaptyxiako_6o() {
        setContentView(R.layout.activity_metaptyxiako6o);
    }
    void create_metaptyxiako_7o() {
        setContentView(R.layout.activity_metaptyxiako7o);

        TextView text2 = findViewById(R.id.text2);
        String text = "<br><b>Λόγω του περιορισμού του ν. 4485/2017 για τρεις ειδικεύσεις ανά Π.Μ.Σ., και το γεγονός ότι το Π.Μ.Σ. «Προηγμένα Συστήματα Πληροφορικής» είχε 7 κατευθύνσεις (ειδικεύσεις), από το Ακαδημαϊκό Έτος 2018-2019 αντί για το Π.Μ.Σ. «Προηγμένα Συστήματα Πληροφορικής» θα λειτουργήσουν τρία Π.Μ.Σ. ως εξής:</b>" +
                "<br><br> · Π.Μ.Σ. «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης»" +
                "<br> · Π.Μ.Σ. «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες»" +
                "<br> · Π.Μ.Σ. «Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας»" +
                "<br><br>Οι κατευθύνσεις που υπήρχαν ήταν:" +
                "<ul><li>Δικτυοκεντρικά και Τηλεπικοινωνιακά Συστήματα</li>" +
                "<li>Επιχειρηματική Ευφυία</li>" +
                "<li>Ευφυείς Τεχνολογίες Επικοινωνίας Ανθρώπου-Υπολογιστή</li>" +
                "<li>Προηγμένες Τεχνολογίες Ανάπτυξης Λογισμικού</li>" +
                "<li>Τεχνολογίες Διαχείρισης Ασφάλειας</li>" +
                "<li>Τεχνολογίες Ηλεκτρονικών και Κινητών Υπηρεσιών</li>" +
                "<li>Ψηφιακός Πολιτισμός</li></ul>";
        text2.setText(Html.fromHtml(text));
    }
    void create_metaptyxiako_8o() {
        setContentView(R.layout.activity_metaptyxiako8o);

        TextView text2 = findViewById(R.id.text2);
        String text = " Το Τμήμα Μηχανικών Πληροφορικής Τ.Ε. του Τ.Ε.Ι. Δυτικής Μακεδονίας σε συνεργασία με το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς οργανώνουν και λειτουργούν Διατμηματικό Πρόγραμμα Μεταπτυχιακών Σπουδών (Π.Μ.Σ.) με τίτλο \"Σύγχρονα Συστήματα Τηλεπικοινωνιών, Τεχνολογίες Διαδικτύου και Ασφάλεια Συστημάτων\"." +
                "<br><br>Το Π.Μ.Σ. απονέμει Μεταπτυχιακό Δίπλωμα Ειδίκευσης (Μ.Δ.Ε.)/ Master of Science (M.Sc.) με τίτλο \"Σύγχρονα Συστήματα Τηλεπικοινωνιών, Τεχνολογίες Διαδικτύου και Ασφάλεια Συστημάτων\" (Modern Telecommunication Systems, Internet Technologies and Systems Security). Οι τίτλοι απονέμονται από κοινού από τα συνεργαζόμενα Τμήματα Πληροφορικής του Πανεπιστημίου Πειραιώς και Μηχανικών Πληροφορικής Τ.Ε. του ΤΕΙ Δυτικής Μακεδονίας." +
                "<br><br>Στο Π.Μ.Σ. γίνονται δεκτοί, μετά από επιλογή, πτυχιούχοι Τμημάτων Πληροφορικής, Μηχανικών Πληροφορικής Τ.Ε., Μηχανικών Τ.Ε., Πολυτεχνείων ή Πολυτεχνικών Σχολών, Θετικών ή Τεχνολογικών Επιστημών ή/και άλλων συναφών ειδικοτήτων, καθώς και πτυχιούχοι Πανεπιστημίων, Πολυτεχνείων ή Πολυτεχνικών Σχολών και ΤΕΙ ή Α.Σ.ΠΑΙ.Τ.Ε. της ημεδαπής, και ΑΕΙ της αλλοδαπής." +
                "<br><br>Η διάρκεια του Π.Μ.Σ. είναι 3 ακαδημαϊκά εξάμηνα." +
                "<br><br>Το Π.Μ.Σ. λειτουργεί στις εγκαταστάσεις του Τ.Ε.Ι. Δυτικής Μακεδονίας στην Καστοριά, Παρασκευή 16:00 - 22:00 και Σάββατο 08:30 - 18:00";
        text2.setText(Html.fromHtml(text));
    }

    public void ShowPopup(View v) {

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
        else if(text.equals("Φιλιππάκης Μιχαήλ")){
            idiotita.setText("Αναπ.Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("janag@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Πατσάκης Κωνσταντίνος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("540/ΚΕΚΤ");
            thl.setText("+30 210 4142261");
            email.setText("kpatsak@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σακκόπουλος Ευάγγελος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("543/ΚΕΚΤ");
            thl.setText("+30 210 4142312 ");
            email.setText("sakkopul@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Δημήτριος Ι. Βέργαδος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Διάλλα Άντα")){
            idiotita.setText("Αναπ.Καθηγήτρια");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }

        else if(text.equals("Μιχάλας Άγγελος")){
            idiotita.setText("Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("208/ΚΕKΤ");
            thl.setText("");
            email.setText("amichalas@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Καραγιώργου Σοφία")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("501/ΚΕKΤ");
            thl.setText("");
            email.setText("karagior@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Ζουμή Ειρήνη")){
            idiotita.setText("Υποψήφια Διδάκτορας");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("208/ΚΕΚΤ");
            thl.setText("+30 210 4142451");
            email.setText("zoumi@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σκόνδρας Εμμανουήλ")){
            idiotita.setText("Μεταδιδακτορικός Ερευνητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("501/ΚΕKΤ");
            thl.setText("");
            email.setText("karagior@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Αναγνωστόπουλος Χρήστος-Νικόλαος")){
            idiotita.setText("Καθ.Παν.Αιγαίου");
            tmhma.setText("-");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("canag@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Καλογεράκη Ελένη - Μαρία")){
            idiotita.setText("");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("503/ΚΕΚΤ");
            thl.setText("+30 210 4142263");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κανατούλα Αικατερίνη")){
            idiotita.setText("");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("503/ΚΕΚΤ");
            thl.setText("+30 210 4142105");
            email.setText("psp@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κατσιώνης Γεώργιος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("507/ΚΕKΤ");
            thl.setText("");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Λιαγκούρας Κωνσταντίνος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("303/ΓΛ126");
            thl.setText("");
            email.setText("kliagk@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Παπαδομιχελάκη Ξένη")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("");
            thl.setText("");
            email.setText("");
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
        else if(text.equals("Λιαγκούρας Κωνσταντίνος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("303/ΓΛ126");
            thl.setText("");
            email.setText("kliagk@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Παπαδομιχελάκη Ξένη")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("");
            thl.setText("");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Ψυχογιός Δημήτριος")){
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("319/Δεληγιώργη 107");
            thl.setText("+30 210 4142399 ");
            email.setText("dpsycho@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Στεφάνου Ιωσήφ")){
            idiotita.setText("Ομότιμος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("jstefanou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Fran Casino ")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("");
            thl.setText("");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Ανδρουλιδάκη Αμαλία")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Βαγενά Ευαγγελία")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("evagena@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Βασιλαρά Αρχοντούλα")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("avasilara@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Γρηγορακάκης Γρήγορης")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Θωμάς Δασακλής")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("");
            thl.setText("");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κακαβάς Γεώργιος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κακουλίδου Αλίκη")){
            idiotita.setText("Διδάσκoυσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("akakoulidou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Καραμητσάνης Βασίλειος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Κοτσώνης Ιωάννης")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("ykotsonis@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Λινάκη Ε.")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Μαγγίνης Γεώργιος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Μυριδάκης Νικόλαος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Οικονόμου Αγησίλαος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Ράππας Παναγιώτης")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Ρωμάνου Χριστίνα")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σιούντρη Κωνσταντίνα")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("ksiountri@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σκόνδρας Εμμανουήλ")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("skondras@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Στεφάνου Βασιλεία")){
            idiotita.setText("Διδάσκουσα");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("vstefanou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Συρρής Νικόλαος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Χατζηγρηγορίου Παύλος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("pchatzigrigoriou@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Σωτηρόπουλος Διονύσιος")){
            idiotita.setText("Διδάσκων");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("506/ΚΕKΤ");
            thl.setText(" +30 210 4142262");
            email.setText("dsotirop@unipi.gr");
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
        else if(text.equals("Δουληγέρης")){
            onomatepwnymo.setText("Δουληγέρης Χρήστος");
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
        }else if(text.equals("Παναγιωτόπουλος")){
            onomatepwnymo.setText("Παναγιωτόπουλος Θεμιστοκλής");
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
        else if(text.equals("Γ. Τσιχριντζής")){
            onomatepwnymo.setText("Τσιχριντζής Γεώργιος");
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
        else if(text.equals("Τσικούρας")) {
            onomatepwnymo.setText("Τσικούρας Παναγιώτης-Γεώργιος");
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
        else if(text.equals("Κωνσταντόπουλος")){
            onomatepwnymo.setText("Κωνσταντόπουλος Χαράλαμπος");
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

        }
        else if(text.equals("Αλέπης")){
            onomatepwnymo.setText("Αλέπης Ευθύμιος");
            idiotita.setText("Επίκουρος Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("540/ΚΕΚΤ");
            thl.setText("+30 210 4142311");
            email.setText("talepis@unipi.gr");
            istoselida.setText("www.unipi.gr");

        }
        else if(text.equals("Κοτζανικολάου Παναγιώτης")){
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
        else if(text.equals("Θεοδωρίδης")){
            onomatepwnymo.setText("Θεοδωρίδης Ιωάννης");
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
        }
        else if(text.equals("Μεταξιώτης")){
            onomatepwnymo.setText("Μεταξιώτης Κωνσταντίνος");
            idiotita.setText("Αναπληρωτής Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("303/ΓΛ126");
            thl.setText("+30 210 4142578");
            email.setText("cdoulig@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }
        else if(text.equals("Βίρβου Μαρία")){
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

        }
        else if(text.equals("Δ. Βέργαδος")){
            onomatepwnymo.setText("Βέργαδος Δημήτριος");
            idiotita.setText("Αναπλ. Καθηγητής");
            tmhma.setText("Τμήμα Πληροφορικής");
            grafeio.setText("104/ΓΛ126");
            thl.setText("+30 210 4142479");
            email.setText("vergados@unipi.gr");
            istoselida.setText("www.unipi.gr");
        }

        else if(text.equals("Γεωργιακώδης Φώτιος")) {
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
        }else if(text.equals("Πελέκης Νικόλαος")){
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
