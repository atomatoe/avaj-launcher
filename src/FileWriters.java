import java.io.IOException;

public class FileWriters {
    private String text;
    private static FileWriters instance;

    private FileWriters() {
        this.text = "";
    }

    public static FileWriters getInstance() {
        if(instance == null) {
            instance = new FileWriters();
        }
        return instance;
    }

    public void add_text(String text) {
        this.text += text + "\n";
    }

    public void print_text() {
        System.out.println(text);
    }

    public void write_in_file() {
        try(java.io.FileWriter writer = new java.io.FileWriter("simulation.txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
