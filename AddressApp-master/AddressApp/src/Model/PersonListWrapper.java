//@author Savio Cardoso, Marco Jakob

package Model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private List<Person> persons;

    /**
     * Retorna uma Lista de Pessoas.
     *
     * @return persons
     */
    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * Define uma Lista de Pessoas.
     *
     * @param persons
     */
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}