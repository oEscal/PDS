package aula03;

import java.util.Comparator;

public class MemberSetComparator implements Comparator<Member> {

    @Override
    public int compare(Member member1, Member member2) {
        int member1_initial = member1.getNum_initial(),
                member2_initial = member2.getNum_initial(),
                member1_final = member1.getNum_final(),
                member2_final = member2.getNum_final();

        if(member1_initial == member2_initial)
            return (member2_final != member1_final) ? (member2_final - member1_final) : 1;
        return member1_initial - member2_initial;
    }
}
