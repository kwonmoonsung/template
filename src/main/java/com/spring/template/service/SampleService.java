package com.spring.template.service;

import com.spring.template.VO.SampleVO;
import com.spring.template.controller.SampleController;

import java.util.List;

public interface SampleService {
    public List<SampleVO> getMemberList();

    public SampleVO getMember(int memberId);

    public int createMember(SampleVO member);

    public int updateMember(SampleVO member);

    public int deleteMember(int memberId);

}
