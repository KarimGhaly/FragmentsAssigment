package com.example.admin.fragmentsassigment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Admin on 9/14/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private static final String TAG ="TestTAG" ;
    Context context;
    List<Celebritie> celebritieList;
    public static RecyclerViewClickListener itemListener;
    public interface RecyclerViewClickListener
    {

        public void recyclerViewListClicked(View v, int position);
    }


    public RVAdapter(Context context, List<Celebritie> celebritieList,RecyclerViewClickListener itemListener) {
        this.context = context;
        this.celebritieList = celebritieList;
        this.itemListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Celebritie C = celebritieList.get(position);
        holder.txtName.setText(C.getName());
        holder.imgView.setImageResource(C.getImageID());

    }


    @Override
    public int getItemCount() {
        return celebritieList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        ImageView imgView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String x = "Tetetete";
            int y = getLayoutPosition();
            try {
                itemListener.recyclerViewListClicked(v, getLayoutPosition());
            }
            catch (Exception e)
            {
                Log.d(TAG, "onClick: "+e.toString());
            }

        }
    }
}
