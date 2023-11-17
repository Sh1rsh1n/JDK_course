package gitnub.sh1rsh1n;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import main.java.gitnub.sh1rsh1n.entitys.BoxBroker;

public class App {

    private static void test(BoxBroker broker){

        Map<Integer, Boolean> map = new HashMap<>();
        int trueTest = 0;

        for (int index = 0; index < 10; index++) {
            boolean value = broker.start();
            if (value) {
                trueTest++;
            }
            map.put(index, value);
        }

        System.out.println((float) trueTest / map.size() * 10000 / 100);
    }

    public static void main(String[] args) {
        BoxBroker broker = new BoxBroker();
        test(broker);
    }
}
