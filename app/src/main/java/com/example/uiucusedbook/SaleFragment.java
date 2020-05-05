package com.example.uiucusedbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button submit;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private EditText titleTE;
    private EditText authorTE;
    private EditText descriptionTE;
    private EditText emailTE;




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SaleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaleFragment newInstance(String param1, String param2) {
        SaleFragment fragment = new SaleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        submit = getView().findViewById(R.id.submitofSale);

        titleTE = getView().findViewById(R.id.titleofSale);
        authorTE = getView().findViewById(R.id.authorofSale);
        descriptionTE = getView().findViewById(R.id.descriptionofSale);
        emailTE = getView().findViewById(R.id.emailofLogIn);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                saveBook();

                submit.setBackgroundColor(Color.GRAY);
            }
        });




    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale, container, false);
    }

    public void saveBook() {
        String code;
        final String title = titleTE.getText().toString();
        final String description = descriptionTE.getText().toString();
        final TextView test = getView().findViewById(R.id.test);
        final String author = authorTE.getText().toString();
        // less than  50 words
        if (description.length() > 400) {
            descriptionTE.setError("Type less than 400 letters");
        } else {
            final String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            CollectionReference entireBooks = db.collection("EntireBooks");
            Map<String,Object> note2 = new HashMap<>();
            note2.put("title", title);
            note2.put("author", author);
            note2.put("description", description);
            note2.put("userEmail", user);

            entireBooks.add(note2).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    String key = documentReference.getId();
                    final Map<String, Object> note = new HashMap<>();
                    note.put("title", title);
                    note.put("author", author);
                    note.put("description", description);
                    note.put("BookId", key);
                    CollectionReference dbBooks = db.collection(user);
                    dbBooks.add(note)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext().getApplicationContext(), "submitted", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getContext().getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });


        }



    }



}
