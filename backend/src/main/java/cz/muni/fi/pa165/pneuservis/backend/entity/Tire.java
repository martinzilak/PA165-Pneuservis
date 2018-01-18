package cz.muni.fi.pa165.pneuservis.backend.entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/***
 * @author Jakub Palenik, 422453@mail.muni.cz
 */
@Entity
public class Tire {
      
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    private String name;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private TireManufacturer manufacturer;
     
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private TireProperties tireProperties; 
    
    @NotNull
    private int onStock;
    
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;
    
    private String imageUrl;
    
    private String description;

    public Tire(){}

    public Tire(String name, TireManufacturer manufacturer, TireProperties tireProperties, int onStock, BigDecimal price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.tireProperties = tireProperties;
        this.onStock = onStock;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setManufacturer(TireManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            
    public TireManufacturer getTireManufacturer() {
        return manufacturer;
    }

    public void setTireManufacturer(TireManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TireProperties getTireProperties() {
        return tireProperties;
    }

    public void setTireProperties(TireProperties tireProperties) {
        this.tireProperties = tireProperties;
        
    }

    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int onStock) {
        this.onStock = onStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage_url() {
        return imageUrl;
    }

    public void setImage_url(String image_url) {
        this.imageUrl = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String decription) {
        this.description = decription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.manufacturer);
        hash = 79 * hash + Objects.hashCode(this.tireProperties);
        hash = 79 * hash + this.onStock;
        hash = 79 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Tire) ) {
            return false;
        }
        final Tire other = (Tire) obj;
        if (this.onStock != other.onStock) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.tireProperties, other.tireProperties)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tire{" + "manufacturer=" + manufacturer + ", tireProperties=" + tireProperties + ", onStock=" + onStock + ", price=" + price + '}';
    }
    
    
    
}
