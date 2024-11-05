// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: game-events.proto
// Protobuf Java Version: 4.28.3

package com.github.eco_heroes.proto.game_events;

public interface DepositWasteRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ecoheroes.DepositWasteRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ecoheroes.WasteType waste = 1;</code>
   * @return The enum numeric value on the wire for waste.
   */
  int getWasteValue();
  /**
   * <code>.ecoheroes.WasteType waste = 1;</code>
   * @return The waste.
   */
  com.github.eco_heroes.proto.game_events.WasteType getWaste();

  /**
   * <code>.ecoheroes.ContainerType container = 2;</code>
   * @return The enum numeric value on the wire for container.
   */
  int getContainerValue();
  /**
   * <code>.ecoheroes.ContainerType container = 2;</code>
   * @return The container.
   */
  com.github.eco_heroes.proto.game_events.ContainerType getContainer();

  /**
   * <code>string roomId = 3;</code>
   * @return The roomId.
   */
  java.lang.String getRoomId();
  /**
   * <code>string roomId = 3;</code>
   * @return The bytes for roomId.
   */
  com.google.protobuf.ByteString
      getRoomIdBytes();

  /**
   * <code>int32 playerNumber = 4;</code>
   * @return The playerNumber.
   */
  int getPlayerNumber();
}