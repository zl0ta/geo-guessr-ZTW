CREATE TABLE City (
                      cityId BIGINT PRIMARY KEY auto_increment,
                      latitude DECIMAL,
                      longitude DECIMAL,
                      name VARCHAR(255)
);

CREATE TABLE Room (
                      roomId BIGINT PRIMARY KEY auto_increment,
                      name VARCHAR(255),
                      timeToAnswer SMALLINT CHECK (timeToAnswer > 0 AND timeToAnswer <= 300),
                      roomState ENUM('Created', 'InProgress', 'Finished'),
                      roundQty TINYINT CHECK (roundQty > 0)
);

CREATE TABLE User (
                      id BIGINT PRIMARY KEY auto_increment,
                      username VARCHAR(255) CHECK (LENGTH(username) >= 2),
                      password VARCHAR(255) CHECK (LENGTH(password) >= 8),
                      role TINYINT NOT NULL
);

CREATE TABLE GameSession (
                             gameSessionId BIGINT PRIMARY KEY auto_increment,
                             points INT CHECK (points >= 0),
                             roundNumber TINYINT CHECK (roundNumber > 0),
                             roomId BIGINT,
                             playerId BIGINT,
                             FOREIGN KEY (roomId) REFERENCES Room(roomId),
                             FOREIGN KEY (playerId) REFERENCES User(id)
);

CREATE TABLE PlayerResult (
                              playerResultId BIGINT PRIMARY KEY auto_increment,
                              result INT CHECK (result >= 0),
                              userId BIGINT,
                              roomId BIGINT,
                              FOREIGN KEY (userId) REFERENCES User(id),
                              FOREIGN KEY (roomId) REFERENCES Room(roomId)
);

CREATE TABLE Room_City (
                           roomId BIGINT,
                           cityId BIGINT,
                           PRIMARY KEY (roomId, cityId),
                           FOREIGN KEY (roomId) REFERENCES Room(roomId),
                           FOREIGN KEY (cityId) REFERENCES City(cityId)
);

CREATE TABLE User_Room (
                           userId BIGINT,
                           roomId BIGINT,
                           isHost BOOLEAN,
                           PRIMARY KEY (userId, roomId),
                           FOREIGN KEY (userId) REFERENCES User(id),
                           FOREIGN KEY (roomId) REFERENCES Room(roomId)
);
