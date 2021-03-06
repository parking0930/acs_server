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
	@RequestMapping(value = "/selectAuthorized") // 孤獄 閤焼神奄
	public Map<String, Object> selectAuthorized(HttpServletRequest request) {
		String id = request.getParameter("id");
        System.out.println(id+"級嬢身");
		AuthorizedVO authorized = service.selectAutorizedById(id); // 1戚檎 焼戚巨 糎仙
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("authorized", authorized);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkid") // 孤獄 閤焼神奄
	public Map<String, String> checkid(HttpServletRequest request) {
		String id = request.getParameter("id");
        System.out.println(id+"級嬢身");
        
        Map<String, String> map = new HashMap<String, String>();

        System.out.println("ししししししし?");
        int idchk = service.checkAuthorizedById(id);
        
        if(idchk==1)
        	map.put("result", "0"); // 叔鳶 獣 result拭 0聖 眼焼 左蛙
        else { // 析帖馬檎 噺据亜脊 板 result拭 1聖 眼焼 左蛙
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
        
        // 去系 穿 焼戚巨, 莞革績 2託 掻差 伊装, 却 掻 馬蟹虞亀 1戚檎(糎仙馬檎) 亜脊 災亜
        int idchk = service.checkAuthorizedById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(idchk==1)
        	map.put("result", "0"); // 叔鳶 獣 result拭 0聖 眼焼 左蛙
        else { // 析帖馬檎 噺据亜脊 板 result拭 1聖 眼焼 左蛙
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
	@RequestMapping(value = "/getLog") // 孤獄 閤焼神奄
	public String getLog(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();

        List<LogVO> loglist = service.getLog();
        
		return loglist.toString();
	}
}
