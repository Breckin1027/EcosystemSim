import java.util.ArrayList;

/*************************************************************************
 * Plant Subclass inherits Entity and holds the behaviors of Plant Objects
 ************************************************************************/
public class Plant extends Entity{

    /*****************************************************************
     * The Grow method increases the growth_stage and nutrients values
     * by 1 and 3 respectfully
     * @param ent
     * The current entity
     ****************************************************************/
    public static void Grow(ArrayList<String> ent) {

        //The modification array list for the Plant
        ArrayList<String> plantMods = new ArrayList<>();

        int new_growth_stage = Integer.parseInt(ent.get(3)) + 1;
        int new_nutrients = Integer.parseInt(ent.get(4)) + 3;

        System.out.println(ent.get(0) + " grew another year older!\n");

        plantMods.add(ent.get(0));
        plantMods.add(ent.get(1));
        plantMods.add(ent.get(2));
        plantMods.add(Integer.toString(new_growth_stage));
        plantMods.add(Integer.toString(new_nutrients));

        Ecosystem.UpdateState(plantMods, ent);
    }

    /**********************************************************************
     * The ProvideNutrients method calculates how many nutrients to provide
     * a random entity within entities, which decreases the Plant Object's
     * nutrients and increases the entity's energy or nutrients by the same
     * random amount.
     * @param ent
     * The current entity
     * @param luckyEnt
     * The entity the Plant gave nutrients to
     *********************************************************************/
    public static void ProvideNutrients(ArrayList<String> ent, ArrayList<String> luckyEnt) {
        ArrayList<String> plantMods = new ArrayList<>();

        //The modification array list for the randomly chosen entity
        ArrayList<String> luckyMods = new ArrayList<>();

        int generosity = (int) (Math.random() * 3) + 1;
        int new_nutrients = Integer.parseInt(ent.get(4));
        int new_energy = Integer.parseInt(luckyEnt.get(4));

        //Calculates number of nutrients the Plant gives, making sure the Plant can't have negative nutrients
        if (new_nutrients > generosity) {
            System.out.println(ent.get(0) + " provided " + generosity + " nutrients to " + luckyEnt.get(0) + "!\n");
            new_nutrients -= generosity;
            new_energy += generosity;
        }
        else if (new_nutrients > 0) {
            System.out.println(ent.get(0) + " could only provide " + generosity + " nutrients to " + luckyEnt.get(0) + ".\n");
            new_energy += new_nutrients;
            new_nutrients = 0;
        }
        else {
            System.out.println(ent.get(0) + " doesn't have any nutrients to provide.\n");
        }

        plantMods.add(ent.get(0));
        plantMods.add(ent.get(1));
        plantMods.add(ent.get(2));
        plantMods.add(ent.get(3));
        plantMods.add(Integer.toString(new_nutrients));

        luckyMods.add(luckyEnt.get(0));
        luckyMods.add(luckyEnt.get(1));
        luckyMods.add(luckyEnt.get(2));
        luckyMods.add(luckyEnt.get(3));
        luckyMods.add(Integer.toString(new_energy));

        //Adds the value if the entity is an Animal
        if (luckyEnt.get(2).equals("Animal")) {
            luckyMods.add(luckyEnt.get(5));
        }

        Ecosystem.UpdateState(plantMods, ent);
        Ecosystem.UpdateState(luckyMods, luckyEnt);
    }
}
