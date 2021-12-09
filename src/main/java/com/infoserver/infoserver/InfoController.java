package com.infoserver.infoserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.infoserver.domain.AuthorizedVO;
import com.infoserver.domain.LogVO;
import com.infoserver.service.AuthorizedService;

@Controller
public class InfoController {

	@Inject
	private AuthorizedService service;
	
	@ResponseBody
	@RequestMapping(value = "/selectAuthorized") // 맴버 받아오기
	public Map<String, Object> selectAuthorized(HttpServletRequest request) {
		String id = request.getParameter("id");
        System.out.println(id+"들어옴");
		AuthorizedVO authorized = service.selectAutorizedById(id); // 1이면 아이디 존재
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("authorized", authorized);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkid") // 맴버 받아오기
	public Map<String, String> checkid(HttpServletRequest request) {
		String id = request.getParameter("id");
        System.out.println(id+"들어옴");
        
        Map<String, String> map = new HashMap<String, String>();

        System.out.println("ㅇㅇㅇㅇㅇㅇㅇ?");
        int idchk = service.checkAuthorizedById(id);
        
        if(idchk==1)
        	map.put("result", "0"); // 실패 시 result에 0을 담아 보냄
        else { // 일치하면 회원가입 후 result에 1을 담아 보냄
        	map.put("result", "1");
        }
        System.out.println("222222?");
        System.out.println(map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/register")
	public Map<String, Object> joinMember(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
        String position = request.getParameter("position");
        
        AuthorizedVO authorized = new AuthorizedVO();
        authorized.setId(id);
        authorized.setName(name);
        authorized.setPosition(position);
        
        System.out.println(authorized.toString());
        
        // 등록 전 아이디, 닉네임 2차 중복 검증, 둘 중 하나라도 1이면(존재하면) 가입 불가
        int idchk = service.checkAuthorizedById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(idchk==1)
        	map.put("result", "0"); // 실패 시 result에 0을 담아 보냄
        else { // 일치하면 회원가입 후 result에 1을 담아 보냄
        	service.insertAuthorized(authorized);
        	map.put("result", "1");
        }
		return map;
	}
	

	@ResponseBody
	@RequestMapping(value = "/insertLog")
	public Map<String, Object> insertLog(HttpServletRequest request) throws Exception{
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
        String picture = request.getParameter("picture");
        String allow = request.getParameter("allow");

        LogVO log = new LogVO();
        log.setUid(uid);
        log.setName(name);
        log.setPicture(picture);
        log.setAllow(allow);
        
        System.out.println(log.toString());
        
        Map<String, Object> map = new HashMap<String, Object>();
        service.insertLog(log);
        map.put("result", "1");
        
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLog") // 맴버 받아오기
	public String getLog(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();

        List<LogVO> loglist = service.getLog();
        
		return loglist.toString();
	}
}
