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
@Table(name = "BULLETINBOARDCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bulletinboardcb006302.findAll", query = "SELECT b FROM Bulletinboardcb006302 b"),
    @NamedQuery(name = "Bulletinboardcb006302.findByEventId", query = "SELECT b FROM Bulletinboardcb006302 b WHERE b.eventId = :eventId"),
    @NamedQuery(name = "Bulletinboardcb006302.findByEventTime", query = "SELECT b FROM Bulletinboardcb006302 b WHERE b.eventTime = :eventTime"),
    @NamedQuery(name = "Bulletinboardcb006302.findByEventName", query = "SELECT b FROM Bulletinboardcb006302 b WHERE b.eventName = :eventName")})
public class Bulletinboardcb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "EVENT_ID")
    private String eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EVENT_TIME")
    private String eventTime;
    @Size(max = 100)
    @Column(name = "EVENT_NAME")
    private String eventName;

    public Bulletinboardcb006302() {
    }

    public Bulletinboardcb006302(String eventId) {
        this.eventId = eventId;
    }

    public Bulletinboardcb006302(String eventId, String eventTime) {
        this.eventId = eventId;
        this.eventTime = eventTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bulletinboardcb006302)) {
            return false;
        }
        Bulletinboardcb006302 other = (Bulletinboardcb006302) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bulletinboardcb006302[ eventId=" + eventId + " ]";
    }
    
}
