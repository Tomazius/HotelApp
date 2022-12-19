package lt.dassault.hotelapp.service;

import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final RoomRepository roomRepository;

    public HotelService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean checkRoomsOccupied() {
        for (int i = 101; i <= 105; i++) {
            var room = roomRepository.findByRoomNumber(String.valueOf(i));
            if ("Vacant".equalsIgnoreCase(room.getRoomStatus())) {
                return false;
            }
        }
        return true;
    }
}
