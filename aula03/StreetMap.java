package aula03;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class StreetMap{

    private List<TreeSet<Member>> doors;

    public StreetMap(){
        this.doors = new ArrayList<>();
    }

    public void add(Member new_member){

        int new_member_initial = new_member.getNum_initial(),
                new_member_final = new_member.getNum_final();

        increaseStreetSize(new_member_final);

        for(int door_index = new_member_initial; door_index < new_member_final + 1; door_index++){
            doors.get(door_index - 1).add(new_member);
        }
    }

    private void increaseStreetSize(int new_size){
        for(int door_index = doors.size(); door_index < new_size; door_index++)
            doors.add(new TreeSet(new MemberSetComparator()));
    }

    public List<TreeSet<Member>> getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "StreetMap{" +
                "doors=" + doors +
                '}';
    }
}
