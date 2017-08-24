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
@Table(name = "TICKETCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticketcb006302.findAll", query = "SELECT t FROM Ticketcb006302 t"),
    @NamedQuery(name = "Ticketcb006302.findByTicketId", query = "SELECT t FROM Ticketcb006302 t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Ticketcb006302.findByTicketType", query = "SELECT t FROM Ticketcb006302 t WHERE t.ticketType = :ticketType"),
    @NamedQuery(name = "Ticketcb006302.findByTicketDate", query = "SELECT t FROM Ticketcb006302 t WHERE t.ticketDate = :ticketDate"),
    @NamedQuery(name = "Ticketcb006302.findByTicketPrice", query = "SELECT t FROM Ticketcb006302 t WHERE t.ticketPrice = :ticketPrice"),
    @NamedQuery(name = "Ticketcb006302.findByTicketType2", query = "SELECT t FROM Ticketcb006302 t WHERE t.ticketType2 = :ticketType2")})
public class Ticketcb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TICKET_ID")
    private String ticketId;
    @Size(max = 10)
    @Column(name = "TICKET_TYPE")
    private String ticketType;
    @Size(max = 20)
    @Column(name = "TICKET_DATE")
    private String ticketDate;
    @Column(name = "TICKET_PRICE")
    private Integer ticketPrice;
    @Size(max = 10)
    @Column(name = "TICKET_TYPE2")
    private String ticketType2;
    @JoinColumn(name = "WRIST_ID", referencedColumnName = "WRIST_ID")
    @ManyToOne(optional = false)
    private Wristbandcb006302 wristId;

    public Ticketcb006302() {
    }

    public Ticketcb006302(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketType2() {
        return ticketType2;
    }

    public void setTicketType2(String ticketType2) {
        this.ticketType2 = ticketType2;
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
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticketcb006302)) {
            return false;
        }
        Ticketcb006302 other = (Ticketcb006302) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ticketcb006302[ ticketId=" + ticketId + " ]";
    }
    
}
