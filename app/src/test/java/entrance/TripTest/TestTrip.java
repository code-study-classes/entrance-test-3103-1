package entrance.TripTest;

import entrance.Trip.Hotel;
import entrance.Trip.Region;
import entrance.Trip.Room;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class TestTrip {
    private Hotel hotel1;
    private Hotel hotel2;

    @BeforeEach
    void setUp() {
        // Создаем регионы
        Region region1 = new Region("Регион 1");
        Region region2 = new Region("Регион 2");

        // Создаем отели
        hotel1 = new Hotel("Отель 1", region1);
        hotel2 = new Hotel("Отель 2", region2);

        // Добавляем номера в отели
        for (int i = 1; i <= 5; i++) {
            hotel1.addRoom(new Room("101" + i, "Стандарт"));
            hotel1.addRoom(new Room("102" + i, "Люкс"));
        }

        for (int i = 1; i <= 5; i++) {
            hotel2.addRoom(new Room("201" + i, "Апартаменты"));
            hotel2.addRoom(new Room("202" + i, "Стандарт"));
        }
    }

    @org.junit.jupiter.api.Test
    void testChangeStatus() {
        // Проверяем начальный статус первого номера
        Room room = hotel1.getFreeRooms().get(0);
        assertEquals("свободен", room.getStatus(), "Начальный статус должен быть 'свободен'");

        // Меняем статус
        room.changeStatus();
        assertEquals("занят", room.getStatus(), "Статус должен измениться на 'занят'");

        // Меняем статус обратно
        room.changeStatus();
        assertEquals("свободен", room.getStatus(), "Статус должен измениться обратно на 'свободен'");
    }

    @org.junit.jupiter.api.Test
    void testGetFreeRooms() {
        // Проверяем начальное количество свободных номеров
        List<Room> freeRooms = hotel1.getFreeRooms();
        assertEquals(10, freeRooms.size(), "В отеле должно быть 10 свободных номеров");

        // Занимаем один номер и проверяем снова
        Room room = freeRooms.get(0);
        room.changeStatus();
        freeRooms = hotel1.getFreeRooms();
        assertEquals(9, freeRooms.size(), "В отеле должно остаться 9 свободных номеров");

        // Занимаем еще один номер
        room = freeRooms.get(0);
        room.changeStatus();
        freeRooms = hotel1.getFreeRooms();
        assertEquals(8, freeRooms.size(), "В отеле должно остаться 8 свободных номеров");
    }
}
