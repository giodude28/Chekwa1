package io.giodude.chekwa1.Network;

import java.util.List;

import javax.inject.Inject;

import io.giodude.chekwa1.Model.MatchesModel;
import io.giodude.chekwa1.Model.TeamModel;
import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private MatchesApiService matchesApiService;
    private TeamApiService apiService;

    @Inject
    public Repository(TeamApiService apiService,MatchesApiService matchesApiService){
        this.matchesApiService = matchesApiService;
        this.apiService = apiService;
//        this.tableApiService = tableApiService;
//        this.liveApiService = liveApiService;
    }

    public Observable<MatchesModel> getPast(){
        return matchesApiService.getPast(Keys.League);
    }

    public Observable<List<TeamModel>> getTeam(){
        return apiService.getTeam();
    }
}
