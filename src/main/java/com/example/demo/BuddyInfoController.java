package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyInfoController {

    private final BuddyInfoRepository buddyInfoRepository;

    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @RequestMapping(value="/BuddyInfo", method = RequestMethod.GET)
    public String addBuddies(@RequestParam(name="name", defaultValue = "Jason") String name, Model model){
        //BuddyInfo buddy = new BuddyInfo(name);
        //buddyInfoRepository.save(buddy);
        model.addAttribute("buddy", name);
        return "BuddyInfo";
    }

}
