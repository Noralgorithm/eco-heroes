// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.35.1
// 	protoc        v5.28.3
// source: rooms.proto

package rooms

import (
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	emptypb "google.golang.org/protobuf/types/known/emptypb"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

type RoomDataReply struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Id           string              `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	Players      []*PlayerInRoomData `protobuf:"bytes,2,rep,name=players,proto3" json:"players,omitempty"`
	PlayersLimit int32               `protobuf:"varint,3,opt,name=playersLimit,proto3" json:"playersLimit,omitempty"`
	Me           *PlayerInRoomData   `protobuf:"bytes,4,opt,name=me,proto3" json:"me,omitempty"`
}

func (x *RoomDataReply) Reset() {
	*x = RoomDataReply{}
	mi := &file_rooms_proto_msgTypes[0]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *RoomDataReply) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*RoomDataReply) ProtoMessage() {}

func (x *RoomDataReply) ProtoReflect() protoreflect.Message {
	mi := &file_rooms_proto_msgTypes[0]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use RoomDataReply.ProtoReflect.Descriptor instead.
func (*RoomDataReply) Descriptor() ([]byte, []int) {
	return file_rooms_proto_rawDescGZIP(), []int{0}
}

func (x *RoomDataReply) GetId() string {
	if x != nil {
		return x.Id
	}
	return ""
}

func (x *RoomDataReply) GetPlayers() []*PlayerInRoomData {
	if x != nil {
		return x.Players
	}
	return nil
}

func (x *RoomDataReply) GetPlayersLimit() int32 {
	if x != nil {
		return x.PlayersLimit
	}
	return 0
}

func (x *RoomDataReply) GetMe() *PlayerInRoomData {
	if x != nil {
		return x.Me
	}
	return nil
}

type JoinRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	RoomId string `protobuf:"bytes,1,opt,name=roomId,proto3" json:"roomId,omitempty"`
}

func (x *JoinRequest) Reset() {
	*x = JoinRequest{}
	mi := &file_rooms_proto_msgTypes[1]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *JoinRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*JoinRequest) ProtoMessage() {}

func (x *JoinRequest) ProtoReflect() protoreflect.Message {
	mi := &file_rooms_proto_msgTypes[1]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use JoinRequest.ProtoReflect.Descriptor instead.
func (*JoinRequest) Descriptor() ([]byte, []int) {
	return file_rooms_proto_rawDescGZIP(), []int{1}
}

func (x *JoinRequest) GetRoomId() string {
	if x != nil {
		return x.RoomId
	}
	return ""
}

type RoomsListReply struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Rooms []*RoomDataReply `protobuf:"bytes,1,rep,name=rooms,proto3" json:"rooms,omitempty"`
}

func (x *RoomsListReply) Reset() {
	*x = RoomsListReply{}
	mi := &file_rooms_proto_msgTypes[2]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *RoomsListReply) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*RoomsListReply) ProtoMessage() {}

func (x *RoomsListReply) ProtoReflect() protoreflect.Message {
	mi := &file_rooms_proto_msgTypes[2]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use RoomsListReply.ProtoReflect.Descriptor instead.
func (*RoomsListReply) Descriptor() ([]byte, []int) {
	return file_rooms_proto_rawDescGZIP(), []int{2}
}

func (x *RoomsListReply) GetRooms() []*RoomDataReply {
	if x != nil {
		return x.Rooms
	}
	return nil
}

type PlayerInRoomData struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Number int32 `protobuf:"varint,1,opt,name=number,proto3" json:"number,omitempty"`
}

func (x *PlayerInRoomData) Reset() {
	*x = PlayerInRoomData{}
	mi := &file_rooms_proto_msgTypes[3]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *PlayerInRoomData) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PlayerInRoomData) ProtoMessage() {}

func (x *PlayerInRoomData) ProtoReflect() protoreflect.Message {
	mi := &file_rooms_proto_msgTypes[3]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PlayerInRoomData.ProtoReflect.Descriptor instead.
func (*PlayerInRoomData) Descriptor() ([]byte, []int) {
	return file_rooms_proto_rawDescGZIP(), []int{3}
}

func (x *PlayerInRoomData) GetNumber() int32 {
	if x != nil {
		return x.Number
	}
	return 0
}

var File_rooms_proto protoreflect.FileDescriptor

var file_rooms_proto_rawDesc = []byte{
	0x0a, 0x0b, 0x72, 0x6f, 0x6f, 0x6d, 0x73, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x09, 0x65,
	0x63, 0x6f, 0x68, 0x65, 0x72, 0x6f, 0x65, 0x73, 0x1a, 0x1b, 0x67, 0x6f, 0x6f, 0x67, 0x6c, 0x65,
	0x2f, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x62, 0x75, 0x66, 0x2f, 0x65, 0x6d, 0x70, 0x74, 0x79, 0x2e,
	0x70, 0x72, 0x6f, 0x74, 0x6f, 0x22, 0xa7, 0x01, 0x0a, 0x0d, 0x52, 0x6f, 0x6f, 0x6d, 0x44, 0x61,
	0x74, 0x61, 0x52, 0x65, 0x70, 0x6c, 0x79, 0x12, 0x0e, 0x0a, 0x02, 0x69, 0x64, 0x18, 0x01, 0x20,
	0x01, 0x28, 0x09, 0x52, 0x02, 0x69, 0x64, 0x12, 0x35, 0x0a, 0x07, 0x70, 0x6c, 0x61, 0x79, 0x65,
	0x72, 0x73, 0x18, 0x02, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x1b, 0x2e, 0x65, 0x63, 0x6f, 0x68, 0x65,
	0x72, 0x6f, 0x65, 0x73, 0x2e, 0x50, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x49, 0x6e, 0x52, 0x6f, 0x6f,
	0x6d, 0x44, 0x61, 0x74, 0x61, 0x52, 0x07, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x12, 0x22,
	0x0a, 0x0c, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x4c, 0x69, 0x6d, 0x69, 0x74, 0x18, 0x03,
	0x20, 0x01, 0x28, 0x05, 0x52, 0x0c, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x4c, 0x69, 0x6d,
	0x69, 0x74, 0x12, 0x2b, 0x0a, 0x02, 0x6d, 0x65, 0x18, 0x04, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x1b,
	0x2e, 0x65, 0x63, 0x6f, 0x68, 0x65, 0x72, 0x6f, 0x65, 0x73, 0x2e, 0x50, 0x6c, 0x61, 0x79, 0x65,
	0x72, 0x49, 0x6e, 0x52, 0x6f, 0x6f, 0x6d, 0x44, 0x61, 0x74, 0x61, 0x52, 0x02, 0x6d, 0x65, 0x22,
	0x25, 0x0a, 0x0b, 0x4a, 0x6f, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12, 0x16,
	0x0a, 0x06, 0x72, 0x6f, 0x6f, 0x6d, 0x49, 0x64, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x06,
	0x72, 0x6f, 0x6f, 0x6d, 0x49, 0x64, 0x22, 0x40, 0x0a, 0x0e, 0x52, 0x6f, 0x6f, 0x6d, 0x73, 0x4c,
	0x69, 0x73, 0x74, 0x52, 0x65, 0x70, 0x6c, 0x79, 0x12, 0x2e, 0x0a, 0x05, 0x72, 0x6f, 0x6f, 0x6d,
	0x73, 0x18, 0x01, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x18, 0x2e, 0x65, 0x63, 0x6f, 0x68, 0x65, 0x72,
	0x6f, 0x65, 0x73, 0x2e, 0x52, 0x6f, 0x6f, 0x6d, 0x44, 0x61, 0x74, 0x61, 0x52, 0x65, 0x70, 0x6c,
	0x79, 0x52, 0x05, 0x72, 0x6f, 0x6f, 0x6d, 0x73, 0x22, 0x2a, 0x0a, 0x10, 0x50, 0x6c, 0x61, 0x79,
	0x65, 0x72, 0x49, 0x6e, 0x52, 0x6f, 0x6f, 0x6d, 0x44, 0x61, 0x74, 0x61, 0x12, 0x16, 0x0a, 0x06,
	0x6e, 0x75, 0x6d, 0x62, 0x65, 0x72, 0x18, 0x01, 0x20, 0x01, 0x28, 0x05, 0x52, 0x06, 0x6e, 0x75,
	0x6d, 0x62, 0x65, 0x72, 0x32, 0xc0, 0x01, 0x0a, 0x05, 0x52, 0x6f, 0x6f, 0x6d, 0x73, 0x12, 0x41,
	0x0a, 0x0d, 0x63, 0x72, 0x65, 0x61, 0x74, 0x65, 0x41, 0x6e, 0x64, 0x4a, 0x6f, 0x69, 0x6e, 0x12,
	0x16, 0x2e, 0x67, 0x6f, 0x6f, 0x67, 0x6c, 0x65, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x62, 0x75,
	0x66, 0x2e, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x1a, 0x18, 0x2e, 0x65, 0x63, 0x6f, 0x68, 0x65, 0x72,
	0x6f, 0x65, 0x73, 0x2e, 0x52, 0x6f, 0x6f, 0x6d, 0x44, 0x61, 0x74, 0x61, 0x52, 0x65, 0x70, 0x6c,
	0x79, 0x12, 0x38, 0x0a, 0x04, 0x6a, 0x6f, 0x69, 0x6e, 0x12, 0x16, 0x2e, 0x65, 0x63, 0x6f, 0x68,
	0x65, 0x72, 0x6f, 0x65, 0x73, 0x2e, 0x4a, 0x6f, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73,
	0x74, 0x1a, 0x18, 0x2e, 0x65, 0x63, 0x6f, 0x68, 0x65, 0x72, 0x6f, 0x65, 0x73, 0x2e, 0x52, 0x6f,
	0x6f, 0x6d, 0x44, 0x61, 0x74, 0x61, 0x52, 0x65, 0x70, 0x6c, 0x79, 0x12, 0x3a, 0x0a, 0x05, 0x66,
	0x65, 0x74, 0x63, 0x68, 0x12, 0x16, 0x2e, 0x67, 0x6f, 0x6f, 0x67, 0x6c, 0x65, 0x2e, 0x70, 0x72,
	0x6f, 0x74, 0x6f, 0x62, 0x75, 0x66, 0x2e, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x1a, 0x19, 0x2e, 0x65,
	0x63, 0x6f, 0x68, 0x65, 0x72, 0x6f, 0x65, 0x73, 0x2e, 0x52, 0x6f, 0x6f, 0x6d, 0x73, 0x4c, 0x69,
	0x73, 0x74, 0x52, 0x65, 0x70, 0x6c, 0x79, 0x42, 0x3a, 0x0a, 0x21, 0x63, 0x6f, 0x6d, 0x2e, 0x67,
	0x69, 0x74, 0x68, 0x75, 0x62, 0x2e, 0x65, 0x63, 0x6f, 0x5f, 0x68, 0x65, 0x72, 0x6f, 0x65, 0x73,
	0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x2e, 0x72, 0x6f, 0x6f, 0x6d, 0x73, 0x42, 0x0a, 0x52, 0x6f,
	0x6f, 0x6d, 0x73, 0x50, 0x72, 0x6f, 0x74, 0x6f, 0x50, 0x01, 0x5a, 0x07, 0x2e, 0x2f, 0x72, 0x6f,
	0x6f, 0x6d, 0x73, 0x62, 0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_rooms_proto_rawDescOnce sync.Once
	file_rooms_proto_rawDescData = file_rooms_proto_rawDesc
)

func file_rooms_proto_rawDescGZIP() []byte {
	file_rooms_proto_rawDescOnce.Do(func() {
		file_rooms_proto_rawDescData = protoimpl.X.CompressGZIP(file_rooms_proto_rawDescData)
	})
	return file_rooms_proto_rawDescData
}

var file_rooms_proto_msgTypes = make([]protoimpl.MessageInfo, 4)
var file_rooms_proto_goTypes = []any{
	(*RoomDataReply)(nil),    // 0: ecoheroes.RoomDataReply
	(*JoinRequest)(nil),      // 1: ecoheroes.JoinRequest
	(*RoomsListReply)(nil),   // 2: ecoheroes.RoomsListReply
	(*PlayerInRoomData)(nil), // 3: ecoheroes.PlayerInRoomData
	(*emptypb.Empty)(nil),    // 4: google.protobuf.Empty
}
var file_rooms_proto_depIdxs = []int32{
	3, // 0: ecoheroes.RoomDataReply.players:type_name -> ecoheroes.PlayerInRoomData
	3, // 1: ecoheroes.RoomDataReply.me:type_name -> ecoheroes.PlayerInRoomData
	0, // 2: ecoheroes.RoomsListReply.rooms:type_name -> ecoheroes.RoomDataReply
	4, // 3: ecoheroes.Rooms.createAndJoin:input_type -> google.protobuf.Empty
	1, // 4: ecoheroes.Rooms.join:input_type -> ecoheroes.JoinRequest
	4, // 5: ecoheroes.Rooms.fetch:input_type -> google.protobuf.Empty
	0, // 6: ecoheroes.Rooms.createAndJoin:output_type -> ecoheroes.RoomDataReply
	0, // 7: ecoheroes.Rooms.join:output_type -> ecoheroes.RoomDataReply
	2, // 8: ecoheroes.Rooms.fetch:output_type -> ecoheroes.RoomsListReply
	6, // [6:9] is the sub-list for method output_type
	3, // [3:6] is the sub-list for method input_type
	3, // [3:3] is the sub-list for extension type_name
	3, // [3:3] is the sub-list for extension extendee
	0, // [0:3] is the sub-list for field type_name
}

func init() { file_rooms_proto_init() }
func file_rooms_proto_init() {
	if File_rooms_proto != nil {
		return
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_rooms_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   4,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_rooms_proto_goTypes,
		DependencyIndexes: file_rooms_proto_depIdxs,
		MessageInfos:      file_rooms_proto_msgTypes,
	}.Build()
	File_rooms_proto = out.File
	file_rooms_proto_rawDesc = nil
	file_rooms_proto_goTypes = nil
	file_rooms_proto_depIdxs = nil
}
