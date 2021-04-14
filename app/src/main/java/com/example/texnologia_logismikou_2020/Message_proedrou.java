package com.example.texnologia_logismikou_2020;

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
import android.util.TypedValue;
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

public class Message_proedrou extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mnma_proedrou);
        TextView message = (TextView) findViewById(R.id.mnma);
        message.setText("Κατάταξη Μελών ΔΕΠ και Διδακτόρων του Τμήματος με Βάση το Εργαλείο Microsoft Academic Search");
        String linkText = "Σας καλωσορίζω στην ιστοσελίδα του Τμήματος Πληροφορικής της Σχολής Τεχνολογιών Πληροφορικής και Επικοινωνιών του Πανεπιστημίου Πειραιώς. Εδώ θα βρείτε πληροφορίες σχετικά με τις ερευνητικές και διδακτικές δραστηριότητες, αλλά και τις διοικητικές δομές, του Τμήματός μας.\n" +
                "\n" +
                "Το Τμήμα Πληροφορικής ιδρύθηκε με σκοπό την διεξαγωγή έρευνας σε τομείς της σύγχρονης Πληροφορικής και την κατάρτιση νέων επιστημόνων Πληροφορικής που θα συνεισφέρουν στην οικονομία της χώρας μας.\n" +
                "\n" +
                "\n" +
                "<br><br>Η Πληροφορική είναι μια <b>συναρπαστική</b> επιστήμη. Η θεωρητική πλευρά της έχει μεγάλο βάθος. Παράλληλα, το εύρος εφαρμογών της σύγχρονης Πληροφορικής είναι τεράστιο και συνεχώς επεκτείνεται, καθώς συναντούμε εφαρμογές Πληροφορικής σε κάθε έκφραση της καθημερινότητάς μας. Παρά την τεράστια αυτή ανάπτυξή της, μπορεί κανείς να πει ότι η Πληροφορική, ως επιστήμη και τεχνολογία, έχει ακόμα πολύ δρόμο να διανύσει. Αυτό το γεγονός δημιουργεί τεράστιες ευκαιρίες καριέρας για νέους, τόσο σε διάφορες εταιρίες Πληροφορικής, όσο και στη μέση εκπαίδευση, όσο και στον Πανεπιστημιακό χώρο, καθώς τα ακαδημαϊκά Τμήματα Πληροφορικής αποτελούν τα ταχύτερα αναπτυσσόμενα Τμήματα των Πανεπιστημίων. Εκτιμώ ότι οι ευκαιρίες αυτές θα υφίστανται για αρκετές δεκαετίες ακόμα, καθώς η Πληροφορική θα επεκτείνεται συνεχώς σε νέα πεδία εφαρμογών.\n" +
                "\n" +
                "<br><br>Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς αποτελεί ένα από τα κορυφαία Τμήματα Πληροφορικής στη χώρα μας, με διεθνή αναγνώριση και μεγάλο εύρος δραστηριοτήτων. Λειτουργεί ήδη 25 χρόνια και σε αυτό ασκούν διδακτικά και ερευνητικά καθήκοντα περίπου 25 Καθηγητές διαφόρων βαθμίδων, καθώς και αριθμός έκτακτων συνεργατών. Διαθέτουμε πολύ αξιόλογα προγράμματα προπτυχιακών και μεταπτυχιακών σπουδών. Παράλληλα, έχουμε κατακτήσει μια σημαντική θέση ερευνητικού συμμέτοχου στις διεθνείς επιστημονικές εξελίξεις. Τα γεγονότα αυτά σε συνδυασμό με τη μεγάλη απορροφητικότητα των αποφοίτων μας, έχουν καταστήσει το Τμήμα μας περιζήτητο τόσο για προπτυχιακές όσο και για μεταπτυχιακές σπουδές.\n" +
                "\n" +
                "<br><br>Τα προπτυχιακά προγράμματα σπουδών προσφέρουν στους φοιτητές που τα παρακολουθούν κάποια εξειδίκευση πρώτου επιπέδου με διάφορα μαθήματα επιλογής και με τη λειτουργία τριών κατευθύνσεων που επικεντρώνονται σε κάποιους τομείς της Πληροφορικής. Όμως, ο στόχος των προπτυχιακών προγραμμάτων σπουδών Πληροφορικής είναι η παρουσίαση του συνόλου της επιστήμης της Πληροφορικής και όχι η ειδίκευση σε κάποιον τομέα της. Ειδίκευση μπορεί να παρασχεθεί μόνο στα πλαίσια ενός προγράμματος μεταπτυχιακών σπουδών Πληροφορικής. Καθώς η Πληροφορική έχει ήδη διανύσει πέντε δεκαετίες εξέλιξής της, έχει καταστεί αναγκαία η εξειδίκευση μέσω παρακολούθησης κάποιου προγράμματος μεταπτυχιακών σπουδών Πληροφορικής.\n" +
                "\n" +
                "<br><br>Το Πρόγραμμα Μεταπτυχιακών Σπουδών (ΠΜΣ) σε «Προηγµένα Συστήµατα Πληροφορικής» λειτουργεί από το ακαδηµαϊκό έτος 2004-2005 και έχει ως αντικείµενο τη συντονισµένη ανάπτυξη και οργάνωση των ερευνητικών κατευθύνσεων της επιστήµης της Πληροφορικής και ειδικότερα αυτών που αφορούν σε τοµείς υψηλής προτεραιότητας για τη χώρα µας. Το περιεχόµενο και η φυσιογνωµία του προγράµµατος έχει διαµορφωθεί έτσι ώστε να ανταποκρίνεται µε επιτυχία στις ιδιαίτερες επιστηµονικές ανάγκες που προκαλεί η ταχύτατη εξέλιξη της Πληροφορικής σε ευρωπαϊκό και διεθνές επίπεδο.\n" +
                "\n" +
                "<br><br>Θέλω να τονίσω δύο πολύ σημαντικές ιδιαιτερότητες του ΠΜΣ : 1) σε αντίθεση με ΠΜΣ άλλων ιδρυμάτων διάρκειας δύο ετών, η κανονική διάρκεια των μεταπτυχιακών σπουδών του δικού μας ΠΜΣ είναι τρία ακαδημαϊκά εξάμηνα από τα οποία τα δύο πρώτα ακαδημαϊκά εξάμηνα αφιερώνονται στη διδασκαλία μαθημάτων και το τρίτο ακαδημαϊκό εξάμηνο αφιερώνεται στην εκπόνηση μεταπτυχιακής διατριβής και 2) οι κατευθύνσεις του είναι πρωτοποριακές για την Ελλάδα και με μεγάλη σημασία για την αγορά εργασίας και για έρευνα. Οι κατευθύνσεις αυτές δεν προσφέρονται από άλλα Πανεπιστημιακά Ιδρύματα της χώρας μας αλλά μόνο από Πανεπιστήμια του εξωτερικού με ιδιαίτερα μεγάλο κόστος.\n" +
                "\n" +
                "<br><br>Πιο συγκεκριμένα, το ΠΜΣ απονέµει Μεταπτυχιακό ∆ίπλωµα Ειδίκευσης (Μ∆Ε) σε μια τις επόμενες έξι κατευθύνσεις: (1) ∆ικτυοκεντρικά και Τηλεπικοινωνιακά Συστήµατα, (2) Ευφυείς Τεχνολογίες Επικοινωνίας Ανθρώπου – Υπολογιστή, (3) Επιχειρηματική Ευφυΐα, (4) Προηγμένες Τεχνολογίες Ανάπτυξης Λογισμικού, (5) Τεχνολογίες Διαχείρισης Ασφάλειας και (6) Τεχνολογίες Ηλεκτρονικών και Κινητών Υπηρεσιών. Οι κατευθύνσεις αυτές καλύπτουν σύγχρονες τάσεις της Πληροφορικής αναφορικά τόσο με την αγορά εργασίας όσο και με τη δυνατότητα εμβάθυνσης σε τομείς της Πληροφορικής με ευρύ ερευνητικό ενδιαφέρον.\n" +
                "\n" +
                "<br><br>Δεκτοί γίνονται, μετά από επιλογή, κυρίως, πτυχιούχοι Πανεπιστημίων και ΤΕΙ οι οποίοι έχουν ήδη μια αρκετά καλή γνώση της Πληροφορικής από τις προπτυχιακές σπουδές τους και επιθυμούν να αποκτήσουν μια περαιτέρω ειδίκευση σε κλάδους της Πληροφορικής. Επομένως, αυτό το ΠΜΣ απευθύνεται κυρίως σε πτυχιούχους Πληροφορικής και ίσως κάποιων σχολών πολύ συναφών με την Πληροφορική.\n" +
                "\n" +
                "<br><br>Από το έτος 2007 στο Τμήμα μας λειτουργεί και το ΠΜΣ στην «Πληροφορική». Σε αντίθεση με άλλα ΠΜΣ σε αντικείμενα Πληροφορικής σε εκπαιδευτικά ιδρύματα της χώρας μας, το ΠΜΣ στην «Πληροφορική» απευθύνεται κυρίως σε αποφοίτους σχολών ΑΕΙ ή ΤΕΙ άλλων της Πληροφορικής, οι οποίοι επιθυμούν να αποκτήσουν γνώση στα θέματα Πληροφορικής σε επίπεδο μεταπτυχιακών σπουδών. Η ανάγκη για αυτό το πρόγραμμα σπουδών υπαγορεύθηκε από την υψηλού βαθμού διαθεματικότητα της Πληροφορικής και από τις σύγχρονες απαιτήσεις υψηλής γνώσης της Πληροφορικής σε όλες τις ειδικότητες επιστημών. Στην σημερινή εποχή, όλες οι επιστήμες χρειάζονται ειδικές και υψηλές γνώσεις Πληροφορικής που μπορούν να αποκτηθούν από ένα μεταπτυχιακό πρόγραμμα σαν το δικό μας.\n" +
                "\n" +
                "<br><br>Το ΠΜΣ «Πληροφορική» καλύπτει ένα πολύ μεγάλο εκπαιδευτικό κενό. Μέχρι πριν τη λειτουργία του δικού μας ΠΜΣ, κάποιος επιστήμονας μπορούσε να παρακολουθήσει αντίστοιχες μεταπτυχιακές σπουδές μόνο στο εξωτερικό (Αγγλία, Αμερική κ.ά.), όπου τέτοια προγράμματα λειτουργούσαν με μεγάλη επιτυχία από 30ετίας. Τα προγράμματα αυτά αποκαλούνται “M.Sc. conversion courses” και προσφέρονται από Τμήματα Πληροφορικής κορυφαίων Ευρωπαϊκών και Αμερικανικών Πανεπιστημίων. Το πρόγραμμά μας έχει συνταχθεί με βάση αυτά τα πρότυπα. Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς παρέχει τη δυνατότητα να μπορεί πλέον κάποιος να παρακολουθήσει ένα αντίστοιχο πρόγραμμα σπουδών στην Ελλάδα.\n" +
                "\n" +
                "<br><br>Εκτός των προπτυχιακών και μεταπτυχιακών προγραμμάτων σπουδών, το Τμήμα μας προσφέρει και τη δυνατότητα εκπόνησης διδακτορικής διατριβής. Στα χρόνια λειτουργίας του Τμήματος, ολοκληρώθηκαν με επιτυχία περίπου 60 διδακτορικές διατριβές. Πολλοί από αυτούς τους 60 Διδάκτορες του Τμήματός μας αποτελούν σήμερα μέλη του Διδακτικού και Ερευνητικού Προσωπικού ελληνικών και ξένων Πανεπιστημίων και ΤΕΙ, καθώς και ερευνητικών κέντρων. Αυτή τη στιγμή, είναι εγγεγραμμένοι στο Τμήμα περίπου 80 Υποψήφιοι Διδάκτορες. Η θεματολογία των διδακτορικών ερευνών που βρίσκονται σε εξέλιξη καλύπτει ένα μεγάλο φάσμα των ερευνητικών περιοχών της σύγχρονης Πληροφορικής. Στα πλαίσια της εκπόνησης διδακτορικών διατριβών, οι υποψήφιοι διδάκτορες προετοιμάζουν και παρουσιάζουν πρωτότυπες εργασίες οι οποίες ανακοινώνονται σε διεθνή συνέδρια και δημοσιεύονται σε έγκριτα επιστημονικά περιοδικά πολύ υψηλού κύρους. Χαρακτηριστικό του πολύ υψηλού επιπέδου της έρευνας που επιτελείται στο Τμήμα μας είναι το γεγονός ότι τα τελευταία χρόνια, εργασίες των μελών ΔΕΠ του Τμήματος και υποψηφίων διδακτόρων έχουν όχι μόνο δημοσιευθεί, αλλά και διακριθεί σε αναγνωρισμένα διεθνή συνέδρια και περιοδικά, είτε λαμβάνοντας βραβεία «καλύτερων εργασιών», είτε λαμβάνοντας κολακευτικά σχόλια από άλλους ερευνητές σε άλλες χώρες, είτε λαμβάνοντας σημαντικές θέσεις στις λίστες των πιο πολυδιαβασμένων άρθρων των επιστημονικών περιοδικών στα οποία δημοσιεύθηκαν. Το επίτευγμα αυτό δεν είναι αμελητέο, καθώς τα διεθνή συνέδρια και περιοδικά δημοσιεύουν άρθρα σε καταξιωμένους επιστημονικούς εκδοτικούς οίκους που εδρεύουν σε χώρες που θεωρούνται τεχνολογικά πιο εξελιγμένες από τη χώρα μας και όπου παρουσιάζονται εργασίες από πολλές άλλες χώρες του κόσμου.\n" +
                "\n" +
                "<br><br>Επιπρόσθετα προς τα παραπάνω, το Τμήμα Πληροφορικής παρέχει τη δυνατότητα εξ αποστάσεως παρακολούθησης σεμιναριακών μαθημάτων σε πολλά τρέχοντα θέματα της Πληροφορικής που απευθύνονται σε ευρύ κοινό. Τα σεμιναριακά μαθήματα πραγματοποιούνται μέσω ενός προγράμματος e-learning.\n" +
                "\n" +
                "<br><br>Το Τμήμα Πληροφορικής έχει αναγνωριστεί μέσω σημαντικών διεθνών διακρίσεων. Μια τέτοια σημαντική διεθνής αναγνώριση αποτυπώνεται στα αποτελέσματα του εργαλείου ακαδημαϊκής αναζήτησης Microsoft Academic Search που έχει κατασκευάσει η γνωστή εταιρία Microsoft. Σύμφωνα με το εργαλείο, το Πανεπιστήμιο Πειραιώς κατατάσσεται στα 100 κορυφαία του κόσμου, συγκεκριμένα στη θέση 73, για την περιοχή της Πληροφορικής Computer Education, ανάμεσα σε 4.333 άλλα πανεπιστήμια και οργανισμούς διεθνώς. Το ίδιο εργαλείο κατατάσσει μέλη του Τμήματος Πληροφορικής στους κορυφαίους επιστήμονες της περιοχής αυτής και άλλων περιοχών ανάμεσα σε δεκάδες χιλιάδες επιστημόνων διεθνώς.\n" +
                "\n" +
                "<br><br>Πρόσφατα, στις 29 Απριλίου 2014, το Τμήμα μας είχε την ιδιαίτερη τιμή να δεχτεί στην ακαδημαϊκή του κοινότητα τον κορυφαίο Έλληνα επιστήμονα της Πληροφορικής, τον Καθηγητή κ. Ιωσήφ Σηφάκη, αναγορεύοντάς τον σε Επίτιμο Διδάκτορά του. Ο κ. Ι. Σηφάκης είναι ο μοναδικός Έλληνας και από τους λίγους Ευρωπαίους Επιστήμονες που έχει λάβει το βραβείο Turing, το οποίο θεωρείται ισότιμο με Νόμπελ για την Πληροφορική.\n" +
                "\n" +
                "<br><br>Ευχαριστούμε πολύ για το ενδιαφέρον σας για το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς. Θα χαρούμε πολύ να παράσχουμε περισσότερες πληροφορίες για το Τμήμα μας σε κάθε ενδιαφερόμενο, είτε τηλεφωνικά (210-4142263 και 210-4142105) είτε μέσω του ιστότοπου <a href='http://www.cs.unipi.gr'>http://www.cs.unipi.gr.</a> <br><br>Με θερμούς χαιρετισμούς,\n" +
                "\n" +
                "\n" +
                "<br><br>Δρ. Γεώργιος Τσιχριντζής\n" +
                "\n" +
                "<br><br>Καθηγητής\n" +
                "<br><br>Πρόεδρος Τμήματος Πληροφορικής\"";
        message.setText(Html.fromHtml(linkText));
        message.setMovementMethod(LinkMovementMethod.getInstance());

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
                Intent intent = new Intent(Message_proedrou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(Message_proedrou.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(Message_proedrou.this, menu_redirection.class);
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
                Intent intent = new Intent(Message_proedrou.this, menu_redirection.class);
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
        create_underline_info("14542","Πέμπτη, 01 Σεπτεμβρίου 2016 23:47",12000);
    }
    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_message_proedrou);
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