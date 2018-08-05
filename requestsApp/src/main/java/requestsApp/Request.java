package requestsApp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.OffsetDateTime;


@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("CONTACT_ID")
    private long contactId;

    @JsonProperty("APPLICATION_ID")
    private long applicationId;

    @JsonProperty("DT_CREATED")
    private OffsetDateTime dtCreated;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    public Request(){}

    public Request(long contactId, long applicationId, OffsetDateTime dtCreated, String productName) {
        this.contactId = contactId;
        this.applicationId = applicationId;
        this.dtCreated = dtCreated;
        this.productName = productName;
    }


    public long getContactId() {
        return contactId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public OffsetDateTime getDtCreated() {
        return dtCreated;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return String.format(
                "Request [contactId=%d, applicationId=%d, date=%tc, productName='%s']",
                contactId, applicationId, dtCreated, productName);
    }

}


