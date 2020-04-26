package lk.pathum.account.model;

import lombok.Data;

@Data
public class Payment {

    Integer id;
    Float amount;
    String remarks;
    Integer sender;
    Integer reciever;
}
