package aula03;

import java.util.Comparator;

public class MemberNameComparator implements Comparator<Member> {

    @Override
    public int compare(Member member1, Member member2) {
        return member1.getName().compareTo(member2.getName());
    }
}
