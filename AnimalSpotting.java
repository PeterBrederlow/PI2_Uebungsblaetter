package info2;
//Ulrike Hunfeld, Peter Brederlow

public class AnimalSpotting {

    // ----------------------------------------------------------------
    // Exercise 1 (b)
    // ----------------------------------------------------------------
    // TODO: Implement generateRandomZoo
    public static Animal[] generateRandomZoo(int n) {
        Animal[] animals = new Animal[n];
        for (int i = 0; i < n; i++) {
            int r = RandomTools.randomValue(Animal.values().length);
            animals[i] = Animal.values()[r];
        }
        return animals;
    }

    // ----------------------------------------------------------------
    // Exercise 1 (c)
    // ----------------------------------------------------------------
    // TODO: Implement showZoo
    public static String showZoo(Animal[] animals) {
        String zoo = "";
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                zoo += "";
            } else {
                zoo += animals[i];
                zoo += " \n";
            }
        }
        return zoo;
    }


    // ----------------------------------------------------------------
    // Exercise 1 (d)
    // ----------------------------------------------------------------

    // TODO: Implement countAnimals
    public static int[] countAnimals(Animal[] animals) {
        int[] count = new int[Animal.values().length];

        //iterate through animals and add 1 at the index of an animal every time the respective animal appears
        for (int i = 0; i < animals.length; i++) {
            switch (animals[i]) {
                case ELEPHANT -> count[Animal.ELEPHANT.ordinal()]++;
                case EMU -> count[Animal.EMU.ordinal()]++;
                case LION -> count[Animal.LION.ordinal()]++;
                case SNAKE -> count[Animal.SNAKE.ordinal()]++;
                case WASP -> count[Animal.WASP.ordinal()]++;
                case MONKEY -> count[Animal.MONKEY.ordinal()]++;
                case TIGER -> count[Animal.TIGER.ordinal()]++;
            }
        }
        return count;
    }


    // ----------------------------------------------------------------
    // Exercise 1 (e)
    // ----------------------------------------------------------------

    // TODO: Implement mostFrequentAnimal
    public static Animal mostFrequentAnimal(Animal[] animals) {
        if (animals == null) return null;

        int[] countAnimals = countAnimals(animals); //is it better to save once than to compute new in every iteration?

        //find the max in countAnimals and save the respective index
        int max = -1;
        int index = -1;
        for (int i = countAnimals.length - 1; i >= 0; i--) {
            if (Math.max(max, countAnimals[i]) == countAnimals[i]) {
                index = i;
            }
            max = Math.max(countAnimals[i], max);
        }

        //find out which animal belongs to index and return it
        switch (index) {
            case 0: return Animal.ELEPHANT;
            case 1: return Animal.LION;
            case 2: return Animal.TIGER;
            case 3: return Animal.WASP;
            case 4: return Animal.SNAKE;
            case 5: return Animal.MONKEY;
            case 6: return Animal.EMU;
            default: return null;
        }
    }

    // ----------------------------------------------------------------
    // Exercise 1 (f)
    // ----------------------------------------------------------------

    // TODO: Implement calculateBiomass
    public static double calculateBiomass(Animal[] animals) {
        double mass = 0;
        for (Animal animal : animals) {
            switch (animal) {
                case ELEPHANT -> mass += 5000;
                case LION -> mass += 150;
                case TIGER -> mass += 200;
                case WASP -> mass += 6e-5;
                case SNAKE -> mass += 35;
                case MONKEY -> mass += 160;
                case EMU -> mass += 40;
                case null -> mass += 0;
            }
        }
        return mass;
    }

    // ----------------------------------------------------------------

    public static void main(String[] args) {

        Animal[] zoo = generateRandomZoo(100);

        String zooString = showZoo(zoo);
        System.out.println(zooString);

        System.out.println();

        int[] counting = countAnimals(zoo);
        System.out.println(ArrayTools.asString(counting));
        System.out.println();

        System.out.println(mostFrequentAnimal(zoo));

        System.out.println();

        System.out.println(calculateBiomass(zoo));
    }

}
