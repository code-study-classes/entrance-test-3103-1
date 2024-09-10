package entrance.Trip;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private Region region;
    private List<Room> rooms;

    public Hotel(String name, Region region) {
        this.name = name;
        this.region = region;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isFree()) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }
}
