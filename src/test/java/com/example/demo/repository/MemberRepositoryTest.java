package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepo memberRepository;

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        //Arrange
        Member member = new Member();
        member.setName("Cherprang");
        entityManager.persist(member);

        //Act
        List<Member> memberOptional = memberRepository.findByName("Cherprang");

        //Assert
        assertThat(memberOptional.get(0).getName()).isEqualTo("Cherprang");
    }
}
