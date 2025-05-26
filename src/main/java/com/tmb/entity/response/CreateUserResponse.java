package com.tmb.entity.response;

import lombok.Data;

/**
 * The CreateUserResponse class represents the response received after creating a user.
 * It contains information about the user such as their name, job, creation timestamp, and ID.
 * 
 * <p>This class uses Lombok's @Data annotation to automatically generate 
 * boilerplate code such as getters, setters, toString, equals, and hashCode methods.</p>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code name} - The name of the user.</li>
 *   <li>{@code job} - The job title of the user.</li>
 *   <li>{@code createdAt} - The timestamp when the user was created.</li>
 *   <li>{@code id} - The unique identifier of the user.</li>
 * </ul>
 * 
 * @see lombok.Data
 */
@Data
public class CreateUserResponse {
  private String name;
  private String job;
  private String createdAt;
  private String id;
}

