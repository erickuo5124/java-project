package fight_covid19;

public class State {

    static PlantType currentOption = PlantType.None;

    enum PlantType {
        None,
        BOOK,
        ALCOHOL,
        MASK,
    }

    public static void setCurrentOption(PlantType curr) {
        currentOption = curr;
    }

}
