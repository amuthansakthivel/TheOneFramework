package com.tmb.entity.response;

import lombok.Data;

@Data
public class CreateUserResponse {
  private String name;
  private String job;
  private String createdAt;
  private String id;
}

