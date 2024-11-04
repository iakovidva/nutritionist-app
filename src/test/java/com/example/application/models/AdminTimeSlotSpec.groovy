package com.example.application.models

import java.time.LocalDate
import java.time.LocalTime
import spock.lang.Specification

class AdminTimeSlotSpec extends Specification {

  def "overlapsWith should detect overlapping times correctly"() {
    given: "Two time slots"
    LocalDate date = LocalDate.of(2024, 1, 1);
    var slot1 = new AdminTimeSlot(null, date, start1, end1, available1)
    var slot2 = new AdminTimeSlot(null, date, start2, end2, available2)

    expect: "overlapsWith returns the expected result"
    slot1.overlapsWith(slot2) == expected

    where:
    start1              | end1                | available1 | start2               | end2                | available2 | expected
    LocalTime.of(9, 0)  | LocalTime.of(10, 0) | true       | LocalTime.of(9, 0)   | LocalTime.of(10, 0) | true       | true     // Exact match
    LocalTime.of(9, 0)  | LocalTime.of(11, 0) | true       | LocalTime.of(10, 0)  | LocalTime.of(12, 0) | true       | true     // Overlapping start
    LocalTime.of(10, 0) | LocalTime.of(12, 0) | true       | LocalTime.of(9, 0)   | LocalTime.of(11, 0) | true       | true     // Overlapping end
    LocalTime.of(9, 0)  | LocalTime.of(12, 0) | true       | LocalTime.of(10, 0)  | LocalTime.of(11, 0) | true       | true     // Contained within
    LocalTime.of(9, 0)  | LocalTime.of(11, 0) | true       | LocalTime.of(10, 30) | LocalTime.of(12, 0) | true       | true     // Partial overlap
    LocalTime.of(9, 0)  | LocalTime.of(10, 0) | true       | LocalTime.of(10, 0)  | LocalTime.of(11, 0) | true       | false    // Non-overlapping
    LocalTime.of(9, 0)  | LocalTime.of(10, 0) | true       | LocalTime.of(8, 0)   | LocalTime.of(9, 0)  | true       | false    // Non-overlapping
    LocalTime.of(9, 0)  | LocalTime.of(11, 0) | true       | LocalTime.of(9, 0)   | LocalTime.of(11, 0) | false      | false    // Different availability
  }
}