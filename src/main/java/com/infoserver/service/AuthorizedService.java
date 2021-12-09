package com.infoserver.service;

import java.util.List;

import com.infoserver.domain.AuthorizedVO;
import com.infoserver.domain.LogVO;

public interface AuthorizedService {
	public int checkAuthorizedById(String id);
	public AuthorizedVO selectAutorizedById(String id);
	public void insertAuthorized(AuthorizedVO vo);
	public List<LogVO> getLog();
	public void insertLog(LogVO vo);
}
