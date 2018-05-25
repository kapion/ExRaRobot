package ru.kapion.exrobot.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class DateHelper {
    public static XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now =
                datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }

    public static XMLGregorianCalendar convertLocalDateToXMLGregorianCalendar(LocalDate date) throws DatatypeConfigurationException{
        XMLGregorianCalendar xmlDate = getXMLGregorianCalendarNow();
        XMLGregorianCalendar onDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
        xmlDate.setDay(onDate.getDay());
        xmlDate.setMonth(onDate.getMonth());
        xmlDate.setYear(onDate.getYear());
        return xmlDate;
    }
}
