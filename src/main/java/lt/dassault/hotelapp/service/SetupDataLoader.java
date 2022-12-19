package lt.dassault.hotelapp.service;

import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
public class SetupDataLoader {

    private final RoomRepository roomRepository;

    public SetupDataLoader(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void initializeRooms() {
        IntStream.rangeClosed(101, 105)
                .forEach(this::createRoomIfNotFound);
    }

    private void createRoomIfNotFound(Integer roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber.toString());
        if (room == null) {
            saveRoom(roomNumber.toString());
        }
    }

    private void saveRoom(String roomNumber) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomStatus("Vacant");

        roomRepository.save(room);
    }
}
