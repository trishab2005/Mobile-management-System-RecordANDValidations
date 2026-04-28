package com.example.service.impl;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;
import com.example.mapper.Converter;
import com.example.repository.MobileRepository;
import com.example.service.MobileService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {
    private final MobileRepository mobileRepository;
    private final ModelMapper modelMapper;
    @Override
    public MobileDto addMobile(MobileDto mobileDto) {
//    Mobile m=modelMapper.map(mobileDto, Mobile.class);
//    Mobile saved=mobileRepository.save(m);
//    return modelMapper.map(saved, MobileDto.class);
        //return modelMapper.map(mobileRepository.save(modelMapper.map(mobileDto, Mobile.class)), MobileDto.class);
        return Converter.entity_dto(mobileRepository.save(Converter.dto_entity(mobileDto)));
    }

    @Override
    public List<MobileDto> getAllMobiles() {
//        List<Mobile> mobiles = mobileRepository.findAll();
        return mobileRepository.findAll().stream().map(Converter::entity_dto).toList();
    }

    @Override
    public MobileDto getMobileById(Long id) {
        return mobileRepository.findById(id).map(Converter::entity_dto).orElseThrow(
                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
    }

    @Override
    public MobileDto updateMobile(Long id,MobileDto mobileDto) {
        Mobile em=mobileRepository.findById(id).orElseThrow(
                ()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
        em.setBrand(mobileDto.brand());
        em.setModel(mobileDto.model());
        em.setPrice(mobileDto.price());
        em.setStock(mobileDto.stock());
        return Converter.entity_dto(mobileRepository.save(em));
    }

    @Override
    public String deleteMobile(Long id) {
        Mobile em=mobileRepository.findById(id).orElseThrow(()->new MobileNotFoundException("Mobile with id: "+id+" not found"));
        mobileRepository.delete(em);
        return "Mobile with id: "+id+" deleted";
    }

}