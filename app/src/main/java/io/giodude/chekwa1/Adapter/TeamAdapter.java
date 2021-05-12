package io.giodude.chekwa1.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.giodude.chekwa1.Model.Event;
import io.giodude.chekwa1.Model.TeamModel;
import io.giodude.chekwa1.R;
import io.giodude.chekwa1.View.TeamView;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    Context context;
    private List<TeamModel> data;
    TextView name, taon, laro, tdesc,stadium,stadiumdesc;
    ImageView badge,stadiumimg;
    public TeamAdapter(Context context, List<TeamModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTeamnameCn());
        Picasso.get().load(data.get(position).getTeamBadge()).into(holder.img);

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.teamdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.name);
        taon = myDialog.findViewById(R.id.year);
        laro = myDialog.findViewById(R.id.sport);
        stadiumdesc = myDialog.findViewById(R.id.stadiumdesc);
        tdesc = myDialog.findViewById(R.id.teamdesc);
        stadiumimg = myDialog.findViewById(R.id.Stadiumimg);
        badge = myDialog.findViewById(R.id.jerseyimg);
        stadium = myDialog.findViewById(R.id.stadiumtitle);
        for (int i = 0; i < data.size(); i++) {
            if (holder.title.getText() == data.get(position).getTeamnameCn()) {
                name.setText(data.get(position).getTeamnameCn());
                taon.setText(data.get(position).getTeamFormedYear());
                tdesc.setText(data.get(position).getTeamDescription());
                laro.setText(data.get(position).getSports());
                stadiumdesc.setText(data.get(position).getStadiumDescription());
                stadium.setText(data.get(position).getStadium());
                Picasso.get().load(data.get(position).getTeamBadge()).into(badge);
                Picasso.get().load(data.get(position).getStaduimImage()).into(stadiumimg);
            }
        }

        holder.itemView.setOnClickListener(v -> myDialog.show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.teamname);
            img = itemView.findViewById(R.id.teamimg);
        }
    }

    public void updateList(List<TeamModel> updatedList) {
        data = updatedList;
        notifyDataSetChanged();
    }
}
