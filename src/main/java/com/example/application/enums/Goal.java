package com.example.application.enums;

public enum Goal {
    HEALTH_IMPROVEMENT("Health improvement"),
    FAT_LOSS("Fat loss"),
    WEIGHT_LOSS("Weight loss"),
    GAIN_WEIGHT("Gain weight"),
    MUSCLE_MASS_INCREASE("Muscle mass increase"),
    SPORTS_PERFORMANCE_IMPROVEMENT("Sports performance improvement"),
    OTHER("Other");

    private final String displayName;

    Goal(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName; //used in thymeleaf
    }
}
