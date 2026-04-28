package com.example.mapper;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;

public class Converter {
    public static MobileDto entity_dto(Mobile mobile) {
        return new MobileDto(
                mobile.getId(),
                mobile.getBrand(),
                mobile.getModel(),
                mobile.getPrice(),
                mobile.getStock());
    }
    public static Mobile dto_entity(MobileDto mobileDto) {
        return new Mobile(
                mobileDto.id(),
                mobileDto.brand(),
                mobileDto.model(),
                mobileDto.price(),
                mobileDto.stock());
    }

}