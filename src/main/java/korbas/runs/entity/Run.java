package korbas.runs.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Run {
    private int id;
    private String name;
    private LocalDate date;
    private double distance;
    private int heightDifference;
    private String description;
    private int limitOfParticipants;
    private String iframe;
    private boolean isActive;
    private String googlemap;
    private int season;
    private String location;
    private String about;

    public Run() {
    }

    public Run(int id, String name, LocalDate date, double distance, int heightDifference, String description, int limitOfParticipants, String iframe, boolean isActive, String googlemap, int season, String location, String about) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.distance = distance;
        this.heightDifference = heightDifference;
        this.description = description;
        this.limitOfParticipants = limitOfParticipants;
        this.iframe = iframe;
        this.isActive = isActive;
        this.googlemap = googlemap;
        this.season = season;
        this.location = location;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getHeightDifference() {
        return heightDifference;
    }

    public void setHeightDifference(int heightDifference) {
        this.heightDifference = heightDifference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimitOfParticipants() {
        return limitOfParticipants;
    }

    public void setLimitOfParticipants(int limitOfParticipants) {
        this.limitOfParticipants = limitOfParticipants;
    }

    public String getIframe() {
        return iframe;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getGooglemap() {
        return googlemap;
    }

    public void setGooglemap(String googlemap) {
        this.googlemap = googlemap;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return id == run.id &&
                Double.compare(run.distance, distance) == 0 &&
                heightDifference == run.heightDifference &&
                limitOfParticipants == run.limitOfParticipants &&
                isActive == run.isActive &&
                season == run.season &&
                name.equals(run.name) &&
                date.equals(run.date) &&
                Objects.equals(description, run.description) &&
                Objects.equals(iframe, run.iframe) &&
                Objects.equals(googlemap, run.googlemap) &&
                Objects.equals(location, run.location) &&
                Objects.equals(about, run.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id + System.lineSeparator() +
                ", name='" + name + '\'' + System.lineSeparator() +
                ", date=" + date +System.lineSeparator() +
                ", distance=" + distance +System.lineSeparator() +
                ", heightDifference=" + heightDifference +System.lineSeparator() +
                ", description='" + description + '\'' +System.lineSeparator() +
                ", limitOfParticipants=" + limitOfParticipants +System.lineSeparator() +
                ", iframe='" + iframe + '\'' +System.lineSeparator() +
                ", isActive=" + isActive +System.lineSeparator() +
                ", googlemap='" + googlemap + '\'' +System.lineSeparator() +
                ", season=" + season +System.lineSeparator() +
                ", location='" + location + '\'' +System.lineSeparator() +
                ", about='" + about + '\'' +
                '}';
    }
}
