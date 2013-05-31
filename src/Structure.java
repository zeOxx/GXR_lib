/**
 * Created by Inge on 24.05.13
 * <p/>
 * Generic structure class for the Build Order Notebook application.
 */
import java.util.ArrayList;
import java.util.List;

public class Structure {
    //region Class Variables
    private String name;
    private String description;

    private String requirement;
    private ReqType requirementType;

    private List<Cost> costs;

    private int shield;
    private int hitPoints;
    private int buildTime;
    //endregion

    //region Constructor
    public Structure(String name) {
        setName(name);
        setDescription("empty");

        setRequirement("none");
        setRequirementType(ReqType.NONE);

        setShield(0);
        setHitPoints(0);
        setBuildTime(0);

        costs = new ArrayList<Cost>();
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public ReqType getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(ReqType requirementType) {
        this.requirementType = requirementType;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    //endregion

    //region Methods
    public void addCost(Cost cost) {
        costs.add(cost);
    }
    //endregion
}