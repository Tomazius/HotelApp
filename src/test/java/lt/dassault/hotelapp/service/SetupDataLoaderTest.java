package lt.dassault.hotelapp.service;

import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SetupDataLoaderTest {


    @Captor
    ArgumentCaptor<Room> roomCaptor;

    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    SetupDataLoader setupDataLoader;

    @Test
    void onStartup_createsRooms() {
        setupDataLoader.initializeRooms();

        verify(roomRepository, times(5)).save(roomCaptor.capture());

        var capturedRooms = roomCaptor.getAllValues();
        var capturedRoomNumbers = capturedRooms.stream()
                .map(Room::getRoomNumber)
                .collect(Collectors.toList());
        assertThat(capturedRoomNumbers)
                .containsExactlyInAnyOrder("101", "102", "103", "104", "105");
    }
}