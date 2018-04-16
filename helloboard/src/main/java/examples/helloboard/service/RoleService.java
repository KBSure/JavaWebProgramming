package examples.helloboard.service;

import examples.helloboard.domain.Role;

import java.util.List;

// Controller의 메소드를 구하면서, 각 컨틀롤러의 메소드안에서
// 어떤 로직이 수행되는지를 고민했다면 자연스럽게 메소드가 도출된다.
// 서비스가 가지고 있는 메소드를 비지니스 메소드라고 하고,
// 트랜잭션단위로 동작한다.
public interface RoleService {
    public List<Role> getRoles();
    public Role getRole(int roleId);
    public int addRole(Role role);
    public int deleteRole(int roleId);
    public int updateRole(Role role);
}

// service 가 가지고 있는 메소드를 비지니스메소드라고 한다.
// 게시판의 경우 boardId에 해당하는 게시물을 조회한다.
// url : localhost:8080/read?boardId=5
// 5번에 해당하는 게시물을 읽어온다.
// 5번에 해당하는 게시물의 조회수를 증가한다.
// 위의 기능이 하나라도 실패하면 전부 실패다.
// 위의 두가지 기능은 모두 성공해야한다. 이경우 하나의 트랜잭션이라고 한다.
// Board getBoard(long boardId) <-- service가 가지고 있는 메소드
//          ----> BoardDao의 selectBoard
//                BoardDao의 updateBoardCount

// 트랜잭션 레벨
// 5번 정보를 읽어들인후, 5번 정보를 수정하고, 5번정보를 이용하여 6번데이터를 수정한다.
// 5번 정보를 읽어들인후 .....
