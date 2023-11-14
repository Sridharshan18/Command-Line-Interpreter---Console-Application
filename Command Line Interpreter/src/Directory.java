import java.util.ArrayList;
public class Directory {

    private String presentWorkingFolder;

    ArrayList<String> childFolder = new ArrayList<>();

    Directory(String presentWorkingFolder)
    {
        this.presentWorkingFolder = presentWorkingFolder;
    }

    public String getPresentWorkingFolder()
    {
        return this.presentWorkingFolder;
    }
}

