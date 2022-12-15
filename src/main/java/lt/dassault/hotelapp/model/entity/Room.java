package lt.dassault.hotelapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomNumber;
    private String roomStatus;

    @OneToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guestAtRoom;

    @OneToMany(mappedBy = "roomVisit")
    private Set<Visit> roomVisitHistory;

    public Room() {
    }

    public Room(int id, String roomNumber, String roomStatus, Guest guestAtRoom, Set<Visit> roomVisitHistory) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.guestAtRoom = guestAtRoom;
        this.roomVisitHistory = roomVisitHistory;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", guestAtRoom=" + guestAtRoom +
                ", roomVisitHistory=" + roomVisitHistory +
                '}';
    }

    public Set<Visit> getRoomVisitHistory() {
        return roomVisitHistory;
    }

    public void setRoomVisitHistory(Set<Visit> roomVisitHistory) {
        this.roomVisitHistory = roomVisitHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
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

}
