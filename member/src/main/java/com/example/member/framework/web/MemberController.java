package com.example.member.framework.web;

import com.example.member.application.usecase.AddMemberUsecase;
import com.example.member.application.usecase.InquiryMemberUsecase;
import com.example.member.framework.web.dto.MemberInfoDTO;
import com.example.member.framework.web.dto.MemberOutPutDTO;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final AddMemberUsecase addMemberUsecase;
    private final InquiryMemberUsecase inquiryMemberUsecase;

    @PostMapping("/Member/")
    public ResponseEntity<MemberOutPutDTO> addMember(@RequestBody MemberInfoDTO memberInfoDTO) {
        MemberOutPutDTO addedMember = addMemberUsecase.addMember(memberInfoDTO);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }

    @GetMapping("/Member/{no}")
    public ResponseEntity<MemberOutPutDTO> getMember(
            @Parameter(description = "user id", example = "1")
            @PathVariable(name = "no", required = true) long no
    ) {
        MemberOutPutDTO member = inquiryMemberUsecase.getMember(no);
        return member != null
                ? new ResponseEntity<>(member, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

