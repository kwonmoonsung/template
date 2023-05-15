package com.spring.template.service;

import com.spring.template.VO.SampleVO;
import com.spring.template.controller.SampleController;
import com.spring.template.dao.SampleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class SampleServiceImpl implements SampleService {

    private SampleMapper sampleMapper;

    public SampleServiceImpl(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    public List<SampleVO> getMemberList() {return this.sampleMapper.getMemberList();}

    public SampleVO getMember(int memberId) { return this.sampleMapper.getMember(memberId); }

    public int createMember(SampleVO member) { return this.sampleMapper.createMember(member); }

    public int updateMember(SampleVO member) { return this.sampleMapper.updateMember(member); }

    public int deleteMember(int memberId) { return this.sampleMapper.deleteMember(memberId); }
}
