// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: game-events.proto
// Protobuf Java Version: 4.28.3

package com.github.eco_heroes.proto.game_events;

public interface RoomGameDataReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ecoheroes.RoomGameDataReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>repeated .ecoheroes.PlayerInRoomGameData players = 2;</code>
   */
  java.util.List<com.github.eco_heroes.proto.game_events.PlayerInRoomGameData> 
      getPlayersList();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomGameData players = 2;</code>
   */
  com.github.eco_heroes.proto.game_events.PlayerInRoomGameData getPlayers(int index);
  /**
   * <code>repeated .ecoheroes.PlayerInRoomGameData players = 2;</code>
   */
  int getPlayersCount();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomGameData players = 2;</code>
   */
  java.util.List<? extends com.github.eco_heroes.proto.game_events.PlayerInRoomGameDataOrBuilder> 
      getPlayersOrBuilderList();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomGameData players = 2;</code>
   */
  com.github.eco_heroes.proto.game_events.PlayerInRoomGameDataOrBuilder getPlayersOrBuilder(
      int index);

  /**
   * <code>int32 playersLimit = 3;</code>
   * @return The playersLimit.
   */
  int getPlayersLimit();
}
