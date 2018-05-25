package ru.kapion.exrobot.utils.ws;

import org.springframework.stereotype.Component;
import ru.cbr.DailyInfo;
import ru.cbr.DailyInfoSoap;
import ru.cbr.EnumValutesResponse;
import ru.cbr.GetCursOnDateResponse;
import ru.cbr.custom_model.EnumValuteData;
import ru.cbr.custom_model.ValuteData;
import ru.kapion.exrobot.util.DateHelper;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import java.time.LocalDate;
import java.util.List;
@Component
public class CbrWrapper {
    protected static final String WSDL = "http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx?WSDL";
    private static volatile DailyInfoSoap service = null;
    private static final Object MONITOR = new Object();

    public CbrWrapper() {
        if (service == null) {
            synchronized (MONITOR) {
                if (service == null) {
                    service = (new DailyInfo()).getDailyInfoSoap();
                }
            }
        }
    }

    private synchronized DailyInfoSoap getPort() {
        DailyInfoSoap port = service;
        BindingProvider binding = (BindingProvider) port;
        binding.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 60000);
        binding.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 60000);
        return port;
    }

    public List<ValuteData.ValuteCursOnDate> getListRates(LocalDate date) throws DatatypeConfigurationException {
        XMLGregorianCalendar onDate = DateHelper.convertLocalDateToXMLGregorianCalendar(date);
        GetCursOnDateResponse.GetCursOnDateResult result = getPort().getCursOnDate(onDate);
        return  result.getAny().getRows();

    }

    public List<EnumValuteData.EnumValutes> getListValutes() {
        EnumValutesResponse.EnumValutesResult result = getPort().enumValutes(false);
        return  result.getAny().getRows();
    }

}
