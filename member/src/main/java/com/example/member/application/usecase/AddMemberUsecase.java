package com.example.member.application.usecase;


import com.example.member.framework.web.dto.MemberInfoDTO;
import com.example.member.framework.web.dto.MemberOutPutDTO;

public interface AddMemberUsecase {
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO);

}
