package lt.dassault.hotelapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNumber;
    private String roomStatus;

    @OneToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guestAtRoom;

    public Room() {
    }

    public Room(int id, int roomNumber, String roomStatus, Guest guestAtRoom) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.guestAtRoom = guestAtRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Guest getGuestAtRoom() {
        return guestAtRoom;
    }

    public void setGuestAtRoom(Guest guestAtRoom) {
        this.guestAtRoom = guestAtRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomStatus='" + roomStatus + '\'' +
                ", guestAtRoom=" + guestAtRoom +
                '}';
    }
}
