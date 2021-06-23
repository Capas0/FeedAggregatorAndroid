package ru.hse.edu.srzhuchkov;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class WebServiceClient {

    static String DOMAIN_RELEASE = "192.168.43.131:1986";
    static String DOMAIN_DEVELOP = "localhost:1986/";
    public static final String NAMESPACE = "http://for_mobile/";
    public static String URL = "http://" + DOMAIN_RELEASE + "/FeedRetrieveWSService?WSDL";
    public static final String METHOD_NAME = "retrieveFeeds";
    public static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;

    public static ArrayList<Feed> retrieveFeeds() {
        ArrayList<Feed> feeds = new ArrayList<>();
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject resultsRequestSOAP = (SoapObject) envelope.getResponse();

            if (resultsRequestSOAP == null) {
                return null;
            }

            SoapObject soQuestionContaner = (SoapObject) resultsRequestSOAP.getProperty("feeds");
            int countQuestions = soQuestionContaner.getPropertyCount();
            String title;
            String description;
            String link;
            String source;
            for (int i = 0; i < countQuestions; i++) {
                SoapObject soQuestionStub = (SoapObject) soQuestionContaner.getProperty(i);
                title = soQuestionStub.getPropertyAsString("title");
                description = soQuestionStub.getPropertyAsString("description");
                link = soQuestionStub.getPropertyAsString("link");
                source = soQuestionStub.getPropertyAsString("source");
                feeds.add(new Feed(title, description, link, source));
            }
            return feeds;

        } catch (Exception e) {
            return null;
        }
    }
}