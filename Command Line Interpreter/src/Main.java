import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Directory> nameVsDirectory = new HashMap<>();
        Directory rootDirectory = new Directory("root");
        Directory presentDirectory = new Directory(rootDirectory.getPresentWorkingFolder());
        nameVsDirectory.put(rootDirectory.getPresentWorkingFolder(),rootDirectory);

        while(true)
        {
            System.out.print("C:"+presentDirectory.getPresentWorkingFolder()+"\\");
            String fullCommand = scanner.nextLine();
            String[]  commandArray = fullCommand.split(" ");
            String commandName;
            String name = "";
            if(commandArray.length>1) {
                commandName = commandArray[0];
                name = commandArray[1];
            }
            else
            {
                commandName = commandArray[0];
            }
            switch (commandName)
            {
                case "pwd":
                    System.out.println("C:"+presentDirectory.getPresentWorkingFolder());
                    break;
                case "mkdir":
                    Directory newDirectory = new Directory(name);
                    nameVsDirectory.put(name,newDirectory);
                    presentDirectory.childFolder.add(name);
                    System.out.println("New direcotry created "+name);
                    System.out.println(nameVsDirectory.toString());
                    System.out.println(presentDirectory.childFolder.toString());
                    break;
                case "ls":
                    System.out.println(presentDirectory.childFolder.toString());
                    break;
                case "cd":
                    if(presentDirectory.childFolder.contains(name))
                    {
                        presentDirectory = nameVsDirectory.get(name);
                    }
                    else
                    {
                        System.out.println("No such direcotry found");
                    }
                    break;

                default:
                    System.out.println("Invalid Command");

            }
        }

    }
}
