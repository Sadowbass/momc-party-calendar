package com.momc.momc.repository;

import com.momc.momc.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberRepository extends MemberRepository, JpaRepository<Member, Long> {
}