package com.popovanton.testcase.parser;

import com.opencsv.*;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class DataImporter implements ApplicationRunner {

    JdbcTemplate jdbcTemplate;

    @Value("${import.filename}")
    private File fileName;

    public DataImporter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fillTable();
    }

    public boolean fillTable() throws IOException {

        String tableName = fileName.getName().substring(0, fileName.getName().indexOf("."));
        String tableStructure = "";
        String query = "";

        RFC4180Parser csvParser = new RFC4180ParserBuilder().withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).withQuoteChar('"').build();

        CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withCSVParser(csvParser)
                .withKeepCarriageReturn(true)
                .build();

        List<String[]> list = csvReader.readAll();
        Iterator<String[]> iterator = list.iterator();
        StringBuffer structureStringBuffer = new StringBuffer("");
        if (iterator.hasNext()) {
            Arrays.stream(iterator.next()).forEach(l -> structureStringBuffer.append(l).append(","));
            tableStructure = structureStringBuffer.deleteCharAt(structureStringBuffer.lastIndexOf(",")).toString();
        }

        while (iterator.hasNext()) {
            StringBuffer stringBuffer = new StringBuffer("");
            Arrays.stream(iterator.next()).forEach(l -> {
                l = "'" + l + "',";
                stringBuffer.append(l);
            });
            stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
            query = stringBuffer.toString();

            String fillQuery = "INSERT INTO " + tableName +
                        "("+tableStructure+")" + " VALUES "
                        + "(" + query + ");" ;
                jdbcTemplate.update(fillQuery);

        }

        return true;


    }

}
