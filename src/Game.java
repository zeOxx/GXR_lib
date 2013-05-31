/**
 * Created by Inge on 24.05.13
 * <p/>
 * Generic game class for the Build Order Notebook application.
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Game {
    //region Class Variables
    private String name;
    private String description;
    private List<Race> raceList;
    //endregion

    //region Constructor
    public Game(String name) {
        setName(name);
        setDescription("empty");

        // Init raceList
        raceList = new ArrayList<Race>();
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
    public static void main(String argv[]) {
        createGame("xml/starcraft2.xml");
    }

    /**
     * Parses the xml file passed and returns the appropriate Game class
     *
     * @param fileName Path to file
     */
    public static void createGame(String fileName) {
        try {
            // File object
            File xmlFile = new File(fileName);

            // Prepare parsing
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            // Print out the root element
            System.out.println("\nGame: " + doc.getDocumentElement().getAttribute("name"));

            // store nodes in a nodelist
            NodeList raceList = doc.getElementsByTagName("race");

            for (int i = 0; i < raceList.getLength(); i++) {
                Node raceNode = raceList.item(i);

                System.out.println("\n----\nCurrent Element: " + raceNode.getNodeName() + " #" + i);

                if (raceNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) raceNode;

                    System.out.println("Race name: " + eElement.getAttribute("name") + "\n\nStructures:");

                    NodeList structList = eElement.getElementsByTagName("structure");

                    // Go through structures
                    for (int j = 0; j < structList.getLength(); j++) {
                        Node structNode = structList.item(j);

                        if (structNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element sElement = (Element) structNode;

                            System.out.println("\nName: " + sElement.getAttribute("name"));

                            // Print out shield value if it is more than 0
                            if (sElement.getElementsByTagName("shield").getLength() > 0) {
                                System.out.println("\tShield: "
                                        + sElement.getElementsByTagName("shield").item(0).getTextContent());
                            }

                            System.out.println("\tHealth: "
                                    + sElement.getElementsByTagName("hitpoints").item(0).getTextContent());

                            System.out.println("\tProduction Time: "
                                    + sElement.getElementsByTagName("prodTime").item(0).getTextContent());

                            if (sElement.getElementsByTagName("energy").getLength() > 0) {
                                System.out.println("\tEnergy: "
                                        + sElement.getElementsByTagName("energy").item(0).getTextContent());
                            }

                            // Print the requirement, if there is one
                            if (sElement.getElementsByTagName("requirement").getLength() > 0) {
                                NodeList reqList = sElement.getElementsByTagName("requirement");

                                for (int k = 0; k < reqList.getLength(); k++) {
                                    Node reqNode = reqList.item(k);

                                    if (reqNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element rElement = (Element) reqNode;

                                        System.out.println("\tRequirement: "
                                                + rElement.getElementsByTagName("name").item(0).getTextContent()
                                                + " ("
                                                + rElement.getElementsByTagName("type").item(0).getTextContent()
                                                + ")");
                                    }
                                }
                            }

                            // Print the cost
                            if (sElement.getElementsByTagName("cost").getLength() > 0) {
                                NodeList costList = sElement.getElementsByTagName("cost");

                                System.out.println("\tCost:");

                                for (int l = 0; l < costList.getLength(); l++) {
                                    Node costNode = costList.item(l);

                                    if (costNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element cElement = (Element) costNode;

                                        System.out.println("\t\t"
                                                + cElement.getElementsByTagName("amount").item(0).getTextContent()
                                                + " "
                                                + cElement.getElementsByTagName("type").item(0).getTextContent());
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("Units:");

                    NodeList unitList = eElement.getElementsByTagName("unit");

                    // Go through units!
                    for (int j = 0; j < unitList.getLength(); j++) {
                        Node unitNode = unitList.item(j);

                        if (unitNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element uElement = (Element) unitNode;

                            System.out.println("\nName: " + uElement.getAttribute("name"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return tempGame;
    }

    /**
     * Adds the passed race object into the list
     * <p/>
     * This is best used if you already have a complete object to put in. You can
     * obviously go either way though
     *
     * @param race Race object being added
     */
    public void addRaceListItem(Race race) {
        raceList.add(race);
    }
    //endregion
}
