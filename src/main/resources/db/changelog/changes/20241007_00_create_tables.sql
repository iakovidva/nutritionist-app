-- Creating Enums
DROP TYPE IF EXISTS APPOINTMENT_STATUS, GENDER_ENUM, DIET_TYPE, WEEKLY_FREQUENCY, GOAL;

CREATE TYPE QUESTIONNAIRE_STATUS AS ENUM ('RECEIVED', 'VIEWED', 'COMPLETED');
CREATE TYPE QUESTIONNAIRE_TYPE AS ENUM ('INITIAL', 'PROGRESS');
CREATE TYPE APPOINTMENT_STATUS AS ENUM ('SCHEDULED', 'CANCELED', 'COMPLETED', 'PENDING');
CREATE TYPE GENDER_ENUM AS ENUM ('MALE', 'FEMALE', 'OTHER');
CREATE TYPE DIET_TYPE AS ENUM ('BALANCED_DIET', 'VEGETARIAN', 'VEGAN', 'PALEO', 'KETOGENIC', 'GLUTEN_FREE', 'OTHER');
CREATE TYPE WEEKLY_FREQUENCY AS ENUM ('LESS_THAN_ONCE_A_WEEK', 'ONCE_TO_TWICE_A_WEEK', 'THREE_TO_FOUR_TIMES_A_WEEK', 'ALMOST_EVERY_DAY');
CREATE TYPE GOAL AS ENUM ('HEALTH_IMPROVEMENT', 'FAT_LOSS', 'WEIGHT_LOSS', 'GAIN_WEIGHT', 'MUSCLE_MASS_INCREASE', 'SPORTS_PERFORMANCE_IMPROVEMENT', 'OTHER');

-- Creating DB tables

DROP TABLE IF EXISTS client;
CREATE TABLE client
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT client_email_unique UNIQUE (email)
);

DROP TABLE IF EXISTS admin;
CREATE TABLE admin
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT admin_email_unique UNIQUE (email)
);

DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment
(
    id                BIGSERIAL PRIMARY KEY,
    admin_id          BIGINT             NULL,
    client_id         BIGINT             NULL,
    appointment_start TIMESTAMP          NOT NULL,
    appointment_end   TIMESTAMP          NOT NULL,
    status            APPOINTMENT_STATUS NOT NULL DEFAULT 'PENDING',
    created_at        TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_appointment_admin FOREIGN KEY (admin_id) REFERENCES admin (id) ON DELETE SET NULL,
    CONSTRAINT fk_appointment_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE SET NULL
);

DROP TABLE IF EXISTS admin_availability;
CREATE TABLE admin_availability
(
    id         BIGSERIAL PRIMARY KEY,
    admin_id   BIGINT    NULL,
    date       DATE      NOT NULL,
    start_time TIME      NOT NULL,
    end_time   TIME      NOT NULL,
    available  BOOLEAN   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_admin_admin_availability FOREIGN KEY (admin_id) REFERENCES admin (id) ON DELETE SET NULL
);

-- Questionnaire

DROP TABLE IF EXISTS questionnaire;
CREATE TABLE questionnaire
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT               NULL,
    type       QUESTIONNAIRE_TYPE   NOT NULL,
    status     QUESTIONNAIRE_STATUS NOT NULL,
    created_at TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_questionnaire_user FOREIGN KEY (user_id) REFERENCES client (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS demographic;
CREATE TABLE demographic
(
    id               BIGSERIAL PRIMARY KEY,
    questionnaire_id BIGINT       NOT NULL,
    full_name        VARCHAR(255) NOT NULL,
    birthday         DATE         NOT NULL,
    occupation       VARCHAR(255) NULL,
    gender           GENDER_ENUM  NOT NULL,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_demographic_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS anthropometric;
CREATE TABLE anthropometric
(
    id                  BIGSERIAL PRIMARY KEY,
    questionnaire_id    BIGINT        NOT NULL,
    height              INT           NOT NULL,
    weight              NUMERIC(6, 2) NOT NULL,
    waist_circumference INT           NULL,
    recent_measures     VARCHAR(255)  NULL,
    created_at          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_anthropometric_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS dietary_preferences;
CREATE TABLE dietary_preferences
(
    id                         BIGSERIAL PRIMARY KEY,
    questionnaire_id           BIGINT           NOT NULL,
    diet_type                  DIET_TYPE        NOT NULL,
    avoided_foods              VARCHAR(255)     NULL,
    has_allergy_or_intolerance BOOLEAN          NOT NULL,
    allergies_or_intolerances  VARCHAR(255)     NULL,
    alcohol_frequency          WEEKLY_FREQUENCY NOT NULL,
    created_at                 TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                 TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_dietary_preferences_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS health_medical;
CREATE TABLE health_medical
(
    id                           BIGSERIAL PRIMARY KEY,
    questionnaire_id             BIGINT       NOT NULL,
    health_condition             VARCHAR(255) NULL,
    dietary_supplements          VARCHAR(255) NULL,
    lack_of_vitamins_or_minerals VARCHAR(255) NULL,
    created_at                   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_health_medical_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS physical_activity;
CREATE TABLE physical_activity
(
    id                          BIGSERIAL PRIMARY KEY,
    questionnaire_id            BIGINT           NOT NULL,
    exercise_frequency          WEEKLY_FREQUENCY NOT NULL,
    usual_training_time         VARCHAR(255)     NULL,
    endurance_frequency         WEEKLY_FREQUENCY NULL,
    strength_training_frequency WEEKLY_FREQUENCY NULL,
    yoga_pilates_frequency      WEEKLY_FREQUENCY NULL,
    other_activity              VARCHAR(255)     NULL,
    other_activity_frequency    WEEKLY_FREQUENCY NULL,
    created_at                  TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                  TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_physical_activity_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS work_meal_schedule;
CREATE TABLE work_meal_schedule
(
    id               BIGSERIAL PRIMARY KEY,
    questionnaire_id BIGINT       NOT NULL,
    meals_daily      INT          NULL,
    meal_times       VARCHAR(255) NULL,
    working_hours    VARCHAR(255) NULL,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_work_meal_schedule_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS menstrual_cycle;
CREATE TABLE menstrual_cycle
(
    id                            BIGSERIAL PRIMARY KEY,
    questionnaire_id              BIGINT       NOT NULL,
    regular_menstrual_cycle       BOOLEAN      NOT NULL,
    irregular_cycle_reason        VARCHAR(255) NULL,
    changes_in_appetite_or_weight BOOLEAN      NOT NULL,
    description_of_changes        VARCHAR(255) NULL,
    day_of_cycle_when_weighed     INT          NULL,
    created_at                    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_menstrual_cycle_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

--

DROP TABLE IF EXISTS nutrition_goals;
CREATE TABLE nutrition_goals
(
    id                   BIGSERIAL PRIMARY KEY,
    questionnaire_id     BIGINT       NOT NULL,
    timeframe_to_achieve VARCHAR(255) NULL,
    created_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_goals_questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE SET NULL
);

DROP TABLE IF EXISTS nutrition_goal;
CREATE TABLE nutrition_goal
(
    nutrition_goals_id BIGINT NOT NULL,
    goal               GOAL   NOT NULL,
    CONSTRAINT nutrition_goal_pkey PRIMARY KEY (nutrition_goals_id, goal),
    CONSTRAINT fk_nutrition_goals FOREIGN KEY (nutrition_goals_id) REFERENCES nutrition_goals (id) ON DELETE CASCADE
);