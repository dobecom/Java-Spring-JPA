package com.example.member.application.inputport;

import com.example.member.application.outputport.MemberOutPutPort;
import com.example.member.application.usecase.AddMemberUsecase;
import com.example.member.framework.web.dto.MemberInfoDTO;
import com.example.member.framework.web.dto.MemberOutPutDTO;
import com.example.member.model.Member;
import com.example.member.model.vo.Email;
import com.example.member.model.vo.IDName;
import com.example.member.model.vo.PassWord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddMemberInputPort implements AddMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO) {

        IDName idName = new IDName(memberInfoDTO.getId(),memberInfoDTO.getName());
        PassWord pwd = new PassWord(memberInfoDTO.getPassWord(),memberInfoDTO.getPassWord());
        Email email = new Email(memberInfoDTO.getEmail());
        Member addedMember = Member.registerMember(idName,pwd,email);

        Member savedMember = memberOutPutPort.saveMember(addedMember);

        return MemberOutPutDTO.mapToDTO(savedMember);
    }
}
