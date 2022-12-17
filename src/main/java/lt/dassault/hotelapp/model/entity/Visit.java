package lt.dassault.hotelapp.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String visitStatus;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guestVisit;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomVisit;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    public Visit() {
    }

    public Visit(int id, String visitStatus, Guest guestVisit, Room roomVisit, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        this.id = id;
        this.visitStatus = visitStatus;
        this.guestVisit = guestVisit;
        this.roomVisit = roomVisit;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Guest getGuestVisit() {
        return guestVisit;
    }

    public void setGuestVisit(Guest guestVisit) {
        this.guestVisit = guestVisit;
    }

    public Room getRoomVisit() {
        return roomVisit;
    }

    public void setRoomVisit(Room roomVisit) {
        this.roomVisit = roomVisit;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", visitStatus='" + visitStatus + '\'' +
                ", guestVisit=" + guestVisit +
                ", roomVisit=" + roomVisit +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

}
