package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anakoinwseis_details extends AppCompatActivity {
    private String[] title_array;
    private String[] date_array;
    int id;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    View.OnClickListener listener;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anakoinwseis_details);


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
                Intent intent = new Intent(anakoinwseis_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(anakoinwseis_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(anakoinwseis_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition));
                startActivity(intent);
                return false;
            }
        });
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setSelectedItemId(R.id.news_bot_nav);
        bottom_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(anakoinwseis_details.this, menu_redirection.class);
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

        String name = getIntent().getStringExtra("chapter");
        title_array = getIntent().getStringArrayExtra("title");
        date_array = getIntent().getStringArrayExtra("date");
        id = getIntent().getExtras().getInt("id");
        if(name.equals("Διοικητικές πράξεις")){
            if(id==0){
                create_details("","1398","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=62_8498cfb130ed455088ad84cebe3fc042&Itemid=709&lang=el",70,150,300,"ΑΝΑΠΛΗΡΩΤΗΣ ΠΡΟΕΔΡΟΥ (739 Downloads)");
            }else if(id==1){
                create_details("","1403","Δευτέρα, 23 Μαΐου 2016 15:09","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=52_1195f0fb7629a6e26088f13a585f701c&Itemid=709&lang=el",175,150,300,"istoriko-monimopoihshs.xls (655 Downloads)");
            }else if(id==2){
                create_details("","1222","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=32_c6c939efbda66a4cf6c46954f6884be2&Itemid=709&lang=el",240,150,400,"Πρόσκληση εκδήλωσης ενδιαφέροντος για την πρόσληψη εκπαιδευτικού προσωπικού με σχέση εργασίας ιδιωτικού δικαίου ορισμένου χρόνου (497 Downloads)");
            }else if(id==3){
                create_details("<a href='http://www.cs.unipi.gr/files/news/istoriko_monimopoiisis-asyrmata-diktya-epikoinwnies.xls'><u><b>Μονιμοποίηση μέλους ΔΕΠ</b></u></a>","1485","Τετάρτη, 20 Μαΐου 2015 03:32","",70,150,300,"");
            }else if(id==4){
                create_details("<a href='http://www.cs.unipi.gr/files/news/prokirixi-pliroforikis-ada-27-03-2015.pdf'><u><b>Πρόσκληση εκδήλωσης ενδιαφέροντος για την πρόσληψη εκπαιδευτικού προσωπικού με σχέση εργασίας ιδιωτικού δικαίου ορισμένου χρόνου</b></u></a>","1506","Last modified on Παρασκευή, 03 Απριλίου 2015 13:00","",240,320,530,"");
            }
        }else{
            if(id == 0){
                create_details("Σας ενημερώνουμε ότι, σύμφωνα με την αριθμ. 44726/Ζ1/9-4-2020 Κοινή Υπουργική Απόφαση (ΦΕΚ 1271/τ.Β’/9-4-2020), ορίστηκε ότι, λόγω των έκτακτων μέτρων για την αντιμετώπιση του κορωνoϊού, η διανομή των διδακτικών συγγραμμάτων για το εαρινό εξάμηνο του ακαδημαϊκού έτους 2019-2020, θα πραγματοποιηθεί με κατ΄ οίκον παράδοση αυτών προς τους δικαιούχους φοιτητές των Α.Ε.Ι., με ευθύνη των εκδοτικών οίκων μέσω εταιρειών ταχυμεταφορών (courier).\n" +
                        "<br><br><br>" +
                        "Η διαδικασία υποβολής των δηλώσεων για την επιλογή διδακτικών συγγραμμάτων από τους δικαιούχους φοιτητές, θα ξεκινήσει την Παρασκευή 10 Απριλίου 2020 και θα πρέπει να έχει ολοκληρωθεί έως την Κυριακή 26 Απριλίου 2020. Διευκρινίζεται ότι δεν δύναται να υπάρξει παρέκκλιση από την εν λόγω προθεσμία, συνεπώς η ως άνω καταληκτική ημερομηνία υποβολής δηλώσεων είναι υποχρεωτική.\n" +
                        "<br><br><br>" +
                        "Προκειμένου να καταστεί δυνατή η κατ΄οίκον παράδοση των διδακτικών συγγραμμάτων, κάθε φοιτητής οφείλει να δηλώσει μέσω του Πληροφοριακού Συστήματος «ΕΥΔΟΞΟΣ», τον τόπο παράδοσης στον οποίο επιθυμεί να του παραδοθούν τα διδακτικά συγγράμματα που έχει επιλέξει. Ως τόπος κατ΄οίκον παράδοσης δύναται να ορισθεί οποιαδήποτε περιοχή εντός της ελληνικής επικράτειας και την Κύπρο. Για τον λόγο αυτό, οι δικαιούχοι φοιτητές, συμπεριλαμβανομένων και των Κυπρίων φοιτητών, καλούνται να δηλώσουν τον «τόπο παράδοσης», συμπληρώνοντας τα πεδία της «Υποχρεωτικής Δήλωσης Διεύθυνσης», και συγκεκριμένα: Οδό, Αριθμό, ΤΚ, Περιοχή, Καλλικρατικό Δήμο, Περιφερειακή Ενότητα, Χώρα, ενώ παράλληλα καλούνται να επικαιροποιήσουν τα στοιχεία επικοινωνίας τους (κινητό τηλέφωνο και e-mail). Η διανομή των διδακτικών συγγραμμάτων αναμένεται να ξεκινήσει αμέσως μετά την καταληκτική ημερομηνία υποβολής των δηλώσεων και θα πρέπει να έχει ολοκληρωθεί έως τις 15 Ιουνίου 2020.\n" +
                        "<br><br><br>" +
                        "Υπενθυμίζεται ότι οι φοιτητές δικαιούνται να παραλάβουν συγγράμματα μόνο για τα μαθήματα εκείνα τα οποία έχουν συμπεριλάβει στη δήλωση μαθημάτων του εαρινού εξαμήνου.\n" +
                        "<br><br><br>" +
                        "Επισημαίνεται ότι βάσει της ισχύουσας νομοθεσίας, οι φοιτητές που έχουν υπερβεί τα ν+2 έτη σπουδών δεν δικαιούνται δωρεάν διδακτικά συγγράμματα.\n" +
                        "<br><br><br>" +
                        "ΑΠΟ ΤΟ ΓΡΑΦΕΙΟ ΔΗΜΟΣΙΕΥΜΑΤΩΝ ΚΑΙ ΕΚΔΟΣΕΩΝ", "244", " Σάββατο, 11 Απριλίου 2020 13:05", "http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=378_4e1f0037aa802828c841d112ed6886cc&Itemid=673&lang=el",130,260,2560,"Ανακοίνωση δήλωσης συγγραμμάτων (26 Downloads)");
            }else if(id==1){
                create_details("","397","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=377_d030b1b7ebdb49c7d2255531c36b4860&Itemid=673&lang=el",130,200,300,"Αρχείο ανακοίνωσης (326 Downloads)");
            }else if(id==2){
                create_details("Οι φοιτητές που δικαιούνται δωρεάν σίτιση, ενημερώνονται ότι η σίτιση θα γίνεται έως και την Τετάρτη 15 Απριλίου και θα αρχίσει ξανά από την Πέμπτη 23 Απριλίου 2020, με τη διανομή φαγητού σε πακέτο, σε συνεχή ροή από 12:00 έως 18:30 καθημερινά στο φοιτητικό εστιατόριο και θα παραλαμβάνουν όλα τα γεύματα της ημέρας που δικαιούνται, με τρόπο ώστε να αποφεύγεται η συνάθροιση","75","Παρασκευή, 10 Απριλίου 2020 14:27","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=376_a607fe0d7291025fa33a41da547508a4&Itemid=673&lang=el",130,220,640,"Αρχείο ανακοίνωσης (19 Downloads)");
            }else if(id==3){
                create_details("Γίνεται γνωστό ότι η εκπαιδευτική λειτουργία εξ αποστάσεως θα συνεχιστεί έως και την Τετάρτη 15 Απριλίου και θα αρχίσει ξανά από την Πέμπτη 23 Απριλίου 2020, σύμφωνα με το πρόγραμμα μαθημάτων εκάστου Ακαδημαϊκού Τμήματος.\n" +
                        "<br><br>" +
                        "Η εξ αποστάσεως εκπαίδευση θα διακοπεί μόνο από 16 έως και 22 Απριλίου 2020.\n" +
                        "<br><br>" +
                        "Εκ της Πρυτανείας","179","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=375_ca3364d3adb133c7ebfbc2d443bbfa78&Itemid=673&lang=el",80,180,640,"Αρχείο ανακοίνωσης (45 Downloads)");
            }else if(id==4){
                create_details("<a href='https://www.unipi.gr/teleteaching'>https://www.unipi.gr/teleteaching</a>","330","","",170,240,380,"");
            }else if(id==5){
                create_details("<a href='https://www.unipi.gr/unipi/images/various/dieuth_spoudwn/sitisi_2019-2020/%CE%9F%CE%B4%CE%B7%CE%B3%CE%AF%CE%B5%CF%82_%CF%80%CF%81%CE%BF%CF%82_%CE%BC%CE%B5%CF%84%CE%B1%CE%BA%CE%B9%CE%BD%CE%BF%CF%8D%CE%BC%CE%B5%CE%BD%CE%BF%CF%85%CF%82_%CE%B3%CE%B9%CE%B1_%CF%83%CE%AF%CF%84%CE%B9%CF%83%CE%B7_%CF%86%CE%BF%CE%B9%CF%84%CE%B7%CF%84%CE%AD%CF%82.pdf'>https://www.unipi.gr/unipi/images/various/dieuth_spoudwn/sitisi_2019-2020/%CE%9F%CE%B4%CE%B7%CE%B3%CE%AF%CE%B5%CF%82_%CF%80%CF%81%CE%BF%CF%82_%CE%BC%CE%B5%CF%84%CE%B1%CE%BA%CE%B9%CE%BD%CE%BF%CF%8D%CE%BC%CE%B5%CE%BD%CE%BF%CF%85%CF%82_%CE%B3%CE%B9%CE%B1_%CF%83%CE%AF%CF%84%CE%B9%CF%83%CE%B7_%CF%86%CE%BF%CE%B9%CF%84%CE%B7%CF%84%CE%AD%CF%82.pdf</a>","86","","",300,430,880,"");
            }else if(id==6){
                create_details("Σύμφωνα με την αριθμ. Δ1α/ΓΠ.οικ. 20021/21-3-2020, ΚΥΑ (ΦΕΚ 956/τ.Β’/21-32020) απαγορεύεται προσωρινά η λειτουργία των ανώτατων εκπαιδευτικών ιδρυμάτων της χώρας, για προληπτικούς λόγους δημόσιας υγείας, για το χρονικό διάστημα από 21.3.2020 έως και 10.4.2020. Ειδικότερα, απαγορεύεται προσωρινά η διεξαγωγή:<br>" +
                        "α) των πάσης φύσεως εκπαιδευτικών λειτουργιών, οι οποίες πραγματοποιούνται με φυσική παρουσία<br>" +
                        "β) της πρακτικής άσκησης φοιτητών<br>" +
                        "γ) της λειτουργίας των βιβλιοθηκών, των αιθουσών κοινόχρηστων ηλεκτρονικών υπολογιστών, των αναγνωστηρίων, των εστιατορίων και κυλικείων, των εστιών, των αθλητικών εγκαταστάσεων και εν γένει κάθε χώρου συνάθροισης κοινού στις ανωτέρω δομές<br>" +
                        "δ) των τελετών, ημερίδων, συνεδρίων και πάσης φύσεως εκδηλώσεων και δραστηριοτήτων<br>" +
                        "<br><br>" +
                        "Από την ως άνω προσωρινή απαγόρευση εξαιρούνται:<br>" +
                        "α) οι διοικητικές λειτουργίες και υπηρεσίες καθώς και, κατά περίπτωση<br>" +
                        "β) οι ερευνητικές δραστηριότητες<br>" +
                        "γ) η λειτουργία των Ειδικών Λογαριασμών Κονδυλίων Έρευνας Σίτιση φοιτητών<br>" +
                        "<br><br>" +
                        "Οι φοιτητές που δικαιούνται δωρεάν σίτιση, ενημερώνονται ότι από 24.3.2020 έως και 10.4.2020 η σίτιση θα γίνεται με τη διανομή φαγητού σε πακέτο, σε συνεχή ροή από 12:00 έως 18:30 καθημερινά στο φοιτητικό εστιατόριο και θα παραλαμβάνουν όλα τα γεύματα της ημέρας που δικαιούνται, με τρόπο ώστε να αποφεύγεται η συνάθροιση.","156","Τρίτη, 24 Μαρτίου 2020 14:31","",200,330,1780,"");
            }else if(id==7){
            create_details("Το τμήμα Πληροφορικής προχωρεί σε τηλε-διδασκαλία των μαθημάτων, συμμορφούμενο με τις οδηγίες του Υπουργείου εν όψει της επιδημίας του κορωνοϊού." +
                    "<br><br>" +
                    "Η διδασκαλία θα πραγματοποιείται χρησιμοποιώντας συνδυασμό ΑΣΥΓΧΡΟΝΗΣ και ΣΥΓΧΡΟΝΗΣ τεχνολογιας.\n" +
                    "<br><br>" +
                    "Αναμένουμε ομαλοποίηση της διαδικασίας από την εβδομάδα, που ξεκινάει στις 30 Μαρτίου , όπου εκτός απότη χρήση του eclass θα υπάρχουν και ζωντανές διαλέξεις μέσω κατάλληλης πλατφόρμας.\n" +
                    "<br><br>" +
                    "Ζητούμε την κατανόησή σας. Η επιδημία \"χτύπησε\" τη χώρα μας όταν η νομοθεσία ΑΠΑΓΟΡΕΥΕ εξ ολοκλήρου την αποκλειστική διδασκαλία εκτός αμφιθεάτρου. Πρόσφατη επείγουσα ρύθμιση λόγω των συνθηκών επιτρέπει (και επιβάλλει) την εξ αποστάσεως διδασκαλία. Ομως, η απαιτούμενη υποδομή, τόσο σε εθνικό, όσο και σε ευρωπαϊκό επίπεδο ίσως αποδειχτεί ανεπαρκής για τηλε-εκπαίδευση χωρίς προβλήματα. Τις προηγούμενες ημέρες, η δικτυακή και τηλεπικοινωνιακή υποδομή της Ευρώπης δοκιμάστηκε, όπως μπορεί να διαπιστώσει κανείς στο παρακάτω άρθρο. Ας κάνουμε λίγη υπομονή μέχρι την προσαρμογή στις νέες συνθήκες.\n" +
                    "<br><br>" +
                    "<a href='https://www.zdnet.com/article/microsoft-teams-outage-affecting-users-in-europe/?ftag=COS-05-10aaa0h&utm_campaign=trueAnthem%3A+Trending+Content&utm_medium=trueAnthem'>https://www.zdnet.com/article/microsoft-teams-outage-affecting-users-in-europe/?ftag=COS-05-10aaa0h&utm_campaign=trueAnthem%3A+Trending+Content&utm_medium=trueAnthem</a>","572","","",250,350,1680,"");
            }else if(id==8){
                create_details("","315","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=373_4f867facf41c0981d9db843a01601c0c&Itemid=673&lang=el",130,180,300,"αρχείο ανακοίνωσης (221 Downloads)");
            }else if(id==9){
                create_details("","315","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=372_0a9e21d4b23360078db590dadbc708c3&Itemid=673&lang=el",130,180,300,"αρχείο ανακοίνωσης (146 Downloads)");
            }else if(id==10){
                create_details("","364","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=369_16b419f2f0897cc7d1ae06e23f2084bd&Itemid=673&lang=el",130,180,300,"αρχείο ανακοίνωσης (296 Downloads)");
            }else if(id==11){
                create_details("","364","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=368_8d17352f2e139cad95197dde9f739d1f&Itemid=673&lang=el",130,180,300,"Πρόγραμμα Διδασκαλίας Εαρινού Εξαμήνου Ακαδημαϊκού Έτους 2019-2020 (1625 Downloads)");
            }else if(id==12){
                add_image(R.drawable.logounipi,350 ,380 ,250 ,250);
                create_details("<p style='font-size:12px'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ</b>\n" +
                        "<br><b>ΣΧΟΛΗ ΤΕΧΝΟΛΟΓΙΩΝ ΠΛΗΡΟΦΟΡΙΚΗΣ ΚΑΙ ΕΠΙΚΟΙΝΩΝΙΩΝ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΠΡΟΓΡΑΜΜΑ ΜΕΤΑΠΤΥΧΙΑΚΩΝ ΣΠΟΥΔΩΝ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;«ΠΛΗΡΟΦΟΡΙΚΗ»</b>\n" +
                        "\n" +
                        "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Πειραιάς, 18 Φεβρουαρίου 2020\n" +
                        "\n" +
                        "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>ΑΝΑΚΟΙΝΩΣΗ</b>\n" +
                        "<br><br>Γίνεται γνωστό ότι, η Ορκωμοσία των αποφοίτων τουΠρογράμματος Μεταπτυχιακών Σπουδών«Πληροφορική»του Τμήματος Πληροφορικής θα πραγματοποιηθεί στις <b>27 Φεβρουαρίου 2020</b>, ημέρα <b>Πέμπτη και ώρα 12:00</b>, στην «Αίθουσα Συνεδρίων» (Καραολή και Δημητρίου 80, Πειραιάς, ισόγειο).\n" +
                        "\n" +
                        "<br><br>Καλούνται οι κάτωθι απόφοιτοι να προσέλθουν αυτοπροσώπως στη Γραμματεία του Τμήματος,  (Διεύθυνση:  Ζέας 80-82, Πειραιάς στον 1ο Όροφο), με την αστυνομική τους ταυτότητα, τις ήμερες, <b>Τρίτη 25/02/2020</b> και <b>Τετάρτη 26/02/2020 και ώρες 08:00 – 17:00</b>, προκειμένου να συμπληρώσουν το ειδικό έντυπο  του όρκου και να επιστρέψουν τη φοιτητική  ταυτότητα, την κάρτα σίτισης, την κάρτα βιβλιοθήκης και για όσους κάνουν χρήση φοιτητικής εστίας άλλων Ακαδημαϊκών Ιδρυμάτων  βεβαίωση διακοπής της χρήσης της εστίας.\n" +
                        "\n" +
                        "<br><br>Την ήμερα της ορκωμοσίας 27/02/2020 οι απόφοιτοι θα προσέλθουν <b><u>μια ώρα πριν την έναρξη της τελετής στην αίθουσα 012</b></u>. (ισόγειο) προκείμενου να ετοιμαστούν, διότι είναι υποχρεωτική η ένδυση με τήβεννο.</p>" +
                        "<br><table border=1 style='font-family:\"Courier New\", Courier, monospace; font-size:80%'><tr>" +
                        "    <th>A/A</th>" +
                        "    <th>Επώνυμο</th>" +
                        "    <th>Όνομα</th>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>1</td>" +
                        "    <td>ΑΛΕΞΑΚΗ</td>" +
                        "    <td>ΓΕΩΡΓΙΑ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>2</td>" +
                        "    <td>ΒΑΣΙΛΑΚΟΠΟΥΛΟΣ</td>" +
                        "    <td>ΒΑΣΙΛΕΙΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>3</td>" +
                        "    <td>ΒΕΛΕΤΣΟΣ</td>" +
                        "    <td>ΑΛΕΞΑΝΔΡΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>4</td>" +
                        "    <td>ΓΕΩΡΓΟΥΛΗΣ</td>" +
                        "    <td>ΑΡΙΣΤΟΤΕΛΗΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>5</td>" +
                        "    <td>ΓΙΑΝΝΑΔΑΚΗΣ</td>" +
                        "    <td>ΚΩΝΣΤΑΝΤΙΝΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>6</td>" +
                        "    <td>ΓΙΑΝΝΟΥΛΟΠΟΥΛΟΣ</td>" +
                        "    <td>ΝΙΚΟΛΑΟΣ-ΦΩΤΙΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>7</td>" +
                        "    <td>ΖΗΝΟΒΙΟΥ</td>" +
                        "    <td>ΞΕΝΟΦΩΝ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>8</td>" +
                        "    <td>ΖΟΥΜΗ</td>" +
                        "    <td>ΕΙΡΗΝΗ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>9</td>" +
                        "    <td>ΘΕΟΦΙΛΟΠΟΥΛΟΣ</td>" +
                        "    <td>ΘΕΟΦΙΛΟΣ- ΝΙΚΟΛΑΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>7</td>" +
                        "    <td>ΚΑΒΒΑΛΟΣ</td>" +
                        "    <td>ΕΜΜΑΝΟΥΗΛ-ΒΑΣΙΛΕΙΟΣ</td>" +
                        "  </tr></table>" +
                        "<br><p style='font-size:12px'>Η Γραμματέας του Τμήματος\n" +
                        "\n" +
                        "<br>" +
                        "<br>" +
                        "Βασιλική Γκότση</p></body>","383","Last modified on Τρίτη, 18 Φεβρουαρίου 2020 13:21","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=367_ff1b10f76911de5ce0161c8f5df4b134&Itemid=673&lang=el",240,580,3050,"Αρχείο Ανακοίνωσης (32 Downloads)");
            }else if(id==13){
                add_image(R.drawable.logounipi,350 ,380 ,250 ,250);
                create_details("<p style='font-size:12px'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΠΑΝΕΠΙΣΤΗΜΙΟ ΠΕΙΡΑΙΩΣ</b>\n" +
                        "<br><b>ΣΧΟΛΗ ΤΕΧΝΟΛΟΓΙΩΝ ΠΛΗΡΟΦΟΡΙΚΗΣ ΚΑΙ ΕΠΙΚΟΙΝΩΝΙΩΝ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΠΡΟΓΡΑΜΜΑ ΜΕΤΑΠΤΥΧΙΑΚΩΝ ΣΠΟΥΔΩΝ</b>\n" +
                        "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;«ΠΛΗΡΟΦΟΡΙΚΗ»</b>\n" +
                        "\n" +
                        "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Πειραιάς, 18 Φεβρουαρίου 2020\n" +
                        "\n" +
                        "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>ΑΝΑΚΟΙΝΩΣΗ</b>\n" +
                        "<br><br>Γίνεται γνωστό ότι, η Ορκωμοσία των αποφοίτων τουΠρογράμματος Μεταπτυχιακών Σπουδών«Προηγμένα Σύστηματα Πληροφορικής»του Τμήματος Πληροφορικής θα πραγματοποιηθεί στις <b>27 Φεβρουαρίου 2020</b>, ημέρα <b>Πέμπτη και ώρα 10:00</b>, στην «Αίθουσα Συνεδρίων» (Καραολή και Δημητρίου 80, Πειραιάς, ισόγειο).\n" +
                        "\n" +
                        "<br><br>Καλούνται οι κάτωθι απόφοιτοι να προσέλθουν αυτοπροσώπως στη Γραμματεία του Τμήματος,  (Διεύθυνση:  Ζέας 80-82, Πειραιάς στον 1ο Όροφο), με την αστυνομική τους ταυτότητα, τις ήμερες, <b>Τρίτη 25/02/2020</b> και <b>Τετάρτη 26/02/2020 και ώρες 08:00 – 17:00</b>, προκειμένου να συμπληρώσουν το ειδικό έντυπο  του όρκου και να επιστρέψουν τη φοιτητική  ταυτότητα, την κάρτα σίτισης, την κάρτα βιβλιοθήκης και για όσους κάνουν χρήση φοιτητικής εστίας άλλων Ακαδημαϊκών Ιδρυμάτων  βεβαίωση διακοπής της χρήσης της εστίας.\n" +
                        "\n" +
                        "<br><br>Την ήμερα της ορκωμοσίας 27/02/2020 οι απόφοιτοι θα προσέλθουν <b><u>μια ώρα πριν την έναρξη της τελετής στην αίθουσα 012</b></u>. (ισόγειο) προκείμενου να ετοιμαστούν, διότι είναι υποχρεωτική η ένδυση με τήβεννο.</p>" +
                        "<br><table border=1 style='font-family:\"Courier New\", Courier, monospace; font-size:80%'><tr>" +
                        "    <th>A/A</th>" +
                        "    <th>Επώνυμο</th>" +
                        "    <th>Όνομα</th>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>1</td>" +
                        "    <td>ΑΓΓΕΛΕΑΣ</td>" +
                        "    <td>ΑΝΑΡΓΥΡΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>2</td>" +
                        "    <td>ΑΓΓΕΛΗΣ</td>" +
                        "    <td>ΑΛΕΞΑΝΔΡΟΣ -ΝΙΚΟΛΑΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>3</td>" +
                        "    <td>ΑΔΑΜ</td>" +
                        "    <td>ΚΩΝΣΤΑΝΤΙΝΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>4</td>" +
                        "    <td>ΑΛΕΞΑΝΔΡΙΔΗΣ</td>" +
                        "    <td>ΛΑΖΑΡΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>5</td>" +
                        "    <td>ΑΠΟΣΤΟΛΟΠΟΥΛΟΣ</td>" +
                        "    <td>ΘΕΟΔΩΡΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>6</td>" +
                        "    <td>ΒΟΥΒΟΥΤΣΗΣ</td>" +
                        "    <td>ΒΑΣΙΛΕΙΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>7</td>" +
                        "    <td>ΓΕΩΡΓΙΟΠΟΥΛΟΣ</td>" +
                        "    <td>ΚΥΡΙΑΚΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>8</td>" +
                        "    <td>ΓΙΑΝΝΟΥΣΗΣ</td>" +
                        "    <td>ΧΡΗΣΤΟΣ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>9</td>" +
                        "    <td>ΓΚΟΥΒΕΛΟΥ</td>" +
                        "    <td>ΒΗΘΛΕΕΜ</td>" +
                        "  </tr>" +
                        "  <tr>" +
                        "    <td>7</td>" +
                        "    <td>ΓΡΗΓΟΡΙΑΔΗΣ</td>" +
                        "    <td>ΧΡΗΣΤΟΣ</td>" +
                        "  </tr></table>" +
                        "<br><p style='font-size:12px'>Η Γραμματέας του Τμήματος\n" +
                        "\n" +
                        "<br>" +
                        "<br>" +
                        "Βασιλική Γκότση</p></body>","222","Last modified on Τρίτη, 18 Φεβρουαρίου 2020 13:07","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=366_32d06f3d5246e9edef4c169c34bc06fe&Itemid=673&lang=el",240,580,3050,"Αρχείο Ανακοίνωσης (31 Downloads)");
            }else if(id==14){
                create_details("","770","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=364_1209a0601c9af5f24abf4b361601091e&Itemid=673&lang=el",70,150,300,"αρχείο ανακοίνωσης (674 Downloads)");
            }else if(id==15){
                create_details("","137","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=363_b53e17c9654d150b2ed912230e12dac9&Itemid=673&lang=el",70,150,300,"αρχείο ανακοίνωσης (74 Downloads)");
            }else if(id==16){
                create_details("<a href='https://www.unipi.gr/unipi/el/%CF%86%CE%BF%CE%B9%CF%84%CE%B7%CF%84%CE%B9%CE%BA%CE%AC-%CE%B8%CE%AD%CE%BC%CE%B1%CF%84%CE%B1/item/11136-%CE%B1%CE%BD%CE%B1%CE%BA%CE%BF%CE%AF%CE%BD%CF%89%CF%83%CE%B7-%CE%B3%CE%B9%CE%B1-%CE%B4%CF%89%CF%81%CE%B5%CE%AC%CE%BD-%CF%83%CE%AF%CF%84%CE%B9%CF%83%CE%B7-%CF%86%CE%BF%CE%B9%CF%84%CE%B7%CF%84%CF%8E%CE%BD-%CF%86%CE%BF%CE%B9%CF%84%CE%B7%CF%84%CF%81%CE%B9%CF%8E%CE%BD-%CE%B1%CE%BA%CE%B1%CE%B4%CE%B7%CE%BC%CE%B1%CF%8A%CE%BA%CF%8C-%CE%AD%CF%84%CE%BF%CF%82-2019-2020.html'><p style='font-size:14px'><u><b>Ανακοίνωση για δωρεάν σίτιση φοιτητών / φοιτητριών (Ακαδημαϊκό Έτος 2019-2020)</b></u></p></a><br>" +
                        "Αιτήσεις από 3 έως 13 Μαρτίου 2020","137","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=363_b53e17c9654d150b2ed912230e12dac9&Itemid=673&lang=el",130,190,500,"");
            }else if(id==17){
                create_details("","227","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=362_9c93850b21014b03c31c746f6b5f4cd4&Itemid=673&lang=el",180,180,300,"αρχείο ανακοίνωσης (165 Downloads)");
            }else if(id==18){
                create_details("","84","","http://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=365_b796ee42b40be2e1f11f542c2fd62ff3&Itemid=673&lang=el",240,180,350,"αρχείο ανακοίνωσης (43 Downloads)");
            }else if(id==19){
                create_details("Ιδιαίτερα επιτυχημένη η Εσπερίδα Πληροφορικής και Τεχνητής Νοημοσύνης που διοργάνωσε το Τμήμα Πληροφορικής, με συμμετοχή του Πρύτανη του Πανεπιστημίου Πειραιώς, Καθηγητού κ. Άγγελου Κότιου, του Υφυπουργού Ψηφιακής Διακυβέρνησης, κ. Γρ. Ζαριφόπουλου (ως εκπροσώπου του Προέδρου της Κυβέρνησης), του κ. Ι. Μελά (Βουλετού Α' Πειραιώς και Αποφοίτου Προγράμματος Μεταπτυχιακών Σπουδών του τμήματος Πληροφορικής), του κ. Αθ. Κυριαζή (Γενικού Γραμματέα Έρευνας και Τεχνολογίας). Τιμώμενα πρόσωπα, ο Καθηγητής Έδρας του Πανεπιστημίου Wright State University των Η.Π.Α., κ. Νικόλαος Μπουρμπάκης (Nikolaos Bourbakis), και ο Δήμαρχος Τρικκαίων και Πρόεδρος ΚΕΔΕ, κ. Δημήτριος Παπαστεργίου.\n" +
                        "<br><br>" +
                        "Διοργανωτές και προεδρεύοντες, ο Πρόεδρος του τμήματος Πληροφορικής, Καθηγητής κ. Γεώργιος Τσιχριντζής, και η πρώην Πρόεδρος του τμήματος Πληροφορικής, Καθηγήτρια κ. Μαρία Βίρβου.","200","Last modified on Παρασκευή, 14 Φεβρουαρίου 2020 09:07","",130,240,3200,"");
                        add_image(R.drawable.anak_1,900 ,30 ,1010 ,1010);
                        add_image(R.drawable.anak_2,1600 ,30 ,1010 ,1010);
                        add_image(R.drawable.anak_3,2300 ,30 ,1010 ,1010);
            }else if(id==20){
                create_details("Στο πλαίσιο του Προπτυχιακού Προγράμματος Σπουδών (Π.Π.Σ.), το Τμήμα Πληροφορικής του Πανεπιστήμιου Πειραιώς (Πα.Πει.) προσφέρει πλέον στους αποφοίτους του παιδαγωγική και διδακτική επάρκεια !\n" +
                        "\n" +
                        "<br><br>Οι απόφοιτοι του Τμήματος μπορούν πλέον να διδάσκουν σε δημόσια και ιδιωτικά σχολεία και σε φροντιστήρια χωρίς να απαιτείται πρότερη μονοετής φοίτηση σε άλλο κατάλληλο εκπαιδευτικό ίδρυμα.\n" +
                        "\n" +
                        "<br><br>Ακόμα ένας λόγος να προτιμηθεί το Τμήμα Πληροφορικής του Πα.Πει. κατά τη συμπλήρωση του μηχανογραφικού δελτίου.","1161","Κυριακή, 30 Ιουνίου 2019 16:44","",120,220,850,"");
            }
        }
    }
    void add_image(int image,int top,int left,int w,int h){
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_anakoinwseis_details);
        ImageView img = new ImageView(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (w, h);
        params.leftMargin = left;
        img.setImageResource(image);
        params.topMargin  = top;
       img.setLayoutParams(params);
        rl.addView(img);
    }
    void create_details(String text, String read_times, String modify, String link,int date_top,int text_top,int underline_top,String link_desc) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_anakoinwseis_details);
        final TextView[] news_text = new TextView[6];
        final ImageView[] news_underline = new ImageView[2];
        final TextView[] news_date = new TextView[1];

        news_text[0] = new TextView(this);
        news_date[0] = new TextView(this);
        news_underline[0] = new ImageView(this);

        //Setting title
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 30;
        news_text[0].setText(title_array[id]);
        news_text[0].setTextSize((float) 17);
        news_text[0].setPadding(20, 50, 20, 50);
        params.topMargin  = 10;
        news_text[0].setLayoutParams(params);
        news_text[0].setTextColor(Color.parseColor("#003366"));
        rl.addView(news_text[0]);

        //Setting text
        if(id==12 || id==13) {
            WebView wb = new WebView(this);
            RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params8.leftMargin = 30;
            params8.topMargin  = text_top;
            wb.setLayoutParams(params8);
            wb.loadDataWithBaseURL(null, text, "text/html", "utf-8", null);
            rl.addView(wb);
        }else{
            news_text[1] = new TextView(this);
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params2.leftMargin = 30;
            news_text[1].setText(Html.fromHtml(text));
            news_text[1].setTextSize((float) 12);
            news_text[1].setPadding(20, 50, 20, 50);
            params2.topMargin  = text_top;
            news_text[1].setLayoutParams(params2);
            news_text[1].setTextColor(Color.parseColor("#0d0d0d"));
            rl.addView(news_text[1]);
        }

        //Setting date
        news_text[2] = new TextView(this);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params3.leftMargin = 30;
        news_text[2].setText(date_array[id]);
        news_text[2].setTextSize((float) 13);
        news_text[2].setPadding(20, 50, 20, 50);
        params3.topMargin  = date_top;
        news_text[2].setLayoutParams(params3);
        rl.addView(news_text[2]);

        //Setting image
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 30;
        news_underline[0].setImageResource(R.drawable.underline);
        params4.topMargin  = underline_top;
        news_underline[0].setLayoutParams(params4);
        rl.addView(news_underline[0]);

        //Setting read times
        news_text[3] = new TextView(this);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params5.leftMargin = 30;
        news_text[3].setText(Html.fromHtml("Read <b>"+read_times+"</b> times"));
        news_text[3].setTextSize((float) 11);
        news_text[3].setPadding(20, 50, 20, 50);
        params5.topMargin  = underline_top+20;
        news_text[3].setLayoutParams(params5);
        news_text[3].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(news_text[3]);

        //Setting last modified
        if(!modify.equals("")) {
            news_text[4] = new TextView(this);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params6.leftMargin = 30 + 520;
            news_text[4].setText(Html.fromHtml("Last modified on " + modify));
            news_text[4].setTextSize((float) 11);
            news_text[4].setPadding(20, 50, 20, 50);
            params6.topMargin = underline_top + 20;
            news_text[4].setLayoutParams(params6);
            rl.addView(news_text[4]);
        }

        //Setting download
        if(!link.equals("")) {
            news_text[5] = new TextView(this);
            RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params7.leftMargin = 30;
            news_text[5].setText(Html.fromHtml("<b>Download attachments:</b> <a href='" + link + "'>" + link_desc + "</a>"));
            news_text[5].setTextSize((float) 11);
            news_text[5].setPadding(20, 50, 20, 50);
            params7.topMargin = underline_top + 20 + 100;
            news_text[5].setLayoutParams(params7);
            news_text[5].setTextColor(Color.parseColor("#0d0d0d"));
            news_text[5].setMovementMethod(LinkMovementMethod.getInstance());
            rl.addView(news_text[5]);
        }

        }
    }