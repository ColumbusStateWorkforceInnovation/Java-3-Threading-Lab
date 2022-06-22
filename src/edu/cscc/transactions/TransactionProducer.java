package edu.cscc.transactions;

public class TransactionProducer {

    private TransactionsReader transactionsReader;
    private TransactionsReader.TransactionIterator iterator;

    public TransactionProducer(TransactionsReader transactionsReader) {
        this.transactionsReader = transactionsReader;
        iterator = (TransactionsReader.TransactionIterator) this.transactionsReader.iterator();
    }

    public synchronized Transaction peek() {
        return iterator.peek();
    }

    public synchronized boolean hasNext() {
        return peek() != null;
    }

    public synchronized Transaction next() {
        Transaction transaction = iterator.next();
        if (transaction != null) {
            return transaction;
        }

        return null;
    }
}
