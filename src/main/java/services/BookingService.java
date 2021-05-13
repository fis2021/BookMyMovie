package services;
import model.Booking;

import org.dizitart.no2.NitriteId;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
import model.Screening;
import model.User;

import java.util.ArrayList;
import java.util.List;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class BookingService {
    public static void addBooking(Booking booking){
        UserService.getBookingRepo().insert(booking);
        UserService.getScreeningRepo().update(UserService.getSelectedScreening());
    }

}