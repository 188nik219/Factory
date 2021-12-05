import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static ArrayList<String> dump = new ArrayList<String>();
    static ArrayList<String> newRobot = new ArrayList<String>();
    static String[] fullRobot = {"Head", "Body", "left hand", "Right hand", "left foot", "Right foot", "CPU", "RAM", "HDD"};
    static ArrayList<String> Robot = new ArrayList<String>(List.of(fullRobot));
    static int number=0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int random2 = (int) (Math.random()*9);
            dump.add(fullRobot[random2]);
        }
        Fabric fabric = new Fabric();
        Worker worker = new Worker();
        Master master = new Master();
        for (int i = 0; i < 50; i++) {
            fabric.run();
            worker.run();
            master.run();
            Thread.sleep(100);
        };
        System.out.println(number);
        System.out.println(newRobot);
    }
}
class Fabric implements Runnable{
    @Override
    public void run() {
        int random1 = (int) (Math.random()*4);
        for (int i = 0; i < random1; i++) {
            int random2 = (int) (Math.random()*9);
            Main.dump.add(Main.fullRobot[random2]);
        }
    }
}
class Worker implements Runnable{
    @Override
    public void run() {
        if (Main.dump.size()<4){
            for (int i = 0; i < Main.dump.size(); i++) {
                Main.newRobot.add(Main.dump.get(0));
                Main.dump.remove(0);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                Main.newRobot.add(Main.dump.get(0));
                Main.dump.remove(0);
            }
        }
    }
}
class Master implements Runnable{

    @Override
    public void run() {
        while (Main.newRobot.containsAll(Main.Robot)){
            Main.newRobot.remove("Head");
            Main.newRobot.remove("Body");
            Main.newRobot.remove("left hand");
            Main.newRobot.remove("Right hand");
            Main.newRobot.remove("left foot");
            Main.newRobot.remove("Right foot");
            Main.newRobot.remove("CPU");
            Main.newRobot.remove("RAM");
            Main.newRobot.remove("HDD");
            Main.number++;
        }
    }
}
