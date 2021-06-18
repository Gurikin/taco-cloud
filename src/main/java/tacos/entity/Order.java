package tacos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Taco_Order")
public class Order extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank(message = "Street is required")
    @Column(name = "street", nullable = false)
    private String street;
    @NotBlank(message = "City is required")
    @Column(name = "city", nullable = false)
    private String city;
    @NotBlank(message = "State is required")
    @Length(max = 2)
    @Column(name = "state", nullable = false)
    private String state;
    @NotBlank(message = "Zip is required")
    @Column(name = "zip", nullable = false)
    private String zip;
    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(name = "ccNumber", nullable = false)
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    @Column(name = "ccExpiration", nullable = false)
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "ccCVV", nullable = false)
    private String ccCVV;
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    @ManyToOne(targetEntity = User.class)
    private User user;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
