//package cteam.cteamproject.domain.member.memberRepository;
//
//import cteam.cteamproject.domain.member.Member;
//import cteam.cteamproject.domain.member.Position;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class MemoryMemberRepositoryTest {
//
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
//
//    @AfterEach
//    void afterEach() {
//        memoryMemberRepository.clearStore();
//    }
//
//    @Test
//    void save() {
//        //given
//        Member member = new Member("userA", Position.BackEnd, new ArrayList<>());
//        //when
//        Member savedMember = memoryMemberRepository.save(member);
//        //then
//        assertThat(member).isEqualTo(savedMember);
//    }
//
//    @Test
//    void delete() {
//        //given
//        Member member = new Member("userA", Position.BackEnd, new ArrayList<>());
//        memoryMemberRepository.save(member);
//        //when
//        memoryMemberRepository.delete(member.getId());
//        //then
//        Optional<Member> optionalMember = memoryMemberRepository.findById(member.getId());
//        assertThat(optionalMember.isEmpty()).isEqualTo(true);
//    }
//
//    @Test
//    void update() {
//        //given
//        Member member1 = new Member("userA", Position.BackEnd, new ArrayList<>());
//        Member member2 = new Member("userB", Position.FrontEnd, new ArrayList<>());
//        memoryMemberRepository.save(member1);
//        //when
//        memoryMemberRepository.update(member1.getId(), member2);
//        //then
//        assertThat(member1.getUserName()).isEqualTo(member2.getUserName());
//    }
//
//    @Test
//    void findByName() {
//        //given
//        Member member = new Member("userA", Position.BackEnd, new ArrayList<>());
//        memoryMemberRepository.save(member);
//        //when
//        Optional<Member> optionalMember = memoryMemberRepository.findByName(member.getUserName());
//        //then
//        Member result = optionalMember.orElseThrow();
//        assertThat(result.getUserName()).isEqualTo(member.getUserName());
//    }
//
//    @Test
//    void findAll() {
//        //given
//        Member member1 = new Member("userA", Position.BackEnd, new ArrayList<>());
//        Member member2 = new Member("userB", Position.FrontEnd, new ArrayList<>());
//        memoryMemberRepository.save(member1);
//        memoryMemberRepository.save(member2);
//        //when
//        List<Member> members = memoryMemberRepository.findAll();
//        //then
//        assertThat(members.size()).isEqualTo(2);
//        assertThat(members).contains(member1, member2);
//    }
//}