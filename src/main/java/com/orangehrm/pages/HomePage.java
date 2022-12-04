package com.orangehrm.pages;

import com.orangehrm.pages.pagecomponents.LeftMenuComponent;

public class HomePage {

  private final LeftMenuComponent leftMenuComponent;

  public HomePage() {
    this.leftMenuComponent = new LeftMenuComponent();
  }

  public LeftMenuComponent getLeftMenuComponent() {
    return leftMenuComponent;
  }

}