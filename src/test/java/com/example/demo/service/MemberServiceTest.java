package com.example.demo.service;


import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    private MemberService memberService;

    @Mock
    private MemberRepo memberRepository;

    @Before
    public void setUp() throws Exception {
        memberService = new MemberService(memberRepository);
    }

    @Test
    public void createMemberSuccessfully() throws Exception {
        //Arrange
        doAnswer(returnsFirstArg()).when(memberRepository).save(any(Member.class));
        Member member = new Member();
        member.setName("Cherprang");

        //Act
        Member memberResponse = memberService.createMember(member);

        //Assert
        assertThat(memberResponse.getName()).isEqualTo("Cherprang");
        verify(memberRepository).save(any(Member.class));
    }
}
