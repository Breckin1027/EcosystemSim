import java.util.ArrayList;

/***************************************************************************
 * Animal Subclass inherits Entity and holds the behaviors of Animal Objects
 **************************************************************************/
public class Animal extends Entity {

    /****************************************************************************
     * The Move method randomly picks how much the Animal moves, which determines
     * how much their hunger goes up and energy goes down
     * @param ent
     * The current entity
     ***************************************************************************/
    public static void Move(ArrayList<String> ent) {

        //The modification array list for the Animal
        ArrayList<String> mods = new ArrayList<>();

        int motion = (int) (Math.random() * 3) + 1;
        int new_hunger = Integer.parseInt(ent.get(5)) + motion;
        int new_energy = Integer.parseInt(ent.get(4)) - motion;

        System.out.println(ent.get(0) + " moved " + motion + " times.\n");

        mods.add(ent.get(0));
        mods.add(ent.get(1));
        mods.add(ent.get(2));
        mods.add(ent.get(3));
        mods.add(Integer.toString(new_energy));
        mods.add(Integer.toString(new_hunger));

        Ecosystem.UpdateState(mods, ent);
    }

    /*********************************************************************************
     * The Eat method decreases hunger and increases energy values by 3 for the Animal
     * @param ent
     * The current entity
     * @param deadEnt
     * The entity the Animal killed
     ********************************************************************************/
    public static void Eat(ArrayList<String> ent, ArrayList<String> deadEnt) {
        ArrayList<String> mods = new ArrayList<>();
        String ChosenOnesName = deadEnt.get(0);
        int new_hunger = Integer.parseInt(ent.get(5)) - 3;
        int new_energy = Integer.parseInt(ent.get(4)) + 3;

        System.out.println(ent.get(0) + " ate " + ChosenOnesName + "\n");

        if (new_hunger <= 0) {
            new_hunger = 0;
        }

        mods.add(ent.get(0));
        mods.add(ent.get(1));
        mods.add(ent.get(2));
        mods.add(ent.get(3));
        mods.add(Integer.toString(new_energy));
        mods.add(Integer.toString(new_hunger));

        Ecosystem.UpdateState(mods, ent);
    }

    /************************************************************
     * The Age method increases the age value for the Animal by 1
     * @param ent
     * The current entity
     ***********************************************************/
    public static void Age(ArrayList<String> ent) {
        ArrayList<String> mods = new ArrayList<>();
        int new_age = Integer.parseInt(ent.get(3)) + 1;

        System.out.println(ent.get(0) + " grew a year older!\n");

        mods.add(ent.get(0));
        mods.add(ent.get(1));
        mods.add(ent.get(2));
        mods.add(Integer.toString(new_age));
        mods.add(ent.get(4));
        mods.add(ent.get(5));

        Ecosystem.UpdateState(mods, ent);
    }
}
