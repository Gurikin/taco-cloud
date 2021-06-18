package tacos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;
import tacos.entity.Order;
import tacos.entity.User;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    private OrderRepository orderRepository;
    private UserRepository userRepo;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepo) {
        this.orderRepository = orderRepository;
        this.userRepo = userRepo;
    }

    /**
     * @param model The request model
     * @return String
     */
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /**
     *
     * @param order  The Order model
     * @param errors The possible user's errors in the order form
     * @return String
     * @throws NotFoundException
     */
    @PostMapping
    public String processOrder(
        @Valid Order order,
        Errors errors,
        SessionStatus sessionStatus,
        @AuthenticationPrincipal User user
    ) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        orderRepository.save(order);
        
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
