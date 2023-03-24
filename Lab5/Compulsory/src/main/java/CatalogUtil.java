import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil  {
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(); ///serializare
        objectMapper.writeValue(new File(path), catalog);
    }
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;  ///deserealizarea
    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(doc.getLocation()));
    }

    public String toString(Catalog catalog) {
        return "Catalog{" +
                "name='" + catalog.getName() + '\'' +
                ", documents=" + catalog.getDocuments() +
                '}';
    }
}
