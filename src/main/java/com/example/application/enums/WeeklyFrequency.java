package com.example.application.enums;

public enum WeeklyFrequency {
    LESS_THAN_ONCE_A_WEEK("< 1 a week"),
    ONCE_TO_TWICE_A_WEEK("1-2 a week"),
    THREE_TO_FOUR_TIMES_A_WEEK("3-4 a week"),
    ALMOST_EVERY_DAY("Almost every day");

    private final String displayName;

    WeeklyFrequency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName; //used in thymeleaf
    }
}