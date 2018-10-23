package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.exception.MemBerNotFoundException;
import com.example.demo.repository.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member createMember(Member member) {
        return memberRepo.save(member);
    }

    public Member getMember(Long id) {
        return memberRepo.findById(id).orElseThrow(() -> new MemBerNotFoundException("Member Not Found."));
    }

    public List<Member> getAllMember() {
        return memberRepo.findAll();
    }

    public Member updateMember(Long id, Member member) {
        return memberRepo.findById(id).map(it -> {
            it.setName(member.getName());
            return memberRepo.save(it);
        }).orElseThrow(() -> new MemBerNotFoundException("Member Not Found."));
    }

    public Member deleteMember(Long id) {
        return memberRepo.findById(id).map(it -> {
            memberRepo.delete(it);
            return it;
        }).orElseThrow(() -> new MemBerNotFoundException("Member Not Found."));
    }
}
