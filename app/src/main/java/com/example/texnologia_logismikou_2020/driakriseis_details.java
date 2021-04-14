package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class driakriseis_details extends AppCompatActivity {
    private int id;
    ImageView ranking_image;
    TextView text_details,title_details;
    private ViewGroup.MarginLayoutParams mlp;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    int margins[] = {850,1410,2000,1900,6900,7700,2400,4800,7000,6700,3100,3600,4300,600,400,2200};
    String reads[] = {"2605","3988","3028","3202","4447","4433","2833","3559","2778","2482","2413","2556","2216","2200","2347","2292"};
    String modify[] = {"","","Τετάρτη, 04 Φεβρουαρίου 2015 15:52","Τετάρτη, 04 Φεβρουαρίου 2015 15:52","Τετάρτη, 04 Φεβρουαρίου 2015 15:54","Τετάρτη, 04 Φεβρουαρίου 2015 15:53"," Πέμπτη, 04 Σεπτεμβρίου 2014 00:58","","","","","","","","Πέμπτη, 04 Σεπτεμβρίου 2014 01:08",""};
    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driakriseis_details);

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
                Intent intent = new Intent(driakriseis_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(driakriseis_details.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(driakriseis_details.this, menu_redirection.class);
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
                Intent intent = new Intent(driakriseis_details.this, menu_redirection.class);
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


        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        text_details = (TextView) findViewById(R.id.details_text);
        title_details = (TextView) findViewById(R.id.details_title);
        ranking_image =(ImageView) findViewById(R.id.img_ranking);
        ranking_image.setVisibility(View.INVISIBLE);
        if(id >= 7 || id==1){
            mlp = (ViewGroup.MarginLayoutParams) text_details
                    .getLayoutParams();
            mlp.setMargins(30, 125, 0, 0);
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        }else if(id==2){
            mlp = (ViewGroup.MarginLayoutParams) text_details
                    .getLayoutParams();
            mlp.setMargins(10, 205, 0, 0);
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        }
        if(id==1){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Skype Android Security Issue");
            text_details.setText("Οι επίκουροι καθηγητές του τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς Δρ. Κωνσταντίνος Πατσάκης και Δρ. Ευθύμιος Αλέπης εντόπισαν ένα σημαντικό πρόβλημα στην εφαρμογή Skype για το λειτουργικό Android. Το συγκεκριμένο πρόβλημα επηρέαζε 500.000.000-1.000.000.000 συσκευές σε όλο τον κόσμο. Οι επίκουροι καθηγητές ενημέρωσαν σχετικά την εταιρεία Microsoft, η οποία και έβγαλε την κατάλληλη ενημέρωση λογισμικού σε πολύ σύντομο χρονικό διάστημα. Η Microsoft τους ευχαριστεί επίσημα στην ιστοσελίδα της (link), στην Αμερική. Οι Έλληνες Καθηγητές Πανεπιστημίων δείχνουν καθημερινά την αξία τους στο διεθνή επιστημονικό χώρο παρόλες τις αντιξοότητες που αντιμετωπίζει η χώρα!");
        }else if(id==2){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Το Πανεπιστήμιο Πειραιώς πρωτοπόρο σε τομείς αιχμής");
            String linkText = "Υψηλού επιπέδου σπουδές σε τομείς αιχμής όπως είναι αυτές των οικονομικών, του επιχειρείν, της ναυτιλίας, της χρηματoοικοινομικής και τραπεζικής διοικητικής, καθώς και της πληροφορικής προσφέρει το Πανεπιστήμιο Πειραιώς που αποτελεί μετεξέλιξη της Ανώτατης Βιομηχανικής Σχολής. Πρόκειται για ένα ΑΕΙ με δραστήρια παρουσία στον ερευνητικό τομέα και με έντονο στίγμα στον διεθνή ακαδημαϊκό χώρο αφού βασική του προτεραιότητα είναι η εξωστρέφεια. Το Κέντρο Ερευνών του από την ίδρυσή του έχει ολοκληρώσει πάνω από 1.000 ερευνητικά έργα, εκπαιδευτικά προγράμματα και αναπτυξιακά έργα. Παράλληλα, συμμετέχει συχνά σε διεθνή συνέδρια και τα τμήματά του αποσπούν διακρίσεις.<br><br>Επιπροσθέτως, το Πανεπιστήμιο Πειραιώς κατατάσσεται στη θέση 73 από 4.338 πανεπιστήμια διεθνώς για Computer Education σύμφωνα με το εργαλείο ακαδημαϊκής αναζήτησης της Microsoft.<br><br><a href='https://www.tanea.gr/2015/04/28/greece/education/prwtoporo-se-tomeis-aixmis/'>(περισσότερα)</a><br><br>Τα Νέα, 29/04/2015";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==3){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            title_details.setText("Κατάταξη Μελών ΔΕΠ και Διδακτόρων του Τμήματος με Βάση το Εργαλείο Microsoft Academic Search");
            String linkText = "• Μαρία Βίρβου: Στους κορυφαίους 100 συγγραφείς παγκοσμίως για Computer Education (Θέση 53 από 58217 συγγραφείς παγκοσμίως).\n" +
                    "<br><br>• Μαρία Βίρβου και Γεώργιος Τσιχριντζής: Στους κορυφαίους 90 συγγραφείς παγκοσμίως για  Αναγνώριση Συναισθήματος από υπολογιστή.\n" +
                    "<br><br>• Μαρία Βίρβου στη θέση 1 για τα αντικείμενα:\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Authoring tool  (από 4028 συγγραφείς)\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Student Model (από 1693 συγγραφείς)\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Cognitive Theory (από 2393 συγγραφείς)\n" +
                    "<br><br>• Μαρία Βίρβου σε κορυφαίες θέσεις παγκοσμίως για τα ακόλουθα αντικείμενα:\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Graphic User Interface: Στη θέση 6 από 21664 συγγραφείς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• User  Model: Στη θέση 4 από  5711 συγγραφείς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Educational game: Στη θέση 4 από  1860 συγγραφείς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Educational application: Στη θέση 2 από  1864 συγγραφείς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• User Interface: Στη θέση 71 από 46135 συγγραφείς\n" +
                    "<br><br>• Ευθύμιος Αλέπης και Ιωάννα Ουρανία Σταθοπούλου: Στους κορυφαίους 120 συγγραφείς παγκοσμίως για  Αναγνώριση Συναισθήματος από υπολογιστή.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==4){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            ranking_image.setVisibility(View.VISIBLE);
            title_details.setText("Το Πανεπιστήμιο Πειραιώς στα 100 Κορυφαία Πανεπιστήμια του Κόσμου για Computer Education Σύμφωνα με το Εργαλείο Ακαδημαϊκής Αναζήτησης της Microsoft");
            String linkText = "Το Microsoft Academic Search είναι ένα εργαλείο αναζήτησης που διατίθεται δωρεάν στο διαδίκτυο. Οι χρήστες μπορούν γρήγορα να βρουν πληροφορίες για ερευνητές, ερευνητικά άρθρα, συνέδρια, επιστημονικά περιοδικά, οργανισμούς και λέξεις κλειδιά. Από το Μάιο του 2012, το Academic Search περιέλαβε 38 εκατομμύρια δημοσιεύσεις και 18 εκατομμύρια συγγραφείς. <br><br> Το ΠανεπιστήμιοΠειραιώς κατατάσσεται στη θέση 73 από 4338 Πανεπιστήμια διεθνώς για Computer Education.<br><br><a href='http://academic.research.microsoft.com/RankList?entitytype=7&topDomainID=2&subDomainID=23&last=0&start=1&end=100'>http://academic.research.microsoft.com/RankList?entitytype=7&topDomainID=2&subDomainID=23&last=0&start=1&end=100</a>";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==5){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
            title_details.setText("Διεθνής Αναγνώριση και Δραστηριότητα Μελών ΔΕΠ και Φοιτητών του Τμήματος Πληροφορικής");
            String linkText = "<b>Editors διεθνών περιοδικών, σειράς διεθνών βιβλίων</b>\n" +
                    "<br><br>• Μ. Βίρβου: Editor-in-Chief για όλη την περιοχή Computer Science στο διεθνές περιοδικό SpringerPlus.\n" +
                    "<br><br>• Γ. Τσιχριντζής: Editor-in-Chief του διεθνούς περιοδικού International journal of Knowledge and Web Intelligence by Inderscience Publishers.\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Associate Editors του διεθνούς περιοδικού  Intelligent Decision Technologies by IOS Press, An International Journal, ISSN: 1872-4981.\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Members  of the editorial board, Computational Intelligence and its Applications (COMIA) Book Series, Information Science Publishing\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Members of the editorial board, International Journal on Monitoring and Surveillance Technologies Research (IJMSTR), IGI Global Publishing\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Associate Editors του διεθνούς περιοδικού International journal of Knowledge and Web Intelligence by Inderscience Publishers.\n" +
                    "<br><br>• Γ. Τσιχριντζής: Member of the editorial board, Computational Biology and Bioinformatics, Science Publishing Group\n" +
                    "<br><br>• Γ. Τσιχριντζής: Member of the editorial board, ISRN Signal Processing, Hindawi Publishing Corporation\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Intelligent Interactive Multimedia Systems and Services, Smart Innovation, Systems and Technologies Series, Vol.11, Springer, Germany, 2010\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Intelligent Interactive Multimedia Systems and Services, Smart Innovation, Systems and Technologies Series, Vol.6, Springer, Germany, 2010\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Multimedia Services in Intelligent Environments – Integrated Systems, Smart Innovation, Systems and Technologies Series, Vol.3, Springer, Germany, 2010\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Multimedia Services in Intelligent Environments – Software Development Challenges and Solutions, Smart Innovation, Systems and Technologies Series, Vol.2, Springer, Germany, 2010\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, New Directions in Intelligent Interactive Multimedia, Studies in Computational Intelligence Series, Vol. 142, Springer, Germany, 2008\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Computational Intelligence Paradigms – Innovative Applications, Studies in Computational Intelligence Series, Vol. 137, Springer, Germany, 2008\n" +
                    "<br><br>• Γ. Τσιχριντζής: Co-editor, Multimedia Services in Intelligent Environments – Advanced Tools and Methodologies, Studies in Computational Intelligence Series, Vol. 120, Springer, Germany, 2008\n" +
                    "<br><br>• M. Βίρβου: Associate Editor του διεθνούς περιοδικού Knowledge and Information Systems (KAIS), by Springer. Impact Factor: 1,733 (2009). Το περιοδικό KAIS έχει καταλάβει την θέση 24/116 στην περιοχή των Information Systems, και  27 / 102 στην περιοχή της Artifiial Intelligence.\n" +
                    "<br><br>• Ν. Ασημακόπουλος: Τακτικό μέλος του Διεθνούς Συμβουλίου Global Association for Systems Thinking The Board of Advisors is the governing body of the Global Association for Systems Thinking®. They provide the senior leadership, expertise, and wise-counsel to enhance the success of the Association. Αναφέρεται στην ιστοσελίδα: http://www.globalast.org/board-of-advisors.html#nikitas\n" +
                    "<br><br>• Ν. Ασημακόπουλος: Ιδρυτής και Αρχισυντάκτης του διεθνούς περιοδικού IJASS του εκδοτικού οίκου INDERSCIENCE Editor-in-Chief of International Journal of Applied Systemic Studies. Αναφέρεται στην ιστοσελίδα: http://www.inderscience.com/jhome.php?jcode=ijass\n" +
                    "<br><br>• Ν. Ασημακόπουλος: Special Issue on Project Management in IJASS, in print. Guest Editor\n" +
                    "<br><br>• Ν. Ασημακόπουλος: Υπεύθυνος του Διεθνούς Συμποσίου στην Επαγγελματική Συστημική Symposium I: Professional Systemic. Αναφέρεται στην ιστοσελίδα: http://www.emcsr.net/symposium-i-professional-systemics/\n" +
                    "<br><br>• Δ. Δεσπότης:  Member of Editorial Boards\n" +
                    "<br><br>&nbsp&nbsp&nbsp• International Journal of Applied Management\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Journal of Information and Optimization Systems\n" +
                    "<br><br>&nbsp&nbsp&nbsp• International Journal of Multicriteria Decision Making\n" +
                    "<br><br>• Θ. Παναγιωτόπουλος: Πρόεδρος Κεντρικής Επιστημονικής Επιτροπής στο πλαίσιο υλοποίησης της πράξης «Θεσμός Αριστείας και ανάδειξη καλών πρακτικών στην πρωτοβάθμια και δευτεροβάθμια εκπαίδευση».\n" +
                    "<br><br>• Θ. Παναγιωτόπουλος: Mέλος Διοικητικού Συμβουλίου Ελληνικής Εταιρείας Τεχνητής Νοημοσύνης (ΕΕΤΝ)\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Ισόβιο μέλος Endowment, Int'l Symposium on Spatial and Temporal Databases – SSTD, Μάρτιος 2010.\n" +
                    "<br><br>• Κ. Μεταξιώτης: EU Monitor on behalf of DG ENLARG\n" +
                    "<br><br>• Κ. Μεταξιώτης: Editor-in-Chief of the International Journal of Knowledge-Based Development (IJKBD)\n" +
                    "<br><br>• Άγγελος Πικράκης: 2008-σήμερα, Associate Editor του διεθνούς περιοδικού EURASIP Journal on Advances in Signal Processing (JASP), Springer, http://asp.eurasipjournals.com/. Impact factor 0.88.\n" +
                    "<br><br>• Α. Πικράκης: 2011, Εκλεγμένο μέλος του Board of Directors του διεθνούς οργανισμού επεξεργασίας σήματος European Association for Signal Processing (EURASIP, http://www.eurasip.org). Η θητεία του λήγει το 2014.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==6){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Αποφοίτων του Τμήματος Πληροφορικής");
            String linkText = "<b><u>Γεώργιος Καρνάς</b></u>\n" +
                    "<br><br>Ο Γεώργιος Καρνάς είναι αριστούχος απόφοιτος του προπτυχιακού προγράμματος σπουδών από την κατεύθυνση:ΤΛΕΣ (Τεχνολογία Λογισμικού και Ευφυή Συστήματα). Από τον Οκτώβριο 2011 εργάζεται στο FACEBOOK στην California σε υψηλή θέση. Ήταν στα πρωτοσέλιδα των Ελληνικών εφημερίδων για την επιτυχία αυτή σε καιρό κρίσης για την Ελλάδα.\n" +
                    "\n" +
                    "\n" +
                    "<br><br><br><b><u>Μιχάλης Μανιατάκος</b></u>\n" +
                    "<br><br><b>Ph.D. candidate, Yale University</b>\n" +
                    "<br>Ο Μιχάλης Μανιατάκος είναι αριστούχος απόφοιτος:\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• του προπτυχιακού προγράμματος του Τμήματος Πληροφορικής, Παν. Πειραιά, από την κατεύθυνση: Δίκτυα και Υπολογιστικά Συστήματα και\n" +
                    "<br><br>&nbsp&nbsp&nbsp• του ΠΜΣ «Προηγμένα Συστήματα Πληροφορικής» του Τμήματος Πληροφορικής, Παν. Πειραιά.\n" +
                    " \n" +
                    "\n" +
                    "<br><br><br><b><u>Μαρία Μουντρίδου</b></u>\n" +
                    "<br><br><b>Επίκουρος Καθηγήτρια</b>\n" +
                    "<b>ΑΝΩΤΑΤΗ ΣΧΟΛΗ ΠΑΙΔΑΓΩΓΙΚΗΣ ΚΑΙ ΤΕΧΝΟΛΟΓΙΚΗΣ ΕΚΠΑΙΕΔΥΣΗΣ (ΑΣΠΑΙΤΕ)</b>\n" +
                    "2002 : Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "\n" +
                    "<br><br><br><b><u>Εμμανουήλ Μάγκος</b></u>\n" +
                    "<br><br><b>Επίκουρος Καθηγητής</b>\n" +
                    "<b>Τμήμα Πληροφορικής, Ιόνιο Πανεπιστήμιο</b>\n" +
                    "\n" +
                    "<br><br>Εκπαίδευση:\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα σε “Ασφαλή Ηλεκτρονικά Συστήματα Συναλλαγών μέσω Internet”, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "<br><br><br><b><u>Σπύρος Βοσινάκης</b></u>\n" +
                    "<br><br><b>Επίκουρος Καθηγητής</b>\n" +
                    "<b>Τμήμα Μηχανικών Σχεδίασης Προϊόντων και Συστημάτων, Πανεπιστημίου Αιγαίου</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• 2003 : Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• 1998: Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "<br><br><br><b><u>Ιωάννης Παπαδάκης</b></u>\n" +
                    "<br><br><b>Επίκουρος Καθηγητής Τμήμα Αρχειονομίας - Βιβλιοθηκονομίας</b>\n" +
                    "<b>Ιόνιο Πανεπιστήμιο\n</b>" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    " \n" +
                    "\n" +
                    "<br><br><br><b><u>Κατερίνα Καμπάση</b></u>\n" +
                    "<br><br><b>Καθηγήτρια εφαρμογών,</b>\n" +
                    "<b>Αναπληρώτρια Προϊσταμένη,</b>\n" +
                    "<b>Τμήμα Τεχνολογίας, Οικολογίας και Περιβάλλοντος, ΤΕΙ Ιονίων Νήσων</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    " \n" +
                    "\n" +
                    "<br><br><br><b><u>Παναγιώτης  Κοτζανικολάου</b></u>\n" +
                    "<br><br><b>Λέκτορας\n" +
                    "Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "<b><u>Ευθύμιος Αλέπης</b></u>\n" +
                    "<b>Λέκτορας Υπό Διορισμό,\n" +
                    "Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "<br><br><br><b><u>Κωνσταντίνος Πατσάκης</b></u>\n" +
                    "<br><br><b>Λέκτορας Υπό Διορισμό,\n" +
                    "Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς</b>\n" +
                    "\n" +
                    "<br><br>Εκπαίδευση:\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• M.Sc. University of London\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Μαθηματικών, Πανεπιστήμιο Αθηνών\n" +
                    "\n" +
                    "<br><br><br><b><u>Άννα Σταυριανού</b></u>\n" +
                    "<br><br><b>Position:ATER (Temporary Assistant Professor)\n" +
                    "Affiliation:University of Lyon 2</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "\n" +
                    "<br><br><br><b><u>Γεώργιος Κατσιρέλος</b></u>\n" +
                    "<br><br><b>Post-doctoral Researcher,\n" +
                    "University of Toronto</b>\n" +
                    "\n" +
                    "<br><br>Εκπαίδευση:\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Current activities: Senior PC member of IJCAI'11; PC member of SAT 2011, CP 2011; Chair of SymCon 2011.\n" +
                    "\n" +
                    "<br><br><br><b><u>Κατερίνα Μητροκώστα</b></u>\n" +
                    "<br><br><b>Postdoctoral researcher,\n" +
                    "Faculty of Electrical Engineering, Mathematics and Computer Science\n" +
                    "Delft University of Technology,\n" +
                    "Netherlands.</b>\n" +
                    "\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Διδακτορικό Δίπλωμα, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς\n" +
                    "<br><br>&nbsp&nbsp&nbsp• Πτυχίο, Τμήμα Πληροφορικής, Πανεπιστήμιο Πειραιώς";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==7){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2013");
            String linkText = "• Μ. Βίρβου: Διεθνής διάκριση- 8ο κορυφαίο άρθρο στην κατηγορία άρθρων πλήρους μεγέθους ολόκληρου του περιοδικού EDUCATIONAL TECHNOLOGY & SOCIETY, το οποίο έχει impact factor 1,067: Μαρία Βίρβου, Γεώργιος Κατσιώνης και Κωνσταντίνος Μανός: Η εργασία:  \"Combining software games with education: Evaluation of its educational effectiveness” EDUCATIONAL TECHNOLOGY & SOCIETY, Journal of International Forum of Educational Technology & Society and IEEE Learning Technology Task Force, 8 (2): 54-65 APR 2005. Το άρθρο έχει κατέβει 10381 φορές και αριθμεί περισσότερες από 100 ετεροαναφορές.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Γενικοί Πρόεδροι του διεθνούς συνεδρίου 2013 IEEE International Conference on Computer, Information and Telecommunication Systems (CITS2013), Piraeus, Greece, May 7-10, 2013.\n" +
                    "<br><br>• Μ. Βίρβου: Προσκεκλημένη Ομιλήτρια του διεθνούς συνεδρίου 2013 IEEE International Conference on Computer, Information and Telecommunication Systems (CITS2013), Piraeus, Greece, May 7-10, 2013.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: General and program co-chairs of the 2013 International Conference on Intelligent Interactive Multimedia Systems and Services (KES-IIMSS 2013), Sesimbra, Portugal, June 26-28, 2013.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: General and program co-chairs of the 4th IEEE International Conference on Information, Intelligence, Systems and Applications (IISA2013), Piraeus, Greece, July 10-12, 2013.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: General and program co-chairs of the 2013 International Conference on Innovation in Medicine and Healthcare (KES-INMED2013), Piraeus, Greece, July 17-19, 2013.\n" +
                    "<br><br>• Μ. Βίρβου: Program co- chair of the 10th International Conference on Signal Processing and Multimedia Applications (SIGMAP 2013), 29-31 July, 2013.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==8){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2012");
            String linkText = "• Μ. Βίρβου: General co-chair: Τhe Tenth International Conference on Knowledge-Based Software Engineering, JCKBSE 2012, Rodos, Greece, August 23-26, 2012\n" +
                    "<br><br>• Tsihrintzis, G.A., Virvou, M.. General co-chairs: 8th International Conference on Intelligent Information Hiding and Multimedia Signal Processing, IEEE IIH-MSP 2012\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Guest Editors, George A. Tsihrintzis, Maria Virvou, Ioannis Hatzilygeroudis. International Journal on Artificial Intelligence Tools 21(2)\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Προσκεκλημένοι συν-επιμελητές (guest co-editors) του ειδικού τεύχους “Multimedia/Multimodal Human-Computer Interaction in Knowledge-based Environments” of the Intelligent Decision Technologies Journal (IOS Press, 2012).\n" +
                    "<br><br>• Γ. Τσιχριντζής, Μ. Βίρβου, Ι. Χατζηλυγερούδης: Προσκεκλημένοι συν-επιμελητές (guest co-editors) του ειδικού τεύχους “Intelligent Interactive Multimedia” of the International Journal on Artificial Intelligence Tools (World Scientific Publishing, 2012).\n" +
                    "<br><br>• Θ. Παναγιωτόπουλος και Γ. Τσιχριντζής: Συν-πρόεδροι του Διεθνούς Συνεδρίου 24th IEEE International Conference on Tools with Artificial Intelligence (IEEE ICTAI 2012), November 7-9, 2012, Athens, Greece\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Συν-Πρόεδροι του Διεθνούς Συμποσίου 5th IEEE International Symposium on Monitoring and Surveillance Research: Healthcare-Safety-Security, Athens, Greece, November 9, 2012.\n" +
                    "<br><br>• Δ. Δεσπότης:  International Conference on Optimization, Computing & Business Analytics (ICOCBA 2012), December 20th - 22nd, 2012, Kolkata, India (invited speaker).\n" +
                    "<br><br>• Δ. Δεσπότης: International Conference on Business Performance Measurement and Management, September 11-13  2012, Lima, Peru (Advisory committee)\n" +
                    "<br><br>• Δ. Δεσπότης: EURO 2012, 25th European Conference on Operational Research, Vilnius, Lithuania, July 8-11, 2012 (DEA and Performance Measurement Stream organizer)\n" +
                    "<br><br>• Ι. Θεοδωρίδης: General co-Chair, “Panhellenic Conference on Informatics (with International participation)” (PCI), Piraeus, Oct. 2012.\n" +
                    "<br><br>• Δ. Αποστόλου: BEST PAPER AWARD: K. Christidis, D. Apostolou and G. Mentzas, \"A Socially Intelligent Approach for Enterprise Information Search and Recommendation\", 18th International ICE-Conference on Engineering, Technology and Innovation, 18 - 20 June 2012, Munich.\n" +
                    "<br><br>• Δ. Πολέμη: Συν-διοργανώτρια του συνεδρίου : I3E2013 IFIP on e-Business, e-Services, and e-Society, 25-26/4/13.\n" +
                    "<br><br>• Δ. Πολέμη: Οργανώτρια special session και μέλος τη οργανωτικής επιτροπής  του συνεδρίου 16th Panhellenic Conference on Informatics with international participation PCI2012 5-7/10/12\n" +
                    "<br><br>• Δ. Πολέμη: Συν-διοργανώτρια του συνεδρίου ISACA “Information Assurance at a Crossroad: Choosing a New Strategic path through Security, Governance and IT Audit Best Practices”, 7/12/12\n" +
                    "<br><br>• Δ. Πολέμη: Μέλος οργανωτικής επιτροπής του διεθνούς συνεδρίου “International Conference on Wireless Information Networks and Systems” - WINSYS 2012, 29-31/7/12\n" +
                    "<br><br>• Δ. Πολέμη: Μέλος οργανωτικής επιτροπής του διεθνούς συνεδρίου «Methodologies, Technologies and Tools enabling e–Government», Σερβία 3-5 Ιουλίου 2012\n" +
                    "<br><br>• Α. Πικράκης: Area Chair (Audio and Electroacoustics), 21st European Signal processing Conference (EUSIPCO), Sep 2013, Marrakesh, Morocco, www.eusipco2013.org\n" +
                    "<br><br>• M. Ψαράκης: Publicity chair, IEEE International On-Line Testing Symposium, Sitges, Spain, June 2012.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==9){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2010");
            String linkText = "• Μ. Βίρβου: Γενική Πρόεδρος (General co-chair) στο διεθνές συνέδριο που πραγματοποιήθηκε το 2010: 5th International Conference on Software and Data Technologies (ICSOFT 2010), University of Piraeus, 22-24 July 2010.\n" +
                    "<br><br>• Γ. Τσιχριντζής: Γενικός Πρόεδρος (General co-chair) στο διεθνές συνέδριο που πραγματοποιήθηκε το 2010:ICETE 2010 – 7th International Joint Conference on e-Business and Telecommunications. Το συνέδριο συμπεριλάμβανε 6 υπο-συνέδρια:\n" +
                    "<br><br>•   DCNET,  International Conference on Data Communication and Networking\n" +
                    "<br><br>•   ICE-B, International Conference on e-Business\n" +
                    "<br><br>•   OPTICS,  International Conference on Optical Communication Systems\n" +
                    "<br><br>•   SECRYPT, International Conference on Security and Cryptography\n" +
                    "<br><br>•   SIGMAP,  International Conference on Signal Processing and Multimedia Appilcations\n" +
                    "<br><br>•   WINSYS, International Conference on Wireless Information Networks and Systems\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μαρία Βίρβου: Πρόεδροι της Επιτροπής Προγράμματος SIGMAP 2010,  International Conference on Signal Processing and Multimedia Applcations.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Γενικοί και Ιδρυτικοί Συν-Πρόεδροι (General co-chairs) στο διεθνές συνέδριο που πραγματοποιήθηκε το 2010: 1st  International Multi-Conference on Innovative Developments in ICT (INNOV 2010), University of Piraeus,29-31 July2010.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Γενικοί Συν-Πρόεδροι (co-chairs) και Πρόεδροι της Επιτροπής Προγράμματος στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems- 3rd  International Symposium on Intelligent Interactive Multimedia Systems and Services (KES-IIMSS 2010),  Baltimore, U.S.A., 28-30 July 2010.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Προσκεκλημένοι συν-επιμελητές (guest co-editors) του ειδικού τεύχους “Knowledge-based Modes of Human-Computer Interaction” of the Intelligent Decision Technologies Journal (IOS Press, 2010).\n" +
                    "<br><br>• Μ. Βίρβου: Editors José A. Moinhos Cordeiro, Maria Virvou, Boris Shishkov: ICSOFT 2010 - Proceedings of the Fifth International Conference on Software and Data Technologies, Volume 1, Athens, Greece, July 22-24, 2010 SciTePress 2010\n" +
                    "<br><br>• Μ. Βίρβου: Editors José A. Moinhos Cordeiro, Maria Virvou, Boris Shishkov: ICSOFT 2010 - Proceedings of the Fifth International Conference on Software and Data Technologies, Volume 2, Athens, Greece, July 22-24, 2010 SciTePress 2010\n" +
                    "<br><br>• Μ. Βίρβου: Διεθνής διάκριση: Στα 25 πιο πολυδιαβασμένα άρθρα του περιοδικού Computers and Education, το οποίο έχει impact factor 2.059, για την πενταετία 2005-2010: Η εργασία με τίτλο  “Mobile educational features in authoring tools for personalised  tutoring” από τους M. Virvou & E. Alepis, 2005 που έχει δημοσιευθεί στο journal COMPUTERS & EDUCATION, Vol 44, No. 1, pp. 53-68, Jan. 2005, Elsevier Science.\n" +
                    "<br><br>• Δ. Δεσπότης: EURO 2010, 24th European Conference on Operational Research, Lisbon, Portugal, July 11-14, 2010 (DEA and Performance Measurement Stream organizer)\n" +
                    "<br><br>• Χ. Δουληγέρης: International Liaison Co-Chair of IEEE Globecom 2010, The Insitute of Electrical and Electronic Engineers Global Communications Conference Exhibition and Industry Forum, 6-10 December, Miami FL, 2010.\n" +
                    "<br><br>• Χ. Δουληγέρης:  Για την εργασία \"An Analysis of Bluetooth, Zigbee and Bluetooth Low Energy and their use in WBANs\" που παρουσιάστηκε από τον συν-συγγραφέα Emmanouil Georgakakis στο MOBIHEALTH 2010, the International ICST Conference on Wireless Mobile Communications and Healthcare, απονεμήθηκε Best Student Paper Award.\n" +
                    "<br><br>• Χ. Δουληγέρης: General Co-Chair of the IEEE CAMAD, Computer Aided Modeling and Design of Communication Links and Systems Workshop, Miami Florida, Dec.3-4, 2010.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Πρόεδρος Οργανωτικής Επιτροπής στο \"1st Summer School on Mobility, Data Mining, and Privacy\" (MODAP), Ρόδος, Σεπτέμβριος 2010.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Προσκεκλημένος ομιλητής σε σειρά διαλέξεων (PhD short course) με τίτλο \"From Mobility Data Management to Location-based Services\", στα πλαίσια του PhD Studies Program, University of Venice, Italy, Ιούνιος 2010.\n" +
                    "<br><br>• Α. Πικράκης: Co-author of: S. Theodoridis, A. Pikrakis, K. Koutroumbas and D. Cavouras, \"Introduction to Pattern Recognition: a Matlab Approach\", Academic Press (imprint of Elsevier Science), 2010.\n" +
                    "<br><br>• A. Πικράκης :Techncal Program Committee member (TPC member) in various signal processing and pattern recognition conferences, including IEEE ISCAS 2013, EUSIPCO-2012, DSP 2011, ICPR 2010.\n" +
                    "<br><br>• M. Ψαράκης: Publication chair, IEEE International On-Line Testing Symposium, Corfu, Greece, July 2010.\n" +
                    "<br><br>• M. Ψαράκης: The article “Microprocessor Software-Based Self-Testing”, M. Psarakis, D. Gizopoulos, E. Sanchez, and M. Sonza Reorda, IEEE Design & Test of Computers, vol.27, no. 3, pp. 4-19, May/June 2010” was selected by the IEEE Computer Society among the articles of its 13 magazines to be published in the monthly version (June 2010) of the webpage Computing Now (http://computingnow.computer.org).\n" +
                    "<br><br>• M. Ψαράκης: Organizing Liaison of Test Technology Educational Program (TTEP), IEEE Computer Society TTTC: 2007, 2008, 2009, 2010.\n" +
                    "<br><br>• M. Ψαράκης: Session Chair, IEEE Design Automation and Test in Europe (DATE), Dresden, Germany, March 2010.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==10){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2011");
            String linkText = "• 2011: Outstanding Paper Award Winner at the Emerald Literati Network (Awards for Excellence 2011) for the paper titled: Dimitrios Patsos, Sarandis Mitropoulos, Christos Douligeris, (2010) \"Expanding topological vulnerability analysis to intrusion detection through the incident response intelligence system\", Information Management & Computer Security, Vol. 18 Iss: 4, pp.291 - 309\n" +
                    "<br><br>• Μ. Βίρβου: Keynote speaker στο συνέδριο CIE2011-Conference on Informatics in Education, Η Πληροφορική στην Εκπαίδευση 2011, 7-9 Οκτωβρίου 2011, Πειραιάς 2011.\n" +
                    "<br><br>• Μ. Βίρβου: Keynote speaker στο διεθνές συνέδριο International Conference on Computer Graphics and Artificial Intelligence 2011 (3ΙΑ 2011), Athens, 27-28 May 2011.\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Γενικοί Συν-Πρόεδροι (co-chairs) και Πρόεδροι της Επιτροπής Προγράμματος στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems - 4th International Symposium on Intelligent Interactive Systems and Services, Piraeus, Greece, July 20-22, 2011\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Συν-Πρόεδροι (local co-chairs) τοπικής διoργάνωσης στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems – 3rd International Coference on Intelligent Decision Technologies, Piraeus, Greece, July 20-22, 2011\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Γενικοί Συν-Πρόεδροι (co-chairs) και Πρόεδροι της Επιστημονικής Επιτροπής Προγράμματος στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems -4th International Symposium on Intelligent Interactive Systems and Services, Piraeus, Greece, July 20-22, 2011.\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Συν-Πρόεδροι (local co-chairs) τοπικής διoργάνωσης στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems – 3rd International Coference on Intelligent Decision Technologies, Piraeus, Greece, July 20-22, 2011.\n" +
                    "<br><br>• Μ. Βίρβου και Γ. Τσιχριντζής: Προσκεκλημένοι συν-επιμελητές (guest co-editors) του ειδικού τεύχους “Knowledge-based Environments and Services in Human-Computer Interaction” of the Intelligent Decision Technologies Journal (IOS Press, 2011).\n" +
                    "<br><br>• Γ. Τσιχριντζής: Συν-πρόεδρος της Επιτροπής Προγράμματος  International Conference on Signal Processing and Multimedia Applications, Seville, Spain, July 18-21, 2011.\n" +
                    "<br><br>• Δ. Δεσπότης: International Conference on Data Envelopment Analysis and Its Applications to Management, September 14-16, 2011, Lima, Peru (International Scientific and Advisory Committee)\n" +
                    "<br><br>• Χ. Δουληγέρης: Technical Programme Committee Co-Chair of ICT 2011, International Conference on Communications, which will be held in Ayia Nappa, Cyprus, May 8-11, 2011.\n" +
                    "<br><br>• Χ. Δουληγέρης: Program co-Chair of IEEE ISCC International Symposium on Computers and Communications, which will be held in Corfu, Greece, June 28-July2, 2011.\n" +
                    "<br><br>• Χ. Δουληγέρης: μέλος της διοργανωτικής επιτροπής του Panhellenic Conference of Informatics (PCI2011), Kastoria Greece, Sept 28-30, 2011.\n" +
                    "<br><br>• Θ. Παναγιωτόπουλος: Διευθυντής Εθνικής Σχολής Δημόσιας Διοίκησης (Ε.Σ.Δ.Δ.) του Εθνικού Κέντρου Δημόσιας Διοίκησης και Αυτοδιοίκησης (Ε.Κ.Δ.Δ.Α.), 2005-2010.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Πρόεδρος (General co-Chair) στο \"European Conference on Machine Learning and Principles and Practice of Knowledge Discovery in Databases\" (ECML/PKDD), Αθήνα, Σεπτέμβριος 2011.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Επιμελητής ειδικού τεύχους (Guest Editor) στο διεθνές επιστημονικό περιοδικό Int. J. Data Warehousing & Mining, special issue on GeoPKDD project results, vol. 7(1): 2011.\n" +
                    "<br><br>• Δ. Πολέμη: Μέλος οργανωτικής επιτροπής του συνεδρίου «IFIP2011: e-government, e-business, e-society», http://isd.ktu.lt/I3E2011/, Λιθουανία , 12-14 October 2011\n" +
                    "<br><br>• Χ. Κωνσταντόπουλος: (Νοέμ. 2011) – Κύριος Ερευνητής στο ευρωπαϊκό FP7 ερευνητικό έργο  \"eCOMPASS (eCO-friendly urban Multi-modal route Planning services for mobile users)\" τύπου STREP (Small or medium-scale focused research project), Διάρκεια έργου: 36 μήνες. Αντικείμενο έργου: η αλγοριθμική βελτιστοποίηση διαδρομών σε αστικά περιβάλλοντα με κύριο στόχο την αντιμετώπιση των περιβαλλοντικών επιπτώσεων της αστικής κινητικότητας.\n" +
                    "<br><br>• Κ. Μεταξιώτης: Best Presenter Award 2011\n" +
                    "<br><br>• M. Ψαράκης: Management committee substitute member of the EU-funded COST action (European Cooperation in the field of Scientific and Technical Research). IC1103: Manufacturable and Dependable Multicore Architectures at Nanoscale (12/2011-11/2015).\n" +
                    "<br><br>• M. Ψαράκης: Award from the European Network of Excellence on High Performance and Embedded Architecture and Compilation [HiPEAC] for the paper: “Accelerating Microprocessor Silicon Validation by Exposing ISA Diversity”, N.Foutris, D.Gizopoulos, M.Psarakis, X.Vera, A.Gonzalez, ACM/IEEE International Symposium on Microarchitecture (MICRO 2011), Porto Alegre, Brazil, December, 2011.\n" +
                    "<br><br>• M. Ψαράκης: Publication chair, IEEE International On-Line Testing Symposium, Athens, Greece, July 2011.\n" +
                    "<br><br>• M. Ψαράκης: Publication chair, IEEE Design for Reliability and Variability Workshop (DRV 2011), Dana Point, California, USA, May 2011.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==11){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2009");
            String linkText = "• Γ. Τσιχριντζής και Μ. Βίρβου: Επίτιμοι Πρόεδροι (Honorary chairs) στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems- 2nd International Symposium on Intelligent Interactive Multimedia Systems and Services (KES-IIMSS 2008),  Mogliano Veneto, near Venice (hosted by the University of Milan) Italy, 16-17 July 2009 (http://iimss-09.kesinternational.org).\n" +
                    "<br><br>• Γ. Τσιχριντζής και Μ. Βίρβου: Προσκεκλημένοι συν-επιμελητές (guest co-editors) του ειδικού τεύχους “Intelligent Modelling and Data Analysis Techniques” of the International Journal of Intelligent Defence Support Systems (Inderscience, 2009).\n" +
                    "<br><br>• Γ. Τσιχριντζής: Europe liaison του διεθνούς συνεδρίου: The Fifth IEEE International Conference on Intelligent Information Hiding and Multimedia Signal Processing (IIH-MSP 2009), September 12-14, 2009.\n" +
                    "<br><br>• Διεθνές βραβείο για μία από τις καλύτερες εφαρμοσμένες εργασίες (One of the Best Applications Papers Award): Ιωάννα Ουρανία Σταθοπούλου, Ευθύμιος Αλέπης, Γεώργιος Τσιχριντζής, Μαρία Βίρβου: of the 29th Annual International Conference of the British Computer Society Specialist Group on Artificial Intelligence, Cambridge, UK, December 15-17, 2009, for co-authoring a paper titled: “On Assisting a Visual-Facial Affect Recognition System with Keyboard-Stroke Pattern Information.”\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Συν-συγγραφέας της ερευνητικής εργασίας \"Clustering Trajectories of Moving Objects in an Uncertain World\", η οποία βραβεύτηκε με best application paper award στο πλαίσιο του IEEE Int'l Conference on Data Mining, ICDM'09, Miami – FL, USA, Δεκέμβριος 2009 (με N. Pelekis, I. Kopanakis, E. Kotsifakos, E. Frentzos).\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Αντιπρόεδρος της Διοικούσας Επιτροπής (Vice-Chair of the Management Committee) στο Ευρωπαϊκό ερευνητικό δίκτυο \"Knowledge Discovery from Moving Objects (MOVE)\", χρηματοδοτούμενο από ESF/COST Programme, Σεπτέμβριος 2009 – Αύγουστος 2013.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Προσκεκλημένος ομιλητής σε εκπαιδευτική παρουσίαση (tutorial) με θέμα \"Geographic Privacy-aware Knowledge Discovery and Delivery\", στο πλαίσιο του Int'l Conference on Extending Database Technology, EDBT'09, St Petersburg, Russia, Μάρτιος 2009 (με F. Giannotti, D. Pedreschi).\n" +
                    "<br><br>• M. Ψαράκης: Publication chair, IEEE International On-Line Testing Symposium, Sesimbra-Lisbon, Portugal, June 2009.\n" +
                    "<br><br>• M. Ψαράκης: Session Chair, IEEE Design Automation and Test in Europe (DATE), Nice, France, April 2009.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==12){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2008");
            String linkText = "• Γ. Τσιχριντζής και Μ. Βίρβου: Γενικοί Ιδρυτικοί Συν-Πρόεδροι και Πρόεδροι της Επιτροπής Προγράμματος (General  co-chair and Program co-chair) στο διεθνές συνέδριο: Knowledge-Based and Intelligent Information & Engineering Systems- 1st International Symposium on Intelligent Interactive Multimedia Systems and Services (KES-IIMSS 2008), 9-11 July 2008, University of Piraeus, Piraeus, Greece. Το συμπόσιο βασίστηκε σε πρόταση των co-chairs εφ’ όλης της ακαδημαϊκής θεματολογίας και ύλης και αποτελεί το πρώτο σε σειρά συμποσίων που ακολούθησαν και θα ακολουθήσουν στην θεματολογία του.\n" +
                    "<br><br>• Μ. Βίρβου: Γενική Συν-Πρόεδρος και Πρόεδρος της Επιτροπής Προγράμματος (General  co-chair and Program co-chair) στο διεθνές συνέδριο: 8th Joint Conference on Knowledge-Based Software Engineering (JCKBSE 2008), 25-28 August 2008, University of Piraeus, Piraeus, Greece.Το συνέδριο συνδιοργανώθηκε με την Ιαπωνική Εταιρεία Τεχνητής Νοημοσύνης και το Ιαπωνικό IEEE Τμήμα επιστημόνων Τεχνολογίας Λογισμικού. (http://jckbse08.cs.unipi.gr/)\n" +
                    "<br><br>• Γ. Τσιχριντζής: Διεθνές βραβείο καλύτερης εργασίας σε μορφή poster (Best Poster Paper Award): Παρασκευή Λαμπροπούλου, Αριστομένης Λαμπρόπουλος, Γεώργιος Τσιχριντζής: του 5th International Conference on Information Technology: New Generations, Las Vegas, USA, April 7-9, 2008, for co-authoring a paper titled: “Evaluation of a Middleware System for Accessing Digital Music Libraries in Mobile Services.”Γεώργιος Τσιχριντζής: Απονομή τίτλου ‘Gold Member” στην επιστημονική οργάνωση Knowledge-Based & Intelligent Engineering Systems KES International ως αναγνώριση της επιστημονικής της προσφοράς.\n" +
                    "<br><br>• Μ. Βίρβου: Απονομή τίτλου ‘Gold Member” στην επιστημονική οργάνωση Knowledge-Based & Intelligent Engineering Systems KES International ως αναγνώριση της επιστημονικής της προσφοράς.\n" +
                    "<br><br>• Γ. Τσιχριντζής: Απονομή τίτλου “Gold Member” στην επιστημονική οργάνωση Knowledge-Based & Intelligent Engineering Systems KES International ως αναγνώριση της επιστημονικής του προσφοράς.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Αναπληρωτής Πρόεδρος Επιτροπής Προγράμματος (Vice PC Chair) στο 8th IEEE Int'l Conference on Data Mining (ICDM), Δεκέμβριος 2008.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Επιμελητής ειδικού τεύχους (Guest Editor) στο διεθνές επιστημονικό περιοδικό Int. J. Business Intelligence & Data Mining, special issue on \"KDD for Decision Making and Optimisation\", vol. 3(1):2008.\n" +
                    "<br><br>• X. Κωνσταντόπουλος: Η εργασία Aristides Mpitziopoulos, Damianos Gavalas, Charalampos Konstantopoulos, Grammati Pantziou, “Exploiting the Cloning Capability of Mobile Agents for Cost-Effective Data Fusion in Wireless Sensor Networks”, Proceedings of the 13th IEEE Symposium on Computers and Communications (ISCC’08),  pp. 963-968, Marrakech, Morocco, 2008 έλαβε το βραβείο της καλύτερης εργασίας στο συνέδριο ISCC'08.\n" +
                    "<br><br>• M. Ψαράκης: Session Chair, IEEE International On-Line Testing Symposium, Rhodes, Greece, July 2008.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==13){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2007");
            String linkText = "• Best Student Paper Award. T. Giannakopoulos, A. Pikrakis and S. Theodoridis, \"A Multi-Class Audio Classification Method With Respect To Violent Content In Movies, Using Bayesian Networks\", Proceedings of the IEEE 2007 Internatinal Workshop on Multimedia Signal Processing (IEEE MMSP-07), Chania, Crete, Greece, October 1-3, 2007.\n" +
                    "<br><br>• M. Βίρβου: Σημαντική διεθνής αναφορά για την εργασία με τίτλο  “Mobile educational features in authoring tools for personalised  tutoring” από τους M. Virvou & E. Alepis, 2005 που έχει δημοσιευθεί στο journal COMPUTERS & EDUCATION, Vol 44, No. 1, pp. 53-68, Jan. 2005, Elsevier Science: Ο Professor Motiwalla από το Πανεπιστήμιο της Μασαχουσέτης αναφέρει σε επισκόπηση πεδίου που πραγματοποίησε σε άρθρο του (Computers and Education 2007) ότι « η εργασία (Virvou & Alepis, 2005) αποτελεί την πιο πλήρη εργασία στην διεθνή βιβλιογραφία στο θέμα του κινητού εκπαιδευτικού λογισμικού μέχρι τώρα». Το άρθρο αυτό του Professor Motiwalla:  Mobile learning: A framework and evaluation Volume 49, Issue 3, 2007, pp 581-596  συγκαταλέγεται στα 10 most cited άρθρα του περιοδικού Computers and Education.\n" +
                    "<br><br>• Μ. Βίρβου: Διάκριση στα καλύτερα άρθρα του ICSOFT 2007 για την εργασία: Kabassi, K., Virvou, M. & Alepis, E. (2009) “Testing the Effectiveness of MBIUI Life-Cycle Framework for the  Development of Affective Interfaces»  In  Communications in Computer and Information Science, Software and  Data Technologies, Volume 22, βραβεύθηκε στα Best Papers of ICSOFT 2007, Springer-Verlag Berlin Heidelberg,  pp. 159-171.\n" +
                    "<br><br>• Μ. Βίρβου: Διάκριση στα καλύτερα άρθρα ICSOFT 2007 για την εργασία: Alepis, E., Virvou, M. & Kabassi, K. (2009) “Knowledge Engineering Aspects of Affective Bi-Modal Educational Applications” In Communications in Computer and Information Science, E-business and Telecommunications, Volume 23, βραβεύθηκε στα Best Papers of ICSOFT 2007, Springer-Verlag Berlin Heidelberg, pp. 328-339.\n" +
                    "<br><br>• Γ. Τσιχριντζής: I.-O. Stathopoulou and G.A. Tsihrintzis, Recent Developments in Automated Inferencing of Emotional State from Face Images, in: Joaquim Filipe, Boris Shishkiv, and Markus Helfert, (Eds.), Communications in Computer and Information Science, Springer, 2008 (invited chapter, ranked in  the top 20% of the papers accepted in  ICSOFT2007)\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Πρόεδρος Επιτροπής Προγράμματος (PC Chair) στο 6ο Ελληνικό Συμπόσιο Διαχείρισης Δεδομένων (Hellenic Data Management Symposium – HDMS), Αθήνα, Ιούλιος 2007.\n" +
                    "<br><br>• Ι. Θεοδωρίδης: Προσκεκλημένος ομιλητής (invited speaker) με θέμα \"Business Intelligence – Methodologies, Techniques and Applications in Marketing\", στο πλαίσιο του Πανελλήνιου Συνεδρίου για Νέες Τεχνολογίες & Marketing, NTM'07, Ιεράπετρα - Κρήτη, Μάιος 2007.\n" +
                    "<br><br>• Δ. Πολέμη: Πρόεδρος οργανωτικής επιτροπής ημερίδας “Secure e/m-Government enhancing  cooperation with  non-EU regions” στα πλαίσια του IEEE PIMRC 2007 18th IEEE International Symposium on Personal, Indoor and Mobile Radio Communications, http://www.pimrc2007.org, Αθήνα, 3-7 Σεπτέμβριου 2007\n" +
                    "<br><br>• Π. Κοτζανικολάου: Προσκεκλημένο μέλος σε Διεθνείς Ομάδες Εργασίας (Invited Member to Work Groups)\n" +
                    "<br><br>• Μέλος του “European Security Research and Innovation Forum” (ESRIF) (Σεπτέμβριος 2007 – Δεκέμβριος 2009):  Η Ομάδα Εργασίας ESRIF αποτέλεσε ένα forum υπό την αιγίδα της Ευρωπαϊκής Επιτροπής, με βασικό στόχο τον καθορισμό των βραχυπρόθεσμων και μεσοπρόθεσμων ερευνητικών στόχων της Ευρωπαϊκής Ένωσης σε θέματα ασφάλειας και τον καθορισμό της Ερευνητικής Ατζέντας (Joint Security Research Agenda).";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==14){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2006");
            String linkText = "• Μαρία Βίρβου: 1ο βραβείο από το Κέντρο Ερευνών του Πανεπιστημίου Πειραιώς για τις δημοσιεύσεις σε διεθνή περιοδικά των μελών ΔΕΠ του Πανεπιστημίου Πειραιώς για το έτος 2005-2006.<br><br>" +
                    "• Γεώργιος Τσιχριντζής: βραβείο από το Κέντρο Ερευνών του Πανεπιστημίου Πειραιώς για τις δημοσιεύσεις σε διεθνή περιοδικά των μελών ΔΕΠ του Πανεπιστημίου Πειραιώς για το έτος 2005-2006.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==15){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2005");
            String linkText = "• Θ. Παναγιωτόπουλος: Διοργανωτής Διεθνούς Συνεδρίου «5th International Working Conference on Intelligent Virtual Agents» (IVA 2005) Κως, 12-14 Σεπτεμβρίου 2005.";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }else if(id==16){
            title_details.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title_details.setText("Διακρίσεις Τμήματος 2004");
            String linkText = "• Μ. Βίρβου: 1ο βραβείο από το Κέντρο Ερευνών του Πανεπιστημίου Πειραιώς για τις δημοσιεύσεις σε διεθνή περιοδικά των μελών ΔΕΠ του Πανεπιστημίου Πειραιώς για το έτος 2003-2004.\n" +
                    "<br><br>• Γ. Τσιχριντζής: Βραβείο από το Κέντρο Ερευνών του Πανεπιστημίου Πειραιώς για τις δημοσιεύσεις σε διεθνή περιοδικά των μελών ΔΕΠ του Πανεπιστημίου Πειραιώς για το έτος 2003-2004.Διεθνής\n" +
                    "<br><br>• Διάκριση  ως το 2ο πιο πολυδιαβασμένο άρθρο ολόκληρου του διεθνούς περιοδικού User Modeling and User Adapted Interaction ( περιοδικό με Impact Factor 4.3 και στην πρώτη θέση μεταξύ όλων των περιοδικών σε Computer Science! ) του εκδοτικού οίκου Springer: Η εργασία   V. Tsiriga, M. Virvou (2004) “A Generic Framework for the Initialization of Student Models in Web-based Intelligent Tutoring Systems» USER MODELING AND USER ADAPTED INTERACTION, Vol. 14, 2004, pp. 289-316, Springer.\n" +
                    "<br><br>• Διεθνής Διάκριση  ως το 13ο πιο πολυδιαβασμένο άρθρο ολόκληρου του διεθνούς περιοδικού Interacting with Computers, το οποίο έχει impact factor 1.698: Η εργασία   K. Kabassi, M. Virvou (2004) «Personalised adult e-training on computer use based on multiple attribute decision making» In Interacting with Computers, Vol. 16, Issue 1, 2004, Pages 115-132,Εlsevier.\n" +
                    "<br><br>• Διεθνής Διάκριση  ως το 3ο πιο πολυδιαβασμένο άρθρο ολόκληρου του διεθνούς περιοδικού Κnowledge Based Systems, το οποίο έχει impact factor 1.308:      Η εργασία   M. Virvou & K. Kabassi, (2004) “Evaluating an intelligent graphical user interface by comparison with human experts” In Knowledge-Based Systems, vol. 17 (2004) pp. 31-37, Εlsevier.\n" +
                    "<br><br>• Θ. Παναγιωτόπουλος: Συνδιοργανωτής στο 3o Πανελλήνιο Συνέδριο Τεχνητής Νοημοσύνης (SETN04), Σάμος 5-8 Μαΐου 2004";
            text_details.setText(Html.fromHtml(linkText));
            text_details.setMovementMethod(LinkMovementMethod.getInstance());
        }
        create_details(reads[id-1],modify[id-1],margins[id-1]);
    }
    void create_details(String read_times,String modify,int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_diakriseis_details);
        final TextView[] news_text = new TextView[3];
        final ImageView[] news_underline = new ImageView[1];

        news_underline[0] = new ImageView(this);
        //Setting image
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 30;
        news_underline[0].setImageResource(R.drawable.underline);
        params4.topMargin  = underline_top;
        news_underline[0].setLayoutParams(params4);
        rl.addView(news_underline[0]);

        //Setting read times
        news_text[1] = new TextView(this);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params5.leftMargin = 30;
        news_text[1].setText(Html.fromHtml("Read <b>"+read_times+"</b> times"));
        news_text[1].setTextSize((float) 11);
        news_text[1].setPadding(20, 50, 20, 50);
        params5.topMargin  = underline_top+20;
        news_text[1].setLayoutParams(params5);
        news_text[1].setTextColor(Color.parseColor("#0d0d0d"));
        rl.addView(news_text[1]);

        //Setting last modified
        if(!modify.equals("")) {
            news_text[2] = new TextView(this);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params6.leftMargin = 30 + 520;
            news_text[2].setText(Html.fromHtml("Last modified on " + modify));
            news_text[2].setTextSize((float) 11);
            news_text[2].setPadding(20, 50, 20, 50);
            params6.topMargin = underline_top + 20;
            news_text[2].setLayoutParams(params6);
            rl.addView(news_text[2]);
        }


    }
}