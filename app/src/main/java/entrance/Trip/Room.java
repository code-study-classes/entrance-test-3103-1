package entrance.Trip;

public class Room {
    private String number;
    private String category;
    private String status;
    private int capacity;

    public Room(String number, String category) {
        this.number = number;
        this.category = category;
        this.status = "свободен";
        this.capacity = setCapacity(category);
    }

    private int setCapacity(String category) {
        switch (category) {
            case "Стандарт":
            case "Люкс":
                return 2;
            case "Апартаменты":
                return 4;
            default:
                throw new IllegalArgumentException("Недопустимая категория номера");
        }
    }

    public void changeStatus() {
        if (status.equals("свободен")) {
            status = "занят";
        } else {
            status = "свободен";
        }
    }

    public String getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFree() {
        return status.equals("свободен");
    }

    @Override
    public String toString() {
        return number + " (" + category + ", " + status + ")";
    }
}