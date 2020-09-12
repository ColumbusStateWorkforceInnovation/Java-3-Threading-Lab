package edu.cscc.transactions;

public interface ConvertTransaction {
    int EMPLOYEE_ID_IDX = 0;
    int CUSTOMER_ID_IDX = 1;
    int STORE_NUMBER_IDX = 2;
    int RENTAL_ID_IDX = 3;
    int RENTAL_NAME_IDX = 4;
    int RENTAL_COST_IDX = 5;
    int DATE_IDX = 6;

    static Transaction convert(String[] line) {
        Transaction transaction = new Transaction();
        transaction.setEmployeeId(line[EMPLOYEE_ID_IDX]);
        transaction.setCustomerId(line[CUSTOMER_ID_IDX]);
        transaction.setStoreNumber(line[STORE_NUMBER_IDX]);
        transaction.setRentalId(line[RENTAL_ID_IDX]);
        transaction.setRentalName(line[RENTAL_NAME_IDX]);
        transaction.setRentalCost(new Double(line[RENTAL_COST_IDX]));
        transaction.setDate(line[DATE_IDX]);

        return transaction;
    }
}