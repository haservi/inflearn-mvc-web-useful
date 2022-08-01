package hello.itemservice.locale;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LocaleController {

    private final ItemRepository itemRepository;

    @RequestMapping("/message/international")
    public String getInternationalPage(Model model) {
        log.info("international");
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "message/items";
    }

    @ResponseBody
    @RequestMapping("/message/sessionClear")
    public String sessionClear(HttpSession session) {
        session.invalidate();
        return "OK";
    }
}
