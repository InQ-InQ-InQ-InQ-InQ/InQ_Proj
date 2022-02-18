package com.example.inq_proj.ui.project.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inq_proj.R;
import com.example.inq_proj.card.CardAdapterse;
import com.example.inq_proj.card.CardModelse;

import java.util.ArrayList;

public class TabFragment2 extends Fragment {
    private RecyclerView cardRV;

    private ArrayList<CardModelse> cardModelseArrayList;

    public TabFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.tab_fragment2, container, false);
        cardRV = v.findViewById(R.id.idRVcard2);

        cardModelseArrayList = new ArrayList<>();
        cardModelseArrayList.add(new CardModelse("insit", "lorem", R.drawable.logo));
        cardModelseArrayList.add(new CardModelse("insit", "lorem", R.drawable.logo));
        cardModelseArrayList.add(new CardModelse("insit", "lorem", R.drawable.logo));


        CardAdapterse cardAdapterse = new CardAdapterse(getContext(), cardModelseArrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        cardRV.setLayoutManager(gridLayoutManager);
        cardRV.setAdapter(cardAdapterse);

        return v;
    }
}