package com.dkyou.chap04.controller;

import com.dkyou.chap04.dto.GuestbookDTO;
import com.dkyou.chap04.dto.PageRequestDTO;
import com.dkyou.chap04.dto.PageResultDTO;
import com.dkyou.chap04.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService guestbookService;

    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list........................." + pageRequestDTO);

        model.addAttribute("result",guestbookService.getList(pageRequestDTO));
        return "/guestbook/list";
    }

    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..."+dto);

        Long gno = guestbookService.register(dto);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }

    @GetMapping("/read")
    public String read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("gno: " + gno);

        GuestbookDTO dto = guestbookService.read(gno);

        model.addAttribute("dto",dto);

        return "/guestbook/read";
    }

    @GetMapping("/modify")
    public String modify(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("gno: " + gno);

        GuestbookDTO dto = guestbookService.read(gno);

        model.addAttribute("dto",dto);

        return "/guestbook/modify";
    }

    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){
        log.info("gno : " + gno);

        guestbookService.remove(gno);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }
}
