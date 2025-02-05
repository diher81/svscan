package nl.solevision.svscan.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CustomerDataDTO {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String preposition;
    private final LocalDateTime dateOfBirth;

    public CustomerDataDTO(String firstName, String lastName, String email, String preposition, LocalDateTime dateOfBirth) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.preposition = preposition;
        this.dateOfBirth = dateOfBirth;
    }


}
