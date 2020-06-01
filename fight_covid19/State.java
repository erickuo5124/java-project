package fight_covid19;

public class State {

    static PlantType currentOption = PlantType.None;

    enum PlantType {
        None,
        Sunflower,
        Peashooter,
        WallNut,
    }

    public static void setCurrentOption(PlantType curr) {
        currentOption = curr;
    }

}
