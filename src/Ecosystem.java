import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Ecosystem {
    public static Scanner sc = new Scanner(System.in);

    //The 2D array list entities stores the entity values throughout the simulation
    public static ArrayList<ArrayList<String>> entities = new ArrayList<>();

    /********************************************************************
     * The AddAnimal method takes the user's input, adds the Animal age,
     * energy, and hunger values, then adds the Animal Object to entities
     * @param name
     * @param eater
     * @param p_a
     *******************************************************************/
    public static void AddAnimal(String name, String eater, String p_a) {
        ArrayList<String> newEntity = new ArrayList<>();

        newEntity.add(name);
        newEntity.add(eater);
        newEntity.add(p_a);
        newEntity.add("0");
        newEntity.add("10");
        newEntity.add("0");

        entities.add(newEntity);
    }

    /***************************************************************************
     * The AddPlant method takes the user's input, adds the Plant
     * growth_stage and nutrients values, then adds the Plant Object to entities
     * @param name
     * @param eater
     * @param p_a
     **************************************************************************/
    public static void AddPlant(String name, String eater, String p_a) {
        ArrayList<String> newEntity = new ArrayList<>();

        newEntity.add(name);
        newEntity.add(eater);
        newEntity.add(p_a);
        newEntity.add("0");
        newEntity.add("5");

        entities.add(newEntity);
    }

    /****************************************************************
     * The Remove method allows the user to remove an unwanted entity
     * from entities based on the list value they choose
     * @param row
     ***************************************************************/
    public static void Remove(int row) {
        if (row >= 0 && row < entities.size()) {
            while (true) {
                System.out.println("Are you sure you want to remove " + entities.get(row) + "? (y/n): ");
                String delete = sc.nextLine();
                if (delete.equalsIgnoreCase("y")) {
                    entities.remove(row);
                    System.out.println("Entity has been removed.");
                    break;
                }
                else if (delete.equalsIgnoreCase("n")) {
                    System.out.println("The entity has not been removed.");
                    break;
                }
                else {
                    System.out.println("**Invalid input. Please input y/n**");
                }
            }
        }
        else {
            System.out.println("**Invalid row. Returning back to main menu**");
        }
    }

    /*******************************************************************
     * The PresetList method allows the user to use a preset entity list
     * for their simulation for ease of use
     ******************************************************************/
    public static void PresetList() {
        entities.add(new ArrayList<>(Arrays.asList("Frank", "Herbivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Azzie", "Sunlight", "Plant", "0", "5")));
        entities.add(new ArrayList<>(Arrays.asList("Jerry", "Herbivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Janette", "Carnivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Zack", "Sunlight", "Plant", "0", "5")));
        entities.add(new ArrayList<>(Arrays.asList("Bradley", "Sunlight", "Plant", "0", "5")));
        entities.add(new ArrayList<>(Arrays.asList("Helina", "Herbivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Kelsey", "Carnivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Sam", "Carnivore", "Animal", "0", "10", "0")));
        entities.add(new ArrayList<>(Arrays.asList("Dominic", "Sunlight", "Plant", "0", "5")));
    }

    /********************************************************************
     * The ListAll method prints every entity and their attributes to the
     * screen
     *******************************************************************/
    public static void ListAll() {
        for (ArrayList<String> row : entities) {
            System.out.println(row);
        }
    }

    /*********************************************************
     * The StartSimulation method starts the simulation cycle,
     * implementing each entity currently stored in entities
     ********************************************************/
    public static void StartSimulation() {

        //This array list stores the names of the entities that died during the simulation
        ArrayList<String> deadEntities = new ArrayList<>();

        for (ArrayList<String> row : entities) {

            //The name of the current entity
            String name = row.get(0);

            //Stores the full entity list that died during the simulation
            ArrayList<String> toRemove;

            //Stores the name value of the entity that died during the simulation
            String tco;

            //Error handling if an entity has an unrecognized value
            try {
                System.out.println("____________________________________________________________________");
                System.out.println("Now it's " + name + "'s turn!\n");

                if (row.get(2).equals("Animal")) {
                    //These methods are called for each Animal Object
                    Animal.Move(row);
                    toRemove = Animal.Interact(row);
                    Animal.Age(row);

                    /*
                    This if/else block calculates if the Animal dies if one of the values
                    reaches a certain threshold
                    */
                    if (Integer.parseInt(row.get(3)) >= 5) {
                        System.out.println("Sadly, " + name + " grew too old and died.\n");
                        toRemove = row;
                    }
                    else if (Integer.parseInt(row.get(4)) <= 0) {
                        System.out.println("Sadly, " + name + " ran out of energy and died.\n");
                        toRemove = row;
                    }
                    else if (Integer.parseInt(row.get(5)) >= 10) {
                        System.out.println("Sadly, " + name + " didn't eat in time and died.\n");
                        toRemove = row;
                    }

                    //Stores dead entity's name and changes all other values as Dead
                    if (toRemove != null) {
                        tco = toRemove.get(0);
                        deadEntities.add(tco);
                        for (ArrayList<String> dead : entities) {
                            if (dead.equals(toRemove)) {
                                for (int i = 1; i < dead.size(); i++) {
                                    dead.set(i, "Dead");
                                }
                                break;
                            }
                        }
                    }
                }
                else if (row.get(2).equals("Plant")) {
                    //These methods are called for each Plant Object
                    Plant.Grow(row);
                    Plant.Interact(row);
                }
                else if (row.get(2).equals("Dead")) {
                    //Skips over an entity that has been killed during the cycle
                    System.out.println("This entity has died during the simulation.");
                }
            }
            catch (Exception e) {
                System.out.println("This entity is not recognized. " + e.getMessage());
            }
        }

        //Passing off dead entities to be listed at the end of the cycle
        Sacrifices(deadEntities);
    }

    /******************************************************************************
     * The UpdateState method receives a base array list and a modified array list,
     * then it replaces the base with the modified array list within
     * entities
     * @param mods
     * The modified entity's values
     * @param ent
     * The base entity's values
     *****************************************************************************/
    public static void UpdateState(ArrayList<String> mods, ArrayList<String> ent) {
        for (ArrayList<String> row : entities) {
            if (row.equals(ent)) {
                for(int i = 0; i < row.size(); i++) {
                    row.set(i, mods.get(i));
                }
                break;
            }
        }
    }

    /*********************************************************************
     * The Sacrifices method receives and prints an array list of entities
     * that died during the previous simulation cycle
     * @param deadEntities
     * deadEntities stores the names of the entities that died
     ********************************************************************/
    public static void Sacrifices(ArrayList<String> deadEntities) {
        ArrayList<ArrayList<String>> temp = new ArrayList<>();

        if (!deadEntities.isEmpty()) {
            System.out.println("____________________________________________________________________");
            System.out.println("Sadly, these entities have passed on during this round\n");

            //Iterates through deadEntities and lists off each dead entity's name
            for (String deadEntity : deadEntities) {
                if (!deadEntity.isEmpty()) {
                    System.out.println(deadEntity);
                }
            }

            //Iterates through entities and stores each living entity in a temporary 2D array list
            for (ArrayList<String> row : entities) {
                if (!row.get(2).equals("Dead")) {
                    temp.add(row);
                }
            }

            //Deletes each value in entities and deadEntities, then places data from temp back into entities
            entities.clear();
            entities.addAll(temp);
            deadEntities.clear();
        }
        else {
            System.out.println("All entities have survived this round!");
            System.out.println("____________________________________________________________________");
        }
    }

    /**************************************************
     * The GetEnt method returns the data from entities
     * @return
     * Returns entities
     *************************************************/
    public static ArrayList<ArrayList<String>> GetEnt() {
        return entities;
    }
}
