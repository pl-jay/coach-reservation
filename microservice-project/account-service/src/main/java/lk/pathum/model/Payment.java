package lk.pathum.model;

import lombok.Data;

@Data
public class Payment {

    Integer id;
    Float amount;
    String remarks;
    Integer sender;
    Integer reciever;
}
