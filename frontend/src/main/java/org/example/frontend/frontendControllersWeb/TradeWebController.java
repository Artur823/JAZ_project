package org.example.frontend.frontendControllersWeb;

import org.example.client.contract.TradeDTO;
import org.example.frontend.client.TradeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trades")
public class TradeWebController {

    private final TradeClient tradeClient;

    @Autowired
    public TradeWebController(TradeClient tradeClient) {
        this.tradeClient = tradeClient;
    }

    // Отображение списка всех сделок
    @GetMapping
    public String listTrades(Model model) {
        model.addAttribute("trades", tradeClient.getAllTrades());
        return "trades/list"; // Шаблон для отображения списка сделок
    }

    // Отображение деталей конкретной сделки по ID
    @GetMapping("/{id}")
    public String viewTradeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("trade", tradeClient.getTradeById(id));
        return "trades/details"; // Шаблон для отображения подробностей сделки
    }

    // Отображение формы для создания новой сделки
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("trade", new TradeDTO(null, null, null, null)); // Пустой объект TradeDTO
        return "trades/form";
    }

    // Обработка данных формы для сохранения новой сделки
    @PostMapping
    public String saveTrade(@ModelAttribute TradeDTO tradeDTO) {
        tradeClient.saveTrade(tradeDTO); // Сохраняем сделку через клиент
        return "redirect:/trades";
    }
}
