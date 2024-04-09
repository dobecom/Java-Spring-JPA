package com.example.member.application.inputport;

import com.example.member.application.outputport.MemberOutPutPort;
import com.example.member.application.usecase.UsePointUsecase;
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
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO userPoint(IDName idName, long point) throws Exception {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.usePoint(new Point(point));
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
