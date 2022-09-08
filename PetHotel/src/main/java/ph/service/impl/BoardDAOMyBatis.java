package ph.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.BoardDAO;
import ph.service.BoardVO;

@Repository("boardDAOMyBatis")
public class BoardDAOMyBatis extends EgovAbstractMapper implements BoardDAO{

	@Override
	public void boardInsert(BoardVO boardVO) {
		insert("insertBoard",boardVO);
	}

	@Override
	public List<BoardVO> boardList(BoardVO boardVo) throws Exception {
		return selectList("boardList",boardVo);
	}

	@Override
	public BoardVO selectBoard(Integer boardNo) throws Exception {
		return selectOne("selectBoard",boardNo);
	}

}
