package ru.cbr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class CbrClient {
    public static void main(String[] args) throws DatatypeConfigurationException {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();
        XMLGregorianCalendar onDate = getXMLGregorianCalendarNow();
        GetCursOnDateResponse.GetCursOnDateResult result = port.getCursOnDate(onDate);

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        System.out.println(gson.toJson(result.getAny().getRows()));

    }

    public static XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now =
                datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }
}
