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
@Table(name = "ADMIN_PHOTOSCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminPhotoscb006302.findAll", query = "SELECT a FROM AdminPhotoscb006302 a"),
    @NamedQuery(name = "AdminPhotoscb006302.findByPhotoId", query = "SELECT a FROM AdminPhotoscb006302 a WHERE a.photoId = :photoId"),
    @NamedQuery(name = "AdminPhotoscb006302.findByWristId", query = "SELECT a FROM AdminPhotoscb006302 a WHERE a.wristId = :wristId")})
public class AdminPhotoscb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PHOTO_ID")
    private String photoId;
    @Size(max = 6)
    @Column(name = "WRIST_ID")
    private String wristId;

    public AdminPhotoscb006302() {
    }

    public AdminPhotoscb006302(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getWristId() {
        return wristId;
    }

    public void setWristId(String wristId) {
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
        if (!(object instanceof AdminPhotoscb006302)) {
            return false;
        }
        AdminPhotoscb006302 other = (AdminPhotoscb006302) object;
        if ((this.photoId == null && other.photoId != null) || (this.photoId != null && !this.photoId.equals(other.photoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdminPhotoscb006302[ photoId=" + photoId + " ]";
    }
    
}
