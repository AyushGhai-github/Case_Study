package com.washerDetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Leaderboard")
public class Leaderboard {

    @Id
    private long rank;
    private String washerName;
    private double waterSavedInLiters;
    private double workingHrs;

    public String getWasherName() {
        return washerName;
    }

    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }

    public double getWaterSavedInLiters() {
        return waterSavedInLiters;
    }

    public void setWaterSavedInLiters(double waterSavedInLiters) {
        this.waterSavedInLiters = waterSavedInLiters;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public double getWorkingHrs() {
        return workingHrs;
    }

    public void setWorkingHrs(double workingHrs) {
        this.workingHrs = workingHrs;
    }
}
