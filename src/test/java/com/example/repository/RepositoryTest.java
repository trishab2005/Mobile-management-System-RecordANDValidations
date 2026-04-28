package com.example.repository;

import com.example.entity.Mobile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private MobileRepository mobileRepository;

    @Test
    void testSaveAndFind(){
        Mobile mobile = new Mobile();
        mobile.setBrand("trisha");
        mobile.setStock(10);
        mobile.setPrice(34455.00);
        mobile.setModel("spring");
        mobileRepository.save(mobile);
        Mobile fetch= mobileRepository.findById(mobile.getId()).get();
        assertNotNull(fetch);
    }


}
