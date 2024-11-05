package com.github.eco_heroes;

import com.github.eco_heroes.proto.game_events.ServerEvent;
import io.grpc.stub.StreamObserver;

public class ServerEventsListener implements StreamObserver<ServerEvent> {

    @Override
    public void onNext(ServerEvent serverEvent) {
        System.out.println("AAAAAAAAAAAAAAAAAAA");
        System.out.println("RECIEVED SERVER EVENT " + serverEvent);
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
