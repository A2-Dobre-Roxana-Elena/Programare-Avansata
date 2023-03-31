import java.io.IOException;

public class ListCommand extends Command{
    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        System.out.println("Documentele catalogului sunt:");
        if (arguments.get(0).equals("lista") && arguments.get(1).equals("documentelor") && arguments.size() == 2) {
            for (Document i : catalog.getDocuments()) {
                System.out.println(i);
            }
        } else {
            throw new CommandException("Comanda de a lista documentele a fost introdusa gresit. Aveti grija sa respectati formatul.");
        }
    }
}
