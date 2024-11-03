package game

const (
	InitialScore = 0
	InitialLives = 3
)

type Match struct {
	Score int
	Lives int
}

func NewMatch() Match {
	m := Match{
		Score: InitialScore,
		Lives: InitialLives,
	}

	return m
}
