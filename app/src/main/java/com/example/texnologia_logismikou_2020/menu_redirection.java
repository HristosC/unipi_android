package com.example.texnologia_logismikou_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class menu_redirection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String menu_choice = bundle.getString("menu_choice");
        int bottom_nav_id = bundle.getInt("bot_nav_id");
        if(menu_choice != null) {
            if (menu_choice.equals("Μήνυμα Προέδρου")) {
                Intent intent = new Intent(menu_redirection.this, Message_proedrou.class);
                startActivity(intent);
            } else if (menu_choice.equals("Τομείς έρευνας")) {
                Intent intent = new Intent(menu_redirection.this, tomeis_ereunas.class);
                startActivity(intent);
            } else if (menu_choice.equals("Επιλεγμένες δημοσιεύσεις")) {
                Intent intent = new Intent(menu_redirection.this, epilegmenes_dimosieuseis.class);
                startActivity(intent);
            } else if (menu_choice.equals("Ερευνητικά έργα")) {
                Intent intent = new Intent(menu_redirection.this, ereunitika_erga.class);
                startActivity(intent);
            } else if (menu_choice.equals("Ερευνητικά εργαστήρια")) {
                Intent intent = new Intent(menu_redirection.this, ereunitika_ergastiria.class);
                startActivity(intent);
            } else if (menu_choice.equals("Τοποθεσία")) {
                Intent intent = new Intent(menu_redirection.this, maps_location.class);
                startActivity(intent);
            } else if (menu_choice.equals("Στοιχεία Επικοινωνίας")) {
                Intent intent = new Intent(menu_redirection.this, stoixeia_epikoinwnias.class);
                startActivity(intent);
            } else if (menu_choice.equals("Διακρίσεις")) {
                Intent intent = new Intent(menu_redirection.this, diakriseis.class);
                startActivity(intent);
            } else if (menu_choice.equals("Επιστημονικά συνέδρια")) {
                Intent intent = new Intent(menu_redirection.this, episitmonika_sunedria.class);
                startActivity(intent);
            } else if (menu_choice.equals("Υπηρεσίες τμήματος και Πανεπιστημίου")) {
                Intent intent = new Intent(menu_redirection.this, ipiresies_tmimatos_panepistimiou.class);
                startActivity(intent);
            } else if (menu_choice.equals("Ομιλίες,διαλέξεις")) {
                Intent intent = new Intent(menu_redirection.this, omilies_dialexeis.class);
                startActivity(intent);
            } else if (menu_choice.equals("Ημερίδες")) {
                Intent intent = new Intent(menu_redirection.this, hmerides.class);
                startActivity(intent);
            } else if (menu_choice.equals("Άλλες εκδηλώσεις")) {
                Intent intent = new Intent(menu_redirection.this, alles_drasthriotites.class);
                startActivity(intent);
            } else if (menu_choice.equals("Διοικητικές Πράξεις")) {
                Intent intent = new Intent(menu_redirection.this, anakoinwseis.class);
                intent.putExtra("name", "Διοικητικές πράξεις");
                startActivity(intent);
            } else if (menu_choice.equals("Νέα του Τμήματος")) {
                Intent intent = new Intent(menu_redirection.this, anakoinwseis.class);
                intent.putExtra("name", "Τελευταία νέα και ανακοινώσεις");
                startActivity(intent);
            } else if (menu_choice.equals("Συνεργαζόμενες εταιρίες")) {
                Intent intent = new Intent(menu_redirection.this, Sunergazomenes_etairies.class);
                startActivity(intent);
            } else if (menu_choice.equals("Διδάσκοντες")) {
                Intent intent = new Intent(menu_redirection.this, didaskontes.class);
                intent.putExtra("menu", "Διδάσκοντες");
                startActivity(intent);
            } else if (menu_choice.equals("Γραμματεία")) {
                Intent intent = new Intent(menu_redirection.this, didaskontes.class);
                intent.putExtra("menu", "Γραμματεία");
                startActivity(intent);
            } else if (menu_choice.equals("Μεταδιδακτορικοί ερευνητές")) {
                Intent intent = new Intent(menu_redirection.this, epitimoi_metadidaktorikoi.class);
                intent.putExtra("menu", "Μεταδιδακτορικοί");
                startActivity(intent);
            } else if (menu_choice.equals("Υποψήφιοι διδάκτορες")) {
                Intent intent = new Intent(menu_redirection.this, epitimoi_metadidaktorikoi.class);
                intent.putExtra("menu", "Υποψήφιοι διδάκτορες");
                startActivity(intent);
            } else if (menu_choice.equals("ΚΕΝΤΡΙΚΗ")) {
                Intent intent = new Intent(menu_redirection.this, MainActivity.class);
                startActivity(intent);
            }else if (menu_choice.equals("eLearning")) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elearning.cs.unipi.gr/"));
                startActivity(browserIntent);
            }else if (menu_choice.equals("Οδηγός σπουδών")) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.unipi.gr/files/odigos_spoudon_pps_2017-2018.pdf"));
                startActivity(browserIntent);
            }else if (menu_choice.equals("Επίτιμοι Διδάκτορες")) {
                Intent intent = new Intent(menu_redirection.this, epitimoi_didaktores.class);
                startActivity(intent);
            }else if (menu_choice.equals("Προπτυχιακά")) {
                Intent intent = new Intent(menu_redirection.this, proptyxiaka.class);
                startActivity(intent);
            }else if (menu_choice.equals("Διδακτορικές σπουδές")) {
                Intent intent = new Intent(menu_redirection.this, didaktorikes_spoydes.class);
                startActivity(intent);
            }else if (menu_choice.equals("Μεταπτυχιακά")) {
                Intent intent = new Intent(menu_redirection.this, metaptyxiako.class);
                startActivity(intent);
            }
        }else{
            if (bottom_nav_id == R.id.homepage_bot_nav) {
                Intent intent = new Intent(menu_redirection.this, MainActivity.class);
                startActivity(intent);
            } else if (bottom_nav_id == R.id.contact_bot_nav) {
                Intent intent = new Intent(menu_redirection.this, stoixeia_epikoinwnias.class);
                startActivity(intent);
            } else if (bottom_nav_id == R.id.news_bot_nav) {
                Intent intent = new Intent(menu_redirection.this, anakoinwseis.class);
                intent.putExtra("name", "Τελευταία νέα και ανακοινώσεις");
                startActivity(intent);
            } else if (bottom_nav_id == R.id.studies_bot_nav) {
                Intent intent = new Intent(menu_redirection.this, proptyxiaka.class);
                startActivity(intent);
            }
        }
        //remove from stack
        finish();
    }
}