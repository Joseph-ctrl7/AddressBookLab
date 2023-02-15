package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
public class BuddyInfoRestController {
    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookRepository addressBookRepository;

    public BuddyInfoRestController(BuddyInfoRepository buddyInfoRepository,
                                   AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping(value="/buddyInfoRest", method = RequestMethod.GET)
    public String addBuddies(Model model){
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("jack", "613");
        BuddyInfo buddy2 = new BuddyInfo("ray", "425");
        buddyInfoRepository.save(buddy1);
        buddyInfoRepository.save(buddy2);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBookRepository.save(addressBook);

        String buddies = "";
        for(AddressBook a : addressBookRepository.findAll()){
            buddies+= a.printBuddyInfo() + "/n";
        }
        return buddies;
    }


}
