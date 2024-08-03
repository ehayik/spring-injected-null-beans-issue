CREATE TABLE IF NOT EXISTS users
(
    user_id       BIGINT       NOT NULL AUTO_INCREMENT,
    user_email    VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    user_enabled  BOOLEAN      NOT NULL,
    PRIMARY KEY (user_id)
);