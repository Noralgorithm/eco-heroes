package game

var (
	InitialSpeed = 1
)

type Room struct {
	Id      string
	Matches []Match
	Speed   int
}

func NewRoom() Room {
	return Room{Id: "hola", Matches: []Match{}, Speed: InitialSpeed}
}

func (r *Room) CreateNewPlayer() Player {
	//TODO: LOGIC TO ASSIGN PLAYER NUMBER
	p := Player{
		Number: 27,
	}

	m := NewMatch(p)

	r.Matches = append(r.Matches, m)

	return p
}
