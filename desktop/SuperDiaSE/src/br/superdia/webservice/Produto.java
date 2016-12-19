
package br.superdia.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for produto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="produto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estoqueMinimo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preco" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="quantidadeEstoque" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vendidoPor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produto", propOrder = {
    "descricao",
    "estoqueMinimo",
    "id",
    "nome",
    "preco",
    "quantidadeEstoque",
    "vendidoPor"
})
public class Produto {

    protected String descricao;
    protected int estoqueMinimo;
    protected Long id;
    protected String nome;
    protected double preco;
    protected int quantidadeEstoque;
    protected String vendidoPor;

    /**
     * Gets the value of the descricao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets the value of the descricao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Gets the value of the estoqueMinimo property.
     * 
     */
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    /**
     * Sets the value of the estoqueMinimo property.
     * 
     */
    public void setEstoqueMinimo(int value) {
        this.estoqueMinimo = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the preco property.
     * 
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Sets the value of the preco property.
     * 
     */
    public void setPreco(double value) {
        this.preco = value;
    }

    /**
     * Gets the value of the quantidadeEstoque property.
     * 
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Sets the value of the quantidadeEstoque property.
     * 
     */
    public void setQuantidadeEstoque(int value) {
        this.quantidadeEstoque = value;
    }

    /**
     * Gets the value of the vendidoPor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendidoPor() {
        return vendidoPor;
    }

    /**
     * Sets the value of the vendidoPor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendidoPor(String value) {
        this.vendidoPor = value;
    }

}
