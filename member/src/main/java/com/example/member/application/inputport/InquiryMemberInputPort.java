package com.example.member.application.inputport;

import com.example.member.application.outputport.MemberOutPutPort;
import com.example.member.application.usecase.InquiryMemberUsecase;
import com.example.member.framework.web.dto.MemberOutPutDTO;
import com.example.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryMemberInputPort implements InquiryMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO getMember(long memberNo) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}

