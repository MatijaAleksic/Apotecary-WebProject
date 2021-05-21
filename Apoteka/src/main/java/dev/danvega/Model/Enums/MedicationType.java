package dev.danvega.Model.Enums;

public enum MedicationType {
    ANTIBIOTIK(0),
    ANESTETIK(1);

    private final int value;

    MedicationType(int value) {
        this.value = value;
    }
    public static MedicationType fromInteger(int x) {
        switch(x) {
            case 0:
                return ANTIBIOTIK;
            case 1:
                return ANESTETIK;
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
