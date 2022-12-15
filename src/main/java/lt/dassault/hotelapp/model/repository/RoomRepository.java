package lt.dassault.hotelapp.model.repository;

import lt.dassault.hotelapp.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAll();
    Room findById(int id);
    Room findByRoomNumber(String roomNumber);
    Room findFirstByRoomStatus(String status);
}
