package io.giodude.chekwa1.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import io.giodude.chekwa1.Adapter.MatchesAdapter;
import io.giodude.chekwa1.Model.Event;
import io.giodude.chekwa1.R;
import io.giodude.chekwa1.ViewModel.SoccerViewModel;
@AndroidEntryPoint
public class MatchesView extends Fragment {
    private List<Event> eventModel;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayout;
    private MatchesAdapter matchesAdapter;
    private SoccerViewModel viewModel;
    private ProgressBar progressBar;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_matches_view, container, false);
        progressBar = view.findViewById(R.id.progress);
        observeData();
        return view;
    }

    private void observeData() {
        viewModel = new ViewModelProvider(this).get(SoccerViewModel.class);
        viewModel.getMatches();
        viewModel.getEventList().observe(getViewLifecycleOwner(), pokemons -> {
            if (pokemons.size() == 0) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                initRecyclerView(pokemons);
                matchesAdapter.updateList(pokemons);
            }

        });
    }

    private void initRecyclerView (List < Event > team) {
        recyclerView = view.findViewById(R.id.matchesRV);
        rvLayout = new LinearLayoutManager((getActivity()));
        recyclerView.setLayoutManager(rvLayout);
        matchesAdapter = new MatchesAdapter(getActivity(), team);
        recyclerView.setAdapter(matchesAdapter);
    }
}