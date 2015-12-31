package HelpSuperman;

import java.util.*;

/**
 * Created by nilajapatankar on 3/12/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String[] inputArray1 = line1.split(" ");
        int countOfBuildings = Integer.parseInt(inputArray1[0]);
        int buildingHeight = Integer.parseInt(inputArray1[1]);
        int lossInHeight = Integer.parseInt(inputArray1[2]);
        List<Building> buildings = new ArrayList<Building>();
        for (int i = 0; i < countOfBuildings; i++) {
            String line = sc.nextLine();
            String[] buildingInput = line.split(" ");
            Building building = new Building(i + 1);
            int peopleInThisBuilding = Integer.parseInt(buildingInput[0]);
            for (int j = 0; j < peopleInThisBuilding; j++) {
                building.AddPerson(Integer.parseInt(buildingInput[j + 1]));
            }
            building.GroupPeople();
            buildings.add(building);
        }
        SupermanHelper helper = new SupermanHelper(buildings, buildingHeight, lossInHeight);
        int countOfPeopleSaved = helper.CalculateHighestCountOfPeopleToSave();
        System.out.println(countOfPeopleSaved);
    }

    static class Building {
        private int buildingId;
        private HashMap<Integer, Integer> peopleOnFloor;
        private HashMap<Integer, Integer> groupedPeople;

        public Building(int id) {
            buildingId = id;
            peopleOnFloor = new HashMap<Integer, Integer>();
            groupedPeople = new HashMap<Integer,Integer>();
        }

        public void AddPerson(int floorNumber) {
            int currentCount = peopleOnFloor.get(floorNumber);
            peopleOnFloor.remove(floorNumber);
            peopleOnFloor.put(floorNumber, ++currentCount);
        }

        public int GetCountOfPeople() {
            Collection<Integer> people = peopleOnFloor.values();
            int totalCount = 0;
            for (Integer floorPeople : people) {
                totalCount += floorPeople;
            }
            return totalCount;
        }

        public int GetHighestFloorOnWhichPersonIsStuck() {
            Collection<Integer> floors = peopleOnFloor.keySet();
            int highestFloor = 0;
            for (Integer floor : floors) {
                if (floor > highestFloor)
                    highestFloor = floor;
            }
            return highestFloor;
        }

        public int GetId() {
            return buildingId;
        }

        public void GroupPeople() {
            List<Integer> floorsAlreadyGrouped = new ArrayList<Integer>();
            for (Integer floor : peopleOnFloor.keySet()) {
                if (!floorsAlreadyGrouped.contains(floor)) {
                    int countOfPeopleInGroup = 0;
                    int highestFloorForGroup = 0;
                    while (true)
                    {
                        countOfPeopleInGroup += peopleOnFloor.get(floor);
                    }
                }
            }
        }
    }

    static class SupermanHelper {
        private List<Building> buildings;
        private int buildingHeight;
        private int lossInHeight;

        public SupermanHelper(List<Building> buildings, int buildingHeight, int lossInHeight) {
            this.buildings = buildings;
            this.buildingHeight = buildingHeight;
            this.lossInHeight = lossInHeight;
        }

        public int CalculateHighestCountOfPeopleToSave() {
            int highestPopulationBuilding = 0;
            int highestPopulationBuildingId = 0;
            for (Building building : buildings) {
                int countOfPeopleInCurrentBuilding = building.GetCountOfPeople();
                if (highestPopulationBuilding < countOfPeopleInCurrentBuilding) {
                    highestPopulationBuildingId = building.GetId();
                    highestPopulationBuilding = countOfPeopleInCurrentBuilding;
                }
            }

            return 0;
        }
    }
}
