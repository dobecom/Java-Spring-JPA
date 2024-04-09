package com.example.member.application.usecase;


import com.example.member.framework.web.dto.MemberOutPutDTO;
import com.example.member.model.vo.IDName;

public interface UsePointUsecase {
    public MemberOutPutDTO userPoint(IDName idName, long point) throws Exception;
}
