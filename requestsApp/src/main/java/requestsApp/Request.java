package requestsApp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;

    private final long contactId;
    private final long APPLICATION_ID;
    private final Calendar DT_CREATED ;
    private final String PRODUCT_NAME;

    public Request(){
        this.contactId = 0;
        this.APPLICATION_ID = 0;
        this.DT_CREATED = new GregorianCalendar(1970,1,1);
        this.PRODUCT_NAME = "";
    }
    public Request(long contactId, long APPLICATION_ID, Calendar DT_CREATED, String PRODUCT_NAME) {
        this.contactId = contactId;
        this.APPLICATION_ID = APPLICATION_ID;
        this.DT_CREATED = DT_CREATED;
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public long getContactId() {
        return contactId;
    }

    public long getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public Calendar getDT_CREATED() {
        return DT_CREATED;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    @Override
    public String toString() {
        return String.format(
                "Request [contactId=%d, applicationId=%d, date=%tc, productName='%s']",
                contactId, APPLICATION_ID, DT_CREATED, PRODUCT_NAME);
    }

}


