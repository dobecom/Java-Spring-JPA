package com.example.member.application.usecase;


import com.example.member.framework.web.dto.MemberOutPutDTO;

public interface InquiryMemberUsecase {
    public MemberOutPutDTO getMember(long memberNo);
}
