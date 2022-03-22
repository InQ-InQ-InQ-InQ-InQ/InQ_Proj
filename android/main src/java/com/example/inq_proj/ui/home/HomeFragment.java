package com.example.inq_proj.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.inq_proj.R;
import com.example.inq_proj.card.CardAdapterse;
import com.example.inq_proj.card.CardModelse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment{

    private TextView profile_name, profile_position, profile_skills;
    private RecyclerView profileCard;
    private ArrayList<CardModelse> cardModelseArrayList;

    Context mContext;
    Activity mActivity;
    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        if (context instanceof Activity) {
            mActivity = (Activity)context;
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        mContext = null;
        super.onDetach();
    }

    public HomeFragment() { };

    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile, container, false);
        profileCard = v.findViewById(R.id.profile_ingProject);

        //profile info
        profile_name = v.findViewById(R.id.profile_name);
        profile_position = v.findViewById(R.id.text_profile_position_own);
        profile_skills = v.findViewById(R.id.text_profile_skill_own);

        String url_profile_info = "https://1af1-115-143-100-251.ngrok.io/members/my-info";
        RequestQueue queue = Volley.newRequestQueue(requireActivity());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_profile_info, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name = response.getString("name");
                    String position = response.getString("position");
                    String skills = response.getString("skills");

                    profile_name.setText(name);
                    profile_position.setText(position);
                    profile_skills.setText(skills);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonObjectRequest);

        //진행중인 프로젝트
        cardModelseArrayList = new ArrayList<>();
        cardModelseArrayList.add(new CardModelse("insit", "lorem", R.drawable.logo));

        CardAdapterse cardAdapterse = new CardAdapterse(getContext(), cardModelseArrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        profileCard.setLayoutManager(gridLayoutManager);
        profileCard.setAdapter(cardAdapterse);

        return v;
    }
}