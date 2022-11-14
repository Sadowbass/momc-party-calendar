package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAEventRepository extends EventRepository, JpaRepository<Event, Long>, EventRepositoryCustom {
}
