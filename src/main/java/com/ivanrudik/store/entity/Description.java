package com.ivanrudik.store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    private Long id;
    private String manufacturer;
    private String manufactureDate;
    private String details;
}
