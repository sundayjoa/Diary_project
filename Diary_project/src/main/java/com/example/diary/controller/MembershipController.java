package com.example.diary.controller;

import com.example.diary.model.Membership;
import com.example.diary.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping("/register")
    public Membership registerMembership(@RequestBody Membership membership) {
        return membershipService.saveMembership(membership);
    }
}
