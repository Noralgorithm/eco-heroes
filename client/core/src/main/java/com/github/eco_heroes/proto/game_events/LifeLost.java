// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: game-events.proto
// Protobuf Java Version: 4.28.3

package com.github.eco_heroes.proto.game_events;

/**
 * Protobuf type {@code ecoheroes.LifeLost}
 */
public final class LifeLost extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ecoheroes.LifeLost)
    LifeLostOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 3,
      /* suffix= */ "",
      LifeLost.class.getName());
  }
  // Use LifeLost.newBuilder() to construct.
  private LifeLost(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LifeLost() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.github.eco_heroes.proto.game_events.GameEventsProto.internal_static_ecoheroes_LifeLost_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.github.eco_heroes.proto.game_events.GameEventsProto.internal_static_ecoheroes_LifeLost_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.github.eco_heroes.proto.game_events.LifeLost.class, com.github.eco_heroes.proto.game_events.LifeLost.Builder.class);
  }

  public static final int LIVES_FIELD_NUMBER = 1;
  private int lives_ = 0;
  /**
   * <code>int32 lives = 1;</code>
   * @return The lives.
   */
  @java.lang.Override
  public int getLives() {
    return lives_;
  }

  public static final int PLAYERNUMBER_FIELD_NUMBER = 2;
  private int playerNumber_ = 0;
  /**
   * <code>int32 playerNumber = 2;</code>
   * @return The playerNumber.
   */
  @java.lang.Override
  public int getPlayerNumber() {
    return playerNumber_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (lives_ != 0) {
      output.writeInt32(1, lives_);
    }
    if (playerNumber_ != 0) {
      output.writeInt32(2, playerNumber_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (lives_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, lives_);
    }
    if (playerNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, playerNumber_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.github.eco_heroes.proto.game_events.LifeLost)) {
      return super.equals(obj);
    }
    com.github.eco_heroes.proto.game_events.LifeLost other = (com.github.eco_heroes.proto.game_events.LifeLost) obj;

    if (getLives()
        != other.getLives()) return false;
    if (getPlayerNumber()
        != other.getPlayerNumber()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LIVES_FIELD_NUMBER;
    hash = (53 * hash) + getLives();
    hash = (37 * hash) + PLAYERNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getPlayerNumber();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.github.eco_heroes.proto.game_events.LifeLost parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.github.eco_heroes.proto.game_events.LifeLost parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.github.eco_heroes.proto.game_events.LifeLost parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.github.eco_heroes.proto.game_events.LifeLost prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ecoheroes.LifeLost}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ecoheroes.LifeLost)
      com.github.eco_heroes.proto.game_events.LifeLostOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.github.eco_heroes.proto.game_events.GameEventsProto.internal_static_ecoheroes_LifeLost_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.github.eco_heroes.proto.game_events.GameEventsProto.internal_static_ecoheroes_LifeLost_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.github.eco_heroes.proto.game_events.LifeLost.class, com.github.eco_heroes.proto.game_events.LifeLost.Builder.class);
    }

    // Construct using com.github.eco_heroes.proto.game_events.LifeLost.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      lives_ = 0;
      playerNumber_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.github.eco_heroes.proto.game_events.GameEventsProto.internal_static_ecoheroes_LifeLost_descriptor;
    }

    @java.lang.Override
    public com.github.eco_heroes.proto.game_events.LifeLost getDefaultInstanceForType() {
      return com.github.eco_heroes.proto.game_events.LifeLost.getDefaultInstance();
    }

    @java.lang.Override
    public com.github.eco_heroes.proto.game_events.LifeLost build() {
      com.github.eco_heroes.proto.game_events.LifeLost result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.github.eco_heroes.proto.game_events.LifeLost buildPartial() {
      com.github.eco_heroes.proto.game_events.LifeLost result = new com.github.eco_heroes.proto.game_events.LifeLost(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.github.eco_heroes.proto.game_events.LifeLost result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.lives_ = lives_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.playerNumber_ = playerNumber_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.github.eco_heroes.proto.game_events.LifeLost) {
        return mergeFrom((com.github.eco_heroes.proto.game_events.LifeLost)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.github.eco_heroes.proto.game_events.LifeLost other) {
      if (other == com.github.eco_heroes.proto.game_events.LifeLost.getDefaultInstance()) return this;
      if (other.getLives() != 0) {
        setLives(other.getLives());
      }
      if (other.getPlayerNumber() != 0) {
        setPlayerNumber(other.getPlayerNumber());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              lives_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              playerNumber_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int lives_ ;
    /**
     * <code>int32 lives = 1;</code>
     * @return The lives.
     */
    @java.lang.Override
    public int getLives() {
      return lives_;
    }
    /**
     * <code>int32 lives = 1;</code>
     * @param value The lives to set.
     * @return This builder for chaining.
     */
    public Builder setLives(int value) {

      lives_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 lives = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLives() {
      bitField0_ = (bitField0_ & ~0x00000001);
      lives_ = 0;
      onChanged();
      return this;
    }

    private int playerNumber_ ;
    /**
     * <code>int32 playerNumber = 2;</code>
     * @return The playerNumber.
     */
    @java.lang.Override
    public int getPlayerNumber() {
      return playerNumber_;
    }
    /**
     * <code>int32 playerNumber = 2;</code>
     * @param value The playerNumber to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerNumber(int value) {

      playerNumber_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 playerNumber = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerNumber() {
      bitField0_ = (bitField0_ & ~0x00000002);
      playerNumber_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ecoheroes.LifeLost)
  }

  // @@protoc_insertion_point(class_scope:ecoheroes.LifeLost)
  private static final com.github.eco_heroes.proto.game_events.LifeLost DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.github.eco_heroes.proto.game_events.LifeLost();
  }

  public static com.github.eco_heroes.proto.game_events.LifeLost getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LifeLost>
      PARSER = new com.google.protobuf.AbstractParser<LifeLost>() {
    @java.lang.Override
    public LifeLost parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<LifeLost> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LifeLost> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.github.eco_heroes.proto.game_events.LifeLost getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

