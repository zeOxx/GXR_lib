/**
 * Created by Inge on 24.05.13
 * <p/>
 * Class that holds cost and cost type for units, structures or buildings
 */
public class Cost {
    //region Class Variables
    private String name;
    private int amount;
    //endregion

    //region Constructor
    public Cost(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    //endregion
}
