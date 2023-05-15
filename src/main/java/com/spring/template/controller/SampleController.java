package com.spring.template.controller;

import com.spring.template.VO.SampleVO;
import com.spring.template.service.SampleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @GetMapping("sample_memberList")
    @ResponseBody
    public List<SampleVO> getMemberList() {
        log.info("SampleController.getMemberList");
        List<SampleVO> memberList = sampleService.getMemberList();
        log.info("memberList = {}", memberList);
        return memberList;
    }

    @GetMapping("sample_member")
    @ResponseBody
    public SampleVO getMember(String memberId) {
        log.info("SampleController.getMember");
        SampleVO member = sampleService.getMember(Integer.parseInt(memberId));
        if (member == null) {
            log.info("member id find!");
        }
        return member;
    }

    @GetMapping("put_member")
    @ResponseBody
    public SampleVO putMember(SampleVO sampleVO) {
        log.info("id = {}", sampleVO.getMemberId());
        log.info("userName = {}", sampleVO.getUserName());
        int member = sampleService.createMember(sampleVO);
        return sampleVO;
    }

    @GetMapping("update_member")
    @ResponseBody
    public SampleVO updateMember(SampleVO sampleVO) {
        log.info("id = {}", sampleVO.getMemberId());
        log.info("userName = {}", sampleVO.getUserName());
        int member = sampleService.updateMember(sampleVO);
        return sampleVO;
    }

    @GetMapping("delete_member")
    @ResponseBody
    public int deleteMember(String memberId) {
        log.info("id = {}", memberId);
        int member = sampleService.deleteMember(Integer.parseInt(memberId));
        return member;
    }

    @GetMapping("sample_jsp")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("request = {}", request.getRequestURL());
        log.info("request pram = {}", request.getParameter("memberId"));
        model.addAttribute("memberId", request.getParameter("memberId"));
        return "jsp/sample";
    }



}
