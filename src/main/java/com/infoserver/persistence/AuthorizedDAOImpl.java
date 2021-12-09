package com.infoserver.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.infoserver.domain.AuthorizedVO;
import com.infoserver.domain.LogVO;

@Repository
public class AuthorizedDAOImpl implements AuthorizedDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.infoserver.mapper.AutorizedMapper";

	@Override
	public int checkAuthorizedById(String id) {
		return sqlSession.selectOne(namespace+".checkAuthorizedById", id);
	}
	
	@Override
	public AuthorizedVO selectAutorizedById(String id) {
		return sqlSession.selectOne(namespace+".selectAutorizedById", id);
	}

	@Override
	public void insertAuthorized(AuthorizedVO vo) {
		sqlSession.insert(namespace+".insertAuthorized", vo);
	}

	@Override
	public List<LogVO> getLog() {
		return sqlSession.selectList(namespace + ".getLog");
	}

	@Override
	public void insertLog(LogVO vo) {
		sqlSession.insert(namespace+".insertLog", vo);
	}


}
