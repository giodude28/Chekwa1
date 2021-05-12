package io.giodude.chekwa1.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.giodude.chekwa1.Model.Event;
import io.giodude.chekwa1.R;
import io.giodude.chekwa1.View.MatchesView;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    Context context;
    private List<Event> data;
    private TextView h,a,hs,as,d,s,w;
    public MatchesAdapter(Context context, List<Event> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.matchesitem, parent, false);
        MatchesAdapter.ViewHolder viewHolder = new MatchesAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.home.setText(data.get(position).getStrHomeTeam());
        holder.away.setText(data.get(position).getStrAwayTeam());
        holder.homescore.setText(data.get(position).getIntHomeScore().toString());
        holder.awayscore.setText(data.get(position).getIntAwayScore().toString());


        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.matchesdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        h = myDialog.findViewById(R.id.home);
        a = myDialog.findViewById(R.id.away);
        hs = myDialog.findViewById(R.id.homescore);
        as = myDialog.findViewById(R.id.awayscore);
        d = myDialog.findViewById(R.id.date);
        s = myDialog.findViewById(R.id.status);
        for (int i = 0; i < data.size(); i++) {
            if (holder.home.getText() == data.get(position).getStrHomeTeam()) {
                h.setText(data.get(position).getStrHomeTeam());
                a.setText(data.get(position).getStrAwayTeam());
                hs.setText(data.get(position).getIntHomeScore());
                as.setText(data.get(position).getIntAwayScore());
                d.setText(data.get(position).getDateEvent());
                s.setText(data.get(position).getStrStatus());
            }
        }

        holder.itemView.setOnClickListener(v -> myDialog.show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView home;
        public TextView away;
        public TextView homescore;
        public TextView awayscore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home = (TextView) itemView.findViewById(R.id.home);
            awayscore = (TextView) itemView.findViewById(R.id.awayscore);
            homescore = (TextView) itemView.findViewById(R.id.homescore);
            away = (TextView) itemView.findViewById(R.id.away);
        }
    }

    public void updateList(List<Event> updatedList) {
        data = updatedList;
        notifyDataSetChanged();
    }
}
