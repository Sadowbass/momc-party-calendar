package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import com.momc.momc.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    void delete(Member member);

    void deleteAllByEvent(Event event);
}
