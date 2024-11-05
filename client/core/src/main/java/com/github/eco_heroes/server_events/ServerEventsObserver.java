package com.github.eco_heroes.server_events;

import com.github.eco_heroes.proto.game_events.ServerEvent;

public interface ServerEventsObserver {
    void handleEvent(ServerEvent event);
}
