package com.example.member.application.outputport;

import com.example.member.model.Member;
import com.example.member.model.vo.IDName;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOutPutPort {
    public Member loadMember(long memberNo);
    public  Member loadMemberByIdName(IDName idName);
    public Member saveMember(Member member);
}
