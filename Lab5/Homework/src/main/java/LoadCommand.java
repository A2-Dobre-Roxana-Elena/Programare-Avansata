import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command{
    public LoadCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.get(0).equals("incarca") && arguments.get(1).equals("documentele") && arguments.size() == 3) {
            ObjectMapper objectMapper = new ObjectMapper();
            setCatalog(objectMapper.readValue(new File(arguments.get(2)), Catalog.class));
            System.out.println("S-a incarcat catalogul urmator:" + catalog.toString());
        } else {
            throw new CommandException("Comanda pentru a lista documentele a fost introdusa gresit. Aveti grija sa respectati formatul.");
        }
    }


}
