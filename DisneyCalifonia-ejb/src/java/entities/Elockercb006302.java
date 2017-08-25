/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Umair
 */
@Entity
@Table(name = "ELOCKERCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elockercb006302.findAll", query = "SELECT e FROM Elockercb006302 e"),
    @NamedQuery(name = "Elockercb006302.findByElockerId", query = "SELECT e FROM Elockercb006302 e WHERE e.elockerId = :elockerId"),
    @NamedQuery(name = "Elockercb006302.findByElockerType", query = "SELECT e FROM Elockercb006302 e WHERE e.elockerType = :elockerType"),
    @NamedQuery(name = "Elockercb006302.findByElockerPrice", query = "SELECT e FROM Elockercb006302 e WHERE e.elockerPrice = :elockerPrice")})
public class Elockercb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ELOCKER_ID")
    private String elockerId;
    @Size(max = 100)
    @Column(name = "ELOCKER_TYPE")
    private String elockerType;
    @Column(name = "ELOCKER_PRICE")
    private Integer elockerPrice;
    @JoinColumn(name = "WRIST_ID", referencedColumnName = "WRIST_ID")
    @ManyToOne(optional = false)
    private Wristbandcb006302 wristId;

    public Elockercb006302() {
    }

    public Elockercb006302(String elockerId) {
        this.elockerId = elockerId;
    }

    public String getElockerId() {
        return elockerId;
    }

    public void setElockerId(String elockerId) {
        this.elockerId = elockerId;
    }

    public String getElockerType() {
        return elockerType;
    }

    public void setElockerType(String elockerType) {
        this.elockerType = elockerType;
    }

    public Integer getElockerPrice() {
        return elockerPrice;
    }

    public void setElockerPrice(Integer elockerPrice) {
        this.elockerPrice = elockerPrice;
    }

    public Wristbandcb006302 getWristId() {
        return wristId;
    }

    public void setWristId(Wristbandcb006302 wristId) {
        this.wristId = wristId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elockerId != null ? elockerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elockercb006302)) {
            return false;
        }
        Elockercb006302 other = (Elockercb006302) object;
        if ((this.elockerId == null && other.elockerId != null) || (this.elockerId != null && !this.elockerId.equals(other.elockerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Elockercb006302[ elockerId=" + elockerId + " ]";
    }
    
}
