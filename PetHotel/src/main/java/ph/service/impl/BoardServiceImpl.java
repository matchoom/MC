package ph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.service.BoardDAO;
import ph.service.BoardService;
import ph.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name = "boardDAOMyBatis")
	private BoardDAO boardDAO;

	@Override
	public void boardInsert(BoardVO boardVO) {
		boardDAO.boardInsert(boardVO);
	}

	@Override
	public List<BoardVO> boardList(BoardVO boardVo) throws Exception {
		return boardDAO.boardList(boardVo);
	}

	@Override
	public BoardVO selectBoard(Integer boardNo) throws Exception {
		return boardDAO.selectBoard(boardNo);
	}

}
