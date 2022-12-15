package lt.dassault.hotelapp.controller;

import lt.dassault.hotelapp.model.entity.Guest;
import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.entity.Visit;
import lt.dassault.hotelapp.model.repository.GuestRepository;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import lt.dassault.hotelapp.model.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Registration {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    VisitRepository visitRepository;

    @GetMapping("/booking")
    String roomBooking(Model model) {
        List<Room> allRooms = roomRepository.findAll();
        model.addAttribute("allRooms", allRooms);

        Room room1 = roomRepository.findByRoomNumber("101");
        model.addAttribute("roomStatus", room1.getRoomStatus());
        if(room1.getGuestAtRoom() == null){
            room1.setRoomStatus("Vacant");
        }
        else{
            room1.setRoomStatus("Occupied");
        }
        roomRepository.save(room1);  //savina visus o ne 1

        Room room2 = roomRepository.findByRoomNumber("102");
        model.addAttribute("roomStatus", room2.getRoomStatus());
        if(room2.getGuestAtRoom() == null){
            room2.setRoomStatus("Vacant");
        }
        else{
            room2.setRoomStatus("Occupied");
        }

        Room room3 = roomRepository.findByRoomNumber("103");
        model.addAttribute("roomStatus", room3.getRoomStatus());
        if(room3.getGuestAtRoom() == null){
            room3.setRoomStatus("Vacant");
        }
        else{
            room3.setRoomStatus("Occupied");
        }

        Room room4 = roomRepository.findByRoomNumber("104");
        model.addAttribute("roomStatus", room4.getRoomStatus());
        if(room4.getGuestAtRoom() == null){
            room4.setRoomStatus("Vacant");
        }
        else{
            room4.setRoomStatus("Occupied");
        }


        Room room5 = roomRepository.findByRoomNumber("105");
        model.addAttribute("roomStatus", room5.getRoomStatus());
        if(room5.getGuestAtRoom() == null){
            room5.setRoomStatus("Vacant");
        }
        else{
            room5.setRoomStatus("Occupied");
        }
        return "booking_homepage";
    }

    @GetMapping("/booking_form")
    String bookingForm(Model model){
        Guest newGuest = new Guest();
        model.addAttribute("newGuest", newGuest);
        return "booking_form";
    }
/*
        Room room = roomRepository.findById(id);
        model.addAttribute("guestAtRoom", room.getGuestAtRoom());
        if(room.getGuestAtRoom() == null){
            System.out.println("if teigiamas");
        Guest newGuest = new Guest();
        model.addAttribute("newGuest", newGuest);
            System.out.println("daeina iki čia");;
            return "booking_form";
        }
        else{
            System.out.println("if eina else");
            return "room_occupied";
        }
*/



    @PostMapping("/booking_confirmation")
    String bookingConfirmation(Model model, @ModelAttribute Guest newGuest){
        Room room = roomRepository.findFirstByRoomStatus("Vacant");
        room.setRoomStatus("Occupied");
        Visit visit = new Visit();
        visit.setRoomVisit(room);
        newGuest.setAssignedRoom(room);
        visit.setGuestVisit(newGuest);
        roomRepository.save(room);
        guestRepository.save(newGuest);
        visitRepository.save(visit);
/*        System.out.println(room);
        System.out.println(newGuest);
        System.out.println(visit);*/
        return "booking_confirmed";
    }
}
