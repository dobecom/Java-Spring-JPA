package com.example.member.framework.jpaadapter;

import com.example.member.model.Member;
import com.example.member.model.vo.IDName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Optional<Member> findMemberByIdName(IDName idName);
}
