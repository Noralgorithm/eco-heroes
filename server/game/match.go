package game

var (
	InitialScore = 0
	InitialLives = 3
)

type Match struct {
	Player *Player
	Score  int
	Lives  int
}

func NewMatch(p Player) Match {
	m := Match{
		Player: &p,
		Score:  InitialScore,
		Lives:  InitialLives,
	}

	return m
}
