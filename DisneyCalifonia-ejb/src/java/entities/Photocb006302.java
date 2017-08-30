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
@Table(name = "PHOTOCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photocb006302.findAll", query = "SELECT p FROM Photocb006302 p"),
    @NamedQuery(name = "Photocb006302.findByPhotoId", query = "SELECT p FROM Photocb006302 p WHERE p.photoId = :photoId"),
    @NamedQuery(name = "Photocb006302.findByPhotoType", query = "SELECT p FROM Photocb006302 p WHERE p.photoType = :photoType"),
    @NamedQuery(name = "Photocb006302.findByPhotoPrice", query = "SELECT p FROM Photocb006302 p WHERE p.photoPrice = :photoPrice")})
public class Photocb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PHOTO_ID")
    private String photoId;
    @Size(max = 10)
    @Column(name = "PHOTO_TYPE")
    private String photoType;
    @Size(max = 20)
    @Column(name = "PHOTO_PRICE")
    private String photoPrice;
    @JoinColumn(name = "WRIST_ID", referencedColumnName = "WRIST_ID")
    @ManyToOne(optional = false)
    private Wristbandcb006302 wristId;

    public Photocb006302() {
    }

    public Photocb006302(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public String getPhotoPrice() {
        return photoPrice;
    }

    public void setPhotoPrice(String photoPrice) {
        this.photoPrice = photoPrice;
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
        hash += (photoId != null ? photoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photocb006302)) {
            return false;
        }
        Photocb006302 other = (Photocb006302) object;
        if ((this.photoId == null && other.photoId != null) || (this.photoId != null && !this.photoId.equals(other.photoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Photocb006302[ photoId=" + photoId + " ]";
    }
    
}
