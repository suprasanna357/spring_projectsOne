package moviebooking;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieTicketService {

    private List<MovieTicket> tickets = new ArrayList<>();

    public MovieTicket addTicket(MovieTicket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    public List<MovieTicket> getAllTickets() {
        return tickets;
    }

    public MovieTicket getTicketById(int id) {

        for (MovieTicket ticket : tickets) {

            if (ticket.getTicketId() == id) {
                return ticket;
            }
        }

        return null;
    }

    public MovieTicket updateTicket(int id, MovieTicket newTicket) {

        for (MovieTicket ticket : tickets) {

            if (ticket.getTicketId() == id) {

                ticket.setMovieName(newTicket.getMovieName());
                ticket.setCustomerName(newTicket.getCustomerName());
                ticket.setSeatNumber(newTicket.getSeatNumber());
                ticket.setTicketPrice(newTicket.getTicketPrice());

                return ticket;
            }
        }

        return null;
    }

    public String deleteTicket(int id) {

        for (MovieTicket ticket : tickets) {

            if (ticket.getTicketId() == id) {
                tickets.remove(ticket);
                return "Ticket deleted successfully";
            }
        }

        return "Ticket not found";
    }
}
