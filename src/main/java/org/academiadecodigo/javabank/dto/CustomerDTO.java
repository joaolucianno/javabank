package org.academiadecodigo.javabank.dto;

import javax.validation.constraints.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerDTO {
    //Fields
    private Integer id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "phone has invalid characters")
    private String phone;

    private List<AccountDTO> accountDTOList = new LinkedList<>();

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<AccountDTO> getAccountDTOList() {
        return accountDTOList;
    }


}
