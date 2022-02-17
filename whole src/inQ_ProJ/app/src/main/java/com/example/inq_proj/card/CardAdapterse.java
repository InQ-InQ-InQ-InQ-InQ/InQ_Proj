package com.example.inq_proj.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inq_proj.R;

import java.util.ArrayList;

public class CardAdapterse extends RecyclerView.Adapter<CardAdapterse.Viewholder> {

    private Context context;
    private ArrayList<CardModelse> cardModelseArrayList;

    public CardAdapterse(Context context, ArrayList<CardModelse> cardModelseArrayList) {
        this.context = context;
        this.cardModelseArrayList = cardModelseArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_se, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        CardModelse model = cardModelseArrayList.get(position);
        holder.TVtextfr.setText(model.getFr_card_text());
        holder.TVtextse.setText(model.getSe_card_text());
        holder.TVcard.setImageResource(model.getCard_image());
    }

    @Override
    public int getItemCount()  {
        return cardModelseArrayList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView TVcard;
        private TextView TVtextfr, TVtextse;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            TVcard = itemView.findViewById(R.id.idCardImage);
            TVtextfr = itemView.findViewById(R.id.idCardText_1);
            TVtextse = itemView.findViewById(R.id.idCardText_2);
        }
    }
}


