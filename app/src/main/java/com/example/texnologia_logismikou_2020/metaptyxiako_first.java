package com.example.texnologia_logismikou_2020;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class metaptyxiako_first extends Fragment {

    DownloadManager downloadManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_metaptyxiako_first, container, false);

        TextView textView2 = rootView.findViewById(R.id.text2);
        String text = "Το Τμήμα Πληροφορικής του Πανεπιστημίου Πειραιώς, οργανώνει και λειτουργεί τέσσερα μεταπτυχιακά προγράμματα σπουδών:" +
                    "<br><br> - ΠΜΣ «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης».<br>" +
                " - ΠΜΣ «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες».<br>" +
                " - ΠΜΣ «Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας».<br>" +
                " - ΠΜΣ «Πληροφορική».";
        textView2.setText(Html.fromHtml(text));

        TextView textView3 = rootView.findViewById(R.id.text3);
        text ="Το Πρόγραμμα Μεταπτυχιακών Σπουδών " +
                "<b>«Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης»</b> (Advanced Informatics and Computing Systems - Software Development and Αrtificial Intelligence) έχει ως αντικείμενο τη συντονισμένη ανάπτυξη και οργάνωση των ερευνητικών κατευθύνσεων της επιστήμης της Πληροφορικής και των νέων Τεχνολογιών και ειδικότερα αυτών που αφορούν σε τομείς υψηλής προτεραιότητας για τη χώρα μας." +
                "Το «Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης» (Advanced Informatics and Computing Systems - Software Development and Αrtificial Intelligence) θεραπεύει αμιγώς τα πλέον προηγμένα ζητήματα επιστήμης στο χώρο της Πληροφορικής και των νέων τεχνολογιών. Το περιεχόμενο και η φυσιογνωμία του προγράμματος έχει διαμορφωθεί έτσι ώστε να ανταποκρίνεται με επιτυχία στις ιδιαίτερες επιστημονικές ανάγκες που προκαλεί η ταχύτατη εξέλιξη της Πληροφορικής και νέων Τεχνολογιών σε ευρωπαϊκό και διεθνές επίπεδο." +
                "Τόσο τα υποχρεωτικά μαθήματα, όσο και τα μαθήματα επιλογής, έχουν επιλεγεί ώστε να προσφέρουν στο μεταπτυχιακό φοιτητή την ειδίκευση που απαιτούν οι πλέον πρόσφατες τεχνολογικές εξελίξεις στον τομέα της Πληροφορικής και νέων τεχνολογιών, σε συνδυασμό με τα ιδιαίτερα χαρακτηριστικά και τις ανάγκες της σύγχρονης Ελληνικής και Ευρωπαϊκής Οικονομίας." +
                "<br> <br>Το Πρόγραμμα Μεταπτυχιακών Σπουδών <b>«Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες»</b>  («Digital Culture, Smart Cities, IoT and Advanced Digital Technologies») έχει ως αντικείμενο την συντονισμένη ανάπτυξη και οργάνωση των ερευνητικών κατευθύνσεων της επιστήμης των νέων Τεχνολογιών και ειδικότερα αυτών που αφορούν σε τομείς υψηλής προτεραιότητας για τη χώρα μας, όπως είναι ο Ψηφιακός Πολιτισμός, οι Έξυπνες Πόλεις, το Διαδίκτυο των Πραγμάτων (IoT), καθώς και οι Σύγχρονες Επικοινωνίες και Ψηφιακές Τεχνολογίες." +
                "Το ΠΜΣ απονέμει Δίπλωμα Μεταπτυχιακών Σπουδών (Δ.Μ.Σ.) με τίτλο «Ψηφιακός Πολιτισμός, Έξυπνες Πόλεις, IoT και Προηγμένες Ψηφιακές Τεχνολογίες» με τις εξής τρεις (3) ειδικεύσεις (tracks) : «Ψηφιακός Πολιτισμός», «Έξυπνες Πόλεις και Προηγμένες Ψηφιακές Τεχνολογίες», «Διαδίκτυο των Πραγμάτων (IoT) και Προηγμένες Ψηφιακές Τεχνολογίες». Το Π.Μ.Σ. απευθύνεται σε αποφοίτους από διαφορετικά επιστημονικά πεδία. " +
                "<br> <br> Το Πρόγραμμα Μεταπτυχιακών Σπουδών (ΠΜΣ) <b> «Κατανεμημένα Συστήματα, Ασφάλεια και Αναδυόμενες Τεχνολογίες Πληροφορίας» </b> (Distributed Systems, Security and Emerging Information Technologies), έχει ως αντικείμενο την εκπαίδευση νέων επιστημόνων στις επιστημονικές περιοχές της Ασφάλειας Δικτύων και Συστημάτων, των Κατανεμημένων και των Υπολογιστικών Συστημάτων, καθώς και της Επιχειρησιακής Αναλυτικής και των Αναδυόμενων Τεχνολογιών και Υπηρεσιών Πληροφορίας.<br>" +
                "Σκοπός του ΠΜΣ είναι η επιστημονική και τεχνολογική κατάρτιση αποφοίτων τμημάτων ΑΕΙ Πληροφορικής, Τηλεπικοινωνιών και συναφών επιστημών, σε πεδία της Πληροφορικής που επιδεικνύουν ραγδαία επιστημονική ανάπτυξη, υψηλή δυναμική και διαρκώς αυξανόμενη ζήτηση στην Ευρωπαϊκή και παγκόσμια αγορά εργασίας όπως είναι τα αντικείμενα που αναφέρθηκαν παραπάνω, με σκοπό την εκπαίδευση καταρτισμένων και ικανών επιστημόνων και ερευνητών που θα προωθήσουν την ανάπτυξη της χώρας και των Ελληνικών επιχειρήσεων στο πλαίσιο της Κοινωνίας της Πληροφορίας.<br> " +
                "<br>Το Πρόγραμμα Μεταπτυχιακών Σπουδών στην <b>«Πληροφορική»</b> (Informatics) έχει ως αντικείμενο την άρτια και υψηλού επιπέδου εκπαίδευση αποφοίτων τμημάτων ΑΕΙ και ΑΤΕΙ διαφόρων επιστημονικών ειδικοτήτων στις αρχές και μεθοδολογίες εφαρμογής της σύγχρονης επιστήμης της Πληροφορικής.<br>" +
                "Το Πρόγραμμα Μεταπτυχιακών Σπουδών στην «Πληροφορική» θεραπεύει σύγχρονα ζητήματα τεχνολογίας και εφαρμογών της επιστήμης της Πληροφορικής σε άλλες σύγχρονες επιστήμες. Το περιεχόμενο και η φυσιογνωμία του προγράμματος έχει διαμορφωθεί έτσι ώστε να ανταποκρίνεται με επιτυχία στις ιδιαίτερες επιστημονικές ανάγκες που προκαλεί η ταχύτατη εξέλιξη της Πληροφορικής και των εφαρμογών της σε ευρωπαϊκό και διεθνές επίπεδο.<br>";
        textView3.setText(Html.fromHtml(text));

        TextView textView4 = (TextView) rootView.findViewById(R.id.text4);
        textView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inURL = "http://www.cs.unipi.gr/files/msc.ppt";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        TextView textView7 = rootView.findViewById(R.id.text7);
        text ="<b>ΕΛΛΗΝΙΚΗ ΔΗΜΟΚΡΑΤΙΑ<br><br>Α.ΔΙ.Π.<br><br>ΑΡΧΗ ΔΙΑΣΦΑΛΙΣΗΣ ΠΟΙΟΤΗΤΑΣ ΑΝΩΤΑΤΗΣ ΕΚΠΑΙΔΕΥΣΗΣ<br><br><i>Πρωτότυπο Κείμενο</i>:</b><br><br> " +
                "Two postgraduate (M.Sc.) programs are offered by the Department, one in Advanced Computing and Information Systems and a second, " +
                "a Conversion Course, in Informatics. Both programs are in harmony with the general educational aims of the Department " +
                "(the continuous updating of program content according to international trends in general, and in a way that reflects the needs " +
                "of industry and employers in particular). The first program offers a truly advanced level of knowledge and specialization in Computing " +
                "and Information Systems, which is often required by certain parts of the R&D-related industry and other employers. The second M.Sc. " +
                "program makes accessible the area of Informatics to individuals from other science/technology-based backgrounds. Both programs have been " +
                "designed to reflect the research expertise of the staff in the Department and are also feeders to Ph.D. and other research projects supported" +
                " by the Department. The vast majority of course material is appropriate and of high quality. The curriculum of the two M.Sc. programs is " +
                "defined and the results show that excellent work is performed. The academic staff works closely on the two programs and offers a competitive " +
                "course structure.<br><br>" +
                "The depth and spread of Ph.D. activity was found to be impressive. The approach of having M.Sc. courses as a source of students entering Ph.D. programs works very well.<br><br>" +
                "<b><i>Κείμενο σε μετάφραση:</i></b><br><br>" +
                "Το Τμήμα Πληροφορικής προσφέρει δύο προγράμματα μεταπτυχιακών σπουδών (Π.Μ.Σ.), το ένα στα «Προηγμένα Συστήματα Πληροφορικής» και το άλλο " +
                "στην «Πληροφορική». Τα δύο αυτά προγράμματα προσφέρουν υψηλής ποιότητας εκπαίδευση σύμφωνα με τις διεθνείς επιστημονικές και ερευνητικές " +
                "τάσεις και αντικατοπτρίζουν τις ανάγκες της αγοράς εργασίας. Συγκεκριμένα, το Π.Μ.Σ. «Προηγμένα Συστήματα Πληροφορικής» προσφέρει ένα " +
                "πραγματικά προχωρημένο επίπεδο γνώσεων και εξειδίκευσης στην πληροφορική και τα πληροφοριακά συστήματα, που είναι άκρως απαραίτητα για την " +
                "ανεύρεση εργασίας. Το Π.Μ.Σ. «Πληροφορική»  προετοιμάζει και εκπαιδεύει καταρτισμένους και ικανούς επιστήμονες και ερευνητές στον τομέα της " +
                "Πληροφορικής, οι οποίοι όμως προέρχονται από διαφορετικές επιστήμες. Και τα δύο προαναφερθέντα Π.Μ.Σ.  έχουν σχεδιαστεί με τρόπο ώστε να " +
                "αντανακλούν την ερευνητική εμπειρία και τεχνογνωσία  του Τμήματος και προετοιμάζουν το έδαφος για διδακτορικές σπουδές και ερευνητικά " +
                "προγράμματα, υποστηριζόμενα από το Τμήμα. Το υλικό των μαθημάτων των Π.Μ.Σ. είναι υψηλής ποιότητας και κατάλληλα ορισμένο για την " +
                "εκπαιδευτική διαδικασία. Τα αποτελέσματα αποδεικνύουν την εξαιρετική δουλειά που γίνεται στα μαθήματα των Π.Μ.Σ.. Το Διδακτικό και " +
                "Ερευνητικό Προσωπικό δουλεύει προσεκτικά στα δύο προγράμματα και προσφέρει μια ανταγωνιστική δομή μαθημάτων.<br><br>" +
                "Το βάθος και το επίπεδο της έρευνας που προσφέρουν οι σπουδές διδακτορικού επιπέδου στο Τμήμα διαπιστώθηκε ότι είναι εντυπωσιακά. " +
                "Η προσέγγιση της ύπαρξης Π.Μ.Σ. " +
                "που προετοιμάζουν εξαιρετικά τους φοιτητές για διδακτορικές σπουδές έχει αποφέρει πολύ σημαντική πρόοδο." +
                "<br><br><b>Η ΕΠΙΤΡΟΠΗ ΕΞΩΤΕΡΙΚΗΣ ΑΞΙΟΛΟΓΗΣΗΣ</b>";
        textView7.setText(Html.fromHtml(text));

        TextView textView8 = (TextView) rootView.findViewById(R.id.text8);
        textView8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String inURL = "http://web.cs.ucla.edu/~dt/";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        TextView textView9 = (TextView) rootView.findViewById(R.id.text9);
        textView9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String inURL = "http://ctr-emth.teikav.edu.gr/index.php/contact-form/2011-01-17-14-06-30/2011-01-17-13-26-44/37-2011-01-17-13-22-45/1-name";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        TextView textView10 = (TextView) rootView.findViewById(R.id.text10);
        textView10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String inURL = "http://vision.mas.ecp.fr/";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        TextView textView11 = (TextView) rootView.findViewById(R.id.text11);
        textView11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String inURL = "http://www.research.lancs.ac.uk/portal/en/people/Costas-Xydeas/";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        TextView textView13 = (TextView) rootView.findViewById(R.id.text13);
        text ="Στους φοιτητές όλων των Προγραμμάτων Μεταπτυχιακών Σπουδών του Τμήματος παρέχονται:\n \n" +
                "1.Δωρεάν συμμετοχή σε διεθνή επιστημονικά συνέδρια\n" +
                "2.Εκπαιδευτικές εκδρομές\n" +
                "3.Πρόσβαση στα εργαστήρια του Τμήματος\n" +
                "4.WiFi στις αίθουσες διδασκαλίας\n" +
                "5.Πρόσβαση στις υπηρεσίες του Τμήματος και του Πανεπιστημίου.\n" +
                "6.Πρόσβαση σε υπηρεσίες από συνεργαζόμενες εταιρίες.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent1 = new Intent(getActivity(), ipiresies_tmimatos_panepistimiou.class);
                intent1.putExtra("menu", "Υπηρεσίες τμήματος και Πανεπιστημίου");
                startActivity(intent1);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent1 = new Intent(getActivity(), Sunergazomenes_etairies.class);
                intent1.putExtra("menu", "Συνεργαζόμενες εταιρίες");
                startActivity(intent1);
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ss.setSpan(clickableSpan1, 250, 295, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 310, 348, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView13.setText(ss);
        textView13.setMovementMethod(LinkMovementMethod.getInstance());


        TextView textView15 = (TextView) rootView.findViewById(R.id.text15);
        text ="Στο Τμήμα διενεργείται ερευνητικό έργο - στο οποίο οι φοιτητές ενθαρρύνονται να συμμετέχουν - σε μία πληθώρα τομέων. " +
                "Για περισσότερες πληροφορίες, οι φοιτητές μπορούν να απευθύνονται στα ερευνητικά εργαστήρια του Τμήματος.";
        SpannableString ss1 = new SpannableString(text);
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent1 = new Intent(getActivity(), tomeis_ereunas.class);
                intent1.putExtra("menu", "Τομείς έρευνας");
                startActivity(intent1);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent1 = new Intent(getActivity(), ereunitika_ergastiria.class);
                intent1.putExtra("menu", "Ερευνητικά εργαστήρια");
                startActivity(intent1);
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ss1.setSpan(clickableSpan3, 101, 115, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss1.setSpan(clickableSpan4, 187, 221, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView15.setText(ss1);
        textView15.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView17 = (TextView) rootView.findViewById(R.id.text17);
        text = "Ενδεικτικές ιστορίες επιτυχίας αποφοίτων\n" +
                "\n" +
                "Γραφείο Διασύνδεσης\n" +
                "\n" +
                "Δημοσιεύσεις στον τύπο:\n" +
                "\n" +
                "1.Καλές θέσεις εργασίας με «πληροφορική» από Πειραιά\n" +
                "2.«Οι σπουδές πληροφορικής δίνουν λύση στην κρίση εργασίας»\n" +
                "3.Μεταπτυχιακά πληροφορικής\n" +
                "4.Συνέντευξη με τους  Καθηγητές του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς, κ. Μαρία Βίρβου και κ. Γεώργιο Τσιχριντζή.\n\n\n\n";
        SpannableString ss2 = new SpannableString(text);
        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://www.cs.unipi.gr/files/success_stories.ppt";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan6 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://career.unipi.gr/";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan7 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://www.ethnos.gr/entheta.asp?catid=23325&subid=2&pubid=63107221";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan8 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://www.ethnos.gr/entheta.asp?catid=23318&subid=2&pubid=63606948";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan9 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://www.ethnos.gr/entheta.asp?catid=23325&subid=2&pubid=3698797";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan10 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                String inURL = "http://www.universitypress.gr/Issues/tabid/58/articleType/ArticleView/articleId/155/language/el-GR/-35-42011.aspx";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
                startActivity( browse );
            }
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        ss2.setSpan(clickableSpan5, 0, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(clickableSpan6, 41, 61, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(clickableSpan7, 89, 141, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(clickableSpan8, 142, 201, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(clickableSpan9, 203, 228, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(clickableSpan10, 230, 357, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView17.setText(ss2);
        textView17.setMovementMethod(LinkMovementMethod.getInstance());


        return rootView;



    }
}