package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TruckPassingBridge {

    /**
     * 1. Queue를 이용한다.
     * 2. Truck이라는 클래스를 만든다.
     *  * truck_weight
     *  * 지나온 길이 (1초당 1씩)
     *  * 현재 시간을 받아 다리 건너는 것을 완료했는 지의 여부
     * 3. 그 외 필요 변수 -> 이것조 Bridge Class 만들자.
     *  * 현재 다리의 weight
     *  * 현재 시간 (초)
     *  * 다리가 버틸 수 있는 weight (주어짐)
     * @param bridge_length
     * @param weight
     * @param truck_weights
     * @return
     */
    public int solution1(int bridge_length, int weight, int[] truck_weights) {
        List<Truck> truckList = new ArrayList<>();
        List<Truck> passedTruckList = new ArrayList<>();

        for(int truck_weight : truck_weights) {
            truckList.add(new Truck(truck_weight));
        }

        Queue<Truck> passingTrucks = new LinkedList<>();
        int second = 0;
        int weightPassingBridge = 0;       // 현재 다리 위에 올라온 Truck의 무게

        for(int i = 0; i <= truckList.size() && truckList.size() > passedTruckList.size();) {
            second++;

            if(weightPassingBridge + truckList.get(i).getTruck_weight() <= weight) {
                passingTrucks.add(truckList.get(i));
                weightPassingBridge += truckList.get(i).getTruck_weight();

                if(i + 1 < truckList.size()) {
                    i++;
                }
            }

            for(Truck passingTruck : passingTrucks) {
                passingTruck.go();
            }

            if(passingTrucks.peek().isPassed(bridge_length)) {
                Truck passedTruck = passingTrucks.poll();
                passedTruckList.add(passedTruck);
                weightPassingBridge -= passedTruck.getTruck_weight();
            }
        }

        return second + 1;
    }

    public class Truck {
        private int truck_weight;   // 트럭의 무게
        private int passingLength;  // 지나간 길이 (1초의 1씩)

        public Truck(int truck_weight) {
            this.truck_weight = truck_weight;
            this.passingLength = 0;
        }

        public int getTruck_weight() {
            return truck_weight;
        }

        public void go() {
            this.passingLength++;
        }

        /**
         * 다리의 길이를 받아, 본 Truck이 다리를 모두 지나왔는지 확인한다.
         * @param bridge_length
         * @return
         */
        public boolean isPassed(int bridge_length) {
            return bridge_length == passingLength;
        }
    }
}
