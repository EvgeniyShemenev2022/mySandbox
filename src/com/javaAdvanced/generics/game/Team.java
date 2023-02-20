package com.javaAdvanced.generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participants> {

    private String name;
    private List<T> participantsList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T newMember) {

        participantsList.add(newMember);
        System.out.println("Into team " + name + " was added new member " + newMember.getName());
    }

    public void playWith(Team<T> team) {

        String winner;
        Random random = new Random();
        int i = random.nextInt(2);

        if (i == 0) {
            winner = this.name;
        } else {
            winner = team.name;
        }

        System.out.println("Winner is the " + winner + " team! Congratulations");
    }

}
