package game

var (
	INITIAL_SCORE = 0
	INITIAL_LIVES = 3
)

type Match struct {
	Player Player
	Score  int
	Lives  int
}

func NewMatch(p Player) Match {
	m := Match{
		Player: p,
		Score:  INITIAL_SCORE,
		Lives:  INITIAL_LIVES,
	}

	return m
}
