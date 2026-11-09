package zad15;

public class Main {
    public static void main(String[] args) {
        Smoker[] smokers = new Smoker[3];
        Agent agent = new Agent(smokers);

        smokers[0] = new Smoker(0, Items.PAPER, agent);
        smokers[1] = new Smoker(1, Items.TOBACCO, agent);
        smokers[2] = new Smoker(2, Items.MATCHES, agent);

        Thread nitAgenta = new Thread(agent);
        Thread[] nitiPusaca = new Thread[3];

        for (int i = 0; i < smokers.length; i++) {
            nitiPusaca[i] = new Thread(smokers[i]);
            nitiPusaca[i].start();
        }

        nitAgenta.start();
    }
}