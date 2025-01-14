package org.example.frontend.frontendControllersWeb;

import org.example.client.contract.KlineDataDTO;
import org.example.frontend.client.KlineDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kline-data")
public class KlineDataWebController {

    private final KlineDataClient klineDataClient;

    @Autowired
    public KlineDataWebController(KlineDataClient klineDataClient) {
        this.klineDataClient = klineDataClient;
    }

    // Отображаем список всех данных Kline
    @GetMapping
    public String listKlineData(Model model) {
        // Получаем все данные Kline через клиент и добавляем в модель для отображения
        model.addAttribute("klineData", klineDataClient.getAllKlineData());
        return "kline-data/list";
    }

    // Отображаем подробности о конкретной записи Kline по ID
    @GetMapping("/{id}")
    public String viewKlineDataDetails(@PathVariable Long id, Model model) {
        // Получаем данные по ID и добавляем их в модель
        model.addAttribute("klineData", klineDataClient.getKlineDataById(id));
        return "kline-data/details";
    }

    // Открываем форму для создания новой записи Kline
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        // Добавляем пустой DTO в модель, чтобы передать его в форму
        model.addAttribute("klineData", new KlineDataDTO(null, null, null, null, null, null, null, null));
        return "kline-data/form";
    }

    // Обрабатываем POST-запрос на сохранение новой записи Kline
    @PostMapping
    public String saveKlineData(@ModelAttribute KlineDataDTO klineDataDTO) {
        // Отправляем полученные данные на сервер для сохранения
        klineDataClient.saveKlineData(klineDataDTO);
        return "redirect:/kline-data";
    }
}
