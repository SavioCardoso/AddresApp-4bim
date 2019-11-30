//@author Savio Cardoso, Marco Jakob

package Model;

import Util.LocalDateAdapter;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    
    @Id
    @Column(name = "CPF", unique = true)
    private final StringProperty CPF;
    
    @Column(name = "First_Name", nullable = false)
    private final StringProperty firstName;
    
    @Column(name = "Last_Name", nullable = false)
    private final StringProperty lastName;
    
    @Column(name = "Street", nullable = false)
    private final StringProperty street;
    
    @Column(name = "Postal_Code", nullable = false)
    private final IntegerProperty postalCode;
    
    @Column(name = "City", nullable = false)    
    private final StringProperty city;
    
    @Column(name = "Birthday", nullable = false)
    private final ObjectProperty<LocalDate> birthday;

    /**
     *  Construtor padrão.
     */
    public Person() {
        this(null, null);
    }
    
    /**
     * Construtor com alguns dados iniciais.
     * 
     * @param firstName Primeiro nome da Pessoa.
     * @param lastName Sobrenome da Pessoa.
     */
    public Person(String firstName, String lastName) {
        
        String CPFPart1 = Integer.toString((int)(Math.random()*(999999 -1) +1));
        String CPFPart2 = Integer.toString((int)(Math.random()*(99999 -1) + 1));
        StringBuilder CPFaux = new StringBuilder(CPFPart1);
            CPFaux.append(CPFPart2);
                
        this.CPF = new SimpleStringProperty(CPFaux.toString());
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        
        // Alguns dados de exemplo, apenas para testes.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(2000,
                (int) (Math.random() * (12 - 1) + 1), 
                (int) (Math.random() * (28 - 1) + 1)));
    }
    
    /**
     * Construtor com alguns dados iniciais.
     * 
     * @param CPF CPF da Pessoa.
     * @param firstName Primeiro nome da Pessoa.
     * @param lastName Sobrenome da Pessoa.
     */
    public Person(String CPF, String firstName, String lastName) {
        
        this.CPF = new SimpleStringProperty(CPF);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        
        // Alguns dados de exemplo, apenas para testes.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(2000,
                (int) (Math.random() * (12 - 1) + 1), 
                (int) (Math.random() * (28 - 1) + 1)));
    }
    
    /**
     * Construtor com todos os dados iniciais.
     * 
     * @param CPF CPF da Pessoa.
     * @param firstName Primeiro nome da Pessoa.
     * @param lastName Sobrenome da Pessoa.
     * @param street Rua que a Pessoa mora.
     * @param postalCode CEP do local que a Pessoa mora.
     * @param city Cidade na qual a Pessoa mora.
     * @param birthday Dia que a Pessoa nasceu.
     */

    public Person(String CPF, String firstName, String lastName, String street, 
                  int postalCode, String city, LocalDate birthday ) {
        
        this.CPF = new SimpleStringProperty(CPF);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.postalCode = new SimpleIntegerProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.birthday = new SimpleObjectProperty<>(birthday);
        
    }
    
    /**
     * Retorna o CPF.
     *
     * @return CPF
     */
    public String getCPF() {
        return CPF.get();
    }
    
    /**
     * Define o CPF.
     *
     * @param CPF
     */
    public void setCPF(String CPF) {
        this.CPF.set(CPF);
    }
    
    /**
     * Retorna o CPF como StringProperty.
     *
     * @return CPF
     */
    public StringProperty CPFProperty() {
        return CPF;
    }
    
    /**
     * Retorna o Primeiro Nome.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName.get();
    }
    
    /**
     * Define o Primeiro Nome.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    
    /**
     * Retorna o Primeiro Nome como StringProperty.
     *
     * @return firstName
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }
    
    /**
     * Retorna o Último Nome.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName.get();
    }
    
    /**
     * Define o Último Nome.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    
    /**
     * Retorna o Último Nome como StringProperty.
     *
     * @return firstName
     */
    public StringProperty lastNameProperty() {
        return lastName;
    }
    
    /**
     * Retorna a Rua.
     *
     * @return street
     */
    public String getStreet() {
        return street.get();
    }
    
    /**
     * Define a Rua.
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street.set(street);
    }
    
    /**
     * Retorna a Rua como StringProperty.
     *
     * @return street
     */
    public StringProperty streetProperty() {
        return street;
    }
    
    /**
     * Retorna o CEP.
     *
     * @return postalCode
     */
    public int getPostalCode() {
        return postalCode.get();
    }
    
    /**
     * Define o CEP.
     *
     * @param postalCode
     */
    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }
    
    /**
     * Retorna o CEP como IntegerProperty.
     *
     * @return postalCode
     */
    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }
    
    /**
     * Retorna a Cidade.
     *
     * @return city
     */
    public String getCity() {
        return city.get();
    }
    
    /**
     * Define a Cidade.
     *
     * @param city
     */
    public void setCity(String city) {
        this.city.set(city);
    }
    
    /**
     * Retorna a Cidade como StringProperty.
     *
     * @return city
     */
    public StringProperty cityProperty() {
        return city;
    }
    
    /**
     * Retorna a Data de Aniversário.
     *
     * @return firstName
     */
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }
    
    /**
     * Define a Data de Aniversário.
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    
    /**
     * Retorna a Data de Aniversário como ObjectProperty.
     *
     * @return firstName
     */
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}