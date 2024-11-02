package services

/*func (cp *ConnectionsPool) Add(roomId string, stream grpc.ServerStreamingServer[pb.ServerEvent]) (*Connection, error) {
	roomIdx := slices.IndexFunc(cp.rooms, func(gr game.Room) bool { return gr.Id == roomId })

	if roomIdx == -1 {
		return nil, errors.New("that room doesn't exists")
	}

	r := cp.rooms[roomIdx]
	p := r.CreateNewPlayer()

	conn := &Connection{
		player:  p,
		room:    &r,
		stream:  stream,
		channel: make(chan *pb.ServerEvent),
	}

	cp.connections = append(cp.connections, *conn)

	return conn, nil
}

func (cp *ConnectionsPool) Roomcast(roomId string, evt *pb.ServerEvent) {
	for _, conn := range cp.connections {
		if conn.room.Id == roomId {
			conn.channel <- evt
			return
		}

	}
}

func (cp *ConnectionsPool) Broadcast(evt *pb.ServerEvent) {
	for _, conn := range cp.connections {
		conn.channel <- evt
	}
}
*/
