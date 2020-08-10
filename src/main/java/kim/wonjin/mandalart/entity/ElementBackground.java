package kim.wonjin.mandalart.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ElementBackground {
    private String color;
    private String url;

    protected ElementBackground() {
    }

    public ElementBackground(String color, String url) {
        this.color = color;
        this.url = url;
    }
}
