
package br.superdia.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ValidateCard", targetNamespace = "http://webservice.superdia.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ValidateCard {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validaCartao", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.ValidaCartao")
    @ResponseWrapper(localName = "validaCartaoResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.ValidaCartaoResponse")
    @Action(input = "http://webservice.superdia.br/ValidateCard/validaCartaoRequest", output = "http://webservice.superdia.br/ValidateCard/validaCartaoResponse")
    public Boolean validaCartao(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
