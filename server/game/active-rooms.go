package game

var ActiveRooms []*Room

func FindActiveRoom(roomId string) *Room {
	for _, r := range ActiveRooms {
		if r.Id.String() == roomId {
			return r
		}
	}

	return nil
}
