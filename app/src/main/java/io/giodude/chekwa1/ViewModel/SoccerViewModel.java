package io.giodude.chekwa1.ViewModel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.chekwa1.Model.Event;
import io.giodude.chekwa1.Model.MatchesModel;
import io.giodude.chekwa1.Model.TeamModel;
import io.giodude.chekwa1.Network.Repository;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SoccerViewModel extends ViewModel {
    private static final String TAG = "ViewModel";
    private MutableLiveData<List<Event>> eventList = new MutableLiveData<>();
    private MutableLiveData<List<TeamModel>> teamList = new MutableLiveData<>();

    private final CompositeDisposable disposables = new CompositeDisposable();
    private Repository repository;


    @ViewModelInject
    public SoccerViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<Event>> getEventList() {
        return eventList;
    }

    public LiveData<List<TeamModel>> getTeamList() {
        return teamList;
    }

    public void getTeams() {
        repository.getTeam()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> teamList.setValue(result),
                        error -> Log.e(TAG, "getBonus: " + error.getMessage()));
    }

    public void getMatches() {
        disposables.add(repository.getPast()
                .subscribeOn(Schedulers.newThread())
                .map(new Function<MatchesModel, List<Event>>() {
                    public List<Event> apply(MatchesModel teamResponse) throws Throwable {
                        List<Event> list = teamResponse.getEvents();
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> eventList.setValue(result),
                        error -> System.out.println(TAG + "getTable: " + error.getMessage())));
    }
}
