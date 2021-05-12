package io.giodude.chekwa1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("teamname_eng")
    @Expose
    private String teamnameEng;
    @SerializedName("teamname_cn")
    @Expose
    private String teamnameCn;
    @SerializedName("team_description")
    @Expose
    private String teamDescription;
    @SerializedName("team_badge")
    @Expose
    private String teamBadge;
    @SerializedName("team_jersey")
    @Expose
    private String teamJersey;
    @SerializedName("team_formed_year")
    @Expose
    private String teamFormedYear;
    @SerializedName("stadium")
    @Expose
    private String stadium;
    @SerializedName("staduim_image")
    @Expose
    private String staduimImage;
    @SerializedName("stadium_description")
    @Expose
    private String stadiumDescription;
    @SerializedName("sports")
    @Expose
    private String sports;
    @SerializedName("league")
    @Expose
    private String league;
    @SerializedName("country")
    @Expose
    private String country;

    public TeamModel(Integer id, String teamnameEng, String teamnameCn, String teamDescription, String teamBadge, String teamJersey, String teamFormedYear, String stadium, String staduimImage, String stadiumDescription, String sports, String league, String country) {
        this.id = id;
        this.teamnameEng = teamnameEng;
        this.teamnameCn = teamnameCn;
        this.teamDescription = teamDescription;
        this.teamBadge = teamBadge;
        this.teamJersey = teamJersey;
        this.teamFormedYear = teamFormedYear;
        this.stadium = stadium;
        this.staduimImage = staduimImage;
        this.stadiumDescription = stadiumDescription;
        this.sports = sports;
        this.league = league;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getTeamnameEng() {
        return teamnameEng;
    }

    public String getTeamnameCn() {
        return teamnameCn;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public String getTeamBadge() {
        return teamBadge;
    }

    public String getTeamJersey() {
        return teamJersey;
    }

    public String getTeamFormedYear() {
        return teamFormedYear;
    }

    public String getStadium() {
        return stadium;
    }

    public String getStaduimImage() {
        return staduimImage;
    }

    public String getStadiumDescription() {
        return stadiumDescription;
    }

    public String getSports() {
        return sports;
    }

    public String getLeague() {
        return league;
    }

    public String getCountry() {
        return country;
    }
}
