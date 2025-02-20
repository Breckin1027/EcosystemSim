import java.util.ArrayList;

/*******************************************************************
 * Entity is an abstract class that is inherited by Animal and Plant
 ******************************************************************/
public abstract class Entity {

    /******************************************************************************
     * The Interact method defines how each Animal and Plant object should interact
     * with the other Objects within entities
     * @param row
     * row is the current entity's data within an array list
     * @return
     * This method returns the entity that is killed or null if no entity is killed
     * during the current cycle
     *****************************************************************************/
    public static ArrayList<String> Interact(ArrayList<String> row) {

        //Retrieves entities from the Ecosystem Class
        ArrayList<ArrayList<String>> ents = Ecosystem.GetEnt();

        //Randomly picks an entity from entities
        int randomEnt = (int) (Math.random() * ents.size());
        ArrayList<String> TheChosenOne = ents.get(randomEnt);

        if (row.get(2).equals("Animal")) {

            //Error checking to make sure the entity can't eat itself
            if (row == TheChosenOne) {
                System.out.println(row.get(0) + " tried to eat themself, but luckily figured out that was a bad idea.\n");
                return null;
            }

            //Ensures the entity can eat the correct entity type
            if (row.get(1).equals("Carnivore")) {
                if (TheChosenOne.get(2).equals("Animal")) {
                    Animal.Eat(row, ents.get(randomEnt));
                    return TheChosenOne;
                }
                else {
                    System.out.println(row.get(0) + " tried to eat " + TheChosenOne.get(0) + " but " + TheChosenOne.get(0) + " is not an animal\n");
                }
            }
            else {
                if (TheChosenOne.get(2).equals("Plant")) {
                    Animal.Eat(row, ents.get(randomEnt));
                    return TheChosenOne;
                }
                else {
                    System.out.println(row.get(0) + " tried to eat " + TheChosenOne.get(0) + " but " + row.get(0) + " is a pacifist\n");
                }
            }
        }

        //Provides nutrients to the randomly chosen entity
        else if (row.get(2).equals("Plant")) {
            if (row == TheChosenOne) {
                System.out.println(row.get(0) + " tried to give themself more nutrients, but couldn't figure out how to.\n");
                return null;
            }
            else if (TheChosenOne.get(2).equals("Dead")) {
                System.out.println(row.get(0) + " tried to give a dead entity nutrients.\n");
                return null;
            }

            if (Integer.parseInt(row.get(3)) >= 5) {
                return row;
            }

            Plant.ProvideNutrients(row, TheChosenOne);

        }

        //Return null if an entity isn't eaten
        return null;
    }
}
