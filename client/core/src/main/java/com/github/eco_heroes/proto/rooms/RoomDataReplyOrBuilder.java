// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: rooms.proto
// Protobuf Java Version: 4.28.3

package com.github.eco_heroes.proto.rooms;

public interface RoomDataReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ecoheroes.RoomDataReply)
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
   * <code>repeated .ecoheroes.PlayerInRoomData players = 2;</code>
   */
  java.util.List<com.github.eco_heroes.proto.rooms.PlayerInRoomData> 
      getPlayersList();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomData players = 2;</code>
   */
  com.github.eco_heroes.proto.rooms.PlayerInRoomData getPlayers(int index);
  /**
   * <code>repeated .ecoheroes.PlayerInRoomData players = 2;</code>
   */
  int getPlayersCount();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomData players = 2;</code>
   */
  java.util.List<? extends com.github.eco_heroes.proto.rooms.PlayerInRoomDataOrBuilder> 
      getPlayersOrBuilderList();
  /**
   * <code>repeated .ecoheroes.PlayerInRoomData players = 2;</code>
   */
  com.github.eco_heroes.proto.rooms.PlayerInRoomDataOrBuilder getPlayersOrBuilder(
      int index);

  /**
   * <code>int32 playersLimit = 3;</code>
   * @return The playersLimit.
   */
  int getPlayersLimit();

  /**
   * <code>.ecoheroes.PlayerInRoomData me = 4;</code>
   * @return Whether the me field is set.
   */
  boolean hasMe();
  /**
   * <code>.ecoheroes.PlayerInRoomData me = 4;</code>
   * @return The me.
   */
  com.github.eco_heroes.proto.rooms.PlayerInRoomData getMe();
  /**
   * <code>.ecoheroes.PlayerInRoomData me = 4;</code>
   */
  com.github.eco_heroes.proto.rooms.PlayerInRoomDataOrBuilder getMeOrBuilder();
}