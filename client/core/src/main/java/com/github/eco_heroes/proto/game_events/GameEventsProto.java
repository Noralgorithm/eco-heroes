// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: game-events.proto
// Protobuf Java Version: 4.28.2

package com.github.eco_heroes.proto.game_events;

public final class GameEventsProto {
  private GameEventsProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      GameEventsProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_RoomGameDataReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_RoomGameDataReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_PlayerInRoomGameData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_PlayerInRoomGameData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_SubscriptionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_SubscriptionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_StartGameRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_StartGameRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_Unspecified_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_Unspecified_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_PlayerAdded_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_PlayerAdded_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_PlayerRemoved_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_PlayerRemoved_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_GameStarted_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_GameStarted_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_WasteGenerated_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_WasteGenerated_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_LifeLost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_LifeLost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_SpeedIncreased_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_SpeedIncreased_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_GameEnded_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_GameEnded_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecoheroes_ServerEvent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ecoheroes_ServerEvent_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021game-events.proto\022\tecoheroes\"g\n\021RoomGa" +
      "meDataReply\022\n\n\002id\030\001 \001(\t\0220\n\007players\030\002 \003(\013" +
      "2\037.ecoheroes.PlayerInRoomGameData\022\024\n\014pla" +
      "yersLimit\030\003 \001(\005\"&\n\024PlayerInRoomGameData\022" +
      "\016\n\006number\030\001 \001(\005\";\n\023SubscriptionRequest\022\016" +
      "\n\006roomId\030\001 \001(\t\022\024\n\014playerNumber\030\002 \001(\005\"\"\n\020" +
      "StartGameRequest\022\016\n\006roomId\030\001 \001(\t\"\r\n\013Unsp" +
      "ecified\"#\n\013PlayerAdded\022\024\n\014playerNumber\030\001" +
      " \001(\005\"%\n\rPlayerRemoved\022\024\n\014playerNumber\030\001 " +
      "\001(\005\"\036\n\013GameStarted\022\017\n\007message\030\001 \001(\t\"5\n\016W" +
      "asteGenerated\022#\n\005waste\030\001 \001(\0162\024.ecoheroes" +
      ".WasteType\"/\n\010LifeLost\022\r\n\005lives\030\001 \001(\005\022\024\n" +
      "\014playerNumber\030\002 \001(\005\"\037\n\016SpeedIncreased\022\r\n" +
      "\005speed\030\001 \001(\005\"!\n\tGameEnded\022\024\n\014winnerNumbe" +
      "r\030\001 \001(\005\"\254\003\n\013ServerEvent\0220\n\016unspecifiedEv" +
      "t\030\001 \001(\0132\026.ecoheroes.UnspecifiedH\000\0220\n\016pla" +
      "yerAddedEvt\030\002 \001(\0132\026.ecoheroes.PlayerAdde" +
      "dH\000\0224\n\020playerRemovedEvt\030\003 \001(\0132\030.ecoheroe" +
      "s.PlayerRemovedH\000\0220\n\016gameStartedEvt\030\004 \001(" +
      "\0132\026.ecoheroes.GameStartedH\000\0226\n\021wasteGene" +
      "ratedEvt\030\005 \001(\0132\031.ecoheroes.WasteGenerate" +
      "dH\000\022*\n\013lifeLostEvt\030\006 \001(\0132\023.ecoheroes.Lif" +
      "eLostH\000\0226\n\021speedIncreasedEvt\030\007 \001(\0132\031.eco" +
      "heroes.SpeedIncreasedH\000\022,\n\014gameEndedEvt\030" +
      "\010 \001(\0132\024.ecoheroes.GameEndedH\000B\007\n\005Event*\270" +
      "\002\n\tWasteType\022\026\n\022WASTE_TYPE_UNKNOWN\020\000\022\022\n\016" +
      "PLASTIC_BOTTLE\020\001\022\017\n\013PLASTIC_JUG\020\002\022\034\n\030PLA" +
      "STIC_DETERGENT_BOTTLE\020\003\022\023\n\017PAPER_NEWSPAP" +
      "ER\020\004\022\r\n\tPAPER_BAG\020\005\022\025\n\021GLASS_SODA_BOTTLE" +
      "\020\006\022\r\n\tGLASS_JAR\020\007\022\020\n\014GLASS_BOTTLE\020\010\022\023\n\017M" +
      "ETAL_SMALL_CAN\020\t\022\r\n\tMETAL_CAN\020\n\022\022\n\016METAL" +
      "_SODA_CAN\020\013\022\023\n\017POLYSTYRENE_CUP\020\014\022\r\n\tPIZZ" +
      "A_BOX\020\r\022\007\n\003MUG\020\016\022\017\n\013AEROSOL_CAN\020\0172\233\001\n\nGa" +
      "meEvents\022E\n\tsubscribe\022\036.ecoheroes.Subscr" +
      "iptionRequest\032\026.ecoheroes.ServerEvent0\001\022" +
      "F\n\tstartGame\022\033.ecoheroes.StartGameReques" +
      "t\032\034.ecoheroes.RoomGameDataReplyBJ\n\'com.g" +
      "ithub.eco_heroes.proto.game_eventsB\017Game" +
      "EventsProtoP\001Z\014./gameeventsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ecoheroes_RoomGameDataReply_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ecoheroes_RoomGameDataReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_RoomGameDataReply_descriptor,
        new java.lang.String[] { "Id", "Players", "PlayersLimit", });
    internal_static_ecoheroes_PlayerInRoomGameData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ecoheroes_PlayerInRoomGameData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_PlayerInRoomGameData_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_ecoheroes_SubscriptionRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ecoheroes_SubscriptionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_SubscriptionRequest_descriptor,
        new java.lang.String[] { "RoomId", "PlayerNumber", });
    internal_static_ecoheroes_StartGameRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ecoheroes_StartGameRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_StartGameRequest_descriptor,
        new java.lang.String[] { "RoomId", });
    internal_static_ecoheroes_Unspecified_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ecoheroes_Unspecified_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_Unspecified_descriptor,
        new java.lang.String[] { });
    internal_static_ecoheroes_PlayerAdded_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ecoheroes_PlayerAdded_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_PlayerAdded_descriptor,
        new java.lang.String[] { "PlayerNumber", });
    internal_static_ecoheroes_PlayerRemoved_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ecoheroes_PlayerRemoved_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_PlayerRemoved_descriptor,
        new java.lang.String[] { "PlayerNumber", });
    internal_static_ecoheroes_GameStarted_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ecoheroes_GameStarted_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_GameStarted_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_ecoheroes_WasteGenerated_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ecoheroes_WasteGenerated_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_WasteGenerated_descriptor,
        new java.lang.String[] { "Waste", });
    internal_static_ecoheroes_LifeLost_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ecoheroes_LifeLost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_LifeLost_descriptor,
        new java.lang.String[] { "Lives", "PlayerNumber", });
    internal_static_ecoheroes_SpeedIncreased_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ecoheroes_SpeedIncreased_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_SpeedIncreased_descriptor,
        new java.lang.String[] { "Speed", });
    internal_static_ecoheroes_GameEnded_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ecoheroes_GameEnded_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_GameEnded_descriptor,
        new java.lang.String[] { "WinnerNumber", });
    internal_static_ecoheroes_ServerEvent_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ecoheroes_ServerEvent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ecoheroes_ServerEvent_descriptor,
        new java.lang.String[] { "UnspecifiedEvt", "PlayerAddedEvt", "PlayerRemovedEvt", "GameStartedEvt", "WasteGeneratedEvt", "LifeLostEvt", "SpeedIncreasedEvt", "GameEndedEvt", "Event", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
