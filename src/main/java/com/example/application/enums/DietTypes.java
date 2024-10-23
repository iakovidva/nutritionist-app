package com.example.application.enums;

public enum DietTypes {
    BALANCED_DIET("Balanced diet"),
    VEGETARIAN("Vegetarian"),
    VEGAN("Vegan"),
    PALEO("Paleo"),
    KETOGENIC("Ketogenic"),
    GLUTEN_FREE("Gluten free"),
    OTHER("Other");

    private final String displayName;

    DietTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName; //used in thymeleaf
    }
}