package com.example.admin.fragmentsassigment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingFragment extends Fragment implements RVAdapter.RecyclerViewClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "TestTAG";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Celebritie> celebritieList;
    private OnFragmentInteractionListener mListener;

    public ListingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListingFragment newInstance(String param1, String param2) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_listing, container, false);
    }
    @Override
    public void recyclerViewListClicked(View v, int position) {
        Log.d(TAG, "recyclerViewListClicked: "+ celebritieList.get(position).getName());
        mListener.SendCelbtoAct(celebritieList.get(position));

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Database db = new Database(getContext());
        celebritieList = db.getCelebritiesList();
        final RecyclerView rvList = (RecyclerView) view.findViewById(R.id.rvList);
        RVAdapter rvAdapter = new RVAdapter(getContext(),celebritieList,this);
        rvList.setAdapter(rvAdapter);
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        final RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setItemAnimator(itemAnimator);

        Switch switchBTN = (Switch) view.findViewById(R.id.switchBTN);
        switchBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    rvList.setLayoutManager(gridLayoutManager);

                }
                else {
                    rvList.setLayoutManager(linearLayoutManager);
                }
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }





    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void SendCelbtoAct(Celebritie c);
    }

}
