package moviebooking;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/tickets")
public class MovieTicketController {

    @Autowired
    private MovieTicketService service;

   
    @PostMapping
    public MovieTicket addTicket(
            @Valid @RequestBody MovieTicket ticket) {

        return service.addTicket(ticket);
    }

    @GetMapping
    public List<MovieTicket> getAllTickets() {

        return service.getAllTickets();
    }

   
    @GetMapping("/{id}")
    public MovieTicket getTicketById(
            @PathVariable int id) {

        return service.getTicketById(id);
    }

    
    @PutMapping("/{id}")
    public MovieTicket updateTicket(
            @PathVariable int id,
            @Valid @RequestBody MovieTicket ticket) {

        return service.updateTicket(id, ticket);
    }

  
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable int id) {

        return service.deleteTicket(id);
    }
}