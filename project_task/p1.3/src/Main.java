//------------Task 1-------------
/*
First, determining the probability distribution of ages based on the real data and convert these percentages into a cumulative distribution, where each age corresponds to a range between 1 and 100. After that, I would generate random numbers between 0 and 1 and check which interval each random number falls into.The interval would determine the age assigned to that number.
 */
//------------Task 2-------------
class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 25;

        int agedistribution[][] = {
                {10, 20},
                {50, 21},
                {80, 22},
                {95, 23},
                {100,MAXAGE},
        };

        int generatedAges[] = new int[MAXAGE+1];

        // Generate ages according to the distribution:
        for (int i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random()*100)+1;
            int j = 0;
            while (x > agedistribution[j][0]) j++;
            generatedAges[agedistribution[j][1]]++;
        }

        // Output the result of the generation:
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
    }
}
//------------Task 3-------------
/*
Because the constructor of the class is declared private. Making the constructor private prevents other classes from instantiating new objects directly.
 */
//------------Task 4-------------
/*
The normal distribution appears in real life with heights or exam scores, the exponential distribution models waiting times like customers arriving, the uniform distribution is used when all outcomes are equally likely, and the Poisson distribution models counts of events in a fixed time, like cars passing a toll booth.
 */
//------------Task 5-------------
class Clock {
    private static Clock instance;
    private double time;

    private Clock() {
        this.time = 0.0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(double newTime) {
        this.time = newTime;
    }

    public double getTime() {
        return this.time;
    }

    public static void main(String[] args) {
        Clock.getInstance().setTime(0.5);
        System.out.println("Time is " + Clock.getInstance().getTime());
    }
}
//------------Task 6-------------