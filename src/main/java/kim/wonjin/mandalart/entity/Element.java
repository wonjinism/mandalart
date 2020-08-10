package kim.wonjin.mandalart.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Element {
    /*
     정의 : 이것이 무엇인지 정의하지는 말자. 카테고리가 될 수도 있고, 개인의 정의가 필요한 거대한 개념으로 쓸 수도 있다. 예) 인생 > 건강
     구조 : 타이틀을 공통적으로 가지고, 타입별로 구체적인 정보를 가지면서도 8방향으로 Element를 가진다. 배경을 바꿀 수 있다.
     */

    @Id @GeneratedValue
    @Column(name = "element_id")
    private Long id;
    private String title;

    @Embedded
    private ElementBackground background;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Element superElement;

    private int position = 0;

    @OneToMany(mappedBy = "superElement", cascade = CascadeType.ALL)
    private List<Element> subElements;



    public void setMember(Member member) {
        this.member = member;
        member.getElements().add(this);
    }

    public void addElements(Element element) {

    }

}
