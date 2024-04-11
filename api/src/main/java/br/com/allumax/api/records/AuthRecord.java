package br.com.allumax.api.records;

public record AuthRecord(
    Integer id,    
    String username,
    Object authorities,
    String token
    ) {

}
