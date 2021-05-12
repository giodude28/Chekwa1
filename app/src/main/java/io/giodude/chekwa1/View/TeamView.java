package io.giodude.chekwa1.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import io.giodude.chekwa1.Adapter.MatchesAdapter;
import io.giodude.chekwa1.Adapter.TeamAdapter;
import io.giodude.chekwa1.Model.Event;
import io.giodude.chekwa1.Model.TeamModel;
import io.giodude.chekwa1.R;
import io.giodude.chekwa1.ViewModel.SoccerViewModel;
@AndroidEntryPoint
public class TeamView extends Fragment {
    private List<TeamModel> teamModel;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayout;
    private TeamAdapter teamAdapter;
    private SoccerViewModel viewModel;
    private ProgressBar progressBar;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_team_view, container, false);
        progressBar = view.findViewById(R.id.progressBar);
        observeData();
        return view;
    }


    private void observeData() {
        viewModel = new ViewModelProvider(this).get(SoccerViewModel.class);
        viewModel.getTeams();
        viewModel.getTeamList().observe(getViewLifecycleOwner(), pokemons -> {
            if (pokemons.size() == 0) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                initRecyclerView(pokemons);
                teamAdapter.updateList(pokemons);
            }

        });
    }

    private void initRecyclerView (List < TeamModel > team) {
        recyclerView = view.findViewById(R.id.recyclerView);
        rvLayout = new LinearLayoutManager((getActivity()));
        recyclerView.setLayoutManager(rvLayout);
        teamAdapter = new TeamAdapter(getActivity(), team);
        recyclerView.setAdapter(teamAdapter);
    }
}