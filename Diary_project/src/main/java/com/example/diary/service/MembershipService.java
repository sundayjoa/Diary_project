package com.example.diary.service;

import com.example.diary.model.Membership;
import com.example.diary.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;
    
    @Transactional
    public Membership saveMembership(Membership membership) {
        return membershipRepository.save(membership);
    }
    
}
