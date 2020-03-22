package lk.pathum.model;

import lombok.Data;

@Data
public class Transaction {
    Integer provider;
    Integer consumer;
    Float amount;
    String remarks;
}
