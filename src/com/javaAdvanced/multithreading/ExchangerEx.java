package com.javaAdvanced.multithreading;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Синхронизатор Exchanger;
 * Exchanger позволяет потокам обмениваться информацией и получать ее одновременно;
 *
 * метод exchanger.exchange(T)
 * (в целом синхронизатор этот хитрый, требует более глубокого ознакомления! )
 *
 * Реализован пример игры "камень, ножницы, бумага"; где один игрок никак не узнает о результате
 * другого раньше времени. Объявление результата возможно только одновременно.
 */
public class ExchangerEx {

    public static void main(String[] args) {

        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friendsAction1 = List.of(Action.stone, Action.paper, Action.paper);
        List<Action> friendsAction2 = List.of(Action.scissors, Action.paper, Action.scissors);

        Friends friend1 = new Friends("Peter", friendsAction1, exchanger);
        Friends friend2 = new Friends("Oleg", friendsAction2, exchanger);

        // Output:
        // Peter WINS!!!
        // Draw!!
        // Draw!!
        // Oleg WINS!!!
    }
}

enum Action {
    stone,
    paper,
    scissors;
}

class Friends extends Thread {

    private String name;
    private List<Action> actions;
    private Exchanger<Action> exchanger;

    public Friends(String name, List<Action> actions, Exchanger<Action> exchanger) {
        this.name = name;
        this.actions = actions;
        this.exchanger = exchanger;
        this.start();
    }

    // условие победы или ничьей
    private void whoWins(Action myActions, Action friendsAction) {
        if ((myActions == Action.stone && friendsAction == Action.scissors)
                || (myActions == Action.scissors && friendsAction == Action.paper)
                || (myActions == Action.paper && friendsAction == Action.stone)) {
            System.out.println(name + " WINS!!!");
        } else if (myActions == friendsAction) {
            System.out.println("Draw!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : actions) {
            try {
                reply = exchanger.exchange(action); // непосредственно момент обмена
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}