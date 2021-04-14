package com.example.texnologia_logismikou_2020;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class proptyxiako_first extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_proptyxiako_first, container, false);
        VideoView videoView = (VideoView) rootView.findViewById(R.id.videoView3);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.videoplayback;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this.getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

        TextView textView = rootView.findViewById(R.id.textViewfirst);
        String text = " Το νέο Πρόγραμμα Σπουδών του Τμήματος Πληροφορικής του Πανεπιστημίου Πειραιώς φιλοδοξεί να εκπληρώσει στο μέγιστο δυνατό βαθμό τους εξής στόχους: \n"+
                "\n\t\t\u2022 Ευθυγράμμιση με τους τρέχοντες προσανατολισμούς που ορίζονται διεθνώς στον τομέα της Πληροφορικής και τις ανάγκες της αγοράς εργασίας,\n" +
                "\t\t\u2022 Προσδιορισμό της ιδιαίτερης ταυτότητας του Τμήματος με την καθιέρωση κατευθύνσεων που θα θεραπεύουν επαρκώς, για προπτυχιακό επίπεδο, τομείς-αιχμής της Πληροφορικής,\n" +
                "\t\t\u2022Δημιουργία «φυτώριου» νέων επιστημόνων με την ενσωμάτωση σύγχρονων γνωστικών αντικειμένων και μαθημάτων σε συνδυασμό και με τα ήδη δρομολογημένα Προγράμματα Μεταπτυχιακών Σπουδών του Τμήματος.\n" +
                "\nΓια την εκπλήρωση των παραπάνω στόχων στο νέο Πρόγραμμα Σπουδών εισάγονται στα δύο τελευταία έτη σπουδών τρεις κατευθύνσεις,\n" +
                "\n\t\t\u2022Τεχνολογία Λογισμικού και Ευφυή Συστήματα" +
                "\n\t\t\u2022Διαδικτυακά και Υπολογιστικά Συστήματα" +
                "\n\t\t\u2022Πληροφοριακά Συστήματα και Υπηρεσίες\n" +
                "\nοι οποίες θα παρέχουν την απαραίτητη και κρίσιμη, για προπτυχιακό επίπεδο, εξειδίκευση που θα καθιστά τους φοιτητές του Τμήματος ανταγωνιστικούς στην αγορά εργασίας και έτοιμους να αντεπεξέλθουν στις σύγχρονες απαιτήσεις στον επιστημονικό στίβο της Πληροφορικής. \n \n\n\n\n";

        textView.setText(text);
        textView.setMovementMethod(new ScrollingMovementMethod());
        return rootView;



    }
}