package aula09.ex2;

import java.util.ArrayList;
import java.util.List;

public class TesteCommands {

    public static void main(String args[]) {

        List<String> my_list = new ArrayList<>();
        CollectionCommand<String> my_add_command = new AddCommand<>(my_list);
        CollectionCommand<String> my_remove_command = new RemoveCommand<>(my_list);

        String adeus = "Adeus";

        my_add_command.execute("Ola");
        my_add_command.execute(adeus);
        my_remove_command.execute(adeus);
        my_remove_command.undo();

        System.out.println(my_list.toString());
    }
}
