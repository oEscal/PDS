package aula03;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class lab3 {

    static boolean poh_crl = false;

    public static void main(String args[]){

        StreetMap street_test = new StreetMap();
        street_test.add(Member.factory("mikey", 4, 7));
        street_test.add(Member.factory("falB", 5, 6));
        street_test.add(Member.factory("nola", 10, 12));
        street_test.add(Member.factory("mikey@ua.pt", 11, 14));
        street_test.add(Member.factory("rui", 10, 17));


        List<TreeSet<Member>> map_doors = street_test.getDoors();
        map(map_doors);

    }

    private static void map(List<TreeSet<Member>> map_doors){

        List<Member> current_line_struct = new ArrayList<>();
        for (int door_index = 0; door_index < map_doors.size(); door_index++) {

            System.out.print(door_index + 1 + " ");

            // verify if last members remains in current door
            for(int member_index = current_line_struct.size() - 1; member_index >= 0 ; member_index--){
                if(!contains(map_doors.get(door_index), current_line_struct.get(member_index)))
                    current_line_struct.remove(member_index);
                else
                    break;
            }

            // add new elements to the current door
            for(Member member : map_doors.get(door_index))
                if(!current_line_struct.contains(member))
                    current_line_struct.add(member);


            for (Member member : current_line_struct) {
                if(contains(map_doors.get(door_index), member))
                    System.out.print(": " + member.getName());
                else
                    System.out.printf("  " + generateWhiteString(member.getName().length()));
            }
            System.out.println();
        }
    }

    private static boolean contains(TreeSet<Member> set, Member member_to_check){
        AtomicBoolean result = new AtomicBoolean(false);
        set.forEach(item -> {
            if(item.equals(member_to_check))
                result.set(true);
        });
        return result.get();
    }

    private static String generateWhiteString(int size){
        String result = "";
        for(int n = 0; n < size; n++)
            result += " ";
        return result;
    }

}
