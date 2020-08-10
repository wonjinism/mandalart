package kim.wonjin.mandalart.service;

import kim.wonjin.mandalart.entity.Element;
import kim.wonjin.mandalart.entity.Member;
import kim.wonjin.mandalart.entity.MemberType;
import kim.wonjin.mandalart.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ElementService elementService;

    @Autowired
    public MemberService(MemberRepository memberRepository, ElementService elementService) {
        this.memberRepository = memberRepository;
        this.elementService = elementService;
    }

    public Member initMember(Member member) {

        // Initialize Member
        memberRepository.save(member);
        member.setMemberType(MemberType.ANONYMOUS);
        member.setUsername("Guest" + member.getId());

        Element rootElement = elementService.createRootElement();
        rootElement.setMember(member);
//        elementService.updateElement(rootElement);

        List<Element> elements = new ArrayList<>();
        elements.add(rootElement);
        member.setElements(elements);
        return member;
    }

}
