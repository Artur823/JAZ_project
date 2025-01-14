package org.example.frontend.frontendControllersWeb;

import org.example.client.contract.OrderBookDTO;
import org.example.frontend.client.OrderBookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order-books")
public class OrderBookWebController {

    private final OrderBookClient orderBookClient;

    @Autowired
    public OrderBookWebController(OrderBookClient orderBookClient) {
        this.orderBookClient = orderBookClient;
    }

    // Отображение списка всех OrderBook
    @GetMapping
    public String listOrderBooks(Model model) {
        model.addAttribute("orderBooks", orderBookClient.getAllOrderBooks());
        return "order-books/list";
    }

    // Отображение деталей конкретного OrderBook по ID
    @GetMapping("/{id}")
    public String viewOrderBookDetails(@PathVariable Long id, Model model) {
        model.addAttribute("orderBook", orderBookClient.getOrderBookById(id));
        return "order-books/details";
    }

    // Отображение формы для создания нового OrderBook
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("orderBook", new OrderBookDTO(null, null, null, null, null, null));
        return "order-books/form";
    }

    // Обработка данных формы для сохранения нового OrderBook
    @PostMapping
    public String saveOrderBook(@ModelAttribute OrderBookDTO orderBookDTO) {
        orderBookClient.saveOrderBook(orderBookDTO);
        return "redirect:/order-books";
    }
}
