package kim.wonjin.mandalart.service;

import kim.wonjin.mandalart.entity.Element;
import kim.wonjin.mandalart.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ElementService {

    private final ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    /*
     필요한 기능
     1. 엘리먼트를 등록 (등록 대상 element_id, 등록 위치, 등록할 엘리먼트)
     2. 엘리먼트 수정
     2. 엘리먼트 이동 (이동 대상 element_id, 이동 위치, 이동할 엘리먼트)
        이동 위치에 값이 있으면 그걸 되돌려 줘야 할 거 같은데 (이건 뭐 화면에서 처리? 그대로 검증을 위해)
     3. 엘리먼트 삭제 (삭제 대상)
     */

    // element 신규 추가
    public Long addElement(Long targetElementId, int targetPosition, Element element) {

        element.setPosition(targetPosition);
        elementRepository.save(element);

        Element targetElement = elementRepository.findById(targetElementId).orElse(null);
        targetElement.getSubElements().add(element);

        return element.getId();
    }

    // element 내용만 수정
    public Element updateElement(Element element) {
        elementRepository.save(element);
        return element;
    }

    // element position 변경
    public Element updateElementPosition(Long targetElementId, Element currentElement, Element moveElement) {
        int currentPosition = currentElement.getPosition();
        int movePosition = moveElement.getPosition();
        currentElement.setPosition(movePosition);
        moveElement.setPosition(currentPosition);

        elementRepository.save(currentElement);
        return elementRepository.save(moveElement);
    }

    // 삭제
    public void removeElement(Element element) {
        elementRepository.delete(element);
    }

    public Element createRootElement() {
        Element element = new Element();
        element.setTitle("root");
        element.setPosition(0);
        return elementRepository.save(element);
    }
}
