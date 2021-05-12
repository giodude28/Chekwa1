package io.giodude.chekwa1.Network;

import java.util.List;

import io.giodude.chekwa1.Model.TeamModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamApiService {

    @GET("chinasoccer")
    Observable<List<TeamModel>> getTeam();
}
