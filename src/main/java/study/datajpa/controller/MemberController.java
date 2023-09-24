package study.datajpa.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    /**
     * 일반적인 회원 조회
     * @param id
     * @return
     */
    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    /**
     * 도메인 클래스 컨버터를 통한 호원 조회
     * 설명: HTTP 요청은 회원 id 를 받지만 도메인 클래스 컨버터가 중간에 동작하여 회원 객체를 반환 (위와 동일)
     * !!!주의: 조회용으로만 사용할것!!! (값을 변경해야 하거나 복잡할 경우 사용하지 않는것을 권장)
     * @param member
     * @return
     */
    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @PostConstruct
    public void init(){
        memberRepository.save(new Member("userA"));
    }
}
