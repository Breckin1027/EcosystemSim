import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("____________________________________________________________________");
            System.out.println("Ecosystem Builder");
            System.out.println("1. Add Entity");
            System.out.println("2. Remove Entity");
            System.out.println("3. Use Preset Entity List");
            System.out.println("4. List Entities");
            System.out.println("5. Start Simulation");
            System.out.println("6. Exit");

            System.out.println("\nChoose an input (1, 2, 3, 4, 5, 6): ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.println("____________________________________________________________________");
                System.out.println("Would you like to create a plant or an animal? (p/a): ");
                String p_a = sc.nextLine();

                if (p_a.equalsIgnoreCase("a")) {
                    p_a = "Animal";
                    System.out.println("What's the name of the animal? ");
                    String name = sc.nextLine();

                    System.out.println("Is " + name + " a carnivore or an herbivore? (c/h): ");
                    String eater = sc.nextLine();

                    if (eater.equalsIgnoreCase("c")) {
                        eater = "Carnivore";
                    }
                    else if (eater.equalsIgnoreCase("h")) {
                        eater = "Herbivore";
                    }
                    else {
                        System.out.println("**Invalid input. Returning back to main menu**");
                        continue;
                    }

                    Ecosystem.AddAnimal(name, eater, p_a);
                }
                else if (p_a.equalsIgnoreCase("p")) {
                    p_a = "Plant";
                    String eater = "Sunlight";
                    System.out.println("What's the name of the plant? ");
                    String name = sc.nextLine();
                    Ecosystem.AddPlant(name, eater, p_a);
                }
                else {
                    System.out.println("**Invalid input. Returning back to main menu**\n");
                }
            }

            else if (choice.equals("2")) {
                System.out.println("____________________________________________________________________");
                System.out.println("Please choose which entity you wish to delete (Use numeric values): ");
                String delete = sc.nextLine();
                try {
                    int position = Integer.parseInt(delete) - 1;
                    Ecosystem.Remove(position);
                }
                catch (Exception e) {
                    System.out.println("**Invalid input. Returning back to main menu**\n");
                }
            }
            else if (choice.equals("3")) {
                System.out.println("____________________________________________________________________");
                System.out.println("You now have a preset list. \n");
                Ecosystem.PresetList();
            }
            else if (choice.equals("4")) {
                System.out.println("____________________________________________________________________");
                System.out.println("Listing all entities: ");
                Ecosystem.ListAll();
            }
            else if (choice.equals("5")) {
                System.out.println("____________________________________________________________________");
                System.out.println("Starting the simulation round!\n");
                Ecosystem.StartSimulation();
            }
            else if (choice.equals("6")) {
                System.out.println("____________________________________________________________________");
                System.out.println("Thanks for playing!\n");
                System.exit(0);
            }
            else {
                System.out.println("____________________________________________________________________");
                System.out.println("**Invalid input. Returning back to main menu**\n");
            }
        }
    }
}

/*
Entity value key:
Animal | 0: Name, 1: Eater, 2: P_A (Plant or Animal), 3: Age, 4: Energy, 5: Hunger
Plant  | 0: Name, 1: Eater, 2: P_A (Plant or Animal), 3: Growth_Stage, 4: Nutrients
*/