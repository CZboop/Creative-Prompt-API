package com.bnta.practiceapi.prompt;

import java.util.Objects;

public class Prompt  {
    private int id;
    private String title;
    private String discipline;
    private String info;
    private int minsToComplete;
    private int difficulty;

    public Prompt(int id, String title, String discipline, String info, int minsToComplete, int difficulty) {
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.info = info;
        this.minsToComplete = minsToComplete;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getInfo() {
        return info;
    }

    public int getMinsToComplete() {
        return minsToComplete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setMinsToComplete(int minsToComplete) {
        this.minsToComplete = minsToComplete;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prompt prompt = (Prompt) o;
        return id == prompt.id && minsToComplete == prompt.minsToComplete && difficulty == prompt.difficulty && Objects.equals(title, prompt.title) && Objects.equals(discipline, prompt.discipline) && Objects.equals(info, prompt.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, discipline, info, minsToComplete, difficulty);
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discipline='" + discipline + '\'' +
                ", info='" + info + '\'' +
                ", minsToComplete=" + minsToComplete +
                ", difficulty=" + difficulty +
                '}';
    }
}
