package study.datajpa.repository;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

public class MemberSpec {
    // 람다로 변환
    public static Specification<Member> teamName(final String teamName) {
        return (root, query, criteriaBuilder) -> {

            if(StringUtils.isEmpty(teamName)){
                return null;
            }
            Join<Member, Team> t = root.join("team", JoinType.INNER);
            return criteriaBuilder.equal(t.get("name"), teamName);
        };
    }

    public static Specification<Member> username(final String username) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("username"), username);
    };
}
