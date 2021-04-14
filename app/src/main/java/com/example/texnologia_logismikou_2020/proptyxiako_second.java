package com.example.texnologia_logismikou_2020;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class proptyxiako_second extends Fragment {


    public proptyxiako_second() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_proptyxiako_second, container, false);

        TextView textView = rootView.findViewById(R.id.textViewSecond);
        String text = "Τα πρώτα τέσσερα (4) εξάμηνα (1ο και 2ο έτος) είναι κοινά για όλους τους φοιτητές του Τμήματος. Στα τέσσερα (4) τελευταία εξάμηνα (3ο και 4ο έτος) καθιερώνονται τρεις κατευθύνσεις:" +
                "<br/> <br/> <b>Τεχνολογία Λογισμικού και Ευφυή Συστήματα (ΤΛΕΣ):</b><br/>Η ταχύτατη εξέλιξη των υπολογιστών που σηματοδοτείται από αυξημένη υπολογιστική ισχύ, αυξημένη χωρητικότητα μνήμης και εξειδικευμένων περιφερειακών συσκευών, " +
                "έχει επιτρέψει την διάδοση προηγμένων και απαιτητικών προγραμματιστικών τεχνικών ακόμα και σε επίπεδο προσωπικού υπολογιστή. Οι τεχνικές αυτές θεραπεύονται από τα επιστημονικά πεδία της Τεχνολογίας Λογισμικού, των Γραφικών και της " +
                "Εικονικής Πραγματικότητας, της Τεχνητής Νοημοσύνης και των Ευφυών Συστημάτων, της Αναγνώρισης Προτύπου καθώς και από τις πλέον προηγμένες τεχνικές Επικοινωνίας Ανθρώπου Υπολογιστή. Η κατεύθυνση αυτή φιλοδοξεί να προσφέρει στους προπτυχιακούς " +
                "φοιτητές αφ’ ενός το απαραίτητο υπόβαθρο, αφ’ ετέρου τις ιδιαίτερες εκείνες γνώσεις ώστε να μπορούν να ανταποκριθούν αναπτυξιακά και ερευνητικά στην ευρύτερη περιοχή των μοντέρνων και προηγμένων τεχνικών ανάπτυξης λογισμικού. <br/><br/>" +
                "<b>Διαδικτυακά και Υπολογιστικά Συστήματα (ΔΥΣ):</b><br/>Η σύγκλιση των τεχνολογιών πληροφορικής και τηλεπικοινωνιών, η εκρηκτική ανάπτυξη του Διαδικτύου και οι εκθετικές αλλαγές στην πολυπλοκότητα και στις ταχύτητες των συστημάτων που " +
                "υποστηρίζουν τις παραπάνω τεχνολογίες, απαιτεί την απόκτηση εξειδικευμένων γνώσεων στους επιστημονικούς τομείς των διαδικτυακών ή δικτυοκεντρικών συστημάτων και των υπολογιστικών συστημάτων που είναι απαραίτητα για την εξάπλωση των τεχνολογιών αυτών. Το πρόγραμμα σπουδών " +
                "στην κατεύθυνση αυτή παρέχει τη δυνατότητα στους φοιτητές να αποκτήσουν κατ' αρχήν το απαραίτητο υπόβαθρο για την κατανόηση, λειτουργία και χρήση των τεχνολογιών αυτών και ύστερα να εφοδιαστούν με τις απαραίτητες δεξιότητες για την " +
                "ανάπτυξη, συντήρηση και αριστοποίηση συστημάτων που λειτουργούν σε ένα δικτυακό περιβάλλον.<br/> <br/>" +
                "<b>Πληροφοριακά Συστήματα και Υπηρεσίες (ΠΣΥ):</b><br/>" +
                "Η ανάπτυξη, υλοποίηση και διαχείριση σύγχρονων πληροφοριακών συστημάτων απαιτεί ένα ευρύ φάσμα γνώσεων που αναφέρονται στις τεχνολογίες πληροφορικής και επικοινωνιών, και στη διοίκηση επιχειρήσεων, ώστε τα πληροφοριακά συστήματα " +
                "να είναι αποδεκτά από τους χρήστες και να ενσωματώνονται επιτυχώς στη λειτουργία των επιχειρήσεων. Σκοπός της κατεύθυνσης αυτής είναι η παροχή προς τους φοιτητές του Τμήματος των αναγκαίων γνώσεων, σε θεωρητικό και πρακτικό επίπεδο, σχετικά με τις μεθοδολογίες και τεχνολογίες ανάπτυξης " +
                "σύγχρονων πληροφοριακών συστημάτων, τις διαδικασίες διοίκησης έργων που αφορούν στην ανάπτυξη πληροφοριακών συστημάτων, και τις μεθόδους διοίκησης εγκατεστημένων πληροφοριακών συστημάτων. Ενδεικτικά, δίνεται ιδιαίτερη έμφαση σε θέματα μεθοδολογιών ανάλυσης και σχεδιασμού συστημάτων, " +
                "σχεδίασης και ανάπτυξης αποδοτικών βάσεων δεδομένων, δικτύων υπολογιστών, ανάπτυξης πληροφοριακών συστημάτων με βάση τις επιχειρησιακές διαδικασίες, συστημάτων ροής εργασίας και ασφάλειας πληροφοριών.<br/><br/>" +
                "Η δομή του Προγράμματος Σπουδών απεικονίζεται στον πίνακα που ακολουθεί.<br/><br/>";
        textView.setText(Html.fromHtml(text));
        TextView textView2 = rootView.findViewById(R.id.textViewThird);
        text = " \n\nΣτο 5ο και το 6ο εξάμηνο όλες οι κατευθύνσεις έχουν δύο (2) κοινά μαθήματα (μαθήματα κορμού), από τρία υποχρεωτικά μαθήματα κατεύθυνσης και ένα μάθημα επιλογής. Σε κάθε κατεύθυνση, η επιλογή μπορεί να γίνεται από ένα κατάλογο μαθημάτων επιλογής που προσφέρονται στο αντίστοιχο εξάμηνο ή από τα υποχρεωτικά μαθήματα άλλης κατεύθυνσης.\n" +
                "\n" +
                "Στο 7ο και 8ο εξάμηνο εκτείνεται η πτυχιακή εργασία, η οποία ισοδυναμεί με 2 μαθήματα ανά εξάμηνο (τέσσερα μαθήματα συνολικά). Κάθε κατεύθυνση έχει τρία (3) υποχρεωτικά μαθήματα της κατεύθυνσης και δύο (2) μαθήματα επιλογής. Σε κάθε κατεύθυνση, η επιλογή " +
                "μπορεί να γίνεται από ένα κατάλογο μαθημάτων επιλογής που προσφέρονται στο αντίστοιχο εξάμηνο ή από τα υποχρεωτικά μαθήματα άλλης κατεύθυνσης.\n\n\n\n\n";
        textView2.setText(text);
        return rootView;
    }

}