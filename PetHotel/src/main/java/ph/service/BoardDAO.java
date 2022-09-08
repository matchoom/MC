package ph.service;

import java.util.List;

public interface BoardDAO {
	
	void boardInsert(BoardVO boardVO);
	
	List<BoardVO> boardList(BoardVO boardVo) throws Exception;
	
	BoardVO selectBoard(Integer boardNo) throws Exception;
	
	
	

}
