package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryOperation {
    private double x;
    private double y;
    private double result;
    private String operation;
    private User user;
}
