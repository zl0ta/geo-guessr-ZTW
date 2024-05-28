package com.example.GeoGuessr.game.gameSession;

import com.example.GeoGuessr.game.room.Room;
import com.example.GeoGuessr.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gamesession")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameSessionId")
    private long id;
    @Column(name = "points")
    private int points;
    @Column(name = "roundNumber")
    private byte roundNumber;
    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="roomId")
    private Room room;
    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="playerId")
    private User player;
}
