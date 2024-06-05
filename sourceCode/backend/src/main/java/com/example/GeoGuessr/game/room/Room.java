package com.example.GeoGuessr.game.room;

import com.example.GeoGuessr.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "timeToAnswer")
    private short timeToAnswer;
    @Column(name = "roomState")
    private RoomState roomState;
    @Column(name = "roundQty")
    private byte roundQty;
    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="room_city",
            joinColumns = @JoinColumn(name="roomId"),
            inverseJoinColumns = @JoinColumn(name="cityId"))
    private List<User> cityPool;

    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="user_room",
            joinColumns = @JoinColumn(name="roomId"),
            inverseJoinColumns = @JoinColumn(name="userId"))
    private List<User> players;
}
