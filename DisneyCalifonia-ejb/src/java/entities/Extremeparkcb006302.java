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
@Table(name = "EXTREMEPARKCB006302")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extremeparkcb006302.findAll", query = "SELECT e FROM Extremeparkcb006302 e"),
    @NamedQuery(name = "Extremeparkcb006302.findByGameId", query = "SELECT e FROM Extremeparkcb006302 e WHERE e.gameId = :gameId"),
    @NamedQuery(name = "Extremeparkcb006302.findByGameType", query = "SELECT e FROM Extremeparkcb006302 e WHERE e.gameType = :gameType"),
    @NamedQuery(name = "Extremeparkcb006302.findByGamePrice", query = "SELECT e FROM Extremeparkcb006302 e WHERE e.gamePrice = :gamePrice")})
public class Extremeparkcb006302 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "GAME_ID")
    private String gameId;
    @Size(max = 100)
    @Column(name = "GAME_TYPE")
    private String gameType;
    @Column(name = "GAME_PRICE")
    private Integer gamePrice;

    public Extremeparkcb006302() {
    }

    public Extremeparkcb006302(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Integer getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(Integer gamePrice) {
        this.gamePrice = gamePrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameId != null ? gameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extremeparkcb006302)) {
            return false;
        }
        Extremeparkcb006302 other = (Extremeparkcb006302) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Extremeparkcb006302[ gameId=" + gameId + " ]";
    }
    
}
