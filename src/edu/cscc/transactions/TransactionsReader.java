package edu.cscc.transactions;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TransactionsReader implements Iterable<Transaction> {
    private final CSVParser csvParser;
    private final CSVReader csvReader;

    public TransactionsReader(FileReader fileReader) {
        csvParser = new CSVParserBuilder().withQuoteChar('"').withSeparator(',').build();
        csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();
    }

    public void close() throws IOException {
        csvReader.close();
    }

    @Override
    public Iterator<Transaction> iterator() {
        return new TransactionIterator(csvReader);
    }

    public class TransactionIterator implements Iterator {

        private CSVReader csvReader;

        public TransactionIterator(CSVReader csvReader) {
            this.csvReader = csvReader;
        }

        @Override
        public boolean hasNext() {
            try {
                return csvReader.peek() != null;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        public Transaction next() {
            try {
                return ConvertTransaction.convert(csvReader.readNext());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvValidationException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
