package com.example.member.application.usecase;


import com.example.member.framework.web.dto.MemberOutPutDTO;
import com.example.member.model.vo.IDName;

public interface SavePointUsecase {
    public MemberOutPutDTO savePoint(IDName idName, Long point);
}
