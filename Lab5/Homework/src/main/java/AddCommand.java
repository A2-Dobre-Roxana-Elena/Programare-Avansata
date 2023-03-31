
public class AddCommand extends Command{
    public AddCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String arg) throws CommandException {
        parseArguments(arg);
        if (arguments.get(0).equals("adauga") && arguments.get(1).equals("documentul") && arguments.size() == 5) {
            Document addItem = new Document(arguments.get(2), arguments.get(3), arguments.get(4));
            catalog.add(addItem);
        } else {
            throw new CommandException("Comanda de adaugare a fost introdusa gresit. Aveti grija sa respectati formatul.");
        }
    }
}
