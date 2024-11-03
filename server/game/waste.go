package game

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
	"math/rand"
)

var WasteTypes = []pb.WasteType{
	pb.WasteType_PLASTIC_BOTTLE,
	pb.WasteType_PLASTIC_JUG,
	pb.WasteType_PLASTIC_DETERGENT_BOTTLE,
	pb.WasteType_PAPER_NEWSPAPER,
	pb.WasteType_PAPER_BAG,
	pb.WasteType_GLASS_SODA_BOTTLE,
	pb.WasteType_GLASS_JAR,
	pb.WasteType_GLASS_BOTTLE,
	pb.WasteType_METAL_SMALL_CAN,
	pb.WasteType_METAL_CAN,
	pb.WasteType_METAL_SODA_CAN,
	pb.WasteType_POLYSTYRENE_CUP,
	pb.WasteType_PIZZA_BOX,
	pb.WasteType_MUG,
	pb.WasteType_AEROSOL_CAN,
}

func GenerateRandomWaste() pb.WasteType {
	maxBound := len(WasteTypes)
	idx := rand.Intn(maxBound)

	return WasteTypes[idx]
}
