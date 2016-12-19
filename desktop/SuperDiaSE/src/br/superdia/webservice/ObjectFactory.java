
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

    private final static QName _ObtemUsuario_QNAME = new QName("http://webservice.superdia.br/", "obtemUsuario");
    private final static QName _ObtemUsuarioResponse_QNAME = new QName("http://webservice.superdia.br/", "obtemUsuarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.superdia.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtemUsuario }
     * 
     */
    public ObtemUsuario createObtemUsuario() {
        return new ObtemUsuario();
    }

    /**
     * Create an instance of {@link ObtemUsuarioResponse }
     * 
     */
    public ObtemUsuarioResponse createObtemUsuarioResponse() {
        return new ObtemUsuarioResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtemUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "obtemUsuario")
    public JAXBElement<ObtemUsuario> createObtemUsuario(ObtemUsuario value) {
        return new JAXBElement<ObtemUsuario>(_ObtemUsuario_QNAME, ObtemUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtemUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "obtemUsuarioResponse")
    public JAXBElement<ObtemUsuarioResponse> createObtemUsuarioResponse(ObtemUsuarioResponse value) {
        return new JAXBElement<ObtemUsuarioResponse>(_ObtemUsuarioResponse_QNAME, ObtemUsuarioResponse.class, null, value);
    }

}
