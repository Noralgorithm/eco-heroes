package game

import pb "github.com/eco-heroes/server/proto/gameevents"

var AcceptableWastesMap = map[pb.ContainerType][]pb.WasteType{
	pb.ContainerType_YELLOW: {pb.WasteType_PLASTIC_BOTTLE, pb.WasteType_PLASTIC_JUG, pb.WasteType_PLASTIC_DETERGENT_BOTTLE},
	pb.ContainerType_GREEN:  {pb.WasteType_GLASS_BOTTLE, pb.WasteType_GLASS_JAR, pb.WasteType_GLASS_SODA_BOTTLE},
	pb.ContainerType_BLUE:   {pb.WasteType_PAPER_NEWSPAPER, pb.WasteType_PAPER_BAG, pb.WasteType_PAPER_BOX},
	pb.ContainerType_BROWN:  {pb.WasteType_METAL_CAN, pb.WasteType_METAL_SODA_CAN, pb.WasteType_METAL_SMALL_CAN},
	pb.ContainerType_DUMP:   {pb.WasteType_MUG, pb.WasteType_AEROSOL_CAN, pb.WasteType_PIZZA_BOX, pb.WasteType_POLYSTYRENE_CUP},
}

func IsWasteProperlyDisposed(container pb.ContainerType, waste pb.WasteType) bool {
	acceptableWastes, exists := AcceptableWastesMap[container]
	if !exists {
		return false
	}

	for _, w := range acceptableWastes {
		if w == waste {
			return true
		}
	}
	return false
}
