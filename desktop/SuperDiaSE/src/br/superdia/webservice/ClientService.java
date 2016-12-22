
package br.superdia.webservice;

import java.util.List;
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
@WebService(name = "ClientService", targetNamespace = "http://webservice.superdia.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClientService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeProdutoCarrinho", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.RemoveProdutoCarrinho")
    @ResponseWrapper(localName = "removeProdutoCarrinhoResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.RemoveProdutoCarrinhoResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/removeProdutoCarrinhoRequest", output = "http://webservice.superdia.br/ClientService/removeProdutoCarrinhoResponse")
    public Boolean removeProdutoCarrinho(
        @WebParam(name = "arg0", targetNamespace = "")
        ItemVenda arg0);

    /**
     * 
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cleanCarrinho", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.CleanCarrinho")
    @ResponseWrapper(localName = "cleanCarrinhoResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.CleanCarrinhoResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/cleanCarrinhoRequest", output = "http://webservice.superdia.br/ClientService/cleanCarrinhoResponse")
    public Boolean cleanCarrinho();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "endsBuy", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.EndsBuy")
    @ResponseWrapper(localName = "endsBuyResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.EndsBuyResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/endsBuyRequest", output = "http://webservice.superdia.br/ClientService/endsBuyResponse")
    public Boolean endsBuy(
        @WebParam(name = "arg0", targetNamespace = "")
        Usuario arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addProdutoCarrinho", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.AddProdutoCarrinho")
    @ResponseWrapper(localName = "addProdutoCarrinhoResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.AddProdutoCarrinhoResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/addProdutoCarrinhoRequest", output = "http://webservice.superdia.br/ClientService/addProdutoCarrinhoResponse")
    public Boolean addProdutoCarrinho(
        @WebParam(name = "arg0", targetNamespace = "")
        ItemVenda arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.superdia.webservice.Produto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProdutos", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.GetProdutos")
    @ResponseWrapper(localName = "getProdutosResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.GetProdutosResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/getProdutosRequest", output = "http://webservice.superdia.br/ClientService/getProdutosResponse")
    public List<Produto> getProdutos();

    /**
     * 
     * @return
     *     returns java.util.List<br.superdia.webservice.ItemVenda>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarrinho", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.GetCarrinho")
    @ResponseWrapper(localName = "getCarrinhoResponse", targetNamespace = "http://webservice.superdia.br/", className = "br.superdia.webservice.GetCarrinhoResponse")
    @Action(input = "http://webservice.superdia.br/ClientService/getCarrinhoRequest", output = "http://webservice.superdia.br/ClientService/getCarrinhoResponse")
    public List<ItemVenda> getCarrinho();

}
