package ru.cbr;

import ru.kapion.exrobot.util.DateHelper;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;

public class DateHelperTest {
    public static void main(String[] args) throws DatatypeConfigurationException {

        System.out.println(DateHelper.convertLocalDateToXMLGregorianCalendar(LocalDate.now()));
    }
}
