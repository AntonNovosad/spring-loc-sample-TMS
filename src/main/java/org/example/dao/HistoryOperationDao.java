package org.example.dao;

import org.example.entity.HistoryOperation;

import java.util.List;

public interface HistoryOperationDao {

    void add(HistoryOperation operation);
    List<HistoryOperation> get();
}
