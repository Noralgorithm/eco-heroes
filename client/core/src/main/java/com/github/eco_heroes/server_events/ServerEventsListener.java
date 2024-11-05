package com.github.eco_heroes.server_events;

import com.github.eco_heroes.proto.game_events.ServerEvent;
import io.grpc.stub.StreamObserver;

public class ServerEventsListener implements StreamObserver<ServerEvent> {
    @Override
    public void onNext(ServerEvent serverEvent) {
       ServerEventsObservable.notifyObservers(serverEvent);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("RECIEVED ERROR " + throwable);
    }

    @Override
    public void onCompleted() {
        System.out.println("COMPLETED");
    }
}
