package com.momc.momc.repository;

import com.momc.momc.entity.Event;
import com.momc.momc.entity.Member;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PureJavaMemberRepository implements MemberRepository {

    private List<Member> repository = new ArrayList<>();
    private Long idSequence = 1L;

    @Override
    public Member save(Member member) {
        try {
            Field memberIdField = member.getClass().getDeclaredField("id");
            memberIdField.setAccessible(true);
            memberIdField.set(member, idSequence++);
            repository.add(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.stream()
                .filter(member -> Objects.equals(member.getId(), id))
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void delete(Member member) {
        Optional<Member> result = repository.stream()
                .filter(element -> Objects.equals(element.getId(), member.getId()))
                .findFirst();

        result.ifPresent(value -> repository.remove(value));
    }

    @Override
    public void deleteAllByEvent(Event event) {
        List<Member> collect = repository.stream().filter(member -> member.getEvent().equals(event))
                .collect(Collectors.toList());
        repository.removeAll(collect);
    }
}
