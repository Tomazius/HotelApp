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

import java.time.LocalDateTime;
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
        return "booking_homepage";
    }

    @GetMapping("/booking_form")
    String bookingForm(Model model){
        Guest newGuest = new Guest();
        model.addAttribute("newGuest", newGuest);
        if(roomRepository.findById(1).getRoomStatus().equalsIgnoreCase("Occupied") && roomRepository.findById(2).getRoomStatus().equalsIgnoreCase("Occupied") && roomRepository.findById(3).getRoomStatus().equalsIgnoreCase("Occupied") && roomRepository.findById(4).getRoomStatus().equalsIgnoreCase("Occupied") && roomRepository.findById(5).getRoomStatus().equalsIgnoreCase("Occupied")){
            return "booking_closed";
        }
        else{
            return "booking_form";
        }
    }

    @PostMapping("/booking_confirmation")
    String bookingConfirmation(Model model, @ModelAttribute Guest newGuest){
        Room room = roomRepository.findFirstByOrderByRoomStatusDesc();
        room.setRoomStatus("Occupied");
        Visit visit = new Visit();
        visit.setRoomVisit(room);
        visit.setGuestVisit(newGuest);
        visit.setVisitStatus("Active");
        visit.setCheckInDate(LocalDateTime.now());
        roomRepository.save(room);
        guestRepository.save(newGuest);
        visitRepository.save(visit);
/*        System.out.println(room);
        System.out.println(newGuest);
        System.out.println(visit);*/
        return "booking_confirmed";
    }

    @GetMapping("/checkout_form/{id}")
    String visitCheckOut(Model model, @PathVariable int id){
        Visit visit = visitRepository.findById(id);
        model.addAttribute("fullName", visit.getGuestVisit().getFullName());
        System.out.println(visit.getGuestVisit().getFullName());
        return "checkout_form";
    }

    @PostMapping("/checkout_confirmation/{id}")
    String confirmCheckout(Model model, @PathVariable int id){
        Visit visit = visitRepository.findById(id);
        visit.setVisitStatus("Finished");
        visit.getRoomVisit().setRoomStatus("Vacant");
        visit.setCheckOutDate(LocalDateTime.now());
        visitRepository.save(visit);
        return "checkout_finished";
    }

    @GetMapping("/room_empty")
    String emptyRoom(){
        return "room_empty";
    }

    @GetMapping("/booking_history")
    String showHistory(Model model){
        List<Visit> allVisits = visitRepository.findAllByOrderByCheckInDateDesc();
        model.addAttribute("allVisits", allVisits);
        return "visit_history";
    }

/*    @GetMapping("/template")
    String template(){
        return "homepage_temps";
    }

    @GetMapping("/test")
    String test(){
        return "testpage";
    }*/
}
