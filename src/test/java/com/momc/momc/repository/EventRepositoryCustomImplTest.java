package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import com.momc.momc.model.dto.EventDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class EventRepositoryCustomImplTest {

    @Autowired
    JPAEventRepository jpaEventRepository;

    @Test
    @Transactional
    void test2() throws Exception {
        List<Event> all = jpaEventRepository.findAll();
        System.out.println(all);
    }

    @Test
    void test() throws Exception {
        LocalDate now = LocalDate.now();

        LocalDate lastMonth = now.minusMonths(1);
        LocalDate lastMonthWithStartDay = lastMonth.withDayOfMonth(1);

        LocalDate nextMonth = now.plusMonths(1);
        LocalDate nextMonthWithEndDay = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());

        List<EventDto> result = jpaEventRepository.findAllDtoByEventDateBetween(lastMonthWithStartDay, nextMonthWithEndDay);

        System.out.println(result);
    }

}