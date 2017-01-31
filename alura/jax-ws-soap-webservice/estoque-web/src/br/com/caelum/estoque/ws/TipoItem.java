
package br.com.caelum.estoque.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoItem.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoItem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Livro"/>
 *     &lt;enumeration value="Celular"/>
 *     &lt;enumeration value="Tablet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoItem")
@XmlEnum
public enum TipoItem {

    @XmlEnumValue("Livro")
    LIVRO("Livro"),
    @XmlEnumValue("Celular")
    CELULAR("Celular"),
    @XmlEnumValue("Tablet")
    TABLET("Tablet");
    private final String value;

    TipoItem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoItem fromValue(String v) {
        for (TipoItem c: TipoItem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
