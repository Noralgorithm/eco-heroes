package com.github.eco_heroes.server_events;

import com.github.eco_heroes.proto.game_events.ServerEvent;

import java.util.ArrayList;

public class ServerEventsObservable {

    static ArrayList<ServerEventsObserver> observers = new ArrayList<>();

    static public void notifyObservers(ServerEvent event) {
        for (ServerEventsObserver observer : observers) {
            observer.handleEvent(event);
        }
    }

    static public void addObserver(ServerEventsObserver observer) {
        observers.add(observer);
    }

    static public void removeObserver(ServerEventsObserver observer) {
        observers.remove(observer);
    }

}

