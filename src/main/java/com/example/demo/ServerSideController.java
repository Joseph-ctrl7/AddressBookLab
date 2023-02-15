package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller


public class ServerSideController {
    private AddressBookRepository addressbookRepo;
    private BuddyInfoRepository buddyInfoRepo;

    @Autowired
    public ServerSideController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){
        this.addressbookRepo = addressBookRepository;
        this.buddyInfoRepo = buddyInfoRepository;
    }
    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String viewForm(Model model){
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo();
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddyInfo", buddy);
        return "view";
    }

    @RequestMapping(value="/addressBookView", method = RequestMethod.POST)
    public String createAddressBook(Model model){
        if (addressbookRepo.findById(1L) == null){
            AddressBook a = new AddressBook();
            addressbookRepo.save(a);
        }
        AddressBook a = addressbookRepo.findById(1L);
        model.addAttribute("addressBook", a);
        return "addressBookView";
    }

    @RequestMapping(value="/buddyInfoView", method = RequestMethod.POST)
    public String addBuddy(@ModelAttribute("buddy") BuddyInfo buddyInfo){
        AddressBook a = addressbookRepo.findById(1L);
        a.addBuddy(buddyInfo);
        addressbookRepo.save(a);
        return "buddyInfoView";
    }



}
