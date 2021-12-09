package com.infoserver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.infoserver.domain.AuthorizedVO;
import com.infoserver.domain.LogVO;
import com.infoserver.persistence.AuthorizedDAO;

@Service
public class AuthorizedServiceImpl implements AuthorizedService {


	@Inject
	private AuthorizedDAO dao;

	@Override
	public int checkAuthorizedById(String id) {
		return dao.checkAuthorizedById(id);
	}

	@Override
	public AuthorizedVO selectAutorizedById(String id) {
		return dao.selectAutorizedById(id);
	}
	
	@Override
	public void insertAuthorized(AuthorizedVO vo) {
		dao.insertAuthorized(vo);
	}

	@Override
	public List<LogVO> getLog() {
		return dao.getLog();
	}

	@Override
	public void insertLog(LogVO vo) {
		dao.insertLog(vo);
	}


}
