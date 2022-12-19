package lt.dassault.hotelapp.controller;

import lt.dassault.hotelapp.model.entity.Guest;
import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.entity.Visit;
import lt.dassault.hotelapp.model.repository.GuestRepository;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import lt.dassault.hotelapp.model.repository.VisitRepository;
import lt.dassault.hotelapp.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RegistrationController {

    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final RoomRepository roomRepository;

    private final GuestRepository guestRepository;

    private final VisitRepository visitRepository;

    private final HotelService hotelService;

    public RegistrationController(RoomRepository roomRepository, GuestRepository guestRepository, VisitRepository visitRepository, HotelService hotelService) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.visitRepository = visitRepository;
        this.hotelService = hotelService;
    }

    @GetMapping("/home")
    String roomBooking(Model model) {

        List<Room> allRooms = roomRepository.findAll();
        model.addAttribute("allRooms", allRooms);

        return "booking_homepage";
    }

    @GetMapping("/booking_form")
    String bookingForm(Model model) {

        Guest newGuest = new Guest();
        model.addAttribute("newGuest", newGuest);

        if (hotelService.checkRoomsOccupied()) {
            return "booking_closed";
        } else {
            return "booking_form";
        }
    }

    @PostMapping("/booking_confirmation")
    String bookingConfirmation(Model model, @ModelAttribute Guest newGuest) {
        logger.info("booking confirmation request: {}", newGuest);

        Room room = roomRepository.findFirstByOrderByRoomStatusDesc();
        room.setRoomStatus("Occupied");

        Visit visit = new Visit();
        visit.setRoomVisit(room);
        visit.setGuestVisit(newGuest);
        visit.setVisitStatus("Active");
        visit.setCheckInDate(LocalDateTime.now());

        roomRepository.save(room);
        guestRepository.save(newGuest);

        var savedEntity = visitRepository.save(visit);
        model.addAttribute("roomNumber", savedEntity.getRoomVisit().getRoomNumber());

        return "booking_confirmed";
    }

    @GetMapping("/checkout_form/{id}")
    String visitCheckOut(Model model, @PathVariable int id) {

        Visit visit = visitRepository.findById(id);
        model.addAttribute("fullName", visit.getGuestVisit().getFullName());

        return "checkout_form";
    }

    @PostMapping("/checkout_confirmation/{id}")
    String confirmCheckout(Model model, @PathVariable int id) {

        Visit visit = visitRepository.findById(id);

        visit.setVisitStatus("Finished");
        visit.getRoomVisit().setRoomStatus("Vacant");
        visit.setCheckOutDate(LocalDateTime.now());

        visitRepository.save(visit);

        return "checkout_finished";
    }

    @GetMapping("/room_empty")
    String emptyRoom() {
        return "room_empty";
    }

    @GetMapping("/booking_history")
    String showHistory(Model model) {

        List<Visit> allVisits = visitRepository.findAllByOrderByCheckOutDateDesc();
        model.addAttribute("allVisits", allVisits);

        return "visit_history";
    }
}
