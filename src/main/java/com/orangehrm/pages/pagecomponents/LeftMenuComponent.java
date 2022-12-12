package com.orangehrm.pages.pagecomponents;

import com.orangehrm.LeftMenuComponentType;
import lombok.SneakyThrows;

import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent {

  public LeftMenuComponent selectAMenuFromLeftMenuBar(LeftMenuComponentType menuType) {
    $(byText(menuType.getMenuName())).shouldBe(enabled)
        .click();
    return this;
  }

  /*
   I would not prefer to use the below method just to write fluent code
   It introduces complexities. But I will leave it to your choice.
   */
  @SneakyThrows
  public <T> T getInstanceOfClass(Class<T> clazz) {
    return clazz.getDeclaredConstructor()
        .newInstance();
  }

  /*
    If the method selectAMenu is involving many interactions
    it makes sense to create some method like below
    The caller method can use this like perform(leftmenu -> leftmenu.element.click())
   */

  public void perform(Consumer<LeftMenuComponent> leftMenuComponentConsumer) {
    leftMenuComponentConsumer.accept(this);
  }
}