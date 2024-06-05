package com.example.GeoGuessr.game.playerResult;

import com.example.GeoGuessr.game.room.Room;
import com.example.GeoGuessr.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "playerresult")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "result")
    private int result;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="userId")
    private User user;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="roomId")
    private Room room;
}
