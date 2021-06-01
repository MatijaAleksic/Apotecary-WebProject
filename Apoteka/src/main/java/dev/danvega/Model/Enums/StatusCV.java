package dev.danvega.Model.Enums;

public enum StatusCV {
    PENDING(0),
    ACCEPTED(1),
    DECLINED(2);

    private final int value;

    StatusCV(int value) {
        this.value = value;
    }

    public static StatusCV fromInteger(int x) {
        switch(x) {
            case 0:
                return PENDING;
            case 1:
                return ACCEPTED;
            case 2:
                return DECLINED;
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
