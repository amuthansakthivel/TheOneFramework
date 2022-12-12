package com.orangehrm.pages.enums;

public enum LeftMenuComponentType {

  ADMIN("Admin"),
  PIM("PIM"),
  LEAVE("Leave");

  private final String menuName;

  public String getMenuName() {
    return menuName;
  }

  LeftMenuComponentType(String menuName) {
    this.menuName = menuName;
  }
}
