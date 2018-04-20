package examples.boot.simpleboard.service;

import examples.boot.simpleboard.domain.Board;
import examples.boot.simpleboard.domain.User;

public interface BoardService {
    public Board getBoard(Long id);
    public Long getBoardCount();
    public Long getBoardCountByUserName(String userName);
}