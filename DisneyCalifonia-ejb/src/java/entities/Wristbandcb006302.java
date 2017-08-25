/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Umair
 */
@Entity
@Table(name = "WRISTBANDCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wristbandcb006302.findAll", query = "SELECT w FROM Wristbandcb006302 w"),
    @NamedQuery(name = "Wristbandcb006302.findByWristId", query = "SELECT w FROM Wristbandcb006302 w WHERE w.wristId = :wristId"),
    @NamedQuery(name = "Wristbandcb006302.findByCreditLimit", query = "SELECT w FROM Wristbandcb006302 w WHERE w.creditLimit = :creditLimit"),
    @NamedQuery(name = "Wristbandcb006302.findByExpence", query = "SELECT w FROM Wristbandcb006302 w WHERE w.expence = :expence")})
public class Wristbandcb006302 implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wristId")
    private Collection<Elockercb006302> elockercb006302Collection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "WRIST_ID")
    private String wristId;
    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;
    @Column(name = "EXPENCE")
    private Integer expence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wristId")
    private Collection<Ticketcb006302> ticketcb006302Collection;

    public Wristbandcb006302() {
    }

    public Wristbandcb006302(String wristId) {
        this.wristId = wristId;
    }

    public String getWristId() {
        return wristId;
    }

    public void setWristId(String wristId) {
        this.wristId = wristId;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getExpence() {
        return expence;
    }

    public void setExpence(Integer expence) {
        this.expence = expence;
    }

    @XmlTransient
    public Collection<Ticketcb006302> getTicketcb006302Collection() {
        return ticketcb006302Collection;
    }

    public void setTicketcb006302Collection(Collection<Ticketcb006302> ticketcb006302Collection) {
        this.ticketcb006302Collection = ticketcb006302Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wristId != null ? wristId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wristbandcb006302)) {
            return false;
        }
        Wristbandcb006302 other = (Wristbandcb006302) object;
        if ((this.wristId == null && other.wristId != null) || (this.wristId != null && !this.wristId.equals(other.wristId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wristbandcb006302[ wristId=" + wristId + " ]";
    }

    @XmlTransient
    public Collection<Elockercb006302> getElockercb006302Collection() {
        return elockercb006302Collection;
    }

    public void setElockercb006302Collection(Collection<Elockercb006302> elockercb006302Collection) {
        this.elockercb006302Collection = elockercb006302Collection;
    }
    
}
