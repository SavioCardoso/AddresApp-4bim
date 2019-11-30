//@author Savio Cardoso, Marco Jakob

package Util;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    /**
     * Retorna uma a Data Local no formato parse 
     *
     * @param v
     * @return LocalDate
     * @throws java.lang.Exception
     */
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    /**
     * Retorna uma a Data Local no formato de texto
     *
     * @param v
     * @return LocalDate
     * @throws java.lang.Exception
     */
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}