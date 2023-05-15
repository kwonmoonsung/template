package com.spring.template.dao;

import com.spring.template.VO.SampleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    SampleVO getMember(int memberId);
    List<SampleVO> getMemberList();

    int createMember(SampleVO member);

    int updateMember(SampleVO member);

    int deleteMember(int memberId);
}
