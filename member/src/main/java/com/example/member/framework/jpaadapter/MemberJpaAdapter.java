package com.example.member.framework.jpaadapter;

import com.example.member.application.outputport.MemberOutPutPort;
import com.example.member.model.Member;
import com.example.member.model.vo.IDName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberOutPutPort {

    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(long memberNo) {
        return memberRepository.findById(memberNo).get();
    }

    @Override
    public Member loadMemberByIdName(IDName idName) {
        return memberRepository.findMemberByIdName(idName).get();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
