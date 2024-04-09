package com.example.member.application.inputport;

import com.example.member.application.outputport.MemberOutPutPort;
import com.example.member.application.usecase.SavePointUsecase;
import com.example.member.framework.web.dto.MemberOutPutDTO;
import com.example.member.model.Member;
import com.example.member.model.vo.IDName;
import com.example.member.model.vo.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO savePoint(IDName idName, Long point) {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.savePoint(new Point(point));
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
