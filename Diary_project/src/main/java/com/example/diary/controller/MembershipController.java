package com.example.diary.controller;

import com.example.diary.model.Membership;
import com.example.diary.service.MembershipService;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {
	
	private static final Logger logger = LoggerFactory.getLogger(MembershipController.class);

    @Autowired
    private MembershipService membershipService;

    @PostMapping("/register")
    public ResponseEntity<String> registerMembership(@RequestBody Membership membership, HttpSession session) {
    	
    	if (membership.getId() == null || membership.getId().isEmpty()) {
            return ResponseEntity.badRequest().body("ID는 필수 입력값입니다.");
        }
    	
    	 try {
             membershipService.saveMembership(membership);
             logger.info("회원가입이 성공적으로 완료되었습니다: " + membership.getId());
             session.setAttribute("userId", membership.getId());
             return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
         } catch (Exception e) {
             logger.error("회원가입 중 오류가 발생했습니다.", e);
             return ResponseEntity.status(500).body("회원가입 중 오류가 발생했습니다. 상세 내용: " + e.getMessage());
         }
    }

}
