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

public class ereunitika_ergastiria extends AppCompatActivity {
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
        setContentView(R.layout.activity_ereunitika_ergastiria);

        TextView texn_log = (TextView) findViewById(R.id.texn_log);
        String linkText_1 ="<b>Το εργαστήριο Τεχνολογίας Λογισμικού έχει ως κύριο στόχο την προώθηση της βασικής έρευνας και της υψηλής ποιότητας διδασκαλίας σε καίρια και σύγχρονα θέματα της Τεχνολογίας Λογισμικού, Εκπαιδευτικού Λογισμικού, Μοντελοποίησης χρηστών, Μηχανικής μάθησης και Αναγνώρισης προτύπων, Ανάλυσης Εικόνας, Τεχνητής Αίσθησης και Διαδικτυακής Νοημοσύνης.</b><br><br>Η προώθηση αυτή στοχεύει τόσο στον Ελλαδικό χώρο και τον χώρο του Πανεπιστημίου Πειραιώς, όσο και διεθνώς στην παγκόσμια επιστημονική κοινότητα, έτσι ώστε να επιτευχθεί η ανάδειξη της ερευνητικής δραστηριότητας του Εργαστηρίου (και κατ' επέκταση του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς, στο οποίο ανήκει το Εργαστήριο) ως υπολογίσιμης δύναμης στο διεθνές ερευνητικό γίγνεσθαι.\\n\\nΗ Διευθύντρια του Εργαστηρίου είναι η Μαρία Βίρβου και ο Υπεύθυνος της Ομάδας Αναγνώριση Προτύπων και Ανάλυση Εικόνας είναι ο Γεώργιος Τσιχριντζής. Τα μέλη του Εργαστηρίου είναι 6 μέλη Διδακτικού και Ερευνητικού Προσωπικού (Δ.Ε.Π.), 14 υποψήφιοι Διδάκτορες και 10 μεταδιδακτορικοί ερευνητές. Το Εργαστήριο έχει φέρει εις πέρας πάνω από 10 ερευνητικά προγράμματα (R AND D projects).Τα μέλη του έχουν δημοσιεύσει 15 μονογραφίες, πάνω από 600 άρθρα σε διεθνή περιοδικά και συνέδρια. Επιπρόσθετα, έχουν επιμεληθεί 14 ειδικά τεύχη διεθνών περιοδικών και έχουν επιβλέψει 15 ολοκληρωμένα διδακτορικά. Μέλη του Εργαστηρίου είναι Επικεφαλής Εκδόσεων και μέλη της επιτροπής εκδόσεων σε διεθνή περιοδικά και έχουν υπηρετήσει ως πρόεδροι σε 30 καθιερωμένα διεθνή συνέδρια. Μέλη του Εργαστηρίου έχουν λάβει πολλές διακρίσεις για το έργο τους.<br><br>Διευθύντρια: Καθηγήτρια Μαρία Βίρβου<br><br>Διεύθυνση: Αίθουσα 207, Κεντρικό Κτίριο<br><br><a href='http://www.cs.unipi.gr/docs/ergasthrio.pdf'>http://www.cs.unipi.gr/docs/ergasthrio.pdf</a>";
        texn_log.setText(Html.fromHtml(linkText_1));
        texn_log.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dss = (TextView) findViewById(R.id.dss);
        String linkText ="<b>Το Εργαστήριο Συστημάτων Υποστήριξης Αποφάσεων ιδρύθηκε στο Τμήμα Πληροφορικής του Πανεπιστήμιου Πειραιώς το έτος 2001 (ΠΔ 244/2001 – ΦΕΚ Α 182/7-8-2001). Το Εργαστήριο Σ.Υ.Α. υποστηρίζει τη διδασκαλία σχετικών με το αντικείμενό του μαθημάτων σε προπτυχιακό και μεταπτυχιακό επίπεδο, τόσο σε θεωρητικό όσο και σε πρακτικό επίπεδο με την άσκηση των φοιτητών σε ειδικό λογισμικό που υλοποιούν διάφορα μοντέλα υποστήριξης αποφάσεων.</b><br><br>Οι ερευνητικές δραστηριότητες του εργαστηρίου εστιάζουν στα πεδία των συστημάτων υποστήριξης αποφάσεων, μεθοδολογιών μέτρησης αποδοτικότητας συστημάτων, πολυκριτηριακής ανάλυσης αποφάσεων, διαχείρισης γνώσης, ανάλυσης δεδομένων και εξόρυξης γνώσης. Αναλαμβάνει δια των μελών του την διοργάνωση ειδικών θεματικών ενοτήτων σε διεθνή συνέδρια Επιχειρησιακής Έρευνας.<br><br>Διευθυντής: Καθηγητής Δημήτριος Δεσπότης<br><br>Διεύθυνση: Αίθουσα 209, κεντρικό κτίριο<br><br><a href='http://dsslab.cs.unipi.gr'>http://dsslab.cs.unipi.gr</a>";
        dss.setText(Html.fromHtml(linkText));
        dss.setMovementMethod(LinkMovementMethod.getInstance());

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
                Intent intent = new Intent(ereunitika_ergastiria.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Intent intent = new Intent(ereunitika_ergastiria.this, menu_redirection.class);
                intent.putExtra("menu_choice", expandableListTitle.get(groupPosition));
                startActivity(intent);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(ereunitika_ergastiria.this, menu_redirection.class);
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
                Intent intent = new Intent(ereunitika_ergastiria.this, menu_redirection.class);
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
        create_underline_info("8594", "Δευτέρα, 30 Μαΐου 2016 19:09", 8650);
    }
    void create_underline_info(String read_times, String modify, int underline_top) {
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout_ereunitika_ergastiria);
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