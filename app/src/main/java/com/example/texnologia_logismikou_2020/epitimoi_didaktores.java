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
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
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

public class epitimoi_didaktores extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_epitimoi);
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


    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epitimoi_didaktores);

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
                Intent intent = new Intent(epitimoi_didaktores.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(epitimoi_didaktores.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(epitimoi_didaktores.this, menu_redirection.class);
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
                Intent intent = new Intent(epitimoi_didaktores.this, menu_redirection.class);
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


        ImageView img1 = (ImageView)findViewById(R.id.details_img1);
        img1.setBackgroundResource(R.drawable.jos1);
        ImageView img2 = (ImageView)findViewById(R.id.details_img2);
        img2.setBackgroundResource(R.drawable.josephsif2);
        ImageView img3 = (ImageView)findViewById(R.id.details_img3);
        img3.setBackgroundResource(R.drawable.nbourbakis);

        WebView wb = (WebView)findViewById(R.id.details1);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wb.setScrollbarFadingEnabled(false);

        wb.getSettings().setDefaultFontSize(30);
       // TextView txt2 = (TextView)findViewById(R.id.details1);
        String details1 = "<h2>Ιωσήφ Σηφάκης</h2>"+"" +
                "<p>\tΣτις 29 Απριλίου 2014, το Τμήμα μας είχε την τιμή της αναγόρευσης του Καθηγητή της Πληροφορικής κ. <a href=\"http://www-verimag.imag.fr/~sifakis/\" target=\"_blank\" title=\"\">Ιωσήφ Σηφάκη</a> σε Επίτιμο Διδάκτορά του. Ο κ. Σηφάκης είναι ο μοναδικός Έλληνας και από τους λίγους Ευρωπαίους Επιστήμονες που έχει <a href=\"http://amturing.acm.org/award_winners/sifakis_1701095.cfm\" target=\"_blank\" title=\"\">λάβει το βραβείο Turing</a>, το οποίο θεωρείται αντίστοιχο με το Νόμπελ για την Πληροφορική.</p>"
                +"<p>\tO Ιωσήφ Σηφάκης (γνωστός διεθνώς ως Joseph Sifakis/Ζοζέφ Σιφακίς) είναι Ελληνογάλλος ερευνητής της πληροφορικής, ο οποίος τιμήθηκε με Βραβείο Τούρινγκ το 2007 από κοινού με τον Έντμουντ Κλαρκ και τον Έρνεστ Άλλεν Έμερσον, για τις εργασίες τους στον έλεγχο μοντέλων, μία μέθοδο τυπικής επαλήθευσης υλικού ή λογισμικού υπολογιστών.</p>"
                +"<p>\tΓεννήθηκε στο Ηράκλειο της Κρήτης το 1946, σπούδασε ηλεκτρολόγος μηχανικός στο Εθνικό Μετσόβιο Πολυτεχνείο και πληροφορική στο Πανεπιστήμιο της Γκρενόμπλ με μία γαλλική υποτροφία, περίοδο στην διάρκεια της οποίας και απέκτησε την γαλλική υπηκοότητα. Ζει στη Γαλλία και εργάζεται για το Εθνικό Κέντρο Επιστημονικών Ερευνών στο εργαστήριο VERIMAG κοντά στη Γκρενόμπλ, του οποίου είναι ιδρυτής.</p>"+
                "<p>\tΕίναι επίσης συνεργάτης του δικτύου Artist2 (European Network of Excellence for research on Embedded Systems). (Πηγή: <a href=\"http://el.wikipedia.org/wiki/Ζοζέφ_Σιφακίς\" target=\"_blank\" title=\"\">Wikipedia</a>)</p>"+
                "p>\tΑπό την <a href=\"http://www.facebook.com/maria.virvou/media_set?set=a.418297941640932.100003821886182&amp;type=3\" target=\"_blank\">ομιλία της Προέδρου</a> του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς, Καθηγήτριας Μαρίας Βίρβου, σχετικά με την αναγόρευση του Καθηγητή κ. Ιωσήφ Σηφάκη σε Επίτιμο Διδάκτορα του Τμήματος Πληροφορικής:</p>" +
                "<p>\t\"Σήμερα είναι μια πολύ μεγάλη ημέρα για ολόκληρο το Πανεπιστήμιο Πειραιώς αλλά και ειδικότερα για το Τμήμα Πληροφορικής. Η αναγόρευση ενός Επίτιμου Διδάκτορα είναι κορυφαία εκδήλωση ενός Πανεπιστημίου. Ακόμα περισσότερο όταν στην Ακαδημαϊκή κοινότητα του Πανεπιστημίου μας, καλωσορίζουμε έναν επιστήμονα όπως ο Καθηγητής κ. Ιωσήφ Σηφάκης, ο οποίος μας τιμά ιδιαιτέρως με την αποδοχή του τίτλου!</p>"+
                "<p>\tO κ. Σηφάκης είναι ένας διεθνώς κορυφαίος επιστήμονας που έχει βραβευθεί πολλές φορές για το έργο του. Μεταξύ άλλων, τιμήθηκε από τον Επιστημονικό Οργανισμό για την Πληροφορική, ACM, με το εξέχουσας σημασίας βραβείο TURING, το οποίο θεωρείται αντίστοιχης αξίας με ΝΟΜΠΕΛ, θέτοντας έτσι και τη χώρα του (και χώρα μας), την Ελλάδα στην πολύ μικρή λίστα των μόλις 13 χωρών που διαθέτουν επιστήμονα ή επιστήμονες που έχουν λάβει αυτό το κορυφαίο βραβείο για την Πληροφορική στα 48 χρόνια της λειτουργίας του θεσμού αυτού. Η βράβευσή του αυτή καθώς και τα άλλα σπουδαία επιστημονικά επιτεύγματα του Καθηγητή κ. Σηφάκη έχουν έναν ιδιαίτερο συμβολισμό για μας, στα Ελληνικά Πανεπιστήμια γενικότερα και στην Πληροφορική ειδικότερα γιατί ανανεώνει την πίστη μας στις αξίες της επιστήμης και αποτελεί πρότυπο και πηγή καθοδήγησης για τους νεότερους επιστήμονες και φοιτητές αλλά και για τους νέους Έλληνες.\"</p>" +
                "<h3>\tΣχετικοί σύνδεσμοι</h3>"+"<ul>\t<li>\t\t<a href=\"http://www-verimag.imag.fr/~sifakis/\" target=\"_blank\">Προσωπική ιστοσελίδα του Καθηγητή κ. Ιωσήφ Σηφάκη</a></li>\t<li>\t\t<a href=\"http://el.wikipedia.org/wiki/Ζοζέφ_Σιφακίς\" target=\"_blank\" title=\"\">Ο Καθηγητής κ. Ιωσήφ Σηφάκης στη Wikipedia</a></li>\t<li>\t\t<a href=\"https://en.wikipedia.org/wiki/Joseph_Sifakis\" target=\"_blank\" title=\"\">Professor Joseph Sifakis on Wikipedia</a></li>\t<li>\t\t<a href=\"files/UnivofPiraeusDHC-Greek.pdf\" title=\"\">Διαφάνειες της ομιλίας του Καθηγητή κ. Ιωσήφ Σηφάκη</a></li>\t<li>\t\t<a href=\"https://www.facebook.com/maria.virvou/media_set?set=a.418297941640932.100003821886182&amp;type=3\" target=\"_blank\">Ολόκληρη η ομιλία της Προέδρου και φωτογραφικό υλικό από την τελετή αναγόρευσης</a></li>\t<li>\t\t<a href=\"http://techpolicy.acm.org/blog/?p=572\" target=\"_blank\" title=\"\">Ανακοίνωση σχετικά με τη βράβευση του Καθηγητή κ. Ιωσήφ Σηφάκη με το βραβείο Turing</a></li>\t<li>\t\t<a href=\"http://amturing.acm.org/award_winners/sifakis_1701095.cfm\" target=\"_blank\" title=\"\">Η σελίδα του Καθηγητή κ. Ιωσήφ Σηφάκη στον κατάλογο βραβευθέντων με το βραβείο Turing της ACM</a></li>\t<li>\t\t<a href=\"http://bits.blogs.nytimes.com/2014/11/13/google-lifts-the-turing-award-into-nobel-territory/?smid=fb-share&amp;_r=0\" target=\"_blank\" title=\"\">Η Google συνεισφέρει στο βραβείο Turing</a></li></ul>";


        wb.loadDataWithBaseURL("",details1, "text/html", "utf-8","");
        WebView wb2 = (WebView)findViewById(R.id.details2);
        wb2.getSettings().setLoadWithOverviewMode(true);
        wb2.getSettings().setUseWideViewPort(true);
        wb2.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wb2.setScrollbarFadingEnabled(false);

        String details2 = "<h2><b>Νικόλαος Μπουρμπάκης </b></h2>"+
                "Ο κ. Νικόλαος Μπουρμπάκης είναι ένας από τους διεθνώς πλέον αναγνωρισμένους ερευνητές στο χώρο της Πληροφορικής και ειδικότερα της Τεχνητής και Υπολογιστικής Νοημοσύνης και τυγχάνει Ελληνικής καταγωγής. Είναι Καθηγητής στο Wright State University  των ΗΠΑ και διευθυντής ερευνητικών εργαστηρίων."+
                "<br>\tΤα σημαντικότερα σημεία του πλούσιου βιογραφικού σημειώματος του Καθηγητή κ.  Νικόλαου Μπουρμπάκη περιλαμβάνουν και τα κάτωθι:<br><ul>\t    <li>Είναι IEEE Life Fellow</li>\t    <li>Είναι IEEE Computer Society Golden Core Member</li>\t    <li>Είναι Ιδρυτής και Πρόεδρος του μη κερδοσκοπικού χαρακτήρα ιδρύματος Biological and Artificial Intelligence Society and Foundation της Πολιτείας του Ohio των ΗΠΑ</li>\t    <li>Distinguished Professor in Information Technology, CSE Dept., Professor (j.a.) of Geriatrics School of Medicine, Wright State University (WSU), Dayton, OH,USA</li>\t    <li>Director of the Center of Assistive Research Technologies (CART) at Wright State University (WSU), Dayton, OH, USA</li>       <li>Έχει εκπονήσει εκτεταμένη έρευνα στην Εφαρμοσμένη Τεχνητή Νοημοσύνη (Applied Artificial Intelligence), η οποία περιλαμβάνει τα πρόσφατα ερευνητικά έργα:<br>\t    <i>SE-Expert System, Hermes-Vision Architecture, Kydon-Image Recognition Architecture, BouMer-Learing, DIAS Architecture, OCR-Words, Glossa-NL Understanding, Document Understanding, SKD Body Activity Recognition),</i></li>\t    <li>Έχει εκπονήσει εκτεταμένη έρευνα στην Κυβερνητική Ασφάλεια (Cyber Security), η οποία περιλαμβάνει τα πρόσφατα ερευνητικά έργα: SCAN, AMYNA)</li>\t    <li>Έχει εκπονήσει εκτεταμένη έρευνα στην Βιοτεχνολογία (Bioengineering), η οποία περιλαμβάνει τα πρόσφατα ερευνητικά έργα: Tyflos, SPN-Brain, Wireless Capsule Endoscopy, Ultrasound Imaging-Liver-Heart, Nosokoma, Prognosis).</li>\t    <li>Έχει δημοσιεύσει περισσότερες από 450 επιστημονικές εργασίες σε έγκριτα διεθνή περιοδικά (IEEE και άλλα), συλλογικούς τόμους και πρακτικά διεθνών συνεδρίων, καθώς και 10 επιστημονικά βιβλία.</li>\t    <li>Έχει επιβλέψει την εκπόνηση 30 διδακτορικών και πληθώρας μεταπτυχιακών διατριβών.</li>\t    <li>Είναι ο Ιδρυτής και Επικεφαλής Επιμελητής των διεθνών επιστημονικών περιοδικών International Journal on Artificial Intelligence Tools (World Scientific Pub. 1992 -) και International Journal on Monitoring &amp; Surveillance Tech Research (IGI-Global Pub. 2013 -);</li>\t    <li>Ήταν ο Επικεφαλής Επιμελητής (Editor in Charge) της Σειράς Ερευνητικών Τόμων σε Θέματα Τεχνητής Νοημοσύνης (Research Series of Books in AI) (World Scientific Pub., 1993-2001);</li>\t    <li>Είναι ο Ιδρυτής και Πρόεδρος της Επιτροπής Καθοδήγησης (Steering Committee) τριών σημαντικών διεθνών συνεδρίων υπό την αιγίδα και υποστήριξη της IEEE Computer Society (ICTAI, BIBE, IISA);</li>\t    <li>Είναι/ήταν Επιμελητής (Associate Editor) δώδεκα διεθνών περιοδικών της  IEEE και άλλων;</li>\t    <li>Ήταν Προσκεκλημένος Επιμελητής (Guest Editor)  25 ειδικών τευχών (special issues) περιοδικών της IEEE και άλλων σημαντικών διεθνών περιοδικών;</li>\t    <li>Έχει υπάρξει Διακεκριμένος Ομιλητής (Distinguished IEEE Computer Society Speaker);</li>\t    <li>Έχει υπάρξει Προσκεκλημένος Ομιλητής (Keynote Speaker) σε πολλά σημαντικά διεθνή συνέδρια της IEEE και άλλα;</li>\t    <li>Έχει διατελέσει Σύμβουλος και Αξιολογητής Ερευνητικών και Χρηματοδοτικών Οργανισμών των ΗΠΑ και Πανεπιστημιακών Ιδρυμάτων ανά τον Κόσμο</li></ul>\t<br>\tΓια την πολύ σημαντική συνεισφορά του στην Επιστήμη της Πληροφορικής και ειδικότερα της Τεχνητής και Υπολογιστικής Νοημοσύνης, ο κ. Νικόλαος Μπουρμπάκης έχει τιμηθεί κατ’ επανάληψη. Μεταξύ άλλων έχει λάβει και τις κάτωθι διακρίσεις:<br><ul>\t    <li>IBM Author recognition Award 1991;</li>\t    <li>IEEE Computer Society Outstanding Contribution Award 1992;</li>\t    <li>IEEE Outstanding Paper Award AUTESTCON 1994;</li>\t    <li>IEEE Computer Society Technical Research Achievement Award 1998;</li>\t    <li>IEEE I&amp;S Outstanding Leadership Award 1998;</li>\t    <li>IEEE ICTAI 10 years Research Contribution Award 1999;</li>\t    <li>Pattern Recognition Society Journal best papers selection for 1999;</li>\t    <li>IEEE Symposium on BIBE Outstanding Leadership Award, 2003;</li>\t    <li>ASC Outstanding Scientists &amp; Engineers Research Award-2005;</li>\t    <li>SETN Research Recognition- 2006;</li>\t    <li>Degree of Honor and Recognition, University of Patras, Greece 2007;</li>\t    <li>IEEE Appreciation Award for organizing ICTAI-08, Dayton OH, 2008;</li>\t    <li>IEEE Computer Society Appreciation Award as the BIBE Steering Chair 2009;</li>\t    <li>Dr. F. Russ IEEE Biomedical Engineering award, Dayton OH, 2010;</li>\t    <li>Pattern Recognition Society Journal “Most Cited Article for 2006-2010”, and “Honorary mention for several years”;</li>\t    <li>IJAIT best papers selection for the years 2006-2010;</li>\t    <li>IEEE BIBE- Keynote Speaker Recognition Award Mobile-health, Taichung, Taiwan, 2011;</li>\t    <li>WSU Outstanding Service Award, 2001-2012;</li>\t    <li>IEEE Int. Conference ICTAI-2012 CV Ramammoorthy Best paper Award, Athens, Greece;</li>\t    <li>“In honor and recognition for his outstanding scholarly achievements and contributions in the field of Computer Science”, Dept. of Informatics, University of Piraeus, Greece, July 2013;</li>\t    <li>IEEE EMBS-GR Award of Achievements for his contribution on Assistive Devices for the Blind, IEEE IC-BIBE, Nov 2013, Chania , Greece;</li>\t    <li>IEEE Conference BIBE-2014, Biomedical Engineering Best paper Award FL, USA, Nov. 2014;</li>\t    <li>UNESCO-GR Recognition Leadership Award, IEEE Conference IISA, Corfu, Greece, July 2015;</li>\t    <li>IEEE Conference on Tools with AI, CV Ramamoorthy Best paper Award, Vietri sul Mare, Italy Nov. 2015;</li>\t    <li>IEEE Computer Society 28 years ICTAI Outstanding Service &amp; Leadership Recognition, IEEE ICTAI, S. Jose, CA, 2016;</li>\t    <li>IEEE Computer Society Keynote Speaker Recognition Award 2017, Boston MA;</li>\t    <li>IEEE ICTAI-2018, 30 years Leadership Recognition, Volos, Nov 2018, Greece.</li></ul>\t<br>\tΕξαιτίας της Ελληνικής καταγωγής του, της επιστημονικής συνεισφοράς του και της διεθνούς αναγνώρισης του έργου του, ο κ. Νικόλαος  Μπουρμπάκης αποτελεί ένα πρότυπο για νέους ερευνητές της χώρας μας, ιδιαίτερα αυτή την περίοδο της έντονης οικονομικής κρίσης και της ανεργίας.<br><p></p>";

        wb2.getSettings().setDefaultFontSize(30);
        wb2.loadDataWithBaseURL("",details2, "text/html", "utf-8","");
        create_underline_info("13242 ","Πέμπτη, 13 Φεβρουαρίου 2020 11:53",8400);
            }
        }
