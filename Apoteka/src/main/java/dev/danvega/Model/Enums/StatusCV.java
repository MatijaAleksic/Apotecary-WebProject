package dev.danvega.Model.Enums;

public enum StatusCV {
    CREATED(0),
    BOOKED(1),
    CANCELED(2),
    FINISHED(3);

    private final int value;

    StatusCV(int value) {
        this.value = value;
    }
    public static StatusCV fromInteger(int x) {
        switch(x) {
            case 0:
                return CREATED;
            case 1:
                return BOOKED;
            case 2:
                return CANCELED;
            case 3:
                return FINISHED;
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
