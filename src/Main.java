import input.Database;
import input.DataRead;
import output.DataWrite;
import output.OutputClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import work.Consumatori;
import work.Distribuitori;
import work.Producatori;
import work.Simulator;


import java.io.File;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {

        byte[] jsonData = Files.readAllBytes(Paths.get(args[0]));
        ObjectMapper objectMapper = new ObjectMapper();
        Database database = objectMapper.readValue(jsonData, Database.class);


        DataRead dataInput = new DataRead();
        DataWrite dataWrite = new DataWrite();
        Simulator simulator = new Simulator();

        List<output.Distributors> distributors = new ArrayList<>();
        List<output.Consumers> consumers = new ArrayList<>();
        List<output.EnergyProducers> producers = new ArrayList<>();
        List<Consumatori> consumatori = new ArrayList<>();
        List<Distribuitori> distribuitori = new ArrayList<>();
        List<Producatori> producatori = new ArrayList<>();

        OutputClass outputClass = new OutputClass(consumers, distributors, producers);

        dataInput.readConsumers(database, consumatori);
        dataInput.readDistributors(database, distribuitori);
        dataInput.readProducers(database, producatori);

        simulator.run(database, consumatori, distribuitori, producatori);

        dataWrite.writeConsumers(consumatori, outputClass);
        dataWrite.writeDistributors(distribuitori, outputClass);
        dataWrite.writeProducers(producatori, outputClass);


        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(String.valueOf(Paths.get(args[1]))), outputClass);
    }
}
