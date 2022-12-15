package lt.dassault.hotelapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Guest")
public class Guest {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room assignedRoom;

    public Guest() {
    }

    public Guest(int id, String name, String lastName, Room assignedRoom) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.assignedRoom = assignedRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", assignedRoom=" + assignedRoom +
                '}';
    }
}
