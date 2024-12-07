-- Sample data for clients
INSERT INTO client (email, password, created_at, updated_at)
VALUES ('john.doe@example.com', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('jane.smith@example.com', 'password456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('alice.johnson@example.com', 'password789', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('bob.brown@example.com', 'password101', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for admins
INSERT INTO admin (email, password, created_at, updated_at)
VALUES ('admin1@example.com', 'adminpass1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('admin2@example.com', 'adminpass2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for appointments
INSERT INTO appointment (admin_id, client_id, appointment_start, appointment_end, status, created_at, updated_at)
VALUES (1, 1, '2024-10-30 09:00:00', '2024-10-30 09:30:00', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (1, 2, '2024-10-30 11:00:00', '2024-10-30 11:30:00', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 1, '2024-10-30 10:00:00', '2024-10-30 10:30:00', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 3, '2024-10-31 14:00:00', '2024-10-31 14:30:00', 'CANCELED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for admin_availability
INSERT INTO admin_availability (admin_id, date, start_time, end_time, available, created_at, updated_at)
VALUES (1, '2024-10-30', '09:00', '17:00', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (1, '2024-10-30', '11:00', '13:00', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, '2024-10-31', '10:00', '15:00', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for questionnaire
INSERT INTO questionnaire (user_id, type, status, created_at, updated_at)
VALUES (1, 'INITIAL', 'RECEIVED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'INITIAL', 'RECEIVED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'PROGRESS', 'RECEIVED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for demographic
INSERT INTO demographic (questionnaire_id, full_name, birthday, occupation, gender, created_at, updated_at)
VALUES (1, 'John Doe', '1990-05-15', 'Software Engineer', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'Jane Smith', '1985-08-22', 'Marketing Specialist', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'Alice Johnson', '1992-03-10', 'Graphic Designer', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for anthropometric
INSERT INTO anthropometric (questionnaire_id, height, weight, waist_circumference, recent_measures, created_at,
                            updated_at)
VALUES (1, 180, 75.50, 85, 'Height, weight, waist measurement', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 165, 60.20, 70, 'Height, weight, waist measurement', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 170, 65.00, 72, 'Height, weight, waist measurement', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for dietary_preferences
INSERT INTO dietary_preferences (questionnaire_id, diet_type, avoided_foods, has_allergy_or_intolerance,
                                 allergies_or_intolerances, alcohol_frequency, created_at, updated_at)
VALUES (1, 'BALANCED_DIET', 'None', FALSE, NULL, 'LESS_THAN_ONCE_A_WEEK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'VEGETARIAN', 'Dairy', TRUE, 'Lactose Intolerance', 'ONCE_TO_TWICE_A_WEEK', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       (3, 'KETOGENIC', 'None', FALSE, NULL, 'THREE_TO_FOUR_TIMES_A_WEEK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for health_medical
INSERT INTO health_medical (questionnaire_id, health_condition, dietary_supplements, lack_of_vitamins_or_minerals,
                            created_at, updated_at)
VALUES (1, 'None', 'Multivitamin', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'Asthma', 'Vitamin D', 'Iron deficiency', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'None', 'Fish Oil', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for physical_activity
INSERT INTO physical_activity (questionnaire_id, exercise_frequency, usual_training_time, endurance_frequency,
                               strength_training_frequency, yoga_pilates_frequency, other_activity,
                               other_activity_frequency, created_at, updated_at)
VALUES (1, 'THREE_TO_FOUR_TIMES_A_WEEK', '1 hour', 'ONCE_TO_TWICE_A_WEEK', 'THREE_TO_FOUR_TIMES_A_WEEK',
        'LESS_THAN_ONCE_A_WEEK', 'Swimming', 'ONCE_TO_TWICE_A_WEEK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'ALMOST_EVERY_DAY', '45 minutes', 'THREE_TO_FOUR_TIMES_A_WEEK', 'ALMOST_EVERY_DAY', 'ONCE_TO_TWICE_A_WEEK',
        'Cycling', 'THREE_TO_FOUR_TIMES_A_WEEK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'LESS_THAN_ONCE_A_WEEK', '30 minutes', 'LESS_THAN_ONCE_A_WEEK', 'LESS_THAN_ONCE_A_WEEK',
        'LESS_THAN_ONCE_A_WEEK', 'Running', 'LESS_THAN_ONCE_A_WEEK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for work_meal_schedule
INSERT INTO work_meal_schedule (questionnaire_id, meals_daily, meal_times, working_hours, created_at, updated_at)
VALUES (1, 3, '8 AM, 12 PM, 7 PM', '9 AM - 6 PM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 4, '7 AM, 11 AM, 3 PM, 8 PM', '8 AM - 4 PM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 2, '6 AM, 12 PM', '10 AM - 6 PM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for menstrual_cycle (for female users only)
INSERT INTO menstrual_cycle (questionnaire_id, regular_menstrual_cycle, irregular_cycle_reason,
                             changes_in_appetite_or_weight, description_of_changes, day_of_cycle_when_weighed,
                             created_at, updated_at)
VALUES (2, TRUE, NULL, FALSE, NULL, 12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for nutrition_goals
INSERT INTO nutrition_goals (questionnaire_id, timeframe_to_achieve, created_at, updated_at)
VALUES (1, '3 months', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, '6 months', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, '1 month', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for nutrition_goal
INSERT INTO nutrition_goal (nutrition_goals_id, goal)
VALUES (1, 'HEALTH_IMPROVEMENT'),
       (1, 'WEIGHT_LOSS'),
       (2, 'FAT_LOSS'),
       (3, 'MUSCLE_MASS_INCREASE');
