/*
Copyright 2023 Jose Morales joseluis.delacruz@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.jos.dem.vetlog.model;

import com.jos.dem.vetlog.enums.RegistrationCodeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
public class RegistrationCode {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private LocalDateTime dateCreated = LocalDateTime.now();

  @Column(nullable = false)
  private String token = UUID.randomUUID().toString();

  @Column(nullable = false)
  private RegistrationCodeStatus status = RegistrationCodeStatus.VALID;

  public Boolean isValid() {
    return status == RegistrationCodeStatus.VALID ? true : false;
  }
}
