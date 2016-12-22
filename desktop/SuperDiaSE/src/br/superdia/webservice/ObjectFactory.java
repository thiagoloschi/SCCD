
package br.superdia.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.superdia.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidaCartaoResponse_QNAME = new QName("http://webservice.superdia.br/", "validaCartaoResponse");
    private final static QName _ValidaCartao_QNAME = new QName("http://webservice.superdia.br/", "validaCartao");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.superdia.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidaCartaoResponse }
     * 
     */
    public ValidaCartaoResponse createValidaCartaoResponse() {
        return new ValidaCartaoResponse();
    }

    /**
     * Create an instance of {@link ValidaCartao }
     * 
     */
    public ValidaCartao createValidaCartao() {
        return new ValidaCartao();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCartaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "validaCartaoResponse")
    public JAXBElement<ValidaCartaoResponse> createValidaCartaoResponse(ValidaCartaoResponse value) {
        return new JAXBElement<ValidaCartaoResponse>(_ValidaCartaoResponse_QNAME, ValidaCartaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCartao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "validaCartao")
    public JAXBElement<ValidaCartao> createValidaCartao(ValidaCartao value) {
        return new JAXBElement<ValidaCartao>(_ValidaCartao_QNAME, ValidaCartao.class, null, value);
    }

}
