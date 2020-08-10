package kim.wonjin.mandalart.service;

import kim.wonjin.mandalart.entity.Element;
import kim.wonjin.mandalart.entity.Member;
import kim.wonjin.mandalart.entity.MemberType;
import kim.wonjin.mandalart.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ElementServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ElementService elementService;

    @Test
    public void createRootElement() {
        Element rootElement = elementService.createRootElement();
        assertThat(rootElement.getId()).isNotNull();
        assertThat(rootElement.getMember()).isNull();
        assertThat(rootElement.getPosition()).isEqualTo(0);
        assertThat(rootElement.getTitle()).isEqualTo("root");
    }

    @Test
    public void addElement() {
//        Member admin = createAdmin();
//
//
//        Element element = new Element();
//        element.setTitle("2020 목표 설정");
//        element.setMember(admin);
//        elementService.addElement(element);

    }

    private Member createAdmin() {
        Member member = new Member();
        member.setMemberType(MemberType.ADMIN);
        member.setEmail("admin");
        member.setPassword("admin");
        member.setUsername("Admin");
        return memberRepository.save(member);
    }

}