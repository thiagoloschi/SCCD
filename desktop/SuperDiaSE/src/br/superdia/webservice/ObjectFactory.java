
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

    private final static QName _CleanCarrinhoResponse_QNAME = new QName("http://webservice.superdia.br/", "cleanCarrinhoResponse");
    private final static QName _Venda_QNAME = new QName("http://webservice.superdia.br/", "venda");
    private final static QName _GetProdutos_QNAME = new QName("http://webservice.superdia.br/", "getProdutos");
    private final static QName _GetCarrinhoResponse_QNAME = new QName("http://webservice.superdia.br/", "getCarrinhoResponse");
    private final static QName _Produto_QNAME = new QName("http://webservice.superdia.br/", "produto");
    private final static QName _RemoveProdutoCarrinho_QNAME = new QName("http://webservice.superdia.br/", "removeProdutoCarrinho");
    private final static QName _GetCarrinho_QNAME = new QName("http://webservice.superdia.br/", "getCarrinho");
    private final static QName _AddProdutoCarrinho_QNAME = new QName("http://webservice.superdia.br/", "addProdutoCarrinho");
    private final static QName _EndsBuy_QNAME = new QName("http://webservice.superdia.br/", "endsBuy");
    private final static QName _AddProdutoCarrinhoResponse_QNAME = new QName("http://webservice.superdia.br/", "addProdutoCarrinhoResponse");
    private final static QName _CleanCarrinho_QNAME = new QName("http://webservice.superdia.br/", "cleanCarrinho");
    private final static QName _GetProdutosResponse_QNAME = new QName("http://webservice.superdia.br/", "getProdutosResponse");
    private final static QName _EndsBuyResponse_QNAME = new QName("http://webservice.superdia.br/", "endsBuyResponse");
    private final static QName _RemoveProdutoCarrinhoResponse_QNAME = new QName("http://webservice.superdia.br/", "removeProdutoCarrinhoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.superdia.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProdutosResponse }
     * 
     */
    public GetProdutosResponse createGetProdutosResponse() {
        return new GetProdutosResponse();
    }

    /**
     * Create an instance of {@link EndsBuyResponse }
     * 
     */
    public EndsBuyResponse createEndsBuyResponse() {
        return new EndsBuyResponse();
    }

    /**
     * Create an instance of {@link RemoveProdutoCarrinhoResponse }
     * 
     */
    public RemoveProdutoCarrinhoResponse createRemoveProdutoCarrinhoResponse() {
        return new RemoveProdutoCarrinhoResponse();
    }

    /**
     * Create an instance of {@link AddProdutoCarrinho }
     * 
     */
    public AddProdutoCarrinho createAddProdutoCarrinho() {
        return new AddProdutoCarrinho();
    }

    /**
     * Create an instance of {@link GetCarrinho }
     * 
     */
    public GetCarrinho createGetCarrinho() {
        return new GetCarrinho();
    }

    /**
     * Create an instance of {@link CleanCarrinho }
     * 
     */
    public CleanCarrinho createCleanCarrinho() {
        return new CleanCarrinho();
    }

    /**
     * Create an instance of {@link EndsBuy }
     * 
     */
    public EndsBuy createEndsBuy() {
        return new EndsBuy();
    }

    /**
     * Create an instance of {@link AddProdutoCarrinhoResponse }
     * 
     */
    public AddProdutoCarrinhoResponse createAddProdutoCarrinhoResponse() {
        return new AddProdutoCarrinhoResponse();
    }

    /**
     * Create an instance of {@link Venda }
     * 
     */
    public Venda createVenda() {
        return new Venda();
    }

    /**
     * Create an instance of {@link Produto }
     * 
     */
    public Produto createProduto() {
        return new Produto();
    }

    /**
     * Create an instance of {@link RemoveProdutoCarrinho }
     * 
     */
    public RemoveProdutoCarrinho createRemoveProdutoCarrinho() {
        return new RemoveProdutoCarrinho();
    }

    /**
     * Create an instance of {@link GetProdutos }
     * 
     */
    public GetProdutos createGetProdutos() {
        return new GetProdutos();
    }

    /**
     * Create an instance of {@link GetCarrinhoResponse }
     * 
     */
    public GetCarrinhoResponse createGetCarrinhoResponse() {
        return new GetCarrinhoResponse();
    }

    /**
     * Create an instance of {@link CleanCarrinhoResponse }
     * 
     */
    public CleanCarrinhoResponse createCleanCarrinhoResponse() {
        return new CleanCarrinhoResponse();
    }

    /**
     * Create an instance of {@link ItemVenda }
     * 
     */
    public ItemVenda createItemVenda() {
        return new ItemVenda();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CleanCarrinhoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "cleanCarrinhoResponse")
    public JAXBElement<CleanCarrinhoResponse> createCleanCarrinhoResponse(CleanCarrinhoResponse value) {
        return new JAXBElement<CleanCarrinhoResponse>(_CleanCarrinhoResponse_QNAME, CleanCarrinhoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Venda }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "venda")
    public JAXBElement<Venda> createVenda(Venda value) {
        return new JAXBElement<Venda>(_Venda_QNAME, Venda.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProdutos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "getProdutos")
    public JAXBElement<GetProdutos> createGetProdutos(GetProdutos value) {
        return new JAXBElement<GetProdutos>(_GetProdutos_QNAME, GetProdutos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarrinhoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "getCarrinhoResponse")
    public JAXBElement<GetCarrinhoResponse> createGetCarrinhoResponse(GetCarrinhoResponse value) {
        return new JAXBElement<GetCarrinhoResponse>(_GetCarrinhoResponse_QNAME, GetCarrinhoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Produto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "produto")
    public JAXBElement<Produto> createProduto(Produto value) {
        return new JAXBElement<Produto>(_Produto_QNAME, Produto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProdutoCarrinho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "removeProdutoCarrinho")
    public JAXBElement<RemoveProdutoCarrinho> createRemoveProdutoCarrinho(RemoveProdutoCarrinho value) {
        return new JAXBElement<RemoveProdutoCarrinho>(_RemoveProdutoCarrinho_QNAME, RemoveProdutoCarrinho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarrinho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "getCarrinho")
    public JAXBElement<GetCarrinho> createGetCarrinho(GetCarrinho value) {
        return new JAXBElement<GetCarrinho>(_GetCarrinho_QNAME, GetCarrinho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProdutoCarrinho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "addProdutoCarrinho")
    public JAXBElement<AddProdutoCarrinho> createAddProdutoCarrinho(AddProdutoCarrinho value) {
        return new JAXBElement<AddProdutoCarrinho>(_AddProdutoCarrinho_QNAME, AddProdutoCarrinho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EndsBuy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "endsBuy")
    public JAXBElement<EndsBuy> createEndsBuy(EndsBuy value) {
        return new JAXBElement<EndsBuy>(_EndsBuy_QNAME, EndsBuy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProdutoCarrinhoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "addProdutoCarrinhoResponse")
    public JAXBElement<AddProdutoCarrinhoResponse> createAddProdutoCarrinhoResponse(AddProdutoCarrinhoResponse value) {
        return new JAXBElement<AddProdutoCarrinhoResponse>(_AddProdutoCarrinhoResponse_QNAME, AddProdutoCarrinhoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CleanCarrinho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "cleanCarrinho")
    public JAXBElement<CleanCarrinho> createCleanCarrinho(CleanCarrinho value) {
        return new JAXBElement<CleanCarrinho>(_CleanCarrinho_QNAME, CleanCarrinho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProdutosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "getProdutosResponse")
    public JAXBElement<GetProdutosResponse> createGetProdutosResponse(GetProdutosResponse value) {
        return new JAXBElement<GetProdutosResponse>(_GetProdutosResponse_QNAME, GetProdutosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EndsBuyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "endsBuyResponse")
    public JAXBElement<EndsBuyResponse> createEndsBuyResponse(EndsBuyResponse value) {
        return new JAXBElement<EndsBuyResponse>(_EndsBuyResponse_QNAME, EndsBuyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProdutoCarrinhoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.superdia.br/", name = "removeProdutoCarrinhoResponse")
    public JAXBElement<RemoveProdutoCarrinhoResponse> createRemoveProdutoCarrinhoResponse(RemoveProdutoCarrinhoResponse value) {
        return new JAXBElement<RemoveProdutoCarrinhoResponse>(_RemoveProdutoCarrinhoResponse_QNAME, RemoveProdutoCarrinhoResponse.class, null, value);
    }

}
