/**
 * Created by Inge on 24.05.13
 * <p/>
 * Generic race class for the Build Order Notebook application.
 */
import java.util.ArrayList;
import java.util.List;

public class Race {
    //region Class Variables
    private String name;
    private String description;
    private List<Structure> structureList;
    private List<Unit> unitList;
    private List<Upgrade> upgradeList;
    //endregion

    //region Constructor
    public Race(String name) {
        setName(name);
        setDescription("empty");

        //Init lists
        structureList = new ArrayList<Structure>();
        unitList = new ArrayList<Unit>();
        upgradeList = new ArrayList<Upgrade>();
    }
    //endregion

    //region Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion

    //region Methods
    /**
     * Adds a new structure object to the structure list
     *
     * @param structure Structure object being added
     */
    public void addStructureListItem(Structure structure) {
        structureList.add(structure);
    }

    /**
     * Adds a new structure object to the structure list
     *
     * @param unit Unit object being added
     */
    public void addUnitListItem(Unit unit) {
        unitList.add(unit);
    }

    /**
     * Adds a new structure object to the structure list
     *
     * @param upgrade Upgrade object being added
     */
    public void addUpgradeListItem(Upgrade upgrade) {
        upgradeList.add(upgrade);
    }
    //endregion
}
