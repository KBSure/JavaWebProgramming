package examples.helloboard.domain;

import lombok.*;

// lombok 제공하는 애노테이션입니다. 관련된 부분이 오류나면 intelliJ lombok 검색하면 셋팅하는 방법나온다.
// 컴파일전에 자동으로 코드를 생성한다.
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int roleId;
    private String description;
}
