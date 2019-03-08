package aula03;

import java.util.Set;
import java.util.TreeSet;

public class lab3 {

    public static void main(String args[]){
        Set<Member> members = new TreeSet<>(new MemberSetComparator());
        members.add(Member.factory("ola", 9, 12));
        members.add(Member.factory("adeus", 10, 17));
        System.out.println(members.toString());
    }

}
