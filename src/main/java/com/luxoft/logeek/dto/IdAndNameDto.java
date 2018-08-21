package com.luxoft.logeek.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IdAndNameDto {
    private final int id;
    private final String name;
}
