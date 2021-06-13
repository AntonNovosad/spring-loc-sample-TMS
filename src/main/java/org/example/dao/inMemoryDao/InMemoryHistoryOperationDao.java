package org.example.dao.inMemoryDao;

import org.example.dao.HistoryOperationDao;
import org.example.entity.HistoryOperation;


import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryOperationDao implements HistoryOperationDao {
    private static List<HistoryOperation> historyOperationList = new ArrayList<>();
    private static HistoryOperationDao instance;

    public static HistoryOperationDao getInstance() {
        if (instance == null) {
            instance = new InMemoryHistoryOperationDao();
        }
        return instance;
    }

    @Override
    public void add(HistoryOperation operation) {
        historyOperationList.add(operation);
    }

    @Override
    public List<HistoryOperation> get() {
        return historyOperationList;
    }
}
