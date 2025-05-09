package Main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mine.java.test.main.json.PersonaJson;
import org.bson.Document;

import java.math.BigDecimal;

public class MongoDBExampleCloud {
    private static final String MONGO_URI = "mongodb+srv://xeyewal413:68Dh9bXsBQPPZani@bd3cluster.857gz.mongodb.net/?retryWrites=true&w=majority&appName=BD3Cluster";
    private static final String DBNAME = "BD3";
    private static final String COL_TEST = "test";
    private static final String COL_PERSONE = "persone";
    private static final String COL_ASSENZE = "assenze";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DBNAME);
            MongoCollection<org.bson.Document> collection = database.getCollection(COL_TEST);
            Document doc = collection.find().first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
            PersonaJson personaJson = new PersonaJson();
            personaJson.setId(1);
            personaJson.setNome("Nikola");
            personaJson.setCognome("Tesla");
            personaJson.setPosizione("ricercatore");
            personaJson.setStipendio(new BigDecimal(40000));
            insertPersona(database, personaJson);
        }
    }

    private static void insertPersona(MongoDatabase database, PersonaJson personaJson) {
        MongoCollection<org.bson.Document> colPersone = database.getCollection(COL_PERSONE);
        Document persona = new Document("id", personaJson.getId())
                .append("nome", personaJson.getNome())
                .append("cognome", personaJson.getCognome())
                .append("stipendio", personaJson.getStipendio())
                .append("posizione", personaJson.getPosizione());
        colPersone.insertOne(persona);
    }
}