import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CommandException, IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("Documentele-Mele");
        var document1 = new Document("document1","Primul-Document","C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogAdd.json");
        var document2 = new Document("document2","Al-Doilea-Document", "C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogAdd.json");
        catalog.add(document1);
        catalog.add(document2);
        System.out.println(catalog);

        AddCommand addCommand = new AddCommand(catalog);
        addCommand.execute("adauga documentul document3 Al-Treilea-Document C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogAdd.json");
        System.out.println(catalog);
//          addCommand.execute("adaga documentul document3 Al-Treilea-Document C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogAdd.json");


        SaveCommand saveCommand = new SaveCommand(catalog);
        saveCommand.execute("salveaza catalogul C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogSave");
//        saveCommand.execute("salveaza catalog C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogSave");

        ListCommand listCommand = new ListCommand(catalog);
        listCommand.execute("lista documentelor");

        try {
            LoadCommand loadCommand = new LoadCommand(catalog);
            loadCommand.execute("incarca documentele C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Homework/catalogSave");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ViewCommand viewCommand = new ViewCommand(catalog);
        viewCommand.execute("deschidere document document1");
    }
}